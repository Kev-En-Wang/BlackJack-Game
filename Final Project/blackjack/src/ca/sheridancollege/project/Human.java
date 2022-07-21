/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;
import static java.lang.System.in;
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
    //Amount of money the person's betting this round
    private int myBet;
    //The player's hand
    private Hand myHand = new Hand();
    
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
        return "You have "+funds+" dollars in your bank.";
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
    
    public String getStatus(){
        String status = "The current player is: "+ super.getName()+"\n"+getBankUI();
        return status;
    }
    
    private void setBet(int n){
        myBet=n;
    }
    
     //This deals another card to the player
    public void hit(){
        
    }
    
    @Override
    public boolean bet(){
        
        if(funds<bet){
            System.out.println("You don't have the funds.");
            return false;
        }
        else{
            setBet(bet);
            subFunds(bet);
            BlackJack.potList.add(bet);
            System.out.println("Your bet has been placed");
            return true;
        }
    }
    
    public void stay(){
    
    }
    
    //This requires the player and the index of the player in the player list
    public boolean doubleDown(int index){
        //This sets the bet to double the original
        int bet = 2*myBet;
        
        //This checks if you can actually double down
        if (bet>getBankInt()){
            return false;
        }
        //This takes the funds out of the player bank and then puts it into the pot
        else{
            
            subFunds(myBet);
            BlackJack.potList.set(index, bet);
            return true;
        }
    }
    
    //Did I bust, or can I keep going?
    public void didIBust(){
        
    }
    
    private void userPrompt(){
        System.out.println("What would you like to do?");
        System.out.println("1 to Hit");
        System.out.println("2 to Stay");
        System.out.println("3 to Double Down");
        System.out.println("4 to Check Status");
    }
    
    @Override
    public void play(int playerNum) {
        boolean myTurn=true;
        
        //User prompt
        System.out.println(getStatus());
        userPrompt();
        
        Scanner input = new Scanner(System.in);

        //While it's the human player's turn
        while(myTurn){
            try{
                int x = input.nextInt();
                switch (x){
                    case 1:
                        hit();
                        didIBust();
                        break;
                    case 2:
                        stay();
                        myTurn = false;
                        break;
                    case 3:
                        if(doubleDown(playerNum)){
                            System.out.println("You double downed");
                            myTurn = false;
                        }
                        else{
                            System.out.println("Not enough funds to double down.");
                        }
                        break;
                    case 4:
                        System.out.println(getStatus());
                        break;
                    default:
                        System.out.println("That's not a choice.");
                }
            }
            catch (Exception a){
                System.out.println("Invalid Input, try again.opoypt");
                break;
            }
           
        }
    }

}
