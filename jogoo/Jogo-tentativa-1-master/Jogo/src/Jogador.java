import java.util.ArrayList;
import java.util.Scanner;

public class Jogador {
    private ArrayList<Item> inventario;
    private Comodos localAtual;

    public Jogador(Comodos localAtual) {
        this.localAtual = localAtual;
        this.inventario = new ArrayList<>();
    }

    public Comodos getLocalAtual() {
        return localAtual;
    }

    public void pegarItem(Item item) {
        inventario.add(item);
        localAtual.getItens().remove(item);
    }

    public void mostrarInventario() {
        if (inventario.isEmpty()) {
            System.out.println("Seu inventário está vazio.");
        } else {
            System.out.println("Itens no inventário:");
            for (Item item : inventario) {
                System.out.println("- " + item.getNome() + ": " + item.getDescricao());
            }
        }
    }

    public boolean possuiItem(String nomeItem) {
        for (Item item : inventario) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }

    public void mover() {
        Scanner scanner = new Scanner(System.in);
        Comodos norte = localAtual.getNorte();
        Comodos leste = localAtual.getLeste();
        Comodos sul = localAtual.getSul();
        Comodos oeste = localAtual.getOeste();

        System.out.println("\n--- Movimento ---");
        if (norte != null) System.out.println("[1] Ir para o norte: " + norte.getNome());
        if (leste != null) System.out.println("[2] Ir para o leste: " + leste.getNome());
        if (sul != null) System.out.println("[3] Ir para o sul: " + sul.getNome());
        if (oeste != null) System.out.println("[4] Ir para o oeste: " + oeste.getNome());
        System.out.print("Escolha uma direção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Consumir o '\n'

        switch (opcao) {
            case 1:
                if (norte != null) {
                    localAtual = norte;
                    System.out.println("Você se moveu para: " + norte.getNome());
                } else {
                    System.out.println("Não há saída para o norte.");
                }
                break;
            case 2:
                if (leste != null) {
                    localAtual = leste;
                    System.out.println("Você se moveu para: " + leste.getNome());
                } else {
                    System.out.println("Não há saída para o leste.");
                }
                break;
            case 3:
                if (sul != null) {
                    localAtual = sul;
                    System.out.println("Você se moveu para: " + sul.getNome());
                } else {
                    System.out.println("Não há saída para o sul.");
                }
                break;
            case 4:
                if (oeste != null) {
                    localAtual = oeste;
                    System.out.println("Você se moveu para: " + oeste.getNome());
                } else {
                    System.out.println("Não há saída para o oeste.");
                }
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }
}
