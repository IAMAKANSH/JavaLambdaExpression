package functionalInterface;

public class RunnableExample {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable Run is running");
            }
        };
        new Thread(runnable).start();

        //Using Lambda Expression
        Runnable runnable1=() -> {
            System.out.println("Running Run is running using lambda");
        };
        new Thread(runnable1).start();

        //Implement Thread using lambda
        new Thread(() -> System.out.println("Runnable is called")).start();    }
}
