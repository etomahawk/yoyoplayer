package com.chinacnd.framework.util;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import org.apache.log4j.Logger;

import java.io.StringReader;
import java.io.StringWriter;

public class TemplateContentProcesser {
    private static Logger log = Logger.getLogger(TemplateContentProcesser.class);
    private static Configuration configuration;

    static {
        configuration = new Configuration();
        configuration.setClassForTemplateLoading(TemplateContentProcesser.class, "/com/yinhoo/framework/util");
        configuration.setObjectWrapper(new DefaultObjectWrapper());
        configuration.setTagSyntax(Configuration.SQUARE_BRACKET_TAG_SYNTAX);
        configuration.setDefaultEncoding("UTF-8");
        configuration.setWhitespaceStripping(true);
    }

    @SuppressWarnings("unchecked")
    public static String processTemplate(String content, Object parameter) {
        try {
            StringReader reader = new StringReader(content);
            Template template = new Template("string template", reader, configuration);
            StringWriter writer = new StringWriter();
            template.process(parameter, writer);
            return writer.toString();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new TemplateContentProcesserException(e);
        }
    }

    private static class TemplateContentProcesserException extends RuntimeException {
        private TemplateContentProcesserException(Throwable cause) {
            super(cause);
        }
    }
}
