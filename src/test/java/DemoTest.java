/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class DemoTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

     private void setIO(String input) {
         output.reset();
         System.setIn(new ByteArrayInputStream(input.getBytes()));
         System.setOut(new PrintStream(output));
     }

     @Test
     public void test() {
         String[] args = {};
         setIO("3\n4\n5\n");
         Demo.main(args);

         String expectedOutput = "Enter side 1: \n" +
                 "Enter side 2: \n" +
                 "Enter side 3: \n" +
                 "This is a triangle.\n";

         assertEquals(expectedOutput, output.toString());
     }
}
