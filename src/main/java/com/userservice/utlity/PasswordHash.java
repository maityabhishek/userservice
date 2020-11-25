package com.userservice.utlity;
import java.math.BigInteger;  
import java.nio.charset.StandardCharsets; 
import java.security.MessageDigest;  
import java.security.NoSuchAlgorithmException;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
@Component
public class PasswordHash {
	
	private  byte[] getSHA(String input) throws NoSuchAlgorithmException 
    {   
        MessageDigest md = MessageDigest.getInstance("SHA-256");  
        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
    } 
	private  String toHexString(byte[] hash) 
    { 
        BigInteger number = new BigInteger(1, hash);  
        StringBuilder hexString = new StringBuilder(number.toString(16));  

        while (hexString.length() < 32)  
        {  
            hexString.insert(0, '0');  
        }  
  
        return hexString.toString();  
    } 
	public  String hash(String s) throws NoSuchAlgorithmException
	{
		return toHexString(getSHA(s));
	}

}
