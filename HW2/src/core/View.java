package core;

import java.util.Collection;
import java.util.Scanner;

public class View {
    String file;
    Collection<String> words;

    public View(String filename) {
        this.file = filename;
        Repository repository = new Repository(this.file);
        try {
            this.words = repository.getWords();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Analyzer analyzer = new Analyzer(this.words);
        while (true) {
            int action = getOperator();
            if (action < 4) {
                analyzer.analyze(action);
                System.out.println(" ");
            } else if (action == 4) {
                break;
            } else {
                System.out.println("Error");
            }
        }
    }

    private int getOperator() {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("Select an action: \n");
        sb.append("1 Count the number of words\n");
        sb.append("2 Find the longest word\n");
        sb.append("3 Count the repeated words\n");
        sb.append("4 Exit\n");
        System.out.println(sb);
        try {
            int act = Integer.parseInt(in.nextLine());
            return act;
        } catch (NumberFormatException e) {
            System.out.println(" Symbol error");
            return getOperator();
        }


    }
}