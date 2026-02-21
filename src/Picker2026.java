import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Picker2026 {

    ArrayList<Driver> driverList = new ArrayList<>();
    ArrayList<Driver> _driverList = new ArrayList<>();
    ArrayList<Team> teamList = new ArrayList<>();
    ArrayList<Team> _teamList = new ArrayList<>();
    int bestRank;
    int bestValue;
    ArrayList<Driver> bestDrivers = new ArrayList<>();
    ArrayList<Team> bestTeams = new ArrayList<>();

    public Picker2026() {
        createDrivers();
        recurseTeams(teamList, new ArrayList<>());
        printBestDrivers();
    }

    public void createDrivers() {

//        Matthew List
        Driver russell = new Driver("Russell", 22, 35);
        Driver leclerc = new Driver("LeClerc", 21, 30);
        Driver verstappen = new Driver("Verstappen", 20, 45);
        Driver antonelli = new Driver("Antonelli", 19, 25);
        Driver norris = new Driver("Norris", 18, 45);
        Driver hamilton = new Driver("Hamilton", 17, 25);
        Driver piastri = new Driver("Piastri", 16, 40);
        Driver bearman = new Driver("Bearman", 15, 15);
        Driver gasly = new Driver("Gasly", 14, 5);
        Driver hadjar = new Driver("Hadjar", 13, 20);
        Driver lawson = new Driver("Lawson", 12, 15);
        Driver sainz = new Driver("Sainz", 11, 25);
        Driver bortoleto = new Driver("Bortoleto", 10, 5);
        Driver ocon = new Driver("Ocon", 9, 10);
        Driver hulkenberg = new Driver("Hulkenberg", 8, 20);
        Driver alonso = new Driver("Alonso", 7, 20);
        Driver albon = new Driver("Albon", 6, 25);
        Driver stroll = new Driver("Stroll", 5, 5);
        Driver bottas = new Driver("Bottas", 4, 5);
        Driver perez = new Driver("Perez", 3, 5);
        Driver lindblad = new Driver("Lindblad", 2, 5);
        Driver colapinto = new Driver("Colapinto", 1, 5);

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
        driverList.add(colapinto);
        driverList.add(lindblad);
        driverList.add(alonso);
        driverList.add(albon);
        driverList.add(hadjar);
        driverList.add(stroll);
        driverList.add(ocon);
        driverList.add(hulkenberg);
        driverList.add(bearman);
        driverList.add(bortoleto);
        driverList.add(bottas);
        driverList.add(perez);

        // Sort the Driver List by rank
        driverList.sort(Comparator.comparingInt(Driver::getRank).reversed());

        teamList.add(new Team("Mercedes", 11, 35, new ArrayList<>(Arrays.asList(russell, antonelli))));
        teamList.add(new Team("Ferrari", 10, 30, new ArrayList<>(Arrays.asList(hamilton, leclerc))));
        teamList.add(new Team("Red Bull", 9, 35, new ArrayList<>(Arrays.asList(verstappen, hadjar))));
        teamList.add(new Team("McLaren", 8, 45, new ArrayList<>(Arrays.asList(norris, piastri))));
        teamList.add(new Team("Haas", 7, 5, new ArrayList<>(Arrays.asList(ocon, bearman))));
        teamList.add(new Team("Audi", 6, 5, new ArrayList<>(Arrays.asList(hulkenberg, bortoleto))));
        teamList.add(new Team("Alpine", 5, 5, new ArrayList<>(Arrays.asList(gasly, colapinto))));
        teamList.add(new Team("Racing Bulls", 4, 10, new ArrayList<>(Arrays.asList(lawson, lindblad))));
        teamList.add(new Team("Williams", 3, 15, new ArrayList<>(Arrays.asList(sainz, albon))));
        teamList.add(new Team("Aston Martin", 2, 10, new ArrayList<>(Arrays.asList(alonso, stroll))));
        teamList.add(new Team("Cadillac", 1, 5, new ArrayList<>(Arrays.asList(bottas, perez))));

        // Sort the Team List by Driver Rank
        teamList.sort(Comparator.comparingInt(Team::getDriverRank).reversed());
    }



    private void printBestDrivers() {
        for (Driver driver : bestDrivers) {
            System.out.println(driver.getName() + ", " + driver.getRank() + ", " + driver.getValue());
        }
        for (Team team : bestTeams) {
            System.out.println(team.getName() + ", " + team.getRank() + "(" + team.getDriverRank() + "), " + team.getValue());
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
//                    && getTeamsValue(_teamList) + tempTeam.getValue() <= 90
                    && getTeamsValue(_teamList) + tempTeam.getValue() <= 110
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
                    && getTotalValue(teamlist, temp) + tempDriver.getValue() <= 120
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
            System.out.print(driver.getName() + " : " + driver.getValue() + "(" + driver.getRank() + ") - ");
        }
        System.out.println("total : " + getDriversValue(drivers) + "(" + getDriversRank(drivers) + ")");
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
