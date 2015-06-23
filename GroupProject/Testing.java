
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

        nodes[0] = new Node(0);
        nodes[1] = new Node(1);
        nodes[2] = new Node(1);
        nodes[3] = new Node(1);
        nodes[4] = new Node(1);
        nodes[5] = new Node(1);
        nodes[6] = new Node(1);
        nodes[7] = new Node(1);
        nodes[8] = new Node(1);
        nodes[9] = new Node(1);
        nodes[10] = new Node(1);

        int i;

        for(i=0;i<11;i++)
        {
            nodes[i].printValue();
            random[i] = Math.random();
        }

        Arrays.sort(random);

        System.out.println(Arrays.toString(random));

        double crossoverPercent = .1442;
        double mutatePercent = .0544;

        int crossoverNumber = (int)(40 * crossoverPercent);
        int mutateNumber = (int)(40 * (crossoverPercent + mutatePercent));
        int remaining = 40 - mutateNumber;

        System.out.println(crossoverNumber + "   " + mutateNumber + "   " + remaining);
    }
}
