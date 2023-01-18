package com.example.mp03_tictactoe;

import java.util.Random;

public class Partida {

    private boolean ganador;
    private int mode = 0; // ? 1- Plyr VS Plyr  2- Plyr VS PC  3- PC VS PC
    private boolean turno; // ? Turno de jugadores  T-J1 F-J2
    private int nTurno; // ? Número de turno
    private int[][] tablero = new int[3][3]; // ? Matriz del tablero
    public Partida(){
        turno = true;
        mode = 1;
        ganador = false;
    }

    // * --------------------------------

    public int getMode() {
        return mode;
    }
    public void setMode(int tmpMode) {
        mode = tmpMode;
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
    public void setnTurno(int nTurno) {
        this.nTurno = nTurno;
    }
    public int[][] getTablero() {
        return tablero;
    }
    public boolean isGanador() {
        return ganador;
    }
    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }
    // * --------------------------------

    public void cambiarTurno(){
        if (turno){
            turno = false;
        } else turno = true;
    }
    public void restart(){
        tablero = new int[3][3];
        nTurno = 0;
        ganador = false;
    }
    public void marcar(int nBtn){
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
    public int nTablero(int n){
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
    public int turnoMarcar(){
        if (turno){
            return 1;
        } else {
            return 2;
        }
    }
    public int comprobarGanador() {
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

    public void randomTurno(){
        Random rd = new Random();
        turno = rd.nextBoolean();
    }
    public void mostrarTableroLog(){
        System.out.println("JUGADA  nº" + nTurno);
        System.out.println(tablero[0][0] + " - " + tablero[0][1] + " - " + tablero[0][2]);
        System.out.println(tablero[1][0] + " - " + tablero[1][1] + " - " + tablero[1][2]);
        System.out.println(tablero[2][0] + " - " + tablero[2][1] + " - " + tablero[2][2]+"\n");
    } // ! Debug del tablero
}