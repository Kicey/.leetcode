import scala.collection.mutable.*

object Solution:
    def ballGame(num: Int, plate: Array[String]): Array[Array[Int]] =
        val (n, m) = (plate.size, plate(0).size)
        // toRigtht, toDown, toLeft, toUp
        val directions = Array((0, 1), (1, 0), (0, -1), (-1, 0))
        // remainingSteps(i)(j)(d): the remaining steps to reach the cell (i, j) with direction d
        val remainingSteps = Array.fill(n, m, 4)(Int.MaxValue / 2)
        val vis = Array.fill(n, m, 4)(false)
        def dfsGetRemainingSteps(i: Int, j: Int, d: Int): Int =
            if i < 0 || i >= n || j < 0 || j >= m then 
                return Int.MaxValue / 2
            
            val curDirection = 
                if plate(i)(j) == 'W' then 
                    (d + 3) % 4
                else if plate(i)(j) == 'E' then 
                    (d + 1) % 4
                else d

            if vis(i)(j)(d) then
                return remainingSteps(i)(j)(d)
            
            vis(i)(j)(d) = true
            if plate(i)(j) == 'O' then 
                return 0
            
            val remainingStep = dfsGetRemainingSteps(i + directions(curDirection)._1, j + directions(curDirection)._2, curDirection) + 1
            remainingSteps(i)(j)(curDirection) = remainingStep
            remainingStep
        // iterate 4 edge cells except the corner cells
        val result = ArrayBuffer.empty[Array[Int]]
        for (i, j, d, d_, count) <- Array(
            (0, 1, 0, 1, m - 2), 
            (1, 0, 1, 0, n - 2), 
            (n - 1, m - 2, 2, 3, m - 2), 
            (n - 2, m - 1, 3, 2, n - 2));
            curCell <- 0 until count
        do  
            val (curI, curJ, curD) = (i + directions(d)._1 * curCell, j + directions(d)._2 * curCell, d_)
            if plate(curI)(curJ) == '.' then
                val remainingStep = dfsGetRemainingSteps(curI, curJ, curD)
                if remainingStep <= num then
                    result += Array(curI, curJ)
        result.toArray
