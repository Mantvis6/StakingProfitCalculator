package application;

import java.time.LocalDate;

public class InvestmentInformation {

    public double initialInvestment;
    public double yearlyStakingRewardRate;
    public LocalDate stakingStartDate;
    public int stakingDuration;
    public int rewardPaymentDay;
    public String decisionToReinvestStakingReward;
    public String rewardRateWillBeLowered;

    public InvestmentInformation(double initialInvestment, double yearlyStakingRewardRate, LocalDate stakingStartDate, int stakingDuration, int rewardPaymentDay, String decisionToReinvestStakingReward, String rewardRateWillBeLowered) {
        this.initialInvestment = initialInvestment;
        this.yearlyStakingRewardRate = yearlyStakingRewardRate;
        this.stakingStartDate = stakingStartDate;
        this.stakingDuration = stakingDuration;
        this.rewardPaymentDay = rewardPaymentDay;
        this.decisionToReinvestStakingReward = decisionToReinvestStakingReward;
        this.rewardRateWillBeLowered = rewardRateWillBeLowered;
    }

    public InvestmentInformation() {
    }

    public double getInitialInvestment() {
        return initialInvestment;
    }

    public void setInitialInvestment(double initialInvestment) {
        this.initialInvestment = initialInvestment;
    }

    public double getYearlyStakingRewardRate() {
        return yearlyStakingRewardRate;
    }

    public void setYearlyStakingRewardRate(double yearlyStakingRewardRate) {
        this.yearlyStakingRewardRate = yearlyStakingRewardRate;
    }

    public LocalDate getStakingStartDate() {
        return stakingStartDate;
    }

    public void setStakingStartDate(LocalDate stakingStartDate) {
        this.stakingStartDate = stakingStartDate;
    }

    public int getStakingDuration() {
        return stakingDuration;
    }

    public void setStakingDuration(int stakingDuration) {
        this.stakingDuration = stakingDuration;
    }

    public int getRewardPaymentDay() {
        return rewardPaymentDay;
    }

    public void setRewardPaymentDay(int rewardPaymentDay) {
        this.rewardPaymentDay = rewardPaymentDay;
    }

    public String getDecisionToReinvestStakingReward() {
        return decisionToReinvestStakingReward;
    }

    public void setDecisionToReinvestStakingReward(String decisionToReinvestStakingReward) {
        this.decisionToReinvestStakingReward = decisionToReinvestStakingReward;
    }

    public String getRewardRateWillBeLowered() { return rewardRateWillBeLowered;
    }

    public void setRewardRateWillBeLowered(String rewardRateWillBeLowered) {
        this.rewardRateWillBeLowered = rewardRateWillBeLowered;
    }

    @Override
    public String toString() {
        return "InvestmentInformation{" +
                "initialInvestment=" + initialInvestment +
                ", yearlyStakingRewardRate=" + yearlyStakingRewardRate +
                ", stakingStartDate=" + stakingStartDate +
                ", stakingDuration=" + stakingDuration +
                ", rewardPaymentDay=" + rewardPaymentDay +
                ", decisionToReinvestStakingReward='" + decisionToReinvestStakingReward + '\'' +
                ", rewardRateWillBeLowered='" + rewardRateWillBeLowered + '\'' +
                '}';
    }
}
