package com.example.qiaoxian.borrowbook;

public class Person {
    private String per_name;
    private String sex;
    private int age;
    private String time;

    public Person() {
    }

    public String getPer_name() {
        return per_name;
    }

    public void setPer_name(String per_name) {
        this.per_name = per_name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Person{" +
                "per_name='" + per_name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", time='" + time + '\'' +
                '}';
    }
}
