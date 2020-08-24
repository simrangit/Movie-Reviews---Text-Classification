package classifiers;

import java.io.IOException;
import org.junit.Test;

/**
* This test file tests the training functionality of the program which parses the
* files and calculates the probabilities of each word in the dictionary.
* @author SIMRAN
*/

public class TrainingTest 
{
  Training trainingBean = new Training();
  
  @Test
  public void testCalculateProbabilitiesForAll() 
  {
    try 
    {
      trainingBean.calculateProbabilities(0, 0);
      System.out.println("Postive Probabilties: ");
      System.out.println(trainingBean.getPositiveProbability());
      System.out.println("Negative Probabilties: ");
      System.out.println(trainingBean.getNegativeProbability());
      System.out.println("Inverse Postive Probabilties: ");
      System.out.println(trainingBean.getInversePositiveProbability());
      System.out.println("Inverse Negative Probabilties: ");
      System.out.println(trainingBean.getInverseNegativeProbability());
      assert (true);
    } 
    catch (IOException e) 
    {
      e.printStackTrace();
      assert (false);
    }
  }
  
@Test

public void testCalculateProbabilitiesExcluding200To300() 
{
  try 
  {
    trainingBean.calculateProbabilities(200, 300);
    System.out.println("Postive Probabilties: ");
    System.out.println(trainingBean.getPositiveProbability());
    System.out.println("Negative Probabilties: ");
    System.out.println(trainingBean.getNegativeProbability());
    System.out.println("Inverse Postive Probabilties: ");
    System.out.println(trainingBean.getInversePositiveProbability());
    System.out.println("Inverse Negative Probabilties: ");
    System.out.println(trainingBean.getInverseNegativeProbability());
    assert (true);
  } 
  catch (IOException e) 
  {
    e.printStackTrace();
    assert (false);
  }
  }
}
