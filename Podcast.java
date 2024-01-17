import java.util.ArrayList;

/*
 * protected String title;
    protected Creator artist; //questionable
    protected int numStreams;
 */

public class Podcast extends Content implements Comparable<Content>{
    //NEEDS COPY CONSTRUCTOR
    private int episodeNumber;

    public Podcast(){
        super();
    }

    public Podcast(String t, Creator c, int nS, int epNum){
        super(t, c, nS);
        episodeNumber = epNum - 1;
    }

    public Podcast(Content c){
        super(c.getTitle(), c.getCreator(), c.getNumStreams()); 
        Podcast p = (Podcast) c;
        int episodeNumber = p.getEpisodeNum();
    }

    public String toString(){
        return "Episdode " + episodeNumber + ": " + super.toString();
    }

    public int compareTo(Content c){
        return super.compareTo(c);
    }

    public int getEpisodeNum(){
        return episodeNumber;
    }

    /*public Podcast(Podcast p){
        title = p.getTitle();
        artist = new Creator(p.getCreator());
        numStreams = p.getNumStreams();
    }*/
}