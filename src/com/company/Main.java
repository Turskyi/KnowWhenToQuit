package com.company;

import java.util.Random;

public class Main {

    /*
    The martingale strategy.
     The gambler wins his stake if a coin comes up heads and loses it if the coin comes up tails.
     The strategy had the gambler double his bet after every loss,
     so that the first win would recover all previous losses plus win a profit equal to the original stake.
     The same strategy has been applied to roulette as well,
     as the probability of hitting either red or black is close to 50%.
     */

    public static void main(String[] args) {
        martingale ( );
    }

    private static void martingale() {
        int money = 1000;
        int target = 1200;
        int bet = 10;
        while (money > bet) {
            boolean win = play ( );
            if (win) {
                money += bet;
                bet = 10;
            }
            if (money >= target) {
                System.out.println (money);
                break;
            } else {
                money -= bet;
                bet *= 2;
            }
            System.out.println (money);
        }
    }

    private static boolean play() {
        Random random = new Random ( );
        boolean result = random.nextBoolean ( );
        System.out.println (result ? "win" : "loose");
        return result;
    }
}
