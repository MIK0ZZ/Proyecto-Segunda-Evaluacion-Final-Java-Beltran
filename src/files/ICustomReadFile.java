package files;

import java.util.ArrayList;

public interface ICustomReadFile {
    @SuppressWarnings("rawtypes")
    public ArrayList leerJugadores();

    public void closeReadFile();
}
