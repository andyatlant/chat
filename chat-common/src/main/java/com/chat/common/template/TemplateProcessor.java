package com.chat.common.template;

import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public interface TemplateProcessor {
    public String process(String resourcePath, Map<String, Object> parameters);
}
