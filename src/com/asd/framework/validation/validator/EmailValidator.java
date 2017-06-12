package com.asd.framework.validation.validator;

import com.asd.framework.error.ErrorMessage;
import com.asd.framework.error.ErrorSource;
import com.asd.framework.validation.ConstraintValidator;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by 985552 on 6/12/2017.
 */
public class EmailValidator<T> implements Validator<T> {

    @Override
    public Map<Boolean, List<ErrorMessage>> validate(Object obj) {
        Pattern pattern;
        Matcher matcher;
            if (obj != null) {
                if (!obj.toString().isEmpty()) {
                    String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[a-z]{2,3}+)*(\\.[a-z]{2,3})$";
                    pattern = Pattern.compile(EMAIL_REGEX);
                    matcher = pattern.matcher(obj.toString());
                    if (!matcher.matches()) {
                        new ErrorMessage(ErrorSource.FIELD_ERROR, field.getName(),
                                String.format("%s is invalid", field.getName()),
                                CAUSED_MESSAGE);
                        result = false;
                    }
                }
            }
        map.put(result, errorMessages);
        System.out.println("Validation Result:" + result);
        return map;
    }
}
