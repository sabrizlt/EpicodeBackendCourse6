package Esercizio2;
import java.util.Random;

public class ThreadEsercizio2 {
    private static final int Number = 3000;
    private static final int Thread = 3;

    public static void main(String[] args) throws Exception {
        int[] array = Random(Number);
        SumThread[] threads = new SumThread[Thread];
        int[] partialSums = new int[Thread];

        for (int i = 0; i < Thread; i++) {
            int start = i * (Number / Thread);
            int end = (i + 1) * (Number / Thread);
            threads[i] = new SumThread(array, start, end);
            threads[i].start();
        }

        for (int i = 0; i < Thread; i++) {
            threads[i].join(); 
            partialSums[i] = threads[i].getSum();
        }

        int totalSum = 0;
        for (int sum : partialSums) {
            totalSum += sum;
        }

        System.out.println("Risultato 1: " + partialSums[0]);
        System.out.println("Risultato 2: " + partialSums[1]);
        System.out.println("Risultato 3: " + partialSums[2]);
        System.out.println("Risultato finale: " + totalSum);
    }

    private static int[] Random(int size) {
        int[] array = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(100);
        }

        return array;
    }

    private static class SumThread extends Thread {
        private int[] array;
        private int start;
        private int end;
        private int partialSum;

        public SumThread(int[] array, int start, int end) {
            this
.array = array;
            this.start = start;
            this.end = end;
        }

        public int getSum() {
            return partialSum;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                partialSum += array[i];
            }
        }
    }
}
