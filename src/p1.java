import java.util.*;
import java.security.SecureRandom;

public class p1 {

    static int newQuestion(int level, int type)
    {
        Random rand = new Random();
        int num1 = 0;
        int num2 = 0;
        int result = 0;

        switch(level)
        {
            case 1:
                num1 = rand.nextInt(10);
                num2 = rand.nextInt(10);
                break;
            case 2:
                num1 = rand.nextInt((99-10)+1)+10;
                num2 = rand.nextInt((99-10)+1)+10;
                break;
            case 3:
                num1 = rand.nextInt((999-100)+1)+100;
                num2 = rand.nextInt((999-100)+1)+100;
                break;
            case 4:
                num1 = rand.nextInt((9999-1000)+1)+1000;
                num2 = rand.nextInt((9999-1000)+1)+1000;
                break;
        }

        switch(type)
        {
            case 1:
                System.out.println("What is " + num1 + " plus " + num2 + "?");
                result = num1 + num2;
                break;
            case 2:
                System.out.println("What is " + num1 + " times " + num2 + "?");
                result = num1 * num2;
                break;
            case 3:
                System.out.println("What is " + num1 + " minus " + num2 + "?");
                result = num1 - num2;
                break;
            case 4:
                System.out.println("What is " + num1 + " divided by " + num2 + "?");
                result = num1 / num2;
                break;
        }

        return result;
    }

    static void correctReply(int x)
    {
        switch(x)
        {
            case 1:
                System.out.println("Very good!");
                break;
            case 2:
                System.out.println("Excellent!");
                break;
            case 3:
                System.out.println("Nice work!");
                break;
            case 4:
                System.out.println("Keep up the good work!");
        }

    }

    static void incorrectReply(int x)
    {
        switch(x)
        {
            case 1:
                System.out.println("No. Please try again.");
                break;
            case 2:
                System.out.println("Wrong. Try once more.");
                break;
            case 3:
                System.out.println("Don't give up!");
                break;
            case 4:
                System.out.println("No. Keep trying.");
                break;
        }
    }

    public static void main(String[] args) {

        SecureRandom rand = new SecureRandom();
        Scanner input = new Scanner(System.in);
        boolean cont = false;
        int result, response, difficulty, percentage, questionType;
        int mixture = 0;
        int right = 0;
        int wrong = 0;

        do {

            System.out.println("Choose a level of difficulty from 1 to 4");
            difficulty = input.nextInt();
            System.out.println("Choose 1 for addition only\nChoose 2 for multiplication only\nChoose 3 for subtraction only\nChoose 4 for division only\nChoose 5 for a mixture of all four");
            questionType = input.nextInt();

            if(questionType == 5)
            {
                mixture = 1;
            }

            for (int x = 0; x < 10; x++) {
                if(mixture == 1)
                {
                    questionType = rand.nextInt((4-1)+1)+1;
                }
                result = newQuestion(difficulty, questionType);
                response = input.nextInt();

                if (response == result) {
                    right += 1;
                    correctReply(rand.nextInt((4 - 1) + 1) + 1);
                }

                else {
                    wrong += 1;
                    incorrectReply(rand.nextInt((4 - 1) + 1) + 1);
                }

            }
            percentage = (right * 100)/10;

            System.out.println("You got " + percentage + "% correct");

            if (percentage < 75) {
                System.out.println("Please ask your teacher for extra help\n");
            }

            else {
                System.out.println("Congratulations, you are ready to go to the next level!\n");
            }

            right = 0;
            wrong = 0;
            mixture = 0;
            cont = true;

        }while(cont == true);
    }
}

