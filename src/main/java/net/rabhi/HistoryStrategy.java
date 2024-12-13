package net.rabhi;

import java.util.ArrayList;
import java.util.List;

public class HistoryStrategy implements Strategy{
    private List<Transaction> history = new ArrayList<>();

    @Override
    public void handleNotification(Transaction transaction) {
        history.add(transaction);
        System.out.println("History updated: " + history);
    }
}
