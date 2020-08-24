package classifiers;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import tools.FileReaderUtil;
import tools.PolarityType;

/**
* This class is responsible for training purposes using the the group of reviews
provided and
* calculating the probabilities for each of the dictionary word.
* @author SIMRAN
*
*/

public class Training 
{

public static final int TOTAL_NUMBER_OF_FILES = 1000;

HashMap<String, Float> positiveProbability;

HashMap<String, Float> inversePositiveProbability;

HashMap<String, Float> negativeProbability;

HashMap<String, Float> inverseNegativeProbability;

public HashMap<String, Float> getPositiveProbability() 
{
  return positiveProbability;
}

public HashMap<String, Float> getInversePositiveProbability() 
{
  return inversePositiveProbability;
}

public HashMap<String, Float> getNegativeProbability() 
{
  return negativeProbability;
}

public HashMap<String, Float> getInverseNegativeProbability() 
{
  return inverseNegativeProbability;
}

public Training() 
{
  super();
  positiveProbability = initializeDictionaryProbability();
  negativeProbability = initializeDictionaryProbability();
}

/**
* This method creates a blank hashmap with all the words as keys and their frequencies
* as 0.
* @return the created blank hashmap
*/

public HashMap<String, Float> initializeDictionaryProbability() 
{
  HashMap<String, Float> probabilityMap = new HashMap<String, Float>();
  probabilityMap.put("awful", 0f);
  probabilityMap.put("bad", 0f);
  probabilityMap.put("boring", 0f);
  probabilityMap.put("dull", 0f);
  probabilityMap.put("effective", 0f);
  probabilityMap.put("enjoyable", 0f);
  probabilityMap.put("great", 0f);
  probabilityMap.put("hilarious", 0f);
  return probabilityMap;
}

/**
* This method assigns the values to each of the four probabilities after calculating
*/

void calculateProbabilities(int startIndex, int endIndex) throws IOException 
{
  int numberOfFiles = TOTAL_NUMBER_OF_FILES - (endIndex - startIndex);
  Map<String, Integer> dictionaryFrequency =
  FileReaderUtil.calculateFrequencies(PolarityType.POS, startIndex, endIndex);
  for (String word : dictionaryFrequency.keySet()) 
  {
    positiveProbability.put(word, (float) dictionaryFrequency.get(word) / numberOfFiles);
  }

dictionaryFrequency = FileReaderUtil.calculateFrequencies(PolarityType.NEG, startIndex, endIndex);

for (String word : dictionaryFrequency.keySet()) 
{
  negativeProbability.put(word, (float) dictionaryFrequency.get(word) /
  numberOfFiles);
}

/*calculating the inverse probabilities just by subtracting from 1 the
probability of a particular word*/

inversePositiveProbability = calculateInvserseProbabiltyMap(positiveProbability);

inverseNegativeProbability = calculateInvserseProbabiltyMap(negativeProbability);

}

/**
* This method calculates the inverse probabilities just by subtracting from 1, the
probabilty of a particular word
* @param probabilityMap - the inversed probability map.
* @return
*/

private HashMap<String, Float> calculateInvserseProbabiltyMap(HashMap<String, Float> probabilityMap) 
{
  HashMap<String, Float> inverseMap = initializeDictionaryProbability();
  for(String word : probabilityMap.keySet()) {
  inverseMap.put(word, (1 - probabilityMap.get(word)) );
}

return inverseMap;
}
}
