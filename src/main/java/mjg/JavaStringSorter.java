package mjg;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class JavaStringSorter {

    // Java 8 lambda
    public List<String> sortStringsByLength(List<String> strings) {
        return strings.stream()
                      .sorted(Comparator.comparingInt(String::length))
                      .collect(Collectors.toList());
    }
}
