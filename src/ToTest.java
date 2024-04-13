import DataBase.Cloud;
import DataBase.DataRepository;
import DataBase.Student;
import DataBase.Subject;

import java.util.Arrays;
import java.util.PriorityQueue;

public class ToTest {
    public static void main(String[] args) {

        Cloud c= new Cloud();
        Subject subj= (c.getSubjectByName("Math"));
        DataRepository dr= new DataRepository(subj);
        System.out.println(dr.getRanking());
        System.out.println(Arrays.toString(dr.getAllNamesInRanking()));
//        String [] s= c.getAllSubjectNames();
//        for(int i=0;i<s.length;i++){
//            System.out.println(s[i]);
//        }
//        System.out.println(c.containsSubjName("Math"));
//        System.out.println(c.isDataExist("Computer Science"));
//        System.out.println(c.isDataExist("Math"));










//        PriorityQueue<Student> pq = new PriorityQueue<>();
//        pq.add(new Student("Alice", 1, 90, 1));
//        pq.add(new Student("Bob", 2, 80, 2));
//        pq.add(new Student("Charlie", 3, 95, 3));
//        while (!pq.isEmpty()) {
//            Student student = pq.poll();
//            System.out.println("DataBase.Student: " + student.getName() + ", Grade: " + student.getNumericGrade());
//        }
//        Student s1 = new Student("Alice", 1, 90, 1);
//        Student s2 = new Student("Bob", 2, 80, 2);
//        Student s3 = new Student("Charlie", 3, 95, 3);
//        DataRepository DR = new DataRepository(new Subject("math",100));
////        DR.addStudent(s1,new Subject("math",100));
////        DR.addStudent(s2,new Subject("math",100));
////        DR.addStudent(s3,new Subject("math",100));
//        System.out.println(DR.getStudents());
//        System.out.println(DR.getRanking());
    }
}
