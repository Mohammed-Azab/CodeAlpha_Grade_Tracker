package DataBase;

import java.util.ArrayList;

public class Subject {
    private String name;
    private double Maxgrade;
    private ArrayList<Student> students;
    public Subject(String name, int Maxgrade) {
        this.name = name;
        this.Maxgrade = Maxgrade;
    }
    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }
    public String getName() {
        return name;
    }
    public double getMaxgrade() {
        return Maxgrade;
    }
    public void setMaxgrade(int Maxgrade) {
        this.Maxgrade = Maxgrade;
    }
    public ArrayList<Student> getStudents() {
        return students;
    }



    
}
