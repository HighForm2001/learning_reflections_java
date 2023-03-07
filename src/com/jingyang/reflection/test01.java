package com.jingyang.reflection;

public class test01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //通过反射类获取class的对象
        Class c1= Class.forName("com.jingyang.reflection.User");
        System.out.println(c1);
    }
}


// 实体类
class User{
    private String name;
    private int id;
    private int age;

    public User(String name, int id, int age) {
        this.name = name;
        this.id = id;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
