package com.itCs520.deanProject.entity.Day03;
// 定义一个student类，具有age和username两个属性，并通过comparable提供比较

public class Student implements Comparable<Student> {
    private int age;
    private String username;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", username='" + username + '\'' +
                '}';
    }

    /*重新定义比较规则
    * */
    @Override
    public int compareTo(Student o) {
        return this.getAge()- o.getAge();
    }
}
