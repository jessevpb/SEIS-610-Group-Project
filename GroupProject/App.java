/**
 * Write a description of class App here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays;

public class App
{
    long startTime = System.currentTimeMillis();
    long endTime;

    //take input crossover %
    //take input mutate %
    //take input testing x and y values (xArray and yArray)
    //take input current tree generation (testTrees)
    //initialize first generation        

    double crossoverPercent;
    double mutatePercent;
    int i;
    Evcompra newTrees[] = new Evcompra[40];
    double fitnessThreshold;
    Evcompra survivingTrees[] = new Evcompra[30];
    Evcompra tree1;
    Evcompra tree2;

    public static void main(String[] args)
    {
        Evcompra testTrees[] = new Evcompra[40];
        double testValuesX[] = {-5,-3, 0, 2,  10};
        double testValuesY[] = {12, 4, -.5, 1.5, 49.5};
        new App(testTrees, .4, .05, 40, testValuesX, testValuesY);
    }

    //public App(double crossNum, double mutateNum, int genSize, double testValuesX[], double testValuesY[])
    // {
    //     super(testTrees, crossNum, mutateNum, genSize, testValuesX, testValuesY);
    //    
    ///    Evcompra testTrees[] = new Evcompra[genSize];
    //
    // }

    public App(Evcompra[] trees, double crossNum, double mutateNum, int genSize, double testValuesX[], double testValuesY[])
    {
        
        for(i = 0; i < genSize; i++)
        {
           // trees[i].setFitness(testValuesX);
        }
        
        double fitnessScores[] = new double[genSize];
        
        fitnessScores = getFitnessArray(trees);
        Arrays.sort(fitnessScores);

        int crossoverNumber = (int)(genSize * crossoverPercent)-1;
        int mutateNumber = (int)(genSize * (crossoverPercent + mutatePercent))-1;
        int remaining = genSize - mutateNumber;
        int survivingPopulation = (int)(genSize*.75);

        fitnessThreshold = fitnessScores[survivingPopulation-1];

        if(fitnessScores[0] == 0)
        {
            for(i = 0; i < genSize; i++)
            {
                if(trees[i].getFitness() == 0)
                {
                    trees[i].printEquation();
                }
            }
            endTime = System.currentTimeMillis();
            System.out.print("## trees measured over ## generations. " + (endTime - startTime) + " seconds elapsed.");
            // graph equation
        }
        else
        {
            Evcompra newTrees[] = repopulate(trees, crossoverNumber, mutateNumber, genSize);
            new App(newTrees, crossNum, mutateNum, genSize, testValuesX, testValuesY);
        }

    }
    
        double fits[] = new double[40];
        
    private double[] getFitnessArray(Evcompra[] testTrees){

        for(i = 0; i < testTrees.length; i++)
        {   
             fits[i] = testTrees[i].getFitness();
        }
        return fits;
    }

    private Evcompra[] repopulate(Evcompra[] testTrees, int crossoverNumber, int mutateNumber, int genSize)
    {        
        int j = 0;
        int survivingPopulation = (int)(genSize*.75);
        Evcompra newTrees[] = new Evcompra[genSize];
        Evcompra survivingTrees[] = new Evcompra[survivingPopulation];

        for(i = 0; i < genSize; i++)
        {            
            if(testTrees[i].getFitness() < fitnessThreshold)
            {
                survivingTrees[j] = testTrees[i];
                j++;
            }
        }

        for(i = 0; i < crossoverNumber; i++)
        {         
            int rand1 = (int)(Math.random()*survivingPopulation);
            int rand2 = (int)(Math.random()*survivingPopulation);

            if(rand1 == rand2)
            {
                rand2 -= 1;
            }

            tree1 = survivingTrees[rand1];
            tree2 = survivingTrees[rand2];

            tree1.crossWith(tree1.tree[2], tree2.tree[2], false);

            newTrees[i] = tree1;
        }

        for(i = crossoverNumber+1; i < mutateNumber; i++)
        {
            int rand1 = (int)(Math.random()*survivingPopulation);
            tree1 = survivingTrees[rand1];
            tree1.mutateTree(tree1.tree[1]);            
            newTrees[i] = tree1;
        }

        for(i = mutateNumber+1; i < genSize; i++)
        {
            newTrees[i] = testTrees[j];
            j++;
        }

        return newTrees;
    }
}
