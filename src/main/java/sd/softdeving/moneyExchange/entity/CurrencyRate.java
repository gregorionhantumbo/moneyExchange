package sd.softdeving.moneyExchange.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRate {
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal rate;
}