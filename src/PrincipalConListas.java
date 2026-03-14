
import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalConListas {
    static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("El señor de los anillos", 2021);
        miPelicula.evalua(9.00);
        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.evalua(10.00);
        var peliculaNahir = new Pelicula("Matilda", 2001);
        peliculaNahir.evalua(8.00);
        Serie lost = new Serie("Lost", 2000);


        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(peliculaNahir);
        lista.add(otraPelicula);
        lista.add(miPelicula);
        lista.add(lost);

            for (Titulo item : lista) {
                System.out.println("Nombre: " + item.getNombre());
                if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                    System.out.println("Clasificacion: " + pelicula.getClasificacion());
                }

            }

            ArrayList<String> listaDeArtistas = new ArrayList<>();
            listaDeArtistas.add("Penelope Cruz");
            listaDeArtistas.add("Antonio Banderas");
            listaDeArtistas.add("Ricardo Darin");

        Collections.sort (listaDeArtistas);
        System.out.println("Lista ordenada: " + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: " + lista);
        }






    }
