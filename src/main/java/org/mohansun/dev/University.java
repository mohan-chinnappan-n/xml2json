package org.mohansun.dev;

import java.util.ArrayList;


public class University {

    private String name;
    private int noOfDepartments;
    private ArrayList<String> departments;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfDepartments() {
        return noOfDepartments;
    }

    public void setNoOfDepartments(int noOfDepartments) {
        this.noOfDepartments = noOfDepartments;
    }

    public ArrayList<String> getDepartments() {
        return departments;
    }

    public void setDepartments(ArrayList<String> departments) {
        this.departments = departments;
    }

}
