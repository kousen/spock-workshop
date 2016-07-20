package mjg;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaStringSorter {

    // Java 8 lambda
	public List<String> sortStringsByLength(List<String> strings) {
		strings.sort(Comparator.comparingInt(String::length));
        return strings;
	}
}
