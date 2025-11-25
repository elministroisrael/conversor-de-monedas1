package com.juangomez.conversor.monedas.service;

import com.juangomez.conversor.monedas.model.ExchangeRateResponse;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversorMonedaService {

    private static final Gson GSON = new Gson();

    private static final String BASE_DIRECCION = "https://v6.exchangerate-api.com/v6/8f9522200c655e6fefc6b3c0/pair";

    public static double getExchangeRate(String baseCurrency, String targetCurrency) {
        String address = BASE_DIRECCION + "/" + baseCurrency + "/" + targetCurrency;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();
        try {
            HttpResponse<String> httpResponse = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return GSON.fromJson(httpResponse.body(), ExchangeRateResponse.class).getConversion_rate();
        } catch (Exception ex) {
            System.out.println("Something was wrong in the system");
        }
        return 0;
    }

}
