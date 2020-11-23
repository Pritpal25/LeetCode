package DailyChallenge.November2020;

import java.util.HashSet;
import java.util.Set;

public class Nov22_UniqueMorseCode
{
    public int uniqueMorseRepresentations(String[] words) {
        String[] dict = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        Set<String> result = new HashSet<>();

        for(String word : words) {
            StringBuilder str = new StringBuilder();

            char[] wordArr = word.toCharArray();

            for(char c : wordArr) {
                str.append(dict[c-'a']);
            }

            result.add(str.toString());
        }

        return result.size();
    }
}
