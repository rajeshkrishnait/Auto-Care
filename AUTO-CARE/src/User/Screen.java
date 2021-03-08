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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author PROJECTS
 */
public class Screen {
    public void scr(){
      JFrame frame = new JFrame();
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setUndecorated(true);
      
      double x = 0;
      double y = 0;
      frame.setShape(new RoundRectangle2D.Double(x, y,1200,600, 50, 50));
      frame.setSize(1200, 600);
      frame.setBounds(30,30,1200,600); 
      frame.getContentPane().setBackground(Color.white);
      
      
      Icon icon = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img3.png");
      JButton log = new JButton(icon);
      log.setBorderPainted(false);
      log.setFocusPainted(false);
      log.setContentAreaFilled(false);
      log.setBounds(790,215,250,100); 
      frame.add(log);
      
      
      Icon icon1 = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img4.png");
      JButton reg = new JButton(icon1);
      reg.setBorderPainted(false);
      reg.setFocusPainted(false);
      reg.setContentAreaFilled(false);
      reg.setBounds(790,380,250,100); 
      frame.add(reg);
      
      
      log.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                login l=new login();
                l.log();
                frame.setVisible(false);  
            }
        });
      
      reg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                     Register r=new Register();
                     r.reg();
                     frame.setVisible(false);
            }
        });
      
      ImageIcon iconss = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img1.png");
      JLabel labels = new JLabel(iconss);
      labels.setBounds(10,70,500,500); 
      frame.add(labels);
      
      ImageIcon icons = new ImageIcon("C:\\Users\\PROJECTS\\Desktop\\projects\\New folder\\img2.png");
      JLabel label = new JLabel(icons);
      label.setBounds(550,-15,700,600); 
      frame.add(label);
      
      
      frame.setLayout(null);
      frame.setVisible(true);    
    
    
    
    }
}
