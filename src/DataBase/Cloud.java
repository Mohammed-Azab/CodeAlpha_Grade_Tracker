package DataBase;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Cloud {
   private HashMap<Subject, ArrayList<Student>> Data;
   public Cloud() {
       this.Data = new HashMap<>();
       Subject s1= new Subject("Math",105);
       Subject s2= new Subject("Biology",100);
       Subject s3= new Subject("Digital Logic Design",102);
       Subject s4= new Subject("Chemistry",107);
       Subject s5= new Subject("Computer Science",105);
       Data.put(s1,new ArrayList<>());
       Data.put(s2,new ArrayList<>());
       Data.put(s3,new ArrayList<>());
       Data.put(s4,new ArrayList<>());
       Data.put(s5,new ArrayList<>());
       s1.setStudents(Data.get(s1));
       s2.setStudents(Data.get(s2));
       s3.setStudents(Data.get(s3));
       s4.setStudents(Data.get(s4));
       s5.setStudents(Data.get(s5));
       LoadData(s1);
   }

    public Cloud(HashMap<Subject, ArrayList<Student>> Data) {
       this.Data = Data;
    }

    public  HashMap<Subject, ArrayList<Student>> getData() {
       return Data;
    }

    public void setData(HashMap<Subject, ArrayList<Student>> data) {
       this.Data = data;
    }

    public boolean isEmpty(){
       return Data.isEmpty();
    }

    public Subject getSubjectByName(String name) {
        for (Subject subject : Data.keySet()) {
            if (subject.getName().equals(name)) {
                return subject;
            }
        }
        return null;
    }
    public String[] getAllSubjectNames() {
       String[] names = new String[this.getData().size()];
       int i = 0;
       for (Subject subject : Data.keySet()) {
           names[i++] = subject.getName();
       }
       return names;
    }

    public void addStudent(Subject subject, Student student) {
       Data.get(subject).add(student);
    }

    public void removeStudent(Subject subject, Student student) {
        Data.get(subject).remove(student);
    }

    public void removeSubject(Subject subject) {
       Data.get(subject).clear();
    }
    public boolean containsSubjName(String subject){
        for (Subject subj : Data.keySet()) {
           if (subj.getName().equals(subject)) {
               return true;
           }
        }
        return false;
    }

    public boolean isDataExist(String subject) {
        Subject s= this.getSubjectByName(subject);
        if (s == null) {
            return false;
        }
        if (this.Data.get(s)==null){
            return false;
        }
        return !this.Data.get(s).isEmpty();
    }

    public void LoadData(Subject subject) {
        Random random = new Random();
        int idCounter = 1234;

        for (int i = 0; i < 75; i++) {
            String firstName = getRandomName();
            int grade = random.nextInt(105) + 1;
            int id = idCounter++;
            Student student = new Student(firstName,13 ,grade, id);
            this.addStudent(subject, student);
        }
    }

    public static String getRandomName() {
        String[] names = {"Liam", "Olivia", "Noah", "Emma", "Oliver", "Ava", "Elijah", "Charlotte", "William", "Amelia", "James", "Sophia",
                "Benjamin", "Isabella", "Lucas", "Mia", "Henry", "Harper", "Alexander", "Evelyn", "Michael", "Abigail", "Daniel", "Emily",
                "Matthew", "Elizabeth", "Joseph", "Sofia", "Jackson", "Avery", "Samuel", "Ella", "Sebastian", "Scarlett", "David", "Madison",
                "Carter", "Luna", "Wyatt", "Grace", "Jayden", "Chloe", "John", "Lily", "Owen", "Aria", "Jack", "Addison", "Luke", "Natalie",
                "Levi", "Hannah", "Gabriel", "Zoe", "Isaac", "Penelope", "Julian", "Victoria", "Christopher", "Bella", "Jaxon", "Nova", "Lincoln",
                "Aurora", "Ryan", "Emilia", "Mateo", "Stella", "Leo", "Everly", "Nathan", "Willow", "Caleb", "Mila", "Nicholas"};
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }



}
