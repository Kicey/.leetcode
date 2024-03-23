/*
 * @lc app=leetcode.cn id=2617 lang=scala
 *
 * [2617] 网格图中最少访问的格子数
 */

// @lc code=start
import scala.collection.mutable.PriorityQueue
import scala.compiletime.ops.double

object Solution:
	def minimumVisitedCells(grid: Array[Array[Int]]): Int =
		val (m, n) = (grid.length, grid(0).length)
		if ((m, n) == (1, 1)) then return 1
		val order = Ordering.by[(Int, Int), Int](_._1).reverse
		val rowQueueArray = Array.fill(m)(PriorityQueue[(Int, Int)]()(order))
		val colQueueArray = Array.fill(n)(PriorityQueue[(Int, Int)]()(order))
		rowQueueArray(0).enqueue((1, 0))
		colQueueArray(0).enqueue((1, 0))
		// val stepMatrix = Array.fill(m, n)(-1)
		// stepMatrix(0)(0) = 0
		var result = -1
		for 
			i <- 0 until m
			j <- 0 until n
			if (i, j) != (0, 0)
		do
			while
				if colQueueArray(j).isEmpty 
				then false
				else 
					val xRow = colQueueArray(j).head._2
					grid(xRow)(j) + xRow < i
			do
				colQueueArray(j).dequeue()

			val colStep = if colQueueArray(j).nonEmpty then colQueueArray(j).head._1 + 1 else Int.MaxValue

			while
				if rowQueueArray(i).isEmpty 
				then false
				else 
					val xCol = rowQueueArray(i).head._2
					grid(i)(xCol) + xCol < j
			do
				rowQueueArray(i).dequeue()
			
			val rowStep = if rowQueueArray(i).nonEmpty then rowQueueArray(i).head._1 + 1 else Int.MaxValue

			val step = rowStep min colStep
			if step != Int.MaxValue then
				rowQueueArray(i).enqueue((step, j))
				colQueueArray(j).enqueue((step, i))
				// stepMatrix(i)(j) = step
			if ((i, j) == (m - 1, n - 1) && step != Int.MaxValue) then result = step
		
		// print(stepMatrix.map(stepRow => stepRow.mkString(", ")).mkString("\n"))
		
		result
// @lc code=end
