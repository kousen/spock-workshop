package moolah

import spock.lang.Specification

class ExchangeRateServiceSpec extends Specification {
    ExchangeRateService service = ExchangeRateService.instance

    def "USD to USD should be 1"() {
        expect:
        service.getRate('USD', 'USD') == 1.0
    }

    def "USD to INR should be at least 50"() {
        expect:
        service.getRate('USD', 'INR') > 50
    }

    def "INR to USD should be less than 1/50"() {
        expect:
        service.getRate('INR', 'USD') < 1/50
    }

    def 'JPY to EUR should be about '() {
        expect:
        service.getRate('JPY', 'EUR') < 0.01
    }
}
