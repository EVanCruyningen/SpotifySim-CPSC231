import java.util.ArrayList;

public class Song extends Content implements Comparable<Content>{
    //NEEDS COPY CONSTRUCTOR
    public Song(){
        super();
    }

    public Song(String t, Creator c, int nS){
        super(t, c, nS);
    }

    public Song(Content c){
        super(c.getTitle(), c.getCreator(), c.getNumStreams());
    }

    public String toString(){
        return super.toString() + ".";
    }

    public int compareTo(Content c){
        return super.compareTo(c);
    }
}