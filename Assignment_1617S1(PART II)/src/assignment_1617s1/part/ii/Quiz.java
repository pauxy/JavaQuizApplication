/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_1617s1.part.ii;

import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author chuny
 */
public class Quiz {
private int y=0;
    private int x= 16;
    private Question[] array = new Question[x];

    public Quiz() throws MalformedURLException {
        ImageIcon NYANCAT = new ImageIcon(new URL("http://24.media.tumblr.com/8210fd413c5ce209678ef82d65731443/tumblr_mjphnqLpNy1s5jjtzo1_400.gif"));//save image
        ImageIcon PUSHEEN = new ImageIcon(new URL("http://images5.fanpop.com/image/photos/24800000/Pusheen-pusheen-the-cat-24897498-350-300.gif"));
        ImageIcon GUDETAMA = new ImageIcon(new URL("https://66.media.tumblr.com/55172e91f2eb102757c520406fa875f5/tumblr_nssrn4TJtd1si7p4uo2_500.gif"));
        ImageIcon TOTORO = new ImageIcon(new URL("https://66.media.tumblr.com/4c9a87cdf92eb3fb66e17b8d209430d9/tumblr_mx78g2uAUl1qhd8sao1_500.gif"));
        ImageIcon JAKE = new ImageIcon(new URL("https://upload.wikimedia.org/wikipedia/en/d/d0/JaketheDog.png"));
        ImageIcon PANDA = new ImageIcon(new URL("http://24.media.tumblr.com/f5015e7f3f82316d8b7c89a0ffd65658/tumblr_mpsbt23eO01s65dm8o2_400.gif"));
        
        int a = (int) (Math.random() * 101);
        int b = (int) (Math.random() * 101);
        array[0] = new Question("What is " + a + " + " + b + " ?", "" + (a + b - 2) + "", "" + (a + b - 3) + "", "" + (a + b + 2) + "", "" + (a + b - 1) + "", "" + (a + b) + "", 1);
        array[1] = new Question("What is IP?", "Internet Protocol", 2);
        array[2] = new Question("Who is considered the founding father of sociology?", "Auguste Comte", 2);
        array[3] = new Question("What is " + a + " - " + b + " ?", "" + (a - b - 2) + "", "" + (a - b - 3) + "", "" + (a - b + 2) + "", "" + (a - b - 1) + "", "" + (a - b) + "", 1);
        array[4] = new Question("What is " + a + " x " + b + " ?", "" + (a * b - 2) + "", "" + (a * b - 4) + "", "" + (a * b + 2) + "", "" + (a * b + 5) + "", "" + (a * b) + "", 1);
        array[5] = new Question("Galileo was an Italian astronomer who", "discovered four satellites of Jupiter", "developed the telescope", "discovered that the movement of pendulum produces a regular time measurement", "discovered that the Earth orbits the Sun", "All of the above", 1);
        array[6] = new Question("The first China war was between...", "China and France", "China and Egypt", "China and Greek", "China and Russia", "China and Britain", 1);
        array[7] = new Question("The Afghan war took place in which year", "1839", 2);
        array[8] = new Question("What is " + a + " x 2 ?", "" + (a * 2 - 1) + "", "" + (a * 2 - 3) + "", "" + (a * 2 + 2) + "", "" + (a * 2 + 1) + "", "" + (a * 2) + "", 1);
        array[9] = new Question("What is 1 + 2 ?", "2", "4", "1", "5", "3", 1);
        array[10]= new Question("What character is in the Gif?",PUSHEEN,"Pusheen",3);
        array[11]= new Question("Who is this character?",NYANCAT,"Nyan Cat",3);
        array[12]= new Question("Who is this character?",GUDETAMA,"Gudetama",3);
        array[13]= new Question("Who is this character?",TOTORO,"Totoro",3);
        array[14]= new Question("Who is this character in this image?",JAKE,"Jake",3);
        array[15]= new Question("Who is this animal?",PANDA,"Panda",3);
        
    }

    public Question returnarray(int c) {//return array
        return array[c];
    }
    public int noofquestion(){//return noofquestion
    return x;
    }

}
