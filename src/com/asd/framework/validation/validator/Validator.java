package com.asd.framework.validation.validator;

import com.asd.framework.error.ErrorMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by 985552 on 6/12/2017.
 */
public interface Validator<T> {
    static final String CAUSED_MESSAGE = "Caused by invalid field value";
    public ErrorMessage validate(T t);
}
