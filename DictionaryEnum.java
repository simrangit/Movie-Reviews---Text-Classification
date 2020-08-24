package tools;
/**
* This Enum is responsible for maintaining a list of all the dictionary words, along
* with their codes (string values) and the probabilities
* @author SIMRAN
*/

public enum DictionaryEnum 
{
  AWFUL("awful", getAwfulArray()),
  BAD("bad", getBadArray()),
  BORING("boring", getBoringArray()),
  DULL("dull", getDullArray()),
  EFFECTIVE("effective", getEffectiveArray()),
  ENJOYABLE("enjoyable", getEnjoyableArray()),
  GREAT("great", getGreatArray()),
  HILARIOUS("hilarious", getHilariousArray());
  private DictionaryEnum(String code, double[] probabiltyArray) 
    {
      this.code = code;
      this.probabiltyArray = probabiltyArray;
    }

private String code;
private double[] probabiltyArray;

public double[] getProbabiltyArray() 
  {
    return probabiltyArray;
  }

public String getCode() 
  {
    return code;
  }

private static double[] getAwfulArray() 
  {
    double[] probabiltyArray = { 0.034, 0.122 };
    return probabiltyArray;
  }

private static double[] getBadArray() 
  {
    double[] probabiltyArray = { 0.28, 0.545 };
    return probabiltyArray;
  }

private static double[] getBoringArray() 
   {
    double[] probabiltyArray = { 0.054, 0.175 };
    return probabiltyArray;
   }

private static double[] getDullArray() 
  {
    double[] probabiltyArray = { 0.025, 0.101 };
    return probabiltyArray;
  }

private static double[] getEffectiveArray() 
  {
    double[] probabiltyArray = { 0.154, 0.086 };
    return probabiltyArray;
  }

private static double[] getEnjoyableArray() 
  {
    double[] probabiltyArray = { 0.096, 0.054 };
    return probabiltyArray;
  }

private static double[] getGreatArray() 
  {
    double[] probabiltyArray = { 0.485, 0.32 };
    return probabiltyArray;
  }

private static double[] getHilariousArray() 
  {
    double[] probabiltyArray = { 0.132, 0.059 };
    return probabiltyArray;
  }
}
