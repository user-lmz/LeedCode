package p5187;

public class CollectApple {
    private final int neededApples;
    public CollectApple(int neededApples) {
        this.neededApples = neededApples;
    }
    public int getPerimeter() {
        int i=0, sum = 0, s;
        while(sum < this.neededApples) {
            i++;
            sum += 3*4*i*i;
        }
        s = 2*i;
        return 4*s;
    }
}
