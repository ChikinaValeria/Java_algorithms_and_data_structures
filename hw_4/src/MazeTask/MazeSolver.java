package MazeTask;

import java.util.*;
/**
 * MazeSolver attempts to traverse a Maze using a stack. The goal is to get from the
 * given starting position to the bottom right, following a path of 1's. Arbitrary
 * constants are used to represent locations in the maze that have been TRIED
 * and that are part of the solution PATH.
 *
 * @author Lewis and Chase
 * @version 4.0
 */
public class MazeSolver
{
    private Maze maze;

    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze)
    {
        this.maze = maze;
    }
    /**
     * Attempts to traverse the maze using a stack. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse()
    {
    boolean done = false;
    PositionNode pos = new PositionNode(0, 0, null); // Изменено
    Deque<PositionNode> stack = new LinkedList<PositionNode>(); // Изменено
        stack.push(pos);

        while (!(done) && !stack.isEmpty())
    {
        pos = stack.pop();
        maze.tryPosition(pos.getx(), pos.gety());
        if (pos.getx() == maze.getRows() - 1 && pos.gety() == maze.getColumns() - 1)
        {
            done = true;
            // Начинаем отслеживать путь назад
            PositionNode current = pos;
            while (current != null) {
                maze.markPath(current.getx(), current.gety());
                current = current.getParent();
            }
        }
        else
        {
            push_new_pos(pos.getx() - 1, pos.gety(), stack, pos); // Изменено
            push_new_pos(pos.getx() + 1, pos.gety(), stack, pos); // Изменено
            push_new_pos(pos.getx(), pos.gety() - 1, stack, pos); // Изменено
            push_new_pos(pos.getx(), pos.gety() + 1, stack, pos); // Изменено
        }
    }
        return done;
}

private void push_new_pos(int x, int y, Deque<PositionNode> stack, PositionNode currentParent)
{
    if (maze.validPosition(x, y)) {
        PositionNode npos = new PositionNode(x, y, currentParent); // Изменено
        stack.push(npos);
    }
}
}