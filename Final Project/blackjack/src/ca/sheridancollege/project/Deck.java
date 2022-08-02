/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 *SYST 17796
 *
 * @author Kevin (Zheng Yi) Wang
 */

public class Deck extends GroupOfCards{
    //This keeps track of which card the deck is dealing next
    int cardNum = 0;
    public void cardNumReset(){
        cardNum=0;
    }
    
    //Deck constructor
    public Deck(){
        super(52);
    }
    
    public void resetCardNum(){
        cardNum=0;
    }
    
    //This deals cards to a hand
    public void dealHuman(Human player, int n){
        //This sets a hand card to the next card in the deck and adds 1 to the index
        for (int i=0; i<n; i++){
            player.handCards.add(cards.get(cardNum));
            cardNum++;
        }
    }
}
