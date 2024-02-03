import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener{
   
    JLabel userLabel = new JLabel("username :");
    JLabel passwordLabel = new JLabel("password :");

    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JButton login = new JButton("LOGIN");
    JButton reset = new JButton("RESET");
    
    LoginInfo basicInfo = new LoginInfo();
    public Login(){

        // label -> 
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("Tahoma", 1, 14));
        userLabel.setBounds(50,100,100,25);

        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Tahoma", 1, 14));
        passwordLabel.setBounds(50, 140,100,25);



        // textfield -> username and password
        username.setBounds(150,100, 200,25);
        password.setBounds(150,140, 200,25);

        // buttons
        login.addActionListener(this);
        login.setBounds(100,190,100,25); 
        login.setFocusable(false);

        reset.addActionListener(this);
        reset.setBounds(220,190,100,25);
        reset.setFocusable(false);


        // login frame ->
        this.setTitle("Login page");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLocation(600, 200);
        // adding components to frame
        this.add(userLabel);
        this.add(passwordLabel);
        this.add(username);
        this.add(password);
        this.add(login);
        this.add(reset);

    
    }
    public void actionPerformed(ActionEvent e){
        if( e.getSource() == login){
            try {
                if(basicInfo.getLoginData(username.getText(), new String(password.getPassword()))){
                        System.out.println("login successful");
                        new Exam(username.getText());
                        this.dispose();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Login Error" , JOptionPane.ERROR_MESSAGE);
                    System.out.println("login failed");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error : "+ex, "Login Error" , JOptionPane.ERROR_MESSAGE);
            }

        }else if( e.getSource() == reset){
            username.setText("");
            password.setText("");
            System.out.println("reset");
        }
    }
    public static void main(String[] args) {
        new Login();
    }
}
