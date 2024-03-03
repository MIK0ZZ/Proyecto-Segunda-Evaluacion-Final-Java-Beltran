import java.util.Random;
import java.util.Scanner;

public class Engine {

    enum tColores {ROJO, VERDE, AZUL, DORADO, BLANCO, MARRON, NARANJA}
    private int MAX_COLORES_SEQ = 12;
    private tColores[] secuenciaColores = new tColores[MAX_COLORES_SEQ];
    private String color = "";
    enum tModo {FACIL, DIFICIL}
    private tModo difficulty = tModo.FACIL;
    private int nAyudas = 3;

    /**
     * Activa el modo dificl.
     */
    public void hardMode() {
        difficulty = tModo.DIFICIL;
    }
    /**
     * Activa el modo facil.
     */
    public void easyMode() {
        difficulty = tModo.FACIL;
    }

    /**
     * Limpia la consola
     */
    public void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    /**
     * Pausa para el enter
     */
    public void pressENTER() {
        System.console().readLine();
    }

    Random randomN = new Random();

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
            case '1':
                return tColores.ROJO;
            case 'v':
                return tColores.VERDE;
            case '2':
                return tColores.VERDE;
            case 'a':
                return tColores.AZUL;
            case '3':
                return tColores.AZUL;
            case 'd':
                return tColores.DORADO;
            case '4':
                return tColores.DORADO;
            case 'b':
                return tColores.BLANCO;
            case '5':
                return tColores.BLANCO;
            case 'm':
                return tColores.MARRON;
            case '6':
                return tColores.MARRON;
            case 'n':
                return tColores.NARANJA;
            case '7':
                return tColores.NARANJA;
            default:
                return null;
        }
    }

    /**
     * Genera la secuencia tanto en modo dificil como en facil
     */
    public void generarSecuencia(int _cantidad) { //tiene que entrar el numero maximo del random
        
        secuenciaColores = new tColores[MAX_COLORES_SEQ];
        for(int i = 0; i < secuenciaColores.length; i++) {
            int n = randomN.nextInt(0,_cantidad);
            secuenciaColores[i] = tColores.values()[n]; //FUNCIONA PERO SOBREESCRIBE EL ANTERIOR
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
     * @param _i
     * @return
     * 
     * Comprueba si quedan ayudas
     */
    public boolean usarAyuda(int _i) {
        if(nAyudas != 0) {
            nAyudas--;
            System.out.println("Este color es el: " + secuenciaColores[_i] + " Te quedan " + nAyudas + " ayudas.");
            return true;
        } else {
            System.out.println("No te quedan ayudas");
            return false;
        }
    }

    /**
     * @param _stop
     * 
     * Menu de inicio
     */
    public void start(boolean _stop) {

        _stop = false;

        Scanner sc = new Scanner(System.in);
        Player player = new Player();

        while (_stop == false) {
            String name = "";
            
            System.out.print("Cual es tu nombre?: ");
            name = sc.next();
            player.setName(name);
            clearScreen();
            System.out.println("¿Qué desea hacer?: ");
            System.out.println("[1] Jugar");
            System.out.println("[2] Jugar en dificil");
            System.out.println("[X] Salir");
            System.out.print("Respuesta: ");
            String opcion = sc.next();

            switch(opcion.charAt(0)) {
                case '1':
                    System.out.println("Hola " + player.getName() + " pulsa ENTER para jugar.");
                    pressENTER();
                    clearScreen();
                    easyMode();
                    play(_stop, difficulty, sc);
                    break;
                case '2':
                    System.out.println("Hola " + player.getName() + " pulsa ENTER para jugar en modo difícil.");
                    pressENTER();
                    clearScreen();
                    hardMode();
                    play(_stop, difficulty, sc);
                    break;
                default:
                    _stop = true;
            }
            
            
        }
        sc.close();
        
            

    }

    /**
     * @param _stop
     * @param difficulty
     * @param sc
     * 
     * Ejecución del juego
     */
    public void play(boolean _stop, tModo difficulty, Scanner sc) {

        int cantidad = 0;
        switch (difficulty) {
            case tModo.FACIL:
                cantidad = 4;
                break;
            case tModo.DIFICIL:
                cantidad = 7;
                break;
        }
        generarSecuencia(cantidad);
        this.nAyudas = 3;
        boolean acabar = false;
        int ronda = 0;
        int puntos = 0;
        while(acabar == false) {
            puntos = 0;
            System.out.print("Memoriza esta secuencia (x para ayuda): ");
            mostrarSecuencia(ronda);
            pressENTER();
            clearScreen();
            System.out.println("Tu respuesta: ");

            boolean checking = true; //NUEVO
            int i = 0;
            while(checking && i<secuenciaColores.length) {
                if(i==ronda+3) {
                    checking = false;
                } else {
                    System.out.print((i+1) + ": ");
                    String answer = sc.next();
                    if(comprobarColor(i, charToColor(answer)) == true) {
                        puntos += 1;
                        i++;
                    } else if(answer.toLowerCase().charAt(0) == 'x') {
                        if(usarAyuda(i)) {
                            puntos += 1;
                            i++;
                            pressENTER();
                        }
                    } else {
                        checking = false;
                        
                    }
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
            //FALLA ALGO
            if(puntos == MAX_COLORES_SEQ) {
                System.out.println("--HAS GANADO--");
            } else {
                System.out.println("--HAS FALLADO--");
            }
        } 
        
        pressENTER();
        clearScreen();
        
        
    } 

}
