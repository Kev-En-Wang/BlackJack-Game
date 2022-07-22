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
public class Hand extends Deck{
    
    public static ArrayList<Card> handCards = new ArrayList();
    
    public Hand(){
        
    }
    
    //shows the hand
    public void showHand(){
        for(int i=0; i<handCards.size();i++){
            System.out.println(handCards.get(i).toString());
        }
    }
    
    public int getHandInt(){
        int handValue;
        for(int i=0; i<handCards.size();i++){
            System.out.println(handCards.get(i).toString());
        }
        return 5;
    }

}
