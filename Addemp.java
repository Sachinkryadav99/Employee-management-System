
package emp.mng.sys;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import java.util.*;
import javax.swing.JButton;
import java.awt.event.*;
import java.sql.*;
import javax.swing.JOptionPane;


public class Addemp extends JFrame implements ActionListener 
{
    
    Random ran = new Random();
    int num = ran.nextInt(999999);
    
     JTextField tfname,tfaname,tSalary,tadd,tphone,temail,tadeg,tAadhar;
     JComboBox teducation;
     JDateChooser dcdob;
     JButton add ,back;
     JLabel taempid;

    Addemp() 
    {
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel heading = new JLabel("Add Employee Details");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN SERIF", Font.BOLD, 25));
        add(heading);
        
        
        JLabel lablefname = new JLabel("Name");
        lablefname.setBounds(50,150,150,30);
        lablefname.setFont(new Font("serif",Font.PLAIN,20));
        add(lablefname);
        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
        
        JLabel lableFaname = new JLabel("Father's Name");
        lableFaname.setBounds(400,150,150,30);
        lableFaname.setFont(new Font("serif",Font.PLAIN,20));
        add(lableFaname);
        tfaname = new JTextField();
        tfaname.setBounds(600,150,150,30);
        add(tfaname);
        
        
        
        JLabel labdob = new JLabel("Date of Birth");
        labdob.setBounds(50,200,150,30);
        labdob.setFont(new Font("serif",Font.PLAIN,20));
        add(labdob);
        dcdob = new JDateChooser();
        dcdob.setBounds(200,200,150,30);
        add(dcdob);
        
        
        JLabel lablesalary = new JLabel("Salary");
        lablesalary.setBounds(400,200,150,30);
        lablesalary.setFont(new Font("serif",Font.PLAIN,20));
        add(lablesalary);
        tSalary = new JTextField();
        tSalary.setBounds(600,200,150,30);
        add(tSalary);
        
        
        
        JLabel lableadd = new JLabel("Address");
        lableadd.setBounds(50,250,150,30);
        lableadd.setFont(new Font("serif",Font.PLAIN,20));
        add(lableadd);
        tadd = new JTextField();
        tadd.setBounds(200,250,150,30);
        add(tadd);
        
        
        JLabel lablephone = new JLabel("Phone");
        lablephone.setBounds(400,250,150,30);
        lablephone.setFont(new Font("serif",Font.PLAIN,20));
        add(lablephone);
        tphone = new JTextField();
        tphone.setBounds(600,250,150,30);
        add(tphone);
        
        
        
        
        JLabel lableemail = new JLabel("Email");
        lableemail.setBounds(50,300,150,30);
        lableemail.setFont(new Font("serif",Font.PLAIN,20));
        add(lableemail);
        temail = new JTextField();
        temail.setBounds(200,300,150,30);
        add(temail);
        
        
        JLabel lableeducatio = new JLabel("Highest Education");
        lableeducatio.setBounds(400,300,150,30);
        lableeducatio.setFont(new Font("serif",Font.PLAIN,20));
        add(lableeducatio);
        String course[] = {"BBA","BCA","BA","BCA","B.COM","B-TECH","MBA","MCA","MA","M-TECH","MCA","PHD"};
        teducation = new JComboBox(course);
        teducation.setBackground(Color.white);
        teducation.setBounds(600,300,150,30);
        add(teducation);
        
        
        
        JLabel labledesignation = new JLabel("Designamtion");
        labledesignation.setBounds(50,350,150,30);
        labledesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labledesignation);
        tadeg = new JTextField();
        tadeg.setBounds(200,350,150,30);
        add(tadeg);
        
        
        JLabel lableAadhar = new JLabel("Aadhar Number");
        lableAadhar.setBounds(400,350,150,30);
        lableAadhar.setFont(new Font("serif",Font.PLAIN,20));
        add(lableAadhar);
        tAadhar = new JTextField();
        tAadhar.setBounds(600,350,150,30);
        add(tAadhar);
        
        
        JLabel lableempid = new JLabel("Employee Id");
        lableempid.setBounds(50,400,150,30);
        lableempid.setFont(new Font("serif",Font.PLAIN,20));
        add(lableempid);
        taempid = new JLabel(""+num);
        taempid.setBounds(200,400,150,30);
        taempid.setFont(new Font("serif",Font.BOLD,30));
        add(taempid);
       
        
        add = new JButton("Add Details");
        add.setBounds(250,500,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        back = new JButton("Back");
        back.setBounds(450,500,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
        
        
        
        
        
        setSize(900,700);
        setVisible(true);
    }
    
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource() == add)
        {
            String name = tfname.getText();
            String father = tfaname.getText();
            String salary = tSalary.getText();
            String Addres = tadd.getText();
            String phone = tphone.getText();
            String mail = temail.getText();
            String degination = tadeg.getText();
            String aadhar = tAadhar.getText();
            String education = (String) teducation.getSelectedItem();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String empid = taempid.getText();
            
            try {
                conn c = new conn();
                String query = "Insert into Addemp values ('"+name+"','"+father+"','"+salary+"','"+Addres+"','"+phone+"','"+mail+"','"+degination+"','"+aadhar+"','"+education+"','"+dob+"','"+empid+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Detail Added Successfully");
                setVisible(false);
                new Home();
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else
        {
            setVisible(false);
            new Home();
        }
    }
    
    
    
    
    public static void main(String[] args) {
        new Addemp();
    }
}
