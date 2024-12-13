package net.rabhi;

import java.util.List;
import java.util.Observable;

public class Agent implements ObservableAgent, ObserverAgent{
    public String nom;
    public List<Transaction> transactions;
    public List<ObserverAgent> agents;
    public Strategy strategy = (Strategy) new DefaultStrategy();

    @Override
    public void Souscription(Agent agent) {
        agents.add(agent);
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
        for (ObserverAgent agent : agents) {
            agent.update(agent,transaction);
        }
    }



    @Override
    public void update(ObserverAgent agent, Transaction transaction) {
        System.out.println("Le nom d'agent est  : "+this.nom);
        System.out.println("Transaction : " + "ID :" + transaction.getId()
                + "/Date : " + transaction.getDate() +"/Montant : " + transaction.getMontant() +"/Type : "+ transaction.getType());

    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
