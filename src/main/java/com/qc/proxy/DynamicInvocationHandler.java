package com.qc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class DynamicInvocationHandler implements InvocationHandler {

    private Object implementation;

    public DynamicInvocationHandler(Object implementation) {
        this.implementation = implementation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getDeclaringClass().getSimpleName() + "." + method.getName() + "()");
        Method methodToInvoke = Arrays.stream(implementation.getClass().getMethods())
                .filter(m -> m.getName().equals(method.getName()))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);

        System.out.println(methodToInvoke.getDeclaringClass().getSimpleName() + "." + methodToInvoke.getName() + "()");
        return methodToInvoke.invoke(implementation, args);
    }
}
