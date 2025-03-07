import java.util.ArrayList;

public class Team {

    private String name;
    private int rank;
    private int value;
    private ArrayList<Driver> drivers;

    public Team(String name, int rank, int value) {
        this.name = name;
        this.rank = rank;
        this.value = value;
    }

    public Team(String name, int rank, int value, ArrayList<Driver> drivers) {
        this.name = name;
        this.rank = rank;
        this.value = value;
        this.drivers = drivers;
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

    public int getDriverRank() {
        int total = 0;
        for (Driver driver : drivers) {
            total += driver.getRank();
        }
        return total;
    }

    public boolean hasDriver(Driver driver) {
        return drivers.contains(driver);
    }
}
