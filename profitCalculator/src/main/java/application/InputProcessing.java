package application;

import java.time.LocalDate;
import java.util.Scanner;

public class InputProcessing {

    public static Scanner getInputs(){
        return new Scanner(System.in);
    }

    public static InvestmentInformation getInformation(){
        InvestmentInformation client = new InvestmentInformation();

        System.out.println("Initial investment : ");
        client.setInitialInvestment(getInputs().nextDouble());
        System.out.println("Staking reward rate : ");
        client.setYearlyStakingRewardRate(getInputs().nextInt());
        System.out.println("Start Date : ");
        client.setStakingStartDate(LocalDate.parse(getInputs().nextLine()));
        System.out.println("Duration of investment (months) : ");
        client.setStakingDuration(getInputs().nextInt());
        System.out.println("Which day monthly reward will be payed (day of month) : ");
        client.setRewardPaymentDay(getInputs().nextInt());
        System.out.println("Do you want to reinvest reward, yes/no : ");
        client.setDecisionToReinvestStakingReward(getInputs().nextLine());
        System.out.println("Will the rates be lowered at 2020-04-15 ? (yes/no) : ");
        client.setRewardRateWillBeLowered(getInputs().nextLine());
        return client;
    }
}
