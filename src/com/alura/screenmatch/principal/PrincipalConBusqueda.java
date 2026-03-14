package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Titulo;
import com.alura.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    // La sentencia throws IOException es "Mira, este método usa archivos o internet, y eso puede fallar. Si falla, simplemente detén todo y muestra el error".
    //"Este método es peligroso y no voy a solucionar todos sus problemas aquí adentro". por lo que la JVM llamada por el main toma el problema, detiene el programa y muestra mensaje en rojo de la consola.-

    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        // Creamos la lista fuera del bucle para que no se borre en cada vuelta
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                //Esta línea funciona como "Traductor oficial" entre la API y el mundo java
                //Sin esta línea, Gson a veces no encuentra los datos y te deja los campos en null porque no reconoce que "Title" es lo mismo que tu campo title.
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting() // Esto hace que el JSON se vea lindo al imprimir
                .create();

        while (true) {
            System.out.println("Escriba el nombre de una película (o 'salir' para finalizar): ");
            var busqueda = lectura.nextLine();

            //Esta línea compara 2 textos ignorando si están en mayúsculas o minúsculas
            //el usuario puede escribir: salir, SALIR, Salir o hasta sAlIr, y el programa siempre entenderá que quieres cerrar el bucle.
            if (busqueda.equalsIgnoreCase("salir")) {
                break; // Rompemos el bucle y salimos
            }

            try {
                var busquedaFormateada = busqueda.replace(" ", "+");
                String direccion = "http://www.omdbapi.com/?t=" + busquedaFormateada + "&apikey=e77580d8";

                HttpClient client = HttpClient.newHttpClient();
                HttpRequest request = HttpRequest.newBuilder().uri(URI.create(direccion)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                String json = response.body();
                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);

                Titulo miTitulo = new Titulo(miTituloOmdb);

                System.out.println("Título convertido: " + miTitulo);

                // ¡Guardamos el título en nuestra lista!
                titulos.add(miTitulo);

            } catch (NumberFormatException e) {
                System.out.println("Error: No se pudo convertir un dato numérico.");
            } catch (com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado.");
            }
        }

//         Al salir del bucle, mostramos todo lo que buscamos
// AQUÍ es donde ocurre la persistencia (fuera del while)
        System.out.println("Lista de películas recolectadas: " + titulos);

        FileWriter escritura = new FileWriter("peliculas.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();

        System.out.println("Programa finalizado. ¡Archivo guardado con éxito!");
    }
}
