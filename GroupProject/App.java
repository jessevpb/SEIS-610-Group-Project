
/**
 * Write a description of class App here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class App
{

    public static void main(String[] args)
    {
        Node nodes[] = new Node[11 ];
        
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
        }
    }
}
