package com.kyiminhan.mm.spring.config;

/**
 * The Interface ConfigConstant.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/04/11 </BR>
 *        spring-rest-crud-demo system </BR>
 *        com.kyiminhan.mm.spring.config </BR>
 *        ConfigConstant.java </BR>
 */
public interface ConfigConstant {

	/** The application prop source. */
	String APPLICATION_PROP_SOURCE = "classpath:application.properties";

	/** The db prop source. */
	String DB_PROP_SOURCE = "classpath:db.properties";

	/** The scan packages spring. */
	String SCAN_PACKAGES_SPRING = "com.kyiminhan.mm.spring";

	/** The scan packages spring repo. */
	String SCAN_PACKAGES_SPRING_REPO = "com.kyiminhan.mm.spring.repo";

	/** The resolver prefix. */
	String RESOLVER_PREFIX = "/WEB-INF/views/";

	/** The resolver suffix. */
	String RESOLVER_SUFFIX = ".html";

	/** The html5 template mode. */
	String HTML5_TEMPLATE_MODE = "HTML5";

	/** The content type. */
	String CONTENT_TYPE = "text/html; charset=UTF-8";

	/** The i 18 n MESSAGE S PATH. */
	String i18n_MESSAGES_PATH = "i18n/messages";

	/** The local param. */
	String LOCAL_PARAM = "lang";

	/** The locale cookie name. */
	String LOCALE_COOKIE_NAME = "locale";

	/** The scan packages spring entity. */
	String SCAN_PACKAGES_SPRING_ENTITY = "com.kyiminhan.mm";
}