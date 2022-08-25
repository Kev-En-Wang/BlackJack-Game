/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;
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
    
    private String getBankUI(){
        return "You have "+funds+" dollars in your bank.";
    }
    
    private String getBetUI(){
        return "You're betting "+myBet+ " dollars.";
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
    
    public void setBet(int n){
        myBet=n;
    }
    
    public int getBet(){
        return myBet;
    }
    
    //This gives the status of the current player
    private String getStatus(){
        String status = "The current player is: "+ super.getName()+"\n"+getBetUI();
        return status;
    }
    
    //This shows the hand of the current player
    private String showHand(){
        String myHand="";
        for (int i=0; i<handCards.size(); i++){
            myHand+=handCards.get(i).getValue()+" of "+handCards.get(i).getSuit()+"\n";
        }
        
        return "Your cards are:\n" + myHand;
    }
    
    
    
    
    //Method for betting for each individual player
    public boolean bet(){
        Scanner input = new Scanner(System.in);
        System.out.println(getBankUI());
        System.out.println(super.getName()+" how much would you like to bet?");
        int bet = input.nextInt();
        if(funds<bet){
            System.out.println("You don't have the funds.");
            return false;
        }
        else{
            setBet(bet);
            subFunds(bet);
            //BlackJack.potList.add(bet);
            System.out.println("Your bet has been placed\n"+getBankUI());
            return true;
        }
    }
    
    //This requires the player and the index of the player in the player list
    private boolean doubleDown(int index){
        //This sets the bet to double the original
        int bet = 2*myBet;
        
        //This checks if you can actually double down
        if (bet>getBankInt()){
            return false;
        }
        //This takes the funds out of the player bank and then puts it into the pot
        else{
            
            subFunds(myBet);
            //BlackJack.potList.set(index, bet);
            return true;
        }
    }
    /*
    * The user prompt depends on which turn it's on
    * because after the first turn it'll prompt
    * the only valid choices
    */
    
    private void userPrompt(boolean firstTurn){
        if(firstTurn){
            System.out.println(Dealer.showFirstCard());
            System.out.println("What would you like to do?");
            System.out.println("1 to Hit");
            System.out.println("2 to Stay");
            System.out.println("3 to Check Status");
            System.out.println("4 to Double Down");
            //System.out.println("5 to Get Insurance");
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
        /*
        *Instead of making a deal function
        *I just made it so it hits twice to start
        */
        hit();
        hit();
        //User prompt
        System.out.println(getStatus());
        
        Scanner input = new Scanner(System.in);
        boolean firstTurn=true;
        
        //While it's the human player's turn
        while(myTurn){
            
            //This prompts the user accordingly
            userPrompt(firstTurn);
            System.out.println(showHand());
            
            //This is where the user puts in what he/she wants to do
            try{
                int x = input.nextInt();
                
                //switch case instead of "if" statements
                switch (x){
                    
                    //HIT ME
                    case 1:
                        hit();
                        //If the player busts then their hand value becomes -1
                        if(didIBust()){
                            myTurn=false;
                            System.out.println("----BUSTED----\n"+showHand()+"----BUSTED----");
                        }
                        else{
                            firstTurn=false;
                        }
                        break;
                    
                    //I'LL STAY, THANKS
                    case 2:
                        myTurn = false;
                        break;
                    
                    //HOW AM I DOIN' DOC? Status check
                    case 3:
                        System.out.println(getStatus());
                        System.out.println(Dealer.showFirstCard());
                        System.out.println(showHand());
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
                        
                    //BUDDY, IF THINGS LOOK BAD NOW. IT'S GONNA GET A LOT WORSE SOON
                    case 5:
                        System.out.println("Insurance goes here.");
                    
                    //YOU CAN'T DO THAT, BUDDY
                    default:
                        System.out.println("That's not a choice.");
                }
            }
            catch (Exception a){
                System.out.println("Invalid Input, try again.");
            }
           
        }
    }
}
