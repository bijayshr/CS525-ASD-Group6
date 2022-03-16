package banking.commands;

import banking.service.BankingAccountService;
import framework.Command;
import framework.ui.UIControl;

public class AddCompanyAccountCommand implements Command {
    public void execute(UIControl control) {
        BankingAccountService.getInstance()
                .createAccount(
                        control.getAccountNumber(),
                        control.getCustomer(),
                        control.getAccountType());
    }
}
