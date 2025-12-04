/**
 * The class containing your tests for the {@link Demo} class.  Make sure you
 * test all methods in this class (including both 
 * {@link Demo#main(String[])} and 
 * {@link Demo#isTriangle(double, double, double)}).
 */

import static org.junit.Assert.*;
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
     public void main_validTriangle_isTriangle() {
         String[] args = {};
         setIO("3\n4\n5\n");
         Demo.main(args);

         String expectedOutput = "Enter side 1: \n" +
                 "Enter side 2: \n" +
                 "Enter side 3: \n" +
                 "This is a triangle.\n";

         assertEquals(expectedOutput, output.toString());
     }

    @Test
    public void main_invalidTriangle_isNotTriangle() {
        String[] args = {};
        setIO("1\n2\n5\n");
        Demo.main(args);

        String expectedOutput = "Enter side 1: \n" +
                "Enter side 2: \n" +
                "Enter side 3: \n" +
                "This is not a triangle.\n";

        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void isTriangle_equilateral_returnTrue() {
         assertTrue(Demo.isTriangle(1, 1, 1));
    }

    @Test
    public void isTriangle_isosceles_returnTrue() {
        assertTrue(Demo.isTriangle(5, 5, 3));
    }

    @Test
    public void isTriangle_scalene_returnTrue() {
        assertTrue(Demo.isTriangle(5, 6, 7));
    }

    @Test
    public void isTriangle_scalenePermutation1_returnTrue() {
        assertTrue(Demo.isTriangle(9, 12, 15));
    }

    @Test
    public void isTriangle_scalenePermutation2_returnTrue() {
        assertTrue(Demo.isTriangle(15, 9, 12));
    }

    @Test
    public void isTriangle_scalenePermutation3_returnTrue() {
        assertTrue(Demo.isTriangle(12, 15, 9));
    }

    @Test
    public void isTriangle_sumEqualToThirdPermutation1_returnFalse() {
        assertFalse(Demo.isTriangle(5, 5, 10));
    }

    @Test
    public void isTriangle_sumEqualToThirdPermutation2_returnFalse() {
        assertFalse(Demo.isTriangle(5, 10, 5));
    }

    @Test
    public void isTriangle_sumEqualToThirdPermutation3_returnFalse() {
        assertFalse(Demo.isTriangle(10, 5, 5));
    }

    @Test
    public void isTriangle_sumLessThanThird_returnFalse() {
        assertFalse(Demo.isTriangle(5, 4, 10));
    }
    
    @Test
    public void isTriangle_sideEqualToZero_returnFalse() {
         assertFalse(Demo.isTriangle(0, 2, 1));
    }

    @Test
    public void isTriangle_hasNegativeSide_returnFalse() {
        assertFalse(Demo.isTriangle(-1, 1, 1));
    }
}
