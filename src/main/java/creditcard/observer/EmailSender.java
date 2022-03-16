package creditcard.observer;

import shared.AccountService;
import framework.Observer;

public class EmailSender implements Observer {
    private final AccountService accountService;

    public EmailSender(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void update() {

    }
}
