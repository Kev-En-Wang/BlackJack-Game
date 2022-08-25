/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;

/**
 *SYST 17796
 *
 * @author Kevin (Zheng Yi) Wang
 */

public class Deck extends GroupOfCards{
    //This keeps track of which card the deck is dealing next
    private static int cardNum = 0;
    
    //Deck constructor
    public Deck(){
        super(52);
    }
    
    //This resets the index of the card
    public void resetCardNum(){
        cardNum=0;
    }
    
    //This deals a cards to a hand
    public static Card takeCard(){
        cardNum++;
        return cards.get(cardNum-1);
    }
}