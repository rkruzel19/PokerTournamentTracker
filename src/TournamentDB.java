import java.util.ArrayList;

public class TournamentDB {

    private static ArrayList<Tournament> tournaments = new ArrayList<>();

    public void addTournamentToDB(Tournament tournament){
        tournaments.add(tournament);
    }

    public ArrayList<Tournament> getTournaments() {
        return tournaments;
    }

    public static int getNumberOfTournaments(){
        return tournaments.size();
    }

}
