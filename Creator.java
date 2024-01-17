import java.util.ArrayList;

public class Creator extends Account{
    

    public Creator(){
        super();
    }

    public Creator(String s, int i){
        super(s, i);
        favorites = new ArrayList<>();
    }

    public Creator(Creator c){
        name = c.getName();
        ID = c.getID();
    }

    public void favorite(Content c){//MAY NEED TO REMOVE FROM ACCOUNT
    }
}