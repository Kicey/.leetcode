/*
 * @lc app=leetcode.cn id=71 lang=scala
 *
 * [71] 简化路径
 */

// @lc code=start
import scala.collection.mutable.Stack

object Solution {
    def simplifyPath(path: String): String = {
        val stack = Stack[String]()

        val pathes = path.split("/").filter(_.length > 0)
        pathes.foreach {
            case "." => {}
            case ".." => {
                if (stack.size > 0) {
                    stack.pop()
                }
            }
            case v => {
                stack.push(v)
            }
        }
        stack.reverse.mkString("/", "/", "")
    }
}
// @lc code=end

