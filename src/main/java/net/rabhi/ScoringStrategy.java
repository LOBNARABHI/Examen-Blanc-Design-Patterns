package net.rabhi;

import jdk.jfr.Event;

public class ScoringStrategy implements Strategy{
    private double score = 0;


    @Override
    public void handleNotification(Transaction transaction) {
        if (transaction.getType().equals(Type.VENTE)) {
            score += transaction.getMontant();
        } else {
            score -= transaction.getMontant();
        }

    }
}
