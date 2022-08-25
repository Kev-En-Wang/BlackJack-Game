/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @modified by Kevin Wang 2022
 * @modified Mhd Kartoumeh
 */
public abstract class Player {
    
    //The player's hand
    public ArrayList<Card> handCards = new ArrayList();
    
    private String name; //the unique name for this player

    /**
     * A constructor that allows you to set the player's unique ID
     *
     * @param name the unique ID to assign to this player.
     */
    public Player(String name) {
        this.name = name;
    }

    /**
     * @return the player name
     */
    public String getName() {
        return name;
    }
    
    /**
     * Ensure that the playerID is unique
     *
     * @param name the player name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    //This deals another card to the player
    protected void hit(){
        handCards.add(Deck.takeCard());
    }
    
    /**
    * Did I bust, or can I keep going?
    * Tricky thing is if there's an ace
    * You shouldn't bust depending on
    * the values in your hand
    * @return Boolean
    */
    protected boolean didIBust(){
        boolean hasAce=false;
        for(int i=0; i<handCards.size();i++){
            if(handCards.get(i).getIntValue()==11){
                hasAce=true;
            }
        }
        
        /*
        This sees if the hand is bigger than 21
        If it is, then if the hand is less than 31
        and has an ace, the player doesn't bust
        */
        if(getHandInt()<=21){
            return false;
        }
        else if(getHandInt()<31&&hasAce){
            return false;
        }
        else{
            return true;
        }
    }
    
    /**
    * Method for if the player decides to stay
    */

    //This returns the integer value for the hand
    protected int getHandInt(){
        int handVal=0;
        for(int i=0; i<handCards.size(); i++){
            handVal+=handCards.get(i).getIntValue();
        }
        return handVal;
    }

    /**
     * The method to be overridden when you subclass the Player class with your specific type of Player and filled in
     * with logic to play your game.
     * @param playerNum
     */
    public abstract void play(int playerNum);
}
