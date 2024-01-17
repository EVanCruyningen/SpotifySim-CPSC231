import java.util.ArrayList;

public class Playlist extends Holder implements Comparable{

    public Playlist(){
        listenables = new ArrayList<Content>();
    }

    public Playlist(String n){
        name = n;
        listenables = new ArrayList<Content>();
    }

    public int compareTo(Object o){
        if(!(o instanceof Holder)){
            return -10;
        }
        Holder h = (Holder) o;
        return super.compareTo(h);
    }
    
    public void addContent(Object o){
        super.addContent(o);
    }

    public void removeContent(Object o){
        if(!(o instanceof Content)){
            System.out.println("Not a piece of content, please only remove content to playlists.");
        }else {
            Content s = (Content) o;
            listenables.remove(listenables.indexOf(s));
        }
    }

    public void play(){
        //Need to shuffle and go through entire album while not picking same shuffled song
        ArrayList<Content> discard = new ArrayList<Content>();
        Content c;
        for(int i = listenables.size(); i > 0; i--){
            c = shuffle();
            System.out.println(c.play());
            discard.add(listenables.remove(listenables.indexOf(c)));
        }

        for(int i = 0; i < discard.size(); i++){
            listenables.add(discard.remove(i));
        }
    }

    public String toString(){
        return "This is whats in " + name + ": "  + super.toString();
    }

}