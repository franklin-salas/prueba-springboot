package com.digicert.prueba.util;

public class StringUtil {
    public static boolean isEmptyOrNull(String value) {
        if (value == null) {
            return true;
        }
       return value.trim().isEmpty();
    }
}
