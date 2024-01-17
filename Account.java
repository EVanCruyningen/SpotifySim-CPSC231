import java.util.ArrayList;

abstract class Account{
    protected String name;
    protected int ID;
    protected ArrayList<Content> favorites;

    public abstract void favorite(Content c);

    /*public abstract String getName();
    public abstract int getID();*/

    public Account(){
        name = "null";
        ID = -1;
    }

    public Account(String s, int i){
        name = s;
        ID = i;
    }

    protected String getName(){
        return name;
    }

    protected int getID(){
        return ID;
    }

    public String toString(){
        return "You are " + name + " and your ID is: " + ID + ".";
    }
}