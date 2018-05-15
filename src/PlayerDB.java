import java.util.ArrayList;

public class PlayerDB {

    private static ArrayList<Player> players = new ArrayList<>();

    public void addPlayerToDB(Player player){
        players.add(player);
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public static int getPlayerDBsize(){
        return players.size();
    }

    public Player getPlayerByName(String name){
        for(Player player : players){
            if (name.equalsIgnoreCase(player.getName())){
                return player;
            }
        }
        return null;
    }

}
