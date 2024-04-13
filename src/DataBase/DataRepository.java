package DataBase;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DataRepository {

    private final ArrayList<Student> students;
    private final PriorityQueue<Student> ranking;

    public DataRepository(Subject subject) {
        this.students = subject.getStudents();
        this.ranking = new PriorityQueue<>();
        this.ranking.addAll(students);
    }

    public double getAverage() {
        double sum = 0;
        for (Student student : students) {
            sum += student.getGrade();
        }
        return sum / students.size();
    }

    public double getHighestGrade() {
        assert ranking.peek() != null;
        return ranking.peek().getGrade();
    }

    public double getLowestGrade() {
        double lowestGrade = students.getFirst().getGrade();
        for (Student student : students) {
            if (student.getGrade() < lowestGrade) {
                lowestGrade = student.getGrade();
            }
        }
        return lowestGrade;
    }

    public String[] getAllNamesInRanking() {
        String[] names = new String[ranking.size()];
        int i = 0;
        while (!ranking.isEmpty()) {
            Student student = ranking.poll();
            names[i++] = student.getName();
        }
        revive();
        return names;
    }

    public double[] getAllGradesInRanking() {
        double[] grades = new double[ranking.size()];
        int i = 0;
        while (!ranking.isEmpty()) {
            Student student = ranking.poll();
            grades[i++] = student.getGrade();
        }
        revive();
        return grades;
    }

    public int[] getAllIdsInRanking() {
        int[] IDS = new int[ranking.size()];
        int i = 0;
        while (!ranking.isEmpty()) {
            Student student = ranking.poll();
            IDS[i++] = student.getId();
        }
        revive();
        return IDS;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public PriorityQueue<Student> getRanking() {
        return ranking;
    }
    public void revive(){
        this.ranking.addAll(students);
    }
}
