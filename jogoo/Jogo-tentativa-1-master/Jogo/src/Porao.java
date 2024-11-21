import java.util.ArrayList;
import java.util.Scanner;
public class Porao extends Comodos{
    Scanner scanner = new Scanner(System.in);
    int opcao;
    public Porao(String nome, ArrayList<Item> itens) {
        super(nome, itens);
    }

    @Override
        public void descricao() {
            System.out.println("Ao descer ao porão você vê um lugar que ainda parece ser habitado pois esta relativamente mais organizado doque os outros comodos");
            System.out.println("Ao olhar mais atentamente você vê um idoso sentado em uma cadera");
        }
        public void falarComIdoso(Jogador jogador){
            if(jogador.possuiItem("cachaça")){
                System.out.println("-Idoso: Olâ meu jovem, vejo que pela sua aparenceia veio aqui em busca de encontrar a passagem para a terra mistica de narnia,estou certo?");
                System.out.println("-Você: Sim você está correto, mas antes deixe-me perguntar :");
                do {
                    System.out.println("Escolha a pergunta digitando o numero nela: ");
                    System.out.println("[1]Como você veio parar aqui?");
                    System.out.println("[2]Como chego em narnia?");
                    System.out.println("[3]É serio que tive que te arranjar uma cachaça pra tu falar comigo vei gagá?");
                    System.out.println("[4]Sair");
                    System.out.println("Responda: ");
                    opcao = scanner.nextInt();
                    switch (opcao) {
                        case 1:
                            System.out.println("Eu sempre estive aqui desde que o rei de narnia me mando ficar para vigiar o portal");
                            break;
                        case 2:
                            System.out.println("Que saco!Bem já que você me parece uma pessoa de bem e me fez o favor de me dar a cachaça então vou lhe dizer");
                            System.out.println("Atras de mim tem uma escada para um andar ainda mais abaixo que chamo de Ultimo andar, qo descer você ira ver uma porta trancada com muitas tabuas");
                            System.out.println("ou seja você ira precisar de alguma ferramente de metal para quebra-las.");
                            System.out.println("Apos entrar pela porta você vera uma mala antiga, pulando na mala você entrará em narnia");
                            break;
                        case 3:
                            System.out.println("Você tem noção do quanto tempo eu não bebo nada alcoólico?!?!Mais de 100 ANOS!!");
                            System.out.println("desde quando Aslan me pediu para ficar de vigia nessa espelunca para impedir pessoas más de irem à narnia");
                            break;
                        case 4:
                            System.out.println("Você escolheu sair da conversa");
                            break;
                        default:
                            System.out.println("Opção inválida!");
                            break;
                    }
                }while(opcao !=4);
            }else{
                System.out.println("Não fale comigo jovem, estou de mal humor hoje!!");
            }
        }
    }


