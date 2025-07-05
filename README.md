# 💱 Money Exchange API – Spring Boot

A **simple RESTful API** built with **Spring Boot 3**, using `RestTemplate` to fetch real-time exchange rates and perform currency conversions between any two currencies.

---

## ✅ Features

- 🔁 Currency conversion between any two currencies (e.g., USD to MZN)
- 🌐 Consumes external API (CurrencyAPI) for real-time exchange rates
- 📦 Clean architecture (Controller, Service, Entity, Config)
- 🔐 CORS support for frontend integration
- ⚙️ Built with Java 21 and Spring Boot 3.5
- 🖥️ Web Interface included with HTML + JavaScript for quick testing

---

## 🧪 Example Response

```json
{
  "fromCurrency": "USD",
  "toCurrency": "MZN",
  "originalAmount": 2200,
  "convertedAmount": 139885.21443600,
  "conversionRate": 63.58418838
}
```

---

## 📦 Project Structure

```bash
moneyExchange/
├── src/
│   └── main/
│       ├── java/
│       │   └── sd/
│       │       └── softdeving/
│       │           └── moneyExchange/
│       │               ├── config/
│       │               │   ├── CorsConfig.java
│       │               │   └── RestTemplateConfig.java
│       │               ├── controller/
│       │               │   └── CurrencyRateController.java
│       │               ├── entity/
│       │               │   ├── ConversionResult.java
│       │               │   └── CurrencyRate.java
│       │               ├── service/
│       │               │   └── CurrencyRateService.java
│       │               └── MoneyExchangeApplication.java
│       └── resources/
│           └── application.properties
├── public/
│   └── index.html
├── pom.xml
```

---

## 🛠️ Technologies

- ✅ Java 21
- ✅ Spring Boot 3.5
- ✅ Spring Web
- ✅ RestTemplate
- ✅ Lombok
- ✅ Maven
- ✅ HTML + JS (for frontend)

---

## 🚀 Getting Started

### 🔧 Prerequisites

- Java 21+
- Maven 3.8+
- Internet connection (for API calls)
- API key from [CurrencyAPI.com](https://currencyapi.com)

---

### ▶️ Running the Backend

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/moneyExchange.git
   ```

2. Add your API key to `application.properties`:
   ```properties
   currency.api.key=YOUR_API_KEY
   ```

3. Start the application:
   ```bash
   ./mvnw spring-boot:run
   ```

---

### 🖥️ Running the Frontend

1. Go to the `public/` directory
2. Open `index.html` in your browser
3. Fill in the form and click "Convert"

---

## 🔐 CORS Configuration

The API is already configured with `CorsConfig.java` to allow browser-based requests:

```java
registry.addMapping("/api/**")
        .allowedOrigins("*")
        .allowedMethods("*");
```

---

## 📫 Author

**Gregório Nhantumbo**

- 🔗 [LinkedIn](https://www.linkedin.com/in/greg%C3%B3rio-nhantumbo-537a96282/)
- 🌍 Mozambique

---
