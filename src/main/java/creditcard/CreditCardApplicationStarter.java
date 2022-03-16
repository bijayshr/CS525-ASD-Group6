package creditcard;

import creditcard.commands.AddCompanyAccountCommand;
import creditcard.commands.AddPersonalAccountCommand;
import framework.ui.UIControl;
import framework.ui.UIFrame;

import javax.swing.*;

public class CreditCardApplicationStarter {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIControl mainForm = UIFrame.getInstance();
            mainForm.init("MIU CreditCard Application", new CreditCardUIConfig());

            //commands
            mainForm.setAddPersonalAccountCommand(new AddPersonalAccountCommand());
            mainForm.setAddCompanyAccountCommand(new AddCompanyAccountCommand());
            //Create a new instance of our application's frame, and make it visible.
            mainForm.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
