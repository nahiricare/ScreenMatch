package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Titulo;
import com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el nombre de una película: ");
        var busqueda = lectura.nextLine();

        //Try.catch
        try {
            // 1. Preparar la búsqueda (Recuerda el .replace para los espacios)
            var busquedaFormateada = busqueda.replace(" ", "+");
            String direccion = "http://www.omdbapi.com/?t=" + busquedaFormateada + "&apikey=e77580d8";

            // 2. Hacer la petición a la API
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            // 3. Convertir el JSON a nuestro Record
            String json = response.body();
            Gson gson = new Gson();
            TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);

            // 4. Usar el constructor que creamos en Titulo
            Titulo miTitulo = new Titulo(miTituloOmdb);
            System.out.println("Título convertido: " + miTitulo);

        } catch (NumberFormatException e) {
            System.out.println("Error: No se pudo convertir un dato numérico.");
            System.out.println("Detalle: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: La dirección de búsqueda es inválida.");
        } catch (com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException e) {
            System.out.println("Error específico: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            // Esto se ejecuta SIEMPRE (opcional)
            System.out.println("Finalizó la ejecución de la búsqueda.");
        }
    }

}
