package com.example.th03;

import java.util.Date;

public class Student {
    public String id;
    public String full_Name;
    public String gender;
    public Date birth_date;
    public String email;
    public String address;
    public String major;
    public float gpa;
    public int year;

    public static class FullName {
        public String first;
        public String last;
        public String midd;
    }

    public Student(String id, String first_Name, String mid_Name, String last_Name, String gender,Date birth_date, String email, String address, String major, float gpa, int year){
        this.id = id;
        this.full_Name = full_Name;
        this.gender = gender;
        this.birth_date = birth_date;
        this.email = email;
        this.address = address;
        this.major = major;
        this.gpa = gpa;
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public String getFull_Name() {
        return full_Name;
    }

    public String getGender() {
        return gender;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getMajor() {
        return major;
    }

    public float getGpa() {
        return gpa;
    }

    public int getYear() {
        return year;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFull_Name(String full_Name) {
        this.full_Name = full_Name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
