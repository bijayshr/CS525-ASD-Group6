package banking.strategy;

import shared.InterestComputationStrategy;

public class PersonSavingsAccountInterestComputation implements InterestComputationStrategy {

    @Override
    public double computeInterest(double accountBalance) {
        return (accountBalance < 1000) ? accountBalance * .025 : accountBalance * .050;
    }
}
