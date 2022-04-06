import java.util.ArrayList;

public class Picker {

    ArrayList<Driver> driverList = new ArrayList<>();
    int bestRank;
    int bestValue;
    ArrayList<Driver> bestDrivers = new ArrayList<>();

    public Picker() {
        createDrivers();
        chooseDrivers();
        System.out.println("Finished - Best Drivers to pick below:");
        printBestDrivers();
    }

    public void createDrivers() {

//        Matthew List
//        driverList.add(new Driver("Hamilton", 1, 45));
//        driverList.add(new Driver("Verstappen", 2, 45));
//        driverList.add(new Driver("Russell", 3, 30));
//        driverList.add(new Driver("LeClerc", 4, 35));
//        driverList.add(new Driver("Perez", 5, 35));
//        driverList.add(new Driver("Sainz", 6, 35));
//        driverList.add(new Driver("Norris", 7, 35));
//        driverList.add(new Driver("Ricciardo", 8, 30));
//        driverList.add(new Driver("Gasly", 9, 25));
//        driverList.add(new Driver("Vettel", 10, 20));
//        driverList.add(new Driver("Alonso", 11, 30));
//        driverList.add(new Driver("Ocon", 12, 25));
//        driverList.add(new Driver("Bottas", 13, 15));
//        driverList.add(new Driver("Stroll", 14, 15));
//        driverList.add(new Driver("Tsunoda", 15, 20));
//        driverList.add(new Driver("Albon", 16, 10));
//        driverList.add(new Driver("Latifi", 17, 10));
//        driverList.add(new Driver("Magnussen", 18, 5));
//        driverList.add(new Driver("Schumacher", 19, 5));
//        driverList.add(new Driver("Guanyu", 20, 5));

//      Dad List
        driverList.add(new Driver("Hamilton", 1, 45));
        driverList.add(new Driver("Verstappen", 2, 45));
        driverList.add(new Driver("Russell", 7, 30));
        driverList.add(new Driver("LeClerc", 6, 35));
        driverList.add(new Driver("Perez", 3, 35));
        driverList.add(new Driver("Sainz", 4, 35));
        driverList.add(new Driver("Norris", 5, 35));
        driverList.add(new Driver("Ricciardo", 10, 30));
        driverList.add(new Driver("Gasly", 8, 25));
        driverList.add(new Driver("Vettel", 12, 20));
        driverList.add(new Driver("Alonso", 9, 30));
        driverList.add(new Driver("Ocon", 11, 25));
        driverList.add(new Driver("Bottas", 13, 15));
        driverList.add(new Driver("Stroll", 15, 15));
        driverList.add(new Driver("Tsunoda", 14, 20));
        driverList.add(new Driver("Albon", 16, 10));
        driverList.add(new Driver("Latifi", 17, 10));
        driverList.add(new Driver("Magnussen", 19, 5));
        driverList.add(new Driver("Schumacher", 18, 5));
        driverList.add(new Driver("Guanyu", 20, 5));

    }

    private void chooseDrivers() {
        for (Driver driver1 : driverList) {
            for (Driver driver2 : driverList) {
                if(driver2 == driver1) {
                    continue;
                }
                for (Driver driver3 : driverList) {
                    if(driver3 == driver2 || driver3 == driver1) {
                        continue;
                    }
                    for (Driver driver4 : driverList) {
                        if(driver4 == driver3 || driver4 == driver2 || driver4 == driver1) {
                            continue;
                        }
                        for (Driver driver5 : driverList) {
                            if(driver5 == driver4 || driver5 == driver3 || driver5 == driver2 || driver5 == driver1) {
                                continue;
                            }
                            int totalValue = 0;
                            totalValue += driver1.getValue();
                            totalValue += driver2.getValue();
                            totalValue += driver3.getValue();
                            totalValue += driver4.getValue();
                            totalValue += driver5.getValue();

                            int totalRank = 0;
                            totalRank += driver1.getRank();
                            totalRank += driver2.getRank();
                            totalRank += driver3.getRank();
                            totalRank += driver4.getRank();
                            totalRank += driver5.getRank();

                            if(totalValue > 60) {
                                continue;
                            }
                            else {
                                if(bestDrivers.size() == 0) {
                                    bestDrivers.add(driver1);
                                    bestDrivers.add(driver2);
                                    bestDrivers.add(driver3);
                                    bestDrivers.add(driver4);
                                    bestDrivers.add(driver5);

                                    bestRank = totalRank;
                                    bestValue = totalValue;

                                    printBestDrivers();
                                }
                                else {
//                                    System.out.println(totalRank + " : " + bestRank);
                                    if(totalRank < bestRank) {
                                        bestDrivers.clear();
                                        bestDrivers.add(driver1);
                                        bestDrivers.add(driver2);
                                        bestDrivers.add(driver3);
                                        bestDrivers.add(driver4);
                                        bestDrivers.add(driver5);

                                        bestRank = totalRank;
                                        bestValue = totalValue;

                                        printBestDrivers();
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
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
