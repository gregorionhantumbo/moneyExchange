package sd.softdeving.moneyExchange.repository;

import org.springframework.stereotype.Component;
import sd.softdeving.moneyExchange.entity.CurrencyRate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class CurrencyRateRepository {
    private final List<CurrencyRate> rates = List.of(
            new CurrencyRate("USD", LocalDate.of(2024, 6, 1), new BigDecimal("63.2")),
            new CurrencyRate("EUR", LocalDate.of(2024, 6, 1), new BigDecimal("68.5")),
            new CurrencyRate("USD", LocalDate.of(2024, 6, 2), new BigDecimal("64.0")),
            new CurrencyRate("EUR", LocalDate.of(2024, 6, 2), new BigDecimal("69.1"))
    );

    public List<CurrencyRate> findAll() {
        return rates;
    }
}
