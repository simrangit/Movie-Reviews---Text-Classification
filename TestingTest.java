package classifiers;

import java.io.IOException;
import org.junit.Test;
import tools.PolarityType;

/**
* This test file tests the testing functionality of the program which verifies the
* predicted probabilities of each word in the dictionary.
* @author SIMRAN
*/

public class TestingTest 
{
  Testing testingBean = new Testing();
  
  @Test
  public void testCalculatePredictionsForAllPos() 
  {
    Integer numberOfCorrectPredictions;
    try 
    {
      numberOfCorrectPredictions = testingBean.calculatePredictions(PolarityType.POS, 0, 1000);
      System.out.println("For Positives:");
      System.out.println(numberOfCorrectPredictions);
      assert (true);
    } 
    catch (IOException e) 
    {
      e.printStackTrace();
      assert (false);
    }
  }
  
@Test
public void testCalculatePredictionsForAllNeg() 
{
  Integer numberOfCorrectPredictions;
  try 
  {
    numberOfCorrectPredictions =
    testingBean.calculatePredictions(PolarityType.NEG, 0, 1000);
    System.out.println("For Negatives:");
    System.out.println(numberOfCorrectPredictions);
    assert (true);
  } 
  catch (IOException e) 
  {
    e.printStackTrace();
    assert (false);
  }
}

@Test
public void testCalculatePredictionsForPos10Fold() 
{
  Integer numberOfCorrectPredictions;
  try 
  {
    for (int i = 0; i < 1000; i += 100) 
    {
      numberOfCorrectPredictions = testingBean.calculatePredictions(PolarityType.POS, i, i + 100);
      System.out.println("Positive 10 Fold :");
      System.out.println("Fold: " + ((i / 100) + 1) + " - From " + i + " to " + (i + 100) );
      System.out.println(numberOfCorrectPredictions);
      assert (true);
  }
} 
  catch (IOException e) 
  {
    e.printStackTrace();
    assert (false);
  }
}

@Test
public void testCalculatePredictionsForNeg10Fold() 
{
  Integer numberOfCorrectPredictions;
  try 
  {
    for (int i = 0; i < 1000; i += 100) {
    numberOfCorrectPredictions = testingBean.calculatePredictions(PolarityType.NEG, i, i + 100);
    System.out.println("Negative 10 Fold :");
    System.out.println("Fold: " + ((i / 100) + 1) + " - From " + i + " to " + (i + 100) );
    System.out.println(numberOfCorrectPredictions);
    assert (true);
  }
} 
  catch (IOException e) 
  {
    e.printStackTrace();
    assert (false);
  }
  }
}
