package com.zxx.dreamland.common;

import org.apache.commons.lang3.StringUtils;

/**
 *
 */
public class CodeValidate {
    public static boolean validateCode(String code,String cacheCode){
        if(StringUtils.isNotBlank(code) && code.equals(cacheCode)){
            return true;
        }
        return false;
    }
}
