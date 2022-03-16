package shared;

import banking.visitor.Visitor;
import framework.AccountOperationConstant;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public abstract class Account {
	private Customer customer;

	private String accountNumber;

	private final List<AccountEntry> accountEntries;

	private final InterestComputationStrategy interestComputationStrategy;

	public Account(InterestComputationStrategy interestComputationStrategy) {
		this.interestComputationStrategy = interestComputationStrategy;
		this.accountEntries = new ArrayList<>();
	}

	public double getBalance() {
		double balance = 0;
		for (AccountEntry entry : accountEntries) {
			balance += entry.getAmount();
		}
		return balance;
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(
				amount,
				new Date(),
				AccountOperationConstant.DEPOSITED.name(),
				"",
				""
		);
		accountEntries.add(entry);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(
				amount,
				new Date(),
				AccountOperationConstant.WITHDRAW.name(),
				"",
				""
		);
		accountEntries.add(entry);
	}

	public void addInterest(){
		double interest =  interestComputationStrategy.computeInterest(getBalance());
		AccountEntry entry = new AccountEntry(
				interest,
				new Date(),
				AccountOperationConstant.INTEREST.name(),
				"",
				""
		);
		accountEntries.add(entry);
	}

	private void addEntry(AccountEntry entry) {
		accountEntries.add(entry);
	}

	public void transferFunds(Account toAccount, double amount, String description) {
		AccountEntry fromAccountEntry = new AccountEntry(
				-amount,
				new Date(),
				description,
				toAccount.getAccountNumber(),
				toAccount.getCustomer().getName()
		);

		AccountEntry toAccountEntry = new AccountEntry(
				amount,
				new Date(),
				description,
				toAccount.getAccountNumber(),
				toAccount.getCustomer().getName()
		);
		accountEntries.add(fromAccountEntry);
		toAccount.addEntry(toAccountEntry);
	}

	public abstract double accept(Visitor visitor);

	public abstract String getAccountType();

}
