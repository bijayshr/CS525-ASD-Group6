package banking.service;

import banking.constant.BankingAccountType;
import banking.domain.CheckingAccount;
import banking.domain.SavingsAccount;
import banking.dao.BankingAccountDAO;
import banking.strategy.CompanyCheckingAccountComputation;
import banking.strategy.CompanySavingsAccountComputation;
import banking.strategy.PersonCheckingAccountComputation;
import banking.strategy.PersonSavingsAccountInterestComputation;
import shared.Account;
import shared.AccountService;
import shared.Customer;
import creditcard.observer.EmailSender;
import framework.domain.CompanyAccount;
import framework.domain.PersonalAccount;

public class BankingAccountService extends AccountService {
    private static volatile BankingAccountService instance;

    private BankingAccountService() {
        super(BankingAccountDAO.getInstance());
        this.registerObserver(new EmailSender(this));
    }

    public static BankingAccountService getInstance() {
        if (instance == null) {
            synchronized (BankingAccountService.class) {
                if (instance == null) {
                    instance = new BankingAccountService();
                }
            }
        }

        return instance;
    }


    @Override
    public Account createAccountFactory(String accountType, Customer customer) {
        if (customer instanceof PersonalAccount) {
            if (BankingAccountType.valueOf(accountType) == BankingAccountType.CHECKING) {
                return new CheckingAccount(new PersonCheckingAccountComputation());
            }
            return new SavingsAccount(new PersonSavingsAccountInterestComputation());
        } else if(customer instanceof CompanyAccount) {
            if (BankingAccountType.valueOf(accountType) == BankingAccountType.CHECKING) {
                return new CheckingAccount(new CompanyCheckingAccountComputation());
            }
            return new SavingsAccount(new CompanySavingsAccountComputation());
        }
        return null;
    }

}
