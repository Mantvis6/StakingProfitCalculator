package application;

import com.opencsv.CSVWriter;

import java.io.*;
import java.math.RoundingMode;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import static java.time.temporal.ChronoUnit.DAYS;

public class ProfitCalculator {

    public static void calculating(InvestmentInformation client) throws IOException {

        List<GeneratedProfitInformation> clientProfitSchedule = new ArrayList<>();
        DecimalFormat roundedNumbersFormat = new DecimalFormat("#.######");
        roundedNumbersFormat.setRoundingMode(RoundingMode.UP);
        clientProfitSchedule.add(new GeneratedProfitInformation(
                        1,
                        (java.time.LocalDate.of(client.getStakingStartDate().getYear(), client.getStakingStartDate().getMonth(), client.getRewardPaymentDay())),
                        client.getInitialInvestment(),
                        client.getInitialInvestment() * (client.getYearlyStakingRewardRate() / 100 / 365 * DAYS.between(client.getStakingStartDate(), ((java.time.LocalDate.of(client.getStakingStartDate().getYear(), client.getStakingStartDate().getMonth(), client.getRewardPaymentDay()))))),
                        client.getInitialInvestment() * (client.getYearlyStakingRewardRate() / 100 / 365 * DAYS.between(client.getStakingStartDate(), ((java.time.LocalDate.of(client.getStakingStartDate().getYear(), client.getStakingStartDate().getMonth(), client.getRewardPaymentDay()))))),
                        client.getYearlyStakingRewardRate()));

        if (client.getDecisionToReinvestStakingReward().equals("yes")) {
            for (int i = 1; i <= client.getStakingDuration(); i++) {
                clientProfitSchedule.add(new GeneratedProfitInformation(
                                clientProfitSchedule.get(0).getLine() + i,
                                clientProfitSchedule.get(0).getDateOfReceivingReward().plusMonths(i),
                                clientProfitSchedule.get(i - 1).getInvestmentAmountAtTheTime() + clientProfitSchedule.get(i - 1).getRewardAmountForMonth(),
                                ((clientProfitSchedule.get(i - 1).getInvestmentAmountAtTheTime() + clientProfitSchedule.get(i - 1).getRewardAmountForMonth()) * (client.getYearlyStakingRewardRate() / 100 / 365 * DAYS.between(clientProfitSchedule.get(i - 1).getDateOfReceivingReward(), clientProfitSchedule.get(i - 1).getDateOfReceivingReward().plusMonths(1)))),
                                ((clientProfitSchedule.get(i - 1).getInvestmentAmountAtTheTime() + clientProfitSchedule.get(i - 1).getTotalRewardSoFar()) * (client.getYearlyStakingRewardRate() / 100 / 365 * DAYS.between(clientProfitSchedule.get(i - 1).getDateOfReceivingReward(), clientProfitSchedule.get(i - 1).getDateOfReceivingReward().plusMonths(1)))) + clientProfitSchedule.get(i - 1).getTotalRewardSoFar(),
                                client.getYearlyStakingRewardRate()));

                if (client.getRewardRateWillBeLowered().equals("yes") && clientProfitSchedule.get(i).getDateOfReceivingReward().isAfter(client.getStakingStartDate().plusYears(1)) ) {
                    client.setYearlyStakingRewardRate(8);
                }
            }
            savingInformation(client, clientProfitSchedule);
        }
        else{
            for (int i = 1; i <= client.getStakingDuration(); i++) {
                clientProfitSchedule.add(new GeneratedProfitInformation(
                                clientProfitSchedule.get(0).getLine() + i,
                                clientProfitSchedule.get(0).getDateOfReceivingReward().plusMonths(i),
                                client.getInitialInvestment(),
                                (client.getInitialInvestment() * (client.getYearlyStakingRewardRate() / 100 / 365 * DAYS.between(clientProfitSchedule.get(i - 1).getDateOfReceivingReward(), clientProfitSchedule.get(i - 1).getDateOfReceivingReward().plusMonths(1)))),
                                (client.getInitialInvestment() * (client.getYearlyStakingRewardRate() / 100 / 365 * DAYS.between(clientProfitSchedule.get(i - 1).getDateOfReceivingReward(), clientProfitSchedule.get(i - 1).getDateOfReceivingReward().plusMonths(1)))) + clientProfitSchedule.get(i - 1).getTotalRewardSoFar(),
                                clientProfitSchedule.get(0).getYearlyStakingRewardRate()));

                if (client.getRewardRateWillBeLowered().equals("yes") && clientProfitSchedule.get(i).getDateOfReceivingReward().isAfter(client.getStakingStartDate().plusYears(1)) ) {
                    client.setYearlyStakingRewardRate(8);
                }
            }
        }
        savingInformation(client, clientProfitSchedule);
    }

    public static void savingInformation(InvestmentInformation client, List<GeneratedProfitInformation> clientProfitSchedule) throws IOException {

        DecimalFormat roundedNumbersFormat = new DecimalFormat("0.000000");
        roundedNumbersFormat.setRoundingMode(RoundingMode.UP);

        File clientInformationInCsv = new File("src\\main\\resources\\clientProfitScheduleInCsv.csv");
        CSVWriter writer = new CSVWriter(
                new OutputStreamWriter(new FileOutputStream(clientInformationInCsv), StandardCharsets.UTF_8),
                ';',
                CSVWriter.DEFAULT_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        String[] csvHeader = {"Initial Investment: ", "Yearly Staking Reward: ", "Start Date: ", "End Date: ", "Reward Payment Day: ", "Reinvest Staking Reward: "};
        writer.writeNext(csvHeader);
        String[] clientInformation = {roundedNumbersFormat.format(client.getInitialInvestment()), (client.getYearlyStakingRewardRate()+"0%"), String.valueOf(client.getStakingStartDate()), String.valueOf(client.getStakingStartDate().plusMonths(client.getStakingDuration())), String.valueOf(client.getRewardPaymentDay()), client.getDecisionToReinvestStakingReward()};
        writer.writeNext(clientInformation);
        String[] secondCsvHeader = {"Line #", "Reward Date", "Investment Amount", "Reward Amount", "Total Reward Amount To Date", "Staking Reward Rate"};
        writer.writeNext(secondCsvHeader);
        for (GeneratedProfitInformation generatedProfitInformation : clientProfitSchedule) {
            String[] clientProfitScheduleAsString = {String.valueOf(generatedProfitInformation.getLine()), String.valueOf(generatedProfitInformation.getDateOfReceivingReward()), roundedNumbersFormat.format(generatedProfitInformation.getInvestmentAmountAtTheTime()), roundedNumbersFormat.format(generatedProfitInformation.getRewardAmountForMonth()), roundedNumbersFormat.format(generatedProfitInformation.getTotalRewardSoFar()), (generatedProfitInformation.getYearlyStakingRewardRate()) + "0%"};
            writer.writeNext(clientProfitScheduleAsString);
        }
        writer.close();
    }
}
