package kata;

import static org.fest.assertions.api.Assertions.assertThat;

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
        		"  |\n" );

    }
    @Test
    public void for_7() {
        Lcd lcd = new Lcd();
        String result = lcd.getDisplayString(7);
        Assertions.assertThat(result).isEqualTo(
            " _ " + NL +
            "  |" + NL +
            "  |" + NL );
    }

    @Test
    public void for_2() {
        Lcd lcd = new Lcd();
        String result = lcd.getDisplayString(22);
        Assertions.assertThat(result).isEqualTo(
            " _ " + " _ " + NL +
            " _|" + " _|" + NL +
            "|_ " + "|_ " + NL );
    }

    @Test
    public void for_77() {
        Lcd lcd = new Lcd();
        String result = lcd.getDisplayString(77);
        Assertions.assertThat(result).isEqualTo(
            " _ " + " _ " + NL +
            "  |" + "  |" + NL +
            "  |" + "  |" + NL );
    }

    @Test
    public void for_172() {
        Lcd lcd = new Lcd();
        String result = lcd.getDisplayString(172);
        Assertions.assertThat(result).isEqualTo(
            "   " + " _ " + " _ " + NL +
            "  |" + "  |" + " _|" + NL +
            "  |" + "  |" + "|_ " + NL );
        System.out.println(result);
    }

    @Test public void
        div() throws Exception {
        assertThat(21 / 2).isEqualTo(10);
        assertThat(21 % 10).isEqualTo(1);
        assertThat(572 % 10).isEqualTo(2);
        assertThat(572 / 10).isEqualTo(57);
        assertThat(572 / 100).isEqualTo(5);
        assertThat(572 % 100).isEqualTo(72);
        assertThat(Math.floor(Math.log10(12345))).isEqualTo(4);
        assertThat(String.valueOf(12345).length()).isEqualTo(5);
        assertThat(Math.pow(10,3)).isEqualTo(1000);
    }

}
