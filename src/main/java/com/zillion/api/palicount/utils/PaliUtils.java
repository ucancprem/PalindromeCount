package com.zillion.api.palicount.utils;

/**
 * @author Prem
 * 
 */
/**
 * @author Prem
 *
 */
/**
 * @author Prem
 *
 */
public class PaliUtils implements Runnable {

	int count = 0;
	String inputString;

	public PaliUtils(String inputString) {
		this.inputString = inputString;
	}

	public int getCount() {
		return count;
	}

	/**
	 * @param char[] char
	 * @param String offset
	 * @param int len
	 * 
	 * Generates all combinations of the char array of length len
	 * 
	 */
	private void generateComb(char[] chars, String offset, int len) {
		if (len == 0) {
			count++;
			return;
		}
		len--;
		for (int i = 0; i < chars.length; i++)
			generateComb(chars, offset + chars[i], len);
	}

	/*
	 * Calls the recursive function that generates all the combination of a given string
	 *  
	 *  Note: We only pass half the length into the combination generator
	 * because we are only interested in generating the first half of the
	 * palindrome stirng , because the second half is equal and to the first in
	 * the reverse order
	 */
	@Override
	public void run() {
		char[] uniqueChars = getUniqueChars(inputString);
		int midPoint = (inputString.length() % 2 == 0) ? inputString.length() / 2
				: (inputString.length() / 2) + 1;
		count = 0;
		generateComb(uniqueChars, "", midPoint);
	}

	/**
	 * @param String
	 * @return char[] Returns unique characters in a given string
	 */
	private char[] getUniqueChars(String inputString) {

		if (inputString == null || inputString.trim().equals(""))
			return null;
		String uniqueString = "" + inputString.charAt(0);
		for (int i = 1; i < inputString.length(); i++) {
			if (!uniqueString.contains("" + inputString.charAt(i)))
				uniqueString += inputString.charAt(i);
		}
		return uniqueString.toCharArray();
	}

}
