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

    int xVars[];
    int yVars[];
    int generationSize;
    double crossoverPercent;
    double mutatePercent;

    JPanel first = new JPanel();
    JPanel second = new JPanel();
    JPanel third = new JPanel();
    JPanel fourth = new JPanel();
    JPanel fifth = new JPanel();

    JButton run = new JButton("Run");

    JTextField xVals = new JTextField(30);
    JTextField yVals = new JTextField(30);   
    JTextField crossNum = new JTextField(2);
    JTextField mutateNum = new JTextField(2);
    JTextField geneNum = new JTextField(3);

    JLabel cross = new JLabel("Crossover Percent");
    JLabel mutate = new JLabel("Mutate Percent");
    JLabel gene = new JLabel("Generation Size");
    JLabel Xs = new JLabel("X Values");
    JLabel Ys = new JLabel("Y Values");

    JComboBox cb = new JComboBox();
    JTextArea ta = new JTextArea("Area", 5, 12);

    public static void main(String[] args)
    {
        new RunApp();
    }

    public RunApp()
    {
        super("Find the Equation");
        setSize(400,500);
        setResizable(false);
        setLocation(750,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5,0));
 
        first.add(cross);
        first.add(crossNum);
        second.add(mutate);
        second.add(mutateNum);
        third.add(gene);
        third.add(geneNum);
        fourth.add(Xs);
        fourth.add(xVals);
        fourth.add(Ys);
        fourth.add(yVals);
        fifth.add(run);
        
        add(first);      
        add(second);
        add(third);
        add(fourth);
        add(fifth);

        run.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e)
    {
        Object src = e.getSource();
        if(src.equals(run))
        {
            String g = geneNum.getText();
            generationSize = Integer.parseInt(g);
            String c = crossNum.getText();
            crossoverPercent = Double.parseDouble(c);
            String m = mutateNum.getText();
            mutatePercent = Double.parseDouble(m);
            
            //double testValuesX[] = {-5,-3, 0, 2,  10};
            double testValuesX[] = csvToDoubles(xVals);
            double testValuesY[] = csvToDoubles(yVals);
            
            // ************ TESTING ****************
            System.out.printf("\nGen: %d, Cross: %.2f Mutation: %.2f\n",
                                generationSize, crossoverPercent, mutatePercent);
            System.out.println("X values");
            for (double s : testValuesX) {
            System.out.print(s + " ");
            }
            
            System.out.println("\nY values");
            for (double s : testValuesY) {
            System.out.print(s + " ");
            }
            
            //new App(new Evcompra[generationSize], crossoverPercent, mutatePercent,
            //generationSize, testValuesX, testValuesY);
        }
    }
    
    // Takes a text field of comma-separated floating points and returns
    // an array of doubles. No error checking.
    public double[] csvToDoubles(JTextField jtf)
    {
        String inStr;
        String[] inTokens;
        String delimiters = "[ ,]+";
        double out[];
        
        inStr = jtf.getText();
        inTokens = inStr.split(delimiters);
        out = new double[inTokens.length];
        
        for (int i = 0; i < out.length; i++) {
            out[i] = Double.parseDouble(inTokens[i]);
        }
        
        return out;
    }
}
