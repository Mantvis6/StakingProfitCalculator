package application;

import java.time.LocalDate;

public class GeneratedProfitInformation {
    public int line;
    public LocalDate dateOfReceivingReward;
    public double investmentAmountAtTheTime;
    public double rewardAmountForMonth;
    public double totalRewardSoFar;
    public double yearlyStakingRewardRate;

    public GeneratedProfitInformation() {
    }

    public GeneratedProfitInformation(int line, LocalDate dateOfReceivingReward, double investmentAmountAtTheTime, double rewardAmountForMonth, double totalRewardSoFar, double yearlyStakingRewardRate) {
        this.line = line;
        this.dateOfReceivingReward = dateOfReceivingReward;
        this.investmentAmountAtTheTime = investmentAmountAtTheTime;
        this.rewardAmountForMonth = rewardAmountForMonth;
        this.totalRewardSoFar = totalRewardSoFar;
        this.yearlyStakingRewardRate = yearlyStakingRewardRate;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public LocalDate getDateOfReceivingReward() {
        return dateOfReceivingReward;
    }

    public void setDateOfReceivingReward(LocalDate dateOfReceivingReward) {
        this.dateOfReceivingReward = dateOfReceivingReward;
    }

    public double getInvestmentAmountAtTheTime() {
        return investmentAmountAtTheTime;
    }

    public void setInvestmentAmountAtTheTime(double investmentAmountAtTheTime) {
        this.investmentAmountAtTheTime = investmentAmountAtTheTime;
    }

    public double getRewardAmountForMonth() {
        return rewardAmountForMonth;
    }

    public void setRewardAmountForMonth(double rewardAmountForMonth) {
        this.rewardAmountForMonth = rewardAmountForMonth;
    }

    public double getTotalRewardSoFar() {
        return totalRewardSoFar;
    }

    public void setTotalRewardSoFar(double totalRewardSoFar) {
        this.totalRewardSoFar = totalRewardSoFar;
    }

    public double getYearlyStakingRewardRate() {
        return yearlyStakingRewardRate;
    }

    public void setYearlyStakingRewardRate(double yearlyStakingRewardRate) {
        this.yearlyStakingRewardRate = yearlyStakingRewardRate;
    }

    @Override
    public String toString() {
        return "GeneratedProfitInformation{" +
                "line=" + line +
                ", dateOfReceivingReward=" + dateOfReceivingReward +
                ", investmentAmountAtTheTime=" + investmentAmountAtTheTime +
                ", rewardAmountForMonth=" + rewardAmountForMonth +
                ", totalRewardSoFar=" + totalRewardSoFar +
                ", yearlyStakingRewardRate=" + yearlyStakingRewardRate +
                '}';
    }
}
