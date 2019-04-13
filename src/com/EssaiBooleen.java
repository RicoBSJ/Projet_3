package com;

public class EssaiBooleen {
	
	public Character[] toCharacterArray( String s ) {

		   if ( s == null ) {
		     return null;
		   }

		   int len = s.length();
		   Character[] array = new Character[len];
		   for (int i = 0; i < len ; i++) {
		      array[i] = new Character(s.charAt(i));
		   }
		   System.out.println(array);
		   return array;
		}

	public static void main(String[] args) {
//		toCharacterArray(s);
	}
}
