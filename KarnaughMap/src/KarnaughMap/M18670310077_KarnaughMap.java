package KarnaughMap;

public class M18670310077_KarnaughMap {

	private StringBuilder newTermBuilder;
	private String Func, r="";
	private int[] minTermsValue; 
	private String[] result;
	private String[][] newTerm;
	private int a,b,c,d;
	 
	
	
	M18670310077_KarnaughMap(String str){
		Func = str.toUpperCase();
		M18670310077_inputFunction func = new M18670310077_inputFunction(Func);
		
		minTermsValue = new int[(int)Math.pow(2, func.VariablesCounter())]; // minterimlerin sayısı = 2^(değişken sayısı)
		result = new String[str.length()];
		newTerm = new String[func.terms.length][3];
		System.out.println("A function with " + func.VariablesCounter() + " variables");
		BuildNewTerms(); // YENİ TERİMLERİ OLUŞTURMA METODU
		getMinTerms();	// MİNTERİMLERİN GÖSTERME METODU
		for(int i =0;i<func.terms.length;i++) {
			if(func.VariablesCounter() == 3)withThreeVaraibles (i);
			else if(func.VariablesCounter() == 4) withFourVaraibles(i);
		}
			r = r.substring(0, r.length()-2);
		System.out.println("The Result: \nF = " + r);
	}
	
	
	
	
	public void BuildNewTerms() {
		M18670310077_inputFunction func = new M18670310077_inputFunction(Func);
		for(int i =0; i< func.terms.length;i++) {
			newTermBuilder = new StringBuilder("    "); 
			a=-1;b=-1;c=-1;d=-1;		// HANGİ DEĞİŞKERNLER VAR MI YOK MU KONTROL ETMEK AMACIYLA BU 4 DEĞİŞKENİ OLUŞTURDUM
			func.terms[i] = func.terms[i] + "  "; // HATA ÇIKMADAN BÜTÜN İNDEXLERİ KONTROL ETMEK İÇİN HER TERİME 2 BOŞLUK EKLEME
 				for(int j=0;j<func.terms[i].length();j++) {
 					
 					switch (func.terms[i].charAt(j)){ // TERİMDEKİ DEĞİŞKENLERİ TEK TEK KONTROL ETME
 					case 'A' :
 						a=1;
 						if(func.terms[i].charAt(j+1) == '’') { // DEĞİŞKEN MEVCUT İSE SONRAKİ İNDEXİ KONTROL EDİLİR
 							newTermBuilder.setCharAt(0, '0');  // DEĞİLLEME İŞARETİ VARSA YENİ TERİMDE DEĞİŞKENİN YERİNE
 						}else {									// SIFIR ATAR
 							newTermBuilder.setCharAt(0, '1');	// YOKSA 1 ATAR
 						}	// AYNI ADIMLAR DA DİĞER DEĞİŞKENLERE UYGULANIR..
 					break;
 					case 'B' :
 						b=1;
 						if(func.terms[i].charAt(j+1) == '’') {
 							newTermBuilder.setCharAt(1, '0');
 						}else {
 							newTermBuilder.setCharAt(1, '1');
 						}
 						break;
 					
 					case 'C':
 						c=1;
 						if(func.terms[i].charAt(j+1) == '’') {
 							newTermBuilder.setCharAt(2, '0');
 						}else {
 							newTermBuilder.setCharAt(2, '1');
 						}
 						break;
 						
 					case 'D':
 						d=1;
 						if(func.terms[i].charAt(j+1) == '’') {
 							newTermBuilder.setCharAt(3, '0');
 						}else {
 							newTermBuilder.setCharAt(3, '1');
 						}
 						break;
 					}	}	
 				
 				if(a==-1) {  // KONTROL EDİLEN TERİMİN HERHANGİ BİR DEĞİŞKEN EKSİKSE ONUN YERİNE HEM 0 HEM 1 ATMAK AMACIYLA
 							// ONUN YERİNE "-" ATANIR
 					newTermBuilder.setCharAt(0, '-');
 				}if(b==-1&& func.VariablesCounter()>=2) {
 					newTermBuilder.setCharAt(1, '-');
 				}if(c==-1&& func.VariablesCounter()>=3) {
 					newTermBuilder.setCharAt(2, '-');
 				}if(d==-1 && func.VariablesCounter()>=4) {
 					newTermBuilder.setCharAt(3, '-');
 				}
 				
 				newTerm[i][2] = newTermBuilder.toString().trim();// OLUŞTURULAN YENİ TERİMİN KAYDEDİLMESİ VE BOŞLUKLARIN SİLMESİ
 				
 			// YENİ OLUŞTURULAN TERİMLERN (0 VE 1 ŞEKLİLNDE) GÖRMEK İÇİN BU SATIRI ÇALIŞTIRABİLİRSİNİZ.. 
 	    	//	System.out.println(newTerm[i][2]);   
 				
 				
 				
 				// AŞAĞIDAKİ BLOK KODU HER BİR EKSİK DEĞİŞKENİN ("-") YERİNE HEM 0 HEM 1 ATMASI VE MİNTERİMLERİN OLUŞTURUR
 				
 				for(int j=0;j<=1;j++) {
 					newTerm[i][j] = newTerm[i][2].replaceFirst("-", String.valueOf(j));
 					StringBuilder testStrB = new StringBuilder(newTerm[i][j]);
 					int indexc = testStrB.toString().indexOf('-');
  					for(int w=1;w>=0;w--) {
  						if(indexc>-1)  testStrB.setCharAt(indexc, String.valueOf(w).charAt(0));
  						newTerm[i][w] = testStrB.toString();
  						int indexd = testStrB.toString().indexOf('-');
  			// AŞAĞIDAKİ KOD SADECE 4 DEĞİŞKEN VARKEN ÇALIŞIR
  					if(func.VariablesCounter()>=4) {	for(int x=1;x>=0;x--) { 
  	  						if(indexd>-1)  testStrB.setCharAt(indexd, String.valueOf(x).charAt(0));
  	  						newTerm[i][x] = testStrB.toString();
  	  		// YENİ OLUŞTURULAN TERİMLERN (0 VE 1 ŞEKLİLNDE) GÖRMEK İÇİN BU 2 SATIRI ÇALIŞTIRABİLİRSİNİZ..				
  			//			System.out.println(newTerm[i][x]); 
  			//			System.out.println(newTerm[i][w]);
  						
  						setMinTerms(i,w); 
  						setMinTerms(i,x);
  					}}else {
  						setMinTerms(i,w);
  			// YENİ OLUŞTURULAN TERİMLERN (0 VE 1 ŞEKLİLNDE) GÖRMEK İÇİN BU SATIRI ÇALIŞTIRABİLİRSİNİZ..
  			//			System.out.println(newTerm[i][w]);
  					}
  					} 
 				//	System.out.println(newTerm[i][j]);
 					
 					}
 				}
		}
	
	
	// MİNTERİMLERİN DEĞERLERİ ATMA METODU 
	public void setMinTerms(int i, int j){
		M18670310077_inputFunction func = new M18670310077_inputFunction(Func);
		if(func.VariablesCounter() == 3) { // DEĞİŞKENLERİN SAYISI 3 İSE BU ŞEKİLDE ATANIR
			if(newTerm[i][j].equals("000")) { minTermsValue[0] = 1;}
			else if(newTerm[i][j].equals("001")){minTermsValue[1] = 1;}
			else if(newTerm[i][j].equals("010"))	 {minTermsValue[2] = 1;}
			else if(newTerm[i][j].equals("011"))	 {minTermsValue[3] = 1;}
			else if(newTerm[i][j].equals("100"))	 {minTermsValue[4] = 1;}
			else if(newTerm[i][j].equals("101"))	 {minTermsValue[5] = 1;}
			else if(newTerm[i][j].equals("110"))  {minTermsValue[6] = 1;}
			else if(newTerm[i][j].equals("111"))    {minTermsValue[7] = 1;}
		}else if(func.VariablesCounter()==4) {// DEĞİŞKENLERİN SAYISI 4 İSE BU ŞEKİLDE ATANIR
		
			if(newTerm[i][j].equals("0000")) { minTermsValue[0] = 1;}
			else if(newTerm[i][j].equals("0001")){minTermsValue[1] = 1;}
			else if(newTerm[i][j].equals("0010"))	 {minTermsValue[2] = 1;}
			else if(newTerm[i][j].equals("0011"))	 {minTermsValue[3] = 1;}
			else if(newTerm[i][j].equals("0100"))	 {minTermsValue[4] = 1;}
			else if(newTerm[i][j].equals("0101"))	 {minTermsValue[5] = 1;}
			else if(newTerm[i][j].equals("0110"))  {minTermsValue[6] = 1;}
			else if(newTerm[i][j].equals("0111"))    {minTermsValue[7] = 1;}
			
			else if(newTerm[i][j].equals("1000"))    {minTermsValue[8] = 1;}
			else if(newTerm[i][j].equals("1001"))    {minTermsValue[9] = 1;}
			else if(newTerm[i][j].equals("1010"))    {minTermsValue[10] = 1;}
			else if(newTerm[i][j].equals("1011"))    {minTermsValue[11] = 1;}
			else if(newTerm[i][j].equals("1100"))    {minTermsValue[12] = 1;}
			else if(newTerm[i][j].equals("1101"))    {minTermsValue[13] = 1;}
			else if(newTerm[i][j].equals("1110"))    {minTermsValue[14] = 1;}
			else if(newTerm[i][j].equals("1111"))    {minTermsValue[15] = 1;}
		}
	}
	
