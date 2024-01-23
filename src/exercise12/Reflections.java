package exercise12;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Reflections {

    private Reflections() {

    }

    public static String stringify(Object dto) {
        // Möglichkeit 1:
//        Method[] methods = dto.getClass().getDeclaredMethods();
//        Arrays.sort(methods, (o1, o2) -> o1.getName().compareTo(o2.getName()));
        // und jetzt einen Ausgabe-String zusammen"basteln", indem man über methods iteriert,
        // get-Methoden findet, aufruft, etc.


        Method[] methods = dto.getClass().getDeclaredMethods();
        Arrays.sort(methods, (o1, o2) -> o1.getName().compareTo(o2.getName()));


        String output = Arrays.stream(methods)
                .filter(method -> method.getName().startsWith("get") && !method.isAnnotationPresent(SkipStringify.class))
                .map(method -> {
                    try {
                        String propertyName = Character.toLowerCase(method.getName().charAt(3)) + method.getName().substring(4);
                        return propertyName + "=" + method.invoke(dto);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                })
                .collect(Collectors.joining(",", "{","}"));

        return dto.getClass().getSimpleName() + output;
    }
        // Möglichkeit 2, eleganter mit Streams, in einem Ausdruck möglich:
//        return Arrays.stream(dto.getClass().getDeclaredMethods())
//                .sorted((m1, m2) -> m1.getName().compareTo(m2.getName()))
        // jetzt hat man einen Stream von Method-Instanzen, die nach Name sortiert sind.
        // Diesen muss man ausfiltern und auf die richtige Rückgabe mappen.
        // Tipp: Sehen Sie sich zum "Einsammeln" als String via .collect
        // die Methode Collectors.joining(String delimiter, String prefix, String suffix) an!

      //  return "TODO, noch nicht implementiert!";
    }
