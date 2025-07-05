package sd.softdeving.moneyExchange.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class CurrencyRateService {

    private final RestTemplate restTemplate;

    @Value("${currency_api_key}")
    private String API_KEY;

    public CurrencyRateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    // Método para buscar a taxa de conversão
    public BigDecimal getConversionRate(String from, String to) {
        String url = String.format(
                "https://api.currencyapi.com/v3/latest?apikey=%s&base_currency=%s&currencies=%s",
                API_KEY,
                from.toUpperCase(),
                to.toUpperCase()
        );

        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            Map body = response.getBody();

            if (body != null && body.containsKey("data")) {
                Map<String, Map<String, Object>> data = (Map<String, Map<String, Object>>) body.get("data");
                Map<String, Object> currencyData = data.get(to.toUpperCase());
                BigDecimal rate = new BigDecimal(currencyData.get("value").toString());

                return rate;
            } else {
                throw new RuntimeException("Erro ao obter taxa da CurrencyAPI: " + body);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao chamar a CurrencyAPI: " + e.getMessage(), e);
        }
    }

    // Método para converter o valor
    public BigDecimal convert(String from, String to, BigDecimal amount) {
        BigDecimal rate = getConversionRate(from, to);
        return amount.multiply(rate);
    }
}
