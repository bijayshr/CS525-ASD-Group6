package creditcard.service;

import shared.Account;
import shared.AccountService;
import shared.Customer;
import creditcard.domain.CreditCardAccount;
import creditcard.constant.CreditCardType;
import creditcard.dao.CreditCardAccountDAO;
import creditcard.observer.EmailSender;

public class CreditCardAccountService extends AccountService {
    private static volatile  CreditCardAccountService instance;

    private CreditCardAccountService() {
        super(new CreditCardAccountDAO());
        this.registerObserver(new EmailSender(this));
    }

    public static CreditCardAccountService getInstance() {
        if (instance == null) {
            synchronized (CreditCardAccountService.class) {
                if (instance == null) {
                    instance = new CreditCardAccountService();
                }
            }
        }
        return instance;
    }
    @Override
    public Account createAccountFactory(String accountType, Customer customer) {
        CreditCardType type = CreditCardType.valueOf(accountType);
        if(type.equals(CreditCardType.BRONZE)){
            return new CreditCardAccount(type);
        }
        if(type.equals(CreditCardType.SILVER)){
            return new CreditCardAccount(type);
        }
        if(type.equals(CreditCardType.GOLD)){
            return new CreditCardAccount( type);
        }
        throw new UnsupportedOperationException("Invalid Credit Card Type!");
    }

}
