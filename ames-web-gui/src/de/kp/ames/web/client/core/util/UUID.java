package de.kp.ames.web.client.core.util;
/**
	Copyright (c) 2008, Robert Kieffer
	All rights reserved.

	Redistribution and use in source and binary forms, with or without modification, 
	are permitted provided that the following conditions are met:

    [-] Redistributions of source code must retain the above copyright notice, this list 
     	of conditions and the following disclaimer.
    
    [-] Redistributions in binary form must reproduce the above copyright notice, this list 
        of conditions and the following disclaimer in the documentation and/or other materials 
        provided with the distribution.
        
    [-] Neither the name of Robert Kieffer nor the names of its contributors may be used to 
        endorse or promote products derived from this software without specific prior written permission.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED 
    WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A 
    PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR 
    ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
    TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) 
    HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING 
    NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE 
    POSSIBILITY OF SUCH DAMAGE.

*/

public class UUID {

	private static final char[] CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz".toCharArray(); 
	
	/**
	 * Generate a random uuid of the specified length
	 * 
	 * @param len
	 */
	public static String uuid(int len) {
		return uuid(len, CHARS.length);
	}
	
	/**
	 * Generate a random uuid of the specified length, and radix. Examples:
	 * <ul>
	 * <li>uuid(8, 2) returns "01001010" (8 character ID, base=2)
	 * <li>uuid(8, 10) returns "47473046" (8 character ID, base=10)
	 * <li>uuid(8, 16) returns "098F4D35" (8 character ID, base=16)
	 * </ul>
	 * 
	 * @param len
	 *            the desired number of characters
	 * @param radix
	 *            the number of allowable values for each character (must be <=
	 *            62)
	 */
	public static String uuid(int len, int radix) {

		if (radix > CHARS.length)throw new IllegalArgumentException();

		char[] uuid = new char[len];
		for (int i = 0; i < len; i++) {
			uuid[i] = CHARS[(int)(Math.random()*radix)];
		}

		return new String(uuid);
	
	}
	
	/**
	 * Generate a RFC4122, version 4 ID.
	 */
	public static String uuid() {

		char[] uuid = new char[36];
		int r;

		/* 
		 * rfc4122 requires these characters
		 */
		uuid[8] = uuid[13] = uuid[18] = uuid[23] = '-';
		uuid[14] = '4';

		/* 
		 * Fill in random data.  At i==19 set the high bits of 
		 * clock sequence as per rfc4122, sec. 4.1.5
		 */
		
		for (int i = 0; i < 36; i++) {
			if (uuid[i] == 0) {
				r = (int) (Math.random()*16);
				uuid[i] = CHARS[(i == 19) ? (r & 0x3) | 0x8 : r & 0xf];
			}
		}
		
		return new String(uuid);
	
	}

}
