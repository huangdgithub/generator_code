package com.mf.glory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyListener implements ApplicationListener<ApplicationReadyEvent> {

	private static Logger logger = LoggerFactory.getLogger(ApplicationReadyListener.class);

	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) {
		logger.warn("\n========================================================\n"
				+ "================Start project successful================"
				+ "\n========================================================\n");
	}

}
