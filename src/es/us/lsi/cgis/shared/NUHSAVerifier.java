package es.us.lsi.cgis.shared;

public class NUHSAVerifier {

	//NUHSA Valido: AN0415331870

	
	public static boolean esNUHSAValido(String nuhsa) {
		if (nuhsa.length() != 12 || !nuhsa.substring(0, 2).equals("AN") || !(isNumber(nuhsa.substring(2)))) {
			return false;
		}

		long b =Long.parseLong(nuhsa.substring(2, 10));
		long c = Long.parseLong(nuhsa.substring(10, 12));
		long d;

		if (b < 10000000) {
			d = b + 60 * 10000000;
		}

		else {
			d = Long.parseLong("60" + nuhsa.substring(2, 10));
		}

		return d % 97 == c;
	}

	public static Boolean isNumber(String n) {
		return !Float.isNaN(Float.parseFloat(n));		
		
	}
	
}
