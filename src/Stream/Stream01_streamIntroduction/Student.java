package Stream.Stream01_streamIntroduction;

public class Student {
    public Student(String name, int score) {
        this.name = name;
        Score = score;
    }

    private String name;
    private int Score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return Score;
    }

    public void setScore(int score) {
        Score = score;
    }
}
