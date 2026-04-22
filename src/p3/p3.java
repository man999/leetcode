//#3
void main() {
    System.out.println(lengthOfLongestSubstring(""));
    System.out.println(lengthOfLongestSubstring("abcabcbb"));
    System.out.println(lengthOfLongestSubstring("bbbbc"));
    System.out.println(lengthOfLongestSubstring("pwwkew"));
}

public int lengthOfLongestSubstring(String s) {
    //my sol
    int posCur = 0, posTmp = 0, lenCur = 0, lenMax = 0;
    String resStr = s;

    while ((s.length() - posCur) > lenMax) {
        posTmp = s.substring(posCur, posCur + lenCur).indexOf(s.charAt(posCur + lenCur));
        if (posTmp == -1) {
            lenCur++;
            if (lenCur > lenMax) {
                lenMax = lenCur;
                resStr = s.substring(posCur, posCur + lenCur);
            }
        } else {
            lenCur = lenCur - posTmp;
            posCur = posCur + posTmp + 1;
        }
        ;
    }
    System.out.println(resStr);
    return lenMax;
}