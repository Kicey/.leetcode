/*
 * @lc app=leetcode.cn id=1185 lang=scala
 *
 * [1185] 一周中的第几天
 */

// @lc code=start
import java.time.LocalDate

object Solution {
    def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
        val date = LocalDate.of(year, month, day);
        date.getDayOfWeek.getValue() match {
            case 1 => "Monday"
            case 2 => "Tuesday"
            case 3 => "Wednesday"
            case 4 => "Thursday"
            case 5 => "Friday"
            case 6 => "Saturday"
            case 7 => "Sunday"
        }
    }
}
// @lc code=end

