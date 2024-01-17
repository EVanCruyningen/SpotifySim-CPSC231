import java.util.ArrayList;
import java.util.Random;

public abstract class Holder implements Comparable<Holder>{
    protected ArrayList<Content> listenables;
    protected String name;

    public abstract void play();

    public Content shuffle(){
        Random rand = new Random();
        int randInt = rand.nextInt(listenables.size());
        return listenables.get(randInt);
    }

    public String toString(){
        String s = "";
        for(int i = 0; i < listenables.size(); i++){
            s = s + listenables.get(i) + " ";
        }
        return s;
    }

    public int compareTo(Holder h){
        int listOneSum = 0;
        int listTwoSum = 0;
        for(int i = 0; i < listenables.size(); i++){
            listOneSum = listOneSum + listenables.get(i).getNumStreams();
        }

        for(int i = 0; i < h.listenables.size(); i++){
            listTwoSum = listTwoSum + h.listenables.get(i).getNumStreams();
        }



        if(listOneSum > listTwoSum){
            return 1;
        } else if(listOneSum < listTwoSum){
            return -1;
        } else{
            return 0;
        }    
    }

    public void addContent(Object o){
        if(!(o instanceof Content)){
            System.out.println("Not a piece of content, please only add content to playlists.");
        }else {
            Content s = (Content) o;
            listenables.add(s);
        }
    }

    public String getName(){
        return name;
    }
} 