
package com.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Scegli il numero di cavalli da far gareggiare:");
        int Ncavalli = scanner.nextInt();
        scanner.nextLine();

        Cavallo[] cavalli = new Cavallo[Ncavalli];

        for (int i = 0; i < Ncavalli; i++) {
            System.out.println("Inserisci nome cavallo:");
            String nome = scanner.nextLine();

            cavalli[i] = new Cavallo(nome);
        }

        System.out.println("\nTutti i cavalli sono stati registrati!");

        for (Cavallo cavallo : cavalli) {
            cavallo.start();
        }
        for (Cavallo cavallo : cavalli) {
    try {
        cavallo.join();
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        return;
    }
}

System.out.println("\n--- CLASSIFICA FINALE ---");

for (int i = 0; i < Gara.classifica.size(); i++) {
    System.out.println((i + 1) + "° posto: "
            + Gara.classifica.get(i));
}

        scanner.close();
    }
}
