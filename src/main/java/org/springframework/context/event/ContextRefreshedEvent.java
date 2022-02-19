package org.springframework.context.event;

import org.springframework.context.ApplicationContext;

public class ContextRefreshedEvent extends ApplicationContextEvent {

	public ContextRefreshedEvent(ApplicationContext source) {
		super(source);
	}
}
