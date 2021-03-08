
package Admin;

import static Admin.Admin.createImageIcon;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import static Admin.Login.*;
public class PartsReq extends ViewBooking{
    
    JPanel p3;
    JButton ref6,respondstatus;
    JLabel l_orderid,l_status;
    JTextField tf_orderid;
    JComboBox cb_status;
    int count1=0;     
    Vector<Integer> productid=new Vector<>();
    PartsReq(){
        p3 = new JPanel();
    
        String icont1 = "/resources/partsreq 2.png";
        ImageIcon icon = createImageIcon(icont1);
        
        tp.addTab("Parts Required",icon,p3,"Manage OrderS");
        tp.setBackgroundAt(2, Color.WHITE);
        p3.setLayout(null);
        p3.setBackground(Color.WHITE);
        
        String icont2 = "/resources/refresh 2.jpg";
        ImageIcon b_icon = createImageIcon(icont2);
        
        ref6 = new JButton(b_icon);
        ref6.setText("REFRESH");
        ref6.setBounds(1100, 100, 120, 40);
        ref6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new ShowTable();
            }
        });
   
        p3.add(ref6);
        ref6.setBackground(Color.WHITE);
        
        l_orderid = new JLabel("OrderID ");
        l_orderid.setBounds(1050,240,80,40);
        p3.add(l_orderid);
        
        tf_orderid = new JTextField();
        tf_orderid.setBounds(1150,240,150,40);
        p3.add(tf_orderid);
        
        l_status = new JLabel("Status");
        l_status.setBounds(1050,300,70,40);
        p3.add(l_status);
        
        String status[] = {"NONE","Packed","Shipped","Transit"};
        cb_status = new JComboBox<String>(status);
        cb_status.setBounds(1150,300,150,40);
        p3.add(cb_status);

        String icont3 = "/resources/updatestatus.png";
        ImageIcon b_icon2 = createImageIcon(icont3); 
        
        respondstatus = new JButton(b_icon2);
        respondstatus.setText("UPDATE STATUS");
        respondstatus.setBounds(1100,350,190,40);
        p3.add(respondstatus);
        respondstatus.setBackground(Color.WHITE);
        respondstatus.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try{
                    ID = tf_orderid.getText();
                    Object status =  cb_status.getItemAt(cb_status.getSelectedIndex());
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st = con.createStatement();
                    String query = "update ecommerce set status = '"+status+"' where orderid = '"+ID+"'";
                    st.executeUpdate(query);
                    con.close();                    
                    new ShowTable();
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane, ex);
                }
            }
        });
        
        try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st = con.createStatement();
                    String query = "select productid from items where adminid = '"+AID+"'";
                    ResultSet rs=st.executeQuery(query);
                    while(rs.next())
                    {
                       productid.add(rs.getInt(1)); 
                    }
                    Statement st1 = con.createStatement();
                    for(int i=0;i<productid.size();i++)
                    {
                        String query1 = "select productid from ecommerce where productid = '"+productid.get(i)+"'";
                        ResultSet rs1=st1.executeQuery(query1);
                        while(rs1.next())
                        {
                            count1++;
                            
                        }
                    }
                   
                    con.close(); 
                    
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane, ex);
                }
        new ShowTable();
        
    }
    
    
    public class ShowTable {
        
        String [][]data;
        String[]colname;
        JTable jt1;
        ShowTable(){
            new Count();
            data = new String[count1][8];
            String [] heading = {"OrderID","USERID","ProductID","Date","ProductName","Quantity","Totalprice","Status"};

            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                int row = 0;
                 System.out.println(productid);
                  System.out.println(count1);
                for(int i=0;i<productid.size();i++)
                {
                String query = "select * from ecommerce where productid='"+productid.get(i)+"'";
                ResultSet rs = st.executeQuery(query);
                while(rs.next())
                { System.out.println(productid);
                    data[row][0] = rs.getString("orderid");
                    data[row][1] = rs.getString("userid");
                    data[row][2] = rs.getString("productid");
                    java.util.Date date = Calendar.getInstance().getTime();  
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); 
                    String strDate = dateFormat.format(date);  
                           
                    data[row][3] = strDate;
                    data[row][4] = rs.getString("productname");
                    data[row][5] = rs.getString("quantity");
                    data[row][6] = rs.getString("price");
                    data[row][7] = rs.getString("status");
                    row++;
                }
                }
                jt1 = new JTable(data,heading);
                jt1.setBounds(10,30,1000,600);
                
                jt1.setEnabled(true);
                
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
                
                p3.add(jsp);
                con.close();
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(p3,e.toString());
            }
            jt1.getColumnModel().getColumn(0).setPreferredWidth(50);
            jt1.setLayout(null);
            
   
        }
    }

    
    
    public static void main(String args[]){
        new PartsReq();
    }
    
}
