
package hotelmanagementsystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Dashboard extends JFrame implements ActionListener{
    Dashboard(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0,0,1920,1080);
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2=i1.getImage().getScaledInstance(1920,1080,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,1920,1080);
        add(image);
        
        JLabel text=new JLabel("THE TAJ GROUP WELCOME YOU");
        text.setBounds(400,80,1000,50);
        text.setFont(new Font("Tahoma",Font.PLAIN,46));
        text.setForeground(Color.white);
        image.add(text);
        
        JMenuBar mb=new JMenuBar();
        mb.setBounds(0,0,1920,30);
        image.add(mb);
        JMenu hotel=new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);  
        
        JMenu admin=new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        JMenuItem reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenuItem addrooms=new JMenuItem("ADD ROOMS");
        addrooms.addActionListener(this);
        admin.add(addrooms);
        JMenuItem add_drivers=new JMenuItem("ADD DRIVERS");
        add_drivers.addActionListener(this);
        admin.add(add_drivers);
        JMenuItem addemployee=new JMenuItem("ADD EMPLOYEE");
        addemployee.addActionListener(this);
        admin.add(addemployee);
        mb.add(admin);
        
        
        
        
        setVisible(true);
        
    }
     public void actionPerformed(ActionEvent ae){
         if(ae.getActionCommand().equals("ADD EMPLOYEE")){
             new AddEmployee();
         }
         else if(ae.getActionCommand().equals("ADD ROOMS")){
             new AddRooms();
         }
         else if(ae.getActionCommand().equals("ADD DRIVERS")){
             new AddDriver();
         }
         else if(ae.getActionCommand().equals("RECEPTION")){
             new Reception();
         }
     }
    public static void main(String[]args){
       new Dashboard();
    }
}
