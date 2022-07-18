/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *SYST 17796
 *The game with all the methods of the game
 * 
 * @author Kevin (Zheng Yi) Wang
 */
public class BlackJack extends Game {
    
    //An array list for each player's hand when they play
    private ArrayList<Hand> handList;
    
    //An array list for each player's bet
    private ArrayList<Integer> potList;
    
    //An array list for the winners
    private ArrayList<Human> winList;
    
    //An array list for the eliminated
    private ArrayList<Human> deadList;
    
    
    public BlackJack(){
        super("Blackjack");
    }
    
    //Used to register players into the game. 
    //Creates a player object and prompts user for ID
    public void register(){
        //Number of players to register
        int numPlayers;
        //ID of each player
        String id;
        Scanner input= new Scanner(System.in);
        
        while(true){
            //User prompt for number of players
            System.out.println("How many players are playing?");
            
            //Makes sure it catches bad inputs
            try{
                numPlayers = input.nextInt();
                
                //Catches if the player tries to be clever
                if (numPlayers<=0){
                    System.out.println("Can't be 0 or fewer");
                    input.nextLine();
                    continue;
                }
                
                input.nextLine();
                break;
            }            
            catch(Exception a){
                System.out.println("Invalid input, try again");
                input.nextLine();
            }
        }
        
        //Prompts IDs for each player and adds them to the player list
        //This also makes a human player object for each of them
        //One slight problem is the name in the array is human for all human players, but human IDs are unique
        
        //It adds one human player first
        System.out.println("What's your player name?");
        id=input.nextLine();
        Human human = new Human(id);
        players.add(human);
        
        for(int n=1; n<numPlayers;n++){
            
            //This makes sure each user ID is unique
            boolean isRepeat=true;
            while(isRepeat){
                System.out.println("What's your player name?");
                id=input.nextLine();
                
                //This iterates through the player list
                for (int i=0; i<n; i++){
                    //This checks the all the previous ids with the current one
                    if (id.equals(players.get(i).getName())){
                        System.out.println("ID is already taken. Use another name");
                        
                        //if it's not unique, then it sets it to repeat the loop again
                        isRepeat=true;
                        break;
                    }
                    else{
                        isRepeat=false;
                    }
                }
            }
            
            //If it's unique, then it adds it as a player
            human = new Human(id);
            players.add(human);
        }
        input.close();
        //Adds the Dealer player at the end
        Dealer dealer = new Dealer();
        players.add(dealer);
    }
    
    //This changes the player's bank and potList for the turn
    public void bet(Human player, int bet){
        while(true){
            
            //This checks if the player has enough to bet
            if(player.getBankInt()>=bet&&bet>0){
                potList.add(bet);
                player.subFunds(bet);
                break;
            }
            else{
                System.out.println("Please enter a valid integer");
            }
        }
    }
    
    //This deals another card to the player
    public void hit(Human player, int index){
        
    }
    
    public void stay(Human player, int index){
    
    }
    
    //This requires the player and the index of the player in the player list
    public boolean doubleDown(Human player, int index){
        //This sets the bet to double
        int bet = 2*potList.get(index);
        
        //This checks if you can actually double down
        if (bet>player.getBankInt()){
            System.out.println("Not enough funds to double down.");
            return false;
        }
        //This takes the funds out of the player bank and then puts it into the pot
        else{
            player.subFunds(potList.get(index));
            potList.set(index, bet);
            return true;
        }
    }
    
    
    //This deals a hand to the human player
    public void dealHandHuman(Human player){
        //Iterating through every player
        for (int n=0; n<(players.size()-1);n++){
            
        }
    }
    
    //This deals a hand to the dealer
    public void dealHandDealer(){
    
    }
    
    
    @Override
    public void play() {
        //This iterates through every human player
        //The first loop is for the bet
        for (int n=0; n<(players.size()-1);n++){
            
        }
        
    }

    @Override
    public void declareWinner() {
        
    }
    
    public void declareDead(){
    
    }
    
    
}
