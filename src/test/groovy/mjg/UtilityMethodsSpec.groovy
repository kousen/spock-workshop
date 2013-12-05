package mjg

import spock.lang.Specification

class UtilityMethodsSpec extends Specification {
	UtilityMethods um = new JavaUtilityMethods()
	
	def "getPositives should return 1, 2, 3"() {
		expect:
		[1, 2, 3] == um.getPositives(-3..3 as int[])
	}
}
