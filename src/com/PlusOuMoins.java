package com;

import java.util.Random;

public class PlusOuMoins extends Game {

	public void jouer() {

	    int[] random = new int[4];
	    int i = 0;
	    boolean equals;
	    @SuppressWarnings("unused")
		Random rand = new Random(); {
	         
	    	//write\\
	    	while(i != 4) {
	            random[i] = (int)(Math.random()*4);
	            equals = false;
	            for(int j = 0; j != i; j++) {
	                if(random[j] == random[i]) {
	                    equals = true;
	                }
	            }
	            if(!equals) {
	                i++;
	            }
	        }
	        //write\\
	 
	        //read\\
	        for(int k = 0; k != 4; k++) {
	            System.out.print(random[k]);
	        }
	        //read\\
	    }
	}
}