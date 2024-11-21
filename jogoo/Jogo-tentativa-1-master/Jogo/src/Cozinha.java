import java.util.ArrayList;

public class Cozinha extends Comodos {

    @Override
    public void descricao() {
        System.out.println("Você vê uma cozinha que comparado com o restante da casa está em um bom estado, nela tem uma geladeira com a parte de baixo aberta e o freezer fechado");
        System.out.println("Você vê um fogão, uma bancada que tem um armário embaixo dela, e um armário que fica em cima da fogão mas está muito alto para alcançar");
    }

    public Cozinha(String nome, ArrayList<Item> itens) {
        super(nome, itens);
        itens.add(new Item("Cachaça", "Uma cachaça da braba"));
        itens.add(new Item("Bilhete", "Está escrito:'Onde há uma tábua solta, lá também estará a pessoa que lhe ajudará se você tiver algo que ela deseje'"));
        itens.add(new Item("Cabeça da pá", "Parte de metal da pá, está bem afiada para uma pá, mas está faltando o cabo"));
    }

    public void abrirArmarioDeBaixo() {
        System.out.println("Você vê a parte de metal de uma pá (cabeça da pá)");
    }

    public void abrirGeladeria() {
        System.out.println("Você vê um bilhete");
    }

    public void abrirArmarioAlto(Jogador jogador) {
        if (jogador.possuiItem("Escada")) {
            System.out.println("Você usa a escada para alcançar o armário alto e encontra uma cachaça.");

        } else {
            System.out.println("O armário está muito alto para alcançar. Você precisa de uma escada.");
        }
    }
}
