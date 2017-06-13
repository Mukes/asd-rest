package com.asd.framework.validation;

import com.asd.framework.error.ErrorMessage;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

public interface ConstraintValidator<T> {
    static final String CAUSED_MESSAGE = "Caused by invalid field value";

    public ErrorMessage validate(Field field, Annotation annotation, Object obj);
}

