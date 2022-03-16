package shared;

import java.util.Collection;

public interface AccountDAO {
    void createAccount(Account account);

    void updateAccount(Account account);

    Account loadAccount(String accountNumber);

    Collection<Account> getAccounts();
}
