package Behavioralpattern.chainofresponsibility;

public class FatalLogger extends Logprocessor {
     public FatalLogger(int level){
        this.level=level;
    }

    @Override
    protected void write(String message){
        System.out.println("FATAL: "+ message);
    }
}
