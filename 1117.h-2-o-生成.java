import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

/*
 * @lc app=leetcode.cn id=1117 lang=java
 *
 * [1117] H2O 生成
 */

// @lc code=start
class H2O {

    Semaphore h = new Semaphore(2);
    Semaphore o = new Semaphore(1);
    CyclicBarrier cyclicBarrier = new CyclicBarrier(3);

    
    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
		
        h.acquire();
        try{
            cyclicBarrier.await();
        }catch(InterruptedException | BrokenBarrierException e){

        }
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        h.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire();
        try{
            cyclicBarrier.await();
        }catch(InterruptedException | BrokenBarrierException e){

        }
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        o.release();
    }
}
// @lc code=end

