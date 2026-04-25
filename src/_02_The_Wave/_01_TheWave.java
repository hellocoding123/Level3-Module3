package _02_The_Wave;

import java.util.ArrayList;

public class _01_TheWave {
    /*
     * Background:
     * https://en.wikipedia.org/wiki/Wave_%28audience%29 
     * 
     * Task:
     * Your task is to create a function that turns a string into a Wave.
     * You will be passed a string and you must return that string in an
     * ArrayList where an uppercase letter is a person standing up.
     * Example:
     * wave("hello") => "Hello", "hEllo", "heLlo", "helLo", "hellO"
     * 
     * 1. The input string will always be lower case but maybe empty.
     * 2. If the character in the string is whitespace then pass over it as
     *    if it was an empty seat.
     */
    
    public static ArrayList<String> wave(String str) {
    	
    	ArrayList<String> wave = new ArrayList<String>();
    	
    	StringBuilder builder = new StringBuilder(str);
    	
    	int gap = 0;
    	String gapSpace = "";
    	
    	for(int i = 0; i < str.length(); i++) {
    		if(str.charAt(i) == ' ') {
    			if(!(i == 0)) {
    				gap++;
    				gapSpace+=" ";
    			}
    			continue;
    		}
    		else {
    			if(i == 0) {
        			wave.add(builder.replace(i, i+1, ""+gapSpace+Character.toUpperCase(str.charAt(i))).toString());
        		}
        		else {
        			wave.add(builder.replace(i-gap-1, i+1, ""+Character.toLowerCase(str.charAt(i-gap-1))+gapSpace+Character.toUpperCase(str.charAt(i))).toString().toString());
        		}
        		
    			gap = 0;
    			gapSpace = "";
    		}
    	}
    	System.out.println(gap);
    	
    	for(int i = 0; i < wave.size(); i++) {
    		System.out.println(wave.get(i));
    	}
    	
        return wave;
    }
}
