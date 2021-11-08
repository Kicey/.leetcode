import java.util.concurrent.atomic.AtomicBoolean;

/*
 * @lc app=leetcode.cn id=1115 lang=java
 *
 * [1115] 交替打印FooBar
 */

// @lc code=start
class FooBar {
    private int n;
    private AtomicBoolean sync = new AtomicBoolean(false);
    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized(this){
                if(sync.get()) wait();
                printFoo.run();
                sync.set(true);
                notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            synchronized(this){
                if(!sync.get()) wait();
                printBar.run();
                sync.set(false);
                notify();
            }
        }
    }
}
// @lc code=end

