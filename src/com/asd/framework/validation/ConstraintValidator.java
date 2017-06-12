package com.asd.framework.validation;

import com.asd.framework.error.ErrorMessage;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/**
 * Created by 985552 on 6/12/2017.
 */
public interface ConstraintValidator<T> {
    public Map<Boolean, List<ErrorMessage>> validate(Annotation annotation, Object obj, List<ErrorMessage> messages);
}
