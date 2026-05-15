package travel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dashboard extends JFrame implements ActionListener {

    String username;

    JButton addPersonalDetails, viewPersonalDetails, updatePersonalDetails, deletePersonalDetails;
    JButton checkpackages, bookpackage, viewpackage, viewhotels;
    JButton destination, bookhotel, viewBookedHotel, payments, calculator, notepad, about;

    Dashboard(String username) {

        this.username = username;

        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);

        // ---------------- Top Panel ----------------
        JPanel p1 = new JPanel();
        p1.setLayout(null);
        p1.setBackground(new Color(0, 0, 102));
        p1.setBounds(0, 0, 1920, 65);
        add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/dashboard.png"));
        Image i2 = i1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT);
        JLabel icon = new JLabel(new ImageIcon(i2));
        icon.setBounds(5, 0, 70, 70);
        p1.add(icon);

        JLabel heading = new JLabel("Dashboard");
        heading.setBounds(80, 10, 300, 40);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Tahoma", Font.BOLD, 30));
        p1.add(heading);

        // ---------------- Side Panel ----------------
        JPanel p2 = new JPanel();
        p2.setLayout(null);
        p2.setBackground(new Color(0, 0, 102));
        p2.setBounds(0, 65, 300, 900);
        add(p2);

        // -------- Buttons --------
        addPersonalDetails = createButton("Add Personal Details", 0, p2);
        updatePersonalDetails = createButton("Update Personal Details", 65, p2);
        viewPersonalDetails = createButton("View Details", 125, p2);
        deletePersonalDetails = createButton("Delete Personal Details", 185, p2);
        checkpackages = createButton("Check Package", 245, p2);
        bookpackage = createButton("Book Package", 305, p2);
        viewpackage = createButton("View Package", 365, p2);
        viewhotels = createButton("View Hotels", 425, p2);
        bookhotel = createButton("Book Hotel", 485, p2);
        viewBookedHotel = createButton("View Booked Hotel", 545, p2);
        destination = createButton("Destination", 605, p2);
        payments = createButton("Payments", 665, p2);
        calculator = createButton("Calculator", 725, p2);
        notepad = createButton("Notepad", 785, p2);
        about = createButton("About", 845, p2);

        // ---------------- Background Image ----------------
        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(1950, 1000, Image.SCALE_DEFAULT);
        JLabel image = new JLabel(new ImageIcon(bgImg));
        image.setBounds(0, 0, 1950, 1000);
        add(image);

        JLabel text = new JLabel("Travel and Tourism Website");
        text.setBounds(750, 70, 2000, 100);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Tahoma", Font.BOLD, 50));
        image.add(text);

        setVisible(true);
    }

    // -------- Reusable Button Method --------
    private JButton createButton(String text, int y, JPanel panel) {
        JButton button = new JButton(text);
        button.setBounds(0, y, 300, 55);
        button.setBackground(new Color(0, 0, 102));
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.PLAIN, 20));
        button.setFocusPainted(false);
        button.addActionListener(this);
        panel.add(button);
        return button;
    }

    // ---------------- Action Handling ----------------
    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == addPersonalDetails) {
            new AddCustomer(username);

        } else if (ae.getSource() == viewPersonalDetails) {
            new ViewCustomer(username);

        } else if (ae.getSource() == updatePersonalDetails) {
            new UpdateCustomer(username);

        } else if (ae.getSource() == deletePersonalDetails) {
            new DeleteDetails(username);

        } else if (ae.getSource() == checkpackages) {
            new CheckPackage();

        } else if (ae.getSource() == bookpackage) {
            new BookPackage(username);

        } else if (ae.getSource() == viewpackage) {
            new ViewPackage(username);

        } else if (ae.getSource() == viewhotels) {
            new CheckHotels();

        } else if (ae.getSource() == destination) {
            new Destinations();

        } else if (ae.getSource() == bookhotel) {
            new BookHotel(username);

        } else if (ae.getSource() == viewBookedHotel) {
            new ViewBookedHotel(username);

        } else if (ae.getSource() == payments) {
            new Payment();

        } else if (ae.getSource() == calculator) {
            try {
                Runtime.getRuntime().exec("calc.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == notepad) {
            try {
                Runtime.getRuntime().exec("notepad.exe");
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == about) {
            new About();
        }
    }

    public static void main(String[] args) {
        new Dashboard("Dhruvil");
    }
}