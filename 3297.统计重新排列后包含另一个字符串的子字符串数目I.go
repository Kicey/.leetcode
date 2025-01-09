package main

func validSubstringCount(word1 string, word2 string) int64 {
	leterNeedMap := make(map[rune]int)
	for _, letter := range word2 {
		leterNeedMap[letter]++
	}
	leterCountMap := make(map[rune]int)
	result := int64(0)
	// two pointers iterate the word1
	for left, right := 0, 1; right <= len(word1); right++ {
		leterCountMap[rune(word1[right - 1])]++
		for ifSatisfyNeed(leterCountMap, leterNeedMap) {
			result += int64(len(word1) - right + 1)
			leterCountMap[rune(word1[left])]--
			left++
		}
	}
	return result
}

func ifSatisfyNeed(leterCountMap map[rune]int, leterNeedMap map[rune]int) bool {
	for leter, needCount := range leterNeedMap {
		if count, exist := leterCountMap[leter]; !exist || count < needCount {
			return false
		}
	}
	return true
}