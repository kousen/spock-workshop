package mjg

import spock.lang.FailsWith;
import spock.lang.Specification;

class StringSpec extends Specification {
    String llap = "Live Long and Prosper"
    
    def "LLaP has 21 characters"() {
        // check the size of the string
    }
    
    def "LLaP has 4 words"() {
        // check that there are four words using split(/\W/)
    }
    
    def "LLaP has 6 vowels"() {
        // check that there are 6 vowels using findAll(/[aeiou]/)
    }
	
    def "Access inside the string doesn't throw an exception"() {
        when:
        // access characters using a range from 0 to -1
        // access characters using a range from -1 to 0
        true

        then:
        // check that an IndexOutOfBoundsException is NOT thrown
        true // remove this line when you add your test
    }

	@FailsWith(NullPointerException)
    def "Access inside null string throws exception"() {
        given:
        llap = null
        
        expect:
        llap[0]
    }

	def "Access beyond the end of the string throws exception"() {
		when:
        // access the string beyond the end
        true

		then:
        // check that an IndexOutOfBoundsException IS thrown
        // the message of the exception should be 'String index out of range: xx'
        //   for whatever index you used
        true // remove this line when you add your test
	}

}
