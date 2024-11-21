import java.util.ArrayList;
public class Entrada extends Comodos{
    public Entrada(String nome, ArrayList<Item> itens) {
        super(nome, itens);
        itens.add(new Item("Cabo de madeira","possivelmente de uma vassoura ou de alguma ferramenta"));
        itens.add(new Item("Escada","'talvez possa ser usada para alcançar algo fora do meu alcance '"));



    }
    @Override
    public void descricao() {
        System.out.println("Você está na entrada da casa, na qual tem um jardim chei de plantas e flores no caminho até a porta da casa!");
        System.out.println("Você vê a casa por fora, ele percebe que ela parece abandonada,sem sinal de movimento de gente la dentro");
        System.out.println("No canto perto da porta do lado esquerdo você vê um cabo de madeira e do lado direito uma esacada");
    }



}

