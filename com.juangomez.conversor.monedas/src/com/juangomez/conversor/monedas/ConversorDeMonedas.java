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


    public static void main (String[] args) {

      Scanner lectura = new Scanner(System.in);

        String monedaBase="";
        String monedaCambio="";

        int opcion;

        do {

            exibirMenu();
            opcion = lectura.nextInt();

            switch (opcion) {

                case 1 -> {
                    monedaBase = "USD";
                    monedaCambio = "ARS";
                }
                case 2 -> {
                    monedaBase = "ARS";
                    monedaCambio = "USD";
                }
                case 3 -> {
                    monedaBase = "USD";
                    monedaCambio = "BRL";
                }
                case 4 -> {
                    monedaBase = "BRL";
                    monedaCambio = "USD";
                }
                case 5 -> {
                    monedaBase = "USD";
                    monedaCambio = "COP";
                }
                case 6 -> {
                    monedaBase = "COP";
                    monedaCambio = "USD";
                }

                case 7 -> System.out.println("Saliendo del programa. ¡Gracias por usar el conversor!");
                default -> System.out.println("Opción inválida. Intente nuevamente.");


            }
            if (opcion == 7) {
                break; // rompe el bucle y no pide más datos
            }

            System.out.println("Escriba la cantidad de dinero a cambiar: ");
            var dinero = lectura.nextInt();
            final var conversionRate = ConversorMonedaService.getExchangeRate(monedaBase, monedaCambio);
            System.out.println("su cambio : " + (dinero * conversionRate));




        } while (opcion != 7);

        lectura.close();




    }
    public static void exibirMenu() {
        System.out.println("""
    ********************************************
    Sea bienvenido/a al Conversor de Moneda =]
    ********************************************

    1) Dólar ==> Peso argentino
    2) Peso argentino ==> Dólar
    3) Dólar ==> Real brasileño
    4) Real brasileño ==> Dólar
    5) Dólar ==> Peso colombiano
    6) Peso colombiano ==> Dólar
    7) Salir

    Elija una opción válida:
    """);
    }


}
