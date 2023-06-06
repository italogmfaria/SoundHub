package application;

import java.util.Arrays;

public class Playlist {
    private Musica[] musicas;
    private int tamanho;

    public Playlist() {
        musicas = new Musica[10]; // Tamanho inicial do vetor
        tamanho = 0;
    }

    public void adicionarMusica(Musica musica) {
        if (tamanho == musicas.length) {
            expandirCapacidade();
        }

        musicas[tamanho] = musica;
        tamanho++;
    }

    public void removerMusica(int indice) {
        if (indice >= 0 && indice < tamanho) {
            for (int i = indice; i < tamanho - 1; i++) {
                musicas[i] = musicas[i + 1];
            }
            musicas[tamanho - 1] = null;
            tamanho--;
            System.out.println("Música removida da playlist.");
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public Musica[] getMusicas() {
        return Arrays.copyOf(musicas, tamanho);
    }

    public void ordenarPorTitulo() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (musicas[j].getTitulo().compareTo(musicas[j + 1].getTitulo()) > 0) {
                    Musica temp = musicas[j];
                    musicas[j] = musicas[j + 1];
                    musicas[j + 1] = temp;
                }
            }
        }
    }

    public void ordenarPorDuracao() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (musicas[j].getDuracao() > musicas[j + 1].getDuracao()) {
                    Musica temp = musicas[j];
                    musicas[j] = musicas[j + 1];
                    musicas[j + 1] = temp;
                }
            }
        }
    }

    public void ordenarPorArtista() {
        for (int i = 0; i < tamanho - 1; i++) {
            for (int j = 0; j < tamanho - 1 - i; j++) {
                if (musicas[j].getArtista().compareTo(musicas[j + 1].getArtista()) > 0) {
                    Musica temp = musicas[j];
                    musicas[j] = musicas[j + 1];
                    musicas[j + 1] = temp;
                }
            }
        }
    }

    private void expandirCapacidade() {
        int novaCapacidade = musicas.length * 2;
        Musica[] novoArray = new Musica[novaCapacidade];
        for (int i = 0; i < tamanho; i++) {
            novoArray[i] = musicas[i];
        }
        musicas = novoArray;
    }
}
