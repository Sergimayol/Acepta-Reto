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

}
