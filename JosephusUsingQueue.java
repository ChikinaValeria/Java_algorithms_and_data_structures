import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *The person who survives the
 * current round is moved from the front to the back of the queue.
 * The person to be eliminated is removed.
 */
public class JosephusUsingQueue
{
    public static void main(String[] args)
    {
        int numPeople, skip;
        Queue<String> queue = new LinkedList<>();
        Scanner in = new Scanner(System.in);

        // get the initial number of soldiers
        System.out.print("Enter the number of soldiers: ");
        numPeople = in.nextInt();
        in.nextLine();

        // get the number of soldiers to skip
        System.out.print("Enter the number of soldiers to skip: ");
        skip = in.nextInt();

        // load the initial queue of soldiers
        for (int count = 1; count <= numPeople; count++)
        {
            queue.offer("Soldier " + count);
        }

        System.out.println("The order is: ");

        // Loop until the queue is empty
        int eliminationCount = 0;
        while (!queue.isEmpty())
        {
            // Move skip people from front to back of the queue
            for (int i = 0; i < skip; i++)
            {
                String personToMove = queue.poll();
                if (personToMove != null) {
                    queue.offer(personToMove);
                }
            }
            // The person at the front is the one to be eliminated
            String eliminatedPerson = queue.poll();
            if (eliminatedPerson != null) {
                System.out.println(eliminatedPerson);
                eliminationCount++;
            }
        }
    }
}