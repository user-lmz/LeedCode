public class Solution223 {
    public static int computeArea(int ax1, int ay1, int w1, int h1,
                                  int bx1, int by1, int w2, int h2,
                                  int cx1, int cy1, int w3, int h3)
    {
        int overlapWidth = Math.min(Math.min(ax1+w1, bx1+w2), cx1+w3) - Math.max(Math.max(ax1, bx1), cx1);
        int overlapHeight = Math.min(Math.min(ay1, by1), cy1) - Math.max(Math.max(ay1-h1, by1-h2), cy1-h3);
        return Math.max(overlapWidth, 0)*Math.max(overlapHeight, 0);
    }
    public static void main(String[] args) {
        int area = computeArea(
                1, 6, 4, 4,
                3, 5, 3, 4,
                0, 3, 7, 3);
        System.out.println(area);
    }
}
