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

    private final int MAX_COLORES_SEQ = 4;
    
    private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];

    private String color = "";




    
    /** 
     * @param _color
     * @return tColores
     * Transforma el caracter de entrada en un color
     */
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

    /**
     * Genera la secuencia
     */
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

    
    /** 
     * @param _numero
     * Muestra la secuencia de la ronda
     */
    public void mostrarSecuencia(int _numero) {
        System.out.print("[");
        for(int i = 0; i < _numero + 3; i++) {
            System.out.print(secuenciaColores[i] + "-");
        }
        System.out.print("]");
    }

    /**
     * @param _i
     * @param _color
     * @return
     * 
     * Comprueba cada color en la secuencia
     */
    public boolean comprobarColor(int _i, tColores _color) {
        if(_color == secuenciaColores[_i]) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param _ended
     * Ejecución del juego
     */
    public void play(boolean _ended) {

        _ended = false;

        

        

        Scanner sc = new Scanner(System.in);

        Player player = new Player();

        while(_ended == false) {

            boolean acabar = false;
            int ronda = 0;

            System.out.print("¿Cual es tu nombre?: ");
            String name = sc.next();

            player.setName(name);
            System.out.println("Hola " + player.getName() + " pulsa ENTER para jugar.");
            pressENTER();
            clearScreen();
            generarSecuenca();

            int puntos = 0;

            while(acabar == false) {

                puntos = 0;

                System.out.print("Memoriza esta secuencia: ");
                mostrarSecuencia(ronda);
                pressENTER();
                clearScreen();
                System.out.println("Tu respuesta: [r/v/a/d]: ");
                for(int i = 0; i < ronda + 3; i++) {
                
                    System.out.print((i+1) + ": ");
                    String answer = sc.next();
                    if(comprobarColor(i, charToColor(answer)) == true) {
                        puntos += 1;
                    } else {
                        break;
                    }
                    
                } 
                clearScreen();
                if(puntos != (ronda + 3)) {
                    acabar = true;
                } else {
                    if(puntos == MAX_COLORES_SEQ) {
                        acabar = true;
                    } else {
                        ronda += 1;
                    }
                    
                }

    
            }

            if(puntos == MAX_COLORES_SEQ) {
                System.out.println("--HAS GANADO--");
                pressENTER();
                clearScreen();
            } else {
                System.out.println("--HAS FALLADO--");
                pressENTER();
                clearScreen();
            }

            
            

        }
        sc.close();
    }

}
