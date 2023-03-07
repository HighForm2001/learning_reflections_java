package com.jingyang.reflection;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class test07 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class c1 = Class.forName("com.jingyang.reflection.Student2");

        // 通过反射获得注解
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println(annotation);
        }

        // 获得注解value的值
        TableName tbName = (TableName)c1.getAnnotation(TableName.class);
        System.out.println(tbName.value());

        // 获得类指定的注解

        Field name = c1.getDeclaredField("name");
        FieldName annotation = name.getAnnotation(FieldName.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.length());
        System.out.println(annotation.type());

    }
}
@TableName("db_chin")
class Student2{
    @FieldName(columnName = "db_name",type = "varchar",length=10)
    private String name;

    @FieldName(columnName = "db_id",type = "int",length=2)
    private int id;
    @FieldName(columnName = "db_age",type = "int",length=2)
    private int age;

    public Student2() {
    }

    public Student2(String name, int id, int age) {
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
        return "Student2{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                '}';
    }
}


// class name annotation
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface TableName{
    String value();
}

// field name annotation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface FieldName{
    String columnName();
    String type();
    int length();
}