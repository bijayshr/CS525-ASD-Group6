package edu.miu.cs525.banking.domain;

import edu.miu.cs525.banking.constant.BankingAccountType;
import edu.miu.cs525.banking.visitor.Visitor;
import edu.miu.cs525.framework.InterestComputationStrategy;
import edu.miu.cs525.shared.Account;

public class CheckingAccount extends Account {

    public CheckingAccount(InterestComputationStrategy interestComputationStrategy) {
        super(interestComputationStrategy);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String getAccountType() {
        return BankingAccountType.CHECKING.name();
    }
}
