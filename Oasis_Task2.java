import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Random;;
public class Oasis_Task2 extends JFrame implements ActionListener{

    int rand_number, chance;

    Random rd ;
    JLabel lb,info;
    JPanel jp, jpt;
    JButton button;
    JTextField tf, tf1;
    JOptionPane ft;

    public Oasis_Task2(){
        chance = 7;

        // get random number
        rd = new Random();
        rand_number = rd.nextInt(100);
        //label
        lb = new JLabel("No. of chances left : 7");
        lb.setBounds(100,350, 200,50);
        lb.setForeground(Color.black);
        lb.setFont(new Font("MV Boli",Font.BOLD,16));
        lb.setVisible(true);

        info = new JLabel("Guess the number: 1-100");
        info.setBounds(150, 130, 200, 25);
        info.setForeground(Color.black);
        info.setFont(new Font("MV Boli",Font.BOLD,14));


        //textbox
        tf = new JTextField();
        tf.setBounds(170,170,150,50);

        // button
        button = new JButton("check");
        button.setBounds(190,250,100,30);
        button.setFocusable(false);
        button.setFont(new Font("MV Boli",Font.BOLD,16));
        button.addActionListener(this);
        // frame 
        this.setTitle("Guess the number");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.setResizable(false);
        this.getContentPane().setBackground(new Color(123, 50, 250));
        
        //adding to frame or objects
        this.add(tf);
        this.add(button);

        this.add(info);
        this.add(lb);
    }
    
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button){
            int flag = 0;
            

            try{
                int gnumber = Integer.parseInt(tf.getText());
            
                lb.setText("No. of chances left : "+--chance);
                
                if( gnumber == rand_number){
                    this.getContentPane().setBackground(Color.GREEN);
                    JOptionPane.showMessageDialog(null, "You have guessed correctly...\ndo u want to restart the game", "Guess the number", JOptionPane.INFORMATION_MESSAGE);
                    //System.out.println("correct");
                    rand_number = rd.nextInt(100);
                    chance = 7;
                    lb.setText("No. of chances left : "+chance);
                    flag++;
                }else if( gnumber > rand_number){
                    this.getContentPane().setBackground(Color.RED);
                    
                    JOptionPane.showMessageDialog(null, "the number is larger...", "Guess the number", JOptionPane.INFORMATION_MESSAGE);
                }else if( gnumber < rand_number){
                    this.getContentPane().setBackground(Color.ORANGE);
                    
                    JOptionPane.showMessageDialog(null, "the number is smaller...", "Guess the number", JOptionPane.INFORMATION_MESSAGE);

                }
                tf.setText("");
                this.getContentPane().setBackground(new Color(123, 50, 250));
                
                if( flag == 0 && chance == 0){
                    JOptionPane.showMessageDialog(null, "Out of chances\nRestart the game", "Guess the number", JOptionPane.ERROR_MESSAGE);
                    rand_number = rd.nextInt(100);
                    chance = 7;
                    lb.setText("No. of chances left : "+chance);
                }
            }catch(Exception ex){ 
                
                JOptionPane.showMessageDialog(null, "invalid input..\n Enter numbers from 1 to 100", "Guess the number", JOptionPane.WARNING_MESSAGE);
                tf.setText("");
            }
    
        }
    }

    public static void main(String[] args) {
        new Oasis_Task2();
    }
}
