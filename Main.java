//importa  a classe ArrayList, que permite criar listas que podem aumentar de tamanho a import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Scanner;

//Classe principal do programa
//O nome da classe precisa ser igual ao nome do arquivo: Main.java
public class Main {

  //Método principal do java 
  //É aqui que o programa começa a ser executado
  public static void main(String[] args) {

    //Criar um objeto Scanner para ler o que o usuário digiatr no teclado
    Scanner scanner = new Scanner(System.in);
  
    //Cria uma lista para armazenar os nomes das taferas 
    //String significa que essa lista vai armazenar textos
    ArrayList<String> tarefas = new ArrayList<>();

    //Cria outra lista para armazenar o status das tarefas
    //Boolean pode receber apenas dois valores:
    //true = verdadeiro
    //false = falso
    ArrayList<Boolean> concluidas = new ArrayList<>();

    //Cria uma variável para armazenar a opção escolhida no menu 
    int opcao;
    
    // O do-While execute o código pelo menos uma vez
    // e contnua repetindo enquanto a opção for diferente de 0
    do {

      //Exibe o título do programa 
      System.out.println("\n=== GERENCIADOR DE TAREFAS ===");

      // Exibe as opções disponíveis para o usuário
      System.out.println("1 - Adicionar tarefa");
      System.out.println("2 - Listar tarefas");
      System.out.println("3 - Concluir tarefa");
      System.out.println("0 - Sair");

      //pede para o usuário escolher uma opção
      System.out.print("Escolha uma opção:");

      // Verifica se o usuário digitou um número inteiro
      // isso evita que programa dê erro caso ele digite uma letra 
      while (!scanner.hasNextInt()) {

        //Mostra uma mensagem de erro 
        System.out.println("Digite um número válido.");

        //Descarta o valor inválido digitado
        scanner.next();

        //pede novemente uma opção
        System.out.print("Escolha uma opção: ");

      }

      // Lê o número digitado pelo usuário
      opcao = scanner.nextInt();

      // Limpa o ERTER  que ficou no scanner
      scanner.nextLine();


      // O switch verifica qual opção o usuário escolheu
      switch (opcao) {


        //====================================================
        //OPÇÃO 1 - ADICIONAR TAREFA 
        //====================================================
        case 1:

             //Pede para o usuário digitar uma tarefa 
             System.out.print("Digite a tarefa: ");
             
             // Lê o texto digitado pelo usuário
             String tarefa = scanner.nextLine();

             // Verifica se o usuário deixou a tarefa vazia
             // isBlank() verifica se o texto está vazio ou contém apenas espaços
             if (tarefa.isBlank()) {

                //mostra uma mensagem informando que a tarefa é inválida
                System.out.println("A tarefa não pode ficar vazia.");

             } else {

               // Adiciona a tarefa dentro da lista de tarefa 
               tarefas.add(tarefa);
               
               // Adiciona false na lista de status 
               // Isso significa que nova tarefa começa como pendente
               concluidas.add(false);

               // Informe que a tarefa foi cadastrada
               System.out.println("Tarefa adicionada com sucesso!");
             }
             
             // Encerra esse case 
             break;
        
        // ====================================================
        // OPÇÃO 2 - LISTAR TAREFAS
        // ====================================================
        case 2:

            // Verificar se a lista de tarefas está vazia 
            if (tarefas.isEmpty()) {

              // Imforma que ainda não existem tarefas
              System.out.println("Nenhuma tarefa cadastrada.");

            } else{

               // Exibe um título
               System.out.println("\n--- SUAS TAREFAS ---");

               //Percorre todas as tarefas da lista
               //
               // int i = 0
               // Começa pela posição 0
               //
               //i < tarefas.size()
               // Continua enquanto i for maior que a quantidade de tarefas
               //
               // i++
               // Aumenta 1 na variável i a cada repetição
               for (int i = 0; i < tarefas.size(); i++) {

                //Verificar se a tarefa está concluída
                //
                //se for true:
                //   [Concluída]
                //
                //se for false:
                //   [Pendente]
                String status = concluidas.get(i)
                       ? "[Concluída]"
                       : "[Pendente]";
               
                // exibe a tarefa na tela 
                //
                //i + 1:
                // Mostar o número da tarefa começando em 1
                //
                // tarefas.get(i):
                //Pega um texto da tarefa
                //
                //status:
                // Mostra se ela está concluída ou pendente
                System.out.println(
                    (i + 1) + " - " + status
                    + "" + tarefas.get(i)
                );

                  }

              }
            
              // Encerra esse case 
              break;
        

        //=====================================================
        // OPÇÃO 3 - CONCLUIR TAREFA 
        //=====================================================
        case 3:

             // Verifica se não existem tarefas cadastradas 
             if (tarefas.isEmpty()) {
               
               // Mostra uma mensagem para o usuário
               System.out.println("Não há tarefas para concluir.");

               // Encerra esse case 
               break;

             }
             

             // Pede o número da tarefa que será concluída
             System.out.println("Digite o número da tarefa: ");

             // Verifica se o usuário digitou um número
             while (!scanner.hasNextInt()) {
                  
                // Informa que a entrada é inválida
                System.out.println("Digite um número válido.");

                // Remove o valor inválido
                scanner.next();

                // Pede novamente o número
                System.out.println("Digite o número da tarefa: ");
                
             }
            

             // guarda o número digitado pelo usuário
             int numero = scanner.nextInt();

             // Limpa o  ENTER que ficou no Scanner
             scanner.nextLine();


             // Verifica se o número informado corresponde
             // a uma terefa existente
             //
             // numero <= tarefa.size()
             // Onúmero não pode ser maior que a quantidadde de tarefas 
             if (numero >= 1 && numero <= tarefas.size()) {

                  // Altera o status da tarefa para true
                  // true significa que a tarefda para true 
                  //
                  // Como a lista começa na posição 0,
                  // usamos numero - 1 
                  //
                  // Exemplo:
                  // tarefa 1 -> posição 0 
                  // tarefa 2 -> posição 1
                  // tarefa 3 -> posição 2
                  concluidas.set(numero - 1, true);


                  // Informa que a tarefa foi concluída
                  System.out.println("Tarefa concluída!");

             } else {

                //Caso o número não exista
                System.out.println("Número de tarefa inválido.");

             }

             // Encerra esse case
             break;


        // =================================================
        // OPÇÃO 0 - SAIR 
        // =================================================
        case 0:
            
             // Mostra uma mensagem antes de encerrar
             System.out.println("Programa encerrado. Até mais!");

             // Encerra esse case
             break;
        
             
        // =================================================
        // QUALQUER OUTRA OPÇÃO
        // =================================================
        default:

             // Se o usuário digitar algo como 5, 8 ou 10,
             // essa mensagem será exibida
             System.out.println("opção inválida. Tente novamente.");

      }
    

    // Continua mostrando o menu enquanto o usuário
    // não escolher a opção 0
    } while (opcao != 0);

    // Fecha o Scanner quando o programa termina
    // Isso libera o recurso utilizado para ler o teclado
    scanner.close(); 
  
  }
}