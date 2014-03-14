package mjg

import spock.lang.Specification
import spock.lang.Unroll;

class UtilityMethodsSpec extends Specification {
	UtilityMethods um = new JavaUtilityMethods()
	
	def "getPositives should return 1, 2, 3"() {
		expect:
		[1, 2, 3] == um.getPositives(-3..3 as int[])
		[1, 2, 3] == um.getPositives(-3, 1, -4, 2, 3)
	}
	
	@Unroll
	def '#x is prime'() {
		expect:
		um.isPrime(x)
		
		where:
		x << [2, 3, 5, 7, 11, 13]
	}
	
	def '2, 3, 5, 7, 11, 13 are prime'() {
		given: 'a set of prime numbers'
		def primes = [2, 3, 5, 7, 11, 13]
		
		expect: 'all of them are prime'
		primes.every { um.isPrime(it) }
	}
	
	def 'negative arg to isPrime throws IAE'() {
		when:
		um.isPrime(-3)
		
		then:
		IllegalArgumentException e = thrown()
		"argument must be > 0" == e.message
	}
}
