package tradearea.model;

public class PreferenceVotes {
    private int listNumber;
    private String personName;
    private int voteCount;

    // Constructor
    public PreferenceVotes(int listNumber, String personName, int voteCount) {
        this.listNumber = listNumber;
        this.personName = personName;
        this.voteCount = voteCount;
    }

    // Getters and Setters
    public int getListNumber() {
        return listNumber;
    }

    public void setListNumber(int listNumber) {
        this.listNumber = listNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public int getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(int voteCount) {
        this.voteCount = voteCount;
    }
}
