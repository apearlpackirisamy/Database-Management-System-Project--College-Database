package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddStudent extends JFrame implements ActionListener{
    
    JTextField tflname, tffname, tfaddress, tfphone, tfemail, tfssn;
    JLabel labelIDnum;
    JDateChooser dcdob;
    JComboBox cbmajor;
    JButton submit, cancel;
    
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    
    AddStudent() {
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Student Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
        JLabel lblname = new JLabel("Last Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tflname = new JTextField();
        tflname.setBounds(200, 150, 150, 30);
        add(tflname);
        
        JLabel lblfname = new JLabel("First Name");
        lblfname.setBounds(400, 150, 200, 30);
        lblfname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblfname);
        
        tffname = new JTextField();
        tffname.setBounds(600, 150, 150, 30);
        add(tffname);
        
        JLabel lblIDnum = new JLabel("ID Number");
        lblIDnum.setBounds(50, 200, 200, 30);
        lblIDnum.setFont(new Font("serif", Font.BOLD, 20));
        add(lblIDnum);
        
        labelIDnum = new JLabel("1533"+first4);
        labelIDnum.setBounds(200, 200, 200, 30);
        labelIDnum.setFont(new Font("serif", Font.BOLD, 20));
        add(labelIDnum);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
        
        JLabel lbladdress = new JLabel("Address");
        lbladdress.setBounds(50, 250, 200, 30);
        lbladdress.setFont(new Font("serif", Font.BOLD, 20));
        add(lbladdress);
        
        tfaddress = new JTextField();
        tfaddress.setBounds(200, 250, 150, 30);
        add(tfaddress);
        
        JLabel lblphone = new JLabel("Phone");
        lblphone.setBounds(400, 250, 200, 30);
        lblphone.setFont(new Font("serif", Font.BOLD, 20));
        add(lblphone);
        
        tfphone = new JTextField();
        tfphone.setBounds(600, 250, 150, 30);
        add(tfphone);
        
        JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
       
    
        JLabel lblssn = new JLabel("SSN");
        lblssn.setBounds(400, 350, 200, 30);
        lblssn.setFont(new Font("serif", Font.BOLD, 20));
        add(lblssn);
        
        tfssn = new JTextField();
        tfssn.setBounds(600, 350, 150, 30);
        add(tfssn);
        
     
 
        
        JLabel lblcourse = new JLabel("Major");
        lblcourse.setBounds(50, 400, 200, 30);
        lblcourse.setFont(new Font("serif", Font.BOLD, 20));
        add(lblcourse);
        
        String course[] = {"Computer Science", "Data Science", "Information Technology", "Cybersecurity", "Graphic Design", "Bioinformatics", "Computer Engineering", "Robotics"};
        cbmajor = new JComboBox(course);
        cbmajor.setBounds(200, 400, 150, 30);
        cbmajor.setBackground(Color.WHITE);
        add(cbmajor);
        
       
    
      
        submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String lname = tflname.getText();
            String fname = tffname.getText();
            String IDnum = labelIDnum.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tfphone.getText();
            String email = tfemail.getText();
          
       
   
            String SSN = tfssn.getText();
            String major = (String) cbmajor.getSelectedItem();
       
            
            try {
                String query = "insert into student values('"+lname+"', '"+fname+"', '"+IDnum+"', '"+dob+"', '"+address+"', '"+phone+"','"+email+"', '"+SSN+"', '"+major+"')";

                Conn con = new Conn();
                con.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null, "Student Details Inserted Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new AddStudent();
    }
}