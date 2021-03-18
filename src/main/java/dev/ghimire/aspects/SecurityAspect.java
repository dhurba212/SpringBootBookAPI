package dev.ghimire.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Aspect
public class SecurityAspect {

    //At around is the most powerful advice u can give to a method
    //At around allows u to take in the method being called and then
    //u can edit/View the parameters that were sent to that method and even change them before the advice method is called
    //u can also edit the return
    @Around("authorizedJP()")
    public Object authenticate(ProceedingJoinPoint pjp) throws Throwable//PJP is the method call is passed in
    {
        //these 2 lines of code will guve us access to the HTTP request that was sent to a controller as well as edit any sort of response
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();

        String auth = request.getHeader("Authorization");
        System.out.println(auth);
        System.out.println(pjp.getSignature().toString());
        if(auth !=null && auth.equals("pa$$word")){
            Object obj=pjp.proceed();//this will actually execute the method u intercepted
            //it returns object which is the return of the intercepted method

            return obj;
        }else{//in the case they have improper header i will say thery are not authorized and not execute the function
            response.sendError(401);
            return null;
        }


    }


    @Pointcut("@annotation(dev.ghimire.aspects.Authorized)")
    private void authorizedJP(){}

}
