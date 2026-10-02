import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class ScoreTrakker {

    private ArrayList<Student> allStudents;

    public ScoreTrakker() {
        allStudents = new ArrayList<Student>();
    }

    public void loadDataFile(String fName) throws FileNotFoundException {
        Scanner input = new Scanner(new File(fName));

        while (input.hasNextLine()) {
            String name = input.nextLine();
            String score = input.nextLine();
            int numscore = Integer.parseInt(score);

            allStudents.add(new Student(name, numscore));
        }

        input.close();
    }

    public void printInOrder() {
        Collections.sort(allStudents);

        System.out.println("Student Score List");

        for (Student student : allStudents) {
            System.out.println(student);
        }
    }

    public void processFiles() {
        try {
            loadDataFile("scores.txt");
            printInOrder();
        }catch (FileNotFoundException e) {
            System.out.println("Can't open file");
        }
    }

    public static void main(String[] args) {
        ScoreTrakker scoreTrakker = new ScoreTrakker();
        scoreTrakker.processFiles();
    }
}