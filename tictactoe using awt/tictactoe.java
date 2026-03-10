import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class tictactoe {

    JFrame f = new JFrame("Tic Tac Toe");
    JButton[] b = new JButton[9];
    char p = 'X';
    int m = 0;

    tictactoe(){

        f.setLayout(new GridLayout(3,3));

        for(int i=0;i<9;i++){

            b[i] = new JButton("");
            b[i].setFont(new Font("Arial",Font.BOLD,40));

            int x=i;

            b[i].addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    play(x);
                }
            });

            f.add(b[i]);
        }

        f.setSize(300,300);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void play(int i){

        if(!b[i].getText().equals("")) return;

        b[i].setText(String.valueOf(p));
        m++;

        if(win()){
            JOptionPane.showMessageDialog(f,"Player "+p+" Wins!");
            reset();
            return;
        }

        if(m==9){
            JOptionPane.showMessageDialog(f,"Game Draw!");
            reset();
            return;
        }

        if(p=='X')
            p='O';
        else
            p='X';
    }

    boolean win(){

        int[][] w = {
                {0,1,2},{3,4,5},{6,7,8},
                {0,3,6},{1,4,7},{2,5,8},
                {0,4,8},{2,4,6}
        };

        for(int[] c : w){

            if(!b[c[0]].getText().equals("") &&
               b[c[0]].getText().equals(b[c[1]].getText()) &&
               b[c[1]].getText().equals(b[c[2]].getText()))
                return true;
        }

        return false;
    }

    void reset(){

        for(int i=0;i<9;i++)
            b[i].setText("");

        p='X';
        m=0;
    }

    public static void main(String[] args){
        new tictactoe();
    }
}