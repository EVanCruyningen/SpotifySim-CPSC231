import java.util.ArrayList;

public class Album extends Holder implements Comparable{
    
    public Album(){
        listenables = new ArrayList<Content>();
    }

    public Album(String n){
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

    public void play(){
        for(int i = 0; i < listenables.size(); i++){
            System.out.println(listenables.get(i).play()); //idk if correct implementation, but works
        }
    }
    
    //apparently albums dont get the privelege of adding songs
    public void addContent(Object o){
        if(!(o instanceof Song)){
            System.out.println("Not a song, please only add songs to albums.");
        }else {
            Song s = (Song) o;
            super.addContent(s);
        }
    }

    public String toString(){
        return "This is whats in " + name + ": "  + super.toString();
    }

    
}
