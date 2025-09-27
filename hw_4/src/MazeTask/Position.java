package MazeTask;

/**
 * Position represents a location in a maze,
 * holding x (row) and y (column) coordinates.
 */
public class Position {
    private int x;
    private int y;

    /**
     * Default constructor initializes position to (0, 0).
     */
    public Position() {
        this(0, 0);
    }

    /**
     * Constructs a Position with specified coordinates.
     * @param x the x-coordinate (row)
     * @param y the y-coordinate (column)
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns the x-coordinate.
     * @return the x-coordinate
     */
    public int getx() {
        return x;
    }

    /**
     * Sets the x-coordinate.
     * @param x the x-coordinate to set
     */
    public void setx(int x) {
        this.x = x;
    }

    /**
     * Returns the y-coordinate.
     * @return the y-coordinate
     */
    public int gety() {
        return y;
    }

    /**
     * Sets the y-coordinate.
     * @param y the y-coordinate to set
     */
    public void sety(int y) {
        this.y = y;
    }
}
