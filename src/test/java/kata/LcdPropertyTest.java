package kata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.java.lang.IntegerGenerator;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.fest.assertions.api.Assertions;
import org.junit.Assume;
import org.junit.runner.RunWith;

/**
 * Created by johan on 16/03/17.
 */
@RunWith(JUnitQuickcheck.class)
public class LcdPropertyTest {

    //* formatting
    // first and third column only contains pipes or blank

    // middle column only underscore or blank

    // lenght of line is string length * 3 + nl

    // all lines have the same length

    // only three lines

    //* layout
    // any number not (1,4) have underscores on top middle column

    // any number not (1,4,7,9) have underscores on top bottom column

    // any number not 2 have pipe on lower right
    // etc for all places have it / don't have it

    @Property
    public void allDigitsHaveThreeLines( @InRange(min = "0") Integer arg) {
        String displayString = new Lcd().getDisplayString(arg);
        String[] lines = displayString.split(Lcd.NL);
        Assertions.assertThat(lines.length).isEqualTo(3);/**/
    }

    @Property(maxShrinkDepth = 500, maxShrinks = 500)
    public void oneAndFourDontHaveUnderscoreOnTopMiddleColumnBuiltIn(@InRange(minInt = 0) int arg) {
        Assume.assumeTrue(doesNotContain1nor4(arg));
        String displayString = new Lcd().getDisplayString(arg);
        String[] lines = displayString.split(Lcd.NL);
        String firstLine = lines[0];
        Assertions.assertThat(firstLine).matches("( _ )+");
    }

    private boolean doesNotContain1nor4(int arg) {
        return !String.valueOf(arg).contains("1") && !String.valueOf(arg).contains("4");
    }


    @Property()
    public void whatever(@From(AnyPositiveInteger.class) Integer arg) {
    }
}
