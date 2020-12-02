//package lab6;
//
//import lab6.PathScan;
//import lab6.annotation.Column;
//import lab6.annotation.Entity;
//import lab6.bank.Client;
//import lab6.bank.Person;
//import lab6.graph.GraphModel;
//
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Field;
//import java.lang.reflect.Method;
//import java.util.List;
//
//public class ClassScanning {
//
//    public static String PATH_FOR_SCAN = "lab6.bank";
//
//    public static void main(String[] args) {
//
//        GraphModel graph = new GraphModel();
//
//        /* Сканируем пакет PATH_FOR_SCAN для поиска классов-сущностей  */
//        System.out.println("Step 1:");
//        List<Class<?>> classList = PathScan.find(PATH_FOR_SCAN);
//        classList.stream().filter(ClassScanning::classIsEntity).forEach(c -> System.out.println("\t" + c.getSimpleName().toLowerCase()));
//
//        System.out.println("STEP 2: scan class fields:");
//        for (Class<?> cl : classList) {
//            /* Сканируем поля классов */
//            System.out.println("\tFields of class " + cl.getName());
//            Field[] fields = cl.getDeclaredFields();
//            for (Field field : fields) {
//                System.out.println("\t\t" + field.getName());
//            }
//        }
//
//        System.out.println("STEP 3: scan class methods:");
//        for (Class<?> cl : classList) {
//            /* Сканируем методы классов */
//            System.out.println("\tFields of class " + cl.getName());
//            Method[] methods = cl.getMethods();
//            for (Method method : methods) {
//                System.out.println("\t\t" + method.getName());
//            }
//        }
//
//        System.out.println("STEP 4: scan class annotations:");
//        Annotation[] annotations = Person.class.getAnnotations();
//        if (annotations != null) {
//            for (Annotation a : annotations) {
//                if (a.annotationType().equals(Entity.class)) {
//                    System.out.println("\tPerson is entity!");
//                }
//            }
//        }
//
//        System.out.println("STEP 5: scan fields annotations:");
//
//        Field[] fields = Person.class.getDeclaredFields();
//        for (Field f : fields) {
//            Annotation[] fAnnotations = f.getAnnotations();
//            for (Annotation a : fAnnotations) {
//                if (a.annotationType().equals(Column.class)) {
//                    System.out.println(String.format("\tField %s %s is attribute!", f.getType().getName(),f.getName()));
//                }
//            }
//        }
//
//        System.out.println("STEP 6: get superclass:");
//
//        Class superClass = Client.class.getSuperclass();
//        System.out.println("\tSuper class of Client is " + superClass.getName());
//
//        superClass = Person.class.getSuperclass();
//        System.out.println("\tSuper class of Person is " + superClass.getName());
//    }
//
//    private static boolean classIsEntity(Class<?> c) {
//        Annotation[] annotations = c.getAnnotations();
//        for (Annotation a : annotations) {
//            if (a.equals(Entity.class)) {
//                return true;
//            }
//        }
//        return false;
//    }
//
//    private static void addEntityToGraph(Class<?> c, GraphModel graph) {
//
//    }
//
//
//}
