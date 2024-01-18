import java.util.Scanner;

public class Main {

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    

    public static void pressENTER() {
        System.console().readLine();
    }
    public static void main(String[] args) throws Exception {

        Engine engine = new Engine();

        boolean ended = false;

        clearScreen();
        System.out.println("Bienvenide a Simon dice!");
        
        Scanner sc = new Scanner(System.in);
        System.out.print("¿Cual es tu nombre?: ");
        String name = sc.next();

        Player player = new Player();

        player.setName(name);

        engine.play(ended);
        sc.close();

    }
}
