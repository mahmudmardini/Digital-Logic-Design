package _18670310077_Mahmud_Mardini;
import java.util.Scanner;

public class _18670310077_Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		System.out.println("Lütfen kod çözücünün giriş değerlerini (E,x,y,z) sırasıyla giriniz: ");
		String str = s.next();
		
		
		
		// NOT: programı 2 yöntem ile yaptım, ama DÖĞRU ve ANA YÖNTEM İSE 1. YÖNTEMDİR..
		// 2. YÖNTEMİ SADECE BINARY SAYILARININ DEĞERLERİİNİ TOPLAYARAK YAPILABİLİR Mİ DİYE DENEMEK İSTEDİM
		// VE KOD DOĞRU BİR ŞEKİLDE ÇALIŞTI..
		
		// 2.YÖNTEMİN KODU ÇALIŞTIRMAK İSTEMİYORSANIZ 'false' YERİNE 'true' YAZARAK İPTAL EDEBİLİRSİNİZ
		// ama false değeri varken zaten hem 1. hem de 2. yöntemlerin kodu çalışır..
		
	   if(false) {
		   
		_18670310077_Decoder d = new _18670310077_Decoder(str);
		 
	   }else {
		   
		try {
		 _18670310077_Second_Method d = new _18670310077_Second_Method(str);
		 
		}catch(java.lang.NumberFormatException e){
			e.getMessage();
		}
	   }
}
}