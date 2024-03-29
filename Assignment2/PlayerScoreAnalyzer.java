package Assignment2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PlayerScoreAnalyzer {

    public static void main(String[] args) {
        String filename = "E:/untitled/src/Assignment2/Scores.csv";
        Map<String, Integer> highestScores = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                String playerName = data[0];
                for (int i = 1; i < data.length; i++) {
                    int score = extractScore(data[i]);
                    highestScores.put(playerName, Math.max(highestScores.getOrDefault(playerName, 0), score));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print the highest scores for each player
        for (Map.Entry<String, Integer> entry : highestScores.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static int extractScore(String scoreEntry) {
        String[] parts = scoreEntry.split("_");
        if (parts.length > 1) {
            try {
                return Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                // Handle if score is not a valid integer
            }
        }
        return 0; // Default score if unable to extract or parse
    }
}
