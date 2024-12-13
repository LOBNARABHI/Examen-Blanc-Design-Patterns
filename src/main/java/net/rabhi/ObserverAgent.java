package net.rabhi;

import java.util.Observable;

public interface ObserverAgent {
    public void update(ObserverAgent agent, Transaction transaction);
}
