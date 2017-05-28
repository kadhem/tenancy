package tn.tcon.tenancy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages= "tn.tcon.tenancy", excludeFilters = @Filter({Controller.class, Configuration.class}))
public class ApplicationConfig {

}

