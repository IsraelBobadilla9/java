package com.bobadilla;

import java.util.List;
import java.util.function.Consumer;

import com.bobadilla.data.Student;
import com.bobadilla.data.StudentDataBase;

// se introdujeron en java 1.0
// es cualuqier interfaz que tenga un metodo abstracto 
// todas utilizan la anotacion FunctionalInterfaz desde java 1.8
// Nuevas interfaces funcionales introducidas en java 1.8
// consumer predicate function supplier
// Biconsumer BiPredicate Bifunction,UnaryOperator, BinaryOperator
public class Main {
    public static void main(String[] args) {
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        c1.accept("israel");
        printName();
        printNameAndActivities();

    }

    public static void printName() {
        Consumer<Student> showString = (student) -> System.out.println(student.getName());
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(showString);
    }

    public static void printNameAndActivities() {
        System.out.println("#####################");
        Consumer<Student> showString = (student) -> System.out.println(student.getName());
        Consumer<Student> showActivities = (student) -> System.out.println(student.getActivities());
        List<Student> studentList = StudentDataBase.getAllStudents();
        studentList.forEach(showString.andThen(showActivities));
    }

}