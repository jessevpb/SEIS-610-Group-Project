/**
 * Write a description of class App here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.Arrays;

public class App
{

    public static void main(String[] args)
    {

        //take input crossover %
        //take input mutate %
        //take input testing x and y values (xArray and yArray)
        //take input current tree generation (testTrees)
        //initialize first generation        

        int testValuesX[];
        int testValuesY[];        
        double crossoverPercent;
        double mutatePercent;
        int fitnessScores[] = new int[40];
        int i;
        int j = 0;
        Evcompra testTrees[] = new Evcompra[40];
        Evcompra newTrees[] = new Evcompra[40];
        double fitnessThreshold = Arrays.sort(fitnessScores)[29];
        Evcompra survivingTrees[] = new Evcompra[30];

        int crossoverNumber = (int)(40 * crossoverPercent)-1;
        int mutateNumber = (int)(40 * (crossoverPercent + mutatePercent))-1;
        int remaining = 40 - mutateNumber;

        for(i = 0; i < testTrees.length(); i++)
        {
            testTrees[i] = new Evcompra();            
            fitnessScores[i] = getFitness(testTrees[i]);
        }              

        for(i = 0; i < 40; i++)
        {            
            if(testTrees[i].getFitness() < fitnessThreshold)
            {
                survivingTrees[j] = testTrees[i];
                j++;
            }
        }

        for(i = 0; i < crossoverNumber; i++)
        {         
            //crossover a portion of two trees                        

        }

        for(i = crossoverNumber+1; i < mutateNumber; i++)
        {
            //mutate a portion of trees

        }

        j = mutateNumber + 1;

        for(i = 0; i < testTrees.length(); i++)
        {
            if(testTrees[i].getFitness() < fitnessScores[remaining])
            {
                newTrees[j] = testTrees[i];
                j++;
            }
        }

    }

    private static double checkFitnessScore(Tree t)
    {
        //convert tree to expression
        //evaluate tree for given values of x

        for(i=0; i < xArray.length(); i++)
        {
            int x = xArray[i];
            // evaluate expression at x

        }
        //sum absolute value of difference between test and target y values       
    }
}
