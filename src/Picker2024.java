import java.util.ArrayList;

public class Picker2024 {

    ArrayList<Driver> driverList = new ArrayList<>();
    ArrayList<Team> teamList = new ArrayList<>();
    int bestRank;
    int bestValue;
    ArrayList<Driver> bestDrivers = new ArrayList<>();
    ArrayList<Team> bestTeams = new ArrayList<>();

    public Picker2024() {
        createDrivers();
        chooseDrivers();
        System.out.println("Finished - Best Drivers to pick below:");
        printBestDrivers();
    }

    public void createDrivers() {

//        Matthew List
        driverList.add(new Driver("Verstappen", 1, 40));
        driverList.add(new Driver("Hamilton", 2, 30));
        driverList.add(new Driver("Perez", 3, 30));
        driverList.add(new Driver("Russell", 4, 20));
        driverList.add(new Driver("LeClerc", 5, 25));
        driverList.add(new Driver("Alonso", 6, 25));
        driverList.add(new Driver("Sainz", 7, 25));
        driverList.add(new Driver("Norris", 8, 25));
        driverList.add(new Driver("Piastri", 9, 20));
        driverList.add(new Driver("Gasly", 10, 20));
        driverList.add(new Driver("Ocon", 11, 20));
        driverList.add(new Driver("Stroll", 12, 15));
        driverList.add(new Driver("Albon", 13, 15));
        driverList.add(new Driver("Ricciardo", 14, 15));
        driverList.add(new Driver("Tsunoda", 15, 15));
        driverList.add(new Driver("Bottas", 16, 10));
        driverList.add(new Driver("Hulkenberg", 18, 10));
        driverList.add(new Driver("Magnussen", 17, 5));
        driverList.add(new Driver("Zhou", 19, 5));
        driverList.add(new Driver("Seargent", 20, 5));

        teamList.add(new Team("Red Bull", 1, 45));
        teamList.add(new Team("Mercedes", 1, 40));
        teamList.add(new Team("Ferrari", 1, 35));
        teamList.add(new Team("McLaren", 1, 30));
        teamList.add(new Team("Alpine", 1, 20));
        teamList.add(new Team("Aston Martin", 1, 25));
        teamList.add(new Team("Racing Bulls", 1, 10));
        teamList.add(new Team("Williams", 1, 15));
        teamList.add(new Team("Stake", 1, 5));
        teamList.add(new Team("Hass", 1, 5));
    }

    private void chooseDrivers() {
        Team defaultTeam;
        Driver defaultDriver1;
        Driver defaultDriver2;

        for (Team team : teamList) {
            ArrayList<Team> tempTeamList = new ArrayList<>();
            ArrayList<Driver> tempDriverList = new ArrayList<>();
            defaultTeam = team;
            for (Driver driver1 : driverList) {
                defaultDriver1 = driver1;
                for (Driver driver2 : driverList) {
                    defaultDriver2 = driver2;
                    if(defaultDriver1 == defaultDriver2) {
                        continue;
                    }
                    if(team.getValue() + driver1.getValue() + driver2.getValue() <= 100) {
                        if(bestDrivers.size() == 0) {
                            bestDrivers.add(driver1);
                            bestDrivers.add(driver2);
                            bestTeams.add(team);
                        }
                    }
                }
            }
        }

//        for (Driver driver1 : driverList) {
//            for (Driver driver2 : driverList) {
//                if(driver2 == driver1) {
//                    continue;
//                }
//                for (Driver driver3 : driverList) {
//                    if(driver3 == driver2 || driver3 == driver1) {
//                        continue;
//                    }
//                    for (Driver driver4 : driverList) {
//                        if(driver4 == driver3 || driver4 == driver2 || driver4 == driver1) {
//                            continue;
//                        }
//                        for (Driver driver5 : driverList) {
//                            if(driver5 == driver4 || driver5 == driver3 || driver5 == driver2 || driver5 == driver1) {
//                                continue;
//                            }
//                            int totalValue = 0;
//                            totalValue += driver1.getValue();
//                            totalValue += driver2.getValue();
//                            totalValue += driver3.getValue();
//                            totalValue += driver4.getValue();
//                            totalValue += driver5.getValue();
//
//                            int totalRank = 0;
//                            totalRank += driver1.getRank();
//                            totalRank += driver2.getRank();
//                            totalRank += driver3.getRank();
//                            totalRank += driver4.getRank();
//                            totalRank += driver5.getRank();
//
//                            if(totalValue > 60) {
//                                continue;
//                            }
//                            else {
//                                if(bestDrivers.size() == 0) {
//                                    bestDrivers.add(driver1);
//                                    bestDrivers.add(driver2);
//                                    bestDrivers.add(driver3);
//                                    bestDrivers.add(driver4);
//                                    bestDrivers.add(driver5);
//
//                                    bestRank = totalRank;
//                                    bestValue = totalValue;
//
//                                    printBestDrivers();
//                                }
//                                else {
////                                    System.out.println(totalRank + " : " + bestRank);
//                                    if(totalRank < bestRank) {
//                                        bestDrivers.clear();
//                                        bestDrivers.add(driver1);
//                                        bestDrivers.add(driver2);
//                                        bestDrivers.add(driver3);
//                                        bestDrivers.add(driver4);
//                                        bestDrivers.add(driver5);
//
//                                        bestRank = totalRank;
//                                        bestValue = totalValue;
//
//                                        printBestDrivers();
//                                    }
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
    }

    private void printDriverList() {
        for (Driver driver : driverList) {
            System.out.println(driver.getName() + ", " + driver.getRank() + ", " + driver.getValue());
        }
    }

    private void printBestDrivers() {
        for (Driver driver : bestDrivers) {
            System.out.println(driver.getName() + ", " + driver.getRank() + ", " + driver.getValue());
        }
        System.out.println("Best Rank: " + bestRank);
        System.out.println("Value: " + bestValue);
        System.out.println("------------------------------");
    }
}
