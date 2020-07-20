package _18670310077_Mahmud_Mardini;

public class _18670310077_Second_Method extends _18670310077_Decoder{
	
	// 2. YÖNTEM DEĞİŞKENLERİ
		private int[] num = new int[3];
		private int sum, output;
				
	_18670310077_Second_Method(String str){
		super(str);
		
		// kullanıcı tarafından girilen değişkenlerinde bir hata yoksa ve değişkenler doğru bir şekilde girilmiş ise
		// kodu uygula, yoksa zaten kullandığım Bad_input adlı istisna sınfıyla kullanıcıya bir mesaj gösterilecektir.
		if(error == 0)  decode();
		System.out.println(" \n");
	}
	

	public void decode(){
		int E, x, y, z;
		
		E = Integer.parseInt(vars[0]);
		x = Integer.parseInt(vars[1]);
		y = Integer.parseInt(vars[2]);
		z = Integer.parseInt(vars[3]);
		
		
		// BINARY GİRİŞLERİN değerlerini hesaplıyorum ve toplamı "sum" değişkene atıyorum.
		// Yani girişler aktif (1) ise sırasıyla 2^(x) + yani 2^(y) + yani 2^(z) şeklinde hesaplayarak
		// hangi minTerm oluştuğunu bulabilmek için değerleri toplıyorum.
		// Girişler aktif değilse yani 0 ise değeri zaten 0 olacak ve hesaplanmayacaktır.
		
		if(error == 0) {
		if(x == 1)  num[0] = (int) Math.pow(2, 2);
		if(y == 1)	num[1] = (int) Math.pow(2, 1);
	    if(z == 1)  num[2] = (int) Math.pow(2, 0);

		for(int i =0 ; i<3 ; i++) {
			sum += num[i];
		}
		
		// İzin girişi 0 olduğu halde girişlerin değerleri ne olursa olsun çıkışlar 0 olacaktır.
		// İzin girişi 1 olduğunda, minterimlerini tek tek kontrol ediyorum
		// girişlerin değerlerinin toplamı tutulan minterime eşit olduğulduğunda çıkış aktif olacaktır.
		// aksi takdirde çıkış passive olacaktır.
		System.out.println("\n2. YÖNTEMİ İLE");
		for(int minTerm=0 ; minTerm<8 ; minTerm++) {
		if(E != 0) {
			
			if(minTerm == sum) {
				output = 1;
			}else {
				output = 0;
			}
			
		}else {
			output = 0;
			}
		
		System.out.print(output);
		
		if(minTerm<7) System.out.print(","); // Bu if statement sadece fazla virgül yazdırmamak için kullanıldı..
		
		}
		}
	}
	
}
