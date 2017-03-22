package kata;

import org.fest.assertions.api.Assertions;
import org.junit.Test;

public class LcdTest {

    private static final String NL = "\n";

    @Test
    public void for_one() {
        Lcd lcd = new Lcd();
        String result = lcd.getDisplayString(1);
        Assertions.assertThat(result).isEqualTo(
                "   \n" +
                "  |\n" +
                "  |\n");
    }

    @Test
    public void for_7() {
        Lcd lcd = new Lcd();
        String result = lcd.getDisplayString(7);
        Assertions.assertThat(result).isEqualTo(
                " _ " + NL +
                "  |" + NL +
                "  |" + NL);
    }

    @Test
    public void for_22() {
        Lcd lcd = new Lcd();
        String result = lcd.getDisplayString(22);
        Assertions.assertThat(result).isEqualTo(
                " _ " + " _ " + NL +
                " _|" + " _|" + NL +
                "|_ " + "|_ " + NL);
    }

    @Test
    public void for_77() {
        Lcd lcd = new Lcd();
        String result = lcd.getDisplayString(77);
        Assertions.assertThat(result).isEqualTo(
                " _ " + " _ " + NL +
                "  |" + "  |" + NL +
                "  |" + "  |" + NL);
    }

    @Test
    public void for_172() {
        Lcd lcd = new Lcd();
        String result = lcd.getDisplayString(172);
        Assertions.assertThat(result).isEqualTo(
                "    _  _ " + NL +
                "  |  | _|" + NL +
                "  |  ||_ " + NL);
    }

}
