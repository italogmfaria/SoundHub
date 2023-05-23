package application;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        Scanner scanner = new Scanner(System.in);

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
        playlist.exibirMusicas();

        System.out.print("\nDigite o numero correspondente a opcao de ordenacao: " +
                "\n1 - Ordenar por titulo" +
                "\n2 - Ordenar por artista" +
                "\n3 - Ordenar por duracao" +
                "\n0 - Sair" +
                "\nOpcao: ");
        int opcao = scanner.nextInt();

        while (opcao != 0) {
            switch (opcao) {
                case 1:
                    playlist.ordenarPorTitulo();
                    break;
                case 2:
                    playlist.ordenarPorArtista();
                    break;
                case 3:
                    playlist.ordenarPorDuracao();
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }

            System.out.println();
            playlist.exibirMusicas();

            System.out.print("\nDigite o numero correspondente a opcao de ordenacao (ou 0 para sair): ");
            opcao = scanner.nextInt();
        }

        System.out.println("Programa encerrado.");
    }
}