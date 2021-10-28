package database;

public class Info {
    // 학생정보
    private int ID;
    private String name;
    private String birth;
    private String major;


    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public String getBirth() {
        return birth;
    }

    public String getMajor() {
        return major;
    }

}
