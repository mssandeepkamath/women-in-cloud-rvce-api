package com.workspace.management.restfulapi_workspace_management.Entity;

public class StudentChapter {
    private String president;
    private String vice_President;
    private String treasurer;
    private String faculty;
    private String year; //year of student chapter

    public StudentChapter() {
        super();
    }

    public StudentChapter(String president, String vice_President, String treasurer, String faculty, String year) {
        super();
        this.president = president;
        this.vice_President = vice_President;
        this.treasurer = treasurer;
        this.faculty = faculty;
        this.year = year;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getVice_President() {
        return vice_President;
    }

    public void setVice_President(String vice_President) {
        this.vice_President = vice_President;
    }

    public String getTreasurer() {
        return treasurer;
    }

    public void setTreasurer(String treasurer) {
        this.treasurer = treasurer;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "StudentChapter{" +
                "president='" + president + '\'' +
                ", vice_President='" + vice_President + '\'' +
                ", treasurer='" + treasurer + '\'' +
                ", faculty='" + faculty + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
