package sd.softdeving.moneyExchange.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Map;

@Service
public class CurrencyRateService {

    private final RestTemplate restTemplate;
    private final String API_KEY = "cur_live_CK8Zd3LSGRlyx7r1smZypvEcL5XatjMNFowIhUHx";

    public CurrencyRateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public BigDecimal convert(String from, String to, BigDecimal amount) {
        String url = String.format(
                "https://api.currencyapi.com/v3/latest?apikey=%s&base_currency=%s&currencies=%s",
                API_KEY,
                from.toUpperCase(),
                to.toUpperCase()
        );

        try {
            ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
            Map body = response.getBody();

            System.out.println("Resposta da CurrencyAPI:");
            System.out.println(body);

            if (body != null && body.containsKey("data")) {
                Map<String, Map<String, Object>> data = (Map<String, Map<String, Object>>) body.get("data");
                Map<String, Object> currencyData = data.get(to.toUpperCase());
                BigDecimal rate = new BigDecimal(currencyData.get("value").toString());

                return amount.multiply(rate);
            } else {
                throw new RuntimeException("Erro ao obter taxa da CurrencyAPI: " + body);
            }

        } catch (Exception e) {
            throw new RuntimeException("Erro ao chamar a CurrencyAPI: " + e.getMessage(), e);
        }
    }
}
