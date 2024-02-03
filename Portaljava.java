import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class Portaljava extends JFrame{
    int qno = 0, correct_guess =0, seconds = 10;
    JLabel timeleft[] = new JLabel[2];
    JTextArea questionTextArea;
    JRadioButton option[] = new JRadioButton[4];
    ButtonGroup group = new ButtonGroup();
    Question q = new Question();
    String[] s = q.questions;
    String[] ans = q.answers;
    ArrayList<String[]> choice = q.getChoice();

    Timer t = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            seconds--;
            timeleft[1].setText(String.valueOf(seconds));
            if(seconds <= 0){
                t.stop();
                qno++;
                seconds = 10;
                timeleft[1].setText(String.valueOf(seconds));
                setQuestion();
                
            }
        }
    });
    JButton nextButton = new JButton("Next");
    
    public Portaljava(){
        
        // text area of question
        questionTextArea = new JTextArea( );
        questionTextArea.setBounds(40,60,400,55);
        questionTextArea.setFont(new Font("MV Boli", Font.PLAIN,17));
        questionTextArea.setLineWrap(true);
        questionTextArea.setForeground(Color.white);
        questionTextArea.setBackground(Color.BLACK);
        questionTextArea.setEditable(false);
        questionTextArea.setFocusable(false);
       

        // question
        for(int i = 0; i < 4; i++){
            option[i] = new JRadioButton();
            option[i].setBounds(80,150+(50*i),250,25);
            option[i].setFont(new Font("MV Boli", Font.PLAIN,16));
            option[i].setForeground(Color.white);;
            option[i].setBackground(Color.BLACK);
            option[i].setFocusable(false);
            
            group.add(option[i]);

        }

        setQuestion();
        group.clearSelection();
        
        // time left -> label
        for(int i = 0; i < 2; i++){
            timeleft[i] = new JLabel((i==0)? "Time Left: " : String.valueOf(seconds) );
            timeleft[i].setBounds(400,350+(40*i),100,30);
            timeleft[i].setFont(new Font("MV Boli", Font.PLAIN,(i==0)? 16 : 22));
            timeleft[i].setForeground(Color.WHITE);
            timeleft[i].setBackground(Color.BLACK);
            timeleft[i].setFocusable(false);
            
        }
        // button
        nextButton.setBounds(200,400,100,30);
        nextButton.setFocusable(false);
        nextButton.addActionListener(e -> {
                qno++;
                setQuestion();
                seconds = 10;
                timeleft[1].setText(String.valueOf(seconds));
                if(nextButton.getText().equals("Next")){
                    timeleft[0].setVisible(true);;
                    timeleft[1].setVisible(true);
                }
           
        });
        // frame
        this.setTitle("Java Quizz");
        //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(500, 500);
        this.setVisible(true);
        this.getContentPane().setBackground(Color.BLACK);
        this.setResizable(false);
        this.setLocation(600, 200);     
        
        this.add(questionTextArea);
        this.add(option[0]);
        this.add(option[1]);
        this.add(option[2]);
        this.add(option[3]);
        this.add(timeleft[0]);
        this.add(timeleft[1]);
        this.add(nextButton);

    }

    void setQuestion(){
        // count correct guess
        if(qno >0) t.stop();
        if(qno > 0 && group.getSelection() != null ){
            String selected = group.getSelection().getActionCommand();
            if( selected.equals(ans[qno-1])){
                correct_guess++;
            }
        }
        if(qno < 5){
            nextButton.setText("Next");;
            questionTextArea.setText(qno+1 +". " +s[qno]);
            String c[] = choice.get(qno);
            for(int i = 0; i < 4; i++){
                option[i].setActionCommand(c[i]);
                option[i].setText(c[i]);
                option[i].setVisible(true);
            }
            t.start();
            
            group.clearSelection();
            if(qno == 4){
                nextButton.setText("Submit");
            }
        }else if(qno == 5){ // final view
            questionTextArea.setText("You have completed the quiz... \n You got " + correct_guess + " out of 5 ->"+ (int)(correct_guess*20) + "%");
            timeleft[0].setVisible(false);
            timeleft[1].setVisible(false);
            for(int i = 0; i < 4; i++){
                option[i].setVisible(false);
            }
            nextButton.setText("Restart");

            qno =-1;
            correct_guess = 0;
            
        }

    }
    public static void main(String[] args) {
        new Portaljava();
    }
}
