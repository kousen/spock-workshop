package mjg

import groovy.transform.TypeChecked
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class ArrayListSpec extends Specification {
    List<Number> nums = [3, 1, 4, 1, 5, 9, 2, 6, 5]
    
    def 'size method returns number of elements'() {
        expect:
        nums.size() == 9
    }

    def 'default type of list is ArrayList'() {
        expect:
        nums.class == ArrayList
    }

    @Unroll
    void 'element at index #i is #value'() {
        expect:
        nums[i] == value

        where:
        // [i, value] << [[0, 3], [1, 1], [2, 4]]
        i << (0..8)
        value << [3, 1, 4, 1, 5, 9, 2, 6, 5]
    }

    void 'plus method creates a new list'() {
        when:
        List numbers = nums + [3, 5]

        then:
        numbers.size() == nums.size() + 2
        nums == old(nums)
    }

    void 'left-shift does modify the original list'() {
        when:
        nums << 3

        then:
        nums.size() == old(nums.size()) + 1
        nums == [3, 1, 4, 1, 5, 9, 2, 6, 5, 3]
    }

    void 'index beyond the end of the list does not throw exception'() {
        when:
        def val = nums[999]

        then:
        noExceptionThrown()
        val == null
        !val
    }

    // @TypeChecked
    void 'can add a string to a list of integer'() {
        given:
        List<Integer> nums = [3, 1, 4, 1, 5, 9]

        when:
        nums << 'abc'

        then:
        noExceptionThrown()
        nums[-1] == 'abc'
    }
}
