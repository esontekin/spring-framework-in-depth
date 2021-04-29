package com.sontekin.fid;

import com.sontekin.fid.service.GreetingService;
import com.sontekin.fid.service.OutputService;
import com.sontekin.fid.service.TimeService;

public class Application {

    public static void main(String[] args) throws Exception {
        GreetingService greetingService = new GreetingService("Hello");
        TimeService timeService = new TimeService(true);
        OutputService outputService = new OutputService(greetingService, timeService);

        for (int i = 0; i < 5; i++){
            outputService.generateOutput("Emrullah");
            Thread.sleep(5_000);
        }
    }
}
