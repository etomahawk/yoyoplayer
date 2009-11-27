package com.chinacnd.b2b.paper.web.interceptor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RUNTIME)
public @interface NotNeedToLogin {
}
