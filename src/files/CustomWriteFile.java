package files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CustomWriteFile extends FileWriter implements ICustomWriteFile {

    public CustomWriteFile(File file) throws IOException {
        super(file);
    }

    /**
     * Escribe al jugador en el archivo sin sobreescribirlo.
     */
    @Override
    public void writeJugadores(String _chain) {
        try {
            this.write(_chain);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Cierra el fichero
     */
    @Override
    public void closeWriteFile() {
        try {
            this.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
