
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;

public class ViewBooking extends Admin{
    JPanel p2;
    JButton ref3;
    JLabel l_userid,l_status;
    JTextField tf_userid;
    JButton accept,decline,respondstatus;
    JComboBox cb_status;
    String status,ID;
    ViewBooking(){
        p2 = new JPanel();
        
        String icont1 = "/resources/viewbook.png";
        ImageIcon icon = createImageIcon(icont1);
        
        tp.addTab("View Booking",icon,p2,"Manage Bookings");
        p2.setLayout(null);
        tp.setBackgroundAt(1,Color.WHITE);
        p2.setBackground(Color.WHITE);
        
        new ShowTable();
        
        String icont2 = "/resources/refresh 2.jpg";
        ImageIcon b_icon = createImageIcon(icont2);
        
        ref3 = new JButton(b_icon);
        ref3.setText("REFRESH");
        ref3.setBounds(1100, 100, 120, 40);
        ref3.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new ShowTable();
           } 
        });
        p2.add(ref3);
        ref3.setBackground(Color.WHITE);
        
        l_userid = new JLabel("AppointmentID ");
        l_userid.setBounds(1050,200,110,40);
        p2.add(l_userid);
        
        tf_userid = new JTextField();
        tf_userid.setBounds(1160,200,110,40);
        p2.add(tf_userid);
        
        l_status = new JLabel("Status");
        l_status.setBounds(1050,400,70,40);
        p2.add(l_status);
        l_status.setVisible(false);
        
        String status[] = {"OutForPickup","VehiclePicked","OutForDelivery"};
        cb_status = new JComboBox<String>(status);
        cb_status.setBounds(1130,400,150,40);
        p2.add(cb_status);
        cb_status.setVisible(false);
        
        String icont3 = "/resources/updatestatus.png";
        ImageIcon b_icon2 = createImageIcon(icont3);
        
        respondstatus = new JButton(b_icon2);
        respondstatus.setText("UPDATE STATUS");
        respondstatus.setBounds(1060,450,180,40);
        p2.add(respondstatus);
        respondstatus.setBackground(Color.WHITE);
        respondstatus.setVisible(false);
        respondstatus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    Object status =  cb_status.getItemAt(cb_status.getSelectedIndex());
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st = con.createStatement();
                    String query = "update appointments set status = '"+status+"' where appointmentid = '"+ID+"'";
                    st.executeUpdate(query);
                    con.close(); 
                    new ShowTable();
                    JOptionPane.showMessageDialog(rootPane,"Status Updated");
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane, ex);
                }
            }
        });
        
        accept = new JButton("Accept");
        accept.setBounds(1060,280,90,40);
        p2.add(accept);
        accept.setBackground(Color.WHITE);
        accept.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               ID = tf_userid.getText();
               try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st = con.createStatement();
                    String query = "update appointments set status = 'Booked' where appointmentid = '"+ID+"'";
                    st.executeUpdate(query);
                    con.close();
                    new ShowTable();
               }
               catch(Exception ex){
                   System.out.println(ex);
               }           
               l_status.setVisible(true);
               cb_status.setVisible(true);
               respondstatus.setVisible(true);
           } 
        });
        
        decline = new JButton("Decline");
        decline.setBounds(1160,280,90,40);
        p2.add(decline);
        decline.setBackground(Color.WHITE);
        decline.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               try{
                    ID = tf_userid.getText();
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st = con.createStatement();
                    String query = "update appointments set status = 'Declined' where appointmentid = '"+ID+"'";
                    st.executeUpdate(query);
                    con.close();
                    new ShowTable();
               }
               catch(Exception ex){
                   JOptionPane.showMessageDialog(rootPane, ex);
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
                String query = "select count(*) from appointments where adminid = '"+AID+"'";
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
            data = new String[count][8];
            String [] heading = {"UserID","VehicleNo","AppointmentID","Service","Status","Time And Date","VehicleBrand","VehicleModel"};

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "select * from appointments where adminid = '"+AID+"'";
                ResultSet rs = st.executeQuery(query);

                int row = 0;
                while(rs.next()) {
                    data[row][0] = rs.getString("userid");
                    data[row][1] = rs.getString("vehicleno");
                    data[row][2] = rs.getString("appointmentid");
                    data[row][3] = rs.getString("service");
                    data[row][4] = rs.getString("status");
                    data[row][5] = rs.getString("id");
                    data[row][6] = rs.getString("vehiclebrand");
                    data[row][7] = rs.getString("vehiclemodel");
 
                    row++;
                }
                jt1 = new JTable(data,heading);
                jt1.setBounds(10,30,1000,600);
                
                jt1.setEnabled(false);
                
                JScrollPane jsp = new JScrollPane(jt1);
                jsp.setBounds(10,38,1014,612);
                
                int height = jt1.getRowHeight();
                jt1.setRowHeight(height+35);
                
//Aligning the text in JTabble to center                
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                for(int i=0;i<8;i++){
                    jt1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
                
                p2.add(jsp);
                con.close();
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(p2,e.toString());
            }
            jt1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jt1.setLayout(null);
            

        }
    }

    
    public static void main(String args[]){
        new ViewBooking();
    }
 
}
    



