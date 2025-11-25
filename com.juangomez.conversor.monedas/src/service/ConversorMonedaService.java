package service;

public class ConversorMonedaService {
    public ExchageRateResponse getExchangeRate(String baseCurrency, String targetCurrency){
        ExchangeRateResponse response = gson.fromJson(json, ExchangeRateResponse.class);
    }

}
