package creditcard.domain;

import banking.visitor.Visitor;
import creditcard.constant.CreditCardType;
import shared.Account;

//TODO: NEED TO FIX THIS
public class CreditCardAccount extends Account {
    CreditCardType type;
    public CreditCardAccount( CreditCardType type) {
        super(null);
        this.type = type;
    }

    public double getPrevBalance() {
     return 0.0;
    }

    public double getTotalCredit() {
        return 0.0;
    }

    public double getTotalCharge() {
        return 0.0;
    }

    public double getNewBalance() {
       return 0.0;
    }

    public double getTotalDue() {
        return 0.0;
    }

    @Override
    public double accept(Visitor visitor) {
        return 0;
    }

    @Override
    public String getAccountType() {
        return type.name();
    }
}
