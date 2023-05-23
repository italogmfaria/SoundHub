package application;

import java.util.*;

public class Playlist {
	private List<Musica> musicas;

    public Playlist() {
        musicas = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        musicas.add(musica);
    }

    public void removerMusica(Musica musica) {
        musicas.remove(musica);
    }

    public void exibirMusicas() {
        if (musicas.isEmpty()) {
            System.out.println("A playlist esta vazia.");
        } else {
            System.out.println("Playlist de Musicas:");
            for (Musica musica : musicas) {
                System.out.println(musica);
            }
        }
    }

    public void ordenarPorTitulo() {
        Collections.sort(musicas, Comparator.comparing(Musica::getTitulo));
    }

    public void ordenarPorArtista() {
        Collections.sort(musicas, Comparator.comparing(Musica::getArtista));
    }

    public void ordenarPorDuracao() {
        Collections.sort(musicas, Comparator.comparingInt(Musica::getDuracao));
    }
}

