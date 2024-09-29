/*
 * @lc app=leetcode.cn id=2516 lang=scala
 *
 * [2516] 每种字符至少取 K 个
 */

// @lc code=start
object Solution:
  def takeCharacters(s: String, k: Int): Int = 
    val charArray = s.toCharArray()
    var charCount = charArray.foldLeft(Array(0,0,0))(
      (result, elem) =>{
        if elem == 'a'
        then 
          result(0) += 1
          result
        else if elem == 'b'
        then 
          result(1) += 1
          result
        else
          result(2) += 1
          result
      }
    )

    if charCount.exists(count => count < k)
    then return -1
    
    var (l, r) = (0, 0)
    var rangeSize = 0
    while r < charArray.length
    do
      println(r)
      val curChar = charArray(r)
      charCount(curChar - 'a') -= 1
      while charCount(curChar - 'a') < k && l <= r
      do
        println(s"l: $l")
        charCount(charArray(l) - 'a') += 1
        l += 1
      r += 1
      rangeSize = Math.max(rangeSize, r - l)
    charArray.size - rangeSize
// @lc code=end

