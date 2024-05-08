package college.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class EnterGrades extends JFrame implements ActionListener {

    Choice cIDnum;
    JComboBox cbsemester;
    JTextField tfsub1, tfsub2,tfsub3,tfsub4,tfsub5,tfgrades1,tfgrades2,tfgrades3,tfgrades4,tfgrades5;
    JButton cancel, submit;
    JLabel labelname, labelfname;
    
    EnterGrades() {
        
        setSize(1000, 500);
        setLocation(300, 150);
        setLayout(null);
 
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(400, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 40, 500, 400);
        add(image);
        
        JLabel heading = new JLabel("Enter Grades of Student");
        heading.setBounds(50, 0, 300, 50);
        heading.setFont(new Font("Tahoma", Font.BOLD, 16));
        add(heading);
        
        JLabel lblIDnum = new JLabel("Select ID Number");
        lblIDnum.setBounds(50, 50, 200, 20);
        add(lblIDnum);
        
        cIDnum = new Choice();
        cIDnum.setBounds(250, 50, 180, 20);
        add(cIDnum);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            while(rs.next()) {
                cIDnum.add(rs.getString("IDnum"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
             JLabel lblname = new JLabel("Last Name");
        lblname.setBounds(50, 100, 150, 20);
        lblname.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblname);
        
        labelname = new JLabel();
        labelname.setBounds(150, 100, 150, 20);
        labelname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(labelname);
        
        JLabel lblfname = new JLabel("First Name");
        lblfname.setBounds(50, 120, 180, 20);
        lblfname.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(lblfname);
        
        labelfname = new JLabel();
        labelfname.setBounds(150, 120, 140, 20);
        labelfname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(labelfname);
        
        try {
            Conn c = new Conn();
            String query = "select * from student where IDnum='"+cIDnum.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                labelname.setText(rs.getString("lname"));
                labelfname.setText(rs.getString("fname"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        cIDnum.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from student where IDnum='"+cIDnum.getSelectedItem()+"'";
                    ResultSet rs = c.s.executeQuery(query);
                    while(rs.next()) {
                        labelname.setText(rs.getString("lname"));
                        labelfname.setText(rs.getString("fname"));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        JLabel lblsemester = new JLabel("Select Semester");
        lblsemester.setBounds(50, 155, 180, 20);
        add(lblsemester);
        
        String semester[] = {"1st Semester", "2nd Semester", "3rd Semester", "4th Semester", "5th Semester", "6th Semester", "7th Semester", "8th Semester" };
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(250, 155, 180, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblentersubject = new JLabel("Enter Subject");
        lblentersubject.setBounds(100, 180, 200, 40);
        add(lblentersubject);
        
        JLabel lblentermarks = new JLabel("Enter Grades");
        lblentermarks.setBounds(320, 180, 200, 40);
        add(lblentermarks);
        
        tfsub1 = new JTextField();
        tfsub1.setBounds(50, 230, 200, 20);
        add(tfsub1);
        
        tfsub2 = new JTextField();
        tfsub2.setBounds(50, 260, 200, 20);
        add(tfsub2);
        
        tfsub3 = new JTextField();
        tfsub3.setBounds(50, 290, 200, 20);
        add(tfsub3);
        
        tfsub4 = new JTextField();
        tfsub4.setBounds(50, 320, 200, 20);
        add(tfsub4);
        
        tfsub5 = new JTextField();
        tfsub5.setBounds(50, 350, 200, 20);
        add(tfsub5);
        
        tfgrades1 = new JTextField();
        tfgrades1.setBounds(250, 230, 200, 20);
        add(tfgrades1);
        
        tfgrades2 = new JTextField();
        tfgrades2.setBounds(250, 260, 200, 20);
        add(tfgrades2);
        
        tfgrades3 = new JTextField();
        tfgrades3.setBounds(250, 290, 200, 20);
        add(tfgrades3);
        
        tfgrades4 = new JTextField();
        tfgrades4.setBounds(250, 320, 200, 20);
        add(tfgrades4);
        
        tfgrades5 = new JTextField();
        tfgrades5.setBounds(250, 350, 200, 20);
        add(tfgrades5);
        
        submit = new JButton("Submit");
        submit.setBounds(70, 400, 150, 25);
        submit.setBackground(Color.WHITE);
        submit.setForeground(Color.BLACK);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setBounds(280, 400, 150, 25);
        cancel.setBackground(Color.WHITE);
        cancel.setForeground(Color.BLACK);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try {
                Conn c = new Conn();
                
                String query1 = "insert into subject values('"+cIDnum.getSelectedItem()+"','"+labelname.getText()+"','"+labelfname.getText()+"','"+cbsemester.getSelectedItem()+"', '"+tfsub1.getText()+"', '"+tfsub2.getText()+"', '"+tfsub3.getText()+"', '"+tfsub4.getText()+"', '"+tfsub5.getText()+"')";
                String query2 = "insert into grades values('"+cIDnum.getSelectedItem()+"', '"+labelname.getText()+"','"+labelfname.getText()+"','"+cbsemester.getSelectedItem()+"', '"+tfgrades1.getText()+"', '"+tfgrades2.getText()+"', '"+tfgrades3.getText()+"', '"+tfgrades4.getText()+"', '"+tfgrades5.getText()+"')";
            
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Grades Inserted Sucessfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new EnterGrades();
    }
}