package KarnaughMap;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		
		System.out.println("Lütfen Boole fonksiyonunu giriniz:");
		String str = s.nextLine();
		KarnaughMap test = new KarnaughMap(str);
	}

}
