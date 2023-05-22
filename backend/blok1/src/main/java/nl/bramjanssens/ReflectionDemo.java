package nl.bramjanssens;

import nl.bramjanssens.oo.Bier;
import nl.bramjanssens.oo.HackDezeMaar;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectionDemo {

    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {
        Bier b1 = new Bier();

        // Reflection API:
        Class<Bier> bierType = Bier.class;
        for (Field f : bierType.getDeclaredFields()) {
            System.out.println(f.getName());
            if (f.getName().equals("naam") && f.getType().equals(String.class)) {
                if (f.getAnnotation(HackDezeMaar.class) != null) {
                    f.setAccessible(true);
                    f.set(b1, "dit is gehackt");
                }
            }
        }
        System.out.println(b1);

        Constructor<Bier> noArgCtor = bierType.getDeclaredConstructor();
        Constructor<Bier> twoArgCtor = bierType.getDeclaredConstructor(String.class, Double.class);

        Bier bier = noArgCtor.newInstance();
        System.out.println(bier);
    }
}
