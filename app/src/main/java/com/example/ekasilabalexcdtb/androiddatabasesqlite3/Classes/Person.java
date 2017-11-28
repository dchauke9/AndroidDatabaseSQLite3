package com.example.ekasilabalexcdtb.androiddatabasesqlite3.Classes;

import android.widget.EditText;

/**
 * Created by eKasiLab Alex CDTB on 13 Nov 2017.
 */

public class Person {

    String idNumber, name, surname, gender, age;


    public Person() {
    }

    public Person(String idNumber, String name, String surname, String gender, String age) {
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.age = age;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
