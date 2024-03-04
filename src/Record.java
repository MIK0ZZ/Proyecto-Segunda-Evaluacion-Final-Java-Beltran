import java.util.ArrayList;

public class Record {
    //ngl no se que va aquí
    ArrayList<Player> top10 = new ArrayList<Player>(10);
    
    

    public void addPlayerRanking(Player _player) {
        this.top10.add(_player);
    }

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

    public void showBestPlayer() {
        System.out.println("---SinMujeres----");
        
    }
}
