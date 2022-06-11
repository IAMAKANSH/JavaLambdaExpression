package com.modernjava.step3;

public class WaitNotifyAndNotifyAll {

    public static void main(String[] args) throws InterruptedException {

        final Course java=new Course("Java Multithreading");

        //create three thread two for the student waiting for the notification and
        //one for the instructor who is writing the course

        new Thread(() ->
        {
            System.out.println(Thread.currentThread().getName()+ " is waiting for the course "+java.getTitle());
            synchronized (java)
            {
                try {
                    java.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+ "the course : "+java.getTitle()
                + "is now completed");
            }
        },"StudentA").start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName()+ " is waiting for the course "+java.getTitle());
            synchronized (java)
        {
            try {
                java.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+ "the course : "+java.getTitle()
                    + "is now completed");
        }},"StudentB").start();

        Thread.sleep(200);
        new Thread(() -> {
            synchronized (java)
            {
                System.out.println(Thread.currentThread().getName()+ "is starting a new course :"+java.getTitle());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                java.notifyAll();
            }

        },"Akansh Srivastava").start();

    }
}

class Course
{

    private String title;
    private Boolean completed;

    public Course(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }
}
