import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;   

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class MyProfile extends JFrame implements ActionListener{
    String username;
    JLabel changePassword[] = new JLabel[2];
    JTextField changePasswordText;
    JPasswordField confirmField;
    JButton changePasswordButton;
    
    public MyProfile(String username){
        this.username = username;   
        //label
        for(int i = 0; i < 2;i++){
            changePassword[i] = new JLabel((i == 0)?"Change Password : " : "Confirm Password : ");
            changePassword[i].setForeground(Color.WHITE);
            changePassword[i].setFont(new Font("MV Boli", 1, 14));
            changePassword[i].setBounds(50, 100 +(50*i), 150, 25);
        }
        // textfield
        changePasswordText = new JTextField();
        changePasswordText.setBounds(200, 100, 150, 25);

        confirmField = new JPasswordField();
        confirmField.setBounds(200, 150, 150, 25);

        // button
        changePasswordButton = new JButton("change");
        changePasswordButton.setBounds(200, 200, 100, 30);
        changePasswordButton.setFocusable(false);
        changePasswordButton.addActionListener(this);
        // frame
        this.setTitle("My Profile");
        this.setLayout(null);
        this.setSize(450, 450);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLocation(600, 200);
        
        this.add(changePassword[0]);
        this.add(changePassword[1]);
        this.add(changePasswordText);
        this.add(confirmField);
        this.add(changePasswordButton);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == changePasswordButton){
            try{
                String password = changePasswordText.getText(); 
                String confirmPassword = new String(confirmField.getPassword());
                if(!password.equals(confirmPassword)){
                    JOptionPane.showMessageDialog(null, "Password does not match");
                    return;
                }
                new LoginInfo().setPassword(username, password);
                JOptionPane.showMessageDialog(null, "Password changed successfully");
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null, "Error occured");
            }
        }
    }
    public static void main(String[] args) {
        new MyProfile("admin");
    }
    
}
