import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Criação dos cômodos
        ArrayList<Item> entradaItens = new ArrayList<>();
        Entrada entrada = new Entrada("Entrada", entradaItens);

        ArrayList<Item> cozinhaItens = new ArrayList<>();
        Cozinha cozinha = new Cozinha("Cozinha", cozinhaItens);

        ArrayList<Item> salaItens = new ArrayList<>();
        Sala sala = new Sala("Sala", salaItens);

        ArrayList<Item> poraoItens = new ArrayList<>();
        Porao porao = new Porao("Porão", poraoItens);

        ArrayList<Item> ultimoAndarItens = new ArrayList<>();
        Ultimoandar ultimoAndar = new Ultimoandar("Último Andar", ultimoAndarItens);

        // Conectar os cômodos
        entrada.setSaidas(null, sala, cozinha, null); // Norte, Leste, Sul, Oeste
        sala.setSaidas(entrada, null, null, null);
        cozinha.setSaidas(null, null, porao, entrada);
        porao.setSaidas(cozinha, null, ultimoAndar, null);
        ultimoAndar.setSaidas(porao, null, null, null);

        // Criar o jogador
        Jogador jogador = new Jogador(entrada);

        // Loop do jogo
        boolean jogando = true;
        while (jogando) {
            System.out.println("\n--- Menu ---");
            System.out.println("Você está no " + jogador.getLocalAtual().getNome());
            System.out.println("[1] Ver descrição do cômodo");
            System.out.println("[2] Pegar item");
            System.out.println("[3] Mover para outro cômodo");
            System.out.println("[4] Ver inventário");
            System.out.println("[5] Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir o '\n'

            switch (opcao) {
                case 1:
                    jogador.getLocalAtual().descricao();
                    break;

                case 2:
                    if (jogador.getLocalAtual() instanceof Entrada) {
                        System.out.println("[1] Pegar cabo de madeira");
                        System.out.println("[2] Pegar escada");
                        System.out.print("Escolha uma opção: ");
                        int entradaOpcao = scanner.nextInt();
                        scanner.nextLine();
                        if (entradaOpcao == 1) {
                            pegarItem(jogador, "Cabo de madeira");
                        } else if (entradaOpcao == 2) {
                            pegarItem(jogador, "Escada");
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    } else if (jogador.getLocalAtual() instanceof Cozinha) {
                        System.out.println("[1] Pegar item na geladeira (Bilhete)");
                        System.out.println("[2] Pegar item no armário de baixo (Cabeça da pá)");
                        System.out.println("[3] Pegar item no armário alto (Cachaça)");
                        System.out.print("Escolha uma opção: ");
                        int cozinhaOpcao = scanner.nextInt();
                        scanner.nextLine();
                        if (cozinhaOpcao == 1) {
                            pegarItem(jogador, "Bilhete");
                        } else if (cozinhaOpcao == 2) {
                            pegarItem(jogador, "Cabeça da pá");
                        } else if (cozinhaOpcao == 3) {
                            if (jogador.possuiItem("Escada")) {
                                pegarItem(jogador, "Cachaça");
                            } else {
                                System.out.println("Você precisa de uma escada para alcançar o armário alto!");
                            }
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    } else if (jogador.getLocalAtual() instanceof Sala) {
                        System.out.println("[1] Pegar caneta");
                        System.out.println("[2] Pegar bloco de notas");
                        System.out.print("Escolha uma opção: ");
                        int salaOpcao = scanner.nextInt();
                        scanner.nextLine();
                        if (salaOpcao == 1) {
                            pegarItem(jogador, "Caneta");
                        } else if (salaOpcao == 2) {
                            pegarItem(jogador, "Bloco de notas");
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    } else if (jogador.getLocalAtual() instanceof Porao) {
                        System.out.println("[1] Falar com o idoso");
                        System.out.print("Escolha uma opção: ");
                        int poraoOpcao = scanner.nextInt();
                        scanner.nextLine();
                        if (poraoOpcao == 1) {
                            if (jogador.possuiItem("Cachaça")) {
                                ((Porao) jogador.getLocalAtual()).falarComIdoso(jogador);
                            } else {
                                System.out.println("O idoso não quer falar com você sem algo para beber.");
                            }
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    } else if (jogador.getLocalAtual() instanceof Ultimoandar) {
                        System.out.println("[1] Entrar na porta");
                        System.out.print("Escolha uma opção: ");
                        int ultimoAndarOpcao = scanner.nextInt();
                        scanner.nextLine();
                        if (ultimoAndarOpcao == 1) {
                            ((Ultimoandar) jogador.getLocalAtual()).entrarNaPorta(jogador);
                            jogando = false; // Fim do jogo
                        } else {
                            System.out.println("Opção inválida!");
                        }
                    }
                    break;

                case 3:
                    jogador.mover();
                    break;

                case 4:
                    jogador.mostrarInventario();
                    break;

                case 5:
                    jogando = false;
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        System.out.println("Obrigado por jogar!");
    }

    private static void pegarItem(Jogador jogador, String nomeItem) {
        Item item = buscarItemNoComodo(jogador.getLocalAtual(), nomeItem);
        if (item != null) {
            jogador.pegarItem(item);
            System.out.println("Você pegou o item: " + item.getNome());
        } else {
            System.out.println("Esse item não está no cômodo.");
        }
    }

    private static Item buscarItemNoComodo(Comodos comodo, String nomeItem) {
        for (Item item : comodo.getItens()) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return item;
            }
        }
        return null;
    }
}
