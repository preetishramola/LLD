package Behavioralpattern.chainofresponsibility;

public class InfoLogger extends Logprocessor {
     public InfoLogger(int level){
        this.level=level;
    }

    @Override
    protected void write(String message){
        System.out.println("INFO: "+ message);
    }
}
