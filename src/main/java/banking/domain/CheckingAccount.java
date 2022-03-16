package banking.domain;

import banking.constant.BankingAccountType;
import banking.visitor.Visitor;
import shared.Account;
import shared.InterestComputationStrategy;

public class CheckingAccount extends Account {
    public CheckingAccount(InterestComputationStrategy interestComputationStrategy) {
        super(interestComputationStrategy);
    }

    @Override
    public double accept(Visitor visitor) {
        return 0;
    }

    @Override
    public String getAccountType() {
        return BankingAccountType.CHECKING.name();
    }
}
