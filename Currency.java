package models.enums;

/*
Explanation:
- We need to define a currency enum.
- currencies in out app are some constants that we need to define them in our code once and use them in our code.
- each currency has some data, put them here and use some methods to work with currencies so simply.
 */

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Currency {
    GalacticCoin("GTC"),
    StarDollar("SUD"),
    QuantumNote("QTR");

    private final String pattern;

    Currency(String pattern) {
        this.pattern = pattern;
    }

    public Matcher getMatcher(String input) {
        Matcher matcher = Pattern.compile(this.pattern).matcher(input);
        if (matcher.matches())
            return matcher;
        else
            return null;
    }
}
