package com.modernjava.threading;

public class FoodRestaurantSynchronized {

    private String lastClientName;
    private int numberOfBurgerSold;

    public synchronized void burgerSold(String lastClientName){
        alongRunningProcess();
        this.lastClientName=lastClientName;
        numberOfBurgerSold++;
        System.out.println(lastClientName+ " bought burger");
    }

    public void alongRunningProcess()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String getLastClientName() {
        return lastClientName;
    }

    public void setLastClientName(String lastClientName) {
        this.lastClientName = lastClientName;
    }

    public int getNumberOfBurgerSold() {
        return numberOfBurgerSold;
    }

    public void setNumberOfBurgerSold(int numberOfBurgerSold) {
        this.numberOfBurgerSold = numberOfBurgerSold;
    }

    public static void main(String[] args) throws InterruptedException {

        long startTime=System.currentTimeMillis();
        FoodRestaurantSynchronized foodRestaurant=new FoodRestaurantSynchronized();

        Thread t1=new Thread(()->{
            foodRestaurant.burgerSold("Akansh");
        });

        Thread t2=new Thread(()->{
            foodRestaurant.burgerSold("Mike");
        });

        Thread t3=new Thread(()->{
            foodRestaurant.burgerSold("Rahul");
        });

        Thread t4=new Thread(()->{
            foodRestaurant.burgerSold("Anvay");
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t1.join();
        t2.join();
        t3.join();
        t4.join();
        System.out.println("Total number of burger sold is "+foodRestaurant.getNumberOfBurgerSold());
        System.out.println("Last client who buys burger is "+foodRestaurant.getLastClientName());
        System.out.println("Total time taken to complete the process is"+(System.currentTimeMillis()-startTime));
    }
}
