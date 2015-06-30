/**
 * Write a description of class RunApp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;

public class RunApp extends JFrame implements ActionListener{

    JPanel left = new JPanel();
    JPanel right = new JPanel();
    JButton b = new JButton("Run");
    JTextField t = new JTextField("Field", 6);
    JTextArea ta = new JTextArea("Area", 5, 12);
    int xVars[];
    int yVars[];
    JComboBox cb = new JComboBox();
    JTextField crossNum = new JTextField(2);
    JTextField mutateNum = new JTextField(2);
    JTextField geneNum = new JTextField(3);
    JLabel cross = new JLabel("Crossover Percent");
    JLabel mutate = new JLabel("Mutate Percent");
    JLabel gene = new JLabel("Generation Size");

    public static void main(String[] args){
        new RunApp();
    }

    public RunApp(){
        super("Find the Equation");
        setSize(400,300);
        setResizable(false);
        setLocation(500,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(0,2));
        {
            test.addActionListener(this);
            list.addActionListener(this);
            clear.addActionListener(this);
        }

        right.add(b);
        right.add(t);
        right.add(ta);
        left.add(cross);
        left.add(crossNum);
        left.add(mutate);
        left.add(mutateNum);
        left.add(gene);
        left.add(geneNum);

        add(left);
        add(right);

        b.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if(src.equals(test))
        {
        
        }
        App.main();
    }
}
