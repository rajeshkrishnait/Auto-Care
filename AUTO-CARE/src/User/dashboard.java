/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

/**
 *
 * @author PROJECTS
 */
import java.sql.Timestamp;
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
import java.time.Instant;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;

/**
 *
 * @author PROJECTS
 */
public class dashboard {
    
    String serviceinput="";
    String dateinput="";
    String timeinput="";
    String vehmodelinput="";
    
    String vehmodelinputass="";
    int totalitemscart=0;
    String productnameinputcan="";
    public void dash(int userid){
        
      
      
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setUndecorated(true);
      
      double x = 0;
      double y = 0;
      frame.setShape(new RoundRectangle2D.Double(x, y,1200,600, 50, 50));
      frame.setSize(1200, 600);
      frame.setBounds(30,30,1200,600); 
      frame.getContentPane().setBackground(Color.white);
      
      
      //Design buttons
      
      Icon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img12.png");
      JButton b = new JButton(icon);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(-50,30,250,100); 
      frame.add(b);
      
      
      
      Icon icon1 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img13.png");
      JButton b1 = new JButton(icon1);
      b1.setBorderPainted(false);
      b1.setFocusPainted(false);
      b1.setContentAreaFilled(false);
      b1.setBounds(-50,100,250,100); 
      frame.add(b1);
      
      Icon icon2 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img15.png");
      JButton b2= new JButton(icon2);
      b2.setBorderPainted(false);
      b2.setFocusPainted(false);
      b2.setContentAreaFilled(false);
      b2.setBounds(-50,170,250,100); 
      frame.add(b2);
      
      Icon icon3 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img17.png");
      JButton b3 = new JButton(icon3);
      b3.setBorderPainted(false);
      b3.setFocusPainted(false);
      b3.setContentAreaFilled(false);
      b3.setBounds(-50,240,250,100); 
      frame.add(b3);
      
      Icon icon8 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img44.png");
      JButton b4 = new JButton(icon8);
      b4.setBorderPainted(false);
      b4.setFocusPainted(false);
      b4.setContentAreaFilled(false);
      b4.setBounds(-50,310,250,100); 
      frame.add(b4);
      
      Icon icon10 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img49.png");
      JButton b5 = new JButton(icon10);
      b5.setBorderPainted(false);
      b5.setFocusPainted(false);
      b5.setContentAreaFilled(false);
      b5.setBounds(-50,500,250,100); 
      frame.add(b5);
      
      b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                frame.setVisible(false);
                Screen s=new Screen();
                s.scr();
                
            }            
        });
      
      ImageIcon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img19.png");
      JLabel label = new JLabel(icons);
      label.setBounds(0,0,150,800); 
      frame.add(label);
      
      
      
      Icon icon4 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img11.png");
      Icon icon5 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img14.png");
      Icon icon6 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img16.png");
      Icon icon7 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img18.png");
      Icon icon9 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img45.png");
      
      
     
      
      
      //Dashboard start
      JPanel dashboard=new JPanel();
      dashboard.setBackground(Color.white);
      
      dashboard.setLayout(null);  
      dashboard.setBounds(150,0,1150,600);
      
      ImageIcon iconprofile = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img29.png");
      JLabel labelprofile = new JLabel(iconprofile);
      labelprofile.setBounds(-50,10,700,500); 
      
      ImageIcon icondashapp = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img31.png");
      JLabel labeldashapp = new JLabel(icondashapp);
      labeldashapp.setBounds(450,-80,700,500); 
      
      ImageIcon icondaass = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img30.png");
      JLabel labeldashass = new JLabel(icondaass);
      labeldashass.setBounds(450,150,700,500); 
     
            
       try
       {
       Class.forName("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
       Statement st=conn.createStatement();
        String sql = "SELECT username,mobileno,name,address1,address2,district,state,pincode FROM users where userid='"+userid+"'";
        ResultSet rs    = st.executeQuery(sql);   
        JLabel username;  
        JLabel mobileno;
        JLabel name;
        JLabel address1;
        JLabel address2;
        JLabel district;
        JLabel state;
        JLabel pincode;
        
        
        while(rs.next()){
           
           username=new JLabel(rs.getString("username"));
           username.setBounds(320,8,200,70); 
           username.setBorder(javax.swing.BorderFactory.createEmptyBorder());
           username.setBackground(new Color(217,217,217));
           dashboard.add(username);
           
           mobileno=new JLabel(rs.getString("mobileno"));
           mobileno.setBounds(320,60,200,70); 
           mobileno.setBorder(javax.swing.BorderFactory.createEmptyBorder());
           mobileno.setBackground(new Color(217,217,217));
           dashboard.add(mobileno);
           
           name=new JLabel(rs.getString("name"));
           name.setBounds(210,140,200,70); 
           name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
           name.setBackground(new Color(217,217,217));
           dashboard.add(name);
           
           address1=new JLabel(rs.getString("address1"));
           address1.setBounds(210,200,200,70); 
           address1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
           address1.setBackground(new Color(217,217,217));
           dashboard.add(address1);
           
           address2=new JLabel(rs.getString("address2"));
           address2.setBounds(210,240,200,70); 
           address2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
           address2.setBackground(new Color(217,217,217));
           dashboard.add(address2);
           
           district=new JLabel(rs.getString("district"));
           district.setBounds(110,330,200,70); 
           district.setBorder(javax.swing.BorderFactory.createEmptyBorder());
           district.setBackground(new Color(217,217,217));
           dashboard.add(district);
           
           state=new JLabel(rs.getString("state"));
           state.setBounds(350,330,200,70); 
           state.setBorder(javax.swing.BorderFactory.createEmptyBorder());
           state.setBackground(new Color(217,217,217));
           dashboard.add(state);
           
           pincode=new JLabel(rs.getString("pincode"));
           pincode.setBounds(110,420,200,70); 
           pincode.setBorder(javax.swing.BorderFactory.createEmptyBorder());
           pincode.setBackground(new Color(217,217,217));
           dashboard.add(pincode);
           
           
           
           
        }
        JTextArea apptablet1;
        JTextArea apptablet2;
        JTextArea apptablet3;
        JTextArea apptablet4;
        
        
        String s = "SELECT appointmentid,name,date,id from appointments a JOIN admin ad ON a.adminid=ad.adminid where userid='"+userid+"' and status!='Declined' and status!='cancelled' and status!='OutForDelivery'";
        ResultSet r    = st.executeQuery(s); 
        String t1="";
        String t2="";
        String t3="";
        String t4="";
        
        apptablet1=new JTextArea("");
        apptablet1.setBounds(600,120,20,100); 
        apptablet1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        apptablet1.setBackground(new Color(255,230,133));
        apptablet1.setEditable(false);
        
        
        apptablet2=new JTextArea("");
        apptablet2.setBounds(655,120,150,100); 
        apptablet2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        apptablet2.setBackground(new Color(255,230,133));
        apptablet2.setEditable(false);
        
        
        apptablet3=new JTextArea("");
        apptablet3.setBounds(850,120,70,100); 
        apptablet3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        apptablet3.setBackground(new Color(255,230,133));
        apptablet3.setEditable(false);
        
        
        apptablet4=new JTextArea("");
        apptablet4.setBounds(950,120,70,100); 
        apptablet4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        apptablet4.setBackground(new Color(255,230,133));
        apptablet4.setEditable(false);
        
        
        while(r.next()){
           t1=t1+"\n"+r.getString("appointmentid");
           t2=t2+"\n"+r.getString("name");
           t3=t3+"\n"+r.getString("date");
           t4=t4+"\n"+r.getString("id").substring(0,8);
        }
        apptablet1.setText(t1);
        apptablet2.setText(t2);
        apptablet3.setText(t3);
        apptablet4.setText(t4);
        
        dashboard.add(apptablet1);
        dashboard.add(apptablet2);
        dashboard.add(apptablet3);
        dashboard.add(apptablet4);
        
        
        JTextArea asstablet1;
        JTextArea asstablet2;
        JTextArea asstablet3;
        JTextArea asstablet4;
        
        
        String s1 = "select assistid,name,workername,workermobileno from assist a join workers w ON a.workerid=w.workerid join admin ad ON ad.adminid=w.adminid  where userid='"+userid+"' and status='Approved'";
        ResultSet r1    = st.executeQuery(s1); 
        String ta1="";
        String ta2="";
        String ta3="";
        String ta4="";
        
        asstablet1=new JTextArea("");
        asstablet1.setBounds(600,380,20,50); 
        asstablet1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet1.setBackground(new Color(255, 197, 232));
        asstablet1.setEditable(false);
        
        
        asstablet2=new JTextArea("");
        asstablet2.setBounds(655,380,150,50); 
        asstablet2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet2.setBackground(new Color(255,197,232));
        asstablet2.setEditable(false);
        
        
        asstablet3=new JTextArea("");
        asstablet3.setBounds(850,380,70,50); 
        asstablet3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet3.setBackground(new Color(255,197,232));
        asstablet3.setEditable(false);
        
        
        asstablet4=new JTextArea("");
        asstablet4.setBounds(950,380,70,50); 
        asstablet4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet4.setBackground(new Color(255,197,232));
        asstablet4.setEditable(false);
        
        
        while(r1.next()){
           ta1=ta1+"\n"+r1.getString("assistid");
           ta2=ta2+"\n"+r1.getString("name");
           ta3=ta3+"\n"+r1.getString("workername");
           ta4=ta4+"\n"+r1.getString("workermobileno");
        }
        asstablet1.setText(ta1);
        asstablet2.setText(ta2);
        asstablet3.setText(ta3);
        asstablet4.setText(ta4);
        
        dashboard.add(asstablet1);
        dashboard.add(asstablet2);
        dashboard.add(asstablet3);
        dashboard.add(asstablet4);
           
        
       
        conn.close();
       }
       catch(Exception e)
       {
        System.out.println("     "+e);
       }
       Icon iconclose = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img57.png");
      JButton close= new JButton(iconclose);
      close.setBorderPainted(false);
      close.setFocusPainted(false);
      close.setContentAreaFilled(false);
      close.setBounds(670,500,250,100);
     
      close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                frame.setVisible(false);
                table d=new table();
                d.tables(userid);
               
            }            
        });
     
      dashboard.add(close);

       
                
      
      dashboard.add(labeldashass);
      dashboard.add(labeldashapp);
      dashboard.add(labelprofile);
      
      dashboard.setVisible(true);
      frame.add(dashboard);
      //dashboard end
      
      //panel order
      
      JPanel order = new JPanel();
      order.setBackground(Color.white);
      
      order.setLayout(null);  
      order.setBounds(150,0,1150,600);
      
     
       
       order.setVisible(false);
       frame.add(order);
      
      
      
      //panel order end
      
      
      //panel schedule
      
      JPanel schedule = new JPanel();
      schedule.setBackground(Color.white);
      
      
      schedule.setLayout(null);  
      schedule.setBounds(150,0,1150,600);
           
      schedule.setVisible(false);
      frame.add(schedule);
      //panel schedule end
      
      
      
      //panel cancel start
      
      JPanel cancel = new JPanel();
      cancel.setBackground(Color.white);
      cancel.setLayout(null);  
      cancel.setBounds(150,0,1150,600);
      
      
      
      cancel.setVisible(false);
      frame.add(cancel);
      //panel cancel end

      
      
      //panel vieworder
      JPanel vieworder = new JPanel();
      vieworder.setBackground(Color.white);
      vieworder.setLayout(null);  
      vieworder.setBounds(150,0,1150,600);
      
       
      vieworder.setVisible(false);
      frame.add(vieworder);
      
      
      //panel vieworder end
      
       b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                dashboard.removeAll();
                dashboard.revalidate();
                dashboard.repaint();
                dashboard.setVisible(true);
                
                b.setIcon(icon);
                b1.setIcon(icon1);
                b2.setIcon(icon2);
                b3.setIcon(icon3);
                b4.setIcon(icon8);
                
                ImageIcon iconprofile = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img29.png");
                JLabel labelprofile = new JLabel(iconprofile);
                labelprofile.setBounds(-50,10,700,500); 
      
                ImageIcon icondashapp = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img31.png");
                JLabel labeldashapp = new JLabel(icondashapp);
                labeldashapp.setBounds(450,-80,700,500); 
      
               ImageIcon icondaass = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img30.png");
               JLabel labeldashass = new JLabel(icondaass);
               labeldashass.setBounds(450,150,700,500); 
            
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st=conn.createStatement();
                    String sql = "SELECT username,mobileno,name,address1,address2,district,state,pincode FROM users where userid='"+userid+"'";
                    ResultSet rs    = st.executeQuery(sql);   
                    JLabel username;  
                    JLabel mobileno;
                    JLabel name;
                    JLabel address1;
                    JLabel address2;
                    JLabel district;
                    JLabel state;
                    JLabel pincode;
        
                    while(rs.next()){
                        username=new JLabel(rs.getString("username"));
                        username.setBounds(320,8,200,70); 
                        username.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        username.setBackground(new Color(217,217,217));
                        dashboard.add(username);
           
                        mobileno=new JLabel(rs.getString("mobileno"));
                        mobileno.setBounds(320,60,200,70); 
                        mobileno.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        mobileno.setBackground(new Color(217,217,217));
                        dashboard.add(mobileno);
           
                        name=new JLabel(rs.getString("name"));
                        name.setBounds(210,140,200,70); 
                        name.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        name.setBackground(new Color(217,217,217));
                        dashboard.add(name);
           
                        address1=new JLabel(rs.getString("address1"));
                        address1.setBounds(210,200,200,70); 
                        address1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        address1.setBackground(new Color(217,217,217));
                        dashboard.add(address1);
           
                        address2=new JLabel(rs.getString("address2"));
                        address2.setBounds(210,240,200,70); 
                        address2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        address2.setBackground(new Color(217,217,217));
                        dashboard.add(address2);
           
                        district=new JLabel(rs.getString("district"));
                        district.setBounds(110,330,200,70); 
                        district.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        district.setBackground(new Color(217,217,217));
                        dashboard.add(district);
           
                        state=new JLabel(rs.getString("state"));
                        state.setBounds(350,330,200,70); 
                        state.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        state.setBackground(new Color(217,217,217));
                        dashboard.add(state);
           
                        pincode=new JLabel(rs.getString("pincode"));
                        pincode.setBounds(110,420,200,70); 
                        pincode.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                        pincode.setBackground(new Color(217,217,217));
                        dashboard.add(pincode);           
                    }
                    JTextArea apptablet1;
                    JTextArea apptablet2;
                    JTextArea apptablet3;
                    JTextArea apptablet4;        
                    String s = "SELECT appointmentid,name,date,id from appointments a JOIN admin ad ON a.adminid=ad.adminid where userid='"+userid+"' and status!='Declined' and status!='cancelled' and status!='OutForDelivery'";
                    ResultSet r    = st.executeQuery(s); 
                    String t1="";
                    String t2="";
                    String t3="";
                    String t4="";
        
                    apptablet1=new JTextArea("");
                    apptablet1.setBounds(600,120,20,100); 
                    apptablet1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    apptablet1.setBackground(new Color(255,230,133));
                    apptablet1.setEditable(false);
        
        
                    apptablet2=new JTextArea("");
                    apptablet2.setBounds(655,120,150,100); 
                    apptablet2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    apptablet2.setBackground(new Color(255,230,133));
                    apptablet2.setEditable(false);
        
        
                    apptablet3=new JTextArea("");
                    apptablet3.setBounds(850,120,70,100); 
                    apptablet3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    apptablet3.setBackground(new Color(255,230,133));
                    apptablet3.setEditable(false);
        
        
                    apptablet4=new JTextArea("");
                    apptablet4.setBounds(950,120,70,100); 
                    apptablet4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    apptablet4.setBackground(new Color(255,230,133));
                    apptablet4.setEditable(false);
                    
                    while(r.next()){
                          t1=t1+"\n"+r.getString("appointmentid");
                          t2=t2+"\n"+r.getString("name");
                          t3=t3+"\n"+r.getString("date");
                          t4=t4+"\n"+r.getString("id").substring(0,8);
                    }
                    apptablet1.setText(t1);
                    apptablet2.setText(t2);
                    apptablet3.setText(t3);
                    apptablet4.setText(t4);
        
                    dashboard.add(apptablet1);
                    dashboard.add(apptablet2);
                    dashboard.add(apptablet3);
                    dashboard.add(apptablet4);
                    
                    JTextArea asstablet1;
                    JTextArea asstablet2;
                    JTextArea asstablet3;
                    JTextArea asstablet4;
        
        
                    String s1 = "select assistid,name,workername,workermobileno from assist a join workers w ON a.workerid=w.workerid join admin ad ON ad.adminid=w.adminid  where userid='"+userid+"' and status='Approved'";
                    ResultSet r1    = st.executeQuery(s1); 
                    String ta1="";
                    String ta2="";
                    String ta3="";
                    String ta4="";
        
                    asstablet1=new JTextArea("");
                    asstablet1.setBounds(600,380,20,50); 
                    asstablet1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    asstablet1.setBackground(new Color(255, 197, 232));
                    asstablet1.setEditable(false);
        
        
                    asstablet2=new JTextArea("");
                    asstablet2.setBounds(655,380,150,50); 
                    asstablet2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    asstablet2.setBackground(new Color(255,197,232));
                    asstablet2.setEditable(false);
        
        
                    asstablet3=new JTextArea("");
                    asstablet3.setBounds(850,380,70,50); 
                    asstablet3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    asstablet3.setBackground(new Color(255,197,232));
                    asstablet3.setEditable(false);
        
        
                    asstablet4=new JTextArea("");
                    asstablet4.setBounds(950,380,70,50); 
                    asstablet4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                    asstablet4.setBackground(new Color(255,197,232));
                    asstablet4.setEditable(false);
        
        
                    while(r1.next()){
                        ta1=ta1+"\n"+r1.getString("assistid");
                        ta2=ta2+"\n"+r1.getString("name");
                        ta3=ta3+"\n"+r1.getString("workername");
                        ta4=ta4+"\n"+r1.getString("workermobileno");
                    }
                    asstablet1.setText(ta1);
                    asstablet2.setText(ta2);
                    asstablet3.setText(ta3);
                    asstablet4.setText(ta4);
        
                    dashboard.add(asstablet1);
                    dashboard.add(asstablet2);
                    dashboard.add(asstablet3);
                    dashboard.add(asstablet4);
           
                    
                    conn.close();
                }
                catch(Exception e)
                {
                    System.out.println("     "+e);
                }
                Icon iconclose = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img57.png");
      JButton close= new JButton(iconclose);
      close.setBorderPainted(false);
      close.setFocusPainted(false);
      close.setContentAreaFilled(false);
      close.setBounds(670,500,250,100);
     
      close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               
                frame.setVisible(false);
                table d=new table();
                d.tables(userid);
               
            }            
        });
     
      dashboard.add(close);

                
                dashboard.add(labeldashass);
                dashboard.add(labeldashapp);
                dashboard.add(labelprofile);
                
                
                
               dashboard.updateUI();
               dashboard.setVisible(true);
               schedule.setVisible(false);
               cancel.setVisible(false);
               order.setVisible(false);
               vieworder.setVisible(false);
            }
        });
      
      b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 b.setIcon(icon4);
                 b1.setIcon(icon5);
                 b2.setIcon(icon2);
                 b3.setIcon(icon3);
                 b4.setIcon(icon8);
                 
                order.removeAll();
                order.revalidate();
                order.repaint();
                order.setVisible(true);
                 
                JPanel item1=new JPanel();
                item1.setBackground(new Color(255, 222, 89));
                item1.setLayout(null);
                item1.setBounds(450,150,450,50);
                JCheckBox c1=new JCheckBox(); 
                c1.setBackground(new Color(255, 222, 89));
                c1.setForeground(Color.white);
                JLabel itemt1id=new JLabel("-");   
                JLabel itemt1name=new JLabel("-");
                JLabel itemt1quantity=new JLabel("-");
                JLabel itemt1price=new JLabel("-");
                JLabel itemt1total=new JLabel("-");       
                c1.setBounds(0,0,50,50);
                itemt1id.setBounds(50,0,300,50);
                itemt1name.setBounds(90,0,300,50);
                itemt1quantity.setBounds(180,0,300,50);
                itemt1price.setBounds(270,0,300,50);
                itemt1total.setBounds(360,0,300,50);
                item1.add(c1);
                item1.add(itemt1id);
                item1.add(itemt1name);
                item1.add(itemt1quantity);
                item1.add(itemt1price);
                item1.add(itemt1total);
                order.add(item1);
       
                JPanel item2=new JPanel();
                item2.setBackground(new Color(255, 222, 89));
                item2.setLayout(null);
                item2.setBounds(450,200,450,50);
                JCheckBox c2=new JCheckBox(); 
                c2.setBackground(new Color(255, 222, 89));
                c2.setForeground(Color.white);
                JLabel itemt2id=new JLabel("-");   
                JLabel itemt2name=new JLabel("-");
                JLabel itemt2quantity=new JLabel("-");
                JLabel itemt2price=new JLabel("-");
                JLabel itemt2total=new JLabel("-");       
                c2.setBounds(0,0,50,50);
                itemt2id.setBounds(50,0,300,50);
                itemt2name.setBounds(90,0,300,50);
                itemt2quantity.setBounds(180,0,300,50);
                itemt2price.setBounds(270,0,300,50);
                itemt2total.setBounds(360,0,300,50);
                item2.add(c2);
                item2.add(itemt2id);
                item2.add(itemt2name);
                item2.add(itemt2quantity);
                item2.add(itemt2price);
                item2.add(itemt2total);
                order.add(item2);
       
                JPanel item3=new JPanel();
                item3.setBackground(new Color(255, 222, 89));
                item3.setLayout(null);
                item3.setBounds(450,250,450,50);
                JCheckBox c3=new JCheckBox(); 
                c3.setBackground(new Color(255, 222, 89));
                c3.setForeground(Color.white);
                JLabel itemt3id=new JLabel("-");   
                JLabel itemt3name=new JLabel("-");
                JLabel itemt3quantity=new JLabel("-");
                JLabel itemt3price=new JLabel("-");
                JLabel itemt3total=new JLabel("-");       
                c3.setBounds(0,0,50,50);
                itemt3id.setBounds(50,0,300,50);
                itemt3name.setBounds(90,0,300,50);
                itemt3quantity.setBounds(180,0,300,50);
                itemt3price.setBounds(270,0,300,50);
                itemt3total.setBounds(360,0,300,50);
                item3.add(c3);
                item3.add(itemt3id);
                item3.add(itemt3name);
                item3.add(itemt3quantity);
                item3.add(itemt3price);
                item3.add(itemt3total);
                order.add(item3);
      
       
                JPanel item4=new JPanel();
                item4.setBackground(new Color(255, 222, 89));
                item4.setLayout(null);
                item4.setBounds(450,300,450,50);
                JCheckBox c4=new JCheckBox(); 
                c4.setBackground(new Color(255, 222, 89));
                c4.setForeground(Color.white);
                JLabel itemt4id=new JLabel("-");   
                JLabel itemt4name=new JLabel("-");
                JLabel itemt4quantity=new JLabel("-");
                JLabel itemt4price=new JLabel("-");
                JLabel itemt4total=new JLabel("-");       
                c4.setBounds(0,0,50,50);
       itemt4id.setBounds(50,0,300,50);
       itemt4name.setBounds(90,0,300,50);
       itemt4quantity.setBounds(180,0,300,50);
       itemt4price.setBounds(270,0,300,50);
       itemt4total.setBounds(360,0,300,50);
       item4.add(c4);
       item4.add(itemt4id);
       item4.add(itemt4name);
       item4.add(itemt4quantity);
       item4.add(itemt4price);
       item4.add(itemt4total);
       order.add(item4);
       
       JPanel item5=new JPanel();
       item5.setBackground(new Color(255, 222, 89));
       item5.setLayout(null);
       item5.setBounds(450,350,450,50);
       JCheckBox c5=new JCheckBox(); 
       c5.setBackground(new Color(255, 222, 89));
       c5.setForeground(Color.white);
       JLabel itemt5id=new JLabel("-");   
       JLabel itemt5name=new JLabel("-");
       JLabel itemt5quantity=new JLabel("-");
       JLabel itemt5price=new JLabel("-");
       JLabel itemt5total=new JLabel("-");       
       c5.setBounds(0,0,50,50);
       itemt5id.setBounds(50,0,300,50);
       itemt5name.setBounds(90,0,300,50);
       itemt5quantity.setBounds(180,0,300,50);
       itemt5price.setBounds(270,0,300,50);
       itemt5total.setBounds(360,0,300,50);
       item5.add(c5);
       item5.add(itemt5id);
       item5.add(itemt5name);
       item5.add(itemt5quantity);
       item5.add(itemt5price);
       item5.add(itemt5total);
       order.add(item5);
       
       JPanel item6=new JPanel();
       item6.setBackground(new Color(255, 222, 89));
       item6.setLayout(null);
       item6.setBounds(450,400,450,50);
       
       
       JLabel itemt6total=new JLabel("0");       
       JLabel itemt6price=new JLabel("Total:");
       itemt6price.setBounds(270,0,300,50);
       itemt6total.setBounds(360,0,300,50);
       item6.add(itemt6price);
       item6.add(itemt6total);
       order.add(item6);
       
       
       
       item1.setVisible(false);
       item2.setVisible(false);
       item3.setVisible(false);
       item4.setVisible(false);
       item5.setVisible(false);
       item6.setVisible(false);
      
      ImageIcon iconord = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img37.png");
      JLabel labelord = new JLabel(iconord);
      labelord.setBounds(-150,0,700,500); 
      
      ArrayList<String> productlist=new ArrayList<String>();
      ArrayList<String> productstock=new ArrayList<String>();
      ArrayList<String> productprize=new ArrayList<String>();
      ArrayList<String> productid=new ArrayList<String>();
      productlist.add("-");
      productstock.add("0");
      productprize.add("0");
      productid.add("0");
      try{
         Class.forName("com.mysql.jdbc.Driver");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
         Statement st=conn.createStatement();
         String sql = "SELECT * FROM items";
         ResultSet rs    = st.executeQuery(sql);           
         while(rs.next()){
             productid.add(rs.getString("productid"));
             productlist.add(rs.getString("productname"));   
             productstock.add(rs.getString("stock"));  
             productprize.add(rs.getString("price"));
        }
        conn.close();
       }
       catch(Exception e){
         System.out.println("     "+e);
       }
       String[] productarr=new String[productlist.size()];
       productlist.toArray(productarr);
       JComboBox product=new JComboBox(productarr);
       product.setBounds(190,120,120,30); 
       product.setBackground(Color.white);
      
       JLabel orderprize=new JLabel();
       JLabel orderavailable=new JLabel();
       orderprize.setBounds(190,190,120,30);
       orderavailable.setBounds(190,240,120,30);
       orderprize.setText("-");
       orderavailable.setText("-");
       
       JTextField quan=new JTextField(); 
       quan.setBounds(210,315,50,20); 
       quan.setBorder(javax.swing.BorderFactory.createEmptyBorder());
       quan.setBackground(new Color(217,217,217));  
       
      Icon iconaddtocart = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img40.png");
      JButton btnaddtocart= new JButton(iconaddtocart);
      btnaddtocart.setBorderPainted(false);
      btnaddtocart.setFocusPainted(false);
      btnaddtocart.setContentAreaFilled(false);
      btnaddtocart.setBounds(100,350,250,100); 
      
      Icon iconremovetocart = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img41.png");
      JButton btnremovetocart= new JButton(iconremovetocart);
      btnremovetocart.setBorderPainted(false);
      btnremovetocart.setFocusPainted(false);
      btnremovetocart.setContentAreaFilled(false);
      btnremovetocart.setBounds(450,500,250,100); 
      
      Icon iconconfirmtocart = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img42.png");
      JButton btnconfirmtocart= new JButton(iconconfirmtocart);
      btnconfirmtocart.setBorderPainted(false);
      btnconfirmtocart.setFocusPainted(false);
      btnconfirmtocart.setContentAreaFilled(false);
      btnconfirmtocart.setBounds(650,500,250,100); 
       
       JPanel cart=new JPanel();
       cart.setBackground(Color.white);
       cart.setLayout(null);
      
       
       
       
       ImageIcon carts = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img38.png");
       JLabel cartlb = new JLabel(carts);
       cartlb.setBounds(0,0,700,500);
       cartlb.setLayout(null);  
       cart.setBounds(320,0,800,800);
       cart.add(cartlb);
       
       
       
       
       product.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent ie) {
                    //To change body of generated methods, choose Tools | Templates.
                    String prize=productprize.get(productlist.indexOf(product.getSelectedItem().toString()));        
                    String available=productstock.get(productlist.indexOf(product.getSelectedItem().toString()));
                    orderprize.setText(prize);
                    orderavailable.setText(available);
                }
       });
       
       
       
     btnaddtocart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.out.println("working");
                    String productname=product.getSelectedItem().toString();
                    String price=orderprize.getText().toString();
                    String available=orderavailable.getText().toString();
                    String quantity=quan.getText().toString();
                    String total=String.valueOf(Integer.parseInt(quantity)*Integer.parseInt(price));
                    int totalnum=Integer.parseInt(quantity)*Integer.parseInt(price);
                    int totalvalue=Integer.parseInt(itemt6total.getText())+totalnum;
                    String totalvaluestring=String.valueOf(totalvalue);
                    if(productname.equals('-')){
                       Error e=new Error();
                       e.errordis("Choose product","Check again");                    
                    }
                    else if(productname.equals(itemt1name.getText().toString())||productname.equals(itemt2name.getText().toString())||productname.equals(itemt3name.getText().toString())||productname.equals(itemt4name.getText().toString())||productname.equals(itemt5name.getText().toString())){
                       Error e=new Error();
                       e.errordis("Sorry product is already entered","again");  
                    
                    }
                    else if(totalitemscart>=5){
                       Error e=new Error();
                       e.errordis("Cart is full","Cant add items"); 
                    }
                    else if((Integer.parseInt(quantity)>Integer.parseInt(available) )|| (Integer.parseInt(quantity)==0)){
                        Error e=new Error();
                       e.errordis("Stock not available","Can't add items");     
                    }
                    else{
                       if(totalitemscart==0){
                           
                            itemt1id.setText("1");
                            itemt1name.setText(productname);
                            itemt1quantity.setText(quantity);
                            itemt1price.setText(price);
                            itemt1total.setText(total);
                            
                            item1.setVisible(true);
                            
                            itemt6total.setText(totalvaluestring);
                            item6.setVisible(true);
                            
                            System.out.println("cart1");
                            order.repaint();
                            order.updateUI();
                            totalitemscart=totalitemscart+1;
                       }
                       else if(totalitemscart==1){
                            itemt2id.setText("2");
                            itemt2name.setText(productname);
                            itemt2quantity.setText(quantity);
                            itemt2price.setText(price);
                            itemt2total.setText(total);                            
                        
                            item1.setVisible(true);
                            item2.setVisible(true);
                            
                            itemt6total.setText(totalvaluestring);
                            item6.setVisible(true);
                            
                            System.out.println("cart1");
                            order.repaint();
                            order.updateUI();
                            totalitemscart=totalitemscart+1;
                       }
                       else if(totalitemscart==2){
                            itemt3id.setText("3");
                            itemt3name.setText(productname);
                            itemt3quantity.setText(price);
                            itemt3price.setText(quantity);
                            itemt3total.setText(total);
                            
                            item1.setVisible(true);
                            item2.setVisible(true);
                            item3.setVisible(true);
                            
                            itemt6total.setText(totalvaluestring);
                            item6.setVisible(true);
                            
                            System.out.println("cart1");
                            order.repaint();
                            order.updateUI();
                            totalitemscart=totalitemscart+1;
                       }
                       else if(totalitemscart==3){
                            itemt4id.setText("4");
                            itemt4name.setText(productname);
                            itemt4quantity.setText(quantity);
                            itemt4price.setText(price);
                            itemt4total.setText(total);
                            
                            item1.setVisible(true);
                            item2.setVisible(true);
                            item3.setVisible(true);
                            item4.setVisible(true);
                            
                            itemt6total.setText(totalvaluestring);
                            item6.setVisible(true);
                            
                            System.out.println("cart1");
                            order.repaint();
                            order.updateUI();
                            totalitemscart=totalitemscart+1;
                       }
                       else if(totalitemscart==4){
                            itemt5id.setText("5");
                            itemt5name.setText(productname);
                            itemt5quantity.setText(quantity);
                            itemt5price.setText(price);
                            itemt5total.setText(total);
                            
                            item1.setVisible(true);
                            item2.setVisible(true);
                            item3.setVisible(true);
                            item4.setVisible(true);
                            item5.setVisible(true);
                            
                            itemt6total.setText(totalvaluestring);
                            item6.setVisible(true);
                            
                            System.out.println("cart1");
                            order.repaint();
                            order.updateUI();
                            totalitemscart=totalitemscart+1;
                       }
                       
                    }
                
                                    
                
                
            }
        });
       
       btnremovetocart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                  if(c1.isSelected()){
                      
                      itemt1name.setText(itemt2name.getText());
                      itemt1quantity.setText(itemt2quantity.getText());
                      itemt1price.setText(itemt2price.getText());
                      itemt1total.setText(itemt2total.getText());     
                      
                      itemt2name.setText(itemt3name.getText());
                      itemt2quantity.setText(itemt3quantity.getText());
                      itemt2price.setText(itemt3price.getText());
                      itemt2total.setText(itemt3total.getText());   
                      
                      itemt3name.setText(itemt4name.getText());
                      itemt3quantity.setText(itemt4quantity.getText());
                      itemt3price.setText(itemt4price.getText());
                      itemt3total.setText(itemt4total.getText());  
                      
                      itemt4name.setText(itemt5name.getText());
                      itemt4quantity.setText(itemt5quantity.getText());
                      itemt4price.setText(itemt5price.getText());
                      itemt4total.setText(itemt5total.getText());     
                      
                      totalitemscart=totalitemscart-1;                     
                                                              
                  }  
                  if(c2.isSelected()){
                      
                      
                      itemt2name.setText(itemt3name.getText());
                      itemt2quantity.setText(itemt3quantity.getText());
                      itemt2price.setText(itemt3price.getText());
                      itemt2total.setText(itemt3total.getText());   
                      
                      itemt3name.setText(itemt4name.getText());
                      itemt3quantity.setText(itemt4quantity.getText());
                      itemt3price.setText(itemt4price.getText());
                      itemt3total.setText(itemt4total.getText());  
                      
                      itemt4name.setText(itemt5name.getText());
                      itemt4quantity.setText(itemt5quantity.getText());
                      itemt4price.setText(itemt5price.getText());
                      itemt4total.setText(itemt5total.getText());     
                      
                      totalitemscart=totalitemscart-1;                     
                                                              
                  }  
                  if(c3.isSelected()){
                      
                      itemt3name.setText(itemt4name.getText());
                      itemt3quantity.setText(itemt4quantity.getText());
                      itemt3price.setText(itemt4price.getText());
                      itemt3total.setText(itemt4total.getText());  
                      
                      itemt4name.setText(itemt5name.getText());
                      itemt4quantity.setText(itemt5quantity.getText());
                      itemt4price.setText(itemt5price.getText());
                      itemt4total.setText(itemt5total.getText());     
                      
                      totalitemscart=totalitemscart-1;                     
                                                              
                  }
                  if(c4.isSelected()){
                      
                      itemt4name.setText(itemt5name.getText());
                      itemt4quantity.setText(itemt5quantity.getText());
                      itemt4price.setText(itemt5price.getText());
                      itemt4total.setText(itemt5total.getText());     
                      
                      totalitemscart=totalitemscart-1;                     
                                                              
                  }
                  if(c5.isSelected()){                      
                      totalitemscart=totalitemscart-1;                     
                                                              
                  }         
                  
                  if(totalitemscart==0){
                        item1.setVisible(false);
                        item2.setVisible(false);
                        item3.setVisible(false);
                        item4.setVisible(false);
                        item5.setVisible(false);
                        
                        
                        
                        item6.setVisible(false);
                  }
                  else if(totalitemscart==1){
                        item1.setVisible(true);
                        item2.setVisible(false);
                        item3.setVisible(false);
                        item4.setVisible(false);
                        item5.setVisible(false);
                        
                        int totalvaluenum=Integer.parseInt(itemt1total.getText());
                        String totalvaluestring=String.valueOf(totalvaluenum);
                        itemt6total.setText(totalvaluestring);
                        item6.setVisible(true);
                  }
                  else if(totalitemscart==2){
                       item1.setVisible(true);
                        item2.setVisible(true);
                        item3.setVisible(false);
                        item4.setVisible(false);
                        item5.setVisible(false);
                        
                        int totalvaluenum=Integer.parseInt(itemt1total.getText())+Integer.parseInt(itemt2total.getText());
                        String totalvaluestring=String.valueOf(totalvaluenum);
                        itemt6total.setText(totalvaluestring);
                        item6.setVisible(true);
                  }
                  else if(totalitemscart==3){
                        item1.setVisible(true);
                        item2.setVisible(true);
                        item3.setVisible(true);
                        item4.setVisible(false);
                        item5.setVisible(false);
                        
                        int totalvaluenum=Integer.parseInt(itemt1total.getText())+Integer.parseInt(itemt2total.getText())+Integer.parseInt(itemt3total.getText());
                        String totalvaluestring=String.valueOf(totalvaluenum);
                        itemt6total.setText(totalvaluestring);
                        item6.setVisible(true);
                  }
                  else if(totalitemscart==4){
                        item1.setVisible(true);
                        item2.setVisible(true);
                        item3.setVisible(true);
                        item4.setVisible(true);
                        item5.setVisible(false);
                        
                        int totalvaluenum=Integer.parseInt(itemt1total.getText())+Integer.parseInt(itemt2total.getText())+Integer.parseInt(itemt3total.getText())+Integer.parseInt(itemt4total.getText());
                        String totalvaluestring=String.valueOf(totalvaluenum);
                        itemt6total.setText(totalvaluestring);
                        item6.setVisible(true);
                  }
                  else if(totalitemscart==5){
                        item1.setVisible(true);
                        item2.setVisible(true);
                        item3.setVisible(true);
                        item4.setVisible(true);
                        item5.setVisible(true);
                        
                        int totalvaluenum=Integer.parseInt(itemt1total.getText())+Integer.parseInt(itemt2total.getText())+Integer.parseInt(itemt3total.getText())+Integer.parseInt(itemt4total.getText())+Integer.parseInt(itemt4total.getText());
                        String totalvaluestring=String.valueOf(totalvaluenum);
                        itemt6total.setText(totalvaluestring);
                        item6.setVisible(true);
                  }
                  
                
                
            }
        });
       
       btnconfirmtocart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                if(totalitemscart==5){
                     try{
                       Class.forName("com.mysql.jdbc.Driver");                       
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       Timestamp instant=Timestamp.from(Instant.now());
                       String delid="DI "+userid+instant;
                       
                       String s1="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','1','"+itemt1name.getText().toString()+"','"+itemt1quantity.getText().toString()+"','"+itemt1price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt1name.getText().toString()))+"');";
                       st.executeUpdate(s1);                      
                       String s2="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','2','"+itemt2name.getText().toString()+"','"+itemt2quantity.getText().toString()+"','"+itemt2price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt2name.getText().toString()))+"');";
                       st.executeUpdate(s2);
                       String s3="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','3','"+itemt3name.getText().toString()+"','"+itemt3quantity.getText().toString()+"','"+itemt3price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt3name.getText().toString()))+"');";
                       st.executeUpdate(s3);
                       String s4="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','4','"+itemt4name.getText().toString()+"','"+itemt4quantity.getText().toString()+"','"+itemt4price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt4name.getText().toString()))+"');";
                       st.executeUpdate(s4);
                       String s5="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','5','"+itemt5name.getText().toString()+"','"+itemt5quantity.getText().toString()+"','"+itemt5price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt5name.getText().toString()))+"');";
                       st.executeUpdate(s5);
                       System.out.println(itemt1quantity.getText().toString());
                       System.out.println(itemt2quantity.getText().toString());
                       System.out.println(itemt3quantity.getText().toString());
                       System.out.println(itemt4quantity.getText().toString());
                       System.out.println(itemt5quantity.getText().toString());
                       
                       String q1="UPDATE items set stock=(stock-"+itemt1quantity.getText().toString()+") where productname='"+itemt1name.getText().toString()+"'";
                       st.executeUpdate(q1);
                       String q2="UPDATE items set stock=(stock-"+itemt2quantity.getText().toString()+") where productname='"+itemt2name.getText().toString()+"'";
                       st.executeUpdate(q2);
                       String q3="UPDATE items set stock=(stock-"+itemt3quantity.getText().toString()+") where productname='"+itemt3name.getText().toString()+"'";
                       st.executeUpdate(q3);
                       String q4="UPDATE items set stock=(stock-"+itemt4quantity.getText().toString()+") where productname='"+itemt4name.getText().toString()+"'";
                       st.executeUpdate(q4);
                       String q5="UPDATE items set stock=(stock-"+itemt5quantity.getText().toString()+") where productname='"+itemt5name.getText().toString()+"'";
                       st.executeUpdate(q5);
                       
                       
                       
                       messageboxplace m=new messageboxplace();
                       m.message();
                       
                       System.out.println("Success!");
                       conn.close();
                     }
                    catch(Exception e){
                      System.out.println("     "+e);
                    }
                
                
                }
                else if(totalitemscart==4){
                     try{
                       Class.forName("com.mysql.jdbc.Driver");                       
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       Timestamp instant=Timestamp.from(Instant.now());
                       String delid="DI "+userid+instant;
                       String s1="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','1','"+itemt1name.getText().toString()+"','"+itemt1quantity.getText().toString()+"','"+itemt1price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt1name.getText().toString()))+"');";
                       st.executeUpdate(s1);                      
                       String s2="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','2','"+itemt2name.getText().toString()+"','"+itemt2quantity.getText().toString()+"','"+itemt2price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt2name.getText().toString()))+"');";
                       st.executeUpdate(s2);
                       String s3="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','3','"+itemt3name.getText().toString()+"','"+itemt3quantity.getText().toString()+"','"+itemt3price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt3name.getText().toString()))+"');";
                       st.executeUpdate(s3);
                       String s4="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','4','"+itemt4name.getText().toString()+"','"+itemt4quantity.getText().toString()+"','"+itemt4price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt4name.getText().toString()))+"');";
                       st.executeUpdate(s4);
                       
                       System.out.println(itemt1quantity.getText().toString());
                       System.out.println(itemt2quantity.getText().toString());
                       System.out.println(itemt3quantity.getText().toString());
                       System.out.println(itemt4quantity.getText().toString());
                       

                      
                       
                       String q1="UPDATE items set stock=(stock-"+itemt1quantity.getText().toString()+") where productname='"+itemt1name.getText().toString()+"'";
                       st.executeUpdate(q1);
                       String q2="UPDATE items set stock=(stock-"+itemt2quantity.getText().toString()+") where productname='"+itemt2name.getText().toString()+"'";
                       st.executeUpdate(q2);
                       String q3="UPDATE items set stock=(stock-"+itemt3quantity.getText().toString()+") where productname='"+itemt3name.getText().toString()+"'";
                       st.executeUpdate(q3);
                       String q4="UPDATE items set stock=(stock-"+itemt4quantity.getText().toString()+") where productname='"+itemt4name.getText().toString()+"'";
                       st.executeUpdate(q4);
                       
                       
                       
                       
                       messageboxplace m=new messageboxplace();
                       m.message();
                       
                       System.out.println("Success!");
                       conn.close();
                     }
                    catch(Exception e){
                      System.out.println("     "+e);
                    }
                
                
                }
                else if(totalitemscart==3){
                     try{
                       Class.forName("com.mysql.jdbc.Driver");                       
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       Timestamp instant=Timestamp.from(Instant.now());
                       String delid="DI "+userid+instant;
                       String s1="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','1','"+itemt1name.getText().toString()+"','"+itemt1quantity.getText().toString()+"','"+itemt1price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt1name.getText().toString()))+"');";
                       st.executeUpdate(s1);                      
                       String s2="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','2','"+itemt2name.getText().toString()+"','"+itemt2quantity.getText().toString()+"','"+itemt2price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt2name.getText().toString()))+"');";
                       st.executeUpdate(s2);
                       String s3="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','3','"+itemt3name.getText().toString()+"','"+itemt3quantity.getText().toString()+"','"+itemt3price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt3name.getText().toString()))+"');";
                       st.executeUpdate(s3);
                       
                       System.out.println(itemt1quantity.getText().toString());
                       System.out.println(itemt2quantity.getText().toString());
                       System.out.println(itemt3quantity.getText().toString());
                       
                      
                       
                       String q1="UPDATE items set stock=(stock-"+itemt1quantity.getText().toString()+") where productname='"+itemt1name.getText().toString()+"'";
                       st.executeUpdate(q1);
                       String q2="UPDATE items set stock=(stock-"+itemt2quantity.getText().toString()+") where productname='"+itemt2name.getText().toString()+"'";
                       st.executeUpdate(q2);
                       String q3="UPDATE items set stock=(stock-"+itemt3quantity.getText().toString()+") where productname='"+itemt3name.getText().toString()+"'";
                       st.executeUpdate(q3);
                      
                       
                       
                       
                       
                       
                       messageboxplace m=new messageboxplace();
                       m.message();
                       
                       System.out.println("Success!");
                       conn.close();
                     }
                    catch(Exception e){
                      System.out.println("     "+e);
                    }
                
                
                }
                else if(totalitemscart==2){
                     try{
                       Class.forName("com.mysql.jdbc.Driver");                       
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       Timestamp instant=Timestamp.from(Instant.now());
                       String delid="DI "+userid+instant;
                       String s1="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','1','"+itemt1name.getText().toString()+"','"+itemt1quantity.getText().toString()+"','"+itemt1price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt1name.getText().toString()))+"');";
                       st.executeUpdate(s1);                      
                       String s2="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','2','"+itemt2name.getText().toString()+"','"+itemt2quantity.getText().toString()+"','"+itemt2price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt2name.getText().toString()))+"');";
                       st.executeUpdate(s2);
                       
                       System.out.println(itemt1quantity.getText().toString());
                       System.out.println(itemt2quantity.getText().toString());
                      
                      
                       
                       String q1="UPDATE items set stock=(stock-"+itemt1quantity.getText().toString()+") where productname='"+itemt1name.getText().toString()+"'";
                       st.executeUpdate(q1);
                       String q2="UPDATE items set stock=(stock-"+itemt2quantity.getText().toString()+") where productname='"+itemt2name.getText().toString()+"'";
                       st.executeUpdate(q2);
                       
                      
                       
                       messageboxplace m=new messageboxplace();
                       m.message();
                       
                       System.out.println("Success!");
                       conn.close();
                     }
                    catch(Exception e){
                      System.out.println("     "+e);
                    }
                
                
                }
                else if(totalitemscart==1){
                     try{
                       Class.forName("com.mysql.jdbc.Driver");                       
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       Timestamp instant=Timestamp.from(Instant.now());
                       String delid="DI "+userid+instant;
                       String s1="insert into ecommerce(orderid,no,productname,quantity,price,userid,status,productid) values('"+delid+"','1','"+itemt1name.getText().toString()+"','"+itemt1quantity.getText().toString()+"','"+itemt1price.getText().toString()+"','"+userid+"','not delivered','"+productid.get(productlist.indexOf(itemt1name.getText().toString()))+"');";
                       st.executeUpdate(s1);                      
                       
                       System.out.println(itemt1quantity.getText().toString());
                       
                       
                       String q1="UPDATE items set stock=(stock-"+itemt1quantity.getText().toString()+") where productname='"+itemt1name.getText().toString()+"'";
                       st.executeUpdate(q1);
                                              
                       
                       
                       messageboxplace m=new messageboxplace();
                       m.message();
                       
                       System.out.println("Success!");
                       conn.close();
                     }
                    catch(Exception e){
                      System.out.println("     "+e);
                    }
                
                
                }
                b1.doClick();
                totalitemscart=0;                   
                
                
            }
        });
     
       order.add(btnconfirmtocart);
       order.add(btnremovetocart);
       order.add(btnaddtocart);
       order.add(quan);
       order.add(cart);
       order.add(orderprize);
       order.add(orderavailable);
       order.add(product);
       order.add(labelord);
       
                 order.updateUI();
                 dashboard.setVisible(false);
                 schedule.setVisible(false);
                 cancel.setVisible(false);
                 order.setVisible(true );
            }
        });

      b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                
                b.setIcon(icon4);
                 b1.setIcon(icon1);
                 b2.setIcon(icon6);
                 b3.setIcon(icon3);
                 b4.setIcon(icon8);
                 
                 schedule.removeAll();
                schedule.revalidate();
                schedule.repaint();
                schedule.setVisible(true);
                 
                 Icon iconapp = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img23.png");
      JButton bapp= new JButton(iconapp);
      bapp.setBorderPainted(false);
      bapp.setFocusPainted(false);
      bapp.setContentAreaFilled(false);
      bapp.setBounds(550,500,250,100); 
      
      ImageIcon iconapplb = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img21.png");
      JLabel labelapp = new JLabel(iconapplb);
      labelapp.setBounds(360,10,650,500); 
      
      JTextField tfappveh=new JTextField();
      tfappveh.setBounds(570,140,120,30);
      tfappveh.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tfappveh.setBackground(new Color(217,217,217));
      
      ArrayList<String> workshoplist=new ArrayList<String>();
      workshoplist.add("_");
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
        Statement st=conn.createStatement();
        String sql = "SELECT name FROM admin";
        ResultSet rs    = st.executeQuery(sql);           
        while(rs.next()){
              workshoplist.add(rs.getString("name"));
        }
        System.out.println(workshoplist);
        
        conn.close();
       }
       catch(Exception e)
       {
         System.out.println("     "+e);
       }
      
       String[] workshoparr=new String[workshoplist.size()];
       workshoplist.toArray(workshoparr);
      
       JComboBox tfappwor=new JComboBox(workshoparr);
       tfappwor.setBounds(530,240,160,30);
       tfappwor.setBorder(javax.swing.BorderFactory.createEmptyBorder());
       tfappwor.setBackground(Color.white);
      
       JPanel panelser=new JPanel();
       panelser.setBounds(570,320,120,30);
       panelser.setLayout(null);
       panelser.setBackground(Color.white);
      
       JPanel paneldate=new JPanel();
       paneldate.setBounds(850,300,120,30);
       paneldate.setLayout(null);
       paneldate.setBackground(Color.white);
      
       JPanel paneltime=new JPanel();
       paneltime.setBounds(850,370,120,30);
       paneltime.setLayout(null);
       paneltime.setBackground(Color.white);
      
       tfappwor.addItemListener(new ItemListener() {
             @Override
             public void itemStateChanged(ItemEvent ie) {
                        //To change body of generated methods, choose Tools | Templates.
                   Component[] components=panelser.getComponents();
                   for(Component component :components){
               
                        panelser.remove(component);
                   }
                    panelser.revalidate();
                    panelser.repaint();
                    panelser.setVisible(false);
                    int adminid=workshoplist.indexOf(tfappwor.getSelectedItem().toString());
                    ArrayList<String> servicelist=new ArrayList<String>();
                    servicelist.add("-");   
                    try{
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       String sql = "SELECT service from workshop where adminid='"+adminid+"';";
                       ResultSet rs    = st.executeQuery(sql);           
                       while(rs.next()){
                             servicelist.add(rs.getString("service"));
                       }
                       System.out.println("sucess district");
                       System.out.println(servicelist);
                       conn.close();
                    }
                    catch(Exception e){
                           System.out.println("     "+e);
                    }
                    String[] servicearr=new String[servicelist.size()];
                    servicelist.toArray(servicearr);
                    JComboBox service=new JComboBox(servicearr);
         
                    service.setBounds(0,0,120,30);
                    service.setBackground(Color.white);
               
               
                    service.addItemListener(new ItemListener() {
                             @Override
                                public void itemStateChanged(ItemEvent ie) {
                                  //To change body of generated methods, choose Tools | Templates.
                                        serviceinput=service.getSelectedItem().toString();    
                                        System.out.println(serviceinput);
                            }
                    });
               
                    panelser.setBackground(Color.white);
                    panelser.add(service);
               
               
                    Component[] componentsd=panelser.getComponents();
                    for(Component component :componentsd){
               
                        paneldate.remove(component);
                    }
                    paneldate.revalidate();
                    paneldate.repaint();
                    paneldate.setVisible(false);
               
               
                    ArrayList<String> datelist=new ArrayList<String>();
                    datelist.add("-");   
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                        Statement st=conn.createStatement();
                        String sql = "SELECT DISTINCT date from schedule where adminid='"+adminid+"';";
                        ResultSet rs    = st.executeQuery(sql);           
                        while(rs.next()){
                              datelist.add(rs.getString("date"));
                        }
                        System.out.println("sucess date");
                        System.out.println(datelist);
                        conn.close();
                    }
                    catch(Exception e){
                        System.out.println("     "+e);
                    }
                    String[] datearr=new String[datelist.size()];
                    datelist.toArray(datearr);
                    JComboBox date=new JComboBox(datearr);
                    date.setBounds(0,0,120,30);
                    date.setBackground(Color.white);
                              
                    date.addItemListener(new ItemListener() {
                        @Override
                        public void itemStateChanged(ItemEvent ie) {
                                  //To change body of generated methods, choose Tools | Templates.
                            dateinput=date.getSelectedItem().toString();    
                            System.out.println(serviceinput);
                            Component[] components=paneltime.getComponents();
                            for(Component component :components){
                                      paneltime.remove(component);
                            }
                            paneltime.revalidate();
                            paneltime.repaint();
                            paneltime.setVisible(false);
                                
                            ArrayList<String> timelist=new ArrayList<String>();
                            timelist.add("-");     
                            try{
                               Class.forName("com.mysql.jdbc.Driver");
                               Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                               Statement st=conn.createStatement();
                               int adminid=workshoplist.indexOf(tfappwor.getSelectedItem().toString());
                               String sql = "SELECT DISTINCT time from schedule where adminid='"+adminid+"' and date='"+date.getSelectedItem().toString()+"'";
                               ResultSet rs    = st.executeQuery(sql);           
                               while(rs.next()){
                                     timelist.add(rs.getString("time"));
                                }
                                System.out.println("sucess time");
                                System.out.println(timelist);
                                conn.close();
                            }
                            catch(Exception e){
                                System.out.println("     "+e);
                            }
                                
                            String[] timearr=new String[timelist.size()];
                            timelist.toArray(timearr);
                            JComboBox time=new JComboBox(timearr);
                            time.setBounds(0,0,120,30);
                            time.setBackground(Color.white);
                            time.addItemListener(new ItemListener() {
                                   @Override
                                   public void itemStateChanged(ItemEvent ie) {
                                           //To change body of generated methods, choose Tools | Templates.
                                            timeinput=time.getSelectedItem().toString();    
                                            System.out.println(timeinput);
                                    }
                           });
               
                           paneltime.setBackground(Color.white);
                           paneltime.add(time);
                           paneltime.setVisible(true);
                                
                           schedule.updateUI();
                           panelser.setVisible(true);
                           panelser.updateUI();
                           paneldate.updateUI();
                           paneltime.updateUI();
                                 
                           }
                    });
                    paneldate.setBackground(Color.white);
                    paneldate.add(date);
                    paneldate.setVisible(true);
               
               
               
               
               
                    schedule.updateUI();
                    panelser.setVisible(true);
                    panelser.updateUI();
                    paneldate.updateUI();
               
                    }
                });
      
                ArrayList<String> vehiclebrandlist=new ArrayList<String>();
                vehiclebrandlist.add("-");
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st=conn.createStatement();
                    String sql = "SELECT distinct vehiclebrand from vehicle;";
                    ResultSet rs    = st.executeQuery(sql);           
                    while(rs.next()){
                            vehiclebrandlist.add(rs.getString("vehiclebrand"));                
                    }
                    conn.close();
                }
                catch(Exception e){
                    System.out.println("     "+e);
                }
                String[] vehiclebrandarr=new String[vehiclebrandlist.size()];
                vehiclebrandlist.toArray(vehiclebrandarr);
                JComboBox vehiclebrand=new JComboBox(vehiclebrandarr);
                vehiclebrand.setBounds(840,140,120,30); 
                vehiclebrand.setBackground(Color.white);
      
                JPanel panelvehiclemodel=new JPanel();
                panelvehiclemodel.setBounds(840,220,120,30);
                panelvehiclemodel.setLayout(null);
                panelvehiclemodel.setBackground(Color.white);
            
                vehiclebrand.addItemListener(new ItemListener() {
                    @Override
                    public void itemStateChanged(ItemEvent ie) {
                            //To change body of generated methods, choose Tools | Templates.
                            Component[] components=panelvehiclemodel.getComponents();
                            for(Component component :components){
               
                                panelvehiclemodel.remove(component);
                            }
                            panelvehiclemodel.revalidate();
                            panelvehiclemodel.repaint();
                            String vehiclebr=vehiclebrand.getSelectedItem().toString();
                            panelvehiclemodel.setVisible(false);
                            ArrayList<String> vehmlist=new ArrayList<String>();                            
                            vehmlist.add("-");
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                                Statement st=conn.createStatement();
                                String sql = "SELECT vehiclemodel from vehicle where vehiclebrand='"+vehiclebr+"';";
                                ResultSet rs    = st.executeQuery(sql);           
                                while(rs.next()){
                                    vehmlist.add(rs.getString("vehiclemodel"));
                                }
                                System.out.println("sucess district");
                                System.out.println(vehmlist);
                                conn.close();
                            }
                            catch(Exception e){
                                System.out.println("     "+e);
                            }
                            String[] vehmarr=new String[vehmlist.size()];
                            vehmlist.toArray(vehmarr);
                            JComboBox vehmodel=new JComboBox(vehmarr);
                            vehmodel.setBounds(0,0,120,30);
                            vehmodel.setBackground(Color.white);
               
               
                            vehmodel.addItemListener(new ItemListener() {
                                    @Override
                                    public void itemStateChanged(ItemEvent ie) {
                                    //To change body of generated methods, choose Tools | Templates.
                                        vehmodelinput=vehmodel.getSelectedItem().toString();    
                                        System.out.println(vehmodelinput);
                                }
                            });
               
                            panelvehiclemodel.setBackground(Color.white);
                            panelvehiclemodel.add(vehmodel);
                            panelvehiclemodel.updateUI();
                            panelvehiclemodel.setVisible(true);
                            schedule.updateUI();
               
                        }
                    });
      
      bapp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String vehno=tfappveh.getText();
                String workshop=tfappwor.getSelectedItem().toString();
                String vehbrand=vehiclebrand.getSelectedItem().toString();
                Boolean error=false;
                if(vehno.isEmpty()){
                        Error e=new Error();
                        e.errordis("Fill Vehicle no","Check again"); 
                        error=true;               
                
                }
                else if(vehbrand.isEmpty()||vehbrand.equals('-')){
                        Error e=new Error();
                        e.errordis("Select Vehicle brand","Check again"); 
                        error=true;    
                
                }
                else if(workshop.isEmpty()||workshop.equals('-')){
                        Error e=new Error();
                        e.errordis("Select workshop","Check again"); 
                        error=true;    
                
                }
                else if(serviceinput.isEmpty()||serviceinput.equals('-')){
                        Error e=new Error();
                        e.errordis("Select service need from workshop","Check again"); 
                        error=true;    
                
                }
                else if(dateinput.isEmpty()||dateinput.equals('-')){
                        Error e=new Error();
                        e.errordis("Select date","Check again"); 
                        error=true;    
                
                }
                else if(timeinput.isEmpty()||timeinput.equals('-')){
                        Error e=new Error();
                        e.errordis("Select time","Check again"); 
                        error=true;    
                
                }
                else if(vehmodelinput.isEmpty()||vehmodelinput.equals('-')){
                        Error e=new Error();
                        e.errordis("Select vehicle model","Check again"); 
                        error=true;    
                
                }
                else{
                    boolean empty=true;
                    try{
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       String id=timeinput+" "+dateinput+" "+tfappwor.getSelectedItem().toString();
                       String sql = "SELECT id from appointments where id='"+id+"'";
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
                       e.errordis("That time slot is already booked","Pls choose another option"); 
                       error=true;
                    }
                    else{
                       boolean empty1=true;
                       try{
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                           Statement st=conn.createStatement();
                           
                           String sql = "select userid,date from appointments where userid='"+userid+"' and date='"+dateinput+"'";
                           ResultSet rs    = st.executeQuery(sql);           
                           while(rs.next()){
                             empty1=false;
                             System.out.println("alreadyexist");
                          }                     
                          conn.close();
                       }
                       catch(Exception e){
                          System.out.println("     "+e);
                       }
                       if(!empty1){
                          Error e=new Error();
                          e.errordis("Already an appointment is booked","for the particular day"); 
                          error=true;
                       }                    
                    
                    }
                
                }
                
                if(error==false){
                    try{
                       Class.forName("com.mysql.jdbc.Driver");
                       
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       int adminid=workshoplist.indexOf(tfappwor.getSelectedItem().toString());
                       String id=timeinput+" "+dateinput+" "+tfappwor.getSelectedItem().toString();
                       String s="INSERT INTO appointments(userid,vehicleno,adminid,service,status,id,vehiclebrand,vehiclemodel,date) VALUES('"+userid+"','"+vehno+"','"+adminid+"','"+serviceinput+"','Approved','"+id+"','"+vehbrand+"','"+vehmodelinput+"','"+dateinput+"');";
                       st.executeUpdate(s);
                       System.out.println("Success!");
                       messageboxapp m=new messageboxapp();
                       m.message();
                       conn.close();
                     }
                    catch(Exception e){
                      System.out.println("     "+e);
                    }
                    
                    
                }
                b2.doClick(); 
            }           
            
      });
      
      ImageIcon iconas = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img20.png");
      JLabel labelas = new JLabel(iconas);
      labelas.setBounds(-50,10,400,500); 
      
      Icon iconres = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img22.png");
      JButton bres= new JButton(iconres);
      bres.setBorderPainted(false);
      bres.setFocusPainted(false);
      bres.setContentAreaFilled(false);
      bres.setBounds(50,500,250,100); 
      
      ArrayList<String> servicelist=new ArrayList<String>();
      servicelist.add("-");
      try
      {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
        Statement st=conn.createStatement();
        String sql = "select distinct service from workshop";
        ResultSet rs    = st.executeQuery(sql);           
        while(rs.next()){
           servicelist.add(rs.getString("service"));
        }
        System.out.println(servicelist);
        
        conn.close();
       }
       catch(Exception e)
       {
        System.out.println("     "+e);
       }
      
      String[] servicearr=new String[servicelist.size()];
      servicelist.toArray(servicearr);
      
      JComboBox tfassser=new JComboBox(servicearr);
      tfassser.setBounds(145,130,180,30);
      tfassser.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tfassser.setBackground(Color.white);
      
      JComboBox vehiclebrandass=new JComboBox(vehiclebrandarr);
      vehiclebrandass.setBounds(30,420,120,30); 
      vehiclebrandass.setBackground(Color.white);
      
      JPanel panelvehiclemodelass=new JPanel();
      panelvehiclemodelass.setBounds(190,420,120,30);
      panelvehiclemodelass.setLayout(null);
      panelvehiclemodelass.setBackground(Color.white);
      
       vehiclebrandass.addItemListener(new ItemListener() {
          @Override
          public void itemStateChanged(ItemEvent ie) {
               //To change body of generated methods, choose Tools | Templates.
               Component[] components=panelvehiclemodelass.getComponents();
               for(Component component :components){
               
                 panelvehiclemodelass.remove(component);
               }
               panelvehiclemodelass.revalidate();
               panelvehiclemodelass.repaint();
               String vehiclebr=vehiclebrandass.getSelectedItem().toString();
               panelvehiclemodelass.setVisible(false);
               ArrayList<String> vehmlist=new ArrayList<String>();
               vehmlist.add("-");
               try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st=conn.createStatement();
                    String sql = "SELECT vehiclemodel from vehicle where vehiclebrand='"+vehiclebr+"';";
                    ResultSet rs    = st.executeQuery(sql);           
                    while(rs.next()){
                        vehmlist.add(rs.getString("vehiclemodel"));
                   }
                    System.out.println("sucess district");
                    System.out.println(vehmlist);
                    conn.close();
                }
                catch(Exception e){
                    System.out.println("     "+e);
                }
               String[] vehmarr=new String[vehmlist.size()];
               vehmlist.toArray(vehmarr);
               JComboBox vehmodelass=new JComboBox(vehmarr);
               vehmodelass.setBounds(0,0,120,30);
               vehmodelass.setBackground(Color.white);
               
               
               vehmodelass.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent ie) {
                                  //To change body of generated methods, choose Tools | Templates.
                                 vehmodelinputass=vehmodelass.getSelectedItem().toString();    
                                 System.out.println(vehmodelinputass);
                            }
                });
               
               panelvehiclemodelass.setBackground(Color.white);
               panelvehiclemodelass.add(vehmodelass);
               panelvehiclemodelass.updateUI();
               panelvehiclemodelass.setVisible(true);
               schedule.updateUI();
               
          }
      });
       
      JTextField tfassloc=new JTextField();
      JTextField tfasspin=new JTextField();
      
      tfassloc.setBounds(40,210,250,40); 
      tfasspin.setBounds(40,320,100,30);
      
      tfassloc.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tfasspin.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      
      tfassloc.setBackground(new Color(217,217,217));
      tfasspin.setBackground(new Color(217,217,217));
      
      
      bres.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
               boolean error=false;
               String address=tfassloc.getText().toString();
               String pincode=tfasspin.getText().toString();
               String ser=(String)tfassser.getSelectedItem();
               String vehb=(String)vehiclebrandass.getSelectedItem();
               
               Pattern p2=Pattern.compile("[^0-9]");
               Matcher m2=p2.matcher(pincode);
               boolean pinmatch=m2.find();
               
               if(address.isEmpty()){
                     Error e=new Error();
                     e.errordis("Enter the address","Check again"); 
                     error=true;                              
               }
               else if(pincode.isEmpty()){
                     Error e=new Error();
                     e.errordis("Enter the pincode","Check again"); 
                     error=true;                              
               }
               else if(!(pincode.length()==6)){
                     Error e=new Error();
                     e.errordis("pincode can be of 6 digits","Check again"); 
                     error=true; 
               }
               else if(pinmatch){
                     Error e=new Error();
                     e.errordis("pincode can be only of numbers","Check again"); 
                     error=true; 
               }
               else if(ser.isEmpty()||ser.equals('-')){
                     Error e=new Error();
                     e.errordis("Select the service","Check again"); 
                     error=true;                              
               }
               else if(vehb.isEmpty()||vehb.equals('-')){
                     Error e=new Error();
                     e.errordis("Select the vehicle brand","Check again"); 
                     error=true;                              
               }
               else if(vehmodelinputass.isEmpty()||vehmodelinputass.equals('-')){
                     Error e=new Error();
                     e.errordis("Select the vehicle model","Check again"); 
                     error=true;                              
               }
               else{
                       boolean notavailable=true;
                       try{
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                           Statement st=conn.createStatement();
                           
                           String sql = "SELECT workerid,workername,workermobileno,workerstatus,pincode,distance,time,service from assistpincode ap JOIN workshop w ON ap.adminid=w.adminid JOIN workers wk ON ap.adminid=wk.adminid where wk.workerstatus='free' and w.service='"+ser+"' and ap.pincode='"+pincode+"';";
                           ResultSet rs    = st.executeQuery(sql);           
                           while(rs.next()){
                             notavailable=false;                             
                          }                     
                          conn.close();
                       }
                       catch(Exception e){
                          System.out.println("     "+e);
                       }
                       if(notavailable){
                          Error e=new Error();
                          e.errordis("All workers are busy","Try after some time"); 
                          error=true;
                       }   
                       
                       
                    boolean empty=true;
                    try{
                       Class.forName("com.mysql.jdbc.Driver");
                       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                       Statement st=conn.createStatement();
                       String sql = "select userid,status from assist where userid='"+userid+"' and status='Approved'";
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
                       e.errordis("Already response is registered","Pls wait!!!"); 
                       error=true;
                    }
                       
                       
               }
               
               if(error==false){
                        try{
                           Class.forName("com.mysql.jdbc.Driver");
                           Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                           Statement st=conn.createStatement();
                           
                           String sql = "SELECT workerid from assistpincode ap JOIN workshop w ON ap.adminid=w.adminid JOIN workers wk ON ap.adminid=wk.adminid where wk.workerstatus='free' and w.service='"+ser+"' and ap.pincode='"+pincode+"';";
                           ResultSet rs    = st.executeQuery(sql);    
                           int workerid=0;
                           while(rs.next()){
                                 workerid=rs.getInt("workerid"); 
                                 break;
                           }
                           
                           String s = "SELECT adminid from workers where workerid='"+workerid+"';";
                           ResultSet r    = st.executeQuery(s);    
                           int adminid=0;
                           while(r.next()){
                                 adminid=r.getInt("adminid"); 
                                 break;
                           }
                           Timestamp instant=Timestamp.from(Instant.now());
                           String s1="Insert into assist(timestamp,userid,adminid,workerid,service,landmark,pincode,vehiclebrand,vehiclemodel,status) values('"+instant+"','"+userid+"','"+adminid+"','"+workerid+"','"+tfassser.getSelectedItem()+"','"+address+"','"+pincode+"','"+vehb+"','"+vehmodelinputass+"','Approved')";
                           st.executeUpdate(s1);
                           
                           
                           String s2="UPDATE workers set workerstatus='not free' where workerid='"+workerid+"';";
                           st.executeUpdate(s2);
                           
                           String s3 = "SELECT name from admin where adminid='"+adminid+"';";
                           ResultSet r1    = st.executeQuery(s3);    
                           String adminname="";
                           while(r1.next()){
                                 adminname=r1.getString("name");                                  
                           }
                           //SELECT * from workers w JOIN assistpincode a ON w.adminid=a.adminid
                            String s4 = "SELECT workername,workermobileno,time from workers w JOIN assistpincode a ON w.adminid=a.adminid where workerid='"+workerid+"';";
                           ResultSet r2    = st.executeQuery(s4);    
                           String workername="";
                           String workermobileno="";
                           String time="";
                           while(r2.next()){
                                 workername=r2.getString("workername");  
                                 workermobileno=r2.getString("workermobileno");
                                 time=r2.getString("time"); 
                                 break;
                           }
                           
                          conn.close();
                          messageboxass m=new messageboxass();
                          m.message(adminname,workername,workermobileno,time);
                       }
                       catch(Exception e){
                          System.out.println("     "+e);
                       }
               
               
               
               }
                              
              b2.doClick(); 
            }
        });
      
      
      schedule.add(tfassloc);
      schedule.add(tfasspin);
      schedule.add(panelvehiclemodelass);   
      schedule.add(vehiclebrandass);    
      schedule.add(tfassser);
      schedule.add(bres);
      schedule.add(labelas);
      schedule.add(panelvehiclemodel);
      schedule.add(vehiclebrand);
      schedule.add(paneltime);
      schedule.add(paneldate);
      schedule.add(panelser);
      schedule.add(tfappwor);
      schedule.add(tfappveh);
      schedule.add(labelapp);
      schedule.add(bapp);
                 
               schedule.setVisible(true);
               dashboard.setVisible(false);
               cancel.setVisible(false);
               order.setVisible(false);
               vieworder.setVisible(false);
                 
            }
        });
      
       b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                
                 b.setIcon(icon4);
                 b1.setIcon(icon1);
                 b2.setIcon(icon2);
                 b3.setIcon(icon3);
                 b4.setIcon(icon9);
                 
                vieworder.removeAll();
                vieworder.revalidate();
                vieworder.repaint();
                vieworder.setVisible(true);
                
                ImageIcon iconcanlb = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img47.png");
                JLabel labelcan = new JLabel(iconcanlb);
                labelcan.setBounds(-200,10,650,500); 
                
                Icon iconordcan = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img34.png");
                JButton bordcan= new JButton(iconordcan);
                bordcan.setBorderPainted(false);
                bordcan.setFocusPainted(false);
                bordcan.setContentAreaFilled(false);
                bordcan.setBounds(110,430,250,100); 
                
                                
                 
                ImageIcon view = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img46.png");
      JLabel labelview = new JLabel(view);
      labelview.setBounds(400,50,700,500); 
      ArrayList<String> deliveryid=new ArrayList<String>();
      deliveryid.add("-");
      try
       {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
        Statement st=conn.createStatement();
                
        JTextArea ordtablet1;
        JTextArea ordtablet2;
        JTextArea ordtablet3;
        JTextArea ordtablet4;
        JTextArea ordtablet5;
        
        
        String s = "SELECT orderid,no,productname,price,quantity from ecommerce where userid='"+userid+"' and status='not delivered'";
        ResultSet r    = st.executeQuery(s); 
        String t1="";
        String t2="";
        String t3="";
        String t4="";
        String t5="";
        
        
        ordtablet1=new JTextArea("");
        ordtablet1.setBounds(465,190,165,200); 
        ordtablet1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ordtablet1.setBackground(new Color(255, 222, 89));
        ordtablet1.setEditable(false);
        
        
        ordtablet2=new JTextArea("");
        ordtablet2.setBounds(655,190,50,200); 
        ordtablet2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ordtablet2.setBackground(new Color(255, 222, 89));
        ordtablet2.setEditable(false);
        
        
        ordtablet3=new JTextArea("");
        ordtablet3.setBounds(725,190,100,200); 
        ordtablet3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ordtablet3.setBackground(new Color(255, 222, 89));
        ordtablet3.setEditable(false);
        
        
        ordtablet4=new JTextArea("");
        ordtablet4.setBounds(840,190,70,200); 
        ordtablet4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ordtablet4.setBackground(new Color(255, 222, 89));
        ordtablet4.setEditable(false);
        
        ordtablet5=new JTextArea("");
        ordtablet5.setBounds(950,190,70,200); 
        ordtablet5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        ordtablet5.setBackground(new Color(255, 222, 89));
        ordtablet5.setEditable(false);
        
        
        
        System.out.println("work1");
        
        while(r.next()){
               deliveryid.add(r.getString("orderid"));
               t1=t1+"\n"+r.getString("orderid");
               t2=t2+"\n"+r.getString("no");
               t3=t3+"\n"+r.getString("productname");
               t4=t4+"\n"+r.getString("quantity");
               t5=t5+"\n"+r.getString("price");                      
        }
        
        System.out.println(t1);
        System.out.println(t2);
        System.out.println(t3);
        System.out.println(t4);
        System.out.println(t5);
                
        ordtablet1.setText(t1);
        ordtablet2.setText(t2);
        ordtablet3.setText(t3);
        ordtablet4.setText(t4);
        ordtablet5.setText(t5);
        
        
        vieworder.add(ordtablet1);
        vieworder.add(ordtablet2);
        vieworder.add(ordtablet3);
        vieworder.add(ordtablet4);
        vieworder.add(ordtablet5);
        
        vieworder.updateUI();
        conn.close();
       }
       catch(Exception e)
       {
        System.out.println("     "+e);
       }
       String[] deliveryidarr=new String[deliveryid.size()];
       deliveryid.toArray(deliveryidarr);
      
       JComboBox deliveryidbox=new JComboBox(deliveryidarr);
       deliveryidbox.setBounds(240,120,160,30);
       deliveryidbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
       deliveryidbox.setBackground(Color.white);
       
       
       JPanel deliverproductboxpan=new JPanel();
      deliverproductboxpan.setBounds(240,230,120,30);
      deliverproductboxpan.setLayout(null);
      deliverproductboxpan.setBackground(Color.white);
      
       deliveryidbox.addItemListener(new ItemListener() {
          @Override
          public void itemStateChanged(ItemEvent ie) {
               //To change body of generated methods, choose Tools | Templates.
               Component[] components=deliverproductboxpan.getComponents();
               for(Component component :components){
               
                 deliverproductboxpan.remove(component);
               }
               deliverproductboxpan.revalidate();
               deliverproductboxpan.repaint();
               String deliveryid=deliveryidbox.getSelectedItem().toString();
               deliverproductboxpan.setVisible(false);
               ArrayList<String> products=new ArrayList<String>();
               products.add("-");
               try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st=conn.createStatement();
                    String sql = "SELECT productname from ecommerce where orderid='"+deliveryid+"';";
                    ResultSet rs    = st.executeQuery(sql);           
                    while(rs.next()){
                        products.add(rs.getString("productname"));
                   }
                    System.out.println("sucess district");
                    System.out.println(products);
                    conn.close();
                }
                catch(Exception e){
                    System.out.println("     "+e);
                }
               String[] productsarr=new String[products.size()];
               products.toArray(productsarr);
               JComboBox productnamebox=new JComboBox(productsarr);
               productnamebox.setBounds(0,0,120,30);
               productnamebox.setBackground(Color.white);
               
               
               productnamebox.addItemListener(new ItemListener() {
                            @Override
                            public void itemStateChanged(ItemEvent ie) {
                                  //To change body of generated methods, choose Tools | Templates.
                                 productnameinputcan=productnamebox.getSelectedItem().toString();    
                                 System.out.println(productnameinputcan);
                            }
                });
               
               deliverproductboxpan.setBackground(Color.white);
               deliverproductboxpan.add(productnamebox);
               deliverproductboxpan.updateUI();
               deliverproductboxpan.setVisible(true);
               vieworder.updateUI();
               
          }
      });
       
       
       
       bordcan.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        String orderid=deliveryidbox.getSelectedItem().toString();
                        String reason=productnameinputcan;
                 
                        if(orderid.isEmpty()||orderid.equals('-')){
                            Error e=new Error();
                            e.errordis("Select Deliveryid id","Check again"); 
                        }
                        else if(reason.isEmpty()){
                            Error e=new Error();
                            e.errordis("Select product","Pls"); 
                        }
                        else{
                
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                       
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                                Statement st=conn.createStatement();
                                String s="UPDATE ecommerce set status='cancelled' where orderid='"+orderid+"' and productname='"+productnameinputcan+"'";
                                st.executeUpdate(s);
                                System.out.println("Success!");
                                messageplacecancel m=new messageplacecancel();
                                m.message();
                                conn.close();
                            }
                            catch(Exception e){
                                System.out.println("     "+e);
                            }           
                
                     }
                        b4.doClick();
                 }
                });
       
       
       vieworder.add(deliverproductboxpan);
               vieworder.add(deliveryidbox);       
                vieworder.add(bordcan);
                vieworder.add(labelcan);
               
               vieworder.add(labelview);
                 vieworder.updateUI();
               vieworder.setVisible(true);
                 
               
                 
                 
               
               schedule.setVisible(false);
               dashboard.setVisible(false);
               cancel.setVisible(false);
               order.setVisible(false);
                 
            }
        });
      
      b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                cancel.removeAll();
                cancel.revalidate();
                cancel.repaint();
                cancel.setVisible(true);
                
                b.setIcon(icon4);
                 b1.setIcon(icon1);
                 b2.setIcon(icon2);
                 b3.setIcon(icon7);
                 b4.setIcon(icon8);
                 
                
                
                 
                 
                 Icon iconappcan = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img34.png");
                JButton bappcan= new JButton(iconappcan);
                bappcan.setBorderPainted(false);
                bappcan.setFocusPainted(false);
                bappcan.setContentAreaFilled(false);
                bappcan.setBounds(600,400,250,100); 
      
                Icon iconasscan = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img34.png");
                JButton basscan= new JButton(iconasscan);
                basscan.setBorderPainted(false);
                basscan.setFocusPainted(false);
                basscan.setContentAreaFilled(false);
                basscan.setBounds(50,400,250,100); 
      
                ImageIcon iconapplbcan = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img33.png");
                JLabel labelappcan = new JLabel(iconapplbcan);
                labelappcan.setBounds(450,10,650,500); 
      
                ImageIcon iconasslbcan = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img32.png");
                JLabel labelasscan = new JLabel(iconasslbcan);
                labelasscan.setBounds(-90,10,650,500); 
      
                ArrayList<String> applist=new ArrayList<String>();
                applist.add("-");
                try
                {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st=conn.createStatement();
                String sql = "SELECT appointmentid from appointments  where userid='"+userid+"' and status!='Declined' and status!='OutForDelivery' and status!='cancelled';";
                ResultSet rs    = st.executeQuery(sql);           
                while(rs.next()){
                    applist.add(rs.getString("appointmentid"));
                }
                System.out.println(applist);
        
                conn.close();
                }
                catch(Exception e)
                {
                    System.out.println("     "+e);
                }
      
                String[] apparr=new String[applist.size()];
                applist.toArray(apparr);
      
                JComboBox appidbox=new JComboBox(apparr);
                appidbox.setBounds(730,200,160,30);
                appidbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                appidbox.setBackground(Color.white);
      
      
                JTextArea tfappreason=new JTextArea();
     
      
                tfappreason.setBounds(660,280,230,50);   
                tfappreason.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                tfappreason.setBackground(Color.white);      
                tfappreason.setBackground(new Color(217,217,217));            
                tfappreason.setEditable(true);
      
                cancel.add(tfappreason);
                cancel.add(appidbox);
                cancel.add(bappcan);
                cancel.add(labelappcan);
      
                bappcan.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        String appointid=appidbox.getSelectedItem().toString();
                        String reason=tfappreason.getText().toString();
                 
                        if(appointid.isEmpty()||appointid.equals('-')){
                            Error e=new Error();
                            e.errordis("Select appointment id","Check again"); 
                        }
                        else if(reason.isEmpty()){
                            Error e=new Error();
                            e.errordis("Please enter reason","Pls"); 
                        }
                        else{
                
                            try{
                                Class.forName("com.mysql.jdbc.Driver");
                       
                                Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                                Statement st=conn.createStatement();
                                String s="UPDATE appointments set status='cancelled',reason='"+reason+"' where appointmentid='"+appointid+"'";
                                st.executeUpdate(s);
                                System.out.println("Success!");
                                messageboxappcancel m=new messageboxappcancel();
                                m.message();
                                conn.close();
                            }
                            catch(Exception e){
                                System.out.println("     "+e);
                            }           
                
                     }
                 }
                });
      
                ArrayList<String> asslist=new ArrayList<String>();
                asslist.add("-");
                try
                {
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st=conn.createStatement();
                    String sql = "SELECT assistid from assist a  where userid='"+userid+"' and status!='Declined' and status!='cancelled'";
                    ResultSet rs    = st.executeQuery(sql);           
                    while(rs.next()){
                        asslist.add(rs.getString("assistid"));
                    }
                    System.out.println(asslist);
        
                    conn.close();
                }
                catch(Exception e)
                {
                    System.out.println("     "+e);
                }
      
                String[] assarr=new String[asslist.size()];
                asslist.toArray(assarr);
      
                JComboBox assidbox=new JComboBox(assarr);
                assidbox.setBounds(240,200,160,30);
                assidbox.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                assidbox.setBackground(Color.white);
      
      
                JTextArea tfassreason=new JTextArea();
     
      
                tfassreason.setBounds(140,280,230,50);   
                tfassreason.setBorder(javax.swing.BorderFactory.createEmptyBorder());
                tfassreason.setBackground(Color.white);      
                tfassreason.setBackground(new Color(217,217,217));            
                tfassreason.setEditable(true);
      
                cancel.add(tfassreason);
                cancel.add(assidbox);
                cancel.add(basscan);
                cancel.add(labelasscan);
      
                basscan.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            String assistid=assidbox.getSelectedItem().toString();
                            String reason=tfassreason.getText().toString();
                 
                            if(assistid.isEmpty()||assistid.equals('-')){
                                Error e=new Error();
                                e.errordis("Select assist id","Check again"); 
                            }
                            else if(reason.isEmpty()){
                                Error e=new Error();
                                e.errordis("Please enter reason","Pls"); 
                            }
                            else{
                
                                try{
                                    Class.forName("com.mysql.jdbc.Driver");
                       
                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                                    Statement st=conn.createStatement();
                                    String s="UPDATE assist set status='cancelled',reason='"+reason+"' where assistid='"+assistid+"'";
                                    st.executeUpdate(s);
                                    System.out.println("Success!");
                                    String sql = "SELECT workerid from assist a where assistid='"+assistid+"'";
                                    ResultSet rs    = st.executeQuery(sql); 
                                    int workerid=0;
                                    while(rs.next()){
                                              workerid=rs.getInt("workerid");
                                    }
                                    String s1="update workers set workerstatus='free' where workerid='"+workerid+"'";
                                    st.executeUpdate(s1);
                                    messageboxasscancel m=new messageboxasscancel();
                                    m.message();
                                    conn.close();
                                   }
                                catch(Exception e){
                                System.out.println("     "+e);
                             }           
                
                            }
                     }
                    });
                   
               cancel.updateUI();
               schedule.setVisible(false);
               dashboard.setVisible(false);
               cancel.setVisible(true);
               order.setVisible(false);
            }
        });
      

      
      frame.setLayout(null);
      frame.setVisible(true);    
    
    
    
    }
    public static void main(String[] args){
             dashboard d=new dashboard();
             d.dash(1);
    }
    
    public class messageboxapp {
    
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
      
      Icon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img25.png");
      JButton b = new JButton(icons);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(190,100,200,100); 
      frame1.add(b);
      
      ImageIcon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img24.png");
      JLabel labels = new JLabel(icon);
      labels.setBounds(3,15,350,150); 
      frame1.add(labels);
      
      b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                frame1.setVisible(false);
                
                
            }            
        });
      
      
      frame1.setLayout(null);
      frame1.setVisible(true);
    }
    
    
    }
    
    public class messageboxplace {
    
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
      
      Icon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img25.png");
      JButton b = new JButton(icons);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(190,100,200,100); 
      frame1.add(b);
      
      ImageIcon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img43.png");
      JLabel labels = new JLabel(icon);
      labels.setBounds(3,15,350,150); 
      frame1.add(labels);
      
      b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                frame1.setVisible(false);
                
                
            }            
        });
      
      
      frame1.setLayout(null);
      frame1.setVisible(true);
    }
    
    
    }
    
    public class messageboxappcancel {
    
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
      
      Icon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img25.png");
      JButton b = new JButton(icons);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(190,100,200,100); 
      frame1.add(b);
      
      ImageIcon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img35.png");
      JLabel labels = new JLabel(icon);
      labels.setBounds(3,15,350,150); 
      frame1.add(labels);
      
      b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                frame1.setVisible(false);
                
                
            }            
        });
      
      
      frame1.setLayout(null);
      frame1.setVisible(true);
    }
    
    
    }
    
    public class messageboxasscancel {
    
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
      
      Icon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img25.png");
      JButton b = new JButton(icons);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(190,100,200,100); 
      frame1.add(b);
      
      ImageIcon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img36.png");
      JLabel labels = new JLabel(icon);
      labels.setBounds(3,15,350,150); 
      frame1.add(labels);
      
      b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                frame1.setVisible(false);
                
                
            }            
        });
      
      
      frame1.setLayout(null);
      frame1.setVisible(true);
    }
    
    
    }
    
    public class messageboxass {
    
    public void message(String workshop,String name, String no,String time){
    
      JFrame frame1 = new JFrame();
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.setUndecorated(true);
      
      double x = 0;
      double y = 0;
      frame1.setShape(new RoundRectangle2D.Double(x, y,400,200, 50, 50));
      frame1.setSize(400, 200);
      frame1.setBounds(600,250,400,200); 
      frame1.getContentPane().setBackground(new Color(160,237,240));
      
       JLabel ta=new JLabel(time+" mins");
      ta.setBounds(300,10,200,70); 
      ta.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      ta.setForeground(Color.black);
      frame1.add(ta);
      
      JLabel t=new JLabel(workshop);
      t.setBounds(190,50,200,70); 
      t.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      t.setForeground(Color.black);
      frame1.add(t);
      
      
      
      JLabel t1=new JLabel(name);
      t1.setBounds(190,73,200,70); 
      t1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      t1.setForeground(Color.black);
      frame1.add(t1);
      
      
      
      JLabel t2=new JLabel(no);
      t2.setBounds(190,99,200,70); 
      t2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      t2.setForeground(Color.black);
      frame1.add(t2);
      
      Icon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img25.png");
      JButton b = new JButton(icons);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(240,115,200,100); 
      frame1.add(b);
      
      ImageIcon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img28.png");
      JLabel labels = new JLabel(icon);
      labels.setBounds(3,15,350,150); 
      frame1.add(labels);
      
      b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                frame1.setVisible(false);
                
                
            }            
        });
      
      
      frame1.setLayout(null);
      frame1.setVisible(true);
    }
    
    
    }
    
    public class messageplacecancel {
    
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
      
      
      
      
      Icon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img25.png");
      JButton b = new JButton(icons);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(200,110,200,100); 
      frame1.add(b);
      
      ImageIcon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img48.png");
      JLabel labels = new JLabel(icon);
      labels.setBounds(3,15,350,150); 
      frame1.add(labels);
      
      b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                frame1.setVisible(false);
                
                
            }            
        });
      
      
      frame1.setLayout(null);
      frame1.setVisible(true);
    }
    
    
    }
    
    
    
}
