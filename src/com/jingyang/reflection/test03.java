package com.jingyang.reflection;

import org.w3c.dom.ls.LSOutput;

// test the initialization of class object
public class test03 {
    public static void main(String[] args)throws Exception {
        Person person = new Student();
        System.out.println(("this person is: " + person));

        // method 1: through getclass
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());
        // method 2: through forname
        Class c2 = Class.forName("com.jingyang.reflection.Student");
        System.out.println(c2.hashCode());
        // method 3:through Class.class
        Class c3 = Student.class;
        System.out.println(c3.hashCode());

        Class c5 = c1.getSuperclass();
        System.out.println(c5);
    }

}

class Person{
    protected String name;
    public Person(){

    }
    @Override
    public String toString(){
        return name;
    }
}
class Student extends Person{
   public Student(){
       this.name = "Student";
   }
}
class Teacher extends Person{
    public Teacher(){
        this.name = "Teacher";
    }
}