import java.util.Scanner;

import dictionary.Dictionary;
import dictionary.helper.DictionaryHelper;
import dictionary.helper.trie.TrieDictionaryHelper;

public class Main {

    private static void printMessage(Dictionary.Operation operation, boolean isSuccess) {
        System.out.printf("<<<<< %s operation, success = %s >>>>>\n", operation, isSuccess);
    }
    public static void main(String[] args) {
        DictionaryHelper dictionaryHelper = new TrieDictionaryHelper();
        Dictionary dictionary = new Dictionary(dictionaryHelper);
        Scanner reader = new Scanner(System.in);
        boolean breakOutOfLoop = false;
        System.out.println("Welcome to our dictionary application, below are the supported operations:-");
        for (Dictionary.Operation operation : Dictionary.Operation.values()) {
            System.out.println(operation);
        }
        while (!breakOutOfLoop) {
            System.out.println("===== Input the operation you want to perform! =====");
            Dictionary.Operation requestedOperation = Dictionary.Operation.parse(reader.next());
            String word = "";
            switch (requestedOperation) {
            case INSERT:
                System.out.println("=== Input the desired word ===");
                word = reader.next();
                printMessage(requestedOperation, dictionary.insert(word));
                break;
            case SEARCH:
                System.out.println("=== Input the desired word ===");
                word = reader.next();
                printMessage(requestedOperation, dictionary.search(word));
                break;
            case DELETE:
                System.out.println("=== Input the desired word ===");
                word = reader.next();
                printMessage(requestedOperation, dictionary.delete(word));
                break;
            case EXIT:
                breakOutOfLoop = true;
                System.out.println("Thank you for using our dictionary application, exiting . . . . ");
                break;
            }
        }
        reader.close();
    }
}
