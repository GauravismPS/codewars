package sapient.codewars.solution;

import java.util.*;

class Crypto {

    // public static void main(String[] args) {
    // String value = new String("Hippopotomonstrosesquippedaliophobia");
    // System.out.println(wordPattern("hello"));
    // System.out.println(wordPattern(value));
    // }

    public static String wordPattern(final String word) {
        // Your code here!
        String ans = new String();
        Character ch;
        String sz;
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.clear();
        for (int i = 0; i < word.length(); i++) {
            ch = word.charAt(i);
            if (Character.isUpperCase(ch))
                ch = Character.toLowerCase(ch);
            if (map.containsKey(ch)) {
                ans += map.get(ch);
            } else {
                sz = Integer.toString(map.size());
                map.put(ch, sz);
                ans += sz;
            }
            if (i < word.length() - 1) {
                ans += ".";
            }
            // System.out.println(map);
        }
        // System.out.println(map);
        return ans;
    }
}
