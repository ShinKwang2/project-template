package com.app.global.util;

import com.app.global.error.ErrorCode;
import com.app.global.error.exception.AuthenticationException;
import com.app.global.jwt.constant.GrantType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

public class AuthorizationHeaderUtils {
    public static void validateAuthorization(String authorizationHeader) {

        // 1. authorizationHeader 필수 체크
        if (!StringUtils.hasText(authorizationHeader)) {
            throw new AuthenticationException(ErrorCode.NOT_EXIST_AUTHORIZATION);
        }

        // 2. authorizationHeader Bearer 체크
        String[] authorizations = authorizationHeader.split(" ");
        if (authorizations.length < 2 || (!GrantType.BEARER.getType().equals(authorizations[0]))) {
            throw new AuthenticationException(ErrorCode.NOT_VALID_BEARER_TYPE);
        }
    }
}
