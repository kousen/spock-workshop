package moolah

import groovy.transform.Immutable

//@Immutable
class Money {
    BigDecimal amount
    String currency
    ExchangeRateService service = ExchangeRateService.instance

    Money plus(Money other) {
        BigDecimal newAmount = this.amount +
                other.amount * service.getRate(this.currency, other.currency)
        new Money(amount: newAmount, currency: this.currency)
    }

    Money minus(Money other) {
        plus(new Money(amount: -other.amount, currency: other.currency))
    }

    Money negative() {
        return new Money(amount: -this.amount, currency: this.currency)
    }
}
