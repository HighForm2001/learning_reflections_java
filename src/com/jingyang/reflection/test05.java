package com.jingyang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class test05 {
    public static void main(String[] args) throws Exception{
        Class c1 = Class.forName("com.jingyang.reflection.User");
//        User user = (User)c1.newInstance();

        // get constructor
        Constructor cons = c1.getDeclaredConstructor(String.class, int.class, int.class);
        User jingyang =(User) cons.newInstance("Jingyang", 1, 1);
        System.out.println(jingyang);

        Method setName = c1.getDeclaredMethod("setName", String.class);
        setName.invoke(jingyang,"xiaohui");
        System.out.println(jingyang);

        Field name = c1.getDeclaredField("name");
        name.setAccessible(true);
        name.set(jingyang,"xiaohuiX");
        System.out.println(jingyang);

    }
}
