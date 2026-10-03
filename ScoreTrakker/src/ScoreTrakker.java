import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScoreTrakker {

    private ArrayList<Student> allStudents;
    private String[] files = {"../scores.txt", "../badscore.txt", "nofile.txt"};

    public ScoreTrakker() {
        allStudents = new ArrayList<Student>();
    }

    public void loadDataFile(String fName) throws FileNotFoundException {
        allStudents = new ArrayList<Student>();
        Scanner input = new Scanner(new File(fName));

        while (input.hasNextLine()) {
            String name = input.nextLine();

            if (!input.hasNextLine()) {
                break;
            }

            String scoreStr = input.nextLine();

            try {
                int numScore = Integer.parseInt(scoreStr);
                allStudents.add(new Student(name, numScore));
            } catch (NumberFormatException e) {
                System.out.println("Incorrect format for " + name + " not a valid score: " + scoreStr);
            }
        }

        input.close();
    }

    public void printInOrder() {
        Collections.sort(allStudents);

        System.out.println("Student Score List");

        for (Student student : allStudents) {
            System.out.println(student);
        }
        System.out.println();
    }

    public void processFiles() {
        for (String fileName : files) {
            try {
                loadDataFile(fileName);
                printInOrder();
            } catch (FileNotFoundException e) {
                System.out.println("Can't open file");
                System.out.println();
            }
        }
        
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }
}