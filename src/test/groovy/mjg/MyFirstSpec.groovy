package mjg

import spock.lang.Specification
import spock.lang.Unroll

class MyFirstSpec extends Specification {

	@Unroll
	def 'max of #first and #second is #result'() {
		expect:
		result == Math.max(first, second)

		where:
		[result, first, second]<< [
			[2, 1, 2],
			[7, 3, 7],
			[5, 5, 5]
		]
	}

	@Unroll
	def 'max (alt) of #first and #second is #result'(Integer result,
			Integer first,
			Integer second) {
		expect:
		result == Math.max(first, second)

		where:
		result << [2, 7, 5]
		first  << [1, 3, 5]
		second << [2, 7, 5]
	}

	@Unroll
	def 'max (data table) of #first and #second is #result'() {
		expect:
		result == Math.max(first, second)

		where:
		first | second || result
		2     | 1      || 2
		7     | 3      || 7
		5     | 5      || 5
	}


	def "max of 1 and 2 should be 2"() {
		expect:
		Math.max(1, 2) == 2
	}

	// Add a similar test for Math.min
	void 'min of two numbers'() {
		expect:
		Math.min(1, 2) == 1
	}

	// Add a test for Math.abs
	def 'using abs'() {
		expect:
		Math.abs(-3) == 3
		(-3).abs() == 3
	}

	def 'Math.floor returns biggest double less than arg'() {
		expect:
		Math.floor(Math.PI) == 3
	}
}
