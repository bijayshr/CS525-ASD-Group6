package banking;

import banking.commands.AddCompanyAccountCommand;
import banking.commands.AddPersonalAccountCommand;
import framework.ui.UIControl;
import framework.ui.UIFrame;

import javax.swing.*;

public class BankingApplicationStarter {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIControl mainForm = UIFrame.getInstance();
            mainForm.init("MIU Banking Application", new BankingUIConfig());

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
