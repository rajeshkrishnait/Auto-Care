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
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JPasswordField;
/**
 *
 * @author PROJECTS
 */
public class login {
    public void log(){
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setUndecorated(true);
      
      double x = 0;
      double y = 0;
      frame.setShape(new RoundRectangle2D.Double(x, y,1200,600, 50, 50));
      frame.setSize(1200, 600);
      frame.setBounds(30,30,1200,600); 
      frame.getContentPane().setBackground(Color.white);
      
      Icon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img10.png");
      JButton b = new JButton(icon);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(750,400,250,100); 
      frame.add(b);
      
      
      
      JTextField tf1=new JTextField();
      JPasswordField tf2=new JPasswordField();
      
      
      tf1.setBounds(820,220,210,50);  
      tf2.setBounds(730,323,300,50); 
      
      
      
      tf1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      tf2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      
      
      tf1.setBackground(new Color(217,217,217));
      tf2.setBackground(new Color(217,217,217));
      
      
      
      frame.add(tf1);
      frame.add(tf2);
      
      
      ImageIcon iconss = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img1.png");
      JLabel labels = new JLabel(iconss);
      labels.setBounds(10,70,500,500); 
      frame.add(labels);
      
      ImageIcon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img9.png");
      JLabel label = new JLabel(icons);
      label.setBounds(650,-25,500,500); 
      frame.add(label);
      
       b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                try
                                {
                                    Class.forName("com.mysql.jdbc.Driver");

                                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");

                                    Statement st=conn.createStatement();
                                    String pass=new String(tf2.getPassword());
                                    String sql = "select userid,username,password,status from users where username='"+tf1.getText().toString()+"' and password='"+pass+"';";
                                    ResultSet rs    = st.executeQuery(sql);           
                                    // loop through the result set                                    
                                    
                                    boolean success=false;
                                    int userid=0;int flag=0;
                                    while(rs.next())
                                    {
                                        userid=rs.getInt("userid");
                                        if(rs.getString("status").equals("Blocked"))
                                        {
                                            Error w=new Error();
                                            w.errordis("You are Blocked from entry","");
                                            flag=1;
                                        }
                                        else
                                        {
                                            success=true;
                                        }
                                    }
                                    
                                    if(success==true){  
                                                                             
                                        
                                        
                                        dashboard d=new dashboard();
                                        d.dash(userid);
                                        frame.setVisible(false);
                                        System.out.println("loginsuccessful");
                                    }
                                    else if(success==false && flag==0)
                                    {
                                       Error e=new Error();
                                       e.errordis("Login Unsuccessful","Check entries !!! retry again!!!");
                                       System.out.println("not successful");
                                    }
                                    else
                                    {
                                            
                                    }
                                    
                                    conn.close();
                                    
                                    
                                    
                                    
                                            
                   
                                    
                                    
                                }
                                catch(Exception e)
                                {
                                    System.out.println("     "+e);
                                }
                
                
            }
        });
      
      frame.setLayout(null);
      frame.setVisible(true);    
    
    
    }
}

