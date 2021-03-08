/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *
 * @author PROJECTS
 */
public class table {
    
    public void tables(int userid){
    
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setUndecorated(true);
      
      double x = 0;
      double y = 0;
      frame.setShape(new RoundRectangle2D.Double(x, y,1200,600, 50, 50));
      frame.setSize(1200, 600);
      frame.setBounds(30,30,1200,600); 
      frame.getContentPane().setBackground(Color.white);
      
      
      Icon iconclose = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img56.png");
      JButton close= new JButton(iconclose);
      close.setBorderPainted(false);
      close.setFocusPainted(false);
      close.setContentAreaFilled(false);
      close.setBounds(930,500,250,100); 
      
      frame.add(close);
      
       close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                frame.setVisible(false);
                dashboard d=new dashboard();
                d.dash(userid);
                
            }            
        });
      
       Icon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img50.png");
      JButton b = new JButton(icon);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(-50,30,250,100); 
      frame.add(b);
      
      
      
      Icon icon1 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img53.png");
      JButton b1 = new JButton(icon1);
      b1.setBorderPainted(false);
      b1.setFocusPainted(false);
      b1.setContentAreaFilled(false);
      b1.setBounds(-50,100,250,100); 
      frame.add(b1);
      
       Icon icon2 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img51.png");
        Icon icon3 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img52.png");
      ImageIcon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img19.png");
      JLabel label = new JLabel(icons);
      label.setBounds(0,0,150,800); 
      frame.add(label);
      
      JPanel assist=new JPanel();
      assist.setBackground(Color.white);
      
      ImageIcon iconass = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img54.png");
      JLabel labelass = new JLabel(iconass);
      labelass.setBounds(0,-15,900,600); 

      
      assist.add(labelass);
      assist.setLayout(null);  
      assist.setBounds(150,0,1150,600);
      
      
                
                try
       {
       Class.forName("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
       Statement st=conn.createStatement();
       
        JTextArea asstablet1;
        JTextArea asstablet2;
        JTextArea asstablet3;
        JTextArea asstablet4;
        
        
        String s = "select assistid,name,timestamp,status from assist a join workers w ON a.workerid=w.workerid join admin ad ON ad.adminid=w.adminid  where userid='"+userid+"'";
        ResultSet r    = st.executeQuery(s); 
        String t1="";
        String t2="";
        String t3="";
        String t4="";
        
        
        asstablet1=new JTextArea("");
        asstablet1.setBounds(100,120,20,400); 
        asstablet1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet1.setBackground(new Color(255, 229, 127));
        asstablet1.setEditable(false);
        
        
        asstablet2=new JTextArea("");
        asstablet2.setBounds(190,120,150,400); 
        asstablet2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet2.setBackground(new Color(255, 229, 127));
        asstablet2.setEditable(false);
        
        
        asstablet3=new JTextArea("");
        asstablet3.setBounds(420,120,230,400); 
        asstablet3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet3.setBackground(new Color(255, 229, 127));
        asstablet3.setEditable(false);
        
        
        asstablet4=new JTextArea("");
        asstablet4.setBounds(710,120,70,400); 
        asstablet4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet4.setBackground(new Color(255, 229, 127));
        asstablet4.setEditable(false);
        
        
        while(r.next()){
           t1=t1+"\n"+r.getString("assistid");
           t2=t2+"\n"+r.getString("timestamp");
           t3=t3+"\n"+r.getString("name");
           t4=t4+"\n"+r.getString("status");
        }
        asstablet1.setText(t1);
        asstablet2.setText(t2);
        asstablet3.setText(t3);
        asstablet4.setText(t4);
        
        assist.add(asstablet1);
        assist.add(asstablet2);
        assist.add(asstablet3);
        assist.add(asstablet4);
        
        
        
        
       
        
       
        conn.close();
       }
       catch(Exception e)
       {
        System.out.println("     "+e);
       }
      
                assist.add(labelass);
                
      assist.setVisible(true);
      frame.add(assist);
      
      
      JPanel appointment=new JPanel();
      appointment.setBackground(Color.white);
      
      appointment.setLayout(null);  
      appointment.setBounds(150,0,1150,600);
      
      
      appointment.setVisible(true);
      frame.add(appointment);
      
      
      
       b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                
                assist.removeAll();
                assist.revalidate();
                assist.repaint();
                assist.setVisible(true);
                
                b.setIcon(icon);
                b1.setIcon(icon1);
                
                ImageIcon iconass = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img54.png");
                JLabel labelass = new JLabel(iconass);
                labelass.setBounds(0,-15,900,600); 
                
                try
       {
       Class.forName("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
       Statement st=conn.createStatement();
       
        JTextArea asstablet1;
        JTextArea asstablet2;
        JTextArea asstablet3;
        JTextArea asstablet4;
        
        
        String s = "select assistid,name,timestamp,status from assist a join workers w ON a.workerid=w.workerid join admin ad ON ad.adminid=w.adminid  where userid='"+userid+"'";
        ResultSet r    = st.executeQuery(s); 
        String t1="";
        String t2="";
        String t3="";
        String t4="";
        
        
        asstablet1=new JTextArea("");
        asstablet1.setBounds(100,120,20,400); 
        asstablet1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet1.setBackground(new Color(255, 229, 127));
        asstablet1.setEditable(false);
        
        
        asstablet2=new JTextArea("");
        asstablet2.setBounds(190,120,150,400); 
        asstablet2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet2.setBackground(new Color(255, 229, 127));
        asstablet2.setEditable(false);
        
        
        asstablet3=new JTextArea("");
        asstablet3.setBounds(420,120,230,400); 
        asstablet3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet3.setBackground(new Color(255, 229, 127));
        asstablet3.setEditable(false);
        
        
        asstablet4=new JTextArea("");
        asstablet4.setBounds(710,120,70,400); 
        asstablet4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        asstablet4.setBackground(new Color(255, 229, 127));
        asstablet4.setEditable(false);
        
        
        while(r.next()){
           t1=t1+"\n"+r.getString("assistid");
           t2=t2+"\n"+r.getString("timestamp");
           t3=t3+"\n"+r.getString("name");
           t4=t4+"\n"+r.getString("status");
        }
        asstablet1.setText(t1);
        asstablet2.setText(t2);
        asstablet3.setText(t3);
        asstablet4.setText(t4);
        
        assist.add(asstablet1);
        assist.add(asstablet2);
        assist.add(asstablet3);
        assist.add(asstablet4);
        
        
        
        
       
        
       
        conn.close();
       }
       catch(Exception e)
       {
        System.out.println("     "+e);
       }
      
                assist.add(labelass);
                
               assist.updateUI();
               assist.setVisible(true);
               appointment.setVisible(false);
               
            }
        });
       
       b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                b.setIcon(icon2);
                b1.setIcon(icon3);
                appointment.removeAll();
                appointment.revalidate();
                appointment.repaint();
                appointment.setVisible(true);
                
                 ImageIcon iconapp = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img55.png");
                JLabel labelapp = new JLabel(iconapp);
                labelapp.setBounds(0,-15,900,600); 
                
                try
       {
       Class.forName("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
       Statement st=conn.createStatement();
       
        JTextArea apptablet1;
        JTextArea apptablet2;
        JTextArea apptablet3;
        JTextArea apptablet4;
        
        
        String s = "select appointmentid,name,id,date,status from appointments a join admin ad ON ad.adminid=a.adminid  where userid='"+userid+"'";
        ResultSet r    = st.executeQuery(s); 
        String t1="";
        String t2="";
        String t3="";
        String t4="";
        
        
        apptablet1=new JTextArea("");
        apptablet1.setBounds(100,120,20,400); 
        apptablet1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        apptablet1.setBackground(new Color(255, 229, 127));
        apptablet1.setEditable(false);
        
        
        apptablet2=new JTextArea("");
        apptablet2.setBounds(190,120,150,400); 
        apptablet2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        apptablet2.setBackground(new Color(255, 229, 127));
        apptablet2.setEditable(false);
       
        
        apptablet3=new JTextArea("");
        apptablet3.setBounds(420,120,230,400); 
        apptablet3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        apptablet3.setBackground(new Color(255, 229, 127));
        apptablet3.setEditable(false);
        
        
        apptablet4=new JTextArea("");
        apptablet4.setBounds(710,120,70,400); 
        apptablet4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        apptablet4.setBackground(new Color(255, 229, 127));
        apptablet4.setEditable(false);
        
        
        while(r.next()){
           t1=t1+"\n"+r.getString("appointmentid");
           t2=t2+"\n"+r.getString("date")+"   "+r.getString("id").substring(0,8);
           t3=t3+"\n"+r.getString("name");
           t4=t4+"\n"+r.getString("status");
        }
        apptablet1.setText(t1);
        apptablet2.setText(t2);
        apptablet3.setText(t3);
        apptablet4.setText(t4);
        
        appointment.add(apptablet1);
        appointment.add(apptablet2);
        appointment.add(apptablet3);
        appointment.add(apptablet4);
        
        
        
        
       
        
       
        conn.close();
       }
       catch(Exception e)
       {
        System.out.println("     "+e);
       }
      
                appointment.add(labelass);
                
                
                
               appointment.updateUI();
               appointment.setVisible(true);
               assist.setVisible(false);
               
            }

          
        });
      
      
      
      
      
      frame.setLayout(null);
      frame.setVisible(true);  
    
    }
    
    
    
    
    public static void main(String[] args){
    
       table t=new table();
       t.tables(1);
    }
}
