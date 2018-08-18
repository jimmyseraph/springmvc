package com.testops.tr02.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {
    public static String toMD5String(String text){
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(text.getBytes("utf-8"));
            int c;
            for(int i = 0; i < bytes.length; i++){
                c = bytes[i] < 0 ? 256+bytes[i] : bytes[i];
                result = result + (Integer.toHexString(c).length() <= 1 ?
                "0" + Integer.toHexString(c) : Integer.toHexString(c));
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }
}
