import java.util.ArrayList;

public class Player {

    private long playerID;
    private String name;
    private int overallProfit;
    ArrayList<PlayerResult> myResults;

    public Player(String name){
        this.playerID = PlayerDB.getPlayerDBsize() + 1;
        this.name = name;
        overallProfit = 0;
        myResults = new ArrayList<>();
    }

    public long getPlayerID() {
        return playerID;
    }

    public String getName() {
        return name;
    }

    public int getOverallProfit() {
        return overallProfit;
    }

    public ArrayList<PlayerResult> getMyResults() {
        return myResults;
    }

    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("ID: ").append(playerID).append("\n")
                .append("Name: ").append(name).append("\n")
                .append("Overall Profit: ").append(overallProfit).append("\n");

        return output.toString();
    }

}
