
/**
 * Write a description of class Node here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Node
{
    // instance variables - replace the example below with your own

    private int index;
    private String value;
    
    public void printValue()
    {
        System.out.println(value);
    }

    public int getIndex()
    {
        return index;
    }

    /**
     * Constructor for objects of class Node
     */
    public Node(int x)
    {
        index = x;
        Double random = Math.random();
        random = Math.floor(random*15)+1;
        
        switch(random.intValue())
        {
            case 1: value = "1";
            break;
            case 2: value = "2";
            break;
            case 3: value = "3";
            break;
            case 4: value = "4";
            break;
            case 5: value = "5";
            break;
            case 6: value = "6";
            break;
            case 7: value = "7";
            break;
            case 8: value = "8";
            break;
            case 9: value = "9";
            break;
            case 10: value = "0";
            break;
            case 11: value = "x";
            break;
            case 12: value = "+";
            break;
            case 13: value = "-";
            break;
            case 14: value = "/";
            break;
            case 15: value = "*";
            break;
            default:
            break;
        };
    }

    /**
     * private String value;

    public String setValue()
    {
    Vector vals = 

    int var = Math.random();
    if(var >= 0 && var <=9)
    {
    return var;
    }

    if(var == 10)
    {
    return "x";
    }

    if(var == 11)
    {
    return "+";
    }

    if(var == 12)
    {
    return "-";
    }

    if(var == 13)
    {
    return "*";
    }

    if(var == 14)
    {
    return "/";
    }
    }
     */
}
