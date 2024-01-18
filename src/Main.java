public class Main {

    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }  

    

    public static void pressENTER() {
        System.console().readLine();
    }
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
