public class Team {

    private String name;
    private int rank;
    private int value;

    public Team(String name, int rank, int value) {
        this.name = name;
        this.rank = rank;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
}
