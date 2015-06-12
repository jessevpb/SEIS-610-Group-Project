
/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Rectangle implements Solid
{
    
    private String color;
    
    public Box(int X, int Y, int l, int w, String c)
    {
        super(X,Y,l,w);
        color = c;
    }
    
    /**
     * Constructor for objects of class Box
     */
    public String getColor()
    {
        return color;
    }

    public void setColor(String c) throws Exception
    {
        if(c == null)
        {
            throw new Exception("Color cannot be null.");
        }
        else
        {
            color = c;
        }
        
    }
    
    public void dump()
    {
        super.dump();
        System.out.println("Color: " + color);
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
}
