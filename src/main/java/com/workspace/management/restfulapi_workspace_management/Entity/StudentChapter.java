package com.workspace.management.restfulapi_workspace_management.Entity;

public class StudentChapter {
    String President;
    String Vice_President;
    String Treasurer;
    String faculty;
    String year; //year of student chapter

    public String getPresident() {
        return President;
    }

    public void setPresident(String president) {
        President = president;
    }

    public String getVice_President() {
        return Vice_President;
    }

    public void setVice_President(String vice_President) {
        Vice_President = vice_President;
    }

    public String getTreasurer() {
        return Treasurer;
    }

    public void setTreasurer(String treasurer) {
        Treasurer = treasurer;
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
}
