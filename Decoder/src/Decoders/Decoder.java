package Decoders;


public class Decoder {
	protected String[] vars = new String[4];
	private String input;
	protected boolean E, x, y, z;
	
	Decoder(String str){
		
		input = str;
		
		try {
			
			ParseInputs();
			 System.out.println("\n1. YÖNTEM İLE");
				System.out.format("%d,%d,%d,%d,%d,%d,%d,%d \n \n",D0(),D1(),D2(),D3(),D4(),D5(),D6(),D7());
			
		
		}catch(ArrayIndexOutOfBoundsException e){
			
			System.out.println("\nLütfen boşluk bırakmayarak ve sadece 4 tane giriş girerek tekrar deneyiniz.. ");
			
		}catch(NumberFormatException e){
			
			System.out.println("\nLütfen girdiğiniz bilgileri kontrol ediniz..");
			
		}catch(Bad_Input e){
			
		}
	}
	

	public void ParseInputs() throws Bad_Input{
		
		// Kullanıcı tarafından girilen String ','ü kullanarak bölüyorum ve Binary giriş değişkenleri tanımlıyorum.
		// aynı zamanda da kullanıcı tafafından  girilen girişleri kontrol ediyorum.
		
				vars = input.split(","); 
				for(int i =0; i<vars.length;i++)
				if(!(vars[i].equalsIgnoreCase("1") || vars[i].equalsIgnoreCase("0"))) {
					throw new Bad_Input();
				}else {
				
				E = (Integer.parseInt(vars[0]) == 1) ? true : false;
				x = (Integer.parseInt(vars[1]) == 1) ? true : false;
				y = (Integer.parseInt(vars[2]) == 1) ? true : false;
				z = (Integer.parseInt(vars[3]) == 1) ? true : false;
	
				}
	}
	
	
	
	
	// 1. YÖNTEM METODLARI
	// VE Kapılarıyla oluşturulan 8 çıkışı oluşturma ve gerekli logic işlemleri uygulama kodu..
	
	public int D0() {
		
		return (E && !x && !y && !z) ?  1: 0;
	}
	
	public int D1() {
		
		return E && !x && !y && z ?  1: 0;
	}
	
	public int D2() {
		
		return E && !x && y && !z ?  1: 0;
	}
	
	public int D3() {
		
		return E && !x && y && z ?  1: 0;
	}
	
	public int D4() {
		
		return E && x && !y && !z ?  1: 0;
	}
	
	public int D5() {
		
		return E && x && !y && z ?  1: 0;
	}
	
	public int D6() {
		
		return E && x && y && !z ?  1: 0;
	}
	
	public int D7() {
		
		return E && x && y && z ?  1: 0;
	}
	
	
	
}
