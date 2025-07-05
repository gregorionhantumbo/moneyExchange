package sd.softdeving.moneyExchange.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sd.softdeving.moneyExchange.entity.ConversionResult;
import sd.softdeving.moneyExchange.service.CurrencyRateService;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/exchange")
public class CurrencyRateController {

    private final CurrencyRateService service;

    public CurrencyRateController(CurrencyRateService service) {
        this.service = service;
    }

    @GetMapping("/convert")
    public ResponseEntity<ConversionResult> convert(@RequestParam String from,
                                                    @RequestParam String to,
                                                    @RequestParam BigDecimal amount) {
        BigDecimal conversionRate = service.getConversionRate(from, to);
        BigDecimal convertedAmount = amount.multiply(conversionRate);

        ConversionResult result = new ConversionResult(
                from.toUpperCase(),
                to.toUpperCase(),
                amount,
                convertedAmount,
                conversionRate
        );

        return ResponseEntity.ok(result);
    }
}
