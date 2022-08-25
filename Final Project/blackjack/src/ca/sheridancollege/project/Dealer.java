/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;


/**
 *SYST 17796
 *
 * @author Kevin (Zheng Yi) Wang
 * @author Mhd Kartoumeh
 */
public class Dealer extends Player{
    
    //This variable's only used to show the player the dealer's first card
    private static Card firstCard;
    
    //This variable's for the end of play to check how close each player's to winning
    private static int dealerHandVal;
    
    //Default constructor
    public Dealer(){
        super("Dealer");
    }
    
    public static int getDealerHandVal(){
        return dealerHandVal;
    }
    
    /**
     * This is when the dealer starts it removes any
     * previous cards and deals him 2 cards
     */
    public void initialize(){
        handCards.removeAll(handCards);
        hit();
        hit();
        firstCard=handCards.get(0);
    }
    
    //Shows the first card the dealer has
    public static String showFirstCard(){
        return "The dealer shows: "+firstCard.toString();
    }
    
    @Override
    /**
     * Very simply if dealer doesn't reach 17, then it has to keep
     * hitting. If he does, then his turn ends. Checks whether or not 
     * he busted every hit. If he does then he gets rid of all his cards
     * and he stops playing.
     */
    public void play(int nothing) {
        dealerHandVal=getHandInt();
        //Just to let the player know they're screwed
        if(getHandInt()==21){
            System.out.println("Dealer has blackjack.");
        }

        //This is for hard seventeen
        while (dealerHandVal<17){
            hit();
            dealerHandVal=getHandInt();
            
            //If the dealer busts then it'll announce what the dealer has first, then set his value to 0
            if(didIBust()){
                 System.out.println("+++++DEALER HAS BUSTED+++++");
                System.out.println("The dealer has "+ dealerHandVal+" with:");
                for(int n=0; n<handCards.size(); n++){
                       System.out.println(handCards.get(n).toString());
                }
                handCards.removeAll(handCards);
                System.out.println("+++++DEALER HAS BUSTED+++++");
                
                dealerHandVal=0;
                return;
            }
            //This is for if there's an ace that could make the value>21
            else if(dealerHandVal>21){
                dealerHandVal-=10;
                
            }
        }
        /*
         * Mainly for the user to see he hasn't been had
         */
        
        System.out.println("The dealer has "+ dealerHandVal+" with:");
        for(int n=0; n<handCards.size(); n++){
            System.out.println(handCards.get(n).toString());
        }
        
    }
}
