package com.modernjava.threading;

public class CourseNotifier {

    public static void main(String[] args) throws InterruptedException {

        final Course course=new Course("Java Multithreading Programming");

        //Create three threads 2 for the student waiting for notification and one for the instructor who is writing the course
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+ " is waiting for the course ::"+course.getTitle());
            synchronized (course){
                try {
                    course.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ " the course : "+course.getTitle()+ "is now completed");
            }

        },"StudentA").start();
        Thread.sleep(200);
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+ " is waiting for the course ::"+course.getTitle());
            synchronized (course){
                try {
                    course.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ " the course : "+course.getTitle()+ "is now completed");
            }

        },"StudentB").start();
        Thread.sleep(200);
        new Thread(()->{

            synchronized (course)
            {
                System.out.println(Thread.currentThread().getName()+" is starting a new course :"+course.getTitle());
                try {
                    Thread.sleep(1000);
                    course.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        },"Instructor Akansh").start();


    }
}
class Course{
    private String title;
    private boolean completed;

    public Course(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

}
