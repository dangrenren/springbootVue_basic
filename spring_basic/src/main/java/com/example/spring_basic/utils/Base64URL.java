package com.example.spring_basic.utils;
//import com.qiniu.util.Base64;

import org.apache.commons.codec.binary.Base64;
//import java.util.Base64;

/**
 * public class Base64URL {
 * public static byte[] base64EncodeUrl(byte[] input) {
 * byte[] base64 = new String(Base64.encode(input, Base64.NO_WRAP)).getBytes();
 * for (int i = 0; i < base64.length; ++i) {
 * switch (base64[i]) {
 * case '+':
 * base64[i] = '*';
 * break;
 * case '/':
 * base64[i] = '-';
 * break;
 * case '=':
 * base64[i] = '_';
 * break;
 * default:
 * break;
 * }
 * }
 * return base64;
 * }
 * }
 **/

public class Base64URL {
    public static byte[] base64EncodeUrl(byte[] input) {
        byte[] base64 = Base64.encodeBase64(input);//我换了别的base64库来实现编码
        //byte[] base64 = Base64.getEncoder().encode(input);
        for (int i = 0; i < base64.length; ++i) {
            switch (base64[i]) {
                case '+':
                    base64[i] = '*';
                    break;
                case '/':
                    base64[i] = '-';
                    break;
                case '=':
                    base64[i] = '_';
                    break;
                default:
                    break;
            }
        }
        return base64;
    }
}
