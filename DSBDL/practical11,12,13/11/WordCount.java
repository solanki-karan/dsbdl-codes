import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
        // File path of the input file
        String filePath = "C:\\\\Users\\\\Vedant\\\\OneDrive\\\\Desktop\\\\Internship\\\\data science code\\\\11\\\\input.txt";

        try {
            // Open the file
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            StringBuilder paragraphBuilder = new StringBuilder();

            // Read each line from the file and append to the paragraph
            while ((line = bufferedReader.readLine()) != null) {
                paragraphBuilder.append(line).append("\n");
            }

            // Close the file
            bufferedReader.close();

            // Get the paragraph as a string
            String paragraph = paragraphBuilder.toString();

            // Count words in the paragraph and display word count
            countAndDisplayWordOccurrences(paragraph);

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    // Method to count occurrences of each word in the paragraph
    private static void countAndDisplayWordOccurrences(String paragraph) {
        // Split the paragraph into words using space as delimiter
        String[] words = paragraph.split("\\s+");

        // Map to store word occurrences
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Count occurrences of each word
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        // Display word occurrences
        System.out.println("Number of occurrences of each word:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
