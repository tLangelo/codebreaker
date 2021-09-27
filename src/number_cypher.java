import java.util.Scanner;

public class number_cypher {
    public static Scanner scanner = new Scanner(System.in);
    public static String alphabet = " abcdefghijklmnopqrstuvwxyzæøå";
    //public static String numberAlphabet = "0123456789101112";

    // Encoder
    public static void numberCypherEncoder(String stringToEncode){
        for (int i = 0; i < stringToEncode.length(); i++) {
            if(i<stringToEncode.length()-1){
                System.out.print(alphabet.indexOf((stringToEncode.charAt(i))) + ";");
            }
            else{
                System.out.print(alphabet.indexOf(stringToEncode.charAt(i)));
            }

        }
    }
    // Decoder
    public static void numberCypherDecoder(String stringToDecode){
        for (int i = 0; i < stringToDecode.length(); i++) {
            if(i==1){

            }
        }


    }

    public static void main(String[] args) {
        String userInput = scanner.nextLine();
        numberCypherEncoder(userInput);


    }
}
