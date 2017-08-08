import java.util.*;
import java.io.*;

public class crypt{
	public static void main(String args[])throws IOException{

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(System.in);
			int ch1,ch2,k;
			String PT,CT,cho="";
			do	{
			System.out.printf("\t\n:: Study of cryptography ::\n");
      System.out.printf("\nSelect from below : \n");
			System.out.printf("\n1.Additive Cipher.");
			System.out.printf("\n2.Ceaser Cipher.");
			System.out.printf("\n3.One Time Pad.");
			System.out.printf("\n4.Auto Key Cipher.");
      System.out.printf("\n5.Exit.");
			System.out.printf("\n\nEnter your choice: ");
			ch1 = sc.nextInt();
      if(ch1 != 5){
        System.out.printf("\nSelect from below : \n");
  			System.out.printf("\n1.Encryption.");
  			System.out.printf("\n2.Decryption.");
  			System.out.printf("\n\nEnter your choice : ");
  			ch2 = sc.nextInt();
  			switch(ch1){
  				case 1 : if(ch2 == 1){
    								System.out.printf("\nEnter PT : ");
                    PT = br.readLine();
                    System.out.printf("\nEnter Key Value : ");
    								k = sc.nextInt();
                    CT = Addencrypt(PT,k);
                    System.out.printf("\nCipher Text is: %s",CT);
                    System.out.print("\n");
  								 //System.out.printf(PT);
  							   }
  							   else{
    								System.out.printf("\nEnter CT : ");
    								CT = br.readLine();
                    System.out.printf("\nEnter Key Value : ");
    								k = sc.nextInt();
    								PT = Adddecrypt(CT,k);
                    System.out.printf("\nPlain Text is: %s",PT);
                    System.out.print("\n");
  							   }
  							   break;
  				case 2 : if(ch2 == 1){
                    System.out.printf("\nEnter PT : ");
                    PT = br.readLine();
                    CT = Addencrypt(PT,3);
                    System.out.printf("\nCipher Text is: %s",CT);
                    System.out.print("\n");
  							   }
      						 else{
                    System.out.printf("\nEnter CT : ");
      							CT = br.readLine();
      							PT = Adddecrypt(CT,3);
                    System.out.printf("\nPlain Text is: %s",PT);
                    System.out.print("\n");
      						 }
  							   break;
  				case 3 : if(ch2 == 1){
                    System.out.printf("\nEnter PT : ");
                    PT = br.readLine();
                    CT = OTPencrypt(PT);
                    System.out.printf("\nCipher Text is: %s",CT);
                    System.out.print("\n");
    							 }
    							 else{
    								System.out.printf("\nEnter CT : ");
    								CT = br.readLine();
    								System.out.printf(CT);
    							 }
    							 break;
  				case 4 : if(ch2 == 1){
                    System.out.printf("\nEnter PT : ");
                    PT = br.readLine();
                    System.out.printf("\nEnter Key Value between (0-25): ");
                    k = sc.nextInt();
                    if(k<0 || k>25){
                      System.out.printf("\nInvalid Key Value.");
                    }
                    else{
                      CT = AutoKeyencrypt(PT,k);
                      System.out.printf("\nCipher Text is: %s",CT);
                      System.out.print("\n");
                    }
          			   }
  							   else{
                    System.out.printf("\nEnter CT : ");
    								CT = br.readLine();
                    System.out.printf("\nEnter Key Value between (0-25): ");
                    k = sc.nextInt();
                    if(k<0 || k>25){
                      System.out.printf("\nInvalid Key Value.");
                    }
                    else{
                      PT = AutoKeydecrypt(CT,k);
                      System.out.printf("\nPlain Text is: %s",PT);
                      System.out.print("\n");
                    }
  							   }
  							   break;
            }
						System.out.printf("\n\nDo you want to continue (y/n): ");
		        cho = br.readLine();
					}

			}while(cho.equals("y"));

		}catch(Exception e){

		}
	}

  public static String Addencrypt(String plainText, int shiftKey){
        String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
        plainText = plainText.toLowerCase();

        String cipherText = "";

        for (int i = 0; i < plainText.length(); i++)

        {

            int charPosition = ALPHABET.indexOf(plainText.charAt(i));

            int keyVal = (shiftKey + charPosition);
            if(keyVal > 25)
              keyVal %= 26;

            char replaceVal = ALPHABET.charAt(keyVal);

            cipherText += replaceVal;

        }

        return cipherText.toUpperCase();

    }
    public static String Adddecrypt(String cipherText, int shiftKey){
          String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
          cipherText = cipherText.toLowerCase();

          String plainText = "";

          for (int i = 0; i < cipherText.length(); i++)

          {

              int charPosition = ALPHABET.indexOf(cipherText.charAt(i));

              int keyVal = (charPosition - shiftKey);
              if(keyVal < 0)
                keyVal += 26;

              char replaceVal = ALPHABET.charAt(keyVal);

              plainText += replaceVal;

          }

          return plainText;

      }
      public static String OTPencrypt(String plainText){
            String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
            plainText = plainText.toLowerCase();
            Random r = new Random();
            int k = r.nextInt(26);
            System.out.print(k);
            String cipherText = "";

            for (int i = 0; i < plainText.length(); i++)

            {

                int charPosition = ALPHABET.indexOf(plainText.charAt(i));

                int keyVal = (k + charPosition);
                if(keyVal > 25)
                  keyVal -= 26;

                char replaceVal = ALPHABET.charAt(keyVal);

                cipherText += replaceVal;

            }

            return cipherText.toUpperCase();
        }

        public static String AutoKeyencrypt(String plainText, int shiftKey){
              String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
              plainText = plainText.toLowerCase();

              String cipherText = "";

              for (int i = 0; i < plainText.length(); i++) {
                int charPosition = ALPHABET.indexOf(plainText.charAt(i));
                int keyVal = 999;
                  if(i == 0){
                    keyVal = (shiftKey + charPosition);
                  }
                  else{
                    int charPosition_ = ALPHABET.indexOf(plainText.charAt(i-1));
                    keyVal = (charPosition_ + charPosition);
                  }
                  if (keyVal > 25)
					             keyVal %= 26;
                  char replaceVal = ALPHABET.charAt(keyVal);
                  cipherText += replaceVal;
              }

              return cipherText.toUpperCase();

          }

          public static String AutoKeydecrypt(String cipherText, int shiftKey){
                String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
                cipherText = cipherText.toLowerCase();

                String plainText = "";

                for (int i = 0; i < cipherText.length(); i++) {
                  int charPosition = ALPHABET.indexOf(cipherText.charAt(i));
                  int keyVal = 999;
                    if(i == 0){
                      keyVal = (charPosition - shiftKey);
                    }
                    else{
                      int charPosition_ = ALPHABET.indexOf(plainText.charAt(i-1));
                      keyVal = (charPosition - charPosition_);
                    }
                    if (keyVal < 0)
					               keyVal += 26;
                    char replaceVal = ALPHABET.charAt(keyVal);
                    plainText += replaceVal;
                }

                return plainText;

            }
}
