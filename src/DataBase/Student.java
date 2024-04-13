package DataBase;

public class Student implements Comparable<Student> {
    private final String name;
    private final int ID;
    protected int level;
    protected Object grade;

    public Student(String name, int level, Object grade, int ID) {
        this.name = name;
        this.level = level;
        this.grade = grade;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public double getGrade() {
        Number numericGrade = getNumericGrade();
        if (numericGrade != null) {
            return numericGrade.doubleValue();
        } else {
            System.err.println("Invalid grade format, cannot convert to double");
            return 0.0;
        }
    }
    public int getId() {
        return ID;
    }


    public Number getNumericGrade() {
        if (grade instanceof Integer) {
            return (Integer) grade;
        } else if (grade instanceof Double) {
            return (Double) grade;
        } else if (grade instanceof String) {
            try {
                return Double.parseDouble(String.valueOf(grade));
            } catch (NumberFormatException e) {
                System.err.println("Invalid grade format, please try again");
            }
        }
        System.out.println("Invalid grade format, please try again");
        return null;
    }

    public String toString() {
        return "DataBase.Student [name=" + name + ", level=" + level + ", Grade=" + grade + "]";
    }

    @Override
    public int compareTo(Student o) {
        return (int)(o.getGrade()-this.getGrade());
    }
}
