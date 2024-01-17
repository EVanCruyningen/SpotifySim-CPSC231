import java.util.ArrayList;
import java.util.Collections;

public class Listener extends Account{
    
    private ArrayList<Content> favoritesSort = new ArrayList<>();

    public Listener(){
        super();
    }

    public Listener(String s, int i){
        super(s, i);
        favorites = new ArrayList<>();
    }

    public void favorite(Content c){
        if((c instanceof Song) || (c instanceof Podcast)){
            favorites.add(c);
        } else{
            System.out.println("Not able to add to favorites");
        }
    }

    public String getFavorites(){
        if(favorites.size() == 0){
            return "No songs in favorites.";
        }
        String s = "Your favorites are: \n";

        Collections.sort(favorites);

        for(int i = 0; i < favorites.size(); i++){
            s = s + favorites.get(i) + "\n";
        }
        return s;
    }

    public int getFavoritesSize(){
        return favorites.size();
    }
}