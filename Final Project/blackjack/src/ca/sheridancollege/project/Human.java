/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *SYST 17796
 *
 * @author Kevin (Zheng Yi) Wang
 */
public class Human extends Player{
    
    //Amount of money each person has
    private int funds;
    
    
    //Human Constructor
    public Human(String name){
        super(name);
        funds = 1000;
    }
    
    /**
     * Getter for funds
     * 
     * And adding and subtracting funds methods
     * 
     * @return Amount of funds you have
     */
    
    public String getBankUI(){
        return "You have "+funds+" dollars";
    }
    
    public int getBankInt(){
        return funds;
    }
    
    public void addFunds(int add){
        funds =+add;
    }
    
    public void subFunds(int sub){
        funds=- sub;
    }
    
    
    
    @Override
    public void play() {
        //Used to stay on the player's turn
        boolean myTurn = true;
        Scanner input = new Scanner(System.in);
        
        //User prompt
        System.out.println("It's now: "+ getName()+ "'s turn!");
        System.out.println("What would you like to do?");
        System.out.println("1 to Hit");
        System.out.println("2 to Stay");
        System.out.println("3 to Double Down");
        System.out.println("4 to Check Status");
        System.out.println("5 to ");
        
    }

}
