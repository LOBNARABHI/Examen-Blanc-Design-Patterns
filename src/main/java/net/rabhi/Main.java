package net.rabhi;


import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Créer des agents
        Agent agent1 = new Agent();
        agent1.nom = "Agent1";
        agent1.transactions = new ArrayList<>();
        agent1.agents = new ArrayList<>();

        Agent agent2 = new Agent();
        agent2.nom = "Agent2";
        agent2.transactions = new ArrayList<>();
        agent2.agents = new ArrayList<>();

        // Souscription (Agent2 observe Agent1)
        agent1.Souscription(agent2);

        // Définir des stratégies pour les agents
        agent1.setStrategy(new ScoringStrategy());
        agent2.setStrategy(new HistoryStrategy());

        // Créer des transactions avec le Builder
        Transaction transaction1 = new Transaction.Builder()
                .setId("T001")
                .setDate("2024-12-13")
                .setMontant(1000.0)
                .setType("VENTE")
                .build();

        Transaction transaction2 = new Transaction.Builder()
                .setId("T002")
                .setDate("2024-12-14")
                .setMontant(500.0)
                .setType("ACHAT")
                .build();

        // Ajouter des transactions et notifier les observateurs
        System.out.println("Ajout de transaction à Agent1:");
        agent1.addTransaction(transaction1);

        System.out.println("\nAjout de transaction à Agent1:");
        agent1.addTransaction(transaction2);

        // Vérifier les notifications et le traitement via les stratégies
        System.out.println("\nAgent1 transactions:");
        for (Transaction t : agent1.transactions) {
            System.out.println(t);
        }

        System.out.println("\nAgent2 réactions aux notifications:");
        agent2.strategy.handleNotification(transaction1);
        agent2.strategy.handleNotification(transaction2);
    }
}
