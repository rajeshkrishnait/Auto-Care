
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
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Invoice extends PartsReq {
    //String AID = "1";
    JPanel p4;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,TotalLabel;
    JButton b1,b2;
    JTextField t1,t2,t3,t4,t5,t6;
    JTextArea ta;
    String partsPrice,serviceCharge,appointmentid,vehicleno,vehiclebrand,vehiclemodel,service;
    Invoice(){
        p4 = new JPanel();
                
        String icont1 = "/resources/invoice.png";
        ImageIcon icon = createImageIcon(icont1);
        
        tp.addTab("INVOICE",icon,p4,"Generate Invoice");
        p4.setLayout(null);
        
        tp.setBackgroundAt(3, Color.WHITE);
        p4.setBackground(Color.WHITE);
        
        l1 = new JLabel("Appointment ID");
        l1.setBounds(50,50,100,40);
        l2 = new JLabel("Vehicle No");
        l2.setBounds(50,100,100,40);
        l3 = new JLabel("Vehicle Brand");
        l3.setBounds(50,150,100,40);
        l4 = new JLabel("Vehicle Model");
        l4.setBounds(50,200,100,40);
        l5 = new JLabel("Service Done");
        l5.setBounds(50,250,100,40);
        l6 = new JLabel("Price Of Parts");
        l6.setBounds(50,400,100,40);
        l7 = new JLabel("Service Charge");
        l7.setBounds(50,450,100,40);
        l8 = new JLabel("Total Amount");
        l8.setBounds(50,500,100,40);
        TotalLabel = new JLabel();
        TotalLabel.setBounds(180,500,500,40);
        
        String icont2 = "/resources/generatebill.png";
        ImageIcon b_icon = createImageIcon(icont2);
        
        b1 = new JButton(b_icon);
        b1.setText("GENERATE BILL");
        b1.setBounds(270,550,300,40);
        b1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                partsPrice = t5.getText();
                serviceCharge = t6.getText();
                int PP = Integer.parseInt(partsPrice);
                int SC = Integer.parseInt(serviceCharge);
                int total = 0;
                total = PP + SC;
                String Total = String.valueOf(total);
                TotalLabel.setText(Total);
                
                try{
                    appointmentid = t1.getText();
                    vehicleno = t2.getText();
                    vehiclebrand = t3.getText();
                    vehiclemodel = t4.getText();
                    service = ta.getText();
                    
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st = con.createStatement();
                    String query = "insert into invoice (appointmentid,VehicleNo,VehicleBrand,VehicleModel,ServiceDone,PartsPrice,ServiceCharge,TotalAmount,adminid) values ('"+appointmentid+"','"+vehicleno+"','"+vehiclebrand+"','"+vehiclemodel+"','"+service+"','"+partsPrice+"','"+serviceCharge+"','"+Total+"','"+AID+"')";
                    st.executeUpdate(query);
                    String query2 = "update appointments set status = 'Delivered' where appointmentid = '"+appointmentid+"'";
                    st.executeUpdate(query2);
                    con.close();
                    JOptionPane.showMessageDialog(rootPane,"Bill Generated Successfully");
                    t1.setText("");
                    t2.setText("");
                    t3.setText("");
                    t4.setText("");
                    t5.setText("");
                    t6.setText("");
                    ta.setText("");
                    TotalLabel.setText("");
                    
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane,ex);
                }
            }  
        });
        b1.setBackground(Color.WHITE);
        
        b2 = new JButton("Cancel");
        b2.setBounds(60,550,90,40);
        b2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                ta.setText("");
                TotalLabel.setText("");
            }
        });
        b2.setBackground(Color.WHITE);
        
        ta = new JTextArea();
        ta.setBounds(180,250,500,130);
        ta.setBorder(BorderFactory. createLineBorder(Color.GRAY,1));
        ta.setEditable(false);
        
        
        t1 = new JTextField();
        t1.setBounds(180,50,500,40);
        t1.addActionListener(new ActionListener (){
            public void actionPerformed(ActionEvent e){
                try{
                    Class.forName("com.mysql.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                    Statement st = con.createStatement();
                    String query = "select * from appointments where appointmentid = '"+t1.getText()+"' ";
                    ResultSet rs = st.executeQuery(query);
                    if(rs.next()){
                        t2.setText(" "+rs.getString("vehicleno"));
                        t3.setText(" "+rs.getString("vehiclebrand"));
                        t4.setText(" "+rs.getString("vehiclemodel"));
                        ta.setText(" "+rs.getString("service"));
                    }
                    con.close();
                }
                catch(Exception ex){
                    JOptionPane.showMessageDialog(rootPane,ex);
                }
            }
        });
        t2 = new JTextField();
        t2.setBounds(180,100,500,40);
        t2.setEditable(false);
        t2.setBackground(Color.WHITE);
        t2.setBorder(BorderFactory. createLineBorder(Color.GRAY,1));
      
        t3 = new JTextField();
        t3.setBounds(180,150,500,40);
        t3.setEditable(false);
        t3.setBackground(Color.WHITE);
        t3.setBorder(BorderFactory. createLineBorder(Color.GRAY,1));
        t4 = new JTextField();
        t4.setBounds(180,200,500,40);
        t4.setEditable(false);
        t4.setBackground(Color.WHITE);
        t4.setBorder(BorderFactory. createLineBorder(Color.GRAY,1));
        t5 = new JTextField();
        t5.setBounds(180,400,500,40);
        t6 = new JTextField();
        t6.setBounds(180,450,500,40);

        
        p4.add(l1);
        p4.add(l2);
        p4.add(l3);
        p4.add(l4);
        p4.add(l5);
        p4.add(l6);
        p4.add(l7);
        p4.add(l8);
        p4.add(b1);
        p4.add(b2);
        p4.add(ta);
        p4.add(t1);
        p4.add(t2);
        p4.add(t3);
        p4.add(t4);
        p4.add(t5);
        p4.add(t6);
        p4.add(TotalLabel);
        
        
        
        
    }
    
    public static void main(String args[]){
        new Invoice();
    }
    
}

