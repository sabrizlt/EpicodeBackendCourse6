package Esercizio1;

public class ThreadFigli {
    public static void main(String[] args) {
        Thread thread1 = new Simbolo("*");
        Thread thread2 = new Simbolo("#");

        thread1.start();
        thread2.start();
    }

    private static class Simbolo extends Thread {
        private String symbol;

        public Simbolo(String symbol) {
            this.symbol = symbol;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(symbol);
                try {
                    Thread.sleep(1000); 
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
