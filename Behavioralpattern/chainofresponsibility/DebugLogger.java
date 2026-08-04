package Behavioralpattern.chainofresponsibility;

public class DebugLogger extends Logprocessor{

    public DebugLogger(int level){
        this.level=level;
    }

    @Override
    protected void write(String message){
        System.out.println("DEBUG: "+ message);
    }
}
