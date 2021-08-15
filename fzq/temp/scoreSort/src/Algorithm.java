public abstract class Algorithm {
    protected int weight;
    protected double upBound;
    protected double downBound;

    public Algorithm() {

    }

    public Algorithm(int weight, int upBound, int downBound) {
        this.weight = weight;
        this.upBound = upBound;
        this.downBound = downBound;
    }

    abstract Double calcScore(Double value);

    public int getWeight() {
        return weight;
    }
}
