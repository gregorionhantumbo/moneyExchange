package sd.softdeving.moneyExchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.softdeving.moneyExchange.entity.CurrencyRate;
import sd.softdeving.moneyExchange.repository.CurrencyRateRepository;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CurrencyRateService {

    @Autowired
    private CurrencyRateRepository repository;

    public List<CurrencyRate> findByCurrency(String code) {
        return repository.findAll().stream()
                .filter(rate -> rate.getCurrencyRate().equalsIgnoreCase(code))
                .collect(Collectors.toList());
    }

    public Optional<CurrencyRate> findHighestRate(String code) {
        return repository.findAll().stream()
                .filter(rate -> rate.getCurrencyRate().equalsIgnoreCase(code))
                .max(Comparator.comparing(CurrencyRate::getRate));
    }

    public BigDecimal averageRate(String code) {
        return repository.findAll().stream()
                .filter(rate -> rate.getCurrencyRate().equalsIgnoreCase(code))
                .map(CurrencyRate::getRate)
                .mapToDouble(BigDecimal::doubleValue)
                .average()
                .stream()
                .mapToObj(BigDecimal::valueOf)
                .findFirst()
                .orElse(BigDecimal.ZERO);
    }
}

