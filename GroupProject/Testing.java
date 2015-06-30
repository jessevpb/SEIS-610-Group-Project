
/**
 * Write a description of class Testing here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.Arrays;

public class Testing
{
   
    public static void main(String[] args)
    {
        Node nodes[] = new Node[11];
        double random[] = new double[11];

        nodes[0] = new Node((char)0);
        nodes[1] = new Node((char)1);
        nodes[2] = new Node((char)1);
        nodes[3] = new Node((char)1);
        nodes[4] = new Node((char)1);
        nodes[5] = new Node((char)1);
        nodes[6] = new Node((char)1);
        nodes[7] = new Node((char)1);
        nodes[8] = new Node((char)1);
        nodes[9] = new Node((char)1);
        nodes[10] = new Node((char)1);

        int i;

        for(i=0;i<11;i++)
        {
            nodes[i].getValue();
            random[i] = Math.random();
        }

        Arrays.sort(random);

       // System.out.println(Arrays.toString(random));

        double crossoverPercent = .1442;
        double mutatePercent = .0544;

        int crossoverNumber = (int)(40 * crossoverPercent);
        int mutateNumber = (int)(40 * (crossoverPercent + mutatePercent));
        int remaining = 40 - mutateNumber;

        //System.out.println(crossoverNumber + "   " + mutateNumber + "   " + remaining);
        
        Evcompra tree = new Evcompra();
        tree.getEvalString(2);
        //System.out.println(
        //double eval1 = tree.evaluate(7);
        //System.out.println(eval1);
        
    }
}
