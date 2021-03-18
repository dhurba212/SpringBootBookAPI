package dev.ghimire.aspects;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect//Spring AOP uses aspectj
public class LoggingAspect {

    private static int counter =0;

    //advice method
    @Before("logPointCut()")
    public void logRequest(){
        System.out.println("Total HTTP calls: "+ ++counter);
    }

    @After("logPointCut()")
    public void after(){
        System.out.println("i run after");
        System.out.println("Total HTTP calls: "+ ++counter);
    }

    //pointcut expression selecting all methods in the controller
    @Pointcut("execution(* dev.ghimire.controllers.BookController.*(..))")
    private void logPointCut(){};


}
