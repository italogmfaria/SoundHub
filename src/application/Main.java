package application;

import java.util.*;

public class Main {
    public static void main(String[] args) {
    	 Playlist playlist = new Playlist();
         try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Quantas musicas voce deseja adicionar a playlist? ");
			 int quantidadeMusicas = scanner.nextInt();
			 scanner.nextLine(); // Consumir a quebra de linha apos a leitura do numero

			 for (int i = 0; i < quantidadeMusicas; i++) {
			     System.out.println("Musica #" + (i + 1));
			     System.out.print("Titulo: ");
			     String titulo = scanner.nextLine();
			     System.out.print("Artista: ");
			     String artista = scanner.nextLine();
			     System.out.print("Duracao (em minutos): ");
			     int duracao = scanner.nextInt();
			     scanner.nextLine(); // Consumir a quebra de linha apos a leitura do numero

			     Musica musica = new Musica(titulo, artista, duracao);
			     playlist.adicionarMusica(musica);
			 }

			 System.out.println();
			 playlist.getMusicas();

			 int opcao = -1;
			 while (opcao != 0) {
			     System.out.println("\nOpcões de Ordenacao:" +
			             "\n1 - Ordenar por titulo" +
			             "\n2 - Ordenar por artista" +
			             "\n3 - Ordenar por duracao" +
			             "\n4 - Remover musica" +
			             "\n0 - Sair");
			     System.out.print("Digite o numero correspondente a opcao desejada: ");
			     opcao = scanner.nextInt();
			     scanner.nextLine(); // Consumir a quebra de linha apos a leitura do numero

			     switch (opcao) {
			         case 1:
			             playlist.ordenarPorTitulo();
			             System.out.println("\nPlaylist ordenada por titulo:");
			             playlist.getMusicas();
			             break;
			         case 2:
			             playlist.ordenarPorArtista();
			             System.out.println("\nPlaylist ordenada por artista:");
			             playlist.getMusicas();
			             break;
			         case 3:
			             playlist.ordenarPorDuracao();
			             System.out.println("\nPlaylist ordenada por duracao:");
			             playlist.getMusicas();
			             break;
			         case 4:
			             System.out.print("\nDigite o numero correspondente a musica que deseja remover: ");
			             int numeroMusica = scanner.nextInt();
			             scanner.nextLine(); // Consumir a quebra de linha apos a leitura do numero

			             playlist.removerMusica(numeroMusica - 1);
			             playlist.getMusicas();
			             break;
			         case 0:
			             System.out.println("\nPrograma encerrado.");
			             break;
			         default:
			             System.out.println("\nOpcao invalida.");
			     }
			 }
		}
     }
 }