package it.discovery.bpp;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;

public class InitBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Arrays.stream(bean.getClass().getDeclaredMethods())
                .filter(method -> method.getAnnotation(Init.class) != null)
                .forEach(method -> ReflectionUtils.invokeMethod(method, bean));

        return bean;
    }
}
