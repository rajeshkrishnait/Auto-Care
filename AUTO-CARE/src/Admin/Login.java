package Admin;
import static com.sun.java.accessibility.util.AWTEventMonitor.addTextListener;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import javax.swing.ImageIcon;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.security.util.Password;

class Login extends JFrame{
public static int AID;
JLabel p,a;
JLabel l1,l2;
JTextField t1;
JPasswordField t2;
JButton l,b;
JPanel contentPane;
Login(){

setLayout(null);
Container c=getContentPane();
contentPane = new JPanel();
Image icon = Toolkit.getDefaultToolkit().getImage("C:\\AUTO CARE\\admin-images.jpg");
setTitle("Admin Login Page");
setIconImage(icon);
l1=new JLabel("Admin Name");
l2=new JLabel("Password");

t1=new JTextField();

t1.setToolTipText("Enter admin name ");
t2=new JPasswordField();
addTextListener(new TextListener() {
@Override
public void textValueChanged(TextEvent e) {
String s1=t1.getText();
char[] password = t2.getPassword();
t2.getEchoChar();
}
});
l=new JButton("Login");
l.setBackground(Color.WHITE);
l.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
try {
Class.forName("com.mysql.jdbc.Driver");
Connection connection = (Connection)
DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
PreparedStatement st= (PreparedStatement) connection.prepareStatement("Select * from Admin where adminname=? ");
String s1=t1.getText();

st.setString(1, s1);
String s2=new String(t2.getPassword());
ResultSet rs = st.executeQuery();
if(rs.next())
{
if(s2.equals(rs.getString(4)))
{
JOptionPane.showMessageDialog(l,"You have successfully logged in");
AID=rs.getInt("adminid");
dispose();
new Stock();
}
else
{
JOptionPane.showMessageDialog(l,"username Password Does not Match");
}

}
else
{
JOptionPane.showMessageDialog(l,"Register to use our application");
}
}
catch (Exception ae)
{
System.out.println(" "+ae);
}
}
});
b=new JButton("Back");
b.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
new MainPage();
dispose();
}
});
b.setBackground(Color.WHITE);
l1.setBounds(100,120,100,25);
l1.setFont(new Font("Times New Roman",Font.BOLD,16));
contentPane.add(l1);

l2.setBounds(100,170,100,25);
l2.setFont(new Font("Times New Roman",Font.BOLD,16));

t1.setBounds(230,120,150,30);
t1.setFont(new Font("Candara", Font.BOLD, 14));
t1.setBackground(Color.LIGHT_GRAY);
t2.setBounds(230,170,150,30);
t2.setBackground(Color.LIGHT_GRAY);
l.setBounds(290,250,80,25);
l.setFont(new Font("Courier New", Font.BOLD, 14));
b.setBounds(150,250,80,25);
b.setFont(new Font("Courier New", Font.BOLD, 14));
ImageIcon imageIcon = new ImageIcon("C:\\AUTO CARE\\by-my-car-illustration-concept.jpg");
p= new JLabel(imageIcon);
p.setBounds(390,5,626,417);

add(l1);
add(l2);
add(t1);
add(t2);
add(l);
add(b);
add(p);
setSize(1020,500);
c.setBackground(Color.white);
setResizable(true);
setVisible(true);
}
public static void main(String args[]){
JFrame.setDefaultLookAndFeelDecorated(true);
new Login();
}
}