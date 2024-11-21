import java.util.ArrayList;

public abstract class Comodos {
    private String nome;
    private ArrayList<Item> itens;
    private Comodos norte;
    private Comodos leste;
    private Comodos sul;
    private Comodos oeste;

    public Comodos(String nome, ArrayList<Item> itens) {
        this.nome = nome;
        this.itens = itens;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }

    public void setSaidas(Comodos norte, Comodos leste, Comodos sul, Comodos oeste) {
        this.norte = norte;
        this.leste = leste;
        this.sul = sul;
        this.oeste = oeste;
    }

    public Comodos getNorte() {
        return norte;
    }

    public Comodos getLeste() {
        return leste;
    }

    public Comodos getSul() {
        return sul;
    }

    public Comodos getOeste() {
        return oeste;
    }

    public abstract void descricao();
}
