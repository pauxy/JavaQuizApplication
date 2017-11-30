

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1617s1.part.ii;

import javax.swing.Icon;

/**
 *
 * @author chuny
 */
public class Question {

    private String qn;
    private String[] option = new String[4];
    private String answer;
    private int questiontype;
    private Icon image;
    

    public Question(String question, String A, String B, String C, String D, String ans, int questiontyp) { //mcq
        qn = question;
        option[0] = A;
        option[1] = B;
        option[2] = C;
        option[3] = D;
        answer = ans;
        questiontype = questiontyp;
    }

    public Question(String question, String ans, int questiontyp) {                               //fill in the blank question
        qn = question;
        answer = ans;
        questiontype = questiontyp;
    }

    public Question(String question, Icon imag, String ans, int questiontyp) {
        qn = question;
        image = imag;
        questiontype = questiontyp;
        answer = ans;
    }

    public String option(int c) {
        return option[c];//returns option
    }

    public String ans() {
        return answer;//return answer
    }

    public int questiontype() {//returns type of question
        return questiontype;
    }

    public String question() {//returns questions
        return qn;
    }

    public Icon image() {//returns image
        return image;
    }
}


