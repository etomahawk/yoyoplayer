package com.chinacnd.framework.struts.converter;

import com.chinacnd.framework.util.StringUtils;
import org.apache.struts2.util.StrutsTypeConverter;

import java.util.Map;

/**
 * @author Hades
 */
public class EnumConverter extends StrutsTypeConverter {
    @SuppressWarnings("unchecked")
    public Object convertFromString(Map context, String[] values, Class toClass) {
        if (!StringUtils.hasText(values[0])) return null;
        return Enum.valueOf(toClass, values[0]);
    }

    public String convertToString(Map context, Object object) {
        if (object == null) return "";
        return object.toString();
    }
}
