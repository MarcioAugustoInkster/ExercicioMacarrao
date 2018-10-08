package entra21.java.inicializador;

import entra21.java.classe.Macarrao;
import java.awt.EventQueue;

public class Inicializador {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Macarrao macarrao = new Macarrao();
                macarrao.inicia();
            }
        });
    }
}
