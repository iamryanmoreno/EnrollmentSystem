/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package EnrollmentSystem;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class LogIn extends JFrame{
    JPanel panelBgImg;
    JPasswordField pwPassword;
    JLabel lblUserName, lblPassword, lblBackground;
    JTextField txtUserName, txtPassword;
    JButton btnOk, btnLogIn, btnCancel;
    Container con = null;
    JPasswordField pwField;
    public String name, name2;
    
    public LogIn(){
        
        setTitle ("Login");
        setBounds(450,250,500,500);
        setIconImage(new ImageIcon(LogIn.class.getResource("TIPlogo.jpg")).getImage());
        con = getContentPane();
        
        con.setLayout(null);
        ImageIcon imh = new ImageIcon("loginbackground.png");
        setSize(imh.getIconWidth(), imh.getIconHeight());
        
        final ImageIcon imageOk = new ImageIcon("ok.jpg");
        final ImageIcon imageCancel = new ImageIcon("cancel.jpg");
        
        panelBgImg = new JPanel()
        {
            @Override
            public void paintComponent(Graphics g){ //bg.jpeg
                Image img = new ImageIcon("loginbackground.png").getImage();
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
        
        lblUserName = new JLabel("Username:");
        lblUserName.setBounds(100,100,70,20);
        lblUserName.setForeground(Color.white);
        panelBgImg.add(lblUserName);
        
        txtUserName = new JTextField("");
        txtUserName.setBounds(200,100,120,20);
        txtUserName.setBackground(Color.white);
        txtUserName.setHorizontalAlignment(JTextField.LEFT);
        txtUserName.setToolTipText("Enter Username");
        txtUserName.setEditable(true);
        panelBgImg.add(txtUserName);
        
        lblPassword = new JLabel("Password:");
        lblPassword.setBounds(100,130,70,20);
        lblPassword.setForeground(Color.white);
        panelBgImg.add(lblPassword);
        
        pwField = new JPasswordField();
        pwField.setBounds(200, 130, 120, 20);
        panelBgImg.add(pwField);
        
        txtPassword = new JTextField("");
        txtPassword.setBounds(200,130,120,20);
        txtPassword.setBackground(Color.white);
        txtPassword.setToolTipText("Enter Password");
        txtPassword.setEditable(true);
        panelBgImg.add(txtPassword);
    
        btnOk = new JButton("",imageOk);
        btnOk.setBounds(130,170,imageOk.getIconWidth(),imageOk.getIconHeight());
        btnOk.setForeground(Color.black);
        btnOk.setOpaque(false);
        btnOk.setBorderPainted(true); 
        btnOk.setContentAreaFilled(true); 
        btnOk.setFocusPainted(true);
        btnOk.addActionListener(new ButtonListener());
        panelBgImg.add(btnOk);
        
        btnCancel = new JButton("",imageCancel);
        btnCancel.setBounds(230,170,imageOk.getIconWidth(),imageOk.getIconHeight());
        btnCancel.setForeground(Color.black);
        btnCancel.setOpaque(false);
        btnCancel.setBorderPainted(true); 
        btnCancel.setContentAreaFilled(true); 
        btnCancel.setFocusPainted(true);
        btnCancel.addActionListener(new ButtonListener());
        panelBgImg.add(btnCancel);
    }
    public void run(){
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     private class ButtonListener implements ActionListener{
        @Override
        public  void actionPerformed(ActionEvent e){
            if (e.getSource()==btnCancel)  
            {
                txtUserName.setText("");
                txtPassword.setText("");
                pwField.setText("");
                
            }
            if (e.getSource()==btnOk){
            
            name = txtUserName.getText();
            name2 = txtPassword.getText();
            
            StudentRegistration std = new StudentRegistration();
            std.run();
           //student.lblName.setText(name);
            
            //dispose();
            
            
            }
        }
     }/*
     public static void main(String[] args){
        
        LogIn log = new LogIn();
        log.run();
    }*/
}
