public class PlayerResult {

    private long tournamentID;
    private long playerID;
    private int totalBuyIn;
    private int finalRank;
    private int payout;
    private int profitMargin;

    public PlayerResult(long tournamentID, long playerID, int totalBuyIn, int finalRank, int payout) {
        this.tournamentID = tournamentID;
        this.playerID = playerID;
        this.totalBuyIn = totalBuyIn;
        this.finalRank = finalRank;
        this.payout = payout;
        this.profitMargin = payout - totalBuyIn;
    }

    public long getTournamentID() {
        return tournamentID;
    }

    public long getPlayerID() {
        return playerID;
    }

    public int getTotalBuyIn() {
        return totalBuyIn;
    }

    public int getFinalRank() {
        return finalRank;
    }

    public int getPayout() {
        return payout;
    }

    public int getProfitMargin() {
        return profitMargin;
    }

    public String toString(){
        StringBuilder output = new StringBuilder();
        output.append("Tournament ID: ").append(tournamentID).append("\n")
                .append("Player ID: ").append(playerID).append("\n")
                .append("Total Buy-in: ").append(totalBuyIn).append("\n")
                .append("Final Rank: ").append(finalRank).append("\n")
                .append("Payout: ").append(payout).append("\n")
                .append("Profit Margin: ").append(profitMargin).append("\n");

        return output.toString();
    }

}
