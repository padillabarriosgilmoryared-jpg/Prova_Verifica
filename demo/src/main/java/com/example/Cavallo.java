
package com.example;

import java.util.Random;

public class Cavallo extends Thread {

    private static final float LENGHTRACE = 200;
    private final String name;
    private float LpercorsoCompiuto = 0;

    public Cavallo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        Random random = new Random();

        while (LpercorsoCompiuto < LENGHTRACE) {

            float randDistance = random.nextFloat(9) + 1;

            try {
                int tempoSleep = random.nextInt(400) + 400;
                Thread.sleep(tempoSleep);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }

            float distanzaRimanente = LENGHTRACE - LpercorsoCompiuto;

            randDistance = Math.min(randDistance, distanzaRimanente);
            LpercorsoCompiuto += randDistance;

            System.out.println("Il cavallo " + name
                    + " ha percorso: " + LpercorsoCompiuto + " metri");

            if (LpercorsoCompiuto < LENGHTRACE) {
                System.out.println("Mancano al cavallo " + name + ": "
                        + (LENGHTRACE - LpercorsoCompiuto) + " metri");
            }
        }

        Gara.classifica.add(name);
        System.out.println(name + " ha tagliato il traguardo!");
    }
}
