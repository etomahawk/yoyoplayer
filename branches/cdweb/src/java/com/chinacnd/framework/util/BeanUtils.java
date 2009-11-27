package com.chinacnd.framework.util;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Dom4JDriver;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.PropertyUtilsBean;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Hades
 */
public class BeanUtils {

    private static org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(BeanUtils.class);

    private static void addAttribute(Map<String, Object> map, String startWith, Method method, Object obj) {
        String methodName = method.getName();
        if (methodName.startsWith(startWith) && methodName.length() > startWith.length()) {
            StringBuilder sb = new StringBuilder(methodName.substring(startWith.length()));
            sb.setCharAt(0, Character.toLowerCase(sb.charAt(0)));
            try {
                Object result = method.invoke(obj);
                if (result != null) {
                    map.put(sb.toString(), result);
                }
            } catch (Exception ex) {
                log.error(null, ex);
            }
        }
    }

    public static Map<String, Object> convertObjectToMap(Object obj) {
        Map<String, Object> map = new HashMap<String, Object>();
        Method[] ms = obj.getClass().getDeclaredMethods();
        for (Method m : ms) {
            if ((m.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) {
                addAttribute(map, "get", m, obj);
                addAttribute(map, "is", m, obj);
            }

        }
        return map;
    }

    public static <T> T newInstance(Class<T> clazz) {
        try {
            return clazz.newInstance();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        assert false : "cannot create new instance for: " + clazz;
        return null;
    }

    public static void copyProperties(Object source, Object target, String... ignoredProperties) {
        try {
            org.springframework.beans.BeanUtils.copyProperties(source, target, ignoredProperties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void deepCopyProperties(Object target, Object resource) {
        PropertyUtilsBean propertyUtils = BeanUtilsBean.getInstance().getPropertyUtils();
        PropertyDescriptor[] srcDescriptors = propertyUtils.getPropertyDescriptors(resource);
        for (PropertyDescriptor origDescriptor : srcDescriptors) {
            String name = origDescriptor.getName();
            if ("class".equals(name)) {
                continue; // No point in trying to set an object's class
            }
            if (propertyUtils.isReadable(resource, name) && propertyUtils.isWriteable(target, name)) {
                try {
                    Object value = propertyUtils.getSimpleProperty(resource, name);
                    propertyUtils.setProperty(target, name, deepClone(value));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T deepClone(T object) {
        if (object == null) {
            return null;
        }
        if (object.getClass().isPrimitive() || object instanceof String) {
            return object;
        }
        XStream xstream = new XStream(new Dom4JDriver());
        String xml = xstream.toXML(object);
        return (T) xstream.fromXML(xml);
    }

    public static Object newInstance(String clazz) {
        try {
            return newInstance(BeanUtils.class.getClassLoader().loadClass(clazz));
        } catch (ClassNotFoundException e) {
            log.error(e.getMessage(), e);
        }
        assert false : "cannot load the class: " + clazz;
        return null;
    }

    public static boolean equals(Object object1, Object object2) {
        if (object1 == object2) {
            return true;
        }
        if (object1 != null) {
            return object1.equals(object2);
        }
        return false;
    }

    //for example  class name:"com.base.class"  file name: "file.xml"
    //return "/com/base/file.xml"
    public static String getURLFromClassName(String className, String fileName) {
        className = className.replaceAll("\\.", "/");
        String filePath = className.substring(0, className.lastIndexOf("/") + 1) + fileName;
        return "/" + filePath;
    }
}
