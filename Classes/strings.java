package Classes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class strings {

    static boolean isPalindrome(long a) {
        String s = Long.toString(a);
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        return s.equals(rev.toString());
    }

    static boolean isPalindrome(int number) {
        List<Integer> digits = new ArrayList<>();
        while (number > 0) {
            digits.add(number % 10);
            number /= 10;
        }
        return IntStream.range(0, digits.size() / 2)
                .allMatch(index -> digits.get(index) == digits.get(digits.size() - 1 - index));
    }

    static boolean isPalindrome(String s) {
        StringBuilder rev = new StringBuilder(s);
        rev.reverse();
        return s.equals(rev.toString());
    }

    static boolean isPalindrome(String s, int start, int end) {
        StringBuilder rev = new StringBuilder(s.substring(start, end));
        rev.reverse();
        return s.substring(start, end).equals(rev.toString());
    }

    static boolean isSentencePalindrome(String str) {
        int l = 0;
        int h = str.length() - 1;

        // Lowercase string
        str = str.toLowerCase();

        // Compares character until they are equal
        while (l <= h) {

            char getAtl = str.charAt(l);
            char getAth = str.charAt(h);

            // If there is another symbol in left
            // of sentence
            if (!(getAtl >= 'a' && getAtl <= 'z'))
                l++;

            // If there is another symbol in right
            // of sentence
            else if (!(getAth >= 'a' && getAth <= 'z'))
                h--;

            // If characters are equal
            else if (getAtl == getAth) {
                l++;
                h--;
            }
            // If characters are not equal then
            // sentence is not palindrome
            else
                return false;
        }
        // Returns true if sentence is palindrome
        return true;
    }

    static boolean isSentPalindrome(String s) {
        if (s.isEmpty()) // if String s is empty return true
            return true;

        String str = s.toLowerCase();// convert the whole string into lower case alphabet

        // remove non-alphanumeric characters
        // replace the given string with empty string except the pattern [^a-zA-Z0-9]
        str = str.replaceAll("[^a-zA-Z0-9]", "");

        // The reverse() method of StringBuilder is used to reverse the characters in
        // the StringBuilder.
        StringBuilder revstr = new StringBuilder(str);
        revstr.reverse();
        String rstr = revstr.toString();

        if (str.equals(rstr))// if string and reversed string both are equal return true
            return true;

        return false; // else return false

    }

}
