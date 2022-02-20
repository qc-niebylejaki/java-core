package com.qc.proxy;

import java.lang.reflect.Proxy;

public class DynamicProxy {

    @SuppressWarnings("unchecked")
    public <T> T getProxy(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(
                clazz.getClassLoader(),
                new Class[]{clazz},
                new DynamicInvocationHandler(new DocumentPrinterImpl()));
    }
}