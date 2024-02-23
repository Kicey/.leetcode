/*
 * @lc app=leetcode.cn id=1670 lang=scala
 *
 * [1670] 设计前中后队列
 */

// @lc code=start
import scala.collection.mutable.ArrayDeque

class FrontMiddleBackQueue() {

    val frontQueue = ArrayDeque[Int]()
    val backQueue = ArrayDeque[Int]()

    def pushFront(v: Int) = {
        frontQueue.prepend(v)
        if (frontQueue.size > backQueue.size) {
            backQueue.prepend(frontQueue.removeLast(true))
        }
    }

    def pushMiddle(v: Int) = {
        if (frontQueue.size < backQueue.size) {
            frontQueue.append(v)
        } else {
            backQueue.prepend(v)
        }
    }

    def pushBack(v: Int) = {
        backQueue.append(v)
        if (frontQueue.size + 1 < backQueue.size) {
            frontQueue.append(backQueue.removeHead())
        }
    }

    def popFront(): Int = {
        frontQueue.size match {
            case 0 => {
                if (backQueue.size == 0) {
                    -1
                } else {
                    backQueue.removeHead()
                }
            }
            case _ => {
                val v = frontQueue.removeHead()
                if (frontQueue.size + 1 < backQueue.size) {
                    frontQueue.append(backQueue.removeHead())
                }
                v
            }
        }
    }

    def popMiddle(): Int = {
        if (frontQueue.size == backQueue.size) {
            if (backQueue.size == 0) {
                -1
            } else {
                frontQueue.removeLast(true)
            }
        } else {
            backQueue.removeHead(true)
        }
    }

    def popBack(): Int = {
        backQueue.size match {
            case 0 => {
                -1
            }
            case _ => {
                val v = backQueue.removeLast(true)
                if (frontQueue.size > backQueue.size) {
                    backQueue.prepend(frontQueue.removeLast(true))
                }
                v
            }
        }
    }

}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * var obj = new FrontMiddleBackQueue()
 * obj.pushFront(`val`)
 * obj.pushMiddle(`val`)
 * obj.pushBack(`val`)
 * var param_4 = obj.popFront()
 * var param_5 = obj.popMiddle()
 * var param_6 = obj.popBack()
 */
// @lc code=end

