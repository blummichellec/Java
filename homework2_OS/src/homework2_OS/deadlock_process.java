package homework2_OS;
import java.util.ArrayList;
import java.util.Random;

//deadlock package
public class deadlock_process extends Thread {
    private int number;
    private semaphore currentSemaphore;
    private ArrayList<semaphore> trace;

    public deadlock_process(int number) {
        this.number = number;
        trace = new ArrayList<>();
    }

    public void setCurrentSemaphore(semaphore semaphore) {
        this.currentSemaphore = semaphore;
        trace.add(currentSemaphore);
    }

    @Override
    public void run() {
        test.logger.writeLine("Starting thread id: p" + number);
        randomSleep(100, 1000);

        while (true) {
            while (currentSemaphore != test.semaphores[0]) {
                blockCurrentSemaphore();
            }

            handleCriticalResource();
        }
    }

    private void handleCriticalResource() {
        boolean success = currentSemaphore.tryAcquire();
        if (success) {
            test.logger.writeLine("Thread p" + number + " in critical section now." +
                    "Will be in critical section for " + randomSleep(500, 1500) + " milliseconds...");

            releaseSemaphores();
        }
    }

    private void releaseSemaphores() {
        for (int i = trace.size() - 1; i >= 0; i--) {
            test.logger.writeLine("Thread p" + number + " releasing lock on semaphore s" + trace.get(i).getNumber());
            trace.get(i).release();
        }

        randomSleep(250, 500);
        currentSemaphore = trace.get(0);
        trace.clear();
        trace.add(currentSemaphore);
    }

    private void blockCurrentSemaphore() {
        String msg = "Thread p" + number + " trying to lock semaphore s" + currentSemaphore.getNumber() + " : ";
        String scs;

        boolean success = currentSemaphore.tryAcquire();
        if (success) {
            scs = "success";
            setCurrentSemaphore(test.semaphores[currentSemaphore.getParentSemaphoreNumber()]);
        }
        else {
            scs = "failure [waiting]";
            randomSleep(1400, 1800);
        }

        msg += scs;
        test.logger.writeLine(msg);
    }

    private int randomSleep(int minTime, int maxTime) {
        Random random = new Random();

        int time = random.nextInt(maxTime - minTime) + minTime;

        try {
            sleep(time);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        return time;
    }
}