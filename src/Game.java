import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

public class Game {
    private int difficulty = 0;
    private int maxValue = 9;
    private int value=1;
    private int maximumGuesses = 3;
    private User myUser;
    ScoreBoard myScoreBoard;

    public Game(){
        myScoreBoard = new ScoreBoard(new String[] {"Name","Difficulty","Guesses"});
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Do you wish to play (y/n)");
            if(scanner.nextLine().equals("y")){
                setDifficulty();
                myUser = new User();
                play();
                myScoreBoard.getResults(4);
            }
            else{
                break;
            }
        }
    }

    private void play(){
        Random r = new Random();
        value = r.nextInt(maxValue)+1;
        for(int x =0; x<maximumGuesses; x++){
           int guess = myUser.getGuess();
           if(checkGuess(guess)){
               myScoreBoard.addResult(new String[]{myUser.getName(), ""+difficulty, ""+myUser.getGuesses()});
               return;
           }
        }
        System.out.println("you lose value was "+value);
    }

    private boolean checkGuess(int guess){
        if(guess<value){
            System.out.println("go higher");
            return false;
        }
        else if(guess>value){
            System.out.println("go lower");
            return false;
        }
        System.out.println("correct");
        return true;
    }

    private void setDifficulty(){
        System.out.println("Please enter difficulty (a positive integer)");
        Scanner scanner = new Scanner(System.in);
        while(true) {
            try {
                difficulty = Integer.valueOf(scanner.nextLine());
                if(difficulty>0){
                    maximumGuesses = 2 * difficulty;
                    maxValue = difficulty * difficulty;
                    System.out.println("Maximum Guesses:" + maximumGuesses);
                    System.out.println("Maximum Value:" + maxValue);
                    return;
                }
            } catch (NumberFormatException e) {
            }
            System.out.println("Value is not a positive integer. Please enter difficulty (a positive integer)");
        }
    }

    public static void main(String[] args) {
        Game g = new Game();
    }
}
