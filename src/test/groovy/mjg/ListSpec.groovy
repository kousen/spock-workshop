package mjg

import spock.lang.Specification

class ListSpec extends Specification {
	List nums = [3, 1, 4, 1, 5, 9]
	
	def 'there should be six numbers'() {
		expect: 6 == nums.size()
	}
	
	def 'add element increases size by one'() {
		when:
		nums << 2
		
		then:
		nums.size() == old(nums.size()) + 1
	}
}
