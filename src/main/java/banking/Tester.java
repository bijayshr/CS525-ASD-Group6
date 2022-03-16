package banking;

import banking.service.BankingAccountService;
import shared.Account;
import shared.AccountEntry;
import shared.AccountService;
import shared.Customer;

public class Tester {
    public static void main(String[] args) {
        AccountService accountService =  BankingAccountService.getInstance();

        Customer renuka = new Customer(1,"Renuka Mohanraj", "1000N Fourth Street",
                "Fairfield", "Iowa", 52557, "renuka@miu.edu");
        Customer sabi = new Customer(1,"Sabi Shresthaq", "147 Hillcrest Avenue",
                "West Hartford", "Connecticut", 06110, "care.sabi@gmail.com");
        // create 2 accounts;
        accountService.createAccount("1263862",renuka, "Savings");
        accountService.createAccount("4253892", sabi, "Checking");
        // use account 1;
        accountService.deposit("1263862", 240);
        accountService.deposit("1263862", 529);
        accountService.withdraw("1263862", 230);
        // use account 2;
        accountService.deposit("4253892", 12450);
        accountService.transferFunds("4253892", "1263862", 100, "payment of invoice 10232");
        // show balances

        for (Account account : accountService.getAllAccounts()) {
            Customer customer = account.getCustomer();
            System.out.println("Statement for Account: " + account.getAccountNumber());
            System.out.println("Account Holder: " + customer.getName());

            System.out.println("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");

            for (AccountEntry entry : account.getAccountEntries()) {
                System.out.printf("%30s%30s%20.2f\n",
                        entry.getDate().toString(),
                        entry.getDescription(),
                        entry.getAmount());
            }

            System.out.println("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }
    }

}
