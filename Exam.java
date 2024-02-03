import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Exam extends JFrame implements ActionListener{
    String username;
    JMenuBar menu = new JMenuBar();
    JMenuItem MyProfile,Logout;
    JLabel label = new JLabel("Click the button to enter the Quiz");
    JButton button = new JButton("Click");
    public Exam(String username){
        this.username = username;
        // java menu
        JMenu File = new JMenu("File");

        // menu item
        MyProfile = new JMenuItem("MyProfile");
        MyProfile.setMnemonic(KeyEvent.VK_M);
        MyProfile.addActionListener(this);

        Logout = new JMenuItem("Logout");
        Logout.setMnemonic(KeyEvent.VK_L);
        Logout.addActionListener(this);

        // label
        label.setBounds(75, 100,  300, 30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("MV Boli", Font.ITALIC, 14));

        //button
        button.setBounds(170, 150, 75, 30);
        button.addActionListener(this);
        button.setFocusable(false);
        // frame
        this.setTitle("Quizz");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLocation(600, 200);
        
        File.add(MyProfile);
        File.add(Logout);
        menu.add(File);

        this.setJMenuBar(menu);
        this.add(label);
        this.add(button);
        
       
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == MyProfile){
            new MyProfile(username);
        }
        if(e.getSource() == Logout){
            this.dispose();
        }
        if(e.getSource() == button){
            new Portaljava();
        }
    }
    
}
