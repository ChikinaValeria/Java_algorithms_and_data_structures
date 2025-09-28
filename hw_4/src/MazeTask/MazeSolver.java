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
public class MazeSolver {
    private Maze maze;

    /**
     * Constructor for the MazeSolver class.
     */
    public MazeSolver(Maze maze) {
        this.maze = maze;
    }

    /**
     * Attempts to traverse the maze using a stack. Inserts special
     * characters indicating locations that have been TRIED and that
     * eventually become part of the solution PATH.
     *
     * @param row    row index of current location
     * @param column column index of current location
     * @return true if the maze has been solved
     */
    public boolean traverse() {
        System.out.println("\nStarting maze traversal with a stack...");
        boolean done = false;
        PositionNode pos = new PositionNode(0, 0, null);
        Deque<PositionNode> stack = new LinkedList<>();
        stack.push(pos);

        System.out.println("Initial state:");
        System.out.println(maze);
        printStackContents(stack);

        while (!done && !stack.isEmpty()) {
            pos = stack.pop();
            System.out.println("Exploring position: (" + pos.getx() + ", " + pos.gety() + ")");
            maze.tryPosition(pos.getx(), pos.gety());

            if (pos.getx() == maze.getRows() - 1 && pos.gety() == maze.getColumns() - 1) {
                done = true;
                System.out.println("Path found! Tracing back the solution...");
                // Step by step visualization of marking Path
                traceAndMarkPath(pos);
                break;
            } else {
                System.out.println("  Checking neighbors...");
                push_new_pos(pos.getx() - 1, pos.gety(), stack, pos);
                push_new_pos(pos.getx() + 1, pos.gety(), stack, pos);
                push_new_pos(pos.getx(), pos.gety() - 1, stack, pos);
                push_new_pos(pos.getx(), pos.gety() + 1, stack, pos);
            }
            System.out.println("\n--- Current Maze State ---");
            System.out.println(maze);
            printStackContents(stack);
        }
        System.out.println("Traversal finished.");
        return done;
    }

    private void push_new_pos(int x, int y, Deque<PositionNode> stack, PositionNode currentParent) {
        if (maze.validPosition(x, y)) {
            PositionNode npos = new PositionNode(x, y, currentParent);
            stack.push(npos);
            System.out.println("  Pushed valid position: (" + x + ", " + y + ")");
        } else {
            System.out.println("  Position (" + x + ", " + y + ") is invalid.");
        }
    }

    private void printStackContents(Deque<PositionNode> stack) {
        System.out.print("Current Stack: [");
        for (PositionNode pos : stack) {
            System.out.print("(" + pos.getx() + "," + pos.gety() + ")");
        }
        System.out.println("]");
    }

    private void traceAndMarkPath(PositionNode endNode) {
        PositionNode current = endNode;
        while (current != null) {
            maze.markPath(current.getx(), current.gety());
            System.out.println("Marking path step: (" + current.getx() + ", " + current.gety() + ")");
            System.out.println(maze);
            current = current.getParent();
        }
    }
}