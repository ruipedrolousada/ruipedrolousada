import java.lang.reflect.Array;
import java.util.ArrayList;

public class Stack {
    private ArrayList<String> str;

    public Stack(){
        this.str = new ArrayList<String>();
    }

    public Stack(ArrayList<String> str){
        this();
        this.str.addAll(str);
    }

    public Stack(Stack s){
        this.str = s.getStr();
    }

    public ArrayList<String> getStr() {

        ArrayList<String> ole = new ArrayList<>();

        ole.addAll(this.str);
        return ole;
    }

    public void setStr(ArrayList<String> str) {
        this.str = new ArrayList<>();
        this.str.addAll(str);
    }


    public String top(){

        this.str.get(this.str.size()-1);
    }

    public void push(String s){

        this.str.add(s);
    }

    public void pop(){
        if(this.str.size()!=0){
            this.str.remove(this.str.size()-1);
        }
    }

    public boolean empty(){
        return this.str.isEmpty();
    }

    public int length(){
        return this.str.size();
         }


}
