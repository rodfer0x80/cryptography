import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.HashMap; // Import the Hashmap class to store hash {key:value}

public class main {
    // * Implemented after design

    public static void main(String[] args) {
        // Open data file and handle errors
        try {
            String fileLocation = System.getProperty("user.dir");
            String dataPath = fileLocation + File.separator + "datafile.txt";
            File dataFile = new File(dataPath);
            Scanner dataScanner = new Scanner(dataFile);
            // decoding lang
            HashMap<String, Character> alphabet = new HashMap<String, Character>();
                alphabet.put("V1", 'a');
                alphabet.put("V2", 'A');
                alphabet.put("V3", 'e');
                alphabet.put("V4", 'E');
                alphabet.put("V5", 'i');
                alphabet.put("V6", 'I');
                alphabet.put("V7", 'o');
                alphabet.put("V8", 'O');
                alphabet.put("V9", 'u');
                alphabet.put("V10", 'U');
                alphabet.put("V11", 'y');
                alphabet.put("V12", 'Y');

                alphabet.put("C1", 'b');
                alphabet.put("C2", 'B');
                alphabet.put("C3", 'c');
                alphabet.put("C4", 'C');
                alphabet.put("C5", 'd');
                alphabet.put("C6", 'D');
                alphabet.put("C7", 'f');
                alphabet.put("C8", 'F');
                alphabet.put("C9", 'g');
                alphabet.put("C10", 'G');
                alphabet.put("C11", 'h');
                alphabet.put("C12", 'H');
                alphabet.put("C13", 'j');
                alphabet.put("C14", 'J');
                alphabet.put("C15", 'k');
                alphabet.put("C16", 'K');
                alphabet.put("C17", 'l');
                alphabet.put("C18", 'L');
                alphabet.put("C19", 'm');
                alphabet.put("C20", 'M');
                alphabet.put("C21", 'n');
                alphabet.put("C22", 'N');
                alphabet.put("C23", 'p');
                alphabet.put("C24", 'P');
                alphabet.put("C25", 'q');
                alphabet.put("C26", 'Q');
                alphabet.put("C27", 'r');
                alphabet.put("C28", 'R');
                alphabet.put("C29", 's');
                alphabet.put("C30", 'S');
                alphabet.put("C31", 't');
                alphabet.put("C32", 'T');
                alphabet.put("C33", 'v');
                alphabet.put("C34", 'V');
                alphabet.put("C35", 'w');
                alphabet.put("C36", 'W');
                alphabet.put("C37", 'x');
                alphabet.put("C38", 'X');
                alphabet.put("C39", 'z');
                alphabet.put("C40", 'Z');
            // Parse data from file line by line into stack
            while (dataScanner.hasNextLine()) {
                String msg = dataScanner.nextLine();
                // Encoding/Decoding lang
                

                String decodedMsg = "";
                
                // -- Splits words and adds a space at the end
                for (String word : msg.split(" ")) {
                    String letter = "";
                    // The method used to decrypt the message was as following:
                    // 1. Assign to the variable String letter the first 2 or 3
                    // characters of the word and slices that same portion from
                    // the word variable
                    // 1.1. This is possible by checking if the char at the 3rd
                    /// position is a number or a char 'C' or 'V'
                    // 2. Later we compare the letter variable holding a string
                    // that should be part of our alphabet. Now we simply
                    // compare with our hashmap and when found, we add the 
                    // decoded character to our decodedMsg variable and print it
                    // after going throught the entire line of data 
                    while (word.length() > 2) {
                        if (word.charAt(2) == 'C' || word.charAt(2) == 'V') {
                            letter = word.substring(0, 2);
                            word = word.substring(2);
                            for (String alpha : alphabet.keySet()) {
                                if (alpha.equals(letter)) {
                                    decodedMsg = decodedMsg + alphabet.get(alpha);
                                }
                            }
                        } else {
                            letter = word.substring(0, 3);
                            word = word.substring(3);
                            for (String alpha : alphabet.keySet()) {
                                if (alpha.equals(letter)) {
                                    decodedMsg = decodedMsg + alphabet.get(alpha);
                                }
                            }
                        }
                    }
                    for (String alpha : alphabet.keySet()) {
                        if (alpha.equals(word)) {
                            decodedMsg = decodedMsg + alphabet.get(alpha);
                        }
                    }
                    decodedMsg = decodedMsg + " ";

                }

                System.out.println(decodedMsg);
            }
            dataScanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
