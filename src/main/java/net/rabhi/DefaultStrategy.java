package net.rabhi;

import jdk.jfr.Event;

public class DefaultStrategy implements Strategy{
    @Override
    public void handleNotification(Transaction transaction) {
        System.out.println("Transaction arrived: " + transaction);}

}
