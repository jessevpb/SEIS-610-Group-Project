
import java.util.Stack;
public class Evcompra
{
    int MAXNODES = 128;
    Node[] tree;
    int MAXHEIGHT = 5; // maximum height of the tree
    int OPERANDPROB = 14; // Probability of getting an 'x' is (OPERANDPROB - 10)/OPERANDPROB
    int height;
    String treeStr = "";
    double fitness = -1;
    double MUTATIONRATE = 0.05;
    double CROSSRATE = 0.8;
    Stack<Double> evalSt = new Stack<Double>();

    // ASCII char values of the operator symbols, the letter x, and the character for 0
    int cAdd = 43; int cSub = 45; int cMult = 42; int cDiv = 47; int cX = 120; int cZero = 48;

    public Evcompra()
    {
        tree = new Node[MAXNODES];
        tree[1] = new Node(null, null, randOperator(), true, 1, 1 ); // root node is always an operator node
    }

    public Evcompra copySelf()
    {
        Evcompra out = new Evcompra();
        for(int i = 1; i < MAXNODES; i++)
        {
            if(this.tree[i] == null ) continue;
            else out.tree[i] = this.tree[i].copySelf();
        }
        out.height = this.height;
        return out;
    }

    public void fillTreeStr(Node n) // postorder
    {
        if(n == null) return;
        //treeStr += n.getValue();
        fillTreeStr(n.getLeft());
        fillTreeStr(n.getRight());
        treeStr += (n.getValue());
    }

    public String getEvalString(double input)
    {
        return treeStr.replace("x", (new Double(input)).toString());
    }

    public void printEquation()
    {
        System.out.println(treeStr);
    }

    public void fillTree(Node n)
    {
        // System.out.println("fillTree( tree[" + n.getIndex() + "] )");
        if(n == null) return; // can't populate a null
        if((int)(n.getValue()) >= cZero) return; // operand node has no children
        makeLeft(n); // populate both children
        makeRight(n);
        fillTree(n.getLeft());
        fillTree(n.getRight());
    }

    public void makeLeft(Node n)
    {
        int nValue = (int)(n.getValue());
        int nHt = n.getHeight();

        if(nValue >= cZero)
        {
            // System.out.println("Can't set n.left, n.value = " + n.getValue() );
            return;
        }

        if(nHt < MAXHEIGHT - 1) //node can be operator or operand
        {
            int newIndex = n.getIndex() * 2;
            Node newNode = new Node(randValue(), nHt + 1, newIndex );
            tree[newIndex] = newNode;
            n.setLeft(newNode);
            if( (nHt + 1) > this.height) this.height = nHt + 1;

        }

        if(nHt == MAXHEIGHT - 1) //newNode.height will be MAXHEIGHT, so it must be an operand
        {
            int newIndex = n.getIndex() * 2;
            Node newNode = new Node(randOperand(), nHt + 1, newIndex );
            tree[newIndex] = newNode;
            n.setLeft(newNode);
            if( (nHt + 1) > this.height) this.height = nHt + 1;
        }
        else
        {
            //System.out.println("Max height exceeded. Calling left node tree[" + n.getIndex() + "]");
            return;
        }
    }

    public void makeRight(Node n)
    {
        int nValue = (int)(n.getValue());
        int nHt = n.getHeight();

        if(nValue >= cZero)
        {
            // System.out.println("Can't set n.right, n.value = " + n.getValue() );
            return;
        }

        if(nHt < (MAXHEIGHT - 1) )
        {
            int newIndex = n.getIndex() * 2 + 1;
            Node newNode = new Node(randValue(), nHt + 1, newIndex );
            tree[newIndex] = newNode;
            n.setRight(newNode);
        }

        if(nHt == (MAXHEIGHT - 1) ) //newNode.height will be MAXHEIGHT, so it must be an operand
        {
            int newIndex = n.getIndex() * 2 + 1;
            Node newNode = new Node(randOperand(), nHt + 1, newIndex );
            tree[newIndex] = newNode;
            n.setRight(newNode);
        }

        else
        {
            //System.out.println("Max height exceeded. Calling right node tree[" + n.getIndex() + "]");
            return;
        }
    }

    public char randOperator()
    {
        int r = (int)(Math.random() * 4);
        switch(r)
        {
            case 0:
            return '+';
            case 1:
            return '-';
            case 2:
            return '*';
            default:
            return '/';
        }
    }

    public char randOperand()
    {
        int r = (int)(Math.random() * OPERANDPROB);
        if(r < 10) return (char)(r + cZero);
        return 'x';
    }

    public char randValue()
    {
        char c;
        int r = (int)(Math.random() * 10);
        if(r < 4) c = randOperator();
        else c = randOperand();
        //System.out.printf("randValue() = %c\n", c); 
        return c;
    }     

