package files;

import java.util.ArrayList;

import main.Player;

public interface ICustomReadFile {
    @SuppressWarnings("rawtypes")
    public ArrayList leerJugadores();
    public void closeReadFile();
}
