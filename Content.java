import java.util.ArrayList;

public abstract class Content implements Comparable<Content>{
    protected String title;
    protected Creator artist; //questionable
    protected int numStreams;

    public Content(){
        title = "null";
        artist = new Creator();
        numStreams = -1;
    }

    public Content(String t, Creator c, int nS){
        title = t;
        artist = new Creator(c);
        numStreams = nS;
    }

    public String play(){
        numStreams++;
        return "You are now playing: " + title + " by " + artist.getName();    
    }
    
    public String getTitle(){
        return title;
    }

    public Creator getCreator(){
        return artist;
    }

    public int getNumStreams(){
        return numStreams;
    }
    
    public String toString(){
        numStreams++;
        return "" + title + " by " + artist.getName(); // + " and has " + numStreams + " streams";
    }

    
    public int compareTo(Content c){
        if(numStreams > c.numStreams){
            return 1;
        } else if(numStreams < c.numStreams){
            return -1;
        } else {
            return 0;
        }
    }

}