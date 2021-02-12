package br.com.project.springboot.login.util;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import org.apache.tomcat.util.codec.binary.Base64;

public class Encrypt {
	
	public static String encrypt(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {		
        return new Base64().encodeToString(password.getBytes());
	}

}
