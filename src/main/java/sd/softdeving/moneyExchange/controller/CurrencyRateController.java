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
        BigDecimal converted = service.convert(from, to, amount);
        ConversionResult result = new ConversionResult(from, to, amount, converted);
        return ResponseEntity.ok(result);
    }
}

