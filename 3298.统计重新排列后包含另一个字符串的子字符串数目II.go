package main

func validSubstringCount(word1 string, word2 string) int64 {
    letterNeeded := make(map[byte]int, 26)
	for _, letter := range word2 {
		letterNeeded[byte(letter) - byte('a')]++
	}
	complete := false
	letterNeededRemain := len(word2)
	result := int64(0)
	letterCount := make(map[byte]int, 26)

	// two pointers iterate
	for left, right := 0, 1; right <= len(word1); right++ {
		letterIndex := byte(word1[right-1]) - byte('a')
		letterCount[letterIndex]++
		if letterCount[letterIndex] <= letterNeeded[letterIndex] {
			letterNeededRemain--
		}
		if letterNeededRemain == 0 {
			complete = true
			result += int64(len(word1) - right + 1)
		}
		for complete {
			letterIndexLeft := byte(word1[left]) - byte('a')
			letterCount[letterIndexLeft]--
			if letterCount[letterIndexLeft] < letterNeeded[letterIndexLeft] {
				letterNeededRemain++
				complete = false
			} else {
				result += int64(len(word1) - right + 1)
			}
			left++
		}
	}
	return result
}
