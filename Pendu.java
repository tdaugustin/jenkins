package pendu;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Pendu {
	public static void main(String[] args) {
		List<String> listeMots = Arrays.asList("JAZZ", "GEOLOGIE") ;
		String vies = "ooooooo" ;
		Integer i = (int)(Math.random() * listeMots.size()) ; // int rand = (int)(Math.random() * range) + min; // avec int range = max - min + 1;
		Integer compteur = 0 ;
		String motMystere = listeMots.get(i) ;
		String motPropose = "" ; //= StringUtils.repeat("_", 10) //import org.apache.commons.lang3.StringUtils;
		String choixLettre ;
		Boolean test ;
		motMystere = motMystere.toUpperCase() ;
		for(i = 0 ; i < motMystere.length(); i++) {
			motPropose += "." ;
		}
		System.out.println(motPropose) ;
		Scanner sc = new Scanner(System.in) ;
		do {
			test = false ;
			System.out.print("Proposez une lettre : ") ;
			choixLettre = sc.nextLine() ;
			choixLettre = choixLettre.toUpperCase() ;
			for(i = 0 ; i < motMystere.length() ; i++) {
				if(choixLettre.equals(String.valueOf(motMystere.charAt(i)))) {
					test = true ;
					motPropose = motPropose.substring(0, i) + choixLettre + motPropose.substring(i + 1) ;
				}
			}
			if (!test){
				compteur ++ ;
				if(compteur < 8) {
					vies = vies.substring(0, compteur-1) + "+" + vies.substring(compteur) ;
				}
			}
			System.out.println(motPropose + " [" + vies + "]") ;
		}while(!motPropose.equals(motMystere) && compteur < 8) ;
		sc.close() ;
		if(compteur == 8) {
			System.out.println("Perdu ! le mot était " + motMystere) ;
		}else {
			System.out.println("Gagné " + vies) ;
		}
	}
}
