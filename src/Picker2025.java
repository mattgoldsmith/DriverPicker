import java.util.ArrayList;
import java.util.Arrays;

public class Picker2025 {

    ArrayList<Driver> driverList = new ArrayList<>();
    ArrayList<Driver> _driverList = new ArrayList<>();
    ArrayList<Team> teamList = new ArrayList<>();
    ArrayList<Team> _teamList = new ArrayList<>();
    int bestRank;
    int bestValue;
    ArrayList<Driver> bestDrivers = new ArrayList<>();
    ArrayList<Team> bestTeams = new ArrayList<>();

    public Picker2025() {
        createDrivers();
        recurseTeams(teamList, new ArrayList<>());
        printBestDrivers();
    }

    public void createDrivers() {

//        Matthew List
        Driver norris = new Driver("Norris", 20, 45);
        Driver hamilton = new Driver("Hamilton", 19, 30);
        Driver piastri = new Driver("Piastri", 18, 40);
        Driver leclerc = new Driver("LeClerc", 17, 40);
        Driver verstappen = new Driver("Verstappen", 16, 45);
        Driver russell = new Driver("Russell", 15, 30);
        Driver lawson = new Driver("Lawson", 14, 5);
        Driver antonelli = new Driver("Antonelli", 13, 5);
        Driver gasly = new Driver("Gasly", 12, 15);
        Driver sainz = new Driver("Sainz", 11, 25);
        Driver doohan = new Driver("Doohan", 10, 5);
        Driver tsunoda = new Driver("Tsunoda", 9, 15);
        Driver alonso = new Driver("Alonso", 8, 20);
        Driver albon = new Driver("Albon", 7, 10);
        Driver hadjar = new Driver("Hadjar", 6, 5);
        Driver stroll = new Driver("Stroll", 5, 10);
        Driver ocon = new Driver("Ocon", 4, 10);
        Driver hulkenberg = new Driver("Hulkenberg", 3, 15);
        Driver bearman = new Driver("Bearman", 2, 5);
        Driver bortoleto = new Driver("Bortoleto", 1, 5);

        driverList.add(norris);
        driverList.add(hamilton);
        driverList.add(piastri);
        driverList.add(leclerc);
        driverList.add(verstappen);
        driverList.add(russell);
        driverList.add(lawson);
        driverList.add(antonelli);
        driverList.add(gasly);
        driverList.add(sainz);
        driverList.add(doohan);
        driverList.add(tsunoda);
        driverList.add(alonso);
        driverList.add(albon);
        driverList.add(hadjar);
        driverList.add(stroll);
        driverList.add(ocon);
        driverList.add(hulkenberg);
        driverList.add(bearman);
        driverList.add(bortoleto);

        teamList.add(new Team("McLaren", 10, 45, new ArrayList<>(Arrays.asList(norris, piastri))));
        teamList.add(new Team("Ferrari", 9, 45, new ArrayList<>(Arrays.asList(hamilton, leclerc))));
        teamList.add(new Team("Red Bull", 8, 40, new ArrayList<>(Arrays.asList(verstappen, lawson))));
        teamList.add(new Team("Mercedes", 7, 35, new ArrayList<>(Arrays.asList(russell, antonelli))));
        teamList.add(new Team("Alpine", 6, 15, new ArrayList<>(Arrays.asList(gasly, doohan))));
        teamList.add(new Team("Racing Bulls", 5, 5, new ArrayList<>(Arrays.asList(tsunoda, hadjar))));
        teamList.add(new Team("Williams", 4, 10, new ArrayList<>(Arrays.asList(sainz, albon))));
        teamList.add(new Team("Aston Martin", 3, 20, new ArrayList<>(Arrays.asList(alonso, stroll))));
        teamList.add(new Team("Haas", 2, 10, new ArrayList<>(Arrays.asList(ocon, bearman))));
        teamList.add(new Team("Stake", 1, 5, new ArrayList<>(Arrays.asList(hulkenberg, bortoleto))));
    }



    private void printBestDrivers() {
        for (Driver driver : bestDrivers) {
            System.out.println(driver.getName() + ", " + driver.getRank() + ", " + driver.getValue());
        }
        for (Team team : bestTeams) {
            System.out.println(team.getName() + ", " + team.getRank() + ", " + team.getValue());
        }
        System.out.println("Best Rank: " + bestRank);
        System.out.println("Value: " + bestValue);
        System.out.println("------------------------------");
    }

