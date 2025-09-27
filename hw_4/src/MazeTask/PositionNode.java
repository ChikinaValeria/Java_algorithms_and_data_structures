package MazeTask;

/**
 * PositionNode represents a location in a maze,
 * holding x (row) and y (column) coordinates,
 * as well as a reference to its parent node
 * to trace the path back.
 */
public class PositionNode {
    private int x;
    private int y;
    private PositionNode parent;

    public PositionNode() {
        this(0, 0, null);
    }

    public PositionNode(int x, int y) {
        this.x = x;
        this.y = y;
        this.parent = null;
    }

    public PositionNode(int x, int y, PositionNode parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public int getx() {
        return x;
    }

    public int gety() {
        return y;
    }

    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public PositionNode getParent() {
        return parent;
    }
}