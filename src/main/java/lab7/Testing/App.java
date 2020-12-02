package lab7.Testing;

import lab7.db.DbConnect;
import lab7.db.PackageScanning;

public class App {

    private static final String domain = "lab7.hotel";

    /** ClassNames are equal to tables */

    public static void main(String[] args) {
        printClasses();
    }

    public static void printClasses(){
        System.out.println("---------------Table names-------------------");
        DbConnect.getTables().forEach(System.out::println);
        System.out.println("---------------Class names-------------------");
        PackageScanning.getClasses().forEach(System.out::println);
        System.out.println("----------------------------------------------");
    }

    public static void printFields(){
        System.out.println("---------------Table columns-------------------");
    }


}
