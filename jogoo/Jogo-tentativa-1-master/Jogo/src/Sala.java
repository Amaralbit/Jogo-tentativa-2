import java.util.ArrayList;

public class Sala extends Comodos{
    @Override
    public void descricao() {
        System.out.println("Você vê uma sala de estar, você sente um cheiro de mofo, no meio há um sofa ragado cheio de poeria");
        System.out.println("proximo a parede há uma lareira e em cima da lareira há oq parece ser uma caneta ");
        System.out.println("no meio proximo ao sofa há uma mesinha e em cima dessa mesa há um bloco de notas");
    }

    public Sala(String nome, ArrayList<Item> itens) {
        super(nome, itens);
        itens.add(new Item("Caneta","pelo tubo ela parece ter tinta, e por algum motivo ela não parece ser velha, mas sim muito parecida com os modelos que tem no mercado atualmente"));
        itens.add(new Item("Bloco de notas","Bloco de notas branco,aparentemente so a primeira folhas esta em um estado ruim, as outras estão em um bom estado"));
    }

}
