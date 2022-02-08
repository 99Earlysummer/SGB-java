package com.sgb.proxy;

import com.sgb.service.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author ***
 * @create 2021-12-27 10:30
 * 工具类  执行代理类 ;获取User service得代理类对象
 * 动态代理不需要原始被代理对象  动态创建新的代理对象
 */
public class UserServiceCGLIBProxy {
    /**
     * 获取代理类
     *
     * @param clazz 被代理类(原始方法类)得字节码对象
     * @return
     */
    public static UserService createUserServiceCGIBProxy(Class clazz) {
        Enhancer enhancer = new Enhancer();
        //被代理类是代理类的父类--确定了结构
        enhancer.setSuperclass(clazz);
        //增强方法
        enhancer.setCallback(
                new MethodInterceptor() {//这是个拦截器 拦截被代理类得原始方法即没有增强得方法 拦截下来后对这个方法进行增强

                    @Override
                    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                        //Object o: 代理类对象
                        // Method method:被代理类的原始方法
                        // Object[] args:方法的实际参数
                        // MethodProxy methodProxy:代理类得(增强得)方法

                    //我现在对拦截下来的方法进行增强处理  增强后得加上原始方法就是增强后的方法即在代理类中调用被代理类的对象(执行被代理类)
                        System.out.println("权限校验");
                        Object result=null;
                        //我们只要部分方法增强 因此需要if
                        if ("addUser".equals(method.getName()) || "deleteUser".equals(method.getName())) {
                            //执行被代理类的原始方法(被代理对象,方法实际参数)
                            /** 动态代理不需要原始被代理对象  动态创建新的代理对象  因此clazz不需要
                             invoke = method.invoke(clazz, args);
                             methodProxy.invoke(o,args)执行得是代理类的对象还是不行*/

                            //执行代理类调用父类(即原始方法)因为代理类与被代理类之间是继承关系
                             result = methodProxy.invokeSuper(o, args);
                            System.out.println("日志记录");
                        }else{
                             result = methodProxy.invokeSuper(o, args);
                        }




                        return result;
                    }
                });
        return (UserService) enhancer.create();

        //
    }
}
