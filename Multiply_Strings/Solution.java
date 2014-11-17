class Solution {
	public String multiply(String num1, String num2) {
		num1 = new StringBuilder(num1).reverse().toString();
		num2 = new StringBuilder(num2).reverse().toString();

		//Length of final result is less than len1+len2.
		//etc. 99x99 < 100x100 = 10000, so 4 digit is enough for 99x99
		int[] digitProduct = new int[num1.length() + num2.length()];
		for (int i = 0; i < num1.length(); i++) {
			int a = num1.charAt(i) - '0';
			for (int j = 0; j < num2.length(); j++) {
				int b = num2.charAt(j) - '0';
				digitProduct[i + j] += a*b;
				//System.out.println(a + " x " + b + " = " + digitProduct[i+j] + ", added to " + (i+j) + " bit");

			}
		}

		StringBuilder result = new StringBuilder();
		//For each digitProduct, record LSB to result, add carry next bit.
		for (int i = 0; i < digitProduct.length; i++) {
			int digit = digitProduct[i] % 10;
			int carry = digitProduct[i] / 10;
			result.insert(0, digit);
			if (i + 1 < digitProduct.length)
				digitProduct[i + 1] += carry;
		}

		//Trim starting zeros
		while(result.length() > 1 && result.charAt(0) == '0')
			result.deleteCharAt(0);

		return result.toString();
	}

	public static void main (String[] args) {
		String num1 = "128";
		String num2 = "256";
		Solution solution = new Solution();

		System.out.println(num1 + " x " + num2 + " = " + solution.multiply(num1, num2));
	}
}
