package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import files.CustomReadFile;
import files.CustomWriteFile;

public class Record {
    private final int MAX_JUGADORES = 10;
    ArrayList<Player> top10 = new ArrayList<Player>(MAX_JUGADORES);
    File file = new File("./src/data/top.txt");

    /**
     * Carga el ranking.
     */
    @SuppressWarnings("unchecked")
    public void cargarRanking() {
        try (CustomReadFile crf = new CustomReadFile(file)) {
            this.top10 = crf.leerJugadores();
            crf.closeReadFile();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param _player Recibe un player y lo escribe en el ranking.
     */
    public void escribirRanking() {
        try {
            @SuppressWarnings("resource")
            CustomWriteFile cwf = new CustomWriteFile(file);
            String chain = "";
            for (int i = 0; i < this.top10.size(); i++) {
                chain = chain + top10.get(i).getPuntos() + " " + top10.get(i).getName() + "\n";
            }

            cwf.writeJugadores(chain);
            cwf.closeWriteFile();
        } catch (FileNotFoundException e) {
            System.out.println("El archivo no se encontró.");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param _player añade un jugador al ranking
     */
    public void addPlayerRanking(Player _player) {
        this.top10.add(_player);
    }

    /**
     * Muestra el raking ordenado
     * Complejidad de 0(n)
     */
    public void showRanking() {
        System.out.println("----TOP10----");

        try {
            for (int i = 0; i < 10; i++) {
                System.out.println(i + 1 + ". " + top10.get(i).getName() + " = " + top10.get(i).getPuntos());
            }
            System.out.println("-------------");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("-------------");
        }

    }

    /**
     * Ordena el ranking
     * Complejidad de 0(n^2)
     */
    public void ordenarRanking() {
        for (int i = 0; i < top10.size(); i++) {
            for (int j = 0; j < top10.size() - i - 1; j++) {
                if (top10.get(j).getPuntos() < top10.get(j + 1).getPuntos()) {
                    Player temp = top10.get(j);
                    top10.set(j, top10.get(j + 1));
                    top10.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Muestra los mejores jugadores
     * Complejidad de 0(n)
     */
    public void showBestPlayer() {
        System.out.println("---SinMujeres----");
        try {
            for (int i = 0; i < top10.size(); i++) {
                if (top10.get(i).getPuntos() == top10.get(0).getPuntos()) {
                    System.out.println(i + 1 + ". " + top10.get(i).getName() + " = " + top10.get(i).getPuntos());
                }

            }
            System.out.println("-----------------");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("-----------------");
        }

    }
}
