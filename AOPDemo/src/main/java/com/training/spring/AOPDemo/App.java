package com.training.spring.AOPDemo;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.training.config.AppConfig;
import com.training.service.TransferService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ConfigurableApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        TransferService service = applicationContext.getBean(TransferService.class);
        
        service.checkBalance("132123");
        service.transfer("123", "123132", 345l);
        service.withdrawl("2345253", 1000l);
        applicationContext.close();
    }
}
