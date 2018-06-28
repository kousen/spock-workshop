package safari

import spock.lang.Specification

class FirstDemo extends Specification {

    List<String> lights = ['one', 'two', 'three', 'four']

    def 'there are four lights'() {
        expect:
        lights.size() == 4
        lights.class == ArrayList
    }
}
