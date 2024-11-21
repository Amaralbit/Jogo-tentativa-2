import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens;

    public Inventario() {
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        System.out.println("Você adicionou o item: " + item.getNome());
    }

    public void removerItem(Item item) {
        if (itens.remove(item)) {
            System.out.println("Você removeu o item: " + item.getNome());
        } else {
            System.out.println("Item não encontrado no inventário: " + item.getNome());
        }
    }

    public boolean possuiItem(String nomeItem) {
        for (Item item : itens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
        } else {
            System.out.println("Itens no inventário:");
            for (Item item : itens) {
                System.out.println("- " + item.getNome());
            }
        }
    }
}
