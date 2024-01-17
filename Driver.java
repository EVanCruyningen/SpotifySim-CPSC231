import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Driver{
    public static void main(String[] args){    

        String s = "racecar";
        String q = "";
        for(int i = 0; i < (s.length()); i++){
            q = q + s.charAt(s.length() - i - 1);
        }
        System.out.println(q);
        
        //Setup
        /*Album NurseryRhymes = new Album("Nursery Rhymes"); //Generic Nursery Rhymes - creates the album
        Creator nursery = new Creator("Sleep Expert", 000); //singer of the nursery rhymes
        Song Twinkle = new Song("Twinkle Twinkle Little Star", nursery, 1); //Creates the song
        Song bbbs = new Song("Baa Baa Black Sheep", nursery, 2);
        Song JandJ = new Song("Jack and Jill", nursery, 3);
        NurseryRhymes.addContent(Twinkle); //Adds song to album
        NurseryRhymes.addContent(bbbs);
        NurseryRhymes.addContent(JandJ);

        Album mdtf = new Album("My Beautiful Dark Twisted Fantasy"); //My Beautiful Dark Twisted Fantasy - Kanye
        Creator kanye = new Creator("Ye", 001);
        Song df = new Song("Dark Fantasy", kanye, 0);
        Song AOTL = new Song("All Of The Lights", kanye, 0);
        Song runaway = new Song("Runaway", kanye, 0);
        mdtf.addContent(df);
        mdtf.addContent(AOTL);
        mdtf.addContent(runaway);

        Playlist JRP = new Playlist("The Joe Rogan Experience");
        Creator JoeRogan = new Creator("Joe Rogan", 002);
        Podcast episode1 = new Podcast("Meaning of Life", JoeRogan, 0, 1);
        Podcast episode2 = new Podcast("How to make weird shows", JoeRogan, 0, 2);
        Podcast episode3 = new Podcast("I dont want to write this", JoeRogan, 0, 3);
        JRP.addContent(episode1);
        JRP.addContent(episode2);
        JRP.addContent(episode3);

        ArrayList<Holder> listAP = new ArrayList<>(); //list of albums and playlists
        listAP.add(NurseryRhymes); //adds albums and playlists to the list of albums and playlists.
        listAP.add(mdtf);
        listAP.add(JRP);



        //Start of user interaction
        Scanner scnr = new Scanner(System.in);
        Creator userCreator;
        Listener userListener = null;
        Song userSong;
        String uN = "";
        
        
        while(true){
            System.out.println("What would you like to do\n" + "1. Create a Listener Account\n" + "2. List all playlists and their contents\n" + "3. Add songs to an existing playlist\n" +
            "4. Shuffle an existing playlist or listen to an album\n" + "5. Add a song or podcast to favorites\n" + "6. Export your favorite songs to a file\n" + "7. Exit\n");
            String x = scnr.nextLine();
            x.toLowerCase();
            if(x.equals("quit")){
                break;
            } 
            
            
            else if(x.equals("1")){ //Done
                if(!(userListener == null)){
                    System.out.println("User has already been made.");
                    break;
                } 
                System.out.println("What would you like your account name to be?");
                String userName = scnr.nextLine();
                uN = userName;
                userListener = new Listener(userName, 100);
                System.out.println(userListener);

            } 
            
            
            else if(x.equals("2")){ //Done
                for(int i = 0; i < listAP.size(); i++){
                    System.out.println(listAP.get(i));
                }
            } 
            
            
            else if(x.equals("3")){ //DONE
                System.out.println("What is the name of the content you would like to add?");
                String songName = scnr.nextLine();
                System.out.println("Who is this song by?");
                String artistName = scnr.nextLine();
                userCreator = new Creator(artistName, -1);
                userSong = new Song(songName, userCreator, 0);
                System.out.println("What playlist would you like to add it to?");
                String playlistName = scnr.nextLine();
                int index = -1;
                for(int i = 0; i < listAP.size(); i++){
                    if(listAP.get(i).getName().equals(playlistName)){
                        index = i;
                    }
                }

                if(index >= 0){
                    listAP.get(index).addContent(userSong);
                    System.out.println(listAP.get(index));
                } else {
                    System.out.println("Could not find that album. Would you like to make this a new album? Use Y/N for answer.");
                    x = scnr.nextLine();
                    if(x.equals("Y")){
                        Playlist userPlaylist = new Playlist(playlistName);
                        userPlaylist.addContent(userSong);
                        listAP.add(userPlaylist);
                        System.out.println("Successfully made a new playlist: " + userPlaylist);
                    }
                }

            } 
            
            
            else if(x.equals("4")){ //DONE
                System.out.println("Here is a list of albums.");
                for(int i = 0; i < listAP.size(); i++){
                    System.out.println(listAP.get(i).getName());
                }
                System.out.println("favorites");
                System.out.println("Type the playlist you would like to shuffle, or the album you would like to play");
                x = scnr.nextLine(); //NO NEED FOR A CHOICE BC PLAY FUNCTION WORKS AS INTENDED FOR BOTH ALBUM AND PLAYLIST
                int count = 0;
                if(x.equals("favorites")){
                    System.out.println(userListener.getFavorites());
                    count++;
                }
                for(int i = 0; i < listAP.size(); i++){
                    if(listAP.get(i).getName().equals(x)){
                        listAP.get(i).play();
                        count++;
                    }
                }
                if(count == 0){
                    System.out.println("Could not find that playlist.");
                }

            } 
            
            
            else if(x.equals("5")){
                if(userListener == null){
                    System.out.println("Please make an account first.");
                } else{
                    System.out.println("What is the name of the content you would like to add?");
                    String songName = scnr.nextLine();
                    System.out.println("Who is this song by?");
                    String artistName = scnr.nextLine();
                    userCreator = new Creator(artistName, -1);
                    userSong = new Song(songName, userCreator, 0);
                    userListener.favorite(userSong);
                    System.out.println("" + songName + " has been added to favorites.");
                }
            } 
            
            
            
            
            else if(x.equals("6")){//NEED TO EXPORT IN ORDER OF MOST TIMES PLAYED
                System.out.println("What would you like your file to be named?");
                x = scnr.nextLine(); //Getting file name

                try{
                    PrintWriter pw = new PrintWriter(new FileWriter("" + x)); //New Printer
                    pw.println(userListener.getFavorites()); //writes the favorites
                    
                    System.out.println("File Created: Named " + x);
                    System.out.println(userListener.getFavorites()); //prints list of favorites - temp code
                    pw.close(); //closes

                } catch(IOException e){
                    System.out.println("Error."); 
                }
            }

            
            else if(x.equals("7")){ //DONE
                break;
            } 
            
            else{
                System.out.println("Not a valid input.");
            }
            
            System.out.println();//adds an extra space, visually good
        }*/
    }
}