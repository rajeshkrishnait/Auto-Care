
package admin;

import static admin.Admin.createImageIcon;
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
import javax.swing.table.DefaultTableCellRenderer;

public class DelivaryDetails extends Custdetail{
    
    JPanel p7;
    JButton ref5;
    
    DelivaryDetails(){
        
        p7 = new JPanel();
        
        String icont1 = "/resources/delivery.png";
        ImageIcon icon = createImageIcon(icont1);
        
        tp.addTab("View Delivary Details",icon,p7,"Delivary Details");
        p7.setLayout(null);
        tp.setBackgroundAt(6, Color.WHITE);
        p7.setBackground(Color.WHITE);
        
        new ShowTable();
        
        String icont2 = "/resources/refresh 2.jpg";
        ImageIcon b_icon = createImageIcon(icont2);
        
        ref5 = new JButton(b_icon);
        ref5.setText("REFRESH");
        ref5.setBounds(800, 100, 120, 40);
        ref5.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               new ShowTable();
           } 
        });
        p7.add(ref5);
        ref5.setBackground(Color.WHITE);
        
    }

//class finding the number of records in a DataBase Table
    public class Count{
        Count(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?zeroDateTimeBehavior=convertToNull","Nandha Kumar","Beinghappy@123");
                Statement st = con.createStatement();
                String query = "select count(*) from appointments where status = 'Delivered'";
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
        String [] heading = {"UserID","VehicleNo","AdminID","Service","Status","Timestamp","VehicleBrand","VehicleModel"};

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin?zeroDateTimeBehavior=convertToNull","Nandha Kumar","Beinghappy@123");
            Statement st = con.createStatement();
            String query = "select * from appointments where status = 'Delivered'";
            ResultSet rs = st.executeQuery(query);

            int row = 0;
            while(rs.next()) {
                data[row][0] = rs.getString("userid");
                data[row][1] = rs.getString("vehicleno");
                data[row][2] = rs.getString("adminid");
                data[row][3] = rs.getString("service");
                data[row][4] = rs.getString("status");
                data[row][5] = rs.getString("timestramp");
                data[row][6] = rs.getString("vehiclebrand");
                data[row][7] = rs.getString("vehiclemodel");

                row++;
            }
            jt1 = new JTable(data,heading);
            jt1.setBounds(10,30,700,500);
            JScrollPane jsp = new JScrollPane(jt1);
            jsp.setBounds(10,38,714,512);
            
            int height = jt1.getRowHeight();
            jt1.setRowHeight(height+35);
            
//Aligning the text in JTabble to center                
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                for(int i=0;i<8;i++){
                    jt1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
            
            p7.add(jsp);
            con.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(p7,e.toString());
        }
        jt1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jt1.setLayout(null);

        jt1.setEnabled(false);

        }
    }

    public static void main(String args[]){
        new DelivaryDetails();
    }
}
