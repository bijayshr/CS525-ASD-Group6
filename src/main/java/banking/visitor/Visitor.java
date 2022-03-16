package banking.visitor;

import banking.domain.CheckingAccount;
import banking.domain.SavingsAccount;

public interface Visitor {

    double visit(SavingsAccount savingsAccount);

    double visit(CheckingAccount checkingAccounts);

}
