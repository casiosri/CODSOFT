import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;

class BankAccount { private double balance;

public BankAccount(double initialBalance) {
    this.balance = initialBalance;
}

public double getBalance() {
    return balance;
}

public boolean deposit(double amount) {
    if (amount > 0) {
        balance += amount;
        return true;
    }
    return false;
}

public boolean withdraw(double amount) {
    if (amount > 0 && amount <= balance) {
        balance -= amount;
        return true;
    }
    return false;
}

}

class ATM { private BankAccount account;

public ATM(BankAccount account) {
    this.account = account;
}

public String deposit(double amount) {
    if (account.deposit(amount)) {
        return "Deposit successful. New balance: Rs. " + account.getBalance();
    }
    return "Invalid deposit amount.";
}

public String withdraw(double amount) {
    if (account.withdraw(amount)) {
        return "Withdrawal successful. New balance: Rs. " + account.getBalance();
    }
    return "Invalid amount or insufficient balance.";
}

public String checkBalance() {
    return "Current Balance: Rs. " + account.getBalance();
}

}

public class ATMInterfaceGUI { public static void main(String[] args) { SwingUtilities.invokeLater(ATMInterfaceGUI::createAndShowGUI); }

public static void createAndShowGUI() {
    BankAccount userAccount = new BankAccount(1000);
    ATM atm = new ATM(userAccount);

    JFrame frame = new JFrame("ATM Interface");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(400, 300);

    JLabel label = new JLabel("Enter amount:");
    JTextField textField = new JTextField(10);
    JButton depositBtn = new JButton("Deposit");
    JButton withdrawBtn = new JButton("Withdraw");
    JButton balanceBtn = new JButton("Check Balance");
    JLabel resultLabel = new JLabel("Welcome to ATM");

    JPanel panel = new JPanel();
    panel.setLayout(new GridLayout(6, 1, 10, 10));
    panel.add(label);
    panel.add(textField);
    panel.add(depositBtn);
    panel.add(withdrawBtn);
    panel.add(balanceBtn);
    panel.add(resultLabel);

    depositBtn.addActionListener(e -> {
        try {
            double amount = Double.parseDouble(textField.getText());
            String result = atm.deposit(amount);
            resultLabel.setText(result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    });

    withdrawBtn.addActionListener(e -> {
        try {
            double amount = Double.parseDouble(textField.getText());
            String result = atm.withdraw(amount);
            resultLabel.setText(result);
        } catch (NumberFormatException ex) {
            resultLabel.setText("Please enter a valid number.");
        }
    });

    balanceBtn.addActionListener(e -> {
        resultLabel.setText(atm.checkBalance());
    });

    frame.getContentPane().add(panel);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
}

}
