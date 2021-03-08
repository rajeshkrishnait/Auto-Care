
package Admin;
import static Admin.Login.*;
import static Admin.Admin.createImageIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Profile extends DeliveryDetails {
    JPanel p8;
    JLabel adminid,adminname,mobileno,address1,address2,district,state,pincode,l_currentpass,l_newpass;
    JTextField tf_adminid,tf_adminname,tf_mobileno,tf_address1,tf_address2,tf_district,tf_state,tf_pincode,tf_currentpass,tf_newpass;
    JButton b_edit,b_submit,b_changepass,b_ref7,b_submit1;
    Profile(){
        p8 = new JPanel();
        
        String icont1 = "/resources/profile.jpg";
        ImageIcon icon = createImageIcon(icont1);
        
        tp.addTab("PROFILE",icon,p8,"View Your Profile");
        p8.setLayout(null);
        p8.setBackground(Color.WHITE);
        tp.setBackgroundAt(7,Color.WHITE);
        

        adminid = new JLabel("AdminID");
        adminid.setBounds(100,50,100,40);
        p8.add(adminid);
        adminname = new JLabel("Name");
        adminname.setBounds(100,120,100,40);
        p8.add(adminname);
        mobileno = new JLabel("MobileNo");
        mobileno.setBounds(100,190,100,40);
        p8.add(mobileno);
        address1 = new JLabel("Addres1");
        address1.setBounds(100,260,100,40);
        p8.add(address1);
        address2 = new JLabel("Address2");
        address2.setBounds(100,330,100,40);
        p8.add(address2);
        district = new JLabel("District");
        district.setBounds(100,400,100,40);
        p8.add(district);
        state = new JLabel("State");
        state.setBounds(100,470,100,40);
        p8.add(state);
        pincode = new JLabel("Pincode");
        pincode.setBounds(100,540,100,40);
        p8.add(pincode);
        
        tf_adminid = new JTextField();
        tf_adminid.setBounds(200,50,250,40);
        p8.add(tf_adminid);
        tf_adminid.setEditable(false);
        tf_adminname = new JTextField();
        tf_adminname.setBounds(200,120,250,40);
        p8.add(tf_adminname);
        tf_adminname.setEditable(false);
        tf_mobileno = new JTextField();
        tf_mobileno.setBounds(200,190,250,40);
        p8.add(tf_mobileno);
        tf_mobileno.setEditable(false);
        tf_address1 = new JTextField();
        tf_address1.setBounds(200,260,250,40);
        tf_address1.setEditable(false);
        p8.add(tf_address1);
        tf_address2 = new JTextField();
        tf_address2.setBounds(200,330,250,40);
        p8.add(tf_address2);
        tf_address2.setEditable(false);
        tf_district = new JTextField();
        tf_district.setBounds(200,400,250,40);
        p8.add(tf_district);
        tf_district.setEditable(false);
        tf_state = new JTextField();
        tf_state.setBounds(200,470,250,40);
        p8.add(tf_state);
        tf_state.setEditable(false);
        tf_pincode = new JTextField();
        tf_pincode.setBounds(200,540,250,40);
        p8.add(tf_pincode);
        tf_pincode.setEditable(false);
        
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject", "root", "Ram03");
                Statement st = con.createStatement();
                String query = "select * from admin where adminid = '"+AID+"'";
                ResultSet rs = st.executeQuery(query);
                if(rs.next()){
                    tf_adminid.setText(rs.getString(1));
                    tf_adminname.setText(rs.getString(2));
                    tf_mobileno.setText(rs.getString(5));
                    tf_address1.setText(rs.getString(6));
                    tf_address2.setText(rs.getString(7));
                    tf_district.setText(rs.getString(8));
                    tf_state.setText(rs.getString(9));
                    tf_pincode.setText(rs.getString(10));
                }
                con.close();
        }
        catch(Exception ex){
            JOptionPane.showMessageDialog(rootPane,ex);
        }
        
        //Code for REfreshing the Entire ADmin Profile(Module)
        b_ref7 = new JButton();
        b_ref7.setText("REFRESH ALL");
        b_ref7.setBounds(750,180,180,40);
        p8.add(b_ref7);
        b_ref7.setBackground(Color.WHITE);
        b_ref7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                dispose();
                new Stock();
                
            }
        });
        
        //Code for Edit Profile
        b_submit = new JButton();
        b_submit.setText("SUBMIT");
        b_submit.setBounds(750,260,180,40);
        p8.add(b_submit);
        b_submit.setVisible(false);
        b_submit.setBackground(Color.WHITE);
        b_submit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                b_edit.setVisible(true);
                b_submit.setVisible(false);
               
                tf_adminname.setEditable(false);
                tf_mobileno.setEditable(false);
                tf_address1.setEditable(false);
                tf_address2.setEditable(false);
                tf_district.setEditable(false);
                tf_state.setEditable(false);
                tf_pincode.setEditable(false);
                
                String name,mobileno,address1,address2,district,state,pincode;
                name = tf_adminname.getText();
                mobileno = tf_mobileno.getText();
                address1 = tf_address1.getText();
                //address2 = tf_address2.getText();
                //district = tf_district.getText();
                //state = tf_state.getText();
                //pincode = tf_pincode.getText();
                
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st = con.createStatement();
                    String query = "update admin set name='"+name+"',mobileno='"+mobileno+"',address1='"+address1+"' where adminid='"+AID+"'";
                    st.executeUpdate(query);
                    //,address2='"+address2+"',district='"+district+",state='"+state+",pincode='"+pincode+"'
                    con.close();
                    JOptionPane.showMessageDialog(rootPane,"Changes Saved");
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane,ex);
                }
                
            }
        });
        
        b_edit = new JButton();
        b_edit.setText("EDIT PROFILE");
        b_edit.setBounds(750,260,180,40);
        p8.add(b_edit);
        b_edit.setVisible(true);
        b_edit.setBackground(Color.WHITE);
        b_edit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //tf_adminid.setEditable(true);
                tf_adminname.setEditable(true);
                tf_mobileno.setEditable(true);
                tf_address1.setEditable(false);
                //tf_address2.setEditable(true);
                //tf_district.setEditable(true);
                //tf_state.setEditable(true);
                //tf_pincode.setEditable(true);
                
                b_edit.setVisible(false);
                b_submit.setVisible(true);
            }
        });
        
        //Code for Changing Password
        b_changepass = new JButton();
        b_changepass.setText("CHANGE PASSWORD");
        b_changepass.setBounds(750,340,180,40);
        p8.add(b_changepass);
        b_changepass.setBackground(Color.WHITE);
        b_changepass.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                l_currentpass.setVisible(true);
                l_newpass.setVisible(true);
                tf_currentpass.setVisible(true);
                tf_newpass.setVisible(true);
                b_submit1.setVisible(true);
            }
        });
        
        l_currentpass = new JLabel("Current Password");
        l_currentpass.setBounds(600,420,150,40);
        p8.add(l_currentpass);
        l_currentpass.setVisible(false);
        
        l_newpass = new JLabel("New Password");
        l_newpass.setBounds(610,490,150,40);
        p8.add(l_newpass);
        l_newpass.setVisible(false);
        
        tf_currentpass = new JTextField();
        tf_currentpass.setBounds(750,420,200,40);
        p8.add(tf_currentpass);
        tf_currentpass.setVisible(false);
        
        tf_newpass = new JTextField();
        tf_newpass.setBounds(750,490,200,40);
        p8.add(tf_newpass);
        tf_newpass.setVisible(false);
       
        b_submit1 = new JButton("SUBMIT");
        b_submit1.setBounds(800,560,150,40);
        p8.add(b_submit1);
        b_submit1.setVisible(false);
        b_submit1.setBackground(Color.WHITE);
        b_submit1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String currentpass,newpass,checkpass="";
               currentpass = tf_currentpass.getText();
               newpass = tf_newpass.getText();
               if(currentpass!=null && newpass!=null){
                   try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st = con.createStatement();
                    String query = "select * from admin where adminid='"+AID+"'";
                    ResultSet rs = st.executeQuery(query);
                    if(rs.next()){
                        checkpass = rs.getString("Passwords");
                    }
                    
                    if(checkpass.equals(currentpass)){
                        String query1 = "update admin set passwords='"+newpass+"'where adminid='"+AID+"'";
                        st.executeUpdate(query1);
                        JOptionPane.showMessageDialog(rootPane,"Password Changed Successfully");
                        l_currentpass.setVisible(false);
                        l_newpass.setVisible(false);
                        tf_currentpass.setVisible(false);
                        tf_newpass.setVisible(false);
                        b_submit1.setVisible(false);
                        
                    }
                    else{
                        JOptionPane.showMessageDialog(rootPane,"Password Mismatch");
                    }
                    con.close();
                   }
                   catch(Exception ex){
                       JOptionPane.showMessageDialog(rootPane,ex);
                   }
               }
                   
           } 
        });
    JButton b_logout;

	b_logout = new JButton();
        b_logout.setText("LOG OUT");
        b_logout.setBounds(750,100,180,40);
        p8.add(b_logout);
        b_logout.setBackground(Color.WHITE);
        b_logout.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new Login();
            }
        });

    }
    
    
    public static void main(String args[]){
        new Profile();
    }
}
