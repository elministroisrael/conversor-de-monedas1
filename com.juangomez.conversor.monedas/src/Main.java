import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {
        String json = "{\"result\":\"success\",\"documentation\":\"https://www.exchangerate-api.com/docs\",\"terms_of_use\":\"https://www.exchangerate-api.com/terms\",\"time_last_update_unix\":1763942401,\"time_last_update_utc\":\"Mon, 24 Nov 2025 00:00:01 +0000\",\"time_next_update_unix\":1764028801,\"time_next_update_utc\":\"Tue, 25 Nov 2025 00:00:01 +0000\",\"base_code\":\"CAD\",\"target_code\":\"DOP\",\"conversion_rate\":44.9289}";

        Gson gson = new Gson();
        ExchangeRateResponse response = gson.fromJson(json, ExchangeRateResponse.class);

        System.out.println("Resultado: " + response.getResult());
        System.out.println("Base: " + response.getBase_code());
        System.out.println("Target: " + response.getTarget_code());
        System.out.println("Tasa de conversión: " + response.getConversion_rate());
    }
}

