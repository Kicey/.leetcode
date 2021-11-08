import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/*
 * @lc app=leetcode.cn id=1116 lang=java
 *
 * [1116] 打印零与奇偶数
 */

// @lc code=start
class ZeroEvenOdd {
    private int n;

    private volatile int next = 0;
    private ReentrantLock reentrantLock = new ReentrantLock(true);
    private Condition zero = reentrantLock.newCondition();
    private Condition odd = reentrantLock.newCondition();
    private Condition even = reentrantLock.newCondition();

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        reentrantLock.lock();
        try {
            while (next < n) {

                printNumber.accept(0);
                next += 1;

                if (next % 2 == 1) {
                    odd.signalAll();
                } else {
                    even.signalAll();
                }
                if(next == n) break;
                zero.await();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        reentrantLock.lock();
        try {
            if (next == 0)
                even.await();

            while (next <= n) {
                if(next == n && next % 2 == 1) break;
                if (next % 2 == 1)
                    even.await();

                int temp = next;
                printNumber.accept(next);
                zero.signalAll();
                if(next == n){
                    odd.signalAll();
                    break;
                }
                even.await();
                if(temp + 2 != next){
                    break;
                }
                
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        reentrantLock.lock();
        try {
            if (next == 0)
                odd.await();

            while (next <= n) {
                if (next % 2 == 0)
                    odd.await();

                int temp = next;
                printNumber.accept(next);
                zero.signalAll();
                if(next == n){
                    even.signalAll();
                    break;
                }
                odd.await();
                if(temp + 2 != next ){
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        } 
        finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        Thread zero = new Thread(() -> {
            try {
                zeroEvenOdd.zero(System.out::println);
            } catch (InterruptedException interruptedException) {

            }
        });
        Thread odd = new Thread(() -> {
            try {
                zeroEvenOdd.odd(System.out::println);
            } catch (InterruptedException interruptedException) {

            }
        });
        Thread even = new Thread(() -> {
            try {
                zeroEvenOdd.even(System.out::println);
            } catch (InterruptedException interruptedException) {

            }
        });
        zero.setName("zero");
        odd.setName("odd");
        even.setName("even");
        zero.start();
        odd.start();
        even.start();
    }
}
// @lc code=end
