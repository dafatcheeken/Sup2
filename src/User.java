import java.util.Scanner;

public class User {
    private String name;
    private int guesses = 0;

    public User(){
        Scanner s = new Scanner(System.in);
        System.out.println("What is your name");
        name = s.nextLine();
    }
    public int getGuess(){
        int value;
        Scanner s = new Scanner(System.in);
        System.out.println("What is your guess");
        while(true){
            try{
                value = Integer.valueOf(s.nextLine());
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Please enter an integer");
            }
        }
        guesses++;
        return value;
    }
    public String getName(){
        return name;
    }
    public int getGuesses(){
        return guesses;
    }
}
