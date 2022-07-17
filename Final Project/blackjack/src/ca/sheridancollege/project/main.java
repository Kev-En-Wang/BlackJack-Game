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
public class main {
    public static void main(String[] args){
        GroupOfCards deck = new Deck();
        Card newCard = new CardMaker("CLOVERS","KING");
        System.out.println(newCard.toString());
    
    }
}
