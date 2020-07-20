package Decoders;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner s = new Scanner(System.in);
		
		System.out.println("Lütfen kod çözücünün giriş değerlerini (E,x,y,z) sırasıyla giriniz: ");
		String str = s.next();
		
		// 1. YÖNTEMİN SINIFINI ÇAĞIRMA
		 Decoder d = new Decoder(str);
		 
		 
		// 2. YÖNTEMİN SINIFI ÇAĞIRMA
		 d = new Decoder_Second_Method(str);
	}

}
