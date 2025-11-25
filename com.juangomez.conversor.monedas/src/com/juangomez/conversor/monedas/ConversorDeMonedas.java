package com.juangomez.conversor.monedas;

import com.google.gson.Gson;
import com.juangomez.conversor.monedas.service.ConversorMonedaService;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorDeMonedas {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
                System.out.println("Escriba los tres digitos correspondiente a la modeda base:");
        var monedaBase = lectura.nextLine();
        System.out.println("su moneda base es : " + monedaBase);

        System.out.println("Escriba los tres digitos correspondiente a la modeda a cambiar: ");
        var monedaCambio = lectura.nextLine();
        System.out.println("su moneda base es : " + monedaCambio);


        System.out.println("Escriba los tres digitos correspondiente a la modeda a cambiar: ");
        var dinero = Double.parseDouble(lectura.nextLine());
        final var conversionRate = ConversorMonedaService.getExchangeRate(monedaBase, monedaCambio);
        System.out.println("su cambio : " + (dinero * conversionRate));
    }


}
