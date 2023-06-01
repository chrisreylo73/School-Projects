/*
 * CS 2050 - Computer Science II - Summer 2020
 * Instructor: Thyago Mota
 * Description: Activity 20 - SortingObjectsSol class
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SortingObjects {

    private static final String NAMES_FILENAME = "names.txt";

    // TODOd: merge the two given lists returning a new list with the elements sorted
    public static LinkedList<Student> merge(LinkedList<Student> left, LinkedList<Student> right) {
        int i = 0, j = 0;
        LinkedList<Student> sorted = new LinkedList<>();
        while (i < left.size() && j < right.size()) {
            Student leftStudent  = left.get(i);
            Student rightStudent = right.get(j);
            if (leftStudent.compareTo(rightStudent) < 0) {
                sorted.append(leftStudent);
                i++;
            }
            else {
                sorted.append(rightStudent);
                j++;
            }
        }
        while (i < left.size()) {
            Student leftStudent  = left.get(i++);
            sorted.append(leftStudent);
        }
        while (j < right.size()) {
            Student rightStudent  = right.get(j++);
            sorted.append(rightStudent);
        }
        left.clear();
        right.clear();
        return sorted;
    }

    // TODOd: implement merge sort using a linked list
    public static LinkedList<Student> mergeSort(LinkedList<Student> students) {

        // TODOd: implement the base case
        if (students.size() <= 1)
            return students;

        // TODOd: divide the students list into two lists: left and right
        int middle = students.size() / 2;
        LinkedList<Student> left = new LinkedList<>();
        for (int i = 0; i < middle; i++)
            left.append(students.get(i));
        LinkedList<Student> right = new LinkedList<>();
        for (int i = middle; i < students.size(); i++)
            right.append(students.get(i));

        // TODOd: recursively call mergeSort w/ left and right linked lists
        left  = mergeSort(left);
        right = mergeSort(right);

        // TODOd: return the result of merging left and right linked lists
        return merge(left, right);
    }

    public static void main(String[] args) throws FileNotFoundException {

        LinkedList<Student> students = new LinkedList<>();
        Scanner in = new Scanner(new FileInputStream(NAMES_FILENAME));
        int id = 1;
        while (in.hasNextLine()) {
            String name = in.nextLine();
            Student student = new Student(id, name);
            students.append(student);
            id++;
        }
        in.close();
        System.out.println(students);
        LinkedList<Student> studentsSorted = mergeSort(students);
        System.out.println(studentsSorted);
    }
}

