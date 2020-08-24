package tools;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.junit.Test;
/**
* This test file tests the utility for reading/ parsing a file.
* @author SIMRAN
*
*/
public class FileReaderUtilTest {
@Test

public void testGetFeatureVector() 
{
  try {
        File file = new File("res/reviews/neg/cv000_29416.txt");
        HashMap<String, Boolean> featureVector =
        FileReaderUtil.getFeatureVector(file);
        assertTrue(featureVector.get("bad"));
        assertFalse(featureVector.get("boring"));
      } catch (IOException e) 
      {
        e.printStackTrace();
        assert (false);
      }
}
}
