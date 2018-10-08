package entra21.java.bean;

public class MacarraoBean {
    private int id;
    private String marca, tipo;
    private boolean aldente;
    private double peso;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isAldente() {
        return aldente;
    }

    public void setAldente(boolean aldente) {
        this.aldente = aldente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
}
