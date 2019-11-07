package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import Fabricas.FabricaMecanicaDoJogo;
import Principal.MecanicaDoJogo;

import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.FlowLayout;
import javax.swing.JTabbedPane;
import javax.swing.DropMode;
import javax.swing.JDesktopPane;

public class Start {

	private JFrame frame;
	private JTextField txtPalavrasEmbaralhadas;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 */
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex ) {
			System.err.println(ex);
		}
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Start window = new Start();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Start() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		txtPalavrasEmbaralhadas = new JTextField();
		txtPalavrasEmbaralhadas.setEditable(false);
		txtPalavrasEmbaralhadas.setToolTipText("");
		txtPalavrasEmbaralhadas.setBackground(SystemColor.menu);
		txtPalavrasEmbaralhadas.setFont(new Font("Snap ITC", Font.PLAIN, 26));
		txtPalavrasEmbaralhadas.setText("   Palavras Embaralhadas");
		txtPalavrasEmbaralhadas.setBounds(20, 31, 391, 76);
		frame.getContentPane().add(txtPalavrasEmbaralhadas);
		txtPalavrasEmbaralhadas.setColumns(10);
		
		JButton btnStartGame = new JButton("Start Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JGame jogo = new JGame();
				jogo.setVisible(true);
			}
		});
		btnStartGame.setBounds(145, 175, 137, 27);
		frame.getContentPane().add(btnStartGame);
		btnStartGame.setFont(new Font("Snap ITC", Font.BOLD | Font.ITALIC, 12));
	}
}
