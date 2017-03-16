package kata;

import java.util.*;
import java.util.stream.Collectors;

import static kata.LineNumber.One;
import static kata.LineNumber.Three;
import static kata.LineNumber.Two;

public class Lcd {

    @SuppressWarnings("serial")
    private Map<Character, Digit> possibleDigits = new HashMap<Character, Digit>() {{
        put('0', new Digit(" _ ", "  |", "  |"));
        put('1', new Digit("   ", "  |", "  |"));
        put('2', new Digit(" _ ", " _|", "|_ "));
        put('3', new Digit(" _ ", "  |", "  |"));
        put('4', new Digit(" _ ", "  |", "  |"));
        put('5', new Digit(" _ ", "  |", "  |"));
        put('6', new Digit(" _ ", "  |", "  |"));
        put('7', new Digit(" _ ", "  |", "  |"));
        put('8', new Digit(" _ ", "  |", "  |"));
        put('9', new Digit(" _ ", "  |", "  |"));
    }};

    public static final String NL = "\n";

    /**
     * Accept only an integer, so we're sure that from here we have only valid input
     */
    public String getDisplayString(int number) {
        List<Digit> digits = getDigits(number);
        return getDisplayString(digits);
    }

    /**
     * switch to domain objects (instead of primitives ASAP
     */
    private List<Digit> getDigits(int number) {
        char[] inputChars = String.valueOf(number).toCharArray();
        List<Digit> digits = new ArrayList<>();
        for (char charDigit : inputChars) {
            digits.add(possibleDigits.get(charDigit));
        }
        return digits;
    }

    private String getDisplayString(List<Digit> digits) {
        return getDisplayLine(digits, One)
                + getDisplayLine(digits, Two)
                + getDisplayLine(digits, Three);

    }

    private String getDisplayLine(List<Digit> digits, LineNumber currentLine) {
        return digits.stream()
                .map(digit -> digit.forLine(currentLine))
                .collect(Collectors.joining())
                + NL;

    }


}
