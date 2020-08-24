package tools;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;

/**
*This class provide utility methods for reading a file from a pre determined location,
*then calculating the frequencies for each word or providing with the feature vectors.
* @author SIMRAN
*/

public class FileReaderUtil 
{

/**
* This method calculates the frequencies for each of the word in the files present at
* pre determined location
* @return - frequency map of the words
* @throws IOException
*/

public static Map<String,Integer> calculateFrequencies(PolarityType polarity, int startIndex, int endIndex) throws IOException 
{
  Map<String, Integer> dictionaryFrequency = initializeDictionaryFrequency();
  File folder = new File("res/reviews/" + polarity.code() );
  File[] listOfFiles = folder.listFiles();
  for (int i = 0; i < listOfFiles.length; i++) 
  {
    File file = listOfFiles[i];
    int sequence = Integer.parseInt(file.getName().substring(2, 5));
    // including startIndex, excluding endIndex
    if(sequence >= startIndex && sequence < endIndex){
    continue;
  }
  
  if (file.isFile() && file.getName().endsWith(".txt")) 
  {
    String content = FileUtils.readFileToString(file);
    for(String word : dictionaryFrequency.keySet()) 
    {
      if(content.toLowerCase().contains(word)) 
        {
          dictionaryFrequency.put(word, dictionaryFrequency.get(word) + 1);
        }
    }
  }
}
return dictionaryFrequency;
}

/**
* It calculates the feature vector for each word by parsing the specified file.
* @param file - the file to be parsed
* @return - the feature map
* @throws IOException
*/

public static HashMap<String, Boolean> getFeatureVector(File file) throws IOException 
{
  HashMap<String, Boolean> featureVector = initializeFeatureVector();
  if (file.isFile() && file.getName().endsWith(".txt")) 
    {
      String content = FileUtils.readFileToString(file);
      for(String word : featureVector.keySet()) 
        {
          if(content.toLowerCase().contains(word)) 
            {
              featureVector.put(word, true);
            }
        }
    }
return featureVector;
}

/**
* this method initializes the frequency map and sets all values as 0
* @return - frequency map
*/

private static Map<String, Integer> initializeDictionaryFrequency() 
{
  HashMap<String, Integer> dictionaryFrequency = new HashMap<String, Integer>();
  dictionaryFrequency.put("awful", 0);
  dictionaryFrequency.put("bad", 0);
  dictionaryFrequency.put("boring", 0);
  dictionaryFrequency.put("dull", 0);
  dictionaryFrequency.put("effective", 0);
  dictionaryFrequency.put("enjoyable", 0);
  dictionaryFrequency.put("great", 0);
  dictionaryFrequency.put("hilarious", 0);
  return dictionaryFrequency;
}

/**
* this method initializes the feature map and sets all values as false.
* @return - frequency map
*/

private static HashMap<String, Boolean> initializeFeatureVector() 
{
  HashMap<String, Boolean> featureVector = new HashMap<String, Boolean>();
  featureVector.put("awful", false);
  featureVector.put("bad", false);
  featureVector.put("boring", false);
  featureVector.put("dull", false);
  featureVector.put("effective", false);
  featureVector.put("enjoyable", false);
  featureVector.put("great", false);
  featureVector.put("hilarious", false);
  return featureVector;
}
}
