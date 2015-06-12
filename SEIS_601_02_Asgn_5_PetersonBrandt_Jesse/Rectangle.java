
/**
 * Write a description of class Rectangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle implements Calculated
{
    // instance variables - replace the example below with your own
    private int x;
    private int y;
    private int length;
    private int width;

    /**
     * Constructor for objects of class Rectangle
     */
    public Rectangle(int X, int Y, int l, int w)
    {
        x = X;
        y = Y;
        length = l;
        width = w;
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public void expand()
    {
        int lengthDouble = 2 * length;
        int widthDouble = 2 * width;
        length = lengthDouble;
        width = widthDouble;
    }

    public void reduce()
    {
        int lengthHalf = length/2;
        int widthHalf = width/2;
        length = lengthHalf;
        width = widthHalf;
    }

    public void moveX(int X)
    {
        x = X;
    }

    public void moveY(int Y)
    {
        y = Y;
    }

    public void moveXandY(int X, int Y)
    {
        x = X;
        y = Y;
    }

    public void dump()
    {
        System.out.println("About this " + this.getClass().getName() + ":");
        System.out.println("Location: x = " + x + ", y = " + y);
        System.out.println("Dimensions: length = " + length + ", width = " + width);
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
    }

    public double calculateArea()
    {
        return length*width;
    }

    public double calculatePerimeter()
    {
        return 2*length+2*width;
    }

}
