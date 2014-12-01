package mjg;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class JavaStringSorter {

    // Java 8 lambda
	public List<String> sortStringsByLength(List<String> strings) {
		strings.sort((s1, s2) -> {
            int diff = s1.length() - s2.length();
            return (diff < 0 ? -1 : (diff == 0 ? 0 : 1));
        });
        return strings;
	}

    // Java 7 and below anonymous inner class
//    public List<String> sortStringsByLength(List<String> strings) {
//        Collections.sort(strings, new Comparator<String>() {
//            @Override
//            public int compare(String s1, String s2) {
//                int diff = s1.length() - s2.length();
//                return (diff < 0 ? -1 : (diff == 0 ? 0 : 1));
//            }
//        });
//        return strings;
//    }
}
