package co.home.bussines.model.validator;

import co.home.transversal.exception.ExceptionArgument;

import java.util.Collection;
import java.util.Objects;

public class ArgumentValidator {

    public static void validateRequired(Object value, String message) {
        if(Objects.isNull(value) || value.toString().isEmpty()) {
            throw new ExceptionArgument(message);
        }
    }

    public static <T> Collection<T> getCollectionOrAddDefaultValueToIt(Collection<T> list, T defaultValue) {
        if(list.size() == 0) {
            list.add(defaultValue);
        }
        return list;
    }
}
