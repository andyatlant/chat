package com.chat.common.template;

import freemarker.cache.URLTemplateLoader;

import java.net.URL;

/**
 *
 */
class ClassPathTemplateLoader extends URLTemplateLoader {

    @Override
    protected URL getURL(String path) {
        return getClass().getClassLoader().getResource(path);
    }
}
