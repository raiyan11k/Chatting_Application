
package chatting.application;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;         // to call calendar
import java.text.*;   // child package / class of util 

public class Client extends JFrame implements ActionListener { // action listener comes from awt event package
    
    JTextField text;    // globally declare 
    JPanel a1;         //globally declare
    Box vertical = Box.createVerticalBox(); // for showing sender text to the right side
    
    Client (){             // Constructor
        
        setLayout(null);
        
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7,94,84)); // header bg
        p1.setBounds(0, 0, 450, 70);
        p1.setLayout(null);
        add(p1);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);  // Scaing the image
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);    // passing image icon object to the jlabel
        back.setBounds(5,20,25,25);     // image size and position
        p1.add(back);     // show image over the panel p1.add
        
        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked (MouseEvent ae){
                System.exit(0);
            }
    });
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/12.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);  // Scaing the image
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);    // passing image icon object to the jlabel
        profile.setBounds(40,10,50,50);     // image size and position
        p1.add(profile);     // show image over the panel p1.add
        
        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);  // Scaing the image
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);    // passing image icon object to the jlabel
        video.setBounds(300,20,30,30);     // image size and position
        p1.add(video);     // show image over the panel p1.add

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(35, 50, Image.SCALE_DEFAULT);  // Scaing the image
        ImageIcon i12 = new ImageIcon(i11);
        JLabel phone = new JLabel(i12);    // passing image icon object to the jlabel
        phone.setBounds(360,20,35,30);     // image size and position
        p1.add(phone);     // show image over the panel p1.add
        
        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(10, 25, Image.SCALE_DEFAULT);  // Scaing the image
        ImageIcon i15 = new ImageIcon(i14);
        JLabel morevert = new JLabel(i15);    // passing image icon object to the jlabel
        morevert.setBounds(420,20,10,25);     // image size and position
        p1.add(morevert);     // show image over the panel p1.add
        
        JLabel name = new JLabel ("User 2");   // user name
        name.setBounds(110,15,100,18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF", Font.BOLD, 18));
        p1.add(name);
        
        JLabel status = new JLabel ("Active Now");  // active now status
        status.setBounds(110,35,100,18); 
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF", Font.BOLD, 14));
        p1.add(status);
        
        a1 = new JPanel();                    //jpanel globally declared 
        a1.setBounds(5,75,440,570);
        add(a1);
        
        
        text = new JTextField();   // Text box to send msg
        text.setBounds(5,655,310,40);
        text.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));
        add(text);
        
        JButton send = new JButton("Send");   // send button
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.addActionListener(this);
        send.setFont(new Font("SAN_SERIF", Font.PLAIN, 16));  //font size
        add(send);
        
        
        setSize(450,700); //creating fram-e 
        setLocation(800,50); // so the frame doesnt open in the corner
        setUndecorated(true);  // removing frame header /title bar
        getContentPane().setBackground(Color.WHITE); // setting the bakcground color using java awt package 
        
        setVisible(true); // setting frame visibility 
    }
    
    public void actionPerformed(ActionEvent ae){  //override actionevent
        String out = text.getText();
        
        JPanel p2 = formatLabel(out);
        
        a1.setLayout(new BorderLayout());     // border layout places elimends top,bttom,left right or center
        JPanel right = new JPanel(new BorderLayout());
        right.add(p2,BorderLayout.LINE_END);
        vertical.add(right);      // showing the sender msg right. one bellow another allignment
        vertical.add(Box.createVerticalStrut(15));  // so the msgs show one below another in a new line and the gap between each msgs 
        
        a1.add(vertical, BorderLayout.PAGE_START);
        
        text.setText("");        // this is to make the text box empy after sending msg
        
        
        repaint();   // call frame
        invalidate(); // repaint
        validate();
    }
    
    public static JPanel formatLabel (String out){
        JPanel panel = new JPanel ();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel output = new JLabel("<html><p style=\"width: 150px\">" +  out + "</html");
        output.setFont(new Font("Tahoma", Font.PLAIN,16));   //msg font 
        output.setBackground(new Color (37,211,102));        // msg color
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15,15,15,50));   // msg border
        
        panel.add(output);
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        
        JLabel time = new JLabel ();
        time.setText(sdf.format(cal.getTime()));            // to calculate the time dynamically 
        
        panel.add(time);
        
        return panel;
    }
    
    public static void main(String[] args){
        new Client();
    }
}
