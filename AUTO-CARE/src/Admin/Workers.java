package Admin;
import static Admin.Login.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableCellRenderer;

public class Workers extends Profile{
    JPanel p9;
    JButton b1,b2,b3,b4;
    JLabel l1,l2,l3,l4,l5,l6;
    JComboBox c1;JTextField t1,t2,t3;
    Workers()
    {
        p9=new JPanel();
        tp.addTab("Workers",p9);
        tp.setBackgroundAt(1,Color.WHITE);
        p9.setBackground(Color.WHITE);
        
        p9.setLayout(null);
        b1=new JButton("Refresh");
        b1.setBounds(1100, 100, 120, 40);
        b1.setBackground(Color.WHITE);

        b1.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               //new ShowTable();
           } 
        });
        l1=new JLabel("WorkerID");
        l1.setBounds(1100,200,120,40);
        
        t1=new JTextField();
        t1.setBounds(1180,200,120,40);
        String[] str={"NONE","free","not free"};
        
        c1=new JComboBox(str);
        c1.setBounds(1050,250,120,40);
        c1.setBackground(Color.WHITE);

        l4=new JLabel("Add Workers");
        l4.setBounds(1050,330,120,40);
        
        l5=new JLabel("Worker Name");
        l5.setBounds(1050,380,120,40);
        
        t2=new JTextField();
        t2.setBounds(1150,380,120,40);
        
        l6=new JLabel("Phone Number");
        l6.setBounds(1050,430,120,40);
        
        t3=new JTextField();
        t3.setBounds(1150,430,120,40);
        
        b4=new JButton("Add Workers");
        b4.setBounds(1180,500,120,40);
        b4.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "insert into workers(adminid,workername,workermobileno,workerstatus) values('"+AID+"','"+t2.getText()+"','"+t3.getText()+"','free')";
                st.executeUpdate(query);
                count=count+1;
                //new ShowTable();
                }
                catch(Exception ex){
                System.out.println("ex "+ex);
                //JOptionPane.showMessageDialog(rootPane,ex);
            }
                
            }
        });
        b4.setBackground(Color.WHITE);

        
        b2=new JButton("Change Status");
        b2.setBounds(1180,250,120,40);
        b2.addActionListener(new ActionListener()
        {
           public void actionPerformed(ActionEvent e)
           {
               try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "update workers set workerstatus='"+c1.getSelectedItem().toString()+"' where workerid='"+t1.getText()+"'";
                st.executeUpdate(query);
                //new ShowTable();
            }
            catch(Exception ex){
                System.out.println("e "+ex);
                //JOptionPane.showMessageDialog(rootPane,ex);
            }
           }
        });
        b2.setBackground(Color.WHITE);

        p9.add(b1);p9.add(l1);p9.add(t1);p9.add(c1);p9.add(b2);p9.add(l4);p9.add(l5);p9.add(l6);p9.add(b4);p9.add(t2);p9.add(t3);
        p9.setBackground(Color.WHITE);
        tp.setBackgroundAt(8,Color.WHITE);
        try{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
                Statement st = con.createStatement();
                String query = "select count(*) from workers where adminid = '"+AID+"'";
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
        String [] heading = {"WorkerID","WorkerName","Mobile No","Status"};

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bcproject","root","Ram03");
            Statement st = con.createStatement();
            String query = "select * from Workers where adminid= '"+AID+"'";
            ResultSet rs = st.executeQuery(query);

            int row = 0;
            while(rs.next()) {
                data[row][0] = rs.getString("workerid");
                data[row][1] = rs.getString("workername");
                data[row][2] = rs.getString("workermobileno");
                data[row][3] = rs.getString("workerstatus");
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
            
            p9.add(jsp);
            con.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(p9,e.toString());
            System.out.println("sfa");
        }
        jt1.getColumnModel().getColumn(0).setPreferredWidth(50);
        jt1.setLayout(null);

        }
    }

    public static void main(String args[]){
        new Workers();
    }
}