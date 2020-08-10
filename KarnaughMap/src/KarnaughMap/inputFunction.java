package KarnaughMap;

public class inputFunction {

	private  int a,b,c,d,varNum;
	private String func;
	protected String[] terms;
	
	
	inputFunction(String str){
		func = str.toUpperCase();
		terms = str.split(" \\+ "); // verilen fonksiyondaki terimleri tek tek alma
		terms[0] = terms[0].replaceFirst("F =", ""); // ilk terimden F== silme
	}
	
	public int VariablesCounter() {
		// verilen fonksiyondaki Değişkenlerin sayısı belirleme metodu
		for(int i=0;i<func.length();i++) {
 			if(func.charAt(i)== 'A'){a++;}
 			else if(func.charAt(i) == 'B') {b++;}
 			else if(func.charAt(i) == 'C') {c++;}
 			else if(func.charAt(i) == 'D') {d++;}
 			}
		if(d>0)  varNum=4; 	else if(c>0) varNum=3;	else if(b>0)varNum=2;
		return varNum;
	}
	
}
