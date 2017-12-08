package com.pmz.humble.utils;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Hex;

/**
 * @author pasko
 *
 */
public final class StringUtils {

	private static final String ENCODING_UTF8 = "UTF-8";

	/**
	    * Encodes the given string by using the hexadecimal representation of its UTF-8 bytes.
	    *
	    * @param s The string to encode.
	    * @return The encoded string.
	    */
	    public static String utf8HexEncode(String s) {
	        if (s == null) {
	            return null;
	        }
	        byte[] utf8;
	        try {
	            utf8 = s.getBytes(ENCODING_UTF8);
	        } catch (UnsupportedEncodingException x) {
	            throw new RuntimeException(x);
	        }
	        return String.valueOf(Hex.encodeHex(utf8));
	    }

	    /**
	     * Decodes the given string by using the hexadecimal representation of its UTF-8 bytes.
	     *
	     * @param s The string to decode.
	     * @return The decoded string.
	     * @throws Exception If an error occurs.
	     */
	    public static String utf8HexDecode(String s) throws Exception {
	        if (s == null) {
	            return null;
	        }
	        return new String(Hex.decodeHex(s.toCharArray()), ENCODING_UTF8);
	    }
	    
	    public static String encrypt(String s) {
	        if (s == null) {
	            return null;
	        }
	        try {
	            return "enc:" + StringUtils.utf8HexEncode(s);
	        } catch (Exception e) {
	            return s;
	        }
	    }

	    public static String decrypt(String s) {
	        if (s == null) {
	            return null;
	        }
	        if (!s.startsWith("enc:")) {
	            return s;
	        }
	        try {
	            return StringUtils.utf8HexDecode(s.substring(4));
	        } catch (Exception e) {
	            return s;
	        }
	    }
}
