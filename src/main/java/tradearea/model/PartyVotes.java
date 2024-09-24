package tradearea.model;

public class PartyVotes {
    private String partyID;
    private int amountVotes;

    // Constructor, Getters, and Setters
    public PartyVotes(String partyID, int amountVotes) {
        this.partyID = partyID;
        this.amountVotes = amountVotes;
    }

    public int getAmountVotes() {
        return amountVotes;
    }

    public void setAmountVotes(int amountVotes) {
        this.amountVotes = amountVotes;
    }

    public String getPartyID() {
        return partyID;
    }

    public void setPartyID(String partyID) {
        this.partyID = partyID;
    }
}
