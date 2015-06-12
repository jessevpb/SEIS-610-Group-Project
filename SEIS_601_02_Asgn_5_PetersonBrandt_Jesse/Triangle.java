
/**
 * Write a description of class Triangle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Triangle implements Calculated
{

    int x;
    int y;
    int length;
    int width;
    double hypotenuse;

    /**
     * Constructor for objects of class Triangle
     */
    public Triangle(int X, int Y, int l, int w)
    {
        x = X;
        y = Y;
        length = l;
        width = w;
        hypotenuse = Math.hypot(l,w);
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
        System.out.println("About this " + this.getClass().getName()  + ":");
        System.out.println("Location: x = " + x + ", y = " + y);
        System.out.println("Dimensions: length = " + length + ", width = " + width);
        System.out.println("Perimeter: " + calculatePerimeter());
        System.out.println("Area: " + calculateArea());
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

       hypotenuse = Math.hypot(length, width);
    }

    public void reduce()
    {
        int lengthHalf = length/2;
        int widthHalf = width/2;
        length = lengthHalf;
        width = widthHalf;

       hypotenuse = Math.hypot(length, width);
    }

    public double calculateArea()
    {
        return length*width/2;
    }

    public double calculatePerimeter()
    {
        return length+width+hypotenuse;
    }

}
