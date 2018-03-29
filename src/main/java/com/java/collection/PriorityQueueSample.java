package com.java.collection;

import java.util.PriorityQueue;

/**
 * Each class which can be member of priority queue should have implemented comparable.
 * Because priority queue usage the compareTo method to determine the highest priority element
 */
class Student implements Comparable {
    private int id;
    private String name;
    private double marks;
    private double grades;

    public Student(int id, String name, double marks, double grades) {
        this.id = id;
        this.name = name;
        this.marks = marks;
        this.grades = grades;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getMarks() == ((Student) obj).getMarks();
    }

    @Override
    public int compareTo(Object o) {
        if (this.getMarks() == ((Student) o).getMarks()) return 0;
        if (this.getMarks() > ((Student) o).getMarks()) return 1;
        else
            return -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public double getGrades() {
        return grades;
    }

    public void setGrades(double grades) {
        this.grades = grades;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                ", grades=" + grades +
                '}';
    }
}

/**
 * Priority queue data structure works on the principle of priority.
 * lowest number has highest priority. So it implements a real life scenario
 * where people with highest priority gets service first and leave the queue.
 * Based on this principal remove method of queue removes highest priority node
 * first from queue.
 */
public class PriorityQueueSample {
    public static void main(String[] args) {
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Student(1, "Sunil", 70.0, 7.5));
        priorityQueue.add(new Student(2, "Vijay", 69.0, 7.5));


        while (!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.remove());
        }


    }

}
