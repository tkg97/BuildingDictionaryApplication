package dictionary;

import java.util.Scanner;

import dictionary.search.TrieDictionaryHelper;

public class Dictionary {

    private DictionaryHelper helper;

    private enum Operation {
        INSERT, SEARCH, DELETE, EXIT;

        public static Operation parse(String str) {
            return valueOf(str.toUpperCase());
        }
    }

    public Dictionary(DictionaryHelper helper) {
        this.helper = helper;
    }

    public boolean insert(String word) {
        return helper.insert(word);
    }

    public boolean search(String word) {
        return helper.search(word);
    }

    public boolean delete(String word) {
        return helper.delete(word);
    }

    public void printMessage(Operation operation, boolean isSuccess) {
        System.out.printf("<<<<< %s operation, success = %s >>>>>\n", operation, isSuccess);
    }

    public static void main(String[] args) {
        DictionaryHelper dictionaryHelper = new TrieDictionaryHelper();
        Dictionary dictionary = new Dictionary(dictionaryHelper);
        Scanner reader = new Scanner(System.in);
        boolean breakOutOfLoop = false;
        System.out.println("Welcome to our dictionary application, below are the supported operations:-");
        for (Operation operation : Operation.values()) {
            System.out.println(operation);
        }
        while (!breakOutOfLoop) {
            System.out.println("===== Input the operation you want to perform! =====");
            Operation requestedOperation = Operation.parse(reader.next());
            String word = "";
            switch (requestedOperation) {
            case INSERT:
                System.out.println("=== Input the desired word ===");
                word = reader.next();
                dictionary.printMessage(requestedOperation, dictionary.insert(word));
                break;
            case SEARCH:
                System.out.println("=== Input the desired word ===");
                word = reader.next();
                dictionary.printMessage(requestedOperation, dictionary.search(word));
                break;
            case DELETE:
                System.out.println("=== Input the desired word ===");
                word = reader.next();
                dictionary.printMessage(requestedOperation, dictionary.delete(word));
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
