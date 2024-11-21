import java.util.ArrayList;

public class Ultimoandar extends Comodos {
    public Ultimoandar(String nome, ArrayList<Item> itens) {
        super(nome, itens);
    }

    @Override
    public void descricao() {
        System.out.println("Você desce ao ultimo andar e vê igual o velho falou, uma porta fechado com tabuas de madeira");
    }

    public void entrarNaPorta(Jogador jogador) {
        if (jogador.possuiItem("Cabeça da pá") && jogador.possuiItem("Cabo de madeira")) {
            System.out.println("Você entra pela porta e vê uma mala grande aberta no chão, e dela sai uma luz muito forte");
            System.out.println("Você entra na mala e.........");
            System.out.println("FIM");
        }else{
            System.out.println("Não é possivel quebrar essas tabuas com os itens que eu tenho no momento");
        }
    }
}
