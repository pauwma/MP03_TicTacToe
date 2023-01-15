package com.example.mp03_tictactoe;

public class Partida {

    private static boolean started; // ? Determina el estado de la partida  T-Iniciada F-NO Iniciada
    private static boolean ganador;
    private static int mode = 0; // ? 1- Plyr VS Plyr  2- Plyr VS PC  3- PC VS PC
    private static boolean turno; // ? Turno de jugadores  T-J1 F-J2
    private static int nTurno; // ? Número de turno
    private static int[][] tablero = new int[3][3]; // ? Matriz del tablero
    public Partida(){
        turno = true;
        mode = 1;
        ganador = false;
    }

    // * --------------------------------

    public static boolean getStarted(){
        return started;
    }
    public static void setStarted(boolean started) {
        Partida.started = started;
    }
    public static int getMode() {
        return mode;
    }
    public static void setMode(int tmpMode) {
        mode = tmpMode;
    }
    public boolean getTurno() {
        return turno;
    }
    public void setTurno(boolean turno) {
        this.turno = turno;
    }
    public static int getnTurno() {
        return nTurno;
    }
    public static void setnTurno(int nTurno) {
        Partida.nTurno = nTurno;
    }
    public static int[][] getTablero() {
        return tablero;
    }
    public static boolean isGanador() {
        return ganador;
    }
    public static void setGanador(boolean ganador) {
        Partida.ganador = ganador;
    }
    // * --------------------------------

    public static void cambiarTurno(){
        if (turno){
            turno = false;
        } else turno = true;
    }
    public static void restart(){
        tablero = new int[3][3];
        nTurno = 0;
        ganador = false;
    }
    public static void marcar(int nBtn){
        switch (nBtn){
            case 0:
                tablero[0][0] = turnoMarcar();
                break;
            case 1:
                tablero[0][1] = turnoMarcar();
                break;
            case 2:
                tablero[0][2] = turnoMarcar();
                break;
            case 3:
                tablero[1][0] = turnoMarcar();
                break;
            case 4:
                tablero[1][1] = turnoMarcar();
                break;
            case 5:
                tablero[1][2] = turnoMarcar();
                break;
            case 6:
                tablero[2][0] = turnoMarcar();
                break;
            case 7:
                tablero[2][1] = turnoMarcar();
                break;
            case 8:
                tablero[2][2] = turnoMarcar();
                break;
        }
    }
    public static int nTablero(int n){
        if (n==0) {
            return tablero[0][0];
        } else if (n==1) {
            return tablero[0][1];
        } else if (n==2) {
            return tablero[0][2];
        } else if (n==3) {
            return tablero[1][0];
        } else if (n==4) {
            return tablero[1][1];
        } else if (n==5) {
            return tablero[1][2];
        } else if (n==6) {
            return tablero[2][0];
        } else if (n==7) {
            return tablero[2][1];
        } else if (n==8) {
            return tablero[2][2];
        } else return 99;
    }
    public static int turnoMarcar(){
        if (turno){
            return 1;
        } else {
            return 2;
        }
    }
    public static int comprobarGanador() {
        // ? Revisamos las filas
        for (int i = 0; i < 3; i++) {
            if (tablero[i][0] == tablero[i][1] && tablero[i][1] == tablero[i][2]) {
                ganador = true;
                return tablero[i][0];
            }
        }

        // ? Revisamos las columnas
        for (int j = 0; j < 3; j++) {
            if (tablero[0][j] == tablero[1][j] && tablero[1][j] == tablero[2][j]) {
                ganador = true;
                return tablero[0][j];
            }
        }

        if (tablero[0][0] == tablero[1][1] && tablero[1][1] == tablero[2][2]) {
            ganador = true;
            return tablero[0][0];
        }
        if (tablero[0][2] == tablero[1][1] && tablero[1][1] == tablero[2][0]) {
            ganador = true;
            return tablero[0][2];
        }

        // ? Si no se ha cumplido ninguna de las condiciones anteriores, no hay ganador
        return 0;

    } // ? Comprueba si hay ganador y si hay te dice cual es
    public static void mostrarTableroLog(){
        System.out.println("JUGADA  nº" + nTurno);
        System.out.println(tablero[0][0] + " - " + tablero[0][1] + " - " + tablero[0][2]);
        System.out.println(tablero[1][0] + " - " + tablero[1][1] + " - " + tablero[1][2]);
        System.out.println(tablero[2][0] + " - " + tablero[2][1] + " - " + tablero[2][2]+"\n");
    } // ! Debug del tablero
}