	public void getMinTerms() {
		// MİNTERİMLERİN YAZDIRMA METODU
		for(int i =0; i< minTermsValue.length;i+=4) {
			System.out.println(""+"m"+i + " = "  + minTermsValue[i] + "	 m"+(i+1) + " = "  + minTermsValue[i+1] +"  m"+(i+3) + " = "  + minTermsValue[i+3] +"  m"+(i+2) + " = "  + minTermsValue[i+2]);			
			}
	}

	//  MİNTERİMLERİN DEĞERLERİ VE TABLODAKİ 1'LERİ BELİRLEDİKTEN SONRA ARTIK AŞAĞIDAKİ KOD'DA
	// KOMŞULUK ÖZELLİĞİ TAŞIYAN MİNTERİMLRİN GRUPLANDIRMA İŞLEMİ GERÇEKLEŞİR 
	// VE HER GRUBU BELİRLEDİKTEN SONRA GRUPLANDIRILMAYAN MİNTERİM KALIRSA DİĞER MİNTERİMLERİYLE TEKRAR GRUPLANDIRABİLMEK İÇİN
	// HER KULLANILAN MİNTERİMİN DEĞERİ ARTAR VE TEKRAR KULLANABİLMEK İÇİN AŞAĞIDAKİ İF STATEMENTS KULLANDIM...
	
	// İLK ÖNCE  EN BÜYÜK GRUBLARA ONDAN SONRA DAHA KÜÇÜK GRUPLARA BAKAR VE HER MİNTERİM İÇİN
	//   KOMŞULUK ÜZELLİĞİ TAŞIYAN MİNTERİMLERE TEK TEK KONTROL EDELİR...
	
