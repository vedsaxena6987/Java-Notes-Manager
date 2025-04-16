
import java.io.*;
import java.util.Scanner;

public class Java_Notes_Manager {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // 1. Create JavaFile1.txt
            FileWriter writer1 = new FileWriter("JavaFile1.txt");
            String content1 = "Java is an object-oriented programming language.\n"
                    + "It supports encapsulation, inheritance, and polymorphism.\n"
                    + "File handling in Java allows for efficient reading and searching of text.\n"
                    + "Keep learning and mastering Java!\n";
            writer1.write(content1);
            writer1.close();
            System.out.println("JavaFile1.txt created successfully.\n");

            // 2. Display content of JavaFile1.txt
            System.out.println("Contents of JavaFile1.txt:");
            BufferedReader reader1 = new BufferedReader(new FileReader("JavaFile1.txt"));
            String line;
            while ((line = reader1.readLine()) != null) {
                System.out.println(line);
            }
            reader1.close();
            System.out.println();

            // 3. Create JavaFile2.txt
            FileWriter writer2 = new FileWriter("JavaFile2.txt");
            String content2 = "This is the first line in this JavaFile2.txt file.\n";
            writer2.write(content2);
            writer2.close();
            System.out.println("JavaFile2.txt created successfully.\n");

            // 4. Copy content from JavaFile1.txt to JavaFile2.txt (append)
            FileWriter writer2Append = new FileWriter("JavaFile2.txt", true);
            BufferedReader reader2 = new BufferedReader(new FileReader("JavaFile1.txt"));
            while ((line = reader2.readLine()) != null) {
                writer2Append.write(line + "\n");
            }
            reader2.close();
            writer2Append.close();
            System.out.println("Content from JavaFile1.txt copied to JavaFile2.txt.\n");

            // 5. Analyze JavaFile1.txt
            BufferedReader analysisReader = new BufferedReader(new FileReader("JavaFile1.txt"));
            int charCount = 0;
            int lineCount = 0;
            int wordCount = 0;
            int polymorphismCount = 0;
            int lineNumber = 0;
            String wordToFind = "polymorphism";

            System.out.println("Analyzing JavaFile1.txt...");
            while ((line = analysisReader.readLine()) != null) {
                lineNumber++;
                charCount += line.length();
                lineCount++;
                String[] lineWords = line.split("\\s+");
                wordCount += lineWords.length;

                for (String word : lineWords) {
                    // Remove punctuation from each word before comparing
                    word = word.replaceAll("[^a-zA-Z]", "");
                    if (word.equalsIgnoreCase(wordToFind)) {
                        polymorphismCount++;
                        System.out.println("Word \"" + wordToFind + "\" found at line number: " + lineNumber);
                    }
                }
            }
            analysisReader.close();

            System.out.println("\nAnalysis Summary:");
            System.out.println("Total number of characters: " + charCount);
            System.out.println("Total number of lines: " + lineCount);
            System.out.println("Total number of words: " + wordCount);
            System.out.println("Total occurrences of \"" + wordToFind + "\": " + polymorphismCount);

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }
}
