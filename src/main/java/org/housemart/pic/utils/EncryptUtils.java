/**
 * Created on 2013-4-5
 * 
 */
package org.housemart.pic.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtils {

	public static String md5(String input) throws Exception {
		try {
			MessageDigest md = MessageDigest.getInstance(System.getProperty("MD5.algorithm", "MD5"));
			return bytesToHex(md.digest(input.getBytes("utf-8")));

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new Exception("Could not found MD5 algorithm.", e);
		}
	}

	private final static char[] hexDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F'};

	private static String bytesToHex(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		int t;
		for (int i = 0; i < 16; i++) {// 16 == bytes.length;

			t = bytes[i];
			if (t < 0)
				t += 256;
			sb.append(hexDigits[(t >>> 4)]);
			sb.append(hexDigits[(t % 16)]);
		}
		return sb.toString();
	}

}