	public void withThreeVaraibles (int i) {
		// BU METOD SADECE 3 DEĞİŞKENLİ FONKSİYONLAR İÇİN ÇALIŞIR
		// 4'LÜK KARELERİ GRUPLANDIRMA
		if(minTermsValue[0] == 1 && minTermsValue[1]== 1 && minTermsValue[2]== 1 && minTermsValue[3] == 1 ||
		   minTermsValue[0] == 1 && minTermsValue[1]>= 1 && minTermsValue[2]>= 1 && minTermsValue[3] >= 1 ||
		   minTermsValue[0] >= 1 && minTermsValue[1]== 1 && minTermsValue[2]>= 1 && minTermsValue[3] >= 1 ||
		   minTermsValue[0] >= 1 && minTermsValue[1]>= 1 && minTermsValue[2]== 1 && minTermsValue[3] >= 1 ||
		   minTermsValue[0] >= 1 && minTermsValue[1]>= 1 && minTermsValue[2]>= 1 && minTermsValue[3] == 1 ) 
		{
			result[i] = "A’"; minTermsValue[0]++;minTermsValue[1]++;minTermsValue[2]++;minTermsValue[3]++;
		}
	else if(minTermsValue[4] == 1 && minTermsValue[5] == 1 && minTermsValue[6]== 1 && minTermsValue[7] == 1 ||
			minTermsValue[4] == 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1 ||
			minTermsValue[4] >= 1 && minTermsValue[5] == 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1 ||
			minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] == 1 && minTermsValue[7] >= 1 ||
			minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] == 1 )
		{result[i] = "A";  minTermsValue[4]++;minTermsValue[5]++;minTermsValue[6]++;minTermsValue[7]++;}
	else if(minTermsValue[0] == 1 && minTermsValue[1] == 1 && minTermsValue[4] == 1 && minTermsValue[5] == 1 ||
			minTermsValue[0] == 1 && minTermsValue[1] >= 1 && minTermsValue[4] >= 1 && minTermsValue[5] >= 1 ||
			minTermsValue[0] >= 1 && minTermsValue[1] == 1 && minTermsValue[4] >= 1 && minTermsValue[5] >= 1 ||
			minTermsValue[0] >= 1 && minTermsValue[1] >= 1 && minTermsValue[4] == 1 && minTermsValue[5] >= 1 ||
			minTermsValue[0] >= 1 && minTermsValue[1] >= 1 && minTermsValue[4] >= 1 && minTermsValue[5] == 1 )
		{result[i] = "B’"; minTermsValue[0]++;minTermsValue[1]++;minTermsValue[4]++;minTermsValue[5]++;}
	else if(minTermsValue[1] == 1 && minTermsValue[3] == 1 && minTermsValue[5] == 1 && minTermsValue[7] == 1 ||
			minTermsValue[1] == 1 && minTermsValue[3] >= 1 && minTermsValue[5] >= 1 && minTermsValue[7] >= 1 ||
			minTermsValue[1] >= 1 && minTermsValue[3] == 1 && minTermsValue[5] >= 1 && minTermsValue[7] >= 1 ||
			minTermsValue[1] >= 1 && minTermsValue[3] >= 1 && minTermsValue[5] == 1 && minTermsValue[7] >= 1 ||
			minTermsValue[1] >= 1 && minTermsValue[3] >= 1 && minTermsValue[5] >= 1 && minTermsValue[7] == 1 )
		{result[i] = "C"; minTermsValue[1]++;minTermsValue[3]++;minTermsValue[5]++;minTermsValue[7]++;}
	else if(minTermsValue[2] == 1 && minTermsValue[3] == 1 && minTermsValue[6] == 1 && minTermsValue[7] == 1 ||
			minTermsValue[2] == 1 && minTermsValue[3] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1 ||
			minTermsValue[2] >= 1 && minTermsValue[3] == 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1 ||
			minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[6] == 1 && minTermsValue[7] >= 1 ||
			minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] == 1 )
		{result[i] = "B"; minTermsValue[2]++;minTermsValue[3]++;minTermsValue[6]++;minTermsValue[7]++;}
	else if(minTermsValue[0] == 1 && minTermsValue[2] == 1 && minTermsValue[4] == 1 && minTermsValue[6] == 1 ||
			minTermsValue[0] == 1 && minTermsValue[2] >= 1 && minTermsValue[4] >= 1 && minTermsValue[6] >= 1 ||
			minTermsValue[0] >= 1 && minTermsValue[2] == 1 && minTermsValue[4] >= 1 && minTermsValue[6] >= 1 ||
			minTermsValue[0] >= 1 && minTermsValue[2] >= 1 && minTermsValue[4] == 1 && minTermsValue[6] >= 1 ||
			minTermsValue[0] >= 1 && minTermsValue[2] >= 1 && minTermsValue[4] >= 1 && minTermsValue[6] == 1 )
		{result[i] = "C’"; minTermsValue[0]++;minTermsValue[2]++;minTermsValue[4]++;minTermsValue[6]++;}
		
		
		// 2'LİK KARELERİ GRUPLANDIRMA (GRUPLANDIRILMAYAN MINTERMS KALDIYSA ÇALIŞIR)
	else if(minTermsValue[0] == 1 && minTermsValue[1] == 1 || minTermsValue[0] == 1 && minTermsValue[1] >=1 || minTermsValue[0] >= 1 && minTermsValue[1] == 1)
		{result[i] = "A’B’"; minTermsValue[0]++;minTermsValue[1]++;}
	else if(minTermsValue[1] == 1 && minTermsValue[3] == 1 || minTermsValue[1] == 1 && minTermsValue[3] >= 1 || minTermsValue[1] >= 1 && minTermsValue[3] == 1)
		{result[i] = "A’C"; minTermsValue[1]++;minTermsValue[3]++;}
	else if(minTermsValue[2] == 1 && minTermsValue[3] == 1 || minTermsValue[2] == 1 && minTermsValue[3] >= 1 || minTermsValue[2] >= 1 && minTermsValue[3] == 1)
		{result[i] = "A’B"; minTermsValue[2]++;minTermsValue[3]++;}
	else if(minTermsValue[4] == 1 && minTermsValue[5] == 1 ||minTermsValue[4] == 1 && minTermsValue[5] >= 1 || minTermsValue[4] >= 1 && minTermsValue[5] == 1)
		{result[i] = "AB’"; minTermsValue[4]++;minTermsValue[5]++;}
	else if(minTermsValue[5] == 1 && minTermsValue[7] == 1 || minTermsValue[5] == 1 && minTermsValue[7] >= 1 || minTermsValue[5] >= 1 && minTermsValue[7] == 1)
		{result[i] = "AC"; minTermsValue[5]++;minTermsValue[7]++;}
	else if(minTermsValue[6] == 1 && minTermsValue[7] == 1 || minTermsValue[6] == 1 && minTermsValue[7] >= 1 ||minTermsValue[6] >= 1 && minTermsValue[7] == 1)
		{result[i] = "AB"; minTermsValue[6]++;minTermsValue[7]++;}
	else if(minTermsValue[0] == 1 && minTermsValue[2] == 1 || minTermsValue[0] == 1 && minTermsValue[2] >= 1 || minTermsValue[0] >= 1 && minTermsValue[2] == 1)
		{result[i] = "A’C’"; minTermsValue[0]++;minTermsValue[2]++;}
	else if(minTermsValue[4] == 1 && minTermsValue[6] == 1 || minTermsValue[4] == 1 && minTermsValue[6] >= 1 || minTermsValue[4] >= 1 && minTermsValue[6] == 1)
		{result[i] = "AC’"; minTermsValue[4]++;minTermsValue[6]++;}
	else if(minTermsValue[0] == 1 && minTermsValue[4] == 1 || minTermsValue[0] == 1 && minTermsValue[4] >= 1 || minTermsValue[0] >= 1 && minTermsValue[4] == 1)
		{result[i] = "B’C’"; minTermsValue[0]++;minTermsValue[4]++;}
	else if(minTermsValue[1] == 1 && minTermsValue[5] == 1 || minTermsValue[1] == 1 && minTermsValue[5] >= 1 || minTermsValue[1] >= 1 && minTermsValue[5] == 1)
		{result[i] = "B’C"; minTermsValue[1]++;minTermsValue[5]++;}
	else if(minTermsValue[3] == 1 && minTermsValue[7] == 1 || minTermsValue[3] == 1 && minTermsValue[7] >= 1 || minTermsValue[3] >= 1 && minTermsValue[7] == 1)
		{result[i] = "BC"; minTermsValue[3]++;minTermsValue[7]++;}
	else if(minTermsValue[2] == 1 && minTermsValue[6] == 1 || minTermsValue[2] == 1 && minTermsValue[6] >= 1 || minTermsValue[2] >= 1 && minTermsValue[6] == 1)
		{result[i] = "BC’"; minTermsValue[2]++;minTermsValue[6]++;}
		
		// TEK KARELER (önceki koşullarla uymuyorsa)
	else if(minTermsValue[0] == 1)
	{result[i] = "A’B’C’"; }
	else if(minTermsValue[1] == 1)
	{result[i] = "A’B’C"; }
	else if(minTermsValue[2] == 1)
	{result[i] = "A’BC’";}
	else if(minTermsValue[3] == 1)
	{result[i] = "A’BC";}
	else if(minTermsValue[4] == 1)
	{result[i] = "ABC"; }
	else if(minTermsValue[5] == 1)
	{result[i] = "AB’C"; }
	else if(minTermsValue[6] == 1)
	{result[i] = "ABC’"; }
	else if(minTermsValue[7] == 1)
	{result[i] = "ABC";}
						
		if(result[i] != null) { r += result[i] + " + ";}
	}
	
	
	
	public void withFourVaraibles (int i) {
		// BU METOD SADECE 4 DEĞİŞKENLİ FONKSİYONLAR İÇİN ÇALIŞIR
		// 8'LİK KARELERİ GRUPLANDIRMA KISMI
		if( minTermsValue[0] == 1 && minTermsValue[1]== 1 && minTermsValue[2]== 1 && minTermsValue[3] == 1 &&
				minTermsValue[4] == 1 && minTermsValue[5] == 1 && minTermsValue[6]== 1 && minTermsValue[7] == 1||
				
				minTermsValue[0] == 1 && minTermsValue[1]>= 1 && minTermsValue[2]>= 1 && minTermsValue[3] >= 1 && 
				minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1||
				
				minTermsValue[0] >= 1 && minTermsValue[1]== 1 && minTermsValue[2]>= 1 && minTermsValue[3] >= 1 &&
				minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1||
				
				minTermsValue[0] >= 1 && minTermsValue[1]>= 1 && minTermsValue[2]== 1 && minTermsValue[3] >= 1&&
				minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1||
				
				minTermsValue[0] >= 1 && minTermsValue[1]>= 1 && minTermsValue[2]>= 1 && minTermsValue[3] == 1 &&
				minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1 ||
				
				minTermsValue[0] >= 1 && minTermsValue[1]>= 1 && minTermsValue[2]>= 1 && minTermsValue[3] >= 1 && 
				minTermsValue[4] == 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1||
				
				minTermsValue[0] >= 1 && minTermsValue[1]>= 1 && minTermsValue[2]>= 1 && minTermsValue[3] >= 1 &&
				minTermsValue[4] >= 1 && minTermsValue[5] == 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1||
				
				minTermsValue[0] >= 1 && minTermsValue[1]>= 1 && minTermsValue[2]>= 1 && minTermsValue[3] >= 1&&
				minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] == 1 && minTermsValue[7] >= 1||
				
				minTermsValue[0] >= 1 && minTermsValue[1]>= 1 && minTermsValue[2]>= 1 && minTermsValue[3] >= 1 &&
				minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] == 1) 
				{
					result[i] = "A’"; minTermsValue[0]++;minTermsValue[1]++;minTermsValue[2]++;minTermsValue[3]++;
									  minTermsValue[4]++;minTermsValue[5]++;minTermsValue[6]++;minTermsValue[7]++;
				}
				
				
			else if(minTermsValue[4] == 1 && minTermsValue[5] == 1 && minTermsValue[6]== 1 && minTermsValue[7] == 1 &&
					minTermsValue[12] == 1 && minTermsValue[13] == 1 && minTermsValue[14] == 1 && minTermsValue[15] == 1||
					
					minTermsValue[4] == 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1||
					
					minTermsValue[4] >= 1 && minTermsValue[5] == 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] == 1 && minTermsValue[7] >= 1 &&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] == 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1&&
					minTermsValue[12] == 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1||
					
					minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] == 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1 &&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] == 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] == 1)
				{result[i] = "B";  minTermsValue[4]++;minTermsValue[5]++;minTermsValue[6]++;minTermsValue[7]++;
				minTermsValue[12]++;minTermsValue[13]++;minTermsValue[14]++;minTermsValue[15]++;}
		
			else if(minTermsValue[8] == 1 && minTermsValue[9] == 1 && minTermsValue[10]== 1 && minTermsValue[11] == 1 &&
					minTermsValue[12] == 1 && minTermsValue[13] == 1 && minTermsValue[14] == 1 && minTermsValue[15] == 1||
					
					minTermsValue[8] == 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1||
					
					minTermsValue[8] >= 1 && minTermsValue[9] == 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] == 1 && minTermsValue[11] >= 1 &&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] == 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[12] == 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] == 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1 &&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] == 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] == 1)
				{result[i] = "A";  minTermsValue[8]++;minTermsValue[9]++;minTermsValue[10]++;minTermsValue[11]++;
				minTermsValue[12]++;minTermsValue[13]++;minTermsValue[14]++;minTermsValue[15]++;}
		
		
			else if(minTermsValue[8] == 1 && minTermsValue[9] == 1 && minTermsValue[0]== 1 && minTermsValue[1] == 1 &&
					minTermsValue[12] == 1 && minTermsValue[13] == 1 && minTermsValue[4] == 1 && minTermsValue[5] == 1||
					
					minTermsValue[8] == 1 && minTermsValue[9] >= 1 && minTermsValue[0] >= 1 && minTermsValue[1] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[4] >= 1 && minTermsValue[5] >= 1||
					
					minTermsValue[8] >= 1 && minTermsValue[9] == 1 && minTermsValue[0] >= 1 && minTermsValue[1] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[4] >= 1 && minTermsValue[5] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[0] == 1 && minTermsValue[1] >= 1 &&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[4] >= 1 && minTermsValue[5] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[0] >= 1 && minTermsValue[1] == 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[4] >= 1 && minTermsValue[5] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[0] >= 1 && minTermsValue[1] >= 1&&
					minTermsValue[12] == 1 && minTermsValue[13] >= 1 && minTermsValue[4] >= 1 && minTermsValue[5] >= 1||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[0] >= 1 && minTermsValue[1] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] == 1 && minTermsValue[4] >= 1 && minTermsValue[5] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[0] >= 1 && minTermsValue[1] >= 1 &&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[4] == 1 && minTermsValue[5] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[0] >= 1 && minTermsValue[1] >= 1&&
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[4] >= 1 && minTermsValue[5] == 1)
				{result[i] = "C’";  minTermsValue[8]++;minTermsValue[9]++;minTermsValue[0]++;minTermsValue[1]++;
				minTermsValue[12]++;minTermsValue[13]++;minTermsValue[4]++;minTermsValue[5]++;}
		
		
			else if(minTermsValue[3] == 1 && minTermsValue[9] == 1 && minTermsValue[1]== 1 && minTermsValue[5] == 1 &&
					minTermsValue[11] == 1 && minTermsValue[13] == 1 && minTermsValue[7] == 1 && minTermsValue[15] == 1||
					
					minTermsValue[3] == 1 && minTermsValue[9] >= 1 && minTermsValue[1] >= 1 && minTermsValue[5] >= 1&&
					minTermsValue[11] >= 1 && minTermsValue[13] >= 1 && minTermsValue[7] >= 1 && minTermsValue[15] >= 1||
					
					minTermsValue[3] >= 1 && minTermsValue[9] == 1 && minTermsValue[1] >= 1 && minTermsValue[5] >= 1&&
					minTermsValue[11] >= 1 && minTermsValue[13] >= 1 && minTermsValue[7] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[3] >= 1 && minTermsValue[9] >= 1 && minTermsValue[1] == 1 && minTermsValue[5] >= 1 &&
					minTermsValue[11] >= 1 && minTermsValue[13] >= 1 && minTermsValue[7] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[3] >= 1 && minTermsValue[9] >= 1 && minTermsValue[1] >= 1 && minTermsValue[5] == 1&&
					minTermsValue[11] >= 1 && minTermsValue[13] >= 1 && minTermsValue[7] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[3] >= 1 && minTermsValue[9] >= 1 && minTermsValue[1] >= 1 && minTermsValue[5] >= 1&&
					minTermsValue[11] == 1 && minTermsValue[13] >= 1 && minTermsValue[7] >= 1 && minTermsValue[15] >= 1||
					
					minTermsValue[3] >= 1 && minTermsValue[9] >= 1 && minTermsValue[1] >= 1 && minTermsValue[5] >= 1&&
					minTermsValue[11] >= 1 && minTermsValue[13] == 1 && minTermsValue[7] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[3] >= 1 && minTermsValue[9] >= 1 && minTermsValue[1] >= 1 && minTermsValue[5] >= 1 &&
					minTermsValue[11] >= 1 && minTermsValue[13] >= 1 && minTermsValue[7] == 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[3] >= 1 && minTermsValue[9] >= 1 && minTermsValue[1] >= 1 && minTermsValue[5] >= 1&&
					minTermsValue[11] >= 1 && minTermsValue[13] >= 1 && minTermsValue[7] >= 1 && minTermsValue[15] == 1)
				{result[i] = "D";  minTermsValue[3]++;minTermsValue[9]++;minTermsValue[1]++;minTermsValue[5]++;
				minTermsValue[11]++;minTermsValue[13]++;minTermsValue[7]++;minTermsValue[15]++;}
		
		
			else if(minTermsValue[6] == 1 && minTermsValue[7] == 1 && minTermsValue[10]== 1 && minTermsValue[11] == 1 &&
					minTermsValue[2] == 1 && minTermsValue[3] == 1 && minTermsValue[14] == 1 && minTermsValue[15] == 1||
					
					minTermsValue[6] == 1 && minTermsValue[7] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1||
					
					minTermsValue[6] >= 1 && minTermsValue[7] == 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[6] >= 1 && minTermsValue[7] >= 1 && minTermsValue[10] == 1 && minTermsValue[11] >= 1 &&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[6] >= 1 && minTermsValue[7] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] == 1&&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[6] >= 1 && minTermsValue[7] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[2] == 1 && minTermsValue[3] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1||
					
					minTermsValue[6] >= 1 && minTermsValue[7] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[3] == 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[6] >= 1 && minTermsValue[7] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1 &&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[14] == 1 && minTermsValue[15] >= 1 ||
					
					minTermsValue[6] >= 1 && minTermsValue[7] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] == 1)
				{result[i] = "C";  minTermsValue[6]++;minTermsValue[7]++;minTermsValue[10]++;minTermsValue[11]++;
				minTermsValue[2]++;minTermsValue[3]++;minTermsValue[14]++;minTermsValue[15]++;}
		
			else if(minTermsValue[8] == 1 && minTermsValue[9] == 1 && minTermsValue[10]== 1 && minTermsValue[11] == 1 &&
					minTermsValue[2] == 1 && minTermsValue[3] == 1 && minTermsValue[1] == 1 && minTermsValue[0] == 1||
					
					minTermsValue[8] == 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[1] >= 1 && minTermsValue[0] >= 1||
					
					minTermsValue[8] >= 1 && minTermsValue[9] == 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[1] >= 1 && minTermsValue[0] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] == 1 && minTermsValue[11] >= 1 &&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[1] >= 1 && minTermsValue[0] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] == 1&&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[1] >= 1 && minTermsValue[0] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[2] == 1 && minTermsValue[3] >= 1 && minTermsValue[1] >= 1 && minTermsValue[0] >= 1||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[3] == 1 && minTermsValue[1] >= 1 && minTermsValue[0] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1 &&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[1] == 1 && minTermsValue[0] >= 1 ||
					
					minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[1] >= 1 && minTermsValue[0] == 1)
				{result[i] = "B’";  minTermsValue[8]++;minTermsValue[9]++;minTermsValue[10]++;minTermsValue[11]++;
				minTermsValue[2]++;minTermsValue[3]++;minTermsValue[1]++;minTermsValue[0]++;}
		
			else if(minTermsValue[6] == 1 && minTermsValue[0] == 1 && minTermsValue[10]== 1 && minTermsValue[4] == 1 &&
					minTermsValue[2] == 1 && minTermsValue[8] == 1 && minTermsValue[14] == 1 && minTermsValue[12] == 1||
					
					minTermsValue[6] == 1 && minTermsValue[0] >= 1 && minTermsValue[10] >= 1 && minTermsValue[4] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[8] >= 1 && minTermsValue[14] >= 1 && minTermsValue[12] >= 1||
					
					minTermsValue[6] >= 1 && minTermsValue[0] == 1 && minTermsValue[10] >= 1 && minTermsValue[4] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[8] >= 1 && minTermsValue[14] >= 1 && minTermsValue[12] >= 1 ||
					
					minTermsValue[6] >= 1 && minTermsValue[0] >= 1 && minTermsValue[10] == 1 && minTermsValue[4] >= 1 &&
					minTermsValue[2] >= 1 && minTermsValue[8] >= 1 && minTermsValue[14] >= 1 && minTermsValue[12] >= 1 ||
					
					minTermsValue[6] >= 1 && minTermsValue[0] >= 1 && minTermsValue[10] >= 1 && minTermsValue[4] == 1&&
					minTermsValue[2] >= 1 && minTermsValue[8] >= 1 && minTermsValue[14] >= 1 && minTermsValue[12] >= 1 ||
					
					minTermsValue[6] >= 1 && minTermsValue[0] >= 1 && minTermsValue[10] >= 1 && minTermsValue[4] >= 1&&
					minTermsValue[2] == 1 && minTermsValue[8] >= 1 && minTermsValue[14] >= 1 && minTermsValue[12] >= 1||
					
					minTermsValue[6] >= 1 && minTermsValue[0] >= 1 && minTermsValue[10] >= 1 && minTermsValue[4] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[8] == 1 && minTermsValue[14] >= 1 && minTermsValue[12] >= 1 ||
					
					minTermsValue[6] >= 1 && minTermsValue[0] >= 1 && minTermsValue[10] >= 1 && minTermsValue[4] >= 1 &&
					minTermsValue[2] >= 1 && minTermsValue[8] >= 1 && minTermsValue[14] == 1 && minTermsValue[12] >= 1 ||
					
					minTermsValue[6] >= 1 && minTermsValue[0] >= 1 && minTermsValue[10] >= 1 && minTermsValue[4] >= 1&&
					minTermsValue[2] >= 1 && minTermsValue[8] >= 1 && minTermsValue[14] >= 1 && minTermsValue[12] == 1)
				{result[i] = "D’";  minTermsValue[6]++;minTermsValue[0]++;minTermsValue[10]++;minTermsValue[4]++;
				minTermsValue[2]++;minTermsValue[8]++;minTermsValue[14]++;minTermsValue[12]++;}
		
		
		// 4'LÜK KARELERİ GRUPLANDIRMA (GRUPLANDIRILMAYAN MINTERMS KALDIYSA ÇALIŞIR)
			else if(minTermsValue[0] == 1 && minTermsValue[1]== 1 && minTermsValue[2]== 1 && minTermsValue[3] == 1 ||
				   minTermsValue[0] == 1 && minTermsValue[1]>= 1 && minTermsValue[2]>= 1 && minTermsValue[3] >= 1 ||
				   minTermsValue[0] >= 1 && minTermsValue[1]== 1 && minTermsValue[2]>= 1 && minTermsValue[3] >= 1 ||
				   minTermsValue[0] >= 1 && minTermsValue[1]>= 1 && minTermsValue[2]== 1 && minTermsValue[3] >= 1 ||
				   minTermsValue[0] >= 1 && minTermsValue[1]>= 1 && minTermsValue[2]>= 1 && minTermsValue[3] == 1 ) 
				{
					result[i] = "A’B’"; minTermsValue[0]++;minTermsValue[1]++;minTermsValue[2]++;minTermsValue[3]++;
				}
			else if(minTermsValue[4] == 1 && minTermsValue[5] == 1 && minTermsValue[6]== 1 && minTermsValue[7] == 1 ||
					minTermsValue[4] == 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1 ||
					minTermsValue[4] >= 1 && minTermsValue[5] == 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1 ||
					minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] == 1 && minTermsValue[7] >= 1 ||
					minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] == 1 )
				{result[i] = "A’B";  minTermsValue[4]++;minTermsValue[5]++;minTermsValue[6]++;minTermsValue[7]++;}
			else if(minTermsValue[0] == 1 && minTermsValue[1] == 1 && minTermsValue[4] == 1 && minTermsValue[5] == 1 ||
					minTermsValue[0] == 1 && minTermsValue[1] >= 1 && minTermsValue[4] >= 1 && minTermsValue[5] >= 1 ||
					minTermsValue[0] >= 1 && minTermsValue[1] == 1 && minTermsValue[4] >= 1 && minTermsValue[5] >= 1 ||
					minTermsValue[0] >= 1 && minTermsValue[1] >= 1 && minTermsValue[4] == 1 && minTermsValue[5] >= 1 ||
					minTermsValue[0] >= 1 && minTermsValue[1] >= 1 && minTermsValue[4] >= 1 && minTermsValue[5] == 1 )
				{result[i] = "A’B’"; minTermsValue[0]++;minTermsValue[1]++;minTermsValue[4]++;minTermsValue[5]++;}
			else if(minTermsValue[1] == 1 && minTermsValue[3] == 1 && minTermsValue[5] == 1 && minTermsValue[7] == 1 ||
					minTermsValue[1] == 1 && minTermsValue[3] >= 1 && minTermsValue[5] >= 1 && minTermsValue[7] >= 1 ||
					minTermsValue[1] >= 1 && minTermsValue[3] == 1 && minTermsValue[5] >= 1 && minTermsValue[7] >= 1 ||
					minTermsValue[1] >= 1 && minTermsValue[3] >= 1 && minTermsValue[5] == 1 && minTermsValue[7] >= 1 ||
					minTermsValue[1] >= 1 && minTermsValue[3] >= 1 && minTermsValue[5] >= 1 && minTermsValue[7] == 1 )
				{result[i] = "A’D"; minTermsValue[1]++;minTermsValue[3]++;minTermsValue[5]++;minTermsValue[7]++;}
			else if(minTermsValue[2] == 1 && minTermsValue[3] == 1 && minTermsValue[6] == 1 && minTermsValue[7] == 1 ||
					minTermsValue[2] == 1 && minTermsValue[3] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1 ||
					minTermsValue[2] >= 1 && minTermsValue[3] == 1 && minTermsValue[6] >= 1 && minTermsValue[7] >= 1 ||
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[6] == 1 && minTermsValue[7] >= 1 ||
					minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[6] >= 1 && minTermsValue[7] == 1 )
				{result[i] = "A’C"; minTermsValue[2]++;minTermsValue[3]++;minTermsValue[6]++;minTermsValue[7]++;}
			else if(minTermsValue[0] == 1 && minTermsValue[2] == 1 && minTermsValue[4] == 1 && minTermsValue[6] == 1 ||
					minTermsValue[0] == 1 && minTermsValue[2] >= 1 && minTermsValue[4] >= 1 && minTermsValue[6] >= 1 ||
					minTermsValue[0] >= 1 && minTermsValue[2] == 1 && minTermsValue[4] >= 1 && minTermsValue[6] >= 1 ||
					minTermsValue[0] >= 1 && minTermsValue[2] >= 1 && minTermsValue[4] == 1 && minTermsValue[6] >= 1 ||
					minTermsValue[0] >= 1 && minTermsValue[2] >= 1 && minTermsValue[4] >= 1 && minTermsValue[6] == 1 )
				{result[i] = "C’"; minTermsValue[0]++;minTermsValue[2]++;minTermsValue[4]++;minTermsValue[6]++;}	
		
			else if(minTermsValue[12] == 1 && minTermsValue[13] == 1 && minTermsValue[14] == 1 && minTermsValue[15] == 1 ||
					minTermsValue[12] == 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					minTermsValue[12] >= 1 && minTermsValue[13] == 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] == 1 && minTermsValue[15] >= 1 ||
					minTermsValue[12] >= 1 && minTermsValue[13] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] == 1 )
				{result[i] = "AB"; minTermsValue[12]++;minTermsValue[13]++;minTermsValue[14]++;minTermsValue[15]++;}
				else if(minTermsValue[8] == 1 && minTermsValue[9] == 1 && minTermsValue[10]== 1 && minTermsValue[11] == 1 ||
						minTermsValue[8] == 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1 ||
						minTermsValue[8] >= 1 && minTermsValue[9] == 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1 ||
						minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] == 1 && minTermsValue[11] >= 1 ||
						minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] == 1 )
					{result[i] = "AB’";  minTermsValue[8]++;minTermsValue[9]++;minTermsValue[10]++;minTermsValue[11]++;}
				else if(minTermsValue[8] == 1 && minTermsValue[9] == 1 && minTermsValue[12] == 1 && minTermsValue[13] == 1 ||
						minTermsValue[8] == 1 && minTermsValue[9] >= 1 && minTermsValue[12] >= 1 && minTermsValue[13] >= 1 ||
						minTermsValue[8] >= 1 && minTermsValue[9] == 1 && minTermsValue[12] >= 1 && minTermsValue[13] >= 1 ||
						minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[12] == 1 && minTermsValue[13] >= 1 ||
						minTermsValue[8] >= 1 && minTermsValue[9] >= 1 && minTermsValue[12] >= 1 && minTermsValue[13] == 1 )
					{result[i] = "AC’"; minTermsValue[8]++;minTermsValue[9]++;minTermsValue[12]++;minTermsValue[13]++;}
				else if(minTermsValue[9] == 1 && minTermsValue[11] == 1 && minTermsValue[13] == 1 && minTermsValue[15] == 1 ||
						minTermsValue[9] == 1 && minTermsValue[11] >= 1 && minTermsValue[13] >= 1 && minTermsValue[15] >= 1 ||
						minTermsValue[9] >= 1 && minTermsValue[11] == 1 && minTermsValue[13] >= 1 && minTermsValue[15] >= 1 ||
						minTermsValue[9] >= 1 && minTermsValue[11] >= 1 && minTermsValue[13] == 1 && minTermsValue[15] >= 1 ||
						minTermsValue[9] >= 1 && minTermsValue[11] >= 1 && minTermsValue[13] >= 1 && minTermsValue[15] == 1 )
					{result[i] = "AD"; minTermsValue[9]++;minTermsValue[11]++;minTermsValue[13]++;minTermsValue[15]++;}
				else if(minTermsValue[10] == 1 && minTermsValue[11] == 1 && minTermsValue[14] == 1 && minTermsValue[15] == 1 ||
						minTermsValue[10] == 1 && minTermsValue[11] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
						minTermsValue[10] >= 1 && minTermsValue[11] == 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
						minTermsValue[10] >= 1 && minTermsValue[11] >= 1 && minTermsValue[14] == 1 && minTermsValue[15] >= 1 ||
						minTermsValue[10] >= 1 && minTermsValue[11] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] == 1 )
					{result[i] = "AC"; minTermsValue[2]++;minTermsValue[3]++;minTermsValue[14]++;minTermsValue[7]++;}
				else if(minTermsValue[8] == 1 && minTermsValue[10] == 1 && minTermsValue[12] == 1 && minTermsValue[14] == 1 ||
						minTermsValue[8] == 1 && minTermsValue[10] >= 1 && minTermsValue[12] >= 1 && minTermsValue[14] >= 1 ||
						minTermsValue[8] >= 1 && minTermsValue[10] == 1 && minTermsValue[12] >= 1 && minTermsValue[14] >= 1 ||
						minTermsValue[8] >= 1 && minTermsValue[10] >= 1 && minTermsValue[12] == 1 && minTermsValue[14] >= 1 ||
						minTermsValue[8] >= 1 && minTermsValue[10] >= 1 && minTermsValue[12] >= 1 && minTermsValue[14] == 1 )
					{result[i] = "AD’"; minTermsValue[0]++;minTermsValue[2]++;minTermsValue[4]++;minTermsValue[6]++;}
		
				else if(minTermsValue[4] == 1 && minTermsValue[5] == 1 && minTermsValue[12]== 1 && minTermsValue[13] == 1 ||
						minTermsValue[4] == 1 && minTermsValue[5] >= 1 && minTermsValue[12] >= 1 && minTermsValue[13] >= 1 ||
						minTermsValue[4] >= 1 && minTermsValue[5] == 1 && minTermsValue[12] >= 1 && minTermsValue[13] >= 1 ||
						minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[12] == 1 && minTermsValue[13] >= 1 ||
						minTermsValue[4] >= 1 && minTermsValue[5] >= 1 && minTermsValue[12] >= 1 && minTermsValue[13] == 1 )
					{result[i] = "BC’";  minTermsValue[4]++;minTermsValue[5]++;minTermsValue[12]++;minTermsValue[13]++;}
				else if(minTermsValue[5] == 1 && minTermsValue[7] == 1 && minTermsValue[13] == 1 && minTermsValue[15] == 1 ||
						minTermsValue[5] == 1 && minTermsValue[7] >= 1 && minTermsValue[13] >= 1 && minTermsValue[15] >= 1 ||
						minTermsValue[5] >= 1 && minTermsValue[7] == 1 && minTermsValue[13] >= 1 && minTermsValue[15] >= 1 ||
						minTermsValue[5] >= 1 && minTermsValue[7] >= 1 && minTermsValue[13] == 1 && minTermsValue[15] >= 1 ||
						minTermsValue[5] >= 1 && minTermsValue[7] >= 1 && minTermsValue[13] >= 1 && minTermsValue[15] == 1 )
					{result[i] = "BD"; minTermsValue[5]++;minTermsValue[7]++;minTermsValue[13]++;minTermsValue[15]++;}
				else if(minTermsValue[6] == 1 && minTermsValue[7] == 1 && minTermsValue[14] == 1 && minTermsValue[15] == 1 ||
						minTermsValue[6] == 1 && minTermsValue[7] >= 1 && minTermsValue[14] >= 1 && minTermsValue[11] >= 1 ||
						minTermsValue[6] >= 1 && minTermsValue[7] == 1 && minTermsValue[14] >= 1 && minTermsValue[15] >= 1 ||
						minTermsValue[6] >= 1 && minTermsValue[7] >= 1 && minTermsValue[14] == 1 && minTermsValue[15] >= 1 ||
						minTermsValue[6] >= 1 && minTermsValue[7] >= 1 && minTermsValue[14] >= 1 && minTermsValue[15] == 1 )
					{result[i] = "BC"; minTermsValue[6]++;minTermsValue[7]++;minTermsValue[14]++;minTermsValue[15]++;}
				else if(minTermsValue[4] == 1 && minTermsValue[12] == 1 && minTermsValue[6] == 1 && minTermsValue[14] == 1 ||
						minTermsValue[4] == 1 && minTermsValue[12] >= 1 && minTermsValue[6] >= 1 && minTermsValue[14] >= 1 ||
						minTermsValue[4] >= 1 && minTermsValue[12] == 1 && minTermsValue[6] >= 1 && minTermsValue[14] >= 1 ||
						minTermsValue[4] >= 1 && minTermsValue[12] >= 1 && minTermsValue[6] == 1 && minTermsValue[14] >= 1 ||
						minTermsValue[4] >= 1 && minTermsValue[12] >= 1 && minTermsValue[6] >= 1 && minTermsValue[14] == 1 )
					{result[i] = "A’C"; minTermsValue[4]++;minTermsValue[12]++;minTermsValue[6]++;minTermsValue[14]++;}
		
				else if(minTermsValue[0] == 1 && minTermsValue[1] == 1 && minTermsValue[8] == 1 && minTermsValue[9] == 1 ||
						minTermsValue[0] == 1 && minTermsValue[1] >= 1 && minTermsValue[8] >= 1 && minTermsValue[9] >= 1 ||
						minTermsValue[0] >= 1 && minTermsValue[1] == 1 && minTermsValue[8] >= 1 && minTermsValue[9] >= 1 ||
						minTermsValue[0] >= 1 && minTermsValue[1] >= 1 && minTermsValue[8] == 1 && minTermsValue[9] >= 1 ||
						minTermsValue[0] >= 1 && minTermsValue[1] >= 1 && minTermsValue[8] >= 1 && minTermsValue[9] == 1 )
					{result[i] = "B’C’"; minTermsValue[0]++;minTermsValue[1]++;minTermsValue[8]++;minTermsValue[9]++;}
				else if(minTermsValue[1] == 1 && minTermsValue[3] == 1 && minTermsValue[9] == 1 && minTermsValue[11] == 1 ||
						minTermsValue[1] == 1 && minTermsValue[3] >= 1 && minTermsValue[9] >= 1 && minTermsValue[11] >= 1 ||
						minTermsValue[1] >= 1 && minTermsValue[3] == 1 && minTermsValue[9] >= 1 && minTermsValue[11] >= 1 ||
						minTermsValue[1] >= 1 && minTermsValue[3] >= 1 && minTermsValue[9] == 1 && minTermsValue[11] >= 1 ||
						minTermsValue[1] >= 1 && minTermsValue[3] >= 1 && minTermsValue[9] >= 1 && minTermsValue[11] == 1 )
					{result[i] = "B’D"; minTermsValue[1]++;minTermsValue[3]++;minTermsValue[9]++;minTermsValue[11]++;}
				else if(minTermsValue[2] == 1 && minTermsValue[3] == 1 && minTermsValue[10] == 1 && minTermsValue[11] == 1 ||
						minTermsValue[2] == 1 && minTermsValue[3] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1 ||
						minTermsValue[2] >= 1 && minTermsValue[3] == 1 && minTermsValue[10] >= 1 && minTermsValue[11] >= 1 ||
						minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[10] == 1 && minTermsValue[11] >= 1 ||
						minTermsValue[2] >= 1 && minTermsValue[3] >= 1 && minTermsValue[10] >= 1 && minTermsValue[11] == 1 )
					{result[i] = "B’C"; minTermsValue[2]++;minTermsValue[3]++;minTermsValue[10]++;minTermsValue[11]++;}
				else if(minTermsValue[0] == 1 && minTermsValue[2] == 1 && minTermsValue[8] == 1 && minTermsValue[10] == 1 ||
						minTermsValue[0] == 1 && minTermsValue[2] >= 1 && minTermsValue[8] >= 1 && minTermsValue[10] >= 1 ||
						minTermsValue[0] >= 1 && minTermsValue[2] == 1 && minTermsValue[8] >= 1 && minTermsValue[10] >= 1 ||
						minTermsValue[0] >= 1 && minTermsValue[2] >= 1 && minTermsValue[8] == 1 && minTermsValue[10] >= 1 ||
						minTermsValue[0] >= 1 && minTermsValue[2] >= 1 && minTermsValue[8] >= 1 && minTermsValue[10] == 1 )
					{result[i] = "B’D’"; minTermsValue[0]++;minTermsValue[2]++;minTermsValue[8]++;minTermsValue[10]++;}	
		
		
		// 2'LİK KARELERİ GRUPLANDIRMA  (GRUPLANDIRILMAYAN MINTERMS KALDIYSA ÇALIŞIR)

			else if(minTermsValue[0] == 1 && minTermsValue[1] == 1 || minTermsValue[0] == 1 && minTermsValue[1] >=1 || minTermsValue[0] >= 1 && minTermsValue[1] == 1)
				{result[i] = "A’B’C’"; minTermsValue[0]++;minTermsValue[1]++;}
			else if(minTermsValue[1] == 1 && minTermsValue[3] == 1 || minTermsValue[1] == 1 && minTermsValue[3] >= 1 || minTermsValue[1] >= 1 && minTermsValue[3] == 1)
				{result[i] = "A’B’D"; minTermsValue[1]++;minTermsValue[3]++;}
			else if(minTermsValue[2] == 1 && minTermsValue[3] == 1 || minTermsValue[2] == 1 && minTermsValue[3] >= 1 || minTermsValue[2] >= 1 && minTermsValue[3] == 1)
				{result[i] = "A’B’C"; minTermsValue[2]++;minTermsValue[3]++;}
			else if(minTermsValue[4] == 1 && minTermsValue[5] == 1 ||minTermsValue[4] == 1 && minTermsValue[5] >= 1 || minTermsValue[4] >= 1 && minTermsValue[5] == 1)
				{result[i] = "A’BC’"; minTermsValue[4]++;minTermsValue[5]++;}
			else if(minTermsValue[5] == 1 && minTermsValue[7] == 1 || minTermsValue[5] == 1 && minTermsValue[7] >= 1 || minTermsValue[5] >= 1 && minTermsValue[7] == 1)
				{result[i] = "A’BD"; minTermsValue[5]++;minTermsValue[7]++;}
			else if(minTermsValue[6] == 1 && minTermsValue[7] == 1 || minTermsValue[6] == 1 && minTermsValue[7] >= 1 ||minTermsValue[6] >= 1 && minTermsValue[7] == 1)
				{result[i] = "A’BC"; minTermsValue[6]++;minTermsValue[7]++;}
			else if(minTermsValue[0] == 1 && minTermsValue[2] == 1 || minTermsValue[0] == 1 && minTermsValue[2] >= 1 || minTermsValue[0] >= 1 && minTermsValue[2] == 1)
				{result[i] = "A’B’D’"; minTermsValue[0]++;minTermsValue[2]++;}
			else if(minTermsValue[4] == 1 && minTermsValue[6] == 1 || minTermsValue[4] == 1 && minTermsValue[6] >= 1 || minTermsValue[4] >= 1 && minTermsValue[6] == 1)
				{result[i] = "A’BD’"; minTermsValue[4]++;minTermsValue[6]++;}
			else if(minTermsValue[0] == 1 && minTermsValue[4] == 1 || minTermsValue[0] == 1 && minTermsValue[4] >= 1 || minTermsValue[0] >= 1 && minTermsValue[4] == 1)
				{result[i] = "A’C’D’"; minTermsValue[0]++;minTermsValue[4]++;}
			else if(minTermsValue[1] == 1 && minTermsValue[5] == 1 || minTermsValue[1] == 1 && minTermsValue[5] >= 1 || minTermsValue[1] >= 1 && minTermsValue[5] == 1)
				{result[i] = "A’C’D"; minTermsValue[1]++;minTermsValue[5]++;}
			else if(minTermsValue[3] == 1 && minTermsValue[7] == 1 || minTermsValue[3] == 1 && minTermsValue[7] >= 1 || minTermsValue[3] >= 1 && minTermsValue[7] == 1)
				{result[i] = "A’CD"; minTermsValue[3]++;minTermsValue[7]++;}
			else if(minTermsValue[2] == 1 && minTermsValue[6] == 1 || minTermsValue[2] == 1 && minTermsValue[6] >= 1 || minTermsValue[2] >= 1 && minTermsValue[6] == 1)
				{result[i] = "A’CD’"; minTermsValue[2]++;minTermsValue[6]++;}

			else if(minTermsValue[12] == 1 && minTermsValue[13] == 1 || minTermsValue[12] == 1 && minTermsValue[12] >=1 || minTermsValue[12] >= 1 && minTermsValue[13] == 1)
				{result[i] = "ABC’"; minTermsValue[12]++;minTermsValue[13]++;}
			else if(minTermsValue[15] == 1 && minTermsValue[13] == 1 || minTermsValue[15] == 1 && minTermsValue[13] >= 1 || minTermsValue[15] >= 1 && minTermsValue[13] == 1)
				{result[i] = "ABD"; minTermsValue[15]++;minTermsValue[13]++;}
			else if(minTermsValue[15] == 1 && minTermsValue[14] == 1 || minTermsValue[15] == 1 && minTermsValue[14] >= 1 || minTermsValue[15] >= 1 && minTermsValue[14] == 1)
				{result[i] = "ABC"; minTermsValue[14]++;minTermsValue[15]++;}
			else if(minTermsValue[8] == 1 && minTermsValue[9] == 1 ||minTermsValue[8] == 1 && minTermsValue[9] >= 1 || minTermsValue[8] >= 1 && minTermsValue[9] == 1)
				{result[i] = "AB’C’"; minTermsValue[8]++;minTermsValue[9]++;}
			else if(minTermsValue[9] == 1 && minTermsValue[11] == 1 || minTermsValue[9] == 1 && minTermsValue[11] >= 1 || minTermsValue[9] >= 1 && minTermsValue[11] == 1)
				{result[i] = "AB’D"; minTermsValue[9]++;minTermsValue[11]++;}
			else if(minTermsValue[10] == 1 && minTermsValue[11] == 1 || minTermsValue[10] == 1 && minTermsValue[11] >= 1 ||minTermsValue[10] >= 1 && minTermsValue[11] == 1)
				{result[i] = "A’BC"; minTermsValue[10]++;minTermsValue[11]++;}
			else if(minTermsValue[12] == 1 && minTermsValue[14] == 1 || minTermsValue[12] == 1 && minTermsValue[14] >= 1 || minTermsValue[12] >= 1 && minTermsValue[14] == 1)
				{result[i] = "ABD’"; minTermsValue[12]++;minTermsValue[14]++;}
			else if(minTermsValue[8] == 1 && minTermsValue[10] == 1 || minTermsValue[8] == 1 && minTermsValue[10] >= 1 || minTermsValue[8] >= 1 && minTermsValue[10] == 1)
				{result[i] = "AB’D’"; minTermsValue[8]++;minTermsValue[10]++;}
			else if(minTermsValue[8] == 1 && minTermsValue[12] == 1 || minTermsValue[8] == 1 && minTermsValue[12] >= 1 || minTermsValue[8] >= 1 && minTermsValue[12] == 1)
				{result[i] = "AC’D’"; minTermsValue[8]++;minTermsValue[12]++;}
			else if(minTermsValue[9] == 1 && minTermsValue[13] == 1 || minTermsValue[9] == 1 && minTermsValue[13] >= 1 || minTermsValue[9] >= 1 && minTermsValue[13] == 1)
				{result[i] = "AC’D"; minTermsValue[9]++;minTermsValue[13]++;}
			else if(minTermsValue[11] == 1 && minTermsValue[15] == 1 || minTermsValue[11] == 1 && minTermsValue[15] >= 1 || minTermsValue[11] >= 1 && minTermsValue[15] == 1)
				{result[i] = "ACD"; minTermsValue[11]++;minTermsValue[15]++;}
			else if(minTermsValue[10] == 1 && minTermsValue[14] == 1 || minTermsValue[10] == 1 && minTermsValue[14] >= 1 || minTermsValue[10] >= 1 && minTermsValue[14] == 1)
				{result[i] = "ACD’"; minTermsValue[10]++;minTermsValue[14]++;}
				
		
			else if(minTermsValue[12] == 1 && minTermsValue[4] == 1 || minTermsValue[12] == 1 && minTermsValue[4] >=1 || minTermsValue[12] >= 1 && minTermsValue[4] == 1)
			{result[i] = "BC’D’"; minTermsValue[12]++;minTermsValue[14]++;}
		else if(minTermsValue[5] == 1 && minTermsValue[13] == 1 || minTermsValue[5] == 1 && minTermsValue[13] >= 1 || minTermsValue[5] >= 1 && minTermsValue[13] == 1)
			{result[i] = "BC’D"; minTermsValue[5]++;minTermsValue[13]++;}
		else if(minTermsValue[15] == 1 && minTermsValue[7] == 1 || minTermsValue[15] == 1 && minTermsValue[7] >= 1 || minTermsValue[15] >= 1 && minTermsValue[7] == 1)
			{result[i] = "BCD"; minTermsValue[7]++;minTermsValue[15]++;}
		else if(minTermsValue[6] == 1 && minTermsValue[14] == 1 ||minTermsValue[6] == 1 && minTermsValue[14] >= 1 || minTermsValue[6] >= 1 && minTermsValue[14] == 1)
			{result[i] = "BCD’"; minTermsValue[6]++;minTermsValue[14]++;}
		else if(minTermsValue[9] == 1 && minTermsValue[1] == 1 || minTermsValue[9] == 1 && minTermsValue[1] >= 1 || minTermsValue[9] >= 1 && minTermsValue[1] == 1)
			{result[i] = "B’C’D"; minTermsValue[9]++;minTermsValue[1]++;}
		else if(minTermsValue[3] == 1 && minTermsValue[11] == 1 || minTermsValue[3] == 1 && minTermsValue[11] >= 1 ||minTermsValue[3] >= 1 && minTermsValue[11] == 1)
			{result[i] = "B’CD"; minTermsValue[3]++;minTermsValue[11]++;}
		else if(minTermsValue[2] == 1 && minTermsValue[10] == 1 || minTermsValue[2] == 1 && minTermsValue[10] >= 1 || minTermsValue[2] >= 1 && minTermsValue[10] == 1)
			{result[i] = "B’CD’"; minTermsValue[2]++;minTermsValue[10]++;}
		else if(minTermsValue[8] == 1 && minTermsValue[0] == 1 || minTermsValue[8] == 1 && minTermsValue[0] >= 1 || minTermsValue[8] >= 1 && minTermsValue[0] == 1)
			{result[i] = "B’C’D’"; minTermsValue[8]++;minTermsValue[0]++;}
		
		
		// TEK KARELER (GRUPLANDIRILMAYAN MINTERMS KALDIYSA ÇALIŞIR)
	else if(minTermsValue[0] == 1)
	{result[i] = "A’B’C’D’"; }
	else if(minTermsValue[1] == 1)
	{result[i] = "A’B’C’D"; }
	else if(minTermsValue[2] == 1)
	{result[i] = "A’B’CD’";}
	else if(minTermsValue[3] == 1)
	{result[i] = "A’B’CD";}
	else if(minTermsValue[4] == 1)
	{result[i] = "A’BC’D’"; }
	else if(minTermsValue[5] == 1)
	{result[i] = "A’BC’D"; }
	else if(minTermsValue[6] == 1)
	{result[i] = "A’BCD’"; }
	else if(minTermsValue[7] == 1)
	{result[i] = "A’BCD";}
		
	else if(minTermsValue[8] == 1)
	{result[i] = "AB’C’D’"; }
	else if(minTermsValue[9] == 1)
	{result[i] = "AB’C’D"; }
	else if(minTermsValue[10] == 1)
	{result[i] = "AB’CD’";}
	else if(minTermsValue[11] == 1)
	{result[i] = "AB’CD";}
	else if(minTermsValue[12] == 1)
	{result[i] = "ABC’D’"; }
	else if(minTermsValue[13] == 1)
	{result[i] = "ABC’D"; }
	else if(minTermsValue[14] == 1)
	{result[i] = "ABCD’"; }
	else if(minTermsValue[15] == 1)
	{result[i] = "ABCD";}
						
		
		if(result[i] != null) { r += result[i] + " + ";}
	}

}
