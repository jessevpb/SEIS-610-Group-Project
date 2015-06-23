
/**
 * Write a description of class OperatorNode here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class OperatorNode extends Node
{
    // instance variables - replace the example below with your own
    private String value;

    public String getValue()
    {
        System.out.print(value);
    }
    
    /**
     * Constructor for objects of class OperatorNode
     */
    public OperatorNode()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
