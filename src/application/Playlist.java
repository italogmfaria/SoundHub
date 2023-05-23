package application;

import java.util.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Playlist {
	   private List<Musica> musicas;

	    public Playlist() {
	        musicas = new ArrayList<>();
	    }

	    public void adicionarMusica(Musica musica) {
	        musicas.add(musica);
	    }

	    public void removerMusica(int indice) {
	        if (indice >= 0 && indice < musicas.size()) {
	            musicas.remove(indice);
	            JOptionPane.showMessageDialog(null, "Música removida da playlist.");
	        } else {
	            JOptionPane.showMessageDialog(null, "Índice inválido.", "Erro", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    public List<Musica> getMusicas() {
	        return musicas;
	    }

	    public void ordenarPorTitulo() {
	        int n = musicas.size();
	        int h = 1;

	        while (h < n / 3) {
	            h = 3 * h + 1;
	        }

	        while (h >= 1) {
	            for (int i = h; i < n; i++) {
	                Musica musica = musicas.get(i);
	                int j = i;
	                while (j >= h && musicas.get(j - h).getTitulo().compareTo(musica.getTitulo()) > 0) {
	                    musicas.set(j, musicas.get(j - h));
	                    j -= h;
	                }
	                musicas.set(j, musica);
	            }
	            h /= 3;
	        }
	    }

	    public void ordenarPorDuracao() {
	        int n = musicas.size();
	        int h = 1;

	        while (h < n / 3) {
	            h = 3 * h + 1;
	        }

	        while (h >= 1) {
	            for (int i = h; i < n; i++) {
	                Musica musica = musicas.get(i);
	                int j = i;
	                while (j >= h && musicas.get(j - h).getDuracao() > musica.getDuracao()) {
	                    musicas.set(j, musicas.get(j - h));
	                    j -= h;
	                }
	                musicas.set(j, musica);
	            }
	            h /= 3;
	        }
	    }

	    public void ordenarPorArtista() {
	        int n = musicas.size();
	        int h = 1;

	        while (h < n / 3) {
	            h = 3 * h + 1;
	        }

	        while (h >= 1) {
	            for (int i = h; i < n; i++) {
	                Musica musica = musicas.get(i);
	                int j = i;
	                while (j >= h && musicas.get(j - h).getArtista().compareTo(musica.getArtista()) > 0) {
	                    musicas.set(j, musicas.get(j - h));
	                    j -= h;
	                }
	                musicas.set(j, musica);
	            }
	            h /= 3;
	        }
	    }

	    // utilizado na class Main sem GUI
	    public void ordenar(Comparator<Musica> comparador) {
	        Collections.sort(musicas, comparador);
	    }
	}

 


  

