package com.bobadilla;

import java.util.List;
import java.util.function.BiConsumer;
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
        // CONSUMER
        Consumer<String> c1 = (s) -> System.out.println(s.toUpperCase());
        c1.accept("israel");
        printName();
        printNameAndActivities();
        System.out.println("############### BICONSUMER TEST");
        //BICONSUMER
        BiConsumer<String,String> biConsumer = (a,b) ->{
            System.out.println("a" + a + "b" +b);
        };

        BiConsumer<Integer,Integer> multiplyBiConsumer = (a,b) ->{
            System.out.println("Resultado : " + (a*b));
        };

        BiConsumer<Integer,Integer> divBiConsumer = (a,b) ->{
            System.out.println("division:  "+a/b);
        };

        biConsumer.accept("java7", "java10");
        multiplyBiConsumer.accept(5, 10);

        multiplyBiConsumer.andThen(divBiConsumer).accept(100, 10);


        printNameAndActivitiesBiConsumer();

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

    public static void printNameAndActivitiesBiConsumer (){
        List<Student> students = StudentDataBase.getAllStudents();
        BiConsumer<String,List<String>> biConsumer = (name,activities) ->{
            System.out.println("Name: "+ name+" activity: "+activities);
        };

        students.forEach(student -> biConsumer.accept(student.getName(), student.getActivities()));
    }

}