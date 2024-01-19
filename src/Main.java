import java.util.Scanner;

public class Main {
    /**
     * Limpia la consola
     */
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  
    /**
     * Pausa para el enter
     */
    public static void pressENTER() {
        System.console().readLine();
    }
    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {

        Engine engine = new Engine();

        boolean ended = false;

        clearScreen();
        System.out.println("Bienvenide a Simon dice!");
        
        Scanner sc = new Scanner(System.in);
        

        engine.play(ended);
        sc.close();

    }
}
