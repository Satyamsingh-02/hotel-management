
package hotelmanagementsystem;
import javax.swing.*;
import java.awt.*;
import java.awt.Event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class AddRooms extends JFrame implements ActionListener {
    JButton add,cancel;
    JTextField tfroom , tfprice;
    JComboBox typecombo,availablecombo,cleancombo;
    AddRooms(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JLabel heading=new JLabel("Add Rooms");
        heading.setFont(new Font("Tahoma",Font.BOLD,18));
        heading.setBounds(150,20,200,20);
        add(heading);
        
        JLabel lblroomno=new JLabel("Room Number");
        lblroomno.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblroomno.setBounds(60,80 ,120,30);
        add(lblroomno);
        
         tfroom=new JTextField();
        tfroom.setBounds(200,80,150,30);
        add(tfroom);
        
        JLabel lblavailabe=new JLabel("Available");
        lblavailabe.setFont(new Font("Tahoma",Font.PLAIN,18));
        lblavailabe.setBounds(60,130 ,120,30);
        add(lblavailabe);
        
        String available []={"Available","Occupied"};
        availablecombo=new JComboBox(available);
        availablecombo.setBounds(200,130,150,30);
        availablecombo.setBackground(Color.white);
        add(availablecombo);
        
        JLabel lblclean=new JLabel("Clean");
        lblclean.setBounds(60,180,120,30);
        lblclean.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblclean);
        
        String cleanOption[]={"Clean","Dirty"};
        cleancombo =new JComboBox(cleanOption);
        cleancombo.setBounds(200,180,150,30);
        cleancombo.setBackground(Color.white);
        add(cleancombo);
        
        JLabel lblprice=new JLabel("Price");
        lblprice.setBounds(60,230,120,30);
        lblprice.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblprice);
        
        tfprice=new JTextField();
        tfprice.setBounds(200,230,150,30);
        add(tfprice);
        
        JLabel lblbedtype=new JLabel("Bed Type");
        lblbedtype.setBounds(60,280,120,30);
        lblbedtype.setFont(new Font("Tahoma",Font.PLAIN,18));
        add(lblbedtype);
        
        String typeOption[]={"Single Bed","Double Bed"};
        typecombo=new JComboBox(typeOption);
        typecombo.setBackground(Color.white);
        typecombo.setBounds(200,280,150,30);
        add(typecombo);
        
        add=new JButton("Add Rooms");
        add.setForeground(Color.white);
        add.setBackground(Color.BLACK);
        add.setBounds(60,350,130,30);
        add.addActionListener(this);
        add(add);
        
         cancel=new JButton("Cancel");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.BLACK);
        cancel.setBounds(220,350,130,30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image=new JLabel(i1);
        image.setBounds(400,30,500,300);
        add(image);
        
        setBounds(330,200,940,470);
        setVisible(true);
    }
    public void  actionPerformed(ActionEvent ae){
        if(ae.getSource()==add){
            String roomnumber=tfroom.getText();
            String availability=(String)availablecombo.getSelectedItem();
           String status=(String)cleancombo.getSelectedItem();
           String price =tfprice.getText();
           String type=(String)typecombo.getSelectedItem();
           try{
               conn c=new conn();
               String str = "insert into room values('"+roomnumber+"', '"+availability+"', '"+status+"', '"+price+"', '"+type+"')";
                c.s.executeUpdate(str);
                JOptionPane.showMessageDialog(null,"New Room Added Successfully");
                setVisible(false);
           }
           catch(Exception e){
               e.printStackTrace();
           }
        }
        
        
        
        else if(ae.getSource()==cancel){
            setVisible(false);
        }
    }
    public static void main(String[]args){
        new AddRooms();
    }
}
