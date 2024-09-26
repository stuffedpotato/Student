import java.util.Scanner;

/**
 * Program Name: StudentTester;
 * Student Name: Piyusha Satija;
 * Student ID: 200001855;
 * Date: Jan 18, 2024;
 * Course: CPSC 1181-003;
 * Compiler: IntelliJ IDEA 2023.2.1 OpenJDK
 */

public class StudentTester
{
    /**
     * This is the testing program for the Student Class.
     * User can add a student and use the following operations:
     *      1. Access student's name (getName).
     *      2. Access student's address (getAddress).
     *      3. Add course information (addCourse).
     *      4. Calculate student's GPA (calculateGPA).
     *      5. Access student number (getStudentNum).
     *      6. Access student's login ID (getLoginId).
     * The user can also choose to add a new student and use these options again.
     */

    public static void main(String[] args)
    {
        int option;
        String name, address, choice;
        Student stu;

        System.out.println("\nThis program is to test the Student Class.");

        Scanner input = new Scanner(System.in);

        do
        {
            System.out.println("\nPlease enter the student's full name (FirstName LastName): ");
            name = input.nextLine().trim();

            System.out.println("\nPlease enter the student's address (free format): ");
            address = input.nextLine().trim();

            if (validInput(name))
            {
                name = name.substring(0, name.indexOf(' ')) + name.substring(name.lastIndexOf(' '));
                stu = new Student(name, address);
            }
            else
            {
                System.out.println("\nERROR: Please enter the student name in this format only -- FirstName LastName -- and try again.");
                return;
            }

            do
            {
                System.out.println("\nWhat would you like to do with this program? Choose an option below: " +
                        "\n1. Access student's name (getName)." +
                        "\n2. Access student's address (getAddress)." +
                        "\n3. Add course information (addCourse)." +
                        "\n4. Calculate student's GPA (calculateGPA)." +
                        "\n5. Access student number (getStudentNum)." +
                        "\n6. Access student's login ID (getLoginId).\n");

                option = input.nextInt();

                switch (option)
                {
                    case 1: System.out.println("\nThe student's name is " + stu.getName() +".");
                        break;

                    case 2: System.out.println("\nThe student's address is " + stu.getAddress() + ".");
                        break;

                    case 3: addNewCourse(stu, input);
                        break;

                    case 4: System.out.println("\nThe student's GPA is " + stu.calculateGPA() + ".");
                        break;

                    case 5: System.out.println("\nThe student number is " + stu.getStudentNum() + ".");
                        break;

                    case 6: System.out.println("\nThe student's login ID is " + stu.getLoginId() + ".");
                        break;
                }

                input.nextLine();
                System.out.println("\nWould you like to use this program again for the same student? (enter \"Yes\" or \"No\"): ");
                choice = input.nextLine().toLowerCase();
            }
            while (!choice.equals("no"));

            System.out.println("\nWould you like to enter a new student? (enter \"Yes\" or \"No\"): ");
            choice = input.nextLine().toLowerCase();
        }
        while (!choice.equals("no"));

        System.out.println("\nThank you for using this program!");
    }

    /**
     * This method validates the format of the name --FirstName LastName -- entered by the user.
     * @param name is the input name.
     * @return true if the format is correct and false if the format is incorrect.
     */

    public static boolean validInput(String name)
    {
        int totalWords = 1;
        int indexSpace = name.indexOf(' ');

        while (indexSpace > -1)
        {
            name = name.substring(indexSpace + 1).trim();
            totalWords++;
            indexSpace = name.indexOf(' ');
        }

        if (totalWords == 2)
        {
            return true;
        }

        return false;
    }

    /**
     * This method lets the user add course information for a student including course credits and grade points earned.
     * This method then invokes the addCourse method of the Student class.
     * @param stu is the created object of the Student class.
     * @param input is the scanner object for the user to enter the number of credits and grade points.
     */

    public static void addNewCourse(Student stu, Scanner input)
    {
        System.out.println("\nPlease enter the total number of credits for this course: ");
        int credits = input.nextInt();

        System.out.println("\nPlease enter the grade points earned for this course: ");
        double gradePoints = input.nextDouble();

        stu.addCourse(credits, gradePoints);
    }
}

