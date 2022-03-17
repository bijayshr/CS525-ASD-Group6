package edu.miu.cs525.creditcard.commands;

import edu.miu.cs525.creditcard.service.CreditCardAccountServiceImpl;
import edu.miu.cs525.framework.Command;
import edu.miu.cs525.framework.ui.UIControl;

public class AddInterestCommand implements Command {
    @Override
    public void execute(UIControl control) {
        CreditCardAccountServiceImpl.getInstance().addInterest();
    }
}
