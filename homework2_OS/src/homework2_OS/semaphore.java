package homework2_OS;
import java.util.concurrent.Semaphore; //Semaphore package


/* *********************************************************************************************************
 * This semaphore function controls access to a shared resource. A thread must be granted a permit from the*
 * semaphore to access a shared resource. 																   *
 * ********************************************************************************************************/
public class semaphore extends Semaphore {
	
	private static final long serialVersionUID = 1L;
	private int number;

    public semaphore(int number) {
        super(1);
        this.number = number;
    }

    public int getParentSemaphoreNumber() {
        if (number % 2 == 1) {
            return number / 2;
        }
        else {
            return number / 2 - 1;
        }
    }

    public int getNumber() {
        return number;
    }
}