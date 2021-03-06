package com.lzw.lambdademo.why4;

import com.lzw.lambdademo.why3.Student;
import com.lzw.lambdademo.why3.StudentFilter;
import com.lzw.threadpool.forkjoin.PrintTask;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: lzw
 * @Date: 20/11/1 - 11 - 01 - 12:43
 * @Description: com.lzw.lambdademo.why4
 * @version: 1.0
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("zhangsan",14,67));
        students.add(new Student("lisi",13,89));
        students.add(new Student("wangwu",15,97));
        students.add(new Student("maliu",12,63));
        students.add(new Student("zhaoqi",17,75));
        getByFilter(students, (student)->{return student.getAge()>14;});
        getByFilter(students,(s)->{return s.getScore()>75;});
        getByFilter(students, (s)->s.getName().length()>5);
    }

    private static void getByFilter(ArrayList<Student> students, StudentFilter studentFilter) {
        List<Student> list = new ArrayList<>();
        for (Student s:students){
            if (studentFilter.compare(s)){
                list.add(s);
            }
        }
        printStudent(list);
    }

    private static void printStudent(List<Student> list) {
        for (Student s:list){
            System.out.println(s);
        }
    }
}
