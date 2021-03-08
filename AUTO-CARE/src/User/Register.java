/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author PROJECTS
 */
public class Register {
    JFrame frame;
    String opt="coimbatore";
    public void reg(){
    
      frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setUndecorated(true);
      
      double x = 0;
      double y = 0;
      frame.setShape(new RoundRectangle2D.Double(x, y,1200,600, 50, 50));
      frame.setSize(1200, 600);
      frame.setBounds(30,30,1200,600); 
      frame.getContentPane().setBackground(Color.white);
      
      ImageIcon carimg = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img1.png");
      JLabel labelcar = new JLabel(carimg);
      labelcar.setBounds(10,70,500,500); 
      
      
      ImageIcon regimg = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img5.png");
      JLabel labelreg = new JLabel(regimg);
      labelreg.setBounds(500,-20,700,600); 
      
      
      
      Icon registerbtnimg = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img6.png");
      JButton registerbtn = new JButton(registerbtnimg);
      registerbtn.setBorderPainted(false);
      registerbtn.setFocusPainted(false);
      registerbtn.setContentAreaFilled(false);
      registerbtn.setBounds(920,520,200,100); 
      
      JPanel panelback=new JPanel();
      panelback.setLayout(null);
      panelback.setBackground(Color.white);
      panelback.setBounds(0,0,1200,600);
      
      
      
      ArrayList<String> statelist=new ArrayList<String>();
      try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
         Statement st=conn.createStatement();
         String sql = "SELECT state from state;";
         ResultSet rs    = st.executeQuery(sql);           
         while(rs.next()){
                statelist.add(rs.getString("state"));
                
         }
         conn.close();
       }
       catch(Exception e){
                System.out.println("     "+e);
       }
      String[] statearr=new String[statelist.size()];
      statelist.toArray(statearr);
      JComboBox state=new JComboBox(statearr);
      state.setBounds(904,306,240,30); 
      state.setBackground(Color.white);
      JPanel panel=new JPanel();
      panel.setBounds(904,390,240,40);
      panel.setLayout(null);
      panel.setBackground(Color.white);
      
      
      state.addItemListener(new ItemListener() {
          @Override
          public void itemStateChanged(ItemEvent ie) {
               //To change body of generated methods, choose Tools | Templates.
               Component[] components=panel.getComponents();
               for(Component component :components){
               
                 panel.remove(component);
               }
               panel.revalidate();
               panel.repaint();
               String inputdistrict=state.getSelectedItem().toString();
               panel.setVisible(false);
               ArrayList<String> districtlist=new ArrayList<String>();
               try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st=conn.createStatement();
                    String sql = "SELECT district from district where state='"+inputdistrict+"';";
                    ResultSet rs    = st.executeQuery(sql);           
                    while(rs.next()){
                        districtlist.add(rs.getString("district"));
                   }
                    System.out.println("sucess district");
                    System.out.println(districtlist);
                    conn.close();
                }
                catch(Exception e){
                    System.out.println("     "+e);
                }
               String[] districtarr=new String[districtlist.size()];
               districtlist.toArray(districtarr);
               JComboBox district=new JComboBox(districtarr);
               district.setBounds(0,0,210,30);
               district.setBackground(Color.white);
               
               
               district.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent ie) {
                                  //To change body of generated methods, choose Tools | Templates.
                                 opt=district.getSelectedItem().toString();    
                                 System.out.println(opt);
                            }
                });
               
               panel.setBackground(Color.white);
               panel.add(district);
               panelback.updateUI();
               panel.setVisible(true);
               panel.updateUI();
               
          }
      });
      panelback.add(state); 
      
      JTextField tf1=new JTextField();
      JTextField tf2=new JTextField();
      JPasswordField tf3=new JPasswordField();
      JPasswordField tf4=new JPasswordField();
      JTextField tf5=new JTextField();      
      JTextField tf6=new JTextField();
      JTextField tf7=new JTextField();      
      JTextField tf8=new JTextField();
      
      tf1.setBounds(600,227,210,30);  
      tf2.setBounds(600,303,210,30); 
      tf3.setBounds(540,385,100,30);
      tf4.setBounds(700,385,100,30);
      tf5.setBounds(560,471,240,30);      
      tf6.setBounds(904,142,240,30);
      tf7.setBounds(904,227,240,30);       
      tf8.setBounds(904,471,240,30);
      
      
      tf1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tf2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tf3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tf4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tf5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tf6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tf7.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tf8.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      
      
      tf1.setBackground(new Color(240,240,240));
      tf2.setBackground(new Color(240,240,240));
      tf3.setBackground(new Color(240,240,240));
      tf4.setBackground(new Color(240,240,240));
      tf5.setBackground(new Color(240,240,240));
      tf6.setBackground(new Color(240,240,240));
      tf7.setBackground(new Color(240,240,240));
      tf8.setBackground(new Color(240,240,240));
      
      
      
      panelback.add(tf1);
      panelback.add(tf2);
      panelback.add(tf3);
      panelback.add(tf4);
      panelback.add(tf5);
      panelback.add(tf6);
      panelback.add(tf7);
      panelback.add(tf8);
      
      
      
      
      
      
      panelback.add(labelcar);
      panelback.add(labelreg);
      panelback.add(registerbtn);
      
      
      registerbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 Pattern p1=Pattern.compile("[^A-Za-z]");
                 Matcher m1=p1.matcher(tf1.getText().toString());
                 boolean tf1b=m1.find();
                 
                 Pattern p2=Pattern.compile("[^0-9]");
                 Matcher m2=p2.matcher(tf5.getText().toString());
                 boolean tf5b=m2.find();
                 
                 
                 
                 Pattern p5=Pattern.compile("[^0-9]");
                 Matcher m5=p5.matcher(tf5.getText().toString());
                 boolean tf8b=m2.find();
                 
                 boolean error=false;
                 if(tf1b){
                     Error e=new Error();
                     e.errordis("Name cannot contain special character","Pls change it");
                     error=true;
                 }
                 else if(tf5b){
                     Error e=new Error();
                     e.errordis("Mobileno can contain only digits","Pls change it");
                     error=true;
                 }
                 else if(tf5.getText().toString().length()!=10){
                     Error e=new Error();
                     e.errordis("Mobileno should be 10 digits","Pls change it"); 
                     error=true;
                 }
                 
                 else if(tf8b){
                     Error e=new Error();
                     e.errordis("Pincode can contain only numbers","Pls change it");   
                 }
                 else if(tf8.getText().toString().length()!=6){
                     Error e=new Error();
                     e.errordis("Pincode should be 6 digits","Pls change it"); 
                     error=true;
                 }
                 else if(!(new String(tf3.getPassword()).equals(new String(tf4.getPassword())))){
                     Error e=new Error();
                     e.errordis("Passwords are not matched","Check it");
                     error=true;
                 }
                 else if(tf1.getText().isEmpty()||tf2.getText().isEmpty()||tf3.getPassword().toString().isEmpty()||tf4.getPassword().toString().isEmpty()||tf5.getText().isEmpty()||tf6.getText().isEmpty()||tf7.getText().isEmpty()||tf8.getText().isEmpty()){
                     Error e=new Error();
                     e.errordis("Enter all fields","Check it");
                     error=true;
                 }
                 //else if()
                        // {
                             
                         //}
                 else{
                    boolean empty=true;
                    try{
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       String sql = "select username from users where username='"+tf2.getText().toString()+"';";
                       ResultSet rs    = st.executeQuery(sql);           
                       while(rs.next()){
                           empty=false;
                           System.out.println("alreadyexist");
                       }                     
                       conn.close();
                     }
                    catch(Exception e){
                      System.out.println("     "+e);
                    }
                    if(!empty){
                       Error e=new Error();
                       e.errordis("Username already exists","Pls change it"); 
                       error=true;
                    }
                 }
                 if(error==false){
                     try{
                       Class.forName("com.mysql.jdbc.Driver");
                       String pass=new String(tf3.getPassword());
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       String s="insert into users(name,username,password,mobileno,address1,address2,district,state,pincode,status) values('"+tf1.getText().toString()+"','"+tf2.getText().toString()+"','"+pass+"','"+tf5.getText().toString()+"','"+tf6.getText().toString()+"','"+tf7.getText().toString()+"','"+opt+"','"+state.getSelectedItem().toString()+"','"+tf8.getText().toString()+"','active')";
                       st.executeUpdate(s);
                       System.out.println("Success!");
                       messagebox m=new messagebox();
                       m.message();
                       conn.close();
                     }
                    catch(Exception e){
                      System.out.println("     "+e);
                    }
                 
                 }
                 
                 
                 
                 
            }
        });
      
      
      
      
      frame.add(panel);
      frame.add(panelback);
      
      frame.setLayout(null);
      frame.setVisible(true);
    
    }
    public static void main(String[] args){
       Register r=new Register();
       r.reg();
    }
    
    public class messagebox {
    
     public void message(){
    
       JFrame frame1 = new JFrame();
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.setUndecorated(true);
      
      double x = 0;
      double y = 0;
      frame1.setShape(new RoundRectangle2D.Double(x, y,400,200, 50, 50));
      frame1.setSize(400, 200);
      frame1.setBounds(600,250,400,200); 
      frame1.getContentPane().setBackground(new Color(160,237,240));
      
      Icon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img8.png");
      JButton b = new JButton(icons);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(190,70,200,100); 
      frame1.add(b);
      
      ImageIcon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img7.png");
      JLabel labels = new JLabel(icon);
      labels.setBounds(3,15,350,150); 
      frame1.add(labels);
      
      b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Screen s=new Screen();
                s.scr();
                frame1.setVisible(false);
                frame.setVisible(false);
                
            }            
        });
      
      
        frame1.setLayout(null);
        frame1.setVisible(true);
        }
    
    
    }
    
}
