/*
 * @lc app=leetcode.cn id=1410 lang=scala
 *
 * [1410] HTML 实体解析器
 */

// @lc code=start
object Solution {
    def entityParser(text: String): String = {
        val pattern = "&quot;|&apos;|&amp;|&gt;|&lt;|&frasl;".r
        pattern.replaceAllIn(text, m => {
            m.group(0) match {
                case "&quot;" => "\""
                case "&apos;" => "'"
                case "&amp;" => "&"
                case "&gt;" => ">"
                case "&lt;" => "<"
                case "&frasl;" => "/"
            }
        })
    }
}
// @lc code=end

