/*
 * @lc app=leetcode.cn id=93 lang=scala
 *
 * [93] 复原 IP 地址
 */

// @lc code=start
object Solution:
  def restoreIpAddresses(s: String): List[String] =
    if s.length() > 16 then return List.empty
    val totalLength = s.length()
    val resultSeq =
      for
        i <- 1 to 3
        j <- i + 1 to i + 3
        k <- j + 1 to j + 3
        if i < totalLength && j < totalLength && k < totalLength
        if totalLength - k <= 3
        a = s.substring(0, i)
        b = s.substring(i, j)
        c = s.substring(j, k)
        d = s.substring(k, totalLength)
        if a.toInt <= 255 && b.toInt <= 255 && c.toInt <= 255 && d.toInt <= 255
        if (a.length() == 1 || a(0) != '0')
        if (b.length() == 1 || b(0) != '0')
        if (c.length() == 1 || c(0) != '0')
        if (d.length() == 1 || d(0) != '0')
      yield s"$a.$b.$c.$d"
    resultSeq.toList
// @lc code=end
