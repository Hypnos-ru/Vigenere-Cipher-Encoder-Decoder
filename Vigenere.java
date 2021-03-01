
import java.util.Scanner;

public class Vigenere {
	
	
	public static void main(String[] args) {
		
		char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		
		char[][] tab_vigenere = new char [alphabet.length][alphabet.length];
		
		for(int i = 0; i < alphabet.length; i++) {
			
			tab_vigenere[0][i] = alphabet[i];
			
		}
		
		for(int i = 1; i < alphabet.length; i++) {
			
			for(int j = 0; j < alphabet.length; j++) {
				
				if( j == 0) {
					
					tab_vigenere[i][0] = tab_vigenere[i-1][alphabet.length-1];
					tab_vigenere[i][alphabet.length-1] = tab_vigenere[i-1][0];
					
				} else {
				tab_vigenere[i][j-1] = tab_vigenere[i-1][j];
				
				}
				
				
			}
		
		}
		
	    System.out.println("Do you want to code or decode ?");
	    System.out.println("Enter 1 if you want to encode.");
	    System.out.println("Enter 2 if you want to decode.");		
		
		int choice = verifChoice();
		
		
		
		System.out.print("Key :");
		
		String key = getString();
		key = key.replaceAll("\\s", "");
		
		char[] tab_key = toTabChar(key);
		
		System.out.print("Message :");
		
		String message = getString();
		message = message.replaceAll("\\s", "");
		
		

		char[] tab_message = toTabChar(message);

		
		int x = 0;
		char[] encoded_message = new char[tab_message.length];
		
		for(int i = 0; i < tab_message.length; i++) {
			
			if(x >= tab_key.length) {
				x = 0;
			}
			encoded_message[i] = tab_key[x];
			x++;
			
		}
		
		if(choice == 2) {
		char[] final_message = new char[tab_message.length];
		
		
		for(int i = 0; i < tab_message.length; i++) {
			
			for(int z = 0; z < alphabet.length; z++) {
				
				if(tab_vigenere[z][0]== encoded_message[i]) {
					
					for(int v = 0; v < alphabet.length; v++) {
						
						if(tab_vigenere[z][v] == tab_message[i]) {
							final_message[i] = tab_vigenere[0][v];
							
						}
						
						
					}
					
				}
				
			}
			
		}
		System.out.print("Decoded message: ");
		for(int j = 0; j < final_message.length; j++) {
			
			System.out.print(final_message[j]);
		}
		
		}
		
		if(choice == 1) {
		char[] final_message = new char[tab_message.length];
		
		
		for(int i = 0; i < tab_message.length; i++) {
			
			for(int z = 0; z < alphabet.length; z++) {
				
				if(tab_vigenere[0][z]== tab_message[i]) {
					
					for(int v = 0; v < alphabet.length; v++) {
						
						if(tab_vigenere[v][0] == encoded_message[i]) {
							final_message[i] = tab_vigenere[v][z];
							
						}
						
						
					}
					
				}
				
			}
			
		}
		System.out.print("Encoded message: ");
		for(int j = 0; j < final_message.length; j++) {
			
			System.out.print(final_message[j]);
		}
		
		}
       
		
	}
	
    public static char[] toTabChar(String message) {
    	
    	message = message.toUpperCase();
    	int a = message.length();
    	char[] tab = new char[a];
    	 
    	for(int i = 0; i < a;i++){
    	     tab[i] = message.charAt(i);
    	}
    	
    	return tab;
    	
    }
  
    public static String getString() {
        String userValue = "";
        boolean erreur = false;
        
        Scanner scan = null;
		do {
            try {
            	scan = new Scanner(System.in);
                userValue = scan.nextLine();
               
                erreur = false;
            } catch (Exception e) {
                System.out.println("\nThis value is not available, please try again.");
                erreur = true;
            }
        } while (erreur);
        return userValue;
    }
    
    public static char[] encodedMessage(char[] tab_message, char[] tab_key) {
    	
		
		int x = 0;
		char[] tab_message2 = tab_message;
		
		for(int i = 0; i < tab_message.length; i++) {
			
			if(x >= tab_key.length) {
				x = 0;
			}
			tab_message2[i] = tab_key[x];
			x++;
			
		}
		
		return tab_message2;
    	
    }

    public static int verifChoice() {
        int userValue = 0;
        boolean erreur = false;
        
        Scanner scan = null;
		do {
            try {
            	scan = new Scanner(System.in);
                userValue = scan.nextInt();
               
                erreur = false;
            } catch (Exception e) {
                System.out.println("\nThis value is not available, please try again.");
                erreur = true;
            }
        } while (erreur || (userValue != 1 && userValue != 2));
        return userValue;
    }
}
