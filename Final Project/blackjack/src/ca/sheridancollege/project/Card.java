/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general enough to be instantiated for any Card
 * game. Students wishing to add to the code should remember to add themselves as a modifier.
 * @author Kevin Wang 2022
 * @author dancye
 */
public abstract class Card {
    protected String suit;
    protected String value;
    protected int intValue;
    
    public Card(String suit, String value, int intValue){
        this.suit=suit;
        this.value=value;
        this.intValue=intValue;
    }
    public String getSuit(){
        return suit;
    }
    
    public String getValue(){
        return value;
    }
    
    public int getIntValue(){
        return intValue;
    }
    //default modifier for child classes
    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a regular playing card etc.
     */
    @Override
    public abstract String toString();
}
