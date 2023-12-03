package aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/**
 * @Author 饮木
 * @Date 2022/7/18 18:09
 * @Description 代理类
 */
@Component
@Aspect
public class UserProxy {
    /**
     * 相同切入点的抽取
     */
    @Pointcut(value = "execution(* dao.User.showGame(..))")
    public void point() {
    }

    /**
     * 相同切入点的使用
     */
    @Before(value = "point()")
    public void before() {
        System.out.println("前置通知");
    }

    @After(value = "execution(* dao.User.showGame(..))")
    public void after() {
        System.out.println("最终通知");
    }

    /**
     * 环绕通知
     */
    @Around(value = "execution(* dao.User.showGame(..))")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知前置功能");
        //执行被增强的方法
        Object proceed = joinPoint.proceed(joinPoint.getArgs());
        System.out.println("环绕通知后置功能");
        return proceed;
    }

    /**
     * 后置通知
     */
    @AfterReturning(value = "execution(* dao.User.showGame(..))")
    public void afterReturning() {
        System.out.println("后置通知");
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "execution(* dao.User.showGame(..))")
    public void afterThrowing() {
        System.out.println("异常通知");
    }
}
