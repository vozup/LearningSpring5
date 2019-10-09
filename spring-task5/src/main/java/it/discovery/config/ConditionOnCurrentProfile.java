package it.discovery.config;

import it.discovery.Profiles;
import org.springframework.context.annotation.Conditional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Conditional(CurrentProfileCondition.class)
public @interface ConditionOnCurrentProfile {
    public Profiles value();
}
