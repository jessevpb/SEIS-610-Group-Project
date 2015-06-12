
/**
 * Write a description of class ShapeManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShapeManager
{
    // instance variables - replace the example below with your own

    /**
     * Constructor for objects of class ShapeManager
     */
    public ShapeManager()
    {
        // initialise instance variables

    }

    private Calculated shapeArray[] = new Calculated[10];

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void addShape(Calculated s)
    {
        int i;
        int set = 0;
        for(i = 0; i < 10; i++)
        {

            if(shapeArray[i] == null && set == 0)
            {
                shapeArray[i] = s;
                set = 1;
            }

        }
    }

    public void dump()
    {
        int i;
        for(i = 0; i < 10; i++)
        {
            if(shapeArray[i] != null)
            {
                System.out.println("Shape number: " + i);
                shapeArray[i].dump();
                System.out.println();
            }

        }
    }
}