    public double evaluate(double xValue)
    {
        int exprlen = this.treeStr.length();
        double op1, op2;
        for(int i = 0; i < exprlen; i++)
        {
            //System.out.println("["+ i + "]:" + treeStr.charAt(i));
            switch( this.treeStr.charAt(i) )
            {
                case '+':
                op2 = (double)(evalSt.pop());
                op1 = (double)(evalSt.pop());
                //System.out.println(op1 + " + " + op2 + " = " + (op1+op2));
                evalSt.push(op1 + op2);
                break;
                case '-':
                op2 = (double)(evalSt.pop());
                op1 = (double)(evalSt.pop());
                //System.out.println(op1 + " - " + op2 + " = " + (op1 - op2));
                evalSt.push(op1 - op2);
                break;
                case '*':
                // System.out.println(treeStr.charAt(i));
                op2 = (double)(evalSt.pop());
                op1 = (double)(evalSt.pop());
                //System.out.println(op1 + " * " + op2 + " = " + (op1 * op2));
                evalSt.push(op1 * op2);
                break;
                case '/':
                // System.out.println(treeStr.charAt(i));
                op2 = (double)(evalSt.pop());
                op1 = (double)(evalSt.pop());
                //System.out.println(op1 + " / " + op2 + " = " + (op1 / op2));
                if(op2 == 0) return 10000000;
                evalSt.push(op1 / op2);
                break;
                case 'x':
                //System.out.println(treeStr.charAt(i));
                evalSt.push(xValue);
                break;
                case '0':
                evalSt.push(0.0);
                break;
                case '1':
                evalSt.push(1.0);
                break;
                case '2':
                evalSt.push(2.0);
                break;
                case '3':
                evalSt.push(3.0);
                break;
                case '4':
                evalSt.push(4.0);
                break;
                case '5':
                evalSt.push(5.0);
                break;
                case '6':
                evalSt.push(6.0);
                break;
                case '7':
                evalSt.push(7.0);
                break;
                case '8':
                evalSt.push(8.0);
                break;
                case '9':
                evalSt.push(9.0);
                break;
                default:
                System.out.println("This line should never print.");
                break;
            }
        }
        return (double)(evalSt.pop());
    }

    public int getHeight()
    {
        return this.height;
    }

    public void setHeight(int newHt)
    {
        this.height = newHt;
    }

    private void calcHeightRecursive(Node n)
    {   
        if(n == null) return;
        calcHeightRecursive(n.getLeft());
        calcHeightRecursive(n.getRight());
        if(n.getHeight() > this.height) this.height = n.getHeight();
    }

    public double getFitness()
    {
        return fitness;
    }

    public void setFitness(float fts)
    {
        this.fitness = fts;
    }

    public void setFitness(double trainingData[][]) // Each row is an [x][y], or [input][output], pair
    {
        this.fitness = 0;
        double xTr, yTr, yEval, fit;
        int tdLen = trainingData[0].length;
        //int len1 = trainingData.length;
        //int len2 = trainingData[0].length;
        //System.out.println("len1=" + len1);
        //System.out.println("len2=" + len2);
        for(int i = 0; i < tdLen; i++)
        {
            xTr = trainingData[0][i]; yTr = trainingData[1][i];
            yEval = evaluate(xTr);
            //System.out.printf("x input: %.2f, y expected: %.2f, y evaluated: %.2f\n",xTr,yTr,yEval);

            fit = Math.abs( yEval - yTr );
            //System.out.printf("Point fitness: abs( %.2f - %.2f ) = %.2f\n\n", yTr, yEval, fit);
            fitness += fit;
        }
    }

    public void mutateTree(Node n)
    {
        if(n == null) return;
        mutateTree(n.getLeft());
        mutateTree(n.getRight());
        if(Math.random() <= MUTATIONRATE)
        {
            if( (int)(n.getValue() ) >= cZero) n.setValue(randOperand());
            else n.setValue(randOperator());
        }
    }

    public void crossWith(Node thisN, Node otherN, boolean isCrossing)
    {
        boolean xOver = isCrossing;
        // At least one is null
        if(thisN == null || otherN == null){
            // System.out.println("Both null");
            return;
        }
        // At least one
        //if( (int)(thisN.getValue()) > cDiv || (int)(otherN.getValue()) > cDiv );
        if(Math.random() < CROSSRATE) xOver = true;
        if(!isCrossing){
            if(isCrossing) System.out.println("isCrossing=true");
            //if(!isCrossing) System.out.println("Crossing succeeded");
            crossWith(thisN.getLeft(), otherN.getLeft(), xOver);
            crossWith(thisN.getRight(), otherN.getRight(), xOver);
        }
        else
        {
            System.out.println(">< crossover");
            thisN.setValue(otherN.getValue());
            thisN.setRight(otherN.getRight());
            thisN.setLeft(otherN.getLeft());
            thisN.setIndex(otherN.getIndex());
            thisN.setHeight(otherN.getHeight());
            crossWith(thisN.getLeft(), otherN.getLeft(), true);
            crossWith(thisN.getRight(), otherN.getRight(), true);
        }
    }

}
