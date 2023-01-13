package com.example.mp03_tictactoe;

public class Partida {

    private static boolean started; // ? Determina el estado de la partida  T-Iniciada F-NO Iniciada
    private int mode = 0; // ? 0- Plyr VS Plyr  1- Plyr VS PC  2- PC VS PC
    private static boolean turno; // ? Turno de jugadores  T-J1 F-J2
    private int nTurno; // ? Número de turno
    private static int[][] tablero = new int[3][3]; // ? Matriz del tablero

    public Partida(){
        turno = true;
    }

    public static boolean getStarted(){
        return started;
    }
    public static void setStarted(boolean started) {
        Partida.started = started;
    }

    public int getMode() {
        return mode;
    }

    public boolean getTurno() {
        return turno;
    }
    public void setTurno(boolean turno) {
        this.turno = turno;
    }

    public int getnTurno() {
        return nTurno;
    }

    public static int[][] getTablero() {
        return tablero;
    }

    public static void cambiarTurno(){
        turno = true ? false : true; // ! MAL
    }
}
