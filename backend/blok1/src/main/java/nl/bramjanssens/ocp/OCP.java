package nl.bramjanssens.ocp;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Slf4j
public class OCP {

    public static void main(String[] args) {
        List<Character> ratings = Arrays.asList('U', 'R', 'A', 'A');

        List<Character> result = ratings.stream()
                .filter(c -> c == 'A' || c == 'U')  //1
                .map(c -> c == 'A' ? 'R' : c) // 3
                .collect(toList());

        System.out.println(result);
        // .forEach(System.out::println);

        List<Character> resultsToo = new ArrayList<>();
        for (char c : ratings) {
            if (c == 'A' || c == 'U') {
                resultsToo.add(c == 'A' ? 'R' : c);
            }
        }
        System.out.println(resultsToo);
    }
}
