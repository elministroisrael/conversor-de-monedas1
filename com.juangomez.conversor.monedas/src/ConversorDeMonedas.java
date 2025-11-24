import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversorDeMonedas {

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
                System.out.println("Escriba los tres digitos correspondiente a la modeda base:");
        var monedaBase = lectura.nextLine();
        System.out.println("su moneda base es : " + monedaBase);

        String direccion = "https://v6.exchangerate-api.com/v6/8f9522200c655e6fefc6b3c0/pair/USD/"+monedaBase;




        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }


}
