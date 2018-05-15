import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PokerTournamentTracker {

    private TournamentDB tournamentDB = new TournamentDB();
    private PlayerDB playerDB = new PlayerDB();
    private PlayerResultDB playerResultDB = new PlayerResultDB();

    public void start() {
        Display.welcome();
        mainMenuChoice(Display.mainMenu());
    }

    public void mainMenuChoice(int option) {
        switch (option){
            case 1:
                //System.out.println("addTournament not active yet");
                addTournament();
                mainMenuChoice(Display.mainMenu());
                break;
            case 2:
                System.out.println("showStandings not active yet");
                //showStandings();
                mainMenuChoice(Display.mainMenu());
                break;
            case 3:
                //System.out.println("showTournaments not active yet");
                showTournaments();
                mainMenuChoice(Display.mainMenu());
                break;
            case 4:
                addPlayer();
                mainMenuChoice(Display.mainMenu());
            case 5:
                showPlayers();
                mainMenuChoice(Display.mainMenu());
            case 6:
                showResults();
                mainMenuChoice(Display.mainMenu());
            case 7:
                System.exit(0);
                break;
            default:
                System.out.println("Input not valid. Choose again.");
                mainMenuChoice(Display.mainMenu());
        }
    }

    public void showResults(){
        for(PlayerResult result : playerResultDB.getResults()){
            System.out.println(result.toString());
        }
    }

    public void addTournament() {
        Tournament tournament = askForTournamentDetails();
        tournamentDB.addTournamentToDB(tournament);
    }

    public void showTournaments(){
        for(Tournament tournament : tournamentDB.getTournaments()){
            System.out.println(tournament.toString());
        }
    }

    public void addPlayer(){
        Player player = askForPlayerDetails();
        playerDB.addPlayerToDB(player);
    }

    public Player askForPlayerDetails(){
        String name = askForName(Console.getStringInput("Player's name: "));
        return new Player(name);
    }

    public String askForName(String name){
        return name;
    }

    public void showPlayers(){
        for(Player player : playerDB.getPlayers()){
            System.out.println(player.toString());
        }
    }

    public Tournament askForTournamentDetails() {
        Date date = askForDate(Console.getStringInput("Tournament date(DD/MM/YYYY) = "));
        int numberOfPlayers = askForNumberOfPlayers(Console.getIntegerInput("Number of players = "));
        int buyIn = askForBuyIn(Console.getIntegerInput("Buy-in = "));
        int totalPot = askForTotalPot(Console.getIntegerInput("Total pot = "));

        Tournament tournament = new Tournament(date, numberOfPlayers, buyIn, totalPot);
        askForTournamentResults(tournament);

        return tournament;
    }

    public void askForTournamentResults(Tournament tournament){
        long tournamentID = tournament.getTournamentID();
        ArrayList<PlayerResult> results = new ArrayList<>();
        for(int i = 0; i < tournament.getNumberOfPlayers(); i++){
            PlayerResult playerResult = askForPlayerResult(tournamentID);
            results.add(playerResult);
        }
        tournament.setPlayerResults(results);
    }

    public PlayerResult askForPlayerResult(long tournamentID){
        Player player;
        String name = askForName(Console.getStringInput("Player's name: "));
        player = checkIfPlayerExistsInDB(name);
        int totalBuyIn = askForBuyIn(Console.getIntegerInput("Player's total Buy-in: "));
        int finalRank = askForFinalRank(Console.getIntegerInput("Player's final rank: "));
        int payout = askForPayout(Console.getIntegerInput("Player's payout: "));

        PlayerResult result = new PlayerResult(tournamentID, player.getPlayerID(), totalBuyIn, finalRank, payout);
        player.myResults.add(result);
        playerResultDB.addResultToDB(result);

        return result;
    }

    public int askForFinalRank(int finalRank){
        return finalRank;
    }

    public int askForPayout(int payout){
        return payout;
    }

    public Player checkIfPlayerExistsInDB(String name){
        for(Player player : playerDB.getPlayers()){
            if(name.equalsIgnoreCase(player.getName())){
                System.out.println(player.toString());
                if(confirmPlayerToUpdate(Console.getStringInput("Is this the player you wish to update?"))){
                    return player;
                } else {
                    System.out.println("Name already exists. Please choose a different name.");
                    String newName = Console.getStringInput("Player's Name: ");
                    Player player1 = checkIfPlayerExistsInDB(newName);
                    return player1;
                }
            }
        }
        Player player = new Player(name);
        playerDB.addPlayerToDB(player);
        return player;
    }

    public boolean confirmPlayerToUpdate(String answer){
        return answer.equalsIgnoreCase("yes");
    }


    public int askForBuyIn(int buyIn){
        return buyIn;
    }

    public int askForNumberOfPlayers(int numberOfPlayers){
        return numberOfPlayers;
    }

    public Date askForDate(String date)  {
        try {
            return new SimpleDateFormat("dd/MM/yyyy").parse(date);
        } catch(Exception e){
            return null;
        }
    }

    public int askForTotalPot(int totalPot){
        return totalPot;
    }



}
