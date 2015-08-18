package Fragments;

/**
 * Created by CJ-SERVER on 8/17/2015.
 */
public  class ExpertModel {
    private int id;
    private String name;
    private String location;
    private String education;
    private String specialization;
    private String mobile;

    public ExpertModel(int id, String name, String location, String education, String specialization, String mobile) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.education = education;
        this.specialization = specialization;
        this.mobile = mobile;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}