package banking.domain;

import banking.constant.BankingAccountType;
import banking.visitor.Visitable;
import banking.visitor.Visitor;
import shared.Account;
import shared.InterestComputationStrategy;

public class SavingsAccount extends Account implements Visitable {
    public SavingsAccount(InterestComputationStrategy interestComputationStrategy) {
        super(interestComputationStrategy);
    }
    @Override
    public String getAccountType() {
        return BankingAccountType.SAVINGS.name();
    }
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }


}
