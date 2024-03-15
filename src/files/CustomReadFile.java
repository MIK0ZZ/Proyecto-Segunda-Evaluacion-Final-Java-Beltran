package files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import main.Player;

public class CustomReadFile extends FileReader implements ICustomReadFile {

    public CustomReadFile(File file) throws FileNotFoundException {
        super(file);
    }

    ArrayList<Player> leerJugadores = new ArrayList<>();
    Scanner lector = new Scanner(this);

    /**
     * Lee el fichero, divide en 2 la cadena y lo añade a un jugador.
     */
    @Override
    @SuppressWarnings("rawtypes")
    public ArrayList leerJugadores() {
        while (lector.hasNextLine()) {
            String frase = lector.nextLine();
            String[] partes = frase.split(" ", 2);

            int puntos = Integer.parseInt(partes[0]);
            String nombre = partes[1];

            Player molde = new Player(nombre, puntos);
            leerJugadores.add(molde);
        }
        return leerJugadores;
    }

    /**
     * Cierra el fichero.
     */
    @Override
    public void closeReadFile() {
        lector.close();
        try {
            this.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
