package Task_5;

import java.util.Scanner;

class Candidate {
    int candidateId;
    String name;
    int aptitude;
    int technical;
    int communication;

    Candidate(int candidateId, String name, int aptitude,
              int technical, int communication) {

        this.candidateId = candidateId;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    int getTotalScore() {
        return aptitude + technical + communication;
    }
}

public class TopCandidates {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        Candidate[] candidates = new Candidate[n];

        // Input
        for (int i = 0; i < n; i++) {

            int id = sc.nextInt();
            String name = sc.next();

            int aptitude = sc.nextInt();
            int technical = sc.nextInt();
            int communication = sc.nextInt();

            candidates[i] =
                    new Candidate(id, name, aptitude,
                            technical, communication);
        }

        // Sorting
        for (int i = 0; i < n - 1; i++) {

            for (int j = i + 1; j < n; j++) {

                int score1 = candidates[i].getTotalScore();
                int score2 = candidates[j].getTotalScore();

                if (score1 < score2 ||
                   (score1 == score2 &&
                    candidates[i].candidateId >
                    candidates[j].candidateId)) {

                    Candidate temp = candidates[i];
                    candidates[i] = candidates[j];
                    candidates[j] = temp;
                }
            }
        }

        // Display Top K
        System.out.println("Top " + k + " Candidates:");

        for (int i = 0; i < k; i++) {

            System.out.println(
                candidates[i].candidateId + " "
                + candidates[i].name + " "
                + candidates[i].getTotalScore()
            );
        }
    }
}