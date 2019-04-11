package com.kyiminhan.mm.spring.config;

public interface ConfigConstant {
	String APPLICATION_PROP_SOURCE = "classpath:application.properties";
	String DB_PROP_SOURCE = "classpath:db.properties";
	String SCAN_PACKAGES_SPRING = "com.kyiminhan.mm.spring";
	String SCAN_PACKAGES_SPRING_REPO = "com.kyiminhan.mm.spring.repo";
	String RESOLVER_PREFIX = "/WEB-INF/views/";
	String RESOLVER_SUFFIX = ".html";
	String HTML5_TEMPLATE_MODE = "HTML5";
	String CONTENT_TYPE = "text/html; charset=UTF-8";
	String i18n_MESSAGES_PATH = "i18n/messages";
	String LOCAL_PARAM = "lang";
	String LOCALE_COOKIE_NAME = "locale";
	String SCAN_PACKAGES_SPRING_ENTITY = "com.kyiminhan.mm";
}