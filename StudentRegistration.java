/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnrollmentSystem;

/**
 *
 * @author acer
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentRegistration extends JFrame{
    JPanel panelBgImg;
    JLabel lblStudentId, lblPicture, lblFirstName, lblMiddleName, lblLastName, lblGender, lblProgram, lblYearLevel,lblSchoolYear,lblSemester;
    JTextField txtStudentId, txtFirstName, txtMiddleName, txtLastName;
    JRadioButton rdbFemale, rdbMale, rdbFirstSem, rdbSecondSem, rdbSummer;
    JButton btnRegister, btnLogout, btnOk;
    String[] programString = {"Choose Program","ARCH","CE","CpE","EE","ECE","EnSe","ME","IE"};
    String[] yearLevelString = {"Choose Year Level","1st Year","2nd Year","3rd Year","4th Year","5th Year"};
    String[] schoolYearString = {"Choose School Year","2010-2011","2011-2012","2012-2013","2013-2014","2014-2015"};
    ButtonGroup bgGender, bgSemester;
    Container con = null;
    public String name, name2;
    
    final ImageIcon imageRegister = new ImageIcon("register.png");
    final ImageIcon imageLogout = new ImageIcon("logout.png");
    final ImageIcon imagePicture = new ImageIcon("picture.jpg");
        
    public StudentRegistration(){
        
        setTitle ("Student Registration");
        setBounds(200,100,500,500);
        setIconImage(new ImageIcon(LogIn.class.getResource("TIPlogo.jpg")).getImage());
        con = getContentPane();
        
        con.setLayout(null);
        ImageIcon imh = new ImageIcon("studentRegistration.png");
        setSize(imh.getIconWidth(), imh.getIconHeight());
        
        
        panelBgImg = new JPanel()
        {
            @Override
            public void paintComponent(Graphics g){ //bg.jpeg
                Image img = new ImageIcon("studentRegistration.png").getImage();
                Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
                //setBorder(BorderFactory.createTitledBorder("Login"));
                setPreferredSize(size);
                setMinimumSize(size);
                setMaximumSize(size);
                setSize(size);
                setLayout(null);
                g.drawImage(img, 0, 0, null);
            }
        };
        con.add(panelBgImg);
        
        JPanel panelcontent = new JPanel();
        panelBgImg.setBounds(0,0,imh.getIconWidth(),imh.getIconHeight());
        panelBgImg.setLayout(null);
        panelBgImg.add(panelcontent);
        
        lblPicture = new JLabel(imagePicture);
        lblPicture.setBounds(520,80,imagePicture.getIconWidth(),imagePicture.getIconWidth());
        panelBgImg.add(lblPicture);
        
        lblStudentId = new JLabel("Student ID:");
        lblStudentId.setBounds(200,100,70,20);
        lblStudentId.setForeground(Color.black);
        panelBgImg.add(lblStudentId);
       
        txtStudentId = new JTextField("");
        txtStudentId.setBounds(350,100,150,20);
        txtStudentId.setBackground(Color.white);
        txtStudentId.setForeground(Color.black);
        txtStudentId.setHorizontalAlignment(JTextField.LEFT);
        txtStudentId.setOpaque(true);
        txtStudentId.setToolTipText("Enter your Student Identification");
        txtStudentId.setEditable(true);
        panelBgImg.add(txtStudentId);
        
        lblFirstName = new JLabel("First Name:");
        lblFirstName.setBounds(200,125,80,20);
        lblFirstName.setForeground(Color.black);
        panelBgImg.add(lblFirstName);
        
        txtFirstName = new JTextField("");
        txtFirstName.setBounds(350,125,150,20);
        txtFirstName.setBackground(Color.white);
        txtFirstName.setForeground(Color.BLACK);
        txtFirstName.setOpaque(true);
        txtFirstName.setToolTipText("Enter your given name");
        txtFirstName.setEditable(true);
        panelBgImg.add(txtFirstName);
        
        lblMiddleName = new JLabel("Middle Name:");
        lblMiddleName.setBounds(200,150,100,20);
        lblMiddleName.setForeground(Color.black);
        panelBgImg.add(lblMiddleName);
        
        txtMiddleName = new JTextField("");
        txtMiddleName.setBounds(350,150,150,20);
        txtMiddleName.setBackground(Color.white);
        txtMiddleName.setForeground(Color.BLACK);
        txtMiddleName.setOpaque(true);
        txtMiddleName.setToolTipText("Enter your maiden name");
        txtMiddleName.setEditable(true);
        panelBgImg.add(txtMiddleName);
        
        lblLastName = new JLabel("Last Name:");
        lblLastName.setBounds(200,175,100,20);
        lblLastName.setForeground(Color.black);
        panelBgImg.add(lblLastName);
        
        txtLastName = new JTextField("");
        txtLastName.setBounds(350,175,150,20);
        txtLastName.setOpaque(true);
        txtLastName.setToolTipText("Enter your last name");
        txtLastName.setBackground(Color.white);
        txtLastName.setForeground(Color.BLACK);
        txtLastName.setEditable(true);
        panelBgImg.add(txtLastName);
        
        lblGender = new JLabel("Gender:");
        lblGender.setBounds(200,200,120,20);
        lblGender.setForeground(Color.black);
        panelBgImg.add(lblGender);
        
        rdbFemale = new JRadioButton("Female",true); 
        rdbFemale.setBounds(350,200,70,20);
        rdbFemale.setForeground(Color.black);
        rdbFemale.setBackground(Color.white);
        panelBgImg.add(rdbFemale);
        
        rdbMale = new JRadioButton("Male",false); 
        rdbMale.setBounds(450,200,70,20);
        rdbMale.setForeground(Color.black);
        rdbMale.setBackground(Color.white);
        panelBgImg.add(rdbMale);
        
        bgGender = new ButtonGroup();
        bgGender.add(rdbFemale);
        bgGender.add(rdbMale);
        
        lblProgram = new JLabel ("Program: ");
        lblProgram.setBounds(200,225,120,20);
        lblProgram.setForeground(Color.black);
        panelBgImg.add(lblProgram);
        
        JComboBox cbProgram = new JComboBox(programString);
        cbProgram.setBounds(350,225,150,20);
        cbProgram.setForeground(Color.black);
        cbProgram.setBackground(Color.white);
        panelBgImg.add(cbProgram);
        
        lblYearLevel = new JLabel ("Year Level: ");
        lblYearLevel.setBounds(200,250,120,20);
        lblYearLevel.setForeground(Color.black);
        panelBgImg.add(lblYearLevel);
        
        JComboBox cbYearLevel = new JComboBox(yearLevelString);
        cbYearLevel.setBounds(350,250,150,20);
        cbYearLevel.setForeground(Color.black);
        cbYearLevel.setBackground(Color.white);
        panelBgImg.add(cbYearLevel);
        
        lblSchoolYear = new JLabel ("School Year: ");
        lblSchoolYear.setBounds(200,275,120,20);
        lblSchoolYear.setForeground(Color.black);
        panelBgImg.add(lblSchoolYear);
        
        JComboBox cbSchoolYear = new JComboBox(schoolYearString);
        cbSchoolYear.setBounds(350,275,150,20);
        cbSchoolYear.setForeground(Color.black);
        cbSchoolYear.setBackground(Color.white);
        panelBgImg.add(cbSchoolYear);
        
        lblSemester = new JLabel("Semester:");
        lblSemester.setBounds(200,300,120,20);
        lblSemester.setForeground(Color.black);
        panelBgImg.add(lblSemester);
        
        rdbFirstSem = new JRadioButton("First",true); 
        rdbFirstSem.setBounds(350,300,90,20);
        rdbFirstSem.setForeground(Color.black);
        rdbFirstSem.setBackground(Color.white);
        panelBgImg.add(rdbFirstSem);
        
        rdbSecondSem = new JRadioButton("Second",false); 
        rdbSecondSem.setBounds(450,300,90,20);
        rdbSecondSem.setForeground(Color.black);
        rdbSecondSem.setBackground(Color.white);
        panelBgImg.add(rdbSecondSem);
        
        rdbSummer = new JRadioButton("Summer",false); 
        rdbSummer.setBounds(550,300,90,20);
        rdbSummer.setForeground(Color.black);
        rdbSummer.setBackground(Color.white);
        panelBgImg.add(rdbSummer);
        
        bgSemester = new ButtonGroup();
        bgSemester.add(rdbFirstSem);
        bgSemester.add(rdbSecondSem);
        bgSemester.add(rdbSummer);
        
        btnRegister = new JButton("",imageRegister);
        btnRegister.setBounds(300,400,imageRegister.getIconWidth(),imageRegister.getIconHeight());
        panelBgImg.add(btnRegister);
        
        btnLogout = new JButton("",imageLogout);
        btnLogout.setBounds(450,400,imageLogout.getIconWidth(),imageLogout.getIconHeight());
        panelBgImg.add(btnLogout);
        
    }
    public void run(){
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    /*
    public static void main(String[] args){
        
        StudentRegistration std = new StudentRegistration();
        std.run();
    }*/
}
