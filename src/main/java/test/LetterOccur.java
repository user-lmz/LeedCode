package test;

import org.junit.Test;

import java.util.*;

public class LetterOccur {
    public boolean isWord(char c) {
        return c >= 'A' && c <= 'Z';
    }

    public boolean isNum(char c) {
        return c >= '2' && c <= '9';
    }

    static class WordForNum{
        private char word;
        private int num;
        public WordForNum(char word, int num) {
            this.word = word;
            this.num = num;
        }
        public char getWord() {
            return word;
        }
        public int getNum() {
            return num;
        }
    }

    public String quick(String in) {
        HashMap<Character, Integer> map = new HashMap<>();
        Deque<WordForNum> deque = new ArrayDeque<>();
        StringBuilder sd = new StringBuilder();
        int num = 1;
        char[] chs = in.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            while (isWord(chs[i])) {
                map.put(chs[i], map.getOrDefault(chs[i], 0) + 1);
                i++;
            }
            if (isNum(chs[i]) && i >= 1) {
                map.put(chs[i - 1], map.getOrDefault(chs[i - 1], 0) + (chs[i] - '0') - 1);
            }
            if (chs[i] == '(' && i + 1 < chs.length) {
                deque.push(new WordForNum(chs[i], 1));
                i++;
            }
            while (chs[i] != ')' && i + 1 < chs.length
                    && deque.peekLast() != null && deque.peekLast().getWord() == '(') {
                deque.push(new WordForNum(chs[i], 1));
                i++;
            }
            if (i == chs.length - 1)
                break;
            if (chs[i] == ')' && isNum(chs[i + 1]) && i + 1 < chs.length) {
                deque.push(new WordForNum(chs[i], 1));
                i++;
                deque.push(new WordForNum(chs[i], 1));
            }
            List<WordForNum> temp = new ArrayList<>();
            while (!deque.isEmpty() && deque.peek().getWord() != '(') {
                if (deque.peek() != null && isNum(deque.peek().getWord())) {
                    num = (deque.pop().getWord() - '0');
                    if (!deque.isEmpty() && deque.peek().getWord() == ')') {
                        deque.pop();
                    }
                }
                while (!deque.isEmpty() && deque.peek() != null) {
                    char curWord = deque.peek().getWord();
                    int curNum = deque.peek().getNum();
                    if (!deque.isEmpty() && isNum(curWord)) {
                        int mul = (curWord - '0') * curNum * num;
                        deque.pop();
                        curWord = deque.peek().getWord();
                        if (deque.peek() != null && isWord(curWord)) {
                            temp.add(new WordForNum(curWord, mul));
                        }
                        deque.pop();
                        // map.put(numToWord, map.getOrDefault(numToWord, 0) + mul);
                    }
                    curWord = deque.peek().getWord();
                    curNum = deque.peek().getNum();
                    if (!deque.isEmpty() && isWord(curWord)) {
                        temp.add(new WordForNum(curWord, curNum * num));
                        deque.pop();
                    }
                    if (!deque.isEmpty() && deque.peek().getWord() == '(') {
                        deque.pop();
                        break;
                    }
                }
                for (int k = temp.size() - 1; k >= 0; k--) {
                    deque.push(temp.get(k));
                }
                deque.push(new WordForNum('(', 1));
            }
            if (!deque.isEmpty() && deque.peek().getWord() == '(') {
                deque.pop();
            }
        }

        Object[] cha = deque.toArray();
        for (int i = 0; i < cha.length; i++) {
            char cur;
            int curNum;
            while (i < cha.length) {
                cur = ((WordForNum) cha[i]).getWord();
                curNum = ((WordForNum) cha[i]).getNum();
                map.put(cur, map.getOrDefault(cur, 0) + curNum);
                i++;
            }
        }
        Set<Character> set = map.keySet();
        Object[] arr = set.toArray();
        Arrays.sort(arr);
        for (Object key : arr) {
            sd.append(key).append(map.get((char) key));
        }
        return sd.toString();
    }

    @Test
    public void test() {
        // X3Y2Z3
        System.out.println(quick("Z3X(XY)2"));
        // X8Y4Z16
        System.out.println(quick("Z4(Y2(XZ2)3)2X2"));
        // X6Y4Z6
        System.out.println(quick("Z2(Y2(XZ)2)2X2"));
    }
}
