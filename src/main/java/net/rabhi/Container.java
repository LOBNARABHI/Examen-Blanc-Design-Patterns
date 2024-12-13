package net.rabhi;

import java.util.HashMap;
import java.util.Map;

public class Container {
    private static Container instance;
    private Map<String, Agent> agents = new HashMap<>();


    private Container() {}

    public static Container getInstance() {
        if (instance == null) {
            instance = new Container();
        }
        return instance;
    }

    public void addAgent(String name, Agent agent) {
        agents.put(name, agent);
    }

    public Agent getAgent(String name) {
        return agents.get(name);
    }

    public void removeAgent(String name) {
        agents.remove(name);
    }

    public void afficherEtat(HDMI hdmi) {
        hdmi.afficher("Container: " + agents);
    }
}

interface HDMI {
    void afficher(String message);
}

class VGA {
    public void display(String message) {
        System.out.println("VGA Display: " + message);
    }
}

class VGAtoHDMIAdapter implements HDMI {
    private VGA vga;

    public VGAtoHDMIAdapter(VGA vga) {
        this.vga = vga;
    }

    public void afficher(String message) {
        vga.display(message);
    }
}
