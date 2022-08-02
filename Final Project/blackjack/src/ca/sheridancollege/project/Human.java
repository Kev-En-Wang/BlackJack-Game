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
        funds +=add;
    }
    
    public void subFunds(int sub){
        funds-=sub;
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
        Scanner input = new Scanner(System.in);
        System.out.println(super.getName()+" how much would you like to bet?");
        int bet = input.nextInt();
        System.out.println(getBankUI());
        if(funds<bet){
            System.out.println("You don't have the funds.");
            return false;
        }
        else{
            setBet(bet);
            subFunds(bet);
            BlackJack.potList.add(bet);
            System.out.println("Your bet has been placed"+getBankUI());
            return true;
        }
    }
    
    public void stay(){
        BlackJack.handList.add(myHand.getHandInt());
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
    private boolean didIBust(){
        return false;
    }
    
    private void userPrompt(boolean firstTurn){
        if(firstTurn){
            System.out.println("What would you like to do?");
            System.out.println("1 to Hit");
            System.out.println("2 to Stay");
            System.out.println("3 to Check Status");
            System.out.println("4 to Double Down");
            System.out.println("5 to Get Insurance");
        }
        else{
            System.out.println("What would you like to do?");
            System.out.println("1 to Hit");
            System.out.println("2 to Stay");
        }
        
    }
    
    @Override
    public void play(int playerNum) {
        boolean myTurn=true;
        
        //User prompt
        System.out.println(getStatus());
        
        

        //Testing
        for (int n=0; n<13; n++){
            System.out.print(GroupOfCards.cards.get(n).getValue() + " is  ");
            System.out.println(GroupOfCards.cards.get(n).getIntValue());
            
        }
        //Testing
        Scanner input = new Scanner(System.in);
        boolean firstTurn=true;
        
        //While it's the human player's turn
        while(myTurn){
            userPrompt(firstTurn);
            try{
                int x = input.nextInt();
                switch (x){
                    
                    //HIT ME
                    case 1:
                        hit();
                        
                        //If the player busts then their hand value becomes negative 1
                        if(didIBust()){
                            BlackJack.handList.add(-1);
                            myTurn=false;
                        }
                        else{
                            firstTurn=false;
                        }
                        
                        break;
                    
                    //I'LL STAY, THANKS
                    case 2:
                        stay();
                        myTurn = false;
                        break;
                    
                    //HOW AM I DOIN' DOC?
                    case 3:
                        System.out.println(getStatus());
                        break;
                    
                    //DOUBLE DOWN, LET'S GOOOOOO
                    case 4:
                        if(doubleDown(playerNum)&&firstTurn){
                            System.out.println("You double downed");
                            myTurn = false;
                        }
                        else{
                            System.out.println("Not enough funds to double down.");
                        }
                        break;
                        
                    //BUDDY, IF THINGS LOOK BAD NOW. IT'S GONNA GET A LOT MORE HAIRY SOON
                    case 5:
                        System.out.println("Insurance goes here.");
                    
                    //YOU CAN'T DO THAT, BUDDY
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
