package cw.sas;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by Kithmal on 11/7/2015.
 */
public class SpringPropertyUtil extends PropertyPlaceholderConfigurer {

    /* map to hold the properties. */
    private static Map<String, String> propertiesMap;

    /* Default as in PropertyPlaceholderConfigurer */
    private int springSystemPropertiesMode = SYSTEM_PROPERTIES_MODE_FALLBACK;

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#setSystemPropertiesMode
     * (int)
     */
    @Override
    public void setSystemPropertiesMode(int systemPropertiesMode) {

        super.setSystemPropertiesMode(systemPropertiesMode);
        springSystemPropertiesMode = systemPropertiesMode;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * org.springframework.beans.factory.config.PropertyPlaceholderConfigurer#processProperties(org
     * .springframework.beans.factory.config.ConfigurableListableBeanFactory, java.util.Properties)
     */
    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props) throws BeansException {

        super.processProperties(beanFactory, props);

        propertiesMap = new HashMap<String, String>();
        for (Object key : props.keySet()) {

            String keyStr = key.toString();
            String valueStr = resolvePlaceholder(keyStr, props, springSystemPropertiesMode);
            propertiesMap.put(keyStr, valueStr);
        }
    }

    /**
     * Get the value of the property for given key.
     *
     * @param name property key name.
     * @return value of the property for given key.
     */
    public static String getProperty(String name) {

        return propertiesMap.get(name).toString();
    }
}
