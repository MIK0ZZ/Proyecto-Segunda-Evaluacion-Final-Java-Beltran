import java.util.ArrayList;

public class Record {
    private final int MAX_JUGADORES = 10;
    ArrayList<Player> top10 = new ArrayList<Player>(MAX_JUGADORES);
    
    

    
    /** 
     * @param _player añade un jugador al ranking
     */
    public void addPlayerRanking(Player _player) {
        this.top10.add(_player);
    }

    /**
     * Muestra el raking ordenado
     * Complejidad de 0(n^2)
     */
    public void showRanking() {
        System.out.println("----TOP10----");
        for (int i = 0; i < top10.size(); i++) {
            for (int j = 0; j < top10.size()-i-1; j++) {
                if (top10.get(j).getPuntos() < top10.get(j+1).getPuntos()) {
                    Player temp = top10.get(j);
                    top10.set(j, top10.get(j+1));
                    top10.set(j+1, temp);
                }
            }
        }

        for(int i = 0; i<top10.size(); i++) {
            System.out.println(i+1 + ". " +top10.get(i).getName() + " = " + top10.get(i).getPuntos());
        }
        System.out.println("-------------");
    }

    /**
     * Muestra los mejores jugadores
     * Complejidad de 0(n)
     */
    public void showBestPlayer() {
        System.out.println("---SinMujeres----");
        for(int i = 0; i<top10.size(); i++) {
            if(top10.get(i).getPuntos() == 470) {
                System.out.println(i+1 + ". " +top10.get(i).getName() + " = " + top10.get(i).getPuntos());
            }
            
        }
        System.out.println("-----------------");
    }
}
