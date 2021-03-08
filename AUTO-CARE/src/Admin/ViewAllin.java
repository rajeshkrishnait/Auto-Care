
package Admin;
import static Admin.Login.*;
import static Admin.Admin.createImageIcon;
//import static com.sun.xml.internal.fastinfoset.alphabet.BuiltInRestrictedAlphabets.table;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
public class ViewAllin extends Invoice{
    JPanel p5;
    JButton ref1;
    ViewAllin(){
        
        p5 = new JPanel();
        
        String icont1 = "/resources/viewinvoice.jpg";
        ImageIcon icon = createImageIcon(icont1);
        
        tp.addTab("View All Invoice",icon,p5,"View All Invoices Generated");
        p5.setLayout(null);
        tp.setBackgroundAt(4, Color.WHITE);
        p5.setBackground(Color.WHITE);
        
        new ShowTable();
        
        String icont2 = "/resources/refresh 2.jpg";
        ImageIcon b_icon = createImageIcon(icont2);
        
        ref1 = new JButton(b_icon);
        ref1.setText("REFRESH");
        ref1.setBounds(1100, 100, 120, 40);
        ref1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ShowTable();
                
            }
        });

        p5.add(ref1);
        ref1.setBackground(Color.WHITE);
        
    }
    
//class finding the number of records in a DataBase Table
    public class Count{
        Count(){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "select count(*) from invoice where adminid='"+AID+"'";
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
            data = new String[count][9];
            String [] heading = {"SNo","AppointmentID","VehicleNo","VehicleBrand","VehicleModel","ServiceDone","PartsPrice","ServiceCharge","TotalAmount"};

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "select * from invoice where adminid='"+AID+"'";
                ResultSet rs = st.executeQuery(query);

                int row = 0;
                while(rs.next()) {
                    data[row][0] = rs.getString("SNo");
                    data[row][1] = rs.getString("Appointmentid");
                    data[row][2] = rs.getString("VehicleNo");
                    data[row][3] = rs.getString("VehicleBrand");
                    data[row][4] = rs.getString("VehicleModel");
                    data[row][5] = rs.getString("ServiceDone");
                    data[row][6] = rs.getString("PartsPrice");
                    data[row][7] = rs.getString("ServiceCharge");
                    data[row][8] = rs.getString("TotalAmount");
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
                for(int i=0;i<9;i++){
                    jt1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
                
                p5.add(jsp);
                con.close();
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(p5,e.toString());
            }
            jt1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jt1.setLayout(null);
            

        }
    }

    
    public static void main(String args[]){
        new ViewAllin();
    }
}

