package banking.commands;

import framework.Command;
import framework.ui.UIControl;

public class NoCommand implements Command {
    public void execute(UIControl uiControl) { }
    public void undo() { }
}
