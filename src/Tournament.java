import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class Tournament {

    private long tournamentID;
    private Date date;
    private int numberOfPlayers;
    private int buyIn;
    private int totalPot;
    private ArrayList<PlayerResult> playerResults = new ArrayList<>();

    public Tournament(Date date, int numberOfPlayers, int buyIn, int totalPot) {
        this.tournamentID = 1000 + TournamentDB.getNumberOfTournaments();
        this.date = date;
        this.numberOfPlayers = numberOfPlayers;
        this.buyIn = buyIn;
        this.totalPot = totalPot;
    }

    public void setPlayerResults(ArrayList<PlayerResult> playerResults) {
        this.playerResults = playerResults;
    }

    public long getTournamentID() {
        return tournamentID;
    }

    public Date getDate() {
        return date;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public int getBuyIn() {
        return buyIn;
    }

    public int getTotalPot() {
        return totalPot;
    }

    public ArrayList<PlayerResult> getPlayerResults() {
        return playerResults;
    }

    public String getStringDate(){
        String[] splitDate = date.toString().split(" ");
        return splitDate[1] + " " + splitDate[2] + " " + splitDate[5];
    }

    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("Tournament ID: ").append(tournamentID).append("\n")
                .append("Date: ").append(getStringDate()).append("\n")
                .append("Number of players: ").append(numberOfPlayers).append("\n")
                .append("Buy-in: ").append(buyIn).append("\n")
                .append("Total pot: ").append(totalPot).append("\n");
        return output.toString();
    }
}
