package com.sontekin.fid.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Aspect
public class CounterAspect {

    private static final Logger LOGGER = LoggerFactory.getLogger(CounterAspect.class);
    private static final Map<String, Integer> conterMap = new HashMap<>();

    @Pointcut("@annotation(Counter)")
    public void executeCounter(){};

    @Before(value = "executeCounter()")
    public void countCounter(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getDeclaringType() + "." + joinPoint.getSignature().getName();
        StringBuilder message = new StringBuilder("Method: ");
        message.append(methodName).append(" called: ");
        int callCount = 1;
        if(conterMap.containsKey(methodName)){
            callCount = conterMap.get(methodName) + 1;
        }
        conterMap.put(methodName, callCount);
        message.append(callCount).append(" time(s)");

        LOGGER.info(message.toString());
    }
}
