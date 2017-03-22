package kata;

import com.pholser.junit.quickcheck.From;
import com.pholser.junit.quickcheck.Property;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.runner.JUnitQuickcheck;
import org.junit.runner.RunWith;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.junit.Assume.assumeTrue;

@RunWith(JUnitQuickcheck.class)
public class LcdPropertyTest {
    private final Lcd lcd = new Lcd();

    // Properties

    //* formatting
    // first and third column only contains pipes or blank
    // middle column only underscore or blank
    // length of line is string length * 3 + nl
    // all lines have the same length
    // only three lines

    //* layout
    // any number not (1,4) have underscores on top middle column
    // any number not (1,4,7,9) have underscores on top bottom column
    // any number not 2 have pipe on lower right
    // etc for all places have it / don't have it

    @Property
    public void all_lcd_displays_have_three_lines(@InRange(minInt = 0) Integer theNumber) {
        String[] lines = lcdDisplayLines(theNumber);

        assertThat(lines.length).isEqualTo(3);
    }

    @Property(maxShrinkDepth = 500, maxShrinks = 500)
    public void lcd_displays_without_one_or_four_have_underscore_in_top_middle_column(@InRange(minInt = 0) int theNumber) {
        assumeTrue(doesNotContain(theNumber, "1", "4"));

        String[] lines = lcdDisplayLines(theNumber);
        String firstLine = lines[0];

        assertThat(firstLine).matches("( _ )+");
    }

    @Property(trials = 1000, maxShrinkDepth = 500, maxShrinks = 500) // One thousand to find enough examples values
    public void lcd_displays_without_1_4_7_9_have_underscore_in_bottom_middle_column(@InRange(minInt = 0) int theNumber) {
        assumeTrue(doesNotContain(theNumber, "1", "4", "7", "9"));

        String[] lines = lcdDisplayLines(theNumber);
        String bottomLine = lines[2];

        assertThat(bottomLine).matches("(._.)+");
    }

    @Property(maxShrinkDepth = 500, maxShrinks = 500)
    public void lcd_displays_without_2_have_pipe_in_lower_right_column(@InRange(minInt = 0) int theNumber) {
        assumeTrue(doesNotContain(theNumber, "2"));

        String[] lines = lcdDisplayLines(theNumber);
        String bottomLine = lines[2];

        assertThat(bottomLine).matches("(..\\|)+");
    }

    @Property()
    public void lcd_displays_with_2_have_blank_in_lower_right_column(@From(OnlyTwosGenerator.class) int theNumber) {
        String[] lines = lcdDisplayLines(theNumber);
        String bottomLine = lines[2];

        assertThat(bottomLine).matches("(.. )+");
    }

    private String[] lcdDisplayLines(int theNumber) {
        String displayString = lcd.getDisplayString(theNumber);
        return displayString.split(Lcd.NL);
    }

    private boolean doesNotContain(int arg, String... illegal) {
        for (String digit : illegal) {
            if (String.valueOf(arg).contains(digit)) {
                return false;
            }
        }

        return true;
    }

    /*
    We conclude that we need 14 property based tests for verifying that every combination
    of the layout is correct using a property based tests.

    It would be sufficient with 10 example based tests to verify that every combination
    of the layout is correct.
     */
}
