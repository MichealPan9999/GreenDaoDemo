package com.example.greendaodemo1.beans;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;

@Entity
public class StudentBean {

    @Id(autoincrement = true)
    private long id;
    private String name;
    private int age;
    private String math;
    private String gender;
    private String english;
    @Generated(hash = 1860951436)
    public StudentBean(long id, String name, int age, String math, String gender,
            String english) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.math = math;
        this.gender = gender;
        this.english = english;
    }
    @Generated(hash = 2097171990)
    public StudentBean() {
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getGender() {
        return this.gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "StudentBean{" +
                "id = "+id+"'\'"+
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", math='" + math + '\'' +
                ", english='" + english + '\'' +
                '}';
    }
    public long getId() {
        return this.id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getMath() {
        return this.math;
    }
    public void setMath(String math) {
        this.math = math;
    }
    public String getEnglish() {
        return this.english;
    }
    public void setEnglish(String english) {
        this.english = english;
    }
}
