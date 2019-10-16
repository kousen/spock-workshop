package moolah

import groovy.json.JsonSlurper

class ExchangeRateService {
    private final static String URL =
            'https://openexchangerates.org/api/latest.json?' +
                    'app_id=df12e49e55a34cf0927f592c2a36f8b0'
    private final static ExchangeRateService instance = new ExchangeRateService()

    Map<String, BigDecimal> rates = [:]

    private ExchangeRateService() {
        rates = new JsonSlurper().parse(URL.toURL()).rates
    }

    static ExchangeRateService getInstance() {
        instance
    }

    Set<String> getCurrencies() {
        rates.keySet()
    }

    boolean isValid(String currency) {
        currency in currencies
    }

    BigDecimal getRate(String from, String to) {
        return rates[to] / rates[from]
    }
}
