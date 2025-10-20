import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FileEncodingDecoding {

    private static final int[] KEY = {5, 12, -3, 8, -9, 4, 10, -1, 2, -4, 7, 21, -6, 11, 13, 1, 2, -1, -2, 0};

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter input file name:");
        String inputFileName = scan.nextLine();

        System.out.println("Enter output file name:");
        String outputFileName = scan.nextLine();

        System.out.println("Enter operation (E for Encrypt, D for Decrypt):");
        String operation = scan.nextLine().toUpperCase();

        try {
            String content = readFileContent(inputFileName);

            Queue<Integer> keyQueue = new LinkedList<>();
            for (int k : KEY) {
                keyQueue.add(k);
            }

            String result = "";
            if (operation.equals("E")) {
                result = encrypt(content, keyQueue);
                System.out.println("Encryption completed.");
            } else if (operation.equals("D")) {
                result = decrypt(content, keyQueue);
                System.out.println("Decryption completed.");
            } else {
                System.out.println("Invalid operation. Use 'E' or 'D'.");
                return;
            }

            writeToFile(outputFileName, result);
            System.out.println("Result saved to " + outputFileName);

        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. " + e.getMessage());
        } finally {
            scan.close();
        }
    }

    private static String readFileContent(String fileName) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(fileName));
        StringBuilder content = new StringBuilder();

        while (fileScanner.hasNextLine()) {
            content.append(fileScanner.nextLine()).append('\n');
        }
        fileScanner.close();

        // Remove the last newline character if it exists
        if (content.length() > 0 && content.charAt(content.length() - 1) == '\n') {
            content.setLength(content.length() - 1);
        }

        return content.toString();
    }

    private static void writeToFile(String fileName, String content) throws FileNotFoundException {
        PrintWriter writer = new PrintWriter(fileName);
        writer.print(content);
        writer.close();
    }

    private static String encrypt(String message, Queue<Integer> keyQueue) {
        StringBuilder encoded = new StringBuilder();
        Integer keyValue;

        for (int scan = 0; scan < message.length(); scan++) {
            keyValue = keyQueue.remove();
            encoded.append((char) (message.charAt(scan) + keyValue));
            keyQueue.add(keyValue);
        }
        return encoded.toString();
    }

    private static String decrypt(String message, Queue<Integer> keyQueue) {
        StringBuilder decoded = new StringBuilder();
        Integer keyValue;

        for (int scan = 0; scan < message.length(); scan++) {
            keyValue = keyQueue.remove();
            decoded.append((char) (message.charAt(scan) - keyValue));
            keyQueue.add(keyValue);
        }
        return decoded.toString();
    }
}
