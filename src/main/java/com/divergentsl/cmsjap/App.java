package com.divergentsl.cmsjap;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.divergentsl.cmsjap.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	MainMenu mainMenu = context.getBean(MainMenu.class);
		mainMenu.startPanel();
    }
}
