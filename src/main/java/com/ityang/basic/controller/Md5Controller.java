package com.ityang.basic.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.security.MessageDigest;

@Api(value = "Md5加密解密", tags = "Md5加密解密", description = "Md5加密解密")
@RestController
@RequestMapping("/md5")
@Slf4j
public class Md5Controller {


    @PostMapping("getMd5")
    @ApiOperation("获取Md5")
    public String getMd5(@ApiParam("str") @RequestBody String str) throws Exception {
        return encrypt(str);
    }

    @PostMapping("getDecMd5")
    @ApiOperation("获取Md5解密")
    public String getDecMd5(@ApiParam("str") @RequestBody String str) throws Exception {
        return decrypt(str);
    }

    public String encrypt(String str) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("MD5");
        digest.update(str.getBytes());
        BigInteger integer = new BigInteger(1, digest.digest());
        log.info(integer.toString());
        log.info(integer.toString(16));
        return integer.toString(16);
    }

    public String decrypt(String str) throws Exception {
        BigInteger integer = new BigInteger(str, 16);
        StringBuffer hexValue = new StringBuffer();
        byte[] bytes = integer.toByteArray();
        for (int i = 0; i < bytes.length; i++) {
            int val = ((int) bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static String convertMD5(String inStr) throws Exception {
        char[] chars = inStr.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] ^ 't');
        }
        return new String(chars);
    }
}
