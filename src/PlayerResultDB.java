import java.util.ArrayList;

public class PlayerResultDB {

    private ArrayList<PlayerResult> results = new ArrayList<>();

    public void addResultToDB(PlayerResult result){
        results.add(result);
    }

    public ArrayList<PlayerResult> getResults() {
        return results;
    }
}
