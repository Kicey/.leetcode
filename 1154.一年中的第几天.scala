/*
 * @lc app=leetcode.cn id=1154 lang=scala
 *
 * [1154] 一年中的第几天
 */

// @lc code=start
import java.time.LocalDate
import java.time.format.DateTimeFormatter

object Solution {
    def dayOfYear(dateString: String): Int = {
        val date = LocalDate.parse(dateString, DateTimeFormatter.ISO_LOCAL_DATE);
        date.getDayOfYear();
    }
}
// @lc code=end

