import java.util.Arrays;
import java.util.concurrent.Semaphore;

/*
 * @lc app=leetcode.cn id=1226 lang=java
 *
 * [1226] 哲学家进餐
 */

// @lc code=start
class DiningPhilosophers {

    
    private volatile Semaphore[] fork = new Semaphore[5];

    {
        for(int i = 0;i < 5;++i) fork[i] = new Semaphore(1);
    }

    public DiningPhilosophers() {
        
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher + 1) % 5;

        if(philosopher % 2 == 0){
            fork[left].acquire();
            fork[right].acquire();
        }else{
            fork[right].acquire();
            fork[left].acquire();
        }

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        
        putLeftFork.run();
        putRightFork.run();
        
        fork[left].release();
        fork[right].release();
    }
}
// @lc code=end

