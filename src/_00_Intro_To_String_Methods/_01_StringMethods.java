package _00_Intro_To_String_Methods;

import java.util.Base64;

/*
 * Visit the JavaDocs for the String class to view everything you can do with a String.
 * https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
 * https://docs.oracle.com/javase/7/docs/api/java/lang/Character.html
 *
 * HINT:  Here are some String methods you might find useful 
 * contains
 * replace
 * trim
 * length
 * getBytes
 * endsWith
 * split 
 * indexOf
 * lastIndexOf
 * compareTo(IgnoreCase)
 * substring
 * toUpperCase/toLowerCase
 * valueOf
 *
 * Here are some Character methods you might find useful:
 * Character.toLowerCase(char c);
 * Character.toUpperCase(char c);
 * Character.isLetter(char c);
 * Character.isDigit(char c);
 * Character.getNumericValue(char c);
 */

public class _01_StringMethods {

    // Given Strings s1 and s2, return the longer String
    public static String longerString(String s1, String s2) {
    	
    	if(s1.length() > s2.length()) {
    		return s1;
    	}
    	
        return s2;
    }

    // If String s contains the word "underscores", change all of the spaces
    // to underscores
    public static String formatSpaces(String s) {
    	String str = s;
    	if(str.contains("underscores")) {
    		str=str.replace(" ", "_");
    	}
    	
        return str;
    }

    // Return the name of the person whose LAST name would appear first if they
    // were in alphabetical order.
    // You cannot assume there are no extra spaces around the name, but you can
    // assume there is only one space between the first and last name
    public static String lineLeader(String s1, String s2, String s3) {
    	
    	String[] str1 = s1.trim().split(" ");
    	String[] str2 = s2.trim().split(" ");
    	String[] str3 = s3.trim().split(" ");
    	
    	String[] lastName = str1;
    	
    	if(str2[1].compareTo(lastName[1]) < 1) {
    		lastName = str2;
    	}
    	if(str3[1].compareTo(lastName[1]) < 1) {
    		lastName = str3;
    	}
    	
        return lastName[0] + " " + lastName[1];
    }

    // Return the sum of all numerical digits in the String
    public static int numeralSum(String s) {
    	char[] strChar = s.toCharArray();
    	int sum = 0;
    	
    	for(int i = 0; i < strChar.length; i++) {
    		if(Character.isDigit(strChar[i])) {
    			sum += Character.getNumericValue(strChar[i]);
    		}
    	}

    	return sum;
    }

    // Return the number of times String substring appears in String s
    public static int substringCount(String s, String substring) {
    	int subLength = substring.length();
    	char[] strChar = s.toCharArray();
    	int repeats = 0;
    	
    	for(int i = 0; i < strChar.length; i++) {
    		if(strChar[i] == substring.charAt(0)) {
    			if(s.substring(i, i+subLength).equals(substring)) {
    				System.out.println(s.substring(i, i+subLength - 1));
    				repeats++;
    			}
    		}
    	}
    	
        return repeats;
    }

    // Call Utilities.encrypt at the bottom of this file to encrypt String s
    public static String encrypt(String s, char key) {
    	
    	byte[] byteArr = s.getBytes();
    	
    	return Utilities.encrypt(byteArr, (byte)key);
        
    }

    // Call Utilities.decrypt at the bottom of this file to decrypt the
    // cyphertext (encrypted text)
    public static String decrypt(String s, char key) {
        
    	return Utilities.decrypt(s, (byte)key);
    }

    // Return the number of words in String s that end with String substring
    // You can assume there are no punctuation marks between words
    public static int wordsEndsWithSubstring(String s, String substring) {
    	int count = 0;
        String[] strArr = s.trim().split(" ");
        
        for(int i = 0; i < strArr.length; i++) {
        	if(strArr[i].length()>=substring.length()) {
	        	if(strArr[i].substring(strArr[i].length() - substring.length()).equals(substring)) {
	        		count++;
	        	}
        	}
        }
        
		return count;
    }

    // Given String s, return the number of characters between the first
    // occurrence of String substring and the final occurrence
    // You can assume that substring will appear at least twice
    public static int distance(String s, String substring) {
    	int firstIndex;
    	int lastIndex;
    	
    	firstIndex = s.indexOf(substring) + substring.length();
    	
    	lastIndex = s.lastIndexOf(substring);
    	
        return lastIndex-firstIndex;
    }

    // Return true if String s is a palindrome
    // palindromes are words or phrases are read the same forward as backward.
    // HINT: ignore/remove all punctuation and spaces in the String
    public static boolean palindrome(String s) {
    	
    	String strFixed = "";
    	char[] charArr = s.trim().toCharArray();
    	String flipped = "";
    	
    	for(int i = 0; i < charArr.length; i++) {
    		if(Character.isLetter(charArr[i])) {
    			strFixed += charArr[i];
    		}
    	}
    	
    	char[] charArrFixed = strFixed.toCharArray();
    	
    	//remove punctuation first
    	
    	for(int i2 = charArrFixed.length-1; i2 >= 0; i2--) {
    		flipped += charArrFixed[i2];
    	}
    	
    	flipped = flipped.toLowerCase();
    	strFixed = strFixed.toLowerCase();
    	System.out.println(flipped);
    	System.out.println(strFixed);
    	if(flipped.equals(strFixed)) {
    		
    		return true;
    		
    	} else {
    	
    		return false;
    		
    	}
    }
}

class Utilities {
    // This basic encryption scheme is called single-byte xor. It takes a
    // single byte and uses exclusive-or on every character in the String.
    public static String encrypt(byte[] plaintext, byte key) {
        for (int i = 0; i < plaintext.length; i++) {
            plaintext[i] = (byte) (plaintext[i] ^ key);
        }
        return Base64.getEncoder().encodeToString(plaintext);
    }

    public static String decrypt(String cyphertext, byte key) {
        byte[] b = Base64.getDecoder().decode(cyphertext);
        for (int i = 0; i < b.length; i++) {
            b[i] = (byte) (b[i] ^ key);
        }
        return new String(b);
    }
}
