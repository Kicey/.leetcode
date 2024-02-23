/*
 * @lc app=leetcode.cn id=2661 lang=scala
 *
 * [2661] 找出叠涂元素
 */

// @lc code=start
object Solution {
    def firstCompleteIndex(arr: Array[Int], mat: Array[Array[Int]]): Int = {
        val v2pos = mat.zipWithIndex.map(
            {
                case (arr, i) => {
                    arr.zipWithIndex.map(
                        {
                            case (v, j) => {
                                v -> (i, j)
                            }
                        }
                    ).toMap
                }
            }
        ).reduce(_ ++ _)
        val (m, n) = (mat.length, mat(0).length)
        val rowCnt = Array.fill[Int](m)(0)
        val colCnt = Array.fill[Int](n)(0)
        

        for (i <- 0 to m * n - 1) {
            val (row, col) = v2pos(arr(i))
            rowCnt(row) += 1
            colCnt(col) += 1
            if (rowCnt(row) == n || colCnt(col) == m) {
                return i
            }
        }
        -1
    }
}
// @lc code=end

