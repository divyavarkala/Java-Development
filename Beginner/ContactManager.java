package Beginner;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

class Contact {
    private String name;
    private String phone;
    private String email;

    // Constructor
    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters and setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone: " + phone + ", Email: " + email;
    }
}

public class ContactManager {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Contact> contacts = new ArrayList<>();

    public static void main(String[] args) {
        boolean exit = false;
        System.out.println("=== Simple Contact Management System ===");

        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Search Contacts");
            System.out.println("6. Export Contacts to File");
            System.out.println("7. Exit");

            int choice = getIntInput("Enter your choice: ");

            switch (choice) {
                case 1 -> addContact();
                case 2 -> viewContacts();
                case 3 -> updateContact();
                case 4 -> deleteContact();
                case 5 -> searchContacts();
                case 6 -> exportToFile();
                case 7 -> {
                    System.out.println("Exiting...");
                    exit = true;
                }
                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Safe integer input
    public static int getIntInput(String prompt) {
        int num;
        while (true) {
            try {
                System.out.print(prompt);
                num = Integer.parseInt(sc.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a number.");
            }
        }
        return num;
    }

    // Add a new contact
    public static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine().trim();
        System.out.print("Enter email: ");
        String email = sc.nextLine().trim();

        // Check for duplicates
        for (Contact c : contacts) {
            if (c.getPhone().equals(phone)) {
                System.out.println("Contact with this phone already exists!");
                return;
            }
        }

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully.");
    }

    // View all contacts
    public static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        System.out.println("\nContacts List:");
        int i = 1;
        for (Contact c : contacts) {
            System.out.println(i + ". " + c);
            i++;
        }
    }

    // Update a contact by phone number
    public static void updateContact() {
        System.out.print("Enter phone number of contact to update: ");
        String phone = sc.nextLine().trim();
        for (Contact c : contacts) {
            if (c.getPhone().equals(phone)) {
                System.out.print("Enter new name (leave blank to keep current): ");
                String name = sc.nextLine().trim();
                if (!name.isEmpty()) c.setName(name);

                System.out.print("Enter new phone (leave blank to keep current): ");
                String newPhone = sc.nextLine().trim();
                if (!newPhone.isEmpty()) c.setPhone(newPhone);

                System.out.print("Enter new email (leave blank to keep current): ");
                String email = sc.nextLine().trim();
                if (!email.isEmpty()) c.setEmail(email);

                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Delete a contact by phone number
    public static void deleteContact() {
        System.out.print("Enter phone number of contact to delete: ");
        String phone = sc.nextLine().trim();
        for (Contact c : contacts) {
            if (c.getPhone().equals(phone)) {
                contacts.remove(c);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    // Search contacts by keyword (name or phone)
    public static void searchContacts() {
        System.out.print("Enter keyword to search: ");
        String keyword = sc.nextLine().trim().toLowerCase();
        boolean found = false;
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(keyword) || c.getPhone().contains(keyword)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) System.out.println("No matching contacts found.");
    }

    // Export contacts to a text file
    public static void exportToFile() {
        try (FileWriter fw = new FileWriter("contacts.txt")) {
            for (Contact c : contacts) {
                fw.write(c + System.lineSeparator());
            }
            System.out.println("Contacts exported to contacts.txt successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

