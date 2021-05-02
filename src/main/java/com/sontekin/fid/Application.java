package com.sontekin.fid;

import com.sontekin.fid.config.ApplicationConfig;
import com.sontekin.fid.service.OutputService;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {

        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        OutputService outputService = context.getBean(OutputService.class);

        for (int i = 0; i < 5; i++){
            outputService.generateOutput();
            Thread.sleep(5_000);
        }
    }
}
