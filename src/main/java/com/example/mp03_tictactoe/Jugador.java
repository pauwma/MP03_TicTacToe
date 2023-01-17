package com.example.mp03_tictactoe;

public class Jugador {
    private String nombre;
    private int ganadas;
    private int perdidas;
    private int empatadas;

    public Jugador(String nombre, int ganadas, int perdidas, int empatadas) {
        this.nombre = nombre;
        this.ganadas = ganadas;
        this.perdidas = perdidas;
        this.empatadas = empatadas;
    }

    public Jugador(String nombre){
        this.nombre = nombre;
        ganadas = 0;
        perdidas = 0;
        empatadas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public int getEmpatadas() {
        return empatadas;
    }

    public void setEmpatadas(int empatadas) {
        this.empatadas = empatadas;
    }
}