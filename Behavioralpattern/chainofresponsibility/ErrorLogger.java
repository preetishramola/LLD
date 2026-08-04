package Behavioralpattern.chainofresponsibility;

public class ErrorLogger extends Logprocessor {
     public ErrorLogger(int level){
        this.level=level;
    }

    @Override
    protected void write(String message){
        System.out.println("Error: "+ message);
    }
}