    //region Teams
    private void recurseTeams(ArrayList<Team> teams, ArrayList<Team> current) {
        for (int i = 0; i < teams.size(); i++) {
            _teamList = new ArrayList<>(current);
            Team tempTeam = teams.get(i);
            if (!_teamList.contains(tempTeam)
                    && getTeamsValue(_teamList) + tempTeam.getValue() <= 90
            ) {
                _teamList.add(tempTeam);
//                printTeams(_teamList);
                recurseDrivers(driverList, new ArrayList<>(), _teamList);
                recurseTeams(teams, _teamList);

            }
        }
    }

    private void printTeams(ArrayList<Team> teams) {
        for (Team team : teams) {
            System.out.print(team.getName() + " : " + team.getValue() + " - ");
        }
        System.out.println("total : " + getTeamsValue(teams));
    }

    private Integer getTeamsValue(ArrayList<Team> teams) {
        int total = 0;
        for (Team team : teams) {
            total += team.getValue();
        }
        return total;
    }

    private Integer getTeamsRank(ArrayList<Team> teams) {
        int total = 0;
        for (Team team : teams) {
            total += team.getRank();
        }
        return total;
    }

    private Integer getTeamsDriverRank(ArrayList<Team> teams) {
        int total = 0;
        for (Team team :
                teams) {
            total += team.getDriverRank();
        }
        return total;
    }

    private boolean teamsHasDriver(ArrayList<Team> teams, Driver driver) {
        for (Team team : teams) {
            if(team.hasDriver(driver)) {
                return true;
            }
        }
        return false;
    }
    //endregion

    //region Drivers
    private void recurseDrivers(ArrayList<Driver> drivers, ArrayList<Driver> current, ArrayList<Team> teamlist) {
        for (int i = 0; i < drivers.size(); i++) {
            ArrayList<Driver> temp = new ArrayList<>(current);
            Driver tempDriver = drivers.get(i);
            if (!temp.contains(tempDriver)
//                    && !teamsHasDriver(teamlist, tempDriver)
                    && getTotalValue(teamlist, temp) + tempDriver.getValue() <= 100
                    && (getTotalRank(teamlist, temp) + tempDriver.getRank() > getTotalRank(bestTeams, bestDrivers)
                )
            ) {
                temp.add(tempDriver);
                bestTeams = teamlist;
                bestDrivers = temp;
                bestRank = getTotalRank(teamlist, temp);
                bestValue = getTotalValue(teamlist, temp);
                printBestDrivers();
//                printDrivers(temp);
                recurseDrivers(drivers, temp, teamlist);
            }
        }
    }

    private void printDrivers(ArrayList<Driver> drivers) {
        for (Driver driver : drivers) {
            System.out.print(driver.getName() + " : " + driver.getValue() + " - ");
        }
        System.out.println("total : " + getDriversValue(drivers));
    }

    private Integer getDriversValue(ArrayList<Driver> drivers) {
        int total = 0;
        for (Driver driver : drivers) {
            total += driver.getValue();
        }
        return total;
    }

    private Integer getDriversRank(ArrayList<Driver> drivers) {
        int total = 0;
        for (Driver driver : drivers) {
            total += driver.getRank();
        }
        return total;
    }
    //endregion

    private Integer getTotalRank(ArrayList<Team> teams, ArrayList<Driver> drivers) {
        return getTeamsDriverRank(teams) + getDriversRank(drivers);
    }
    private Integer getTotalValue(ArrayList<Team> teams, ArrayList<Driver> drivers) {
        return getTeamsValue(teams) + getDriversValue(drivers);
    }

    //region Debug
    private void printDriverList() {
        for (Driver driver : driverList) {
            System.out.println(driver.getName() + ", " + driver.getRank() + ", " + driver.getValue());
        }
    }
    private void printTeamsList() {
        for (Team team : teamList) {
            System.out.println(team.getName() + " : " + team.getDriverRank() + ", " + team.getValue());
        }
    }

    private void Test(ArrayList<Integer> nums, ArrayList<Integer> current) {
        for (int i = 0; i < nums.size(); i++) {
            ArrayList<Integer> temp = new ArrayList<>(current);
            if (!temp.contains(nums.get(i))) {
                temp.add(nums.get(i));
                System.out.println("temp : " + temp);
                Test(nums, temp);
            }
        }
    }
    //endregion
}
