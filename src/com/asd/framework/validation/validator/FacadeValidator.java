package com.asd.framework.validation.validator;

import com.asd.framework.error.ErrorMessage;
import com.asd.framework.validation.AdapterValidator;
import com.asd.framework.validation.ConstraintValidator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 985552 on 6/12/2017.
 */
public class FacadeValidator<T> implements Validator<T>{
    @Override
    public Map<Boolean, List<ErrorMessage>> validate(T t) {
        Map map = new HashMap<>();
        List<ErrorMessage> errorMessages = new ArrayList<>();
        //ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        boolean result = true;
        Class clazz = t.getClass();
        for (Field field : clazz.getDeclaredFields()) {
            for (Annotation annotation : field.getAnnotations()) {
                field.setAccessible(true);
                Object obj = null;

                try {
                    obj = field.get(t);
                } catch (IllegalArgumentException | IllegalAccessException e) {
                    e.printStackTrace();
                }

                ConstraintValidator<T> constraintValidator = new AdapterValidator();
                constraintValidator.validate(annotation, obj, errorMessages);
                // Email Validation

            }

        }
       /* String json = null;
        if (!result) {

            try {
                json = ow.writeValueAsString(errorMessages);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            System.out.println("Validation Errors:" + json);
            //return new ValidationHandler(json);

        }*/
        map.put(result, errorMessages);
        System.out.println("Validation Result:" + result);
        return map;
    }
}
