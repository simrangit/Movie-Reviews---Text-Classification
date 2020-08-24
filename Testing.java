package classifiers;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import tools.FileReaderUtil;
import tools.PolarityType;

/**
* This class is responsible for testing the accuracy of our predictions once the
training has been completed for the group of reviews
* @author SIMRAN
*
*/

public class Testing 
{

Training trainingBean = new Training();

public Integer calculatePredictions(PolarityType polarity, int startIndex, int endIndex) throws IOException 
{
  Double positiveProduct;
  Double negativeProduct;
  Integer numberOfCorrectPredictions = 0;
  PolarityType predictedPolarityType;
  
  // Handling case when we need probabilties of all the files(not 10 fold crossvalidation).
  
  if(startIndex == 0 && endIndex == 1000) //Parsing all the files.
    trainingBean.calculateProbabilities(0, 0);
  else //Parsing just the specified files.
    trainingBean.calculateProbabilities(startIndex, endIndex);
    
  File folder = new File("res/reviews/" + polarity.code());
  
  File[] listOfFiles = folder.listFiles();

  for (int i = 0; i < listOfFiles.length; i++) 
    {
      File file = listOfFiles[i];
      int sequence = Integer.parseInt(file.getName().substring(2, 5));
        // including startIndex, excluding endIndex
      if (sequence >= startIndex && sequence < endIndex) 
        {
          HashMap<String, Boolean> featureVector = FileReaderUtil.getFeatureVector(file);
          positiveProduct = 0.5d;
          negativeProduct = 0.5d;
          for (String word : featureVector.keySet()) 
            {
              if (featureVector.get(word)) {
              positiveProduct *= trainingBean.getPositiveProbability().get(word);
              negativeProduct *= trainingBean.getNegativeProbability().get(word);
            } 
            else 
            {
              positiveProduct *= trainingBean.getInversePositiveProbability().get(word);
              negativeProduct *= trainingBean.getInverseNegativeProbability().get(word);
          }
     }
     
     if (negativeProduct > positiveProduct) 
      {
        predictedPolarityType = PolarityType.NEG;
      } 
      else
      {
        predictedPolarityType = PolarityType.POS;
      }
      
  if (polarity == predictedPolarityType) 
    {
      numberOfCorrectPredictions++;
    }
  }
}
  return numberOfCorrectPredictions;
}
}
