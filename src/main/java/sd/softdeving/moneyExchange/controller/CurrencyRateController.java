package sd.softdeving.moneyExchange.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sd.softdeving.moneyExchange.entity.CurrencyRate;
import sd.softdeving.moneyExchange.service.CurrencyRateService;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/currency")
public class CurrencyRateController {

    @Autowired
    private CurrencyRateService service;

    @GetMapping("/{code}")
    public List<CurrencyRate> getRates(@PathVariable String code) {
        return service.findByCurrency(code);
    }

    @GetMapping("/{code}/max")
    public ResponseEntity<CurrencyRate> getMaxRate(@PathVariable String code) {
        return service.findHighestRate(code)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{code}/avg")
    public BigDecimal getAverageRate(@PathVariable String code) {
        return service.averageRate(code);
    }
}
