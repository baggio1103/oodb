package lab6;

import lab6.annotation.Column;
import lab6.annotation.Entity;
import lab6.bank.Client;
import lab6.bank.Person;
import lab6.graph.EntityNode;
import lab6.graph.GraphModel;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public class PackageScanning {

    public static String PATH_FOR_SCAN = "lab6.hotel";

    public static void main(String[] args) {
        System.out.println("-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");
        /* Просканируем пакет PATH_FOR_SCAN для поиска классов (включая вложенные пакеты)  */
        System.out.println("STEP 1: scan package " + PATH_FOR_SCAN+":");

        List<Class<?>> classList = PathScan.find(PATH_FOR_SCAN);

        classList.forEach(c->System.out.println("\t" + c.getSimpleName().toLowerCase()));

        System.out.println("\n-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

        System.out.println("STEP 2: scan class fields:");
        for (Class<?> cl : classList) {
            /* Сканируем поля классов */
            System.out.println("\tFields of class " + cl.getName());

            for (Field field : cl.getDeclaredFields()) {
                System.out.println("\t\t" + field.getName() + " of type " + field.getType().getCanonicalName());
            }
        }

        System.out.println("\n-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

        System.out.println("STEP 3: scan class methods:");
        for (Class<?> cl : classList) {
            /* Сканируем методы классов */
            System.out.println("\tMethods of class " + cl.getName());
            Method[] methods = cl.getMethods();
            for (Method method : methods) {
                System.out.println("\t\t" + method.getName());
            }
        }

        System.out.println("\n-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

        System.out.println("STEP 4: scan class annotations:");
        for (Class<?> c : classList) {
            System.out.println(c.getName()+ ":");
            Annotation[] annotations = c.getAnnotations();
            for (Annotation a : annotations) {
//                if (a.annotationType().equals(Entity.class)) {
//                    System.out.println();
//                }
                System.out.println(a.annotationType());
            }
        }

        System.out.println("\n-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");


        System.out.println("STEP 5: scan fields annotations:");

        Field[] fields = lab6.hotel.Client.class.getDeclaredFields();
        for (Field f : fields) {
            Annotation[] fannotations = f.getAnnotations();
            for (Annotation a : fannotations) {
                if (a.annotationType().equals(Column.class)) {
                    System.out.printf("\tField %s %s is attribute!%n", f.getType().getName(),f.getName());
                }
            }
        }

        System.out.println("\n-=-=-=-=-=-=-=-=-=-=--=-=-=-=-=-=-=-=-=-=-=-=-=-=\n");

        System.out.println("STEP 6: get superclass:");

        Class superClass = Client.class.getSuperclass();
        System.out.println("\tSuper class of Client is " + superClass.getName());

        superClass = Person.class.getSuperclass();
        System.out.println("\tSuper class of Person is " + superClass.getName());
    }

}


