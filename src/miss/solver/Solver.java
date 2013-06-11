package miss.solver;

public abstract class Solver {
    private Long state;

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    abstract public long getNextMessage();
}
