package mjg.tos

import mjg.tng.Klingon;
import spock.lang.Specification

class TribbleSpec extends Specification {
    Tribble tribble = new Tribble()

    def "feed a tribble, get more tribbles"() {
        when:
        def result = tribble.feed()

        then:
        result.size() == 11
        result.every {
            it instanceof Tribble
        }
    }

    def "reacts well to Vulcans"() {
        given:
        Vulcan spock = Mock()
        
        when:
        String reaction = tribble.react(spock)

        then:
        reaction == "purr, purr"
        1 * spock.soothe()
    }

    def "reacts badly to Klingons"() {
        setup:
        Klingon koloth = Mock()
        
        when:
        String reaction = tribble.react(koloth)

        then:
        1 * koloth.annoy() >> {
            throw new Exception()
        }
        0 * koloth.howlAtDeath()
        0 * _
        reaction == null
        thrown(Exception)
    }

    // Note: Spock mock tests are in
    // spock-specs/src/test/groovy/org/spockframework/smoke/mock directory
    def 'spy on vulcan using constructor'() {
        given:
        def spy = Spy(TrekVulcan)

        when:
        String reaction = tribble.react(spy)


        then:
        1 * spy.soothe()
        reaction == "purr, purr"
    }

    def 'spy on vulcan using object instantiated in method'() {
        given:
        def spy = Spy(new TrekVulcan())

        when:
        String reaction = tribble.react(spy)


        then:
        1 * spy.soothe()
        reaction == "purr, purr"
    }

    def 'spy on vulcan using existing object'() {
        given:
        def spock = new TrekVulcan()
        def spy = Spy(spock)

        when:
        String reaction = tribble.react(spy)


        then:
        1 * spy.soothe()
        reaction == "purr, purr"
    }

    def "global spy passes through to static method"() {
        given:
        GroovySpy(TrekVulcan, global: true)

        when:
        String reaction =  TrekVulcan.defaultReaction()

        then:
        1 * TrekVulcan.defaultReaction()
        reaction == 'raises eyebrow'
    }

    def "global spy can mock static method"() {
        given:
        GroovySpy(TrekVulcan, global: true)

        when:
        String reaction =  TrekVulcan.defaultReaction()

        then:
        1 * TrekVulcan.defaultReaction() >> "Dude, where's my car?"
        reaction == "Dude, where's my car?"
    }

    def "number of tribbles in storage compartment"() {
        given: "average litter of 10"
		// ... implementation ...
        and: "new generation every 12 hours over a period of three days"
        // ... implementation ...
        when: "tribbles get into storage compartments full of quadrotriticale"
        // invoke method
        then: "compute number of tribbles"
	    // numTribbles == 1771561
    }	
}
