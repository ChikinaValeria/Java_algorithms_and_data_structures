package MazeTask;

public class PositionNode extends Position {
    private PositionNode parent;

    public PositionNode(int x, int y, PositionNode parent) {
        super(x, y);
        this.parent = parent;
    }

    public PositionNode getParent() {
        return parent;
    }
}
