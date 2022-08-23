package Lamda.lambdaTestStudentAvg;

public class Student {
    private String name;
    private int mathScore;
    private int middleScore;

    private String gender;


    public Student(String name, int mathScore, int middleScore, String gender) {
        this.name = name;
        this.mathScore = mathScore;
        this.middleScore = middleScore;
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getMathScore() {
        return mathScore;
    }

    public void setMathScore(int mathScore) {
        this.mathScore = mathScore;
    }

    public int getMiddleScore() {
        return middleScore;
    }

    public void setMiddleScore(int middleScore) {
        this.middleScore = middleScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
