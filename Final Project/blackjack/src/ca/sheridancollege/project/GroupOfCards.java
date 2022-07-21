/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you might want to subclass this more than
 * once. The group of cards has a maximum size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Kevin Wang 2022
 */
public class GroupOfCards{
    
    enum Suit{
        CLOVERS, SPADES, HEARTS, DIAMONDS
    }
    enum Value{
        ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO
    }
    
    //The group of cards, stored in an ArrayList
    protected static ArrayList<Card> cards = new ArrayList();
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        
        //This makes a new deck
        for (int i=0; i<4;i++){
            for(int n=0; n<13; n++){
                    String suit=Suit.values()[i].name();
                    String value=Value.values()[n].name();
                    Card newCard = new CardMaker(suit,value);
                    cards.add(newCard);
            }
        }
        
    }

    /**
     * A method that will get the group of cards as an ArrayList
     *
     * @return the group of cards.
     */
    public ArrayList<Card> getCards() {
        return cards;
    }

    public static void shuffle() {
        Collections.shuffle(cards);
    }

    /**
     * @return the size of the group of cards
     */
    public int getSize() {
        return size;
    }

    /**
     * @param size the max size for the group of cards
     */
    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return null;
    }

}//end class
