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
 */
public class GroupOfCards{
    
    enum Suit{
        CLOVERS, SPADES, HEARTS, DIAMONDS
    }
    enum Value{
        ACE, KING, QUEEN, JACK, TEN, NINE, EIGHT, SEVEN, SIX, FIVE, FOUR, THREE, TWO
    }
    
    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards = new ArrayList();
    private int size;//the size of the grouping

    public GroupOfCards(int size) {
        this.size = size;
        for (int n=0; n<4; n++){
            for(int i=0; i<13; i++){
                String suit=Suit.values()[n].name();
                String value=Value.values()[i].name();
                Card newCard = new CardMaker(suit,value);
                cards.add(newCard);
                //System.out.println(newCard.toString());
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
    
    public void shuffle() {
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
