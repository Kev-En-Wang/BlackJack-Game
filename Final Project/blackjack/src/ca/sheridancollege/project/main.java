/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *SYST 17796
 *
 * @author Kevin (Zheng Yi) Wang
 */
public class main {
    public static void main(String[] args){
        
        Scanner userIn = new Scanner(System.in);
        
        BlackJack newGame = new BlackJack();
        newGame.play();
        /*
        for(int n=0; n<newGame.getPlayers().size(); n++){
            System.out.println("Player " +n+ " is "+newGame.getPlayers().get(n).getName());
        }
        
        boolean keepPlaying=true;
        while(keepPlaying){
            //At the end of every hand, this prompt comes up to quit
            System.out.println("Would you like to keep playing?");
            System.out.println("Y/N");
            String answer = "N";
            if (answer.equals("N")){
                System.exit(1);
            }
        }
        userIn.close();
        */
    }
}
