package com.hotelbooking.system;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static com.mongodb.client.model.Filters.eq;

public class HotelBookingSystem {
    public static void main(String[] args) {
        Hotel_Booking();
    }

    static void Hotel_Booking() {
        JFrame frame = new JFrame();
        ImageIcon imageIcon = new ImageIcon("C:\\Users\\ashut\\OneDrive\\Desktop\\download.jpeg");


        frame.setContentPane(new JLabel(imageIcon));

        JLabel l1 = new JLabel("Full Name");
        l1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l1.setForeground(Color.WHITE);
        l1.setBounds(120, 200, 167, 25);
        frame.getContentPane().add(l1);

        JTextField t1 = new JTextField();
        t1.setBounds(220, 200, 198, 25);
        t1.setBorder(new LineBorder(Color.white, 2));
        frame.getContentPane().add(t1);

        JLabel l2 = new JLabel("Phone_No");
        l2.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l2.setForeground(Color.white);
        l2.setBounds(120, 270, 134, 20);
        frame.getContentPane().add(l2);

        JTextField t2 = new JTextField();
        t2.setBounds(220, 270, 199, 25);
        t2.setBorder(new LineBorder(Color.white, 2));
        frame.getContentPane().add(t2);

        JLabel l3 = new JLabel("Email id");
        l3.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l3.setBounds(120, 340, 167, 25);
        l3.setForeground(Color.white);
        frame.getContentPane().add(l3);

        JTextField t3 = new JTextField();
        t3.setBounds(220, 340, 198, 25);
        t3.setBorder(new LineBorder(Color.white, 2));
        frame.getContentPane().add(t3);

        JLabel l4 = new JLabel("Date-of-Birth");
        l4.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l4.setForeground(Color.WHITE);
        l4.setBounds(120, 410, 167, 25);
        frame.getContentPane().add(l4);

        JTextField t4 = new JTextField();
        t4.setBounds(220, 410, 198, 25);
        t4.setBorder(new LineBorder(Color.white, 2));
        frame.getContentPane().add(t4);

        JLabel l5 = new JLabel("Gender");
        l5.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l5.setForeground(Color.WHITE);
        l5.setBounds(120, 480, 114, 14);
        frame.getContentPane().add(l5);

        JRadioButton r1 = new JRadioButton("Male");
        r1.setBackground(new Color(255, 255, 255, 255));
        r1.setForeground(Color.BLACK);
        r1.setBorder(new LineBorder(Color.WHITE, 2));
        r1.setFont(new Font("White", Font.PLAIN, 13));
        r1.setBounds(220, 480, 70, 23);
        frame.getContentPane().add(r1);

        JRadioButton r2 = new JRadioButton("Female");
        r2.setBackground(new Color(255, 255, 255, 255));
        r2.setForeground(Color.BLACK);
        r2.setBorder(new LineBorder(Color.WHITE, 2));
        r2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        r2.setBounds(220, 510, 70, 23);
        frame.getContentPane().add(r2);

        JRadioButton r3 = new JRadioButton("Other");
        r3.setBackground(new Color(255, 255, 255, 255));
        r3.setBorder(new LineBorder(Color.WHITE, 2));
        r3.setForeground(Color.black);
        r3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        r3.setBounds(220, 540, 70, 23);
        frame.getContentPane().add(r3);

        JLabel l6 = new JLabel("Room Preference");
        l6.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l6.setForeground(Color.WHITE);
        l6.setBounds(480, 200, 167, 25);
        frame.getContentPane().add(l6);

        String[] s1 = {"Standard", "Deluxe", "Suite"};
        JComboBox<String> comboBox1 = new JComboBox<>(s1);
        comboBox1.setBounds(630, 200, 167, 25);
        frame.getContentPane().add(comboBox1);

        JLabel l7 = new JLabel("No of Adults");
        l7.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l7.setForeground(Color.WHITE);
        l7.setBounds(480, 270, 167, 25);
        frame.getContentPane().add(l7);

        String[] s2 = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        JComboBox<String> comboBox2 = new JComboBox<>(s2);
        comboBox2.setBounds(630, 270, 167, 25);
        frame.getContentPane().add(comboBox2);

        JLabel l8 = new JLabel("No of Children");
        l8.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l8.setForeground(Color.WHITE);
        l8.setBounds(480, 340, 167, 25);
        frame.getContentPane().add(l8);

        JComboBox<String> comboBox3 = new JComboBox<>(s2);
        comboBox3.setBounds(630, 340, 167, 25);
        frame.getContentPane().add(comboBox3);

        JLabel l9 = new JLabel("State");
        l9.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l9.setForeground(Color.WHITE);
        l9.setBounds(480, 410, 167, 25);
        frame.getContentPane().add(l9);

        String[] State = {
                "Choose State", "Andhra Pradesh", "Arunachal Pradesh", "Assam", "Bihar", "Chhattisgarh",
                "Goa", "Gujarat", "Haryana", "Himachal Pradesh", "Jharkhand", "Karnataka", "Kerala",
                "Madhya Pradesh", "Maharashtra", "Manipur", "Meghalaya", "Mizoram", "Nagaland", "Odisha",
                "Punjab", "Rajasthan", "Sikkim", "Tamil Nadu", "Telangana", "Tripura", "Uttar Pradesh",
                "Uttarakhand", "West Bengal", "Andaman and Nicobar Islands", "Chandigarh", "Dadra and Nagar Haveli and Daman and Diu",
                "Delhi", "Jammu and Kashmir", "Ladakh", "Lakshadweep", "Puducherry"
        };
        JComboBox<String> comboBox4 = new JComboBox<>(State);
        comboBox4.setBounds(630, 410, 167, 25);
        frame.getContentPane().add(comboBox4);

        JLabel l10 = new JLabel("City Name");
        l10.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l10.setForeground(Color.WHITE);
        l10.setBounds(480, 480, 167, 25);
        frame.getContentPane().add(l10);

        JTextField t5 = new JTextField();
        t5.setBounds(600, 480, 198, 25);
        t5.setBorder(new LineBorder(Color.white, 2));
        frame.getContentPane().add(t5);

        JLabel l11 = new JLabel("Pin Code");
        l11.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l11.setForeground(Color.WHITE);
        l11.setBounds(480, 530, 167, 25);
        frame.getContentPane().add(l11);

        JTextField t6 = new JTextField();
        t6.setBounds(600, 530, 198, 25);
        t6.setBorder(new LineBorder(Color.white, 2));
        frame.getContentPane().add(t6);

        JLabel l12 = new JLabel("Check-in-Date");
        l12.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l12.setForeground(Color.WHITE);
        l12.setBounds(850, 200, 167, 25);
        frame.getContentPane().add(l12);

        JTextField t7 = new JTextField();
        t7.setBounds(980, 200, 198, 25);
        t7.setBorder(new LineBorder(Color.white, 2));
        frame.getContentPane().add(t7);

        JLabel l13 = new JLabel("Check-Out-Date");
        l13.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l13.setForeground(Color.WHITE);
        l13.setBounds(850, 270, 167, 25);
        frame.getContentPane().add(l13);

        JTextField t8 = new JTextField();
        t8.setBounds(980, 270, 198, 25);
        t8.setBorder(new LineBorder(Color.white, 2));
        frame.getContentPane().add(t8);

        JLabel l14 = new JLabel("ID-Name");
        l14.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l14.setForeground(Color.WHITE);
        l14.setBounds(850, 340, 167, 25);
        frame.getContentPane().add(l14);

        String[] s3 = {"Aadhar", "Pan-Card", "Driving License", "Other"};
        JComboBox<String> comboBox5 = new JComboBox<>(s3);
        comboBox5.setBounds(980, 340, 167, 25);
        frame.getContentPane().add(comboBox5);

        JLabel l15 = new JLabel("ID Number");
        l15.setFont(new Font("Tahoma", Font.PLAIN, 16));
        l15.setForeground(Color.WHITE);
        l15.setBounds(850, 410, 167, 25);
        frame.getContentPane().add(l15);

        JTextField t9 = new JTextField();
        t9.setBounds(980, 410, 198, 25);
        t9.setBorder(new LineBorder(Color.white, 2));
        frame.getContentPane().add(t9);

        JButton b1 = new JButton("Confirm Booking");
        b1.setBackground(Color.WHITE);
        b1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        b1.setBounds(400, 600, 200, 30);
        frame.getContentPane().add(b1);

        JButton b2 = new JButton("Search Booking");
        b2.setBackground(Color.WHITE);
        b2.setFont(new Font("Tahoma", Font.PLAIN, 13));
        b2.setBounds(650, 600, 200, 30);
        frame.getContentPane().add(b2);

        JButton b3 = new JButton("Update Booking");
        b3.setBackground(Color.WHITE);
        b3.setFont(new Font("Tahoma", Font.PLAIN, 13));
        b3.setBounds(900, 600, 200, 30);
        frame.getContentPane().add(b3);

        JButton b4 = new JButton("Delete Booking");
        b4.setBackground(Color.WHITE);
        b4.setFont(new Font("Tahoma", Font.PLAIN, 13));
        b4.setBounds(1150, 600, 200, 30);
        frame.getContentPane().add(b4);

        // MongoDB connection
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("HotelBookingDB");
        MongoCollection<Document> collection = database.getCollection("Booking");

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = t1.getText();
                String phone = t2.getText();
                String email = t3.getText();
                String dob = t4.getText();
                String gender = r1.isSelected() ? "Male" : r2.isSelected() ? "Female" : "Other";
                String roomPref = (String) comboBox1.getSelectedItem();
                String adults = (String) comboBox2.getSelectedItem();
                String children = (String) comboBox3.getSelectedItem();
                String state = (String) comboBox4.getSelectedItem();
                String city = t5.getText();
                String pincode = t6.getText();
                String checkin = t7.getText();
                String checkout = t8.getText();
                String idName = (String) comboBox5.getSelectedItem();
                String idNumber = t9.getText();

                // Inserting data into MongoDB
                Document booking = new Document("name", name)
                        .append("phone", phone)
                        .append("email", email)
                        .append("dob", dob)
                        .append("gender", gender)
                        .append("room_pref", roomPref)
                        .append("adults", adults)
                        .append("children", children)
                        .append("state", state)
                        .append("city", city)
                        .append("pincode", pincode)
                        .append("checkin", checkin)
                        .append("checkout", checkout)
                        .append("id_name", idName)
                        .append("id_number", idNumber);

                collection.insertOne(booking);
                JOptionPane.showMessageDialog(frame, "Booking Confirmed!");
            }
        });

        b2.addActionListener(new ActionListener() {  // Search Booking
            @Override
            public void actionPerformed(ActionEvent e) {
                String phone = JOptionPane.showInputDialog(frame, "Enter Phone Number to Search Booking:");

                Document booking = collection.find(eq("phone", phone)).first();

                if (booking != null) {
                    JOptionPane.showMessageDialog(frame, "Booking Found: " + booking.toJson());
                } else {
                    JOptionPane.showMessageDialog(frame, "No Booking Found with this Phone Number.");
                }
            }
        });

        b3.addActionListener(new ActionListener() {  // Update Booking
            @Override
            public void actionPerformed(ActionEvent e) {
                String phone = JOptionPane.showInputDialog(frame, "Enter Phone Number to Update Booking:");

                Document booking = collection.find(eq("phone", phone)).first();

                if (booking != null) {
                    String newCheckOut = JOptionPane.showInputDialog(frame, "Enter New Check-Out Date:");

                    Bson updateOperation = Updates.set("checkout", newCheckOut);
                    collection.updateOne(eq("phone", phone), updateOperation);

                    JOptionPane.showMessageDialog(frame, "Booking Updated!");
                } else {
                    JOptionPane.showMessageDialog(frame, "No Booking Found with this Phone Number.");
                }
            }
        });

        b4.addActionListener(new ActionListener() {  // Delete Booking
            @Override
            public void actionPerformed(ActionEvent e) {
                String phone = JOptionPane.showInputDialog(frame, "Enter Phone Number to Delete Booking:");

                Document booking = collection.find(eq("phone", phone)).first();

                if (booking != null) {
                    collection.deleteOne(eq("phone", phone));
                    JOptionPane.showMessageDialog(frame, "Booking Deleted!");
                } else {
                    JOptionPane.showMessageDialog(frame, "No Booking Found with this Phone Number.");
                }
            }
        });

        frame.setLayout(null);
        frame.setBounds(0, 0, 1500, 1000);
        frame.setVisible(true);
    }
}
