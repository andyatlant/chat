package com.chat.common.template;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Locale;
import java.util.Map;


/**
 *
 */
public class TemplateProcessorImpl implements TemplateProcessor {
    private static final Logger logger = LoggerFactory.getLogger(TemplateProcessorImpl.class);
    private final Configuration cfg;

    public TemplateProcessorImpl() {
        cfg = new Configuration(Configuration.VERSION_2_3_21);
        cfg.setDefaultEncoding(StandardCharsets.UTF_8.displayName());
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setTemplateLoader(new ClassPathTemplateLoader());
    }

    @Override
    public String process(String resourcePath, Map<String, Object> parameters) {
        Template template = loadTemplate(resourcePath);
        return resolve(template, parameters);

    }

    private Template loadTemplate(String resourcePath) {
        try {
            return cfg.getTemplate(resourcePath);
        } catch (IOException e) {
            logger.error("Failed to load template from: " + resourcePath, e);
            throw new RuntimeException(e);
        }
    }

    private String resolve(Template template, Map<String, Object> parameters) {
        // TODO Implements resolve
        return null;
    }
}
