/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ca.sheridancollege.project;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *SYST 17796
 * The main blackjack game
 * 
 * @author Kevin (Zheng Yi) Wang
 */
public class BlackJack extends Game {
    //Makes a new deck
        Deck mainDeck= new Deck();
    
    //An array list for the winners
    private ArrayList<String> winList = new ArrayList();
    
    //An array list for the eliminated
    private ArrayList<String> deadList = new ArrayList();
    
    
    public BlackJack(){
        super("Blackjack");
    }

    //Used to register players into the game. 
    //Creates a player object and prompts user for ID
    private void register(){
        //Number of players to register
        int numPlayers;
        
        //ID of each player
        String id;
        
        
        Scanner input = new Scanner(System.in);
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
                    
                    //If the player actually registers
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
                            
                            //If it's not unique, then it sets it to repeat the loop again
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
        
    }
    
    //This is used to start a new round. It resets all arraylists.
    private void initialize(){
        winList.removeAll(winList);
        deadList.removeAll(deadList);
        
        //removes all the handCards from a player
        for(int n=0; n<players.size();n++){
            players.get(n).handCards.removeAll(players.get(n).handCards);
        }
        mainDeck.resetCardNum();
        GroupOfCards.shuffle();
    }
    
    //This checks whether each player won or lost
    private void sortPlayers(){
        
        //loop to iterate through every player
        for(int n=0; n<players.size();n++){
            
            //This is for if the player already busted.
            if(players.get(n).getHandInt()==0){
                players.get(n).setBet(0);
                continue;
            }
            
            /*
            *Since you can have more than 21 as a value (because it sends the ACE as 11
            *despite it acting as a 1) this if statement checks the ones that are above 21
            */
            if(players.get(n).getHandInt()>21){
                int winner = Math.max(players.get(n).getHandInt()-31,Dealer.getDealerHandVal()-21);
                
                //If the player tied then it refunds the bet
                if(players.get(n).getHandInt()-31==Dealer.getDealerHandVal()-21){
                    players.get(n).addFunds(players.get(n).getBet());
                    players.get(n).setBet(0);
                }
                
                //If the player won, then it pays out 2 times the value
                else if(winner==players.get(n).getHandInt()-31){
                    players.get(n).addFunds(2*players.get(n).getBet());
                    players.get(n).setBet(0);
                    winList.add(players.get(n).getName());
                }
                
                //This groups any errors together with them losing
                else{
                    players.get(n).setBet(0);
                }
            }
            
            //This is for if the player doesn't have an ACE
            else{
                int winner = Math.max(players.get(n).getHandInt()-21,Dealer.getDealerHandVal()-21);
                
                //If the player tied then it refunds the bet
                if(players.get(n).getHandInt()-21==Dealer.getDealerHandVal()-21){
                    players.get(n).addFunds(players.get(n).getBet());
                    players.get(n).setBet(0);
                }
                
                //If the player won, then it pays out 2 times the value
                else if(winner==players.get(n).getHandInt()-21){
                    players.get(n).addFunds(2*players.get(n).getBet());
                    players.get(n).setBet(0);
                    winList.add(players.get(n).getName());
                }
                
                //This groups any errors together with them losing
                else{
                    players.get(n).setBet(0);
                }
            }
        }
    }
    
//This checks if the player is out at the end of the round. If he is, then it unregisters them
    private void declareDead(){
        
        //Going through every player and checks whether or not they have no money
        //If they don't have money, their name is added to the deadList and they get unregistered
        for (int n=0; n<(players.size());n++){
            if(players.get(n).getBankInt()<1){
                deadList.add(players.get(n).getName());
                players.remove(n);
            }
        }
        if(deadList.isEmpty()){
        }
        else{
            //Declares the people that are eliminated
            System.out.println("The following people were eliminated:");
            for(int n=0; n<deadList.size(); n++){
                System.out.println(deadList.get(n));
            }
        }
    }
    
    //Sees if the player wants to keep going
    private boolean keepPlaying(){
        Scanner input = new Scanner(System.in);
        System.out.println("\n\nPress 0 to continue");
        int contGame = input.nextInt();
        return contGame==0;
    }
    
    @Override
    public void declareWinner() {
        if(winList.isEmpty()){
            System.out.println("No-one won.");
        }
        else{
            System.out.println("Let's take a moment to congralate:");
            for (int n=0; n<winList.size(); n++){
                System.out.println(winList.get(n));
            }
        }
    }
    
    
    @Override
    public void play() {
        //If this is true, then the game keeps going
        boolean startGame = true;
        
        //Creates a new dealer
        Dealer dealer = new Dealer();
        
        //registers players
        register();
        
        //Starts the game
        while (startGame){
            //Initialize resets the game
            initialize();
            //this initialize sets up the dealer
            dealer.initialize();
            
            //This goes through every player's turn to place a bet and then deals the dealer's hand
            for (int n=0; n<(players.size());n++){
                players.get(n).bet();
            }
            
            //This goes through every player's turn
            for (int n=0; n<(players.size());n++){
                players.get(n).play(n);
            }
            dealer.play(1);
            sortPlayers();
            declareWinner();
            declareDead();
            startGame=keepPlaying();
        }
        
        System.out.println("Thanks for playing.");
    }
    
}
