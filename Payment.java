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
public class Payment extends JFrame{
        JPanel panelBgImg;
        JLabel lblTuitionFee, lblMiscellaneousFee, lblScholarship, lblDiscount;
        JTextField txtTuitionFee, txtMiscellaneousFee;
        JRadioButton rdb10Percent, rdb15Percent, rdb50Percent;
        JButton btnCompute, btnLogout, btnBack;
        ButtonGroup bgPercent;
        JComboBox cbScholarship;
        String[] scholarshipString = {"Choose Scholarship","Demetrio Scholar","Quirino Scholar","Resident Scholar"};
        Container con = null;
        
        final ImageIcon imageCompute = new ImageIcon("compute.png");
        final ImageIcon imageLogout = new ImageIcon("logout.png");
        final ImageIcon imageBack = new ImageIcon("back.png");
        
        public Payment(){
               setTitle ("Payment");
               setBounds(200,100,500,500);
               setIconImage(new ImageIcon(LogIn.class.getResource("TIPlogo.jpg")).getImage());
               con = getContentPane();
              
               con.setLayout(null);
               ImageIcon imh = new ImageIcon("payment.png");
               setSize(imh.getIconWidth(), imh.getIconHeight());
               
               panelBgImg = new JPanel(){
            @Override
            public void paintComponent(Graphics g){ //bg.jpeg
                Image img = new ImageIcon("payment.png").getImage();
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
        
        
        lblTuitionFee = new JLabel("Tuition Fee:");
        lblTuitionFee.setBounds(200,175,100,20);
        lblTuitionFee.setForeground(Color.black);
        panelBgImg.add(lblTuitionFee);
        
        txtTuitionFee = new JTextField("");
        txtTuitionFee.setBounds(350,175,150,20);
        txtTuitionFee.setOpaque(true);
        txtTuitionFee.setToolTipText("Enter tuition fee");
        txtTuitionFee.setBackground(Color.white);
        txtTuitionFee.setForeground(Color.BLACK);
        txtTuitionFee.setEditable(true);
        panelBgImg.add(txtTuitionFee);
        
        lblMiscellaneousFee = new JLabel("Miscellaneous Fee:");
        lblMiscellaneousFee.setBounds(200,200,120,20);
        lblMiscellaneousFee.setForeground(Color.black);
        panelBgImg.add(lblMiscellaneousFee);
        
        txtMiscellaneousFee = new JTextField("");
        txtMiscellaneousFee.setBounds(350,200,150,20);
        txtMiscellaneousFee.setOpaque(true);
        txtMiscellaneousFee.setToolTipText("Enter miscellaneous fee");
        txtMiscellaneousFee.setBackground(Color.white);
        txtMiscellaneousFee.setForeground(Color.BLACK);
        txtMiscellaneousFee.setEditable(true);
        panelBgImg.add(txtMiscellaneousFee);
        
        lblScholarship = new JLabel("Scholarship:");
        lblScholarship.setBounds(200,225,120,20);
        lblScholarship.setForeground(Color.black);
        panelBgImg.add(lblScholarship);
        
        JComboBox cbScholarship = new JComboBox(scholarshipString);
        cbScholarship.setBounds(350,225,150,20);
        cbScholarship.setForeground(Color.black);
        cbScholarship.setBackground(Color.white);
        panelBgImg.add(cbScholarship);
        
        lblDiscount = new JLabel("Discount:");
        lblDiscount.setBounds(200,275,120,20);
        lblDiscount.setForeground(Color.black);
        panelBgImg.add(lblDiscount);
        
        //rdb10Percent, rdb15Percent, rdb50Percent;
        
        rdb10Percent = new JRadioButton("10%",true); 
        rdb10Percent.setBounds(350,275,50,20);
        rdb10Percent.setForeground(Color.black);
        rdb10Percent.setBackground(Color.white);
        panelBgImg.add(rdb10Percent);
        
        rdb15Percent = new JRadioButton("15%",false); 
        rdb15Percent.setBounds(410,275,50,20);
        rdb15Percent.setForeground(Color.black);
        rdb15Percent.setBackground(Color.white);
        panelBgImg.add(rdb15Percent);
        
        rdb50Percent = new JRadioButton("50%",false); 
        rdb50Percent.setBounds(460,275,50,20);
        rdb50Percent.setForeground(Color.black);
        rdb50Percent.setBackground(Color.white);
        panelBgImg.add(rdb50Percent);
        
        bgPercent = new ButtonGroup();
        bgPercent.add(rdb10Percent);
        bgPercent.add(rdb15Percent);
        bgPercent.add(rdb50Percent);
        
        btnCompute = new JButton("",imageCompute);
        btnCompute.setBounds(220,310,imageCompute.getIconWidth(),imageCompute.getIconHeight());
        panelBgImg.add(btnCompute);
        
        btnLogout = new JButton("",imageLogout);
        btnLogout.setBounds(380,310,imageLogout.getIconWidth(),imageLogout.getIconHeight());
        panelBgImg.add(btnLogout);
        
        btnBack = new JButton("",imageBack);
        btnBack.setBounds(300,370,imageBack.getIconWidth(),imageBack.getIconHeight());
        panelBgImg.add(btnBack);
        
        }
        public void run(){
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
 /*       public static void main(String[] args){
            Payment pay = new Payment();
            pay.run();
        }*/
}
