package it.discovery.config;

import it.discovery.Profiles;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;
import java.util.Objects;

public class CurrentProfileCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        Map<String, Object> attributes = annotatedTypeMetadata.
                getAnnotationAttributes(ConditionOnCurrentProfile.class.getName());
        Profiles value = (Profiles) attributes.get("value");
        String currentProfile = conditionContext.getEnvironment().
                getProperty("current.profile", Profiles.DEV.name());

        return Objects.equals(value.name(), currentProfile);
    }
}
