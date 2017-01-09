package cw.sas;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by User on 1/10/2017.
 */
public abstract class LazyBeanUtils {

    public static Object copyBean(final Class<?> clazz, final Object source) {

        Object destination = null;
        try {

            destination = clazz.newInstance();
            PropertyUtils.copyProperties(destination, source);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {

            destination = null;
        }

        return destination;
    }
}
