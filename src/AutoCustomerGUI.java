import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AutoCustomerGUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("AutomobileSales");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Layout Setup
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel customerTypeLabel = new JLabel("Customer Type:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(customerTypeLabel, gbc);

        String[] customerTypes = {"select", "employee", "manager"};
        JComboBox<String> customerTypeCombo = new JComboBox<>(customerTypes);
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(customerTypeCombo, gbc);

        JLabel customerNameLabel = new JLabel("Customer Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(customerNameLabel, gbc);

        JTextField customerNameField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(customerNameField, gbc);

        JLabel amountLabel = new JLabel("Amount:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(amountLabel, gbc);

        JTextField amountField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(amountField, gbc);

        JButton submitButton = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(submitButton, gbc);

        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(scrollPane, gbc);

        frame.add(panel);
        frame.setVisible(true);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerType = (String) customerTypeCombo.getSelectedItem();
                String customerName = customerNameField.getText().trim();
                String amountText = amountField.getText().trim();

                if ("select".equalsIgnoreCase(customerType) || customerName.isEmpty() || amountText.isEmpty()) {
                    outputArea.append("Invalid input. Please fill all fields correctly.\n");
                } else {
                    try {
                        double amount = Double.parseDouble(amountText);
                        AutoCustomer customer = new AutoCustomer(customerType, customerName, amount);
                        outputArea.append(customer.toString() + "\n");
                    } catch (NumberFormatException ex) {
                        outputArea.append("Amount must be a valid number.\n");
                    }
                }
            }
        });
    }

    public void createAndShowGUI() {
    }
}
