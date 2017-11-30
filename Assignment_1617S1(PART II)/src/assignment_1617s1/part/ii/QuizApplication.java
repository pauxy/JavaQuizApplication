/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1617s1.part.ii;

import java.awt.event.ActionEvent;
import java.io.*;
import java.net.URL;
import java.util.*;
import javax.swing.*;

/**
 *
 *     
 * 

 *
 * @author chuny
 */
public class QuizApplication { 

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Quiz questions = new Quiz();
        ImageIcon LOADING = new ImageIcon(new URL("http://www.techspot.com/images/loading_blue2.gif"));
        File username = new File("UserPass.txt");//for storing username and password
        int NOQ = questions.noofquestion();//finds number of question
        Boolean TOF = false;//used later to check if the answer is contained in the string
        boolean yon = false;//used to check if user input is in "UserPass.txt"
        int a = 2;//contine quiz
        int e = 0;//counts for user
        String winner = "";
        int largest = 0;
        while (a == 2) {
            if (JOptionPane.showConfirmDialog(null, "Welcome to the quiz!\nAre you ready?", "Message", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
            } else {
                break;
            }
            if (JOptionPane.showConfirmDialog(null, "Would you like to register for an account?\nThis will be used to save your total points later!", "Message", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                String userword = LOGIN("Would you like to register an account?", "This will be used to save your total points later!");
                if (userword.equals(" , ")) {
                    JOptionPane.showMessageDialog(null, "not applicable");
                    continue;
                }
                try {
                    PrintStream out = new PrintStream(new FileOutputStream(//prints into a file to save password and username
                            username, true));
                    out.println("\n" + userword);

                    out.close();

                } catch (FileNotFoundException nosuchfile) {
                }

                JOptionPane.showMessageDialog(null, "Registration successful!");
            }
            int total = 0;
            String fin = "\n-----";
            String play = JOptionPane.showInputDialog("How many players?");
            play = letter(play);
            play = noletter(play, "How many players?");
            int x = Integer.parseInt(play);//determines how many times to loop 
            while (x <= 0) {
                JOptionPane.showMessageDialog(null, "INVALID INPUT");
                play = JOptionPane.showInputDialog("How many players?");
                play = letter(play);
                play = noletter(play, "How many players?");
                x = Integer.parseInt(play);
            }//find number of  participating players and converts string to int
            String[] names = new String[x];
            int tries = 0;
            int looping = 0;
            String num = JOptionPane.showInputDialog("How many questions would you like to attempt? \n(Maximum of " + NOQ + " questions)");
            String nmber = letter(num);
            nmber = noletter(nmber, "How many questions would you like to attempt? \n(Maximum of " + NOQ + " questions)");
            int z = Integer.parseInt(nmber);                               //find number of  participating players and converts string to int
            while (z > NOQ || z < 0 || z == 0) {
                JOptionPane.showMessageDialog(null, "INVALID INPUT");
                num = JOptionPane.showInputDialog("How many questions would you like to attempt? \n(Maximum of " + NOQ + " questions)");
                nmber = letter(num);
                nmber = noletter(nmber, "How many questions would you like to attempt? \n(Maximum of " + NOQ + " questions)");
                z = Integer.parseInt(nmber);                               //find number of  participating players and converts string to int
            }
            while (looping < x) {
                names[looping] = JOptionPane.showInputDialog("What's your name Player " + (looping + 1) + "?");//loops for player names
                looping += 1;
            }
            while (tries < x) {
                int points = 0;
                JOptionPane.showMessageDialog(null, "Your quiz will begin now " + names[tries], "message", JOptionPane.INFORMATION_MESSAGE);
                double starttime = System.currentTimeMillis();//saves current time
                int[] point = new int[x];
                int[] loop = new int[NOQ];
                double[] testtime = new double[x];
                Arrays.fill(loop, -1);
                int c = -1;
                int questionz = 1;
                while (questionz <= z) {//makes sure no question appears twice
                    while (c == loop[0] || c == loop[1] || c == loop[2] || c == loop[3] || c == loop[4] || c == loop[5] || c == loop[6] || c == loop[7] || c == loop[8] || c == loop[9] || c == loop[10] || c == loop[11] || c == loop[12] || c == loop[13] || c == loop[14] || c == loop[15]) {
                        c = (int) (Math.random() * NOQ);
                    }
                    int ans = (int) (Math.random() * 4) + 1;//randomise options
                    loop[questionz - 1] = c;//assigns to prevent same thing from appearing
                    int type = questions.returnarray(c).questiontype();//gets questiontype
                    String question;
                    int g = 0;
                    String[] Option = new String[4];
                    switch (type) {
                        case 1:
                            String Answer = questions.returnarray(c).ans();//calls answer
                            question = questions.returnarray(c).question();//stores question
                            while (g < 4) {
                                Option[g] = questions.returnarray(c).option(g);//gets all options
                                g += 1;
                            }
                            Option[ans - 1] = Answer;
                            String Q1 = JOptionPane.showInputDialog(null, "QUESTION " + questionz + "\n" + question + "\n1. " + Option[0] + "\n2. " + Option[1] + "\n3. " + Option[2] + "\n4. " + Option[3] + "");//question with options
                            Q1 = letter(Q1);//prevent input of anything other than 1,2,3,4
                            if (Q1.equals("")) {
                                Q1 = "100";
                            }
                            int qn1 = Integer.parseInt(Q1);
                            while (qn1 < 1 || qn1 > 4) {
                                int que1 = notinrange(question, qn1, Option[0], Option[1], Option[2], Option[3], questionz);//prevents input other than 1-4
                                qn1 = que1;
                            }
                            if (qn1 != ans) {                //this will print for all options except the answer
                                JOptionPane.showMessageDialog(null, "The correct answer is " + ans, "Answer", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                points += 1;                            //points added to points
                            }
                            questionz += 1;
                            System.out.println("Question complete! Answer is option " + ans + " or " + Answer + "\noption chosen was " + qn1 + "\n");//displays the right answer as well as what the user wrote
                            break;
                        case 2:
                            question = questions.returnarray(c).question();
                            Answer = questions.returnarray(c).ans();
                            String input = JOptionPane.showInputDialog(null, "QUESTION " + questionz + "\n" + question);  //allows for user input 
                            TOF = stringsearch(input, Answer);
                            if (TOF == true) {                         //checks if ans is contained in the string userinput
                                points += 1;                            //points added to points(1 rounds)
                            } else {                                    //this will execute for all optionsother than ans
                                JOptionPane.showMessageDialog(null, "The correct answer is " + Answer, "Answer", JOptionPane.ERROR_MESSAGE);
                            }
                            questionz += 1;
                            System.out.println("Question complete! Answer is " + Answer + "\nyou wrote : " + input + "\n");

                            break;
                        case 3:
                            Icon image = questions.returnarray(c).image();
                            question = questions.returnarray(c).question();
                            Answer = questions.returnarray(c).ans();
                            input = picture(image, question, questionz);
                            TOF = stringsearch(input, Answer);
                            if (TOF == true) {                      //checks if ans is contained in the string userinput
                                points += 1;                            //points added to points(1 rounds)
                            } else {                                            //this will execute for all options other than "internet protocol"
                                JOptionPane.showMessageDialog(null, "The correct answer is " + Answer, "Answer", JOptionPane.ERROR_MESSAGE);
                            }
                            questionz += 1;
                            System.out.println("Question complete! Answer is " + Answer + "\nyou wrote : " + input + "\n");

                            break;

                    }

                }
                point[tries] = points;
                double endtime = System.currentTimeMillis();//records time
                double pointcount =1;
                testtime[tries] = ((endtime - starttime) / 1000) / 60;//finds time taken
                if ((testtime[tries] - pointcount)<0) {
                    point[tries] = points + 1;
                   JOptionPane.showMessageDialog(null, "You managed to finish the quiz in under 1 minute, you get an extra mark", "Quiz", JOptionPane.INFORMATION_MESSAGE); 
                }
                total += point[tries];
                String fina = "\n" + names[tries] + " : " + point[tries] + "\n timetaken: " + testtime[tries] + "mins \n-----";
                fin = fin + fina;
                JOptionPane.showMessageDialog(null, "You got " + point[tries] + " out of " + z + " correct ", "Quiz", JOptionPane.INFORMATION_MESSAGE
                );
                JOptionPane.showMessageDialog(null, "CURRENT SCORES" + fin, "message", JOptionPane.INFORMATION_MESSAGE);
                tries += 1;
                if (tries == x) {
                    JOptionPane.showMessageDialog(null, "FINAL SCORES" + fin, "message", JOptionPane.INFORMATION_MESSAGE);
                    for (int i = 0; i < point.length; i++) {//stores winners
                        if (point[i] > largest) {
                            largest = point[i];
                        }
                    }
                    while (e < point.length) {
                        if (point[e] == largest) {
                            winner = winner + names[e] + "\n";
                        }
                        e += 1;
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please pass to the next player", "message", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            double TOTAL = (double) total;
            double X = (double) x;
            if (JOptionPane.showConfirmDialog(null, "Would you like to save your scores? Sign In!", "Message", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {

                String UAP = LOGIN("Would you like to save your total scores?", "Please input Password and Username");

                try {
                    Scanner scanner = new Scanner(username);
                    while (scanner.hasNextLine()) {//checks each line for username and password
                        String line = scanner.nextLine();
                        yon = userpass(line, UAP);
                        if (yon == true) {
                            String Q1 = JOptionPane.showInputDialog("what would you like to name your text file?");//question with options
                            JOptionPane.showMessageDialog(null, "The file has been saved as " + Q1 + ".txt ", "Message", JOptionPane.INFORMATION_MESSAGE);
                            try (PrintWriter out = new PrintWriter(Q1 + ".txt")) {//creates file to store values
                                out.println(fin);
                                break;
                            }

                        }
                        if (yon == false) {
                            JOptionPane.showMessageDialog(null, "LOADING... \n (Authenticating...)", "", JOptionPane.INFORMATION_MESSAGE, LOADING);

                        }
                    }
                    if (yon == false) {
                        JOptionPane.showMessageDialog(null, "ERROR!\n WRONG PASSWORD OR USERNAME \nACCESS DENIED", "Message", JOptionPane.ERROR_MESSAGE);//if wrong info is input
                    }

                } catch (FileNotFoundException filedoesnotexist) {
                }
            }
            JOptionPane.showMessageDialog(null, "FINAL SCORES " + fin + "\nAVERAGE SCORES \n" + TOTAL / X, "message", JOptionPane.INFORMATION_MESSAGE);
            if (JOptionPane.showConfirmDialog(
                    null, "The winner/winners got " + largest + " points and is/are \n~~~~~~~~~~\n" + winner + "\n~~~~~~~~~~\nDo you want to try again?", "WINNER", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                a = 2;
            } else if (JOptionPane.showConfirmDialog(
                    null, "Would you like to shut down your computer?", "WINNER", JOptionPane.YES_OPTION) == JOptionPane.YES_OPTION) {
                String ASD = letter(JOptionPane.showInputDialog("How many seconds before shutdown?"));
                int asd = Integer.parseInt(ASD);
                shutdown(asd);
                JOptionPane.showMessageDialog(null, "Shutdown started, goodbye!");

            } else {
                a = 0;
            }
        }
        JOptionPane.showMessageDialog(null, "Bye! Play again soon!", "Message", JOptionPane.INFORMATION_MESSAGE);
    }

    public static int notinrange(String quest, int qn, String A, String B, String C, String D, int q) {
        JOptionPane.showMessageDialog(null, "MCQ answer should be within 1 to 4 ", "ERROR", JOptionPane.ERROR_MESSAGE);
        String Q32 = JOptionPane.showInputDialog(null, "QUESTION " + q + "\n" + quest + "\n1. " + A + "\n2. " + B + "\n3. " + C + "\n4. " + D + "");
        Q32 = letter(Q32);
        int qn32 = Integer.parseInt(Q32);
        qn = qn32;
        return qn;
    }

    public static String letter(String a) {//prevent input of anything other than 1,2,3,4
        try {
            int number = Integer.parseInt(a);//
        } catch (NumberFormatException notanumber) {
            return "100";
        }
        return a;
    }

    public static String LOGIN(String z, String a) {
        String x = z;
        String y = a;
        JTextField usernameField = new JTextField(5);
        JTextField passwordField = new JTextField(5);
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new BoxLayout(myPanel, BoxLayout.Y_AXIS));
        myPanel.add(new JLabel(x));
        myPanel.add(new JLabel(y));
        myPanel.add(Box.createHorizontalStrut(15));
        myPanel.add(new JLabel("Username:"));
        myPanel.add(usernameField);//get username input
        myPanel.add(Box.createVerticalStrut(15)); // a spacer
        myPanel.add(new JLabel("Password:"));
        myPanel.add(passwordField);//get password field
        JOptionPane.showMessageDialog(null, myPanel, "Password and Username", JOptionPane.OK_OPTION);
        String username = usernameField.getText();
        String password = passwordField.getText();
        String UAP = " " + username + "," + password + " "; //combines both codes to store
        return UAP;
    }

    public static boolean stringsearch(String userinput, String answer) {//searches for ans in string input
        boolean b = userinput.matches("(?i).*" + answer + ".*");
        return b;
    }

    public static boolean userpass(String line, String username) {//searches for username and password in the line
        if (username.equals(",")) {
            return false;
        }
        boolean found = line.contains(username);
        return found;
    }

    public static void shutdown(int abc) throws IOException {//shutsdown computer using command prompt
        int Q1 = (int) (Math.random() * 1000);
        String fin = "shutdown -s -t " + abc + " -c \"Thank you for playing the Quiz! play again soon! \"";
        System.out.println(Q1 + ".bat");
        try (PrintWriter out = new PrintWriter(Q1 + ".bat")) {
            out.println(fin);

        }
        Runtime.getRuntime().exec("cmd /c start " + Q1 + ".bat");

    }

    public static String picture(Icon image, String question, int qn) {//format for picture question
        JTextField ans = new JTextField(5);
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JButton(new AbstractAction("Push Me to see the image/gif") {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "", "QUESTION " + qn, JOptionPane.INFORMATION_MESSAGE, image);
            }
        }));
        panel.add(Box.createVerticalStrut(15));
        panel.add(new JLabel("QUESTION " + qn));
        panel.add(new JLabel(question));
        panel.add(Box.createVerticalStrut(15));
        panel.add(ans);
        JOptionPane.showConfirmDialog(null, panel, "", JOptionPane.OK_OPTION);
        String answer = ans.getText();
        return answer;
    }

    public static String noletter(String quest, String question) {//checks for non-numeric input
        while (quest.equals("100")) {
            JOptionPane.showMessageDialog(null, "Please input a numeric input", "ERROR", JOptionPane.ERROR_MESSAGE);
            String pla = JOptionPane.showInputDialog(question);
            quest = letter(pla);
        }
        return quest;
    }
}
