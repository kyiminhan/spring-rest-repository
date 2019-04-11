package com.kyiminhan.mm.spring.config;

import java.nio.charset.StandardCharsets;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;

import lombok.Setter;
import nz.net.ultraq.thymeleaf.LayoutDialect;

/**
 * The Class AppConfig.</BR>
 *
 * @author KYIMINHAN </BR>
 * @version 1.0 </BR>
 * @since 2019/04/11 </BR>
 *        spring-rest-crud-demo system </BR>
 *        com.kyiminhan.mm.spring.config </BR>
 *        AppConfig.java </BR>
 */
@Configuration
@EnableWebMvc
@EnableAspectJAutoProxy
@ComponentScan(basePackages = { ConfigConstant.SCAN_PACKAGES_SPRING })
@PropertySource(value = ConfigConstant.APPLICATION_PROP_SOURCE)

/*
 * (non-Javadoc)
 *
 * @see
 * org.springframework.context.ApplicationContextAware#setApplicationContext(org
 * .springframework.context.ApplicationContext)
 */
@Setter(onMethod = @__(@Autowired))
public class AppConfig implements WebMvcConfigurer, ApplicationContextAware {

	/** The application context. */
	private ApplicationContext applicationContext;

	/**
	 * Template resolver.
	 *
	 * @return SpringResourceTemplateResolver
	 */
	@Bean
	public SpringResourceTemplateResolver templateResolver() {
		final SpringResourceTemplateResolver templateResolver = new SpringResourceTemplateResolver();
		templateResolver.setApplicationContext(this.applicationContext);
		templateResolver.setPrefix(ConfigConstant.RESOLVER_PREFIX);
		templateResolver.setSuffix(ConfigConstant.RESOLVER_SUFFIX);
		templateResolver.setTemplateMode(ConfigConstant.HTML5_TEMPLATE_MODE);
		templateResolver.setCharacterEncoding(StandardCharsets.UTF_8.name());
		templateResolver.setCacheable(false);
		return templateResolver;
	}

	/**
	 * Template engine.
	 *
	 * @return SpringTemplateEngine
	 */
	@Bean
	public SpringTemplateEngine templateEngine() {
		final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(this.templateResolver());
		templateEngine.setEnableSpringELCompiler(true);
		templateEngine.addDialect(this.java8TimeDialect());
		templateEngine.addDialect(new LayoutDialect());
		return templateEngine;
	}

	/**
	 * View resolver.
	 *
	 * @return ThymeleafViewResolver
	 */
	@Bean
	public ThymeleafViewResolver viewResolver() {
		final ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setContentType(ConfigConstant.CONTENT_TYPE);
		viewResolver.setTemplateEngine(this.templateEngine());
		return viewResolver;
	}

	/**
	 * Java 8 time dialect.
	 *
	 * @return Java8TimeDialect
	 */
	@Bean
	public Java8TimeDialect java8TimeDialect() {
		return new Java8TimeDialect();
	}

	/**
	 * Property sources placeholder configurer.
	 *
	 * @return PropertySourcesPlaceholderConfigurer
	 */
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#
	 * addResourceHandlers(org.springframework.web.servlet.config.annotation.
	 * ResourceHandlerRegistry)
	 */
	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
		registry.addResourceHandler("/static/**").addResourceLocations("/static/").setCachePeriod(31556926);
	}

	/**
	 * Locale resolver.
	 *
	 * @return LocaleResolver
	 */
	@Bean
	public LocaleResolver localeResolver() {
		final CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setCookieMaxAge(24 * 60 * 60);
		localeResolver.setCookieName(ConfigConstant.LOCALE_COOKIE_NAME);
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	/**
	 * Locale change interceptor.
	 *
	 * @return LocaleChangeInterceptor
	 */
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		final LocaleChangeInterceptor changeInterceptor = new LocaleChangeInterceptor();
		changeInterceptor.setParamName(ConfigConstant.LOCAL_PARAM);
		return changeInterceptor;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurer#
	 * addInterceptors(org.springframework.web.servlet.config.annotation.
	 * InterceptorRegistry)
	 */
	@Override
	public void addInterceptors(final InterceptorRegistry registry) {
		registry.addInterceptor(this.localeChangeInterceptor());
	}

	/**
	 * Message source.
	 *
	 * @return MessageSource
	 */
	@Bean
	public MessageSource messageSource() {
		final ResourceBundleMessageSource bundleMessageSource = new ResourceBundleMessageSource();
		bundleMessageSource.setBasenames(new String[] { ConfigConstant.i18n_MESSAGES_PATH });
		bundleMessageSource.setDefaultEncoding(StandardCharsets.UTF_8.name());
		bundleMessageSource.setCacheSeconds(3600);
		return bundleMessageSource;
	}
}