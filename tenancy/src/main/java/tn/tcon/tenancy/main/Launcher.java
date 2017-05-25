package tn.tcon.tenancy.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import tn.tcon.tenancy.config.ApplicationConfig;

public class Launcher {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
	}

}
