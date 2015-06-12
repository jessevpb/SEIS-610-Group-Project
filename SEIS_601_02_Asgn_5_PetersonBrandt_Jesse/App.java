
/**
 * Write a description of class App here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class App
{
    // instance variables - replace the example below with your own
    public static void main(String[] args)
    {
        //1
        ShapeManager Shapes = new ShapeManager();

        //2
        Rectangle r1 = new Rectangle(100,120,10,13);

        Shapes.addShape(r1);

        //3
        Triangle t1 = new Triangle(10,12,3,4);

        Shapes.addShape(t1);

        //4
        Rectangle r2 = new Rectangle(7,9,18,2);
        
        Shapes.addShape(r2);
        
        Triangle t2 = new Triangle(0,23,10,10);

        Shapes.addShape(t2);
        
        //5
        Shapes.dump();

        //6
        r1.expand();
        
        //7
        t1.expand();

        //8
        Shapes.dump();

        //9
        Box b1 = new Box(200,240,10,13,"Yellow");

        Shapes.addShape(b1);

        //10
        
        Triangle t3 = new Triangle(30,20,10,2);

        Shapes.addShape(t3);

        //11
        
        Shapes.dump();

        //12
        
        try
        {
            b1.setColor("Purple");
        }
        catch(Exception e)
        {
            ;
        }
        
        //13
        b1.moveXandY(300,360);
        
        //14
        Box b2 = new Box(11,20,19,34,"Scarlet");
        
        Box b3 = new Box(16,22,30,2,"Black");
        
        Shapes.addShape(b2);
        
        Shapes.addShape(b3);
        
        //15
        Shapes.dump();
        
        //16
        b1.reduce();
        
        //17
        t3.reduce();
        
        //18
        Shapes.dump();
    }
}
