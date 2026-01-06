package gama01;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Start game");
        System.out.println("Enter your choice (1-100)");

        int randNum = rand.nextInt(100)+1;
        int attemps = 0;
       int maxAttemps = 10;
       boolean won = false;

while(attemps<maxAttemps && !won){
    System.out.println((attemps+1) + "/"+ maxAttemps);
    int guess = sc.nextInt();
    attemps++;
    if(guess==randNum){
        won=true;
        System.out.println("Congratulations! You won!");
    } else if(guess < randNum){
        System.out.println("⬆️ My number is BIGGER!");
    } else if(guess > randNum){
        System.out.println("⬆️ My number is SMALLER!");
    }else if (attemps==maxAttemps){
        System.out.println("your attemps limited");
        System.out.println("Where be " + randNum);
    }else{
        System.out.println("try again");
    }

}

    }

}


