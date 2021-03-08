/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admin;




import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import static javafx.scene.paint.Color.color;
  
class MyFrame extends JFrame  { 
  
   
    private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JTextField tname; 
    private JLabel mno; 
    private JTextField tmno; 
     private JLabel city; 
    private JTextField tcity;
     private JLabel state; 
    private JTextField tstate;
      private JLabel Admin_name; 
    private JTextField tAdmin_name;
    private JLabel pass;
    private JTextField tpass;
    private JLabel pass2;
    private JTextField tpass2;
    private JLabel pincode; 
    private JTextField tpincode;
    private JLabel add1,add2; 
    private JTextField tadd1,tadd2; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd; 
  

    public MyFrame() 
    { 
        Color pwhite=new Color(244,248,247);  
        setTitle("Admin Registration Form"); 
        setBounds(0, 0, 1366, 768); 
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        //setResizable(false); 
        
         Color white=new Color(255,255,255);  
        Color blue=new Color(0,98,205); 
         Color hblue=new Color(34,72,102); 
  
        c = getContentPane(); 
        c.setLayout(null); 
        c.setBackground(white);
  
        title = new JLabel("Admin Registration Form"); 
        title.setFont(new Font("bold", Font.PLAIN, 30)); 
        title.setSize(370, 40); 
        
        title.setLocation(140, 30); 
        c.add(title); 
        
        
        
        Admin_name = new JLabel("Workshop Name"); 
        Admin_name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        Admin_name.setSize(200, 20); 
        Admin_name.setLocation(60, 100); 
        Admin_name.setForeground(hblue);
        c.add(Admin_name); 
  
        tAdmin_name = new JTextField(); 
        tAdmin_name.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tAdmin_name.setSize(190, 20); 
        tAdmin_name.setLocation(250, 100); 
        tAdmin_name.setBackground(pwhite);
        c.add(tAdmin_name);
  
        name = new JLabel("Workshop Username"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(250, 20); 
        name.setForeground(hblue);
        name.setLocation(60, 150); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(190, 20); 
        tname.setLocation(250, 150); 
        tname.setBackground(pwhite);
        c.add(tname); 
  
        mno = new JLabel("Mobile Number"); 
        mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mno.setSize(200, 20); 
        mno.setForeground(hblue);
        mno.setLocation(60, 200); 
        c.add(mno); 
  
        tmno = new JTextField(); 
        tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmno.setSize(190, 20); 
        tmno.setLocation(250, 200); 
        tmno.setBackground(pwhite);
        c.add(tmno); 
        
        pass = new JLabel("Password"); 
        pass.setFont(new Font("Arial", Font.PLAIN, 20)); 
        pass.setSize(200, 20);
        pass.setForeground(hblue);
        pass.setLocation(60, 250); 
        c.add(pass); 
  
        tpass = new JTextField(); 
        tpass.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpass.setSize(190, 20); 
        tpass.setBackground(pwhite);
        tpass.setLocation(250, 250); 
        c.add(tpass); 
        
        pass2 = new JLabel("Re-Enter Password"); 
        pass2.setFont(new Font("Arial", Font.PLAIN, 20)); 
        pass2.setSize(200, 20); 
        pass2.setForeground(hblue);
        pass2.setLocation(60, 300); 
        c.add(pass2); 
  
        tpass2 = new JTextField(); 
        tpass2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpass2.setSize(190, 20); 
        tpass2.setLocation(250, 300); 
        tpass2.setBackground(pwhite);
        c.add(tpass2);
        
        add1 = new JLabel("Address line 1"); 
        add1.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add1.setSize(250, 20);
        add1.setForeground(hblue);
        add1.setLocation(60, 350); 
        c.add(add1); 
  
        tadd1 = new JTextField(); 
        tadd1.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd1.setSize(250, 20); 
        tadd1.setLocation(250, 350); 
        tadd1.setBackground(pwhite);
        c.add(tadd1); 
        
        add2 = new JLabel("Address line 2"); 
        add2.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add2.setSize(250, 20); 
        add2.setForeground(hblue);
        add2.setLocation(60, 400); 
        c.add(add2); 
  
        tadd2 = new JTextField(); 
        tadd2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd2.setSize(250, 20); 
        tadd2.setBackground(pwhite);
        tadd2.setLocation(250, 400); 
        c.add(tadd2); 
       
  
       
  
        
        
        city = new JLabel("city"); 
        city.setFont(new Font("Arial", Font.PLAIN, 20)); 
        city.setSize(100, 20); 
        city.setForeground(hblue);
        city.setLocation(60, 450); 
        c.add(city); 
  
        tcity = new JTextField(); 
        tcity.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tcity.setSize(190, 20); 
        tcity.setBackground(pwhite);
        tcity.setLocation(250, 450); 
        c.add(tcity);
        
        state = new JLabel("state"); 
        state.setFont(new Font("Arial", Font.PLAIN, 20)); 
        state.setSize(100, 20);
        state.setForeground(hblue);
        state.setLocation(60, 500); 
        c.add(state); 
  
        tstate = new JTextField(); 
        tstate.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tstate.setSize(190, 20); 
        tstate.setBackground(pwhite);
        tstate.setLocation(250, 500); 
        c.add(tstate);
        
        
        
         pincode = new JLabel("pincode"); 
        pincode.setFont(new Font("Arial", Font.PLAIN, 20)); 
        pincode.setSize(100, 20);
        pincode.setForeground(hblue);
        pincode.setLocation(60, 550); 
        c.add(pincode); 
  
        tpincode = new JTextField(); 
        tpincode.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tpincode.setSize(190, 20); 
        tpincode.setBackground(pwhite);
        tpincode.setLocation(250, 550); 
        c.add(tpincode);
        
  
        term = new JCheckBox("Accept Terms And Conditions."); 
        term.setFont(new Font("bold", Font.PLAIN, 15)); 
        term.setSize(250, 20); 
        term.setBackground(white);
        term.setLocation(250, 600); 
        c.add(term); 
  
        sub = new JButton("Register"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setForeground(white);
        sub.setSize(100, 20); 
        sub.setBackground(blue);
        sub.setLocation(250, 650); 
        sub.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                if (term.isSelected()) { 
                        if(tpass.getText().equals(tpass2.getText()))
                    {
                        try{
                        
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                PreparedStatement ps = con.prepareStatement("insert into Admin(name,adminname,passwords,mobileno,addrees1,address2,district,state,pincode) values(?,?,?,?,?,?,?,?,?)");
                ps.setString(1, tAdmin_name.getText());
                ps.setString(2, tname.getText());
                PreparedStatement ps1 = con.prepareStatement("select * from Admin where adminname='"+tname.getText()+"' ");
                ResultSet rs=ps1.executeQuery();
                ps.setString(3, tpass.getText());
                System.out.println(tmno.getText());
                //int num= Integer.parseInt(tmno.getText());
                
                ps.setString(4,tmno.getText());
                
                ps.setString(5, tadd1.getText());
                ps.setString(6, tadd2.getText());
                ps.setString(7, tcity.getText());
                ps.setString(8,tstate.getText());
                ps.setInt(9,Integer.parseInt(tpincode.getText()));
                
                if(!(rs.next()))
                    {
                        if(tpass.getText().length()<8)
                        {
                            JOptionPane.showMessageDialog(rootPane,"Password must atleast contain 8 character");
                        }
                       
                        else 
                        {
                               if((tmno.getText()).length()!=10 )
                                {
                                    JOptionPane.showMessageDialog(rootPane,"Entered Mobile Number Does'nt exist");
                                }
                               else
                               {
                                   if(tpincode.getText().length()!=6)
                                   {
                                       JOptionPane.showMessageDialog(rootPane,"Pincode does not exist");
                                   }
                                   else
                                   {
                                       ps.executeUpdate();
                                       JOptionPane.showMessageDialog(rootPane,"You have Registered Successfully");
                                       new Login();
                                   }
                               }
                       }
                        
                    }
                else
                    {
                        JOptionPane.showMessageDialog(rootPane,"Username already taken");
                    }
                con.close();
                } 
                    catch(Exception exp)
                {
                        JOptionPane.showMessageDialog(rootPane,exp);
                }
                }
                 else
                    {
                            JOptionPane.showMessageDialog(rootPane,"Passwords do not match");
                    }
           
        } 
        else
        {
            JOptionPane.showMessageDialog(rootPane,"Accept Our Terms and Conditions");
        }
            }
        }); 
        c.add(sub); 
        setBounds(0,0,600,768);
        setVisible(true);
}
    
}
   
     

class JavaApplication14 { 
  
    public static void main(String[] args) 
    { 
        new MyFrame(); 
    } 
}

