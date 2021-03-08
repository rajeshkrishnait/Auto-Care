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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author PROJECTS
 */
public class Error {
    public void errordis(String s,String a){
      JFrame frame1 = new JFrame();
      frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame1.setUndecorated(true);
      
      double x = 0;
      double y = 0;
      frame1.setShape(new RoundRectangle2D.Double(x, y,400,200, 50, 50));
      frame1.setSize(400, 200);
      frame1.setBounds(600,250,400,200); 
      frame1.getContentPane().setBackground(Color.white);
      
       JLabel t=new JLabel(s);
      t.setBounds(140,50,200,70); 
      t.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      t.setForeground(Color.red);
      frame1.add(t);
      
      JLabel t1=new JLabel(a);
      t1.setBounds(140,70,200,70); 
      t1.setBorder(javax.swing.BorderFactory.createEmptyBorder());
      t1.setForeground(Color.red);
      frame1.add(t1);
      
      
      Icon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img27.png");
      JButton b = new JButton(icons);
      b.setBorderPainted(false);
      b.setFocusPainted(false);
      b.setContentAreaFilled(false);
      b.setBounds(190,100,200,100); 
      frame1.add(b);
      
      ImageIcon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img26.png");
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
    public static void main(String[] args){
    
               Error e=new Error();
               e.errordis("Choose another time","It's already booked");
    }
}
