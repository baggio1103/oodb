package lab7.Testing;

import lab7.db.DbConnect;
import lab7.db.PackageScanning;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
//        System.out.println(compare(PackageScanning.getClasses(), DbConnect.getTables()));
//
//        System.out.println(PackageScanning.getClasses());
//        System.out.println(DbConnect.getTables());
//


        List<String> entities = PackageScanning.getClasses();
        List<String> tables = DbConnect.getTables();

        System.out.println(entities);
        System.out.println(tables);

        System.out.println(" ----------------Fields-------------------");

        List<String> classFields = PackageScanning.printClassFields();
        List<String> tableColumns = DbConnect.printDatabase();
        tableColumns = modifyNames(tableColumns);

        System.out.println(classFields);
        System.out.println(tableColumns);

        System.out.println(getComparisonResults());

    }

    public static boolean getComparisonResults(){
        List<String> entities = PackageScanning.getClasses();
        List<String> tables = DbConnect.getTables();
        if (compareFields(entities, tables)){
            List<String> classFields = PackageScanning.printClassFields();
            List<String> tableColumns = DbConnect.printDatabase();
            tableColumns = modifyNames(tableColumns);
            return compareFields(classFields, tableColumns);
        }
        return false;
    }

    /**Comparing entities and tables
     * returns true if their names and sizes are the same*/
    public static boolean compareEntities(List<String> entities, List<String> tables){
        if (entities.size() != tables.size()){
            return false;
        }
        int size = entities.size();
        for (int i = 0; i < size; i++){
            if (!entities.get(i).equalsIgnoreCase(tables.get(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean compareFields(List<String>classFields, List<String> tableColumns){
        for (int i = 0; i < classFields.size(); i++){
            if (!classFields.contains(tableColumns.get(i)) && tableColumns.contains(classFields.get(i))){
                return false;
            }
        }
        return true;
    }

    public static String cutString(String word){
        int index = 0;
        String temp = "";
        index = word.indexOf('_');
        if (word.contains("_id")){
            for (int i = 0; i < index; i++){
                temp += word.charAt(i);
            }
        }else {
            for (int i = 0; i < word.length(); i++){
                if (i != index) {
                    temp += word.charAt(i);
                }
            }
        }
        return temp;
    }

    public static List<String> modifyNames(List<String> list){
        List<String> names = new ArrayList<>();
        for (String word : list){
            names.add(cutString(word));
        }
        return names;
    }

}
