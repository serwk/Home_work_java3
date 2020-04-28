package HomeWork7;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            start(MyClass.class);
            start(MyClassWithException.class);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void start (Class c) throws Exception{
        Object testObj = c.newInstance();
        Method[] methods = c.getDeclaredMethods();
        List<Method> testMethods = new ArrayList<>();
        Method beforeMethod = null;
        Method afterMethod = null;
        for (Method o : c.getDeclaredMethods()) {
            if (o.isAnnotationPresent(Test.class)) {
                testMethods.add(o);
            }
            if (o.isAnnotationPresent(BeforeSuite.class)) {
                if (beforeMethod == null) {
                    beforeMethod = o;
                } else {
                    throw new RuntimeException("More than one method with the annotation BeforeSuite");
                }
            }
            if (o.isAnnotationPresent(AfterSuite.class)) {
                if (afterMethod == null) {
                    afterMethod = o;
                } else {
                    throw new RuntimeException("More than one method with the annotation AfterSuite");
                }
            }
        }

        Collections.sort(testMethods, new Comparator<Method>() {
            public int compare(Method o1, Method o2) {
                return o2.getAnnotation(Test.class).priority()-o1.getAnnotation(Test.class).priority();
            }
        });

        if (beforeMethod != null) {
            beforeMethod.invoke(testObj);
        }
        for (Method o : testMethods) {
            o.invoke(testObj);
        }
        if (afterMethod != null) {
            afterMethod.invoke(testObj);
        }
    }
}
