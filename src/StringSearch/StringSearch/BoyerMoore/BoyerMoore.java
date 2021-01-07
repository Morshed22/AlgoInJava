package BoyerMoore;

import java.util.HashMap;
import java.util.Map;

public class BoyerMoore {
    private Map<Character, Integer> misMatchTable;
    private String text;
    private String pattern;

    public BoyerMoore(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.misMatchTable = new HashMap<>();
    }
    public void preCompute(){
        int lenOfPattern = this.pattern.length();
        for(int index = 0; index < lenOfPattern; index++){
            char c = this.pattern.charAt(index);
            int maxShift = Math.max(1, lenOfPattern-index-1);
            this.misMatchTable.put(c, maxShift);
        }
    }
    public int search(){
        int lengthOfPattern = this.pattern.length();
        int lengthOfText = this.text.length();
        int numOfSkips;

        for (int i = 0; i <= lengthOfText - lengthOfPattern; i += numOfSkips) {

            numOfSkips = 0;

            for (int j = lengthOfPattern - 1; j >= 0; j--) {
                if (pattern.charAt(j) != text.charAt(i + j)) {

                    if ( this.misMatchTable.get(text.charAt(i+j)) != null ) {
                        numOfSkips = this.misMatchTable.get(text.charAt(i+j));
                       // System.out.println(numOfSkips);
                        break;
                    } else {
                        numOfSkips = lengthOfPattern;
                       // System.out.println(numOfSkips);
                        break;
                    }
                }
            }

            if (numOfSkips == 0) return i;
        }

        return lengthOfText;
    }

}
