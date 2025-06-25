package sd.softdeving.moneyExchange.entity;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRate {
    private String currencyRate;
    private LocalDate date;
    private BigDecimal rate;
}
