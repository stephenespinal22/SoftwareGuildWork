/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentquizscores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author stephenespinal
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // TODO code application logic here
        String studentName;
        UserIO io = new UserIO();
        Map<String, ArrayList<Integer>> studentGrades = new HashMap<>();

        //main menu
        boolean keepGoing = true;
        int menuSelection = 0;
        while (keepGoing) {

            io.print("Main Menu");
            io.print("1. List Students");
            io.print("2. Create New Student");
            io.print("3. Remove a Student");
            io.print("4. View a Student's Scores");
            io.print("5. View a Student's Average");
            io.print("6. Average Score Of Class");
            io.print("7. Student With Highest Quiz Score");
            io.print("8. Student With Lowest Quiz Score");
            io.print("9. Exit");

            menuSelection = io.readInt("Please select from the"
                    + " above choices: ", 1, 9);

            switch (menuSelection) {
                case 1:

                    io.print("\nList of all Students");
                    // get the Set of keys from the map
                    Set<String> keys = studentGrades.keySet();

                    // print the keys to the screen - is the order they are printed
                    // what you would expect?
                    for (String k : keys) {
                        io.print(k);
                    }
                    io.print("");
                    break;
                case 2:
                    studentName = io.readString("\nEnter Student Name: ");
                    ArrayList<Integer> grades = new ArrayList<>();
                    grades.add(io.readInt("Enter Quiz 1 Grade: "));
                    grades.add(io.readInt("Enter Quiz 2 Grade: "));

                    studentGrades.put(studentName, grades);
                    io.print("Student Added.\n");
                    break;
                case 3:
                    studentGrades.remove(io.readString("\nEnter Student Name: "));
                    io.print("Student Removed.\n");
                    break;
                case 4:
                    io.print(studentGrades.get(io.readString("\nEnter Student Name: ")).toString());
                    io.print("");
                    break;
                case 5:
                    getStudentAverage(io, studentGrades);
                    break;
                case 6:
                    classAverage(studentGrades, io);
                    break;
                case 7:
                    highestGrade(studentGrades, io);
                    break;
                case 8:
                    int highestGrade = returnHighestGrade(studentGrades, io);
                    lowestGrade(studentGrades, io,highestGrade);
                    break;
                case 9:
                    io.print("\nGood Bye.");
                    keepGoing = false;
                    break;
                default:
                    io.print("Unknown Input");
                    break;
            }
        }

    }

    public static void highestGrade(Map<String, ArrayList<Integer>> studentGrades, UserIO io) {
        int highestGrade = 0;
        int highestGradeOverAll = 0;
        String studentWithHighestGrade = "";

        Set<String> allKeys = studentGrades.keySet();

        //go through all of hash map
        for (String k : allKeys) {

            //at each arraylist in the map we create a new arraylist to iterate through
            ArrayList<Integer> tempGradeArray = studentGrades.get(k);

            for (int i : tempGradeArray) {
                if (highestGrade < i) {
                    highestGrade = i;
                }
            }

            if (highestGradeOverAll < highestGrade) {
                highestGradeOverAll = highestGrade;
                studentWithHighestGrade = k;
            }
        }
        io.print("\nThe Student With The Highest Grade is: " + studentWithHighestGrade + "\n");
    }

    public static void lowestGrade(Map<String, ArrayList<Integer>> studentGrades, UserIO io, int highestGrade) {
        //set to the highest grade for comparison
        int lowestGrade = highestGrade;
        int lowestGradeOverAll = highestGrade;
        String studentWithLowestGrade = "";

        Set<String> allKeys = studentGrades.keySet();

        //go through all of hash map
        for (String k : allKeys) {

            //at each arraylist in the map we create a new arraylist to iterate through
            ArrayList<Integer> tempGradeArray = studentGrades.get(k);

            for (int i : tempGradeArray) {
                if (lowestGrade > i) {
                    lowestGrade = i;
                }
            }

            if (lowestGradeOverAll > lowestGrade) {
                lowestGradeOverAll = lowestGrade;
                studentWithLowestGrade = k;
            }
        }
        io.print("\nThe Student With The Lowest Grade is: " + studentWithLowestGrade + "\n");
    }

    public static int returnHighestGrade(Map<String, ArrayList<Integer>> studentGrades, UserIO io) {
        int highestGrade = 0;
        int highestGradeOverAll = 0;

        Set<String> allKeys = studentGrades.keySet();

        //go through all of hash map
        for (String k : allKeys) {

            //at each arraylist in the map we create a new arraylist to iterate through
            ArrayList<Integer> tempGradeArray = studentGrades.get(k);

            for (int i : tempGradeArray) {
                if (highestGrade < i) {
                    highestGrade = i;
                }
            }

            if (highestGradeOverAll < highestGrade) {
                highestGradeOverAll = highestGrade;
            }
        }
        return highestGradeOverAll;
    }

    public static void getStudentAverage(UserIO io, Map<String, ArrayList<Integer>> studentGrades) {
        String studentName;
        studentName = io.readString("\nEnter Student Name: ");
        ArrayList<Integer> gradesForAvg = studentGrades.get(studentName);
        // print every String in our list with an enhanced for loop
        int sum = 0;
        for (int i : gradesForAvg) {
            sum += i;
        }
        io.print("The Average is: " + sum / gradesForAvg.size() + "\n");
    }

    public static void classAverage(Map<String, ArrayList<Integer>> studentGrades, UserIO io) {
        //this array will contain all grades of each student
        ArrayList<Integer> classAverage = new ArrayList<>();

        Set<String> allKeys = studentGrades.keySet();

        //go through all of hash map
        for (String k : allKeys) {

            //at each arraylist in the map we create a new arraylist to iterate through
            ArrayList<Integer> gradesForClassAvg = studentGrades.get(k);

            for (int i : gradesForClassAvg) {
                //add each grade into the arrayList we will use to calculate
                classAverage.add(i);
            }
        }

        //calculate the average of ArrayList
        int classSum = 0;
        for (int i : classAverage) {
            classSum += i;
        }
        io.print("\nThe Class Average is: " + classSum / classAverage.size() + "\n");
    }

}
