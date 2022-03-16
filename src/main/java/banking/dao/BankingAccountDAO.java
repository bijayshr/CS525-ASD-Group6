package banking.dao;

import lombok.extern.slf4j.Slf4j;
import shared.Account;
import shared.AccountDAO;
import shared.constant.ApplicationMessageConstant;

import java.util.ArrayList;
import java.util.Collection;

@Slf4j
public class BankingAccountDAO implements AccountDAO {
    private static volatile BankingAccountDAO instance;
    Collection<Account> accountlist = new ArrayList<>();

    public static BankingAccountDAO getInstance() {
        if (instance == null) {
            synchronized (BankingAccountDAO.class) {
                if (instance == null) {
                    instance = new BankingAccountDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public void createAccount(Account account) {
        accountlist.add(account);
        log.info(ApplicationMessageConstant.ACCOUNT_CREATED_SUCCESSFULLY,
                account.getAccountNumber(),
                account.getCustomer().getName());
    }

    @Override
    public void updateAccount(Account account) {
        Account isAccountExist = loadAccount(account.getAccountNumber());
        if (isAccountExist != null) {
            accountlist.remove(isAccountExist);
            accountlist.add(account);
        }
        log.info(ApplicationMessageConstant.ACCOUNT_UPDATED_SUCCESSFULLY,
                account.getAccountNumber(),
                account.getCustomer().getName());
    }

    @Override
    public Account loadAccount(String accountNumber) {
        for (Account account : accountlist) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountlist;
    }
}
