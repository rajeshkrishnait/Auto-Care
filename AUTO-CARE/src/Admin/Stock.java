package Admin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableCellRenderer;
import static Admin.Login.*;
public class Stock extends Workers{
    JPanel p10;
    JButton b1,b2,b3,b4;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField c1,t1,t2,t3,t4;
    Stock()
    {
        p10=new JPanel();
        tp.addTab("Stock",p10);
        p10.setLayout(null);
        p10.setBackground(Color.WHITE);
        tp.setBackgroundAt(9,Color.WHITE);
        
        b1=new JButton("Refresh");
        b1.setBounds(1100, 100, 120, 40);
        b1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               
               new ShowTable();
           } 
        });
        b1.setBackground(Color.WHITE);
        
        
        l1=new JLabel("ProductID");
        l1.setBounds(1100,200,120,40);
        
        t1=new JTextField();
        t1.setBounds(1180,200,120,40);
        ///String[] str={"NONE","free","not free"};
        
        c1=new JTextField();
        c1.setBounds(1050,250,120,40);
        c1.setBackground(Color.WHITE);
        
        b2=new JButton("Update Stock");
        b2.setBounds(1180,250,120,40);
        b2.setBackground(Color.WHITE);
        
        l4=new JLabel("Add items");
        l4.setBounds(1050,330,120,40);
        
        l5=new JLabel("item Name");
        l5.setBounds(1050,380,120,40);
        
        t2=new JTextField();
        t2.setBounds(1150,380,120,40);
        
        l6=new JLabel("price");
        l6.setBounds(1050,430,120,40);
        
        t3=new JTextField();
        t3.setBounds(1150,430,120,40);
        
        l7=new JLabel("stock");
        l7.setBounds(1050,480,120,40);
        
        t4=new JTextField();
        t4.setBounds(1150,480,120,40);
        
        b4=new JButton("Add items");
        b4.setBounds(1180,550,120,40);
        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "insert into items(productname,price,stock,adminid) values('"+t2.getText()+"','"+t3.getText()+"','"+t4.getText()+"','"+AID+"')";
                st.executeUpdate(query);
                count=count+1;
                new ShowTable();
                }
                catch(Exception ex){
                System.out.println("ex "+ex);
                //JOptionPane.showMessageDialog(rootPane,ex);
            }
                
            }
        });
        
        b4.setBackground(Color.WHITE);
        
        
        b2.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "update items set stock='"+c1.getText()+"' where productid='"+t1.getText()+"'";
                st.executeUpdate(query);
                new ShowTable();
            }
            catch(Exception ex){
                
                System.out.println("e"+ex);
                //JOptionPane.showMessageDialog(rootPane,ex);
            }
           }
        });
        b2.setBackground(Color.WHITE);
        
        
        p10.add(b1);p10.add(l1);p10.add(t1);p10.add(c1);p10.add(b2);p10.add(b4);p10.add(l4);p10.add(l6);p10.add(l5);p10.add(t2);p10.add(t3);p10.add(t4);p10.add(l7);
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "select count(*) from items where adminid = '"+AID+"'";
                ResultSet rs = st.executeQuery(query);
                rs.next();
                count = rs.getInt(1);
                System.out.println(count);
            }
            catch(Exception ex){
                System.out.println("e"+ex);
                //JOptionPane.showMessageDialog(rootPane,ex);
            }
        new ShowTable();
        setVisible(true);
    }
 public class ShowTable {
    String [][]data;
    String[]colname;
    JTable jt1;
    ShowTable(){
        
        data = new String[count][4];
        String [] heading = {"ProductID","ProductName","Price","Stock"};

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
            Statement st = con.createStatement();
            String query = "select * from items where adminid= '"+AID+"'";
            ResultSet rs = st.executeQuery(query);

            int row = 0;
            while(rs.next()) {
                data[row][0] = rs.getString("productid");
                data[row][1] = rs.getString("productname");
                data[row][2] = rs.getString("price");
                data[row][3] = rs.getString("stock");
                row++;
            }
            jt1 = new JTable(data,heading);
            jt1.setBounds(100,100,1000,600);
            
            jt1.setEnabled(false);

            JScrollPane jsp = new JScrollPane(jt1);
            jsp.setBounds(10,38,1014,612);
            
            int height = jt1.getRowHeight();
            jt1.setRowHeight(height+35);
            
//Aligning the text in JTabble to center                
                DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                centerRenderer.setHorizontalAlignment( JLabel.CENTER );
                for(int i=0;i<4;i++){
                    jt1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
                }
            
            p10.add(jsp);
            con.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(p10,e.toString());
            System.out.println("s");
        }
        jt1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jt1.setLayout(null);

        }
    }

    public static void main(String args[]){
        new Stock();
    }
}