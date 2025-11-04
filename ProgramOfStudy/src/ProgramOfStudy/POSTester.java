package ProgramOfStudy;
import java.io.IOException;
import java.util.Scanner;

public class POSTester
{
    private static final String FILE_NAME = "ProgramOfStudy.dat";
    /**
     * Creates and populates a Program of Study. Then saves it using serialization.
     */
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Are you writing or reading ProgramOfStudy? Answer W = writing or R = reading: ");
        String choice = scan.nextLine().toUpperCase();

        if (choice.startsWith("W"))
        {
            // writing
            ProgramOfStudy pos = new ProgramOfStudy();

            pos.addCourse(new Course("CS", 101, "Introduction to Programming", "A-"));
            pos.addCourse(new Course("ARCH", 305, "Building Analysis", "A"));
            pos.addCourse(new Course("GER", 210, "Intermediate German"));
            pos.addCourse(new Course("CS", 320, "Computer Architecture"));
            pos.addCourse(new Course("THE", 201, "The Theatre Experience"));

            Course arch = pos.find("CS", 320);
            pos.addCourseAfter(arch, new Course("CS", 321, "Operating Systems"));
            Course theatre = pos.find("THE", 201);
            theatre.setGrade("A-");

            Course german = pos.find("GER", 210);
            pos.replace(german, new Course("FRE", 110, "Beginning French", "B+"));

            System.out.println("Saving ProgramOfStudy to file: " + FILE_NAME + "...");
            pos.save(FILE_NAME);
            System.out.println("Saving completed.");
        }
        else if (choice.startsWith("R"))
        {
            // reading
            System.out.println("Reading ProgramOfStudy from file: " + FILE_NAME + "...");
            try
            {
                ProgramOfStudy loadedPos = ProgramOfStudy.load(FILE_NAME);
                System.out.println("Load complete. Loaded data:");
                System.out.println(loadedPos);
            }
            catch (IOException e)
            {
                System.out.println("Error reading file. File does not exist or there was a read error: " + e.getMessage());
            }
            catch (ClassNotFoundException e)
            {
                System.out.println("Error: Class not found during deserialization: " + e.getMessage());
            }
        }
        else
        {
            System.out.println("Invalid choice. Answer W = writing or R = reading: ");
        }

        scan.close();
    }
}