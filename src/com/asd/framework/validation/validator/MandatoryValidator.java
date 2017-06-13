package com.asd.framework.validation.validator;

import java.lang.annotation.Annotation;

public class MandatoryValidator implements Validator {

    @Override
    public boolean validate(Annotation annotation, Object obj) {
        if (obj != null && !((String) obj).isEmpty()) {
            return true;
        }
        return false;
    }
}
