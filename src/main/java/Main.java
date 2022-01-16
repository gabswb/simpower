package main.java;

import main.java.controller.GameController;

import javax.swing.*;

/**
 * Classe principale qui contient la méthode main et permet de démarrer le programme
 */
public class Main {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        new GameController().start();
    }

}
