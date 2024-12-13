package net.rabhi;

import java.util.Date;

public class Transaction {
    private String id ;
    private String date;
    private double montant;
    private Type type;


    private Transaction(Builder builder) {
        this.id = builder.id;
        this.date = builder.date;
        this.montant = builder.montant;
        this.type = Type.valueOf(builder.type);
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public Type getType() {
        return type;
    }

    public static class Builder {
        private String id;
        private String date;
        private double montant;
        private String type;

        public Builder setId(String id) {
            this.id = id;
            return this;
        }

        public Builder setDate(String date) {
            this.date = date;
            return this;
        }

        public Builder setMontant(double montant) {
            this.montant = montant;
            return this;
        }

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }
}
