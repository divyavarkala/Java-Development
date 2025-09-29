import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class InventoryApp {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JTextField nameField, priceField, quantityField, barcodeField;
    private JLabel totalStockLabel;

    public InventoryApp() {
        frame = new JFrame("Inventory Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 400);
        frame.setLayout(new BorderLayout());

        // Table setup
        model = new DefaultTableModel(new String[]{"Barcode", "Name", "Price", "Quantity"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 5, 5, 5));
        barcodeField = new JTextField();
        nameField = new JTextField();
        priceField = new JTextField();
        quantityField = new JTextField();

        inputPanel.add(new JLabel("Barcode:"));
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(new JLabel("Price:"));
        inputPanel.add(new JLabel("Quantity:"));
        inputPanel.add(new JLabel("")); // Placeholder

        inputPanel.add(barcodeField);
        inputPanel.add(nameField);
        inputPanel.add(priceField);
        inputPanel.add(quantityField);

        JButton addButton = new JButton("Add Product");
        JButton updateButton = new JButton("Update Product");
        JButton deleteButton = new JButton("Delete Product");
        JButton totalButton = new JButton("Total Stock Value");

        inputPanel.add(addButton);
        inputPanel.add(updateButton);
        inputPanel.add(deleteButton);
        inputPanel.add(totalButton);

        totalStockLabel = new JLabel("Total Stock Value: 0.0");
        inputPanel.add(totalStockLabel);

        frame.add(inputPanel, BorderLayout.SOUTH);

        // Button actions
        addButton.addActionListener(e -> addProduct());
        updateButton.addActionListener(e -> updateProduct());
        deleteButton.addActionListener(e -> deleteProduct());
        totalButton.addActionListener(e -> calculateTotalStock());

        // Fill input fields when row is selected
        table.getSelectionModel().addListSelectionListener(event -> {
            int selectedRow = table.getSelectedRow();
            if (selectedRow >= 0) {
                barcodeField.setText(model.getValueAt(selectedRow, 0).toString());
                nameField.setText(model.getValueAt(selectedRow, 1).toString());
                priceField.setText(model.getValueAt(selectedRow, 2).toString());
                quantityField.setText(model.getValueAt(selectedRow, 3).toString());
            }
        });

        frame.setVisible(true);
    }

    private void addProduct() {
        String barcode = barcodeField.getText().trim();
        String name = nameField.getText().trim();
        String priceText = priceField.getText().trim();
        String quantityText = quantityField.getText().trim();

        if (barcode.isEmpty() || name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Please fill all fields.");
            return;
        }

        // Check duplicates
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0).toString().equals(barcode)) {
                JOptionPane.showMessageDialog(frame, "Product with this barcode already exists!");
                return;
            }
        }

        try {
            double price = Double.parseDouble(priceText);
            int quantity = Integer.parseInt(quantityText);
            model.addRow(new Object[]{barcode, name, price, quantity});
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Price and Quantity must be numeric!");
        }

        clearFields();
    }

    private void updateProduct() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(frame, "Select a product to update.");
            return;
        }

        try {
            String barcode = barcodeField.getText().trim();
            String name = nameField.getText().trim();
            double price = Double.parseDouble(priceField.getText().trim());
            int quantity = Integer.parseInt(quantityField.getText().trim());

            // Check for duplicate barcode in other rows
            for (int i = 0; i < model.getRowCount(); i++) {
                if (i != selectedRow && model.getValueAt(i, 0).toString().equals(barcode)) {
                    JOptionPane.showMessageDialog(frame, "Another product with this barcode exists!");
                    return;
                }
            }

            model.setValueAt(barcode, selectedRow, 0);
            model.setValueAt(name, selectedRow, 1);
            model.setValueAt(price, selectedRow, 2);
            model.setValueAt(quantity, selectedRow, 3);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(frame, "Price and Quantity must be numeric!");
        }

        clearFields();
    }

    private void deleteProduct() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            model.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(frame, "Select a product to delete.");
        }
    }

    private void calculateTotalStock() {
        double total = 0.0;
        for (int i = 0; i < model.getRowCount(); i++) {
            double price = Double.parseDouble(model.getValueAt(i, 2).toString());
            int quantity = Integer.parseInt(model.getValueAt(i, 3).toString());
            total += price * quantity;
        }
        totalStockLabel.setText("Total Stock Value: " + total);
    }

    private void clearFields() {
        barcodeField.setText("");
        nameField.setText("");
        priceField.setText("");
        quantityField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(InventoryApp::new);
    }
}
