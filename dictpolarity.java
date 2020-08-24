package tools;
/**
* This Enum is responsible for maintaining a list of the codes (string values) for
positive and negative keywords for movie reviews
* @author SIMRAN
*
*/
public enum PolarityType 
{
  POS("pos"), NEG("neg");
  private String code;
  PolarityType(String code) 
  { this.code = code; }

public String code() 
{
  return code;
}
}
