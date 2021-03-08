
package Admin;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class Custdetail extends ViewAllin {
    JPanel p6;
    JButton ref4,blockuser;
    JLabel l_userid;
    JTextField tf_userid;
    String ID;
    
    Custdetail(){
        p6 = new JPanel();
        
        String icont1 = "/resources/managecust.jpg";
        ImageIcon icon = createImageIcon(icont1);
        
        tp.addTab("Manage Customer Details",icon,p6,"Block User");
        p6.setLayout(null);
        tp.setBackgroundAt(5, Color.WHITE);
        p6.setBackground(Color.WHITE);
        
        new ShowTable();
        
        String icont2 = "/resources/refresh 2.jpg";
        ImageIcon b_icon = createImageIcon(icont2);
        
        ref4 = new JButton(b_icon);
        ref4.setText("REFRESH");
        ref4.setBounds(1150, 100, 120, 40);
        ref4.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new ShowTable();
           } 
        });
        p6.add(ref4);
        ref4.setBackground(Color.WHITE);
//code 
        l_userid = new JLabel("UserID");
        l_userid.setBounds(1110,200,50,40);
        p6.add(l_userid);
        
        tf_userid = new JTextField();
        tf_userid.setBounds(1180,200,150,40);
        p6.add(tf_userid);
        
        blockuser = new JButton("BLOCK USER");
        blockuser.setBounds(1140,250,150,40);
        p6.add(blockuser);
        blockuser.setBackground(Color.WHITE);
        blockuser.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
            try {
                ID = tf_userid.getText();
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "update users set status = 'Blocked' where userid='"+ID+"'";
                st.executeUpdate(query);
                con.close();
                JOptionPane.showMessageDialog(rootPane,"User  :  "+ID+"  Blocked ");
                new ShowTable();
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane,ex);
            }
           } 
        });   
    }
    
//class finding the number of records in a DataBase Table
    public class Count{
        Count(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "select count(*) from users";
                ResultSet rs = st.executeQuery(query);
                rs.next();
                count = rs.getInt(1);
            }
            catch(Exception ex){
                JOptionPane.showMessageDialog(rootPane,ex);
            }
        }
    }

    public class ShowTable {
        String [][]data;
        String[]colname;
        JTable jt1;
        ShowTable(){
            new Count();
            data = new String[count][10];
            String [] heading = {"userid","username","password","mobileno","address1","address2","district","state","pincode","status"};

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "select * from users";
                ResultSet rs = st.executeQuery(query);

                int row = 0;
                while(rs.next()) {
                    data[row][0] = rs.getString("userid");
                    //data[row][1] = rs.getString("name");
                    data[row][1] = rs.getString("username");
                    data[row][2] = rs.getString("password");
                    data[row][3] = rs.getString("mobileno");
                    data[row][4] = rs.getString("address1");
                    data[row][5] = rs.getString("address2");
                    data[row][6] = rs.getString("district");
                    data[row][7] = rs.getString("state");
                    data[row][8] = rs.getString("pincode");
                    data[row][9] = rs.getString("status");
                    row++;
                }
                jt1 = new JTable(data,heading);
                jt1.setBounds(10,30,1000,600);
                  
                jt1.setEnabled(false);

                JScrollPane jsp = new JScrollPane(jt1);
                jsp.setBounds(10,38,1064,612);
                
                int height = jt1.getRowHeight();
                jt1.setRowHeight(height+35);
                
                p6.add(jsp);
                con.close();
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(p6,e.toString());
            }
            jt1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jt1.setLayout(null);
            
//Aligning the text in JTabble to center                
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                for(int i=0;i<10;i++){
                    jt1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
          
        }
    }
    
    public static void main(String args[]){
        new Custdetail();
    }
}
