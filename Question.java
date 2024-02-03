import java.util.ArrayList;

public class Question {
    
    public ArrayList<String[]> AnswerChoice ;
  
    String[] questions = {"Who invented Java Programming?",  "Which of the following is a superclass of every class in Java?", "What is the extension of java code files?", "Which of the following is not an OOPS concept in Java?", "What is the extension of compiled java classes?"};
    String[] answers = {"James Gosling", "Object class", ".java", "Compilation", ".class"};  

    ArrayList<String[]> getChoice(){
        AnswerChoice = new ArrayList<String[]>();
        AnswerChoice.add( new String[] { "Guido Van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup" });
        AnswerChoice.add(new String[] { "ArrayList", "Abstract class", "Object class", "String" });
        AnswerChoice.add(new String[] { ".js", ".py", ".class", ".java"});
        AnswerChoice.add(new String[] { "Polymorphism", "Inheritance", "Compilation", "Encapsulation" });
        AnswerChoice.add(new String[] { ".js", ".py", ".class", ".java"});

        return AnswerChoice;    
    } 

}
