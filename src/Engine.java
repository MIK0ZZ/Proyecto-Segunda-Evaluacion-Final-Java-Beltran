import java.util.Random;
import java.util.Scanner;

public class Engine {

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    

    public static void pressENTER() {
        System.console().readLine();
    }

    Random randomN = new Random();

    enum tColores {ROJO, VERDE, AZUL, DORADO}

    private final int MAX_COLORES_SEQ = 12;
    
    private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

    private String color = "";

    private boolean ended = false;



    public tColores charToColor(String _color) {

        this.color = _color.toLowerCase();

        switch(color.charAt(0)) {
            case 'r':
                return tColores.ROJO;
            case 'v':
                return tColores.VERDE;
            case 'a':
                return tColores.AZUL;
            case 'd':
                return tColores.DORADO;
            default:
                return null;
        }

    }

    public void generarSecuenca() {
        for(int i = 0; i < secuenciaColores.length; i++) {
            int n = randomN.nextInt(0,4);
            switch(n) {
                case 0:
                    secuenciaColores[i] = tColores.ROJO;
                    break;
                case 1:
                    secuenciaColores[i] = tColores.VERDE;
                    break;
                case 2:
                    secuenciaColores[i] = tColores.AZUL;
                    break;
                case 3:
                    secuenciaColores[i] = tColores.DORADO;
                    break;
            }
        }
    }

    public void mostrarSecuencia(int _numero) {
        System.out.print("[");
        for(int i = 0; i < _numero + 3; i++) {
            System.out.print(secuenciaColores[i] + "-");
        }
        System.out.print("]");
    }

    public boolean comprobarColor(int _i, tColores _color) {
        if(_color == secuenciaColores[_i]) {
            return true;
        } else {
            return false;
        }
    }

    public void play() {

        Scanner sc = new Scanner(System.in);

        Player player = new Player();

        while(ended = false) {
            System.out.println("Hola " + player.getName() + " pulsa ENTER para jugar.");
            pressENTER();
            clearScreen();
            generarSecuenca();

            while (ended == false) {
                System.out.print("Memoriza esta secuencia: ");
                mostrarSecuencia(3);
                pressENTER();
                clearScreen();
            }
            

        }
        sc.close();
    }

}
