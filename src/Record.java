import java.util.ArrayList;
import java.util.Collection;

public class Record {
    //ngl no se que va aquí
    ArrayList<Player> top10 = new ArrayList<Player>(10);

    public void addPlayerRanking(Player _player) {
        this.top10.add(_player);
    }

    public void showRanking() {
        System.out.println("----TOP10----");
        for(int i = 0; i<top10.size(); i++) {
            System.out.println(top10.get(i));
        }
        System.out.println("-------------");
    }

    public void showBestPlayer() {
        System.out.println("---SinMujeres----");
    }
}
