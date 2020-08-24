package sampling;

import org.junit.Test;

/**
* This test case is responsible for generating 5 positive and 5 negative reviews.
* @author SIMRAN
*
*/

public class MovieReviewSamplerTest 
{
  MovieReveiwSampler movieReveiwSampler = new MovieReveiwSampler();
  
  @Test
  public void testGetPositiveReview() 
  {
    String generatedReview;
    for (int i = 0; i < 5; i++) 
    {
      generatedReview = movieReveiwSampler.getPositiveReview();
      System.out.println(generatedReview);
    }
    assert (true);
  }
  
@Test
public void testGetNegativeReview() 
{
  String generatedReview;
  for (int i = 0; i < 5; i++) 
  {
    generatedReview = movieReveiwSampler.getNegativeReview();
    System.out.println(generatedReview);
  }
  assert (true);
}
}
