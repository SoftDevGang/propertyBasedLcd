package kata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.fest.assertions.api.Assertions;
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
    public void allDigitsHaveThreeLines(@From(AnyPositiveInteger.class) Integer arg) {
        String displayString = new Lcd().getDisplayString(arg);
        String[] lines = displayString.split(Lcd.NL);
        Assertions.assertThat(lines.length).isEqualTo(3);
    }


}
