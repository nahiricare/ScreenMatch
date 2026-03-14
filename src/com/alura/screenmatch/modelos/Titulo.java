package com.alura.screenmatch.modelos;

import com.alura.screenmatch.excepcion.ErrorEnConversionDeDuracionException;

public class Titulo implements Comparable<Titulo>{
    private String nombre;
    private int fechaDeLanzamiento;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeEvaluaciones;
    private int duracionEnMinutos;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;

    }

    // Nuevo constructor para convertir datos de la API
    public Titulo(TituloOmdb miTituloOmdb) {
        this.nombre = miTituloOmdb.Title();

        // Manejamos el error de duración ANTES de intentar convertirla
        if (miTituloOmdb.Runtime().contains("N/A")) {
            throw new ErrorEnConversionDeDuracionException("No pude convertir la duración porque es N/A");
        }

        // El año viene como String ("1993"), lo convertimos a int
        this.fechaDeLanzamiento = Integer.parseInt(miTituloOmdb.Year());

        // La duración viene como "60 min", necesitamos solo el número
        // Usamos replace para quitar " min" y luego convertimos a int
        if (miTituloOmdb.Runtime().contains("N/A")) {
            this.duracionEnMinutos = 0;
        } else {
            this.duracionEnMinutos = Integer.parseInt(miTituloOmdb.Runtime().replace(" min", ""));
        }
    }


    public String getNombre() {
        return nombre;
    }

    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public boolean isIncluidoEnElPlan() {
        return incluidoEnElPlan;
    }

    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public int getTotalDeEvaluaciones() {
        return totalDeEvaluaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void muestraFichaTecnica(){
        System.out.println("Nombre de la película: " + nombre);
        System.out.println("Año de lanzamiento: " + fechaDeLanzamiento);
    }

    public void evalua(double nota){
        sumaDeLasEvaluaciones += nota;
        totalDeEvaluaciones++;
    }

    public double calculaMediaEvaluaciones(){
        return sumaDeLasEvaluaciones / totalDeEvaluaciones;
    }

    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }
}
