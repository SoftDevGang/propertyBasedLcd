package kata;

import java.util.HashMap;
import java.util.Map;

class Digit {
    private Map<LineNumber, String> lines;

    /**
     * Enumerating lines instead of accepting an array/list
     * ensures we have three and only three lines
     */
    public Digit(final String firstLine, final String secondLine, final String thirdLine) {

        this.lines = new HashMap<LineNumber, String>() {{
            put(LineNumber.One, firstLine);
            put(LineNumber.Two, secondLine);
            put(LineNumber.Three, thirdLine);
        }};
    }

    public String forLine(LineNumber lineNumber) {
        return lines.get(lineNumber);
    }

}
