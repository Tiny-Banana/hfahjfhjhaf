package core;

public enum Direction {
    S(0),
    W(2),
    N(1),
    E(3);

    private int animationRow;

    Direction(int animationRow) {
        this.animationRow = animationRow;
    }

    public static core.Direction fromMotion(Motion motion) {
        double x = motion.getVector().getX();
        double y = motion.getVector().getY();

        if(x == 0 && y > 0) return S;
        if(x < 0 && y == 0) return W;
        if(x == 0 && y < 0) return N;
        if(x > 0 && y == 0) return E;
        if(x < 0 && y > 0) return W;
        if(x < 0 && y < 0) return W;
        if(x > 0 && y < 0) return E;
        if(x > 0 && y > 0) return E;

        return S;
    }

    public int getAnimationRow() {
        return animationRow;
    }
}
