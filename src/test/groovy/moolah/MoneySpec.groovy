package moolah

import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class MoneySpec extends Specification {

    @Ignore("Removed the @Immutable in order to mock ExchangeRateService")
    def 'Money is immutable'() {
        given:
        Money money = new Money(amount: 5.0, currency: 'USD')

        when:
        money.amount = 10

        then:
        thrown(ReadOnlyPropertyException)
    }

    def 'plus with different currencies uses first currency with total'() {
        given:
        Money money1 = new Money(amount: 5.0, currency: 'USD')
        Money money2 = new Money(amount: 3.5, currency: 'EUR')

        when:
        Money money3 = money1 + money2

        then:
        money3.currency == money1.currency
        money3.amount > money1.amount
    }

    @Unroll
    def '#currency is #ok'() {
        expect:
        valid == ExchangeRateService.instance.isValid(currency)

        where:
        currency | valid | ok
        'USD'    | true  | 'valid'
        'XYZ'    | false | 'invalid'

//        String ok = valid ? 'valid' : 'invalid'
    }

    // @Unroll
    def "#currency is valid"() {
        expect:
        ExchangeRateService.instance.isValid(currency)

        where:
        currency << ExchangeRateService.instance.currencies
    }

    def 'plus works with mock service'() {
        given:
        Money money1 = new Money(amount: 5.0, currency: 'USD')
        Money money2 = new Money(amount: 3.5, currency: 'EUR')

        when:
        ExchangeRateService service = Mock(ExchangeRateService)
        service.getRate('USD','EUR') >> 2g

        money1.service = service

        Money money3 = money1 + money2

        then:
        money3.currency == money1.currency
        money3.amount == 5.0 + 3.5 * 2
    }

    def 'plus with same currencies gives sum'() {
        given:
        Money money1 = new Money(amount: 5.0, currency: 'USD')
        Money money2 = new Money(amount: 3.5, currency: 'USD')

        when:
        Money money3 = money1 + money2

        then:
        money3.amount == 8.5
        money3.currency == 'USD'
    }

    def 'minus with same currencies gives difference'() {
        given:
        Money money1 = new Money(amount: 5.0, currency: 'USD')
        Money money2 = new Money(amount: 3.5, currency: 'USD')

        when:
        Money money3 = money1 - money2

        then:
        money3.amount == 1.5
        money3.currency == 'USD'
    }

    def 'negative changes sign of amount'() {
        given:
        Money money = new Money(amount: 5.0, currency: 'USD')

        when:
        Money money1 = -money

        then:
        money1.amount == -money.amount
        money1.currency == money.currency
    }

}
