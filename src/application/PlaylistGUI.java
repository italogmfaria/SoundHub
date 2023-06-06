package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class PlaylistGUI extends JFrame {
	  /**
	 * itinho and brenis
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Playlist playlist;
	    private DefaultListModel<Musica> listModel;
	    private JList<Musica> listaMusicas;

	    public PlaylistGUI() {
	    	setIconImage(Toolkit.getDefaultToolkit().getImage(PlaylistGUI.class.getResource("/application/logo.png")));
	        playlist = new Playlist();
	        listModel = new DefaultListModel<>();
	        listaMusicas = new JList<>(listModel);
	        listaMusicas.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	        listaMusicas.setBackground(new Color(204, 153, 255));

	        initComponents();
	    }

	    private void initComponents() {
	        setTitle("Playlist de Músicas");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setPreferredSize(new Dimension(400, 300));

	        JPanel mainPanel = new JPanel(new BorderLayout());
	        setContentPane(mainPanel);

	        JScrollPane scrollPane = new JScrollPane(listaMusicas);
	        mainPanel.add(scrollPane, BorderLayout.CENTER);
	        
	        JPanel panel = new JPanel();
	        panel.setBackground(new Color(204, 153, 255));
	        scrollPane.setColumnHeaderView(panel);
	        
	        JLabel lblNewLabel = new JLabel("Sound");
	        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	        lblNewLabel.setFont(new Font("Dubai", Font.BOLD, 25));
	        panel.add(lblNewLabel);
	        
	        JLabel lblHub = new JLabel("Hub");
	        lblHub.setForeground(new Color(102, 51, 153));
	        lblHub.setHorizontalAlignment(SwingConstants.CENTER);
	        lblHub.setFont(new Font("Dubai", Font.BOLD, 25));
	        panel.add(lblHub);

	        JPanel buttonPanel = new JPanel(new FlowLayout());
	        buttonPanel.setBackground(new Color(204, 51, 204));

	        JButton adicionarButton = new JButton("Adicionar Música");
	        adicionarButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                adicionarMusica();
	            }
	        });
	        buttonPanel.add(adicionarButton);

	        JButton removerButton = new JButton("Remover Música");
	        removerButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                removerMusica();
	            }
	        });
	        buttonPanel.add(removerButton);

	        JButton ordenarTituloButton = new JButton("Ordenar por Título");
	        ordenarTituloButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                ordenarPlaylistPorTitulo();
	            }
	        });
	        buttonPanel.add(ordenarTituloButton);

	        JButton ordenarDuracaoButton = new JButton("Ordenar por Duração");
	        ordenarDuracaoButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                ordenarPlaylistPorDuracao();
	            }
	        });
	        buttonPanel.add(ordenarDuracaoButton);

	        JButton ordenarArtistaButton = new JButton("Ordenar por Artista");
	        ordenarArtistaButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                ordenarPlaylistPorArtista();
	            }
	        });
	        buttonPanel.add(ordenarArtistaButton);

	        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

	        pack();
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	    private void adicionarMusica() {
	        JTextField tituloField = new JTextField();
	        JTextField artistaField = new JTextField();
	        JTextField duracaoField = new JTextField();

	        JPanel panel = new JPanel(new GridLayout(3, 2));
	        panel.add(new JLabel("Título:"));
	        panel.add(tituloField);
	        panel.add(new JLabel("Artista:"));
	        panel.add(artistaField);
	        panel.add(new JLabel("Duração(em minutos):"));
	        panel.add(duracaoField);

	        int result = JOptionPane.showConfirmDialog(null, panel, "Adicionar Música",
	                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

	        if (result == JOptionPane.OK_OPTION) {
	            String titulo = tituloField.getText();
	            String artista = artistaField.getText();
	            int duracao = Integer.parseInt(duracaoField.getText());

	            Musica musica = new Musica(titulo, artista, duracao);
	            playlist.adicionarMusica(musica);
	            listModel.addElement(musica);
	        }
	    }

	    private void removerMusica() {
	        int selectedIndex = listaMusicas.getSelectedIndex();
	        if (selectedIndex != -1) {
	            playlist.removerMusica(selectedIndex);
	            listModel.remove(selectedIndex);
	        } else {
	            JOptionPane.showMessageDialog(null, "Selecione uma música para remover.", "Aviso", JOptionPane.WARNING_MESSAGE);
	        }
	    }

	    private void ordenarPlaylistPorTitulo() {
	        playlist.ordenarPorTitulo();
	        atualizarLista();
	    }

	    private void ordenarPlaylistPorDuracao() {
	        playlist.ordenarPorDuracao();
	        atualizarLista();
	    }

	    private void ordenarPlaylistPorArtista() {
	        playlist.ordenarPorArtista();
	        atualizarLista();
	    }

	    private void atualizarLista() {
	        listModel.clear();
	        for (Musica musica : playlist.getMusicas()) {
	            listModel.addElement(musica);
	        }
	    }

	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                new PlaylistGUI();
	            }
	        });
	    }
	}
