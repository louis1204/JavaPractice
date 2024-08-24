class Solution {
    public String fractionAddition(String expression) {
        // parse, when we hit a number, plus, or minus
        // parse the number and treat it as the numerator
        // When we hit the /, keep  track of the sign and parse the rest of the denominator
        // When we reach the end see if it is divisible starting at the numerator and going down
        List<int[]> fractions = new ArrayList<>();
        for (int i = 0; i < expression.length();) {
            char ch = expression.charAt(i);
            if (ch == '-') {
                i = parseNum(true, i + 1, expression, fractions);
            } else if (ch == '+') {
                i = parseNum(false, i + 1, expression, fractions);
            } else {
                i = parseNum(false, i, expression, fractions);
            }
        }
        int lcd = 1;
        for (int[] fract : fractions) {
            int denom = fract[1];
            if (lcd % denom == 0) {
                continue;
            } else {
                lcd *= denom;
            }
        }
        // update the numerators and accumulate
        int finalNum = 0;
        for (int[] fract : fractions) {
            fract[0] = fract[0] * (lcd / fract[1]);
            finalNum += fract[0];
        }
        // System.out.println("Before divisor: " + finalNum + "/" + lcd);
        // finally reduce the fraction by the smaller of lcd and final
        int divisor = Math.min((int)Math.abs(finalNum), (int)Math.abs(lcd));
        while (divisor > 0) {
            if (finalNum % divisor == 0 && lcd % divisor == 0) {
                finalNum /=  divisor;
                lcd /= divisor;
                break;
            }
            divisor--;
        }
        // System.out.println("Divisor: " + divisor);
        if (finalNum == 0) {
            lcd = 1;
        }
        String res = "";
        res += finalNum;
        res += "/";
        res += lcd;
        return res;
    }

    private int parseNum(boolean isNeg, int ind, String expression, List<int[]> fractions) {
        StringBuilder num = new StringBuilder();
        while (ind < expression.length() && expression.charAt(ind) - '0' <= 9 && expression.charAt(ind) - '0' >= 0) {
            num.append(expression.charAt(ind++));
        }
        ind++;
        StringBuilder denom = new StringBuilder();
        while (ind < expression.length() && expression.charAt(ind) - '0' <= 9 && expression.charAt(ind) - '0' >= 0) {
            denom.append(expression.charAt(ind++));
        }
        Integer top = Integer.parseInt(num.toString());
        Integer bottom = Integer.parseInt(denom.toString());
        if (isNeg) {
            top *= -1;
        }
        fractions.add(new int[] {top, bottom});
        return ind;
    }
}
