/*
 * @lc app=leetcode.cn id=732 lang=golang
 *
 * [732] 我的日程安排表 III
 */

// @lc code=start
package main

type SegmentTree struct {
	Left, Right           int
	Max, Lazy             int
	LeftChild, RightChild *SegmentTree
}

// NewSegmentTree returns a new segment tree.
func NewSegmentTree(left, right int) *SegmentTree {
	return &SegmentTree{
		Left:       left,  // Left bound of current range.
		Right:      right, // Right bound of current range, not included.
		Max:        0,
		Lazy:       0,
		LeftChild:  nil,
		RightChild: nil,
	}
}

func (st *SegmentTree) Pushdown() {
	if st.LeftChild == nil {
		st.LeftChild = NewSegmentTree(st.Left, (st.Left+st.Right)/2)
	}
	if st.RightChild == nil {
		st.RightChild = NewSegmentTree((st.Left+st.Right)/2, st.Right)
	}
	if st.Lazy != 0 {
		st.LeftChild.Max += st.Lazy
		st.LeftChild.Lazy += st.Lazy
		st.RightChild.Max += st.Lazy
		st.RightChild.Lazy += st.Lazy
		st.Lazy = 0
	}
}

func (st *SegmentTree) Update(left, right, val int) {
	// Update range covers current range.
	if left <= st.Left && st.Right <= right {
		st.Max += val
		st.Lazy += val
		return
	}

	// Current range covers update range.
	st.Pushdown()
	if left < st.LeftChild.Right {
		st.LeftChild.Update(left, right, val)
	}
	if right > st.RightChild.Left {
		st.RightChild.Update(left, right, val)
	}
	st.Max = max(st.LeftChild.Max, st.RightChild.Max)
}

func (st *SegmentTree) Query(left, right int) int {
	if left <= st.Left && st.Right <= right {
		return st.Max
	}
	st.Pushdown()
	res := 0
	if left < st.LeftChild.Right {
		res = max(res, st.LeftChild.Query(left, right))
	}
	if right > st.RightChild.Left {
		res = max(res, st.RightChild.Query(left, right))
	}
	return res
}

type MyCalendarThree struct {
	Root *SegmentTree
}

func Constructor() MyCalendarThree {
	return MyCalendarThree{
		Root: NewSegmentTree(0, 1e9+1),
	}
}

func (mc *MyCalendarThree) Book(startTime int, endTime int) int {
	mc.Root.Update(startTime, endTime, 1)
	return mc.Root.Query(0, 1e9+1)
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * obj := Constructor();
 * param_1 := obj.Book(startTime,endTime);
 */
// @lc code=end
