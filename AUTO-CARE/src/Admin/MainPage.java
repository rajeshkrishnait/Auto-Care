package Admin;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;

public class MainPage extends JFrame
{
JButton log,reg;
JPanel contentPane;
JTextPane p;
JLabel label,a;
MainPage()
{
setLayout(null);
Container c=getContentPane();
contentPane = new JPanel();
log= new JButton("Login");
log.setFont(new Font("Courier New", Font.BOLD, 15));
log.setBackground(Color.WHITE);
reg= new JButton("Register");
reg.setFont(new Font("Courier New", Font.BOLD, 15));
reg.setBackground(Color.WHITE);

log.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
new Login();
dispose();
}
});
reg.addActionListener((ActionEvent e) -> {
    new MyFrame();
dispose();

});
Frame f=new JFrame();
Image icon = Toolkit.getDefaultToolkit().getImage("C:\\AUTO CARE\\admin-images.jpg");
setTitle("Admin Login Page");
setIconImage(icon);
ImageIcon imageIcon = new ImageIcon("C:\\AUTO CARE\\by-my-car-illustration-concept.jpg");
label = new JLabel(imageIcon);
label.setBounds(5,40,626,417);
add(label);
a=new JLabel();
a.setText("AUTO-CARE");
a.setBounds(00,00,1376,768);
a.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 25));

add(a);
log.setBounds(650,200,200,30);
log.setForeground(Color.BLACK);
add(log);
reg.setBounds(650,300,200,30);
reg.setForeground(Color.BLACK);
add(reg);

setSize(900,500);
setVisible(true);
c.setBackground(Color.white);
addWindowListener(new WindowAdapter(){
@Override
public void windowClosing(WindowEvent e) {
dispose();
}
});
}
public static void main(String[] args)
{
JFrame.setDefaultLookAndFeelDecorated(true);
new MainPage();

}
}