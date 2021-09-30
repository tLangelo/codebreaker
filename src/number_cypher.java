import java.util.Scanner;

public class number_cypher {
    public static Scanner scanner = new Scanner(System.in);
    public static String alphabet = "abcdefghijklmnopqrstuvwxyzæøå";
    public static String alphabetWithSpace = " abcdefghijklmnopqrstuvwxyzæøå";

    // Encoder/Decoder Initializer
    public static void initializer(){
        boolean isLoopOn = true;
        String nameOfPerson = getName();
        String longTextLine = "\n---------------------------------------------------------------\n";

        System.out.println("Welcome dear " + nameOfPerson + ", pleased to meet you. " +
                "\nWhat would you like to do today?" +
                "\n1.\tNumber Cypher Encoder" + "\t🔢|🔢\t2.\tNumber Cypher Decoder" +
                "\n3.\tCaesar Cypher Encoder" + "\t🏛|🏛\t4.\tCaesar Cypher Decoder" +
                longTextLine);
        do {
            String userChoice = scanner.nextLine();
            switch (userChoice) {
                case "1":
                    isLoopOn = false;
                    System.out.println(longTextLine + "You've chosen 'Number Cypher Encoder'." +
                            "\nPlease input the message you'd like to encode.");
                    String messageToEncode = scanner.nextLine();
                    numberCypherEncoder(messageToEncode);
                    break;
                case "2":
                    isLoopOn = false;
                    System.out.println("You've chosen 'Number Cypher Decoder'." +
                            "\nPlease input the message you'd like to decode.");
                    String messageToDecode = scanner.nextLine();
                    numberCypherDecoder(messageToDecode);
                    break;
                case "3":
                    isLoopOn = false;
                    System.out.println("You've chosen 'Caesar Cypher Encoder'." +
                            "\nPlease input the message you'd like to encode.");
                    String messageToCaesarEncode = scanner.nextLine();
                    caesarEncoder(messageToCaesarEncode);
                    break;
                case "4":
                    isLoopOn = false;
                    System.out.println("You've chosen 'Caesar Cypher Decoder'." +
                            "\nPlease input the message you'd like to decode.");
                    String messageToCaesarDecode = scanner.nextLine();
                    caesarDecoder(messageToCaesarDecode);
                    break;
                default:
                    System.out.println("Invalid input. Please try again");
            }
        } while(isLoopOn == true);
    }
    // Name Grabber
    public static String getName(){
        String username = "";
        System.out.println("Salutations, what's your name?");
        username = scanner.nextLine();

        return username;
    }
    // Encoder
    public static void numberCypherEncoder(String stringToEncode){
        for (int i = 0; i < stringToEncode.length(); i++) {
            // if statement to make "message" more readable and usable for decoder
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
      // using .split with ';' to make string to an array
      String[] stringToIntArray = stringToDecode.split(";");
      String decodedString = "";
        // foreach loop to create the message in relative to our alphabet.
        for (String str: stringToIntArray) {
            // making try/catch since we're expecting a specific format
            try {
                // making numbers in string int(s)
                int index = Integer.parseInt(str);
                decodedString = decodedString + alphabet.charAt(index);
            }catch(NumberFormatException e){
                System.out.println("Invalid number formatting.");
                return;
            }
        }
        System.out.print(stringToDecode + "\t\t->\t\t" + decodedString);

    }
    // Caesar Encoder
    public static void caesarEncoder(String stringToCaesarEncode) {
        // Variables
        int currentChar;
        char firstLetterOfAlphabet = alphabet.charAt(0);
        char lastLetterOfAlphabet = alphabet.charAt(alphabet.length() - 1);
        // making chars relative to alphabet instead of ascii
        int startOfAlphabetIndex = alphabet.indexOf(firstLetterOfAlphabet);
        int endOfAlphabetIndex = alphabet.indexOf(lastLetterOfAlphabet);

        String caesarEncodedMessage = "";
        int offsetMessageBy = 3;


        // for loop to change the chars
        for (int i = 0; i < stringToCaesarEncode.length(); i++) {
            try {
                currentChar = stringToCaesarEncode.charAt(i);
                currentChar = alphabet.indexOf(currentChar);
                // if statement to check if in range of our alphabet and offsetting if true
                if (currentChar >= startOfAlphabetIndex && currentChar <= endOfAlphabetIndex) {
                    currentChar = (char) (currentChar + offsetMessageBy);
                    // if statement to get to the start of alphabet if it exceeds the length
                    if (currentChar > endOfAlphabetIndex) {
                        currentChar = (char) (currentChar - (endOfAlphabetIndex + 1));
                        // ^Same as^
                        // currentChar = (char)(currentChar + startOfAlphabetIndex - alphabet.length());
                    }
                }
            // adding to the final message
            caesarEncodedMessage = caesarEncodedMessage + alphabet.charAt(currentChar);

            }
            catch(Exception e){
            System.out.println("Invalid formatting.");
            return;
            }
        }

        System.out.println(stringToCaesarEncode + "\t\t->\t\t" + caesarEncodedMessage);
    }
    // Caesar Decoder
    public static void caesarDecoder(String stringToCaesarDecode){
        //--------------------
        //Somewhat the same as the encoder, but we're offsetting by -3 instead,
        //and checking if it goes under our startOfAlphabetIndex
        //--------------------

        // Variables
        int currentChar;
        char firstLetterOfAlphabet = alphabet.charAt(0);
        char lastLetterOfAlphabet = alphabet.charAt(alphabet.length() - 1);
        // Making chars relative to alphabet variable instead of ascii
        int startOfAlphabetIndex = alphabet.indexOf(firstLetterOfAlphabet);
        int endOfAlphabetIndex = alphabet.indexOf(lastLetterOfAlphabet);

        String caesarEncodedMessage = "";
        int offsetMessageBy = -3;


        // For loop to change the chars
        for (int i = 0; i < stringToCaesarDecode.length(); i++) {
            try {
                currentChar = stringToCaesarDecode.charAt(i);
                currentChar = alphabet.indexOf(currentChar);
                // if statement to check if in range of our alphabet and offsetting if true
                if (currentChar >= startOfAlphabetIndex && currentChar <= endOfAlphabetIndex) {
                    currentChar = (currentChar + offsetMessageBy);
                    // if statement to get to the end of alphabet if it goes under the length
                    if (currentChar < startOfAlphabetIndex) {
                        currentChar = (char) (currentChar + (endOfAlphabetIndex + 1));
                        // ^Same as^
                        // currentChar = (char)(currentChar + startOfAlphabetIndex + alphabet.length());
                    }
                }
                // adding to the final message
                //(Not familiar with StringBuilder)
                caesarEncodedMessage = caesarEncodedMessage + alphabet.charAt(currentChar);

            }
            catch(Exception e){
                System.out.println("Invalid formatting.");
                return;
            }
        }

        System.out.println(stringToCaesarDecode + "\t\t->\t\t" + caesarEncodedMessage);
    }

    // Main
    public static void main(String[] args) {
        initializer();

    }
}
