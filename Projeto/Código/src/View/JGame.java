package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JGame extends JFrame {

	private JPanel contentPane;
	
	private JTextField txtPalavraEmbaralhada;
	private JTextField textPalavraEmbaralhada;
	private JTextField txtInsira;
	private JTextField textResposta;
	private JMenuBar menuBar;
	private JTextField txtPontuao;
	private JTextField textField_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JGame frame = new JGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPalavraEmbaralhada = new JTextField();
		txtPalavraEmbaralhada.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		txtPalavraEmbaralhada.setEditable(false);
		txtPalavraEmbaralhada.setText(" Palavra embaralhada:");
		txtPalavraEmbaralhada.setBounds(30, 39, 189, 33);
		contentPane.add(txtPalavraEmbaralhada);
		txtPalavraEmbaralhada.setColumns(10);
		
		textPalavraEmbaralhada = new JTextField();
		textPalavraEmbaralhada.setEditable(false);
		textPalavraEmbaralhada.setBounds(229, 40, 182, 32);
		contentPane.add(textPalavraEmbaralhada);
		textPalavraEmbaralhada.setText("Teucu");
		textPalavraEmbaralhada.setColumns(10);
		
		txtInsira = new JTextField();
		txtInsira.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		txtInsira.setEditable(false);
		txtInsira.setText(" Insira seu palpite :");
		txtInsira.setBounds(30, 83, 189, 33);
		contentPane.add(txtInsira);
		txtInsira.setColumns(10);
		
		textResposta = new JTextField();
		textResposta.setBounds(229, 84, 182, 32);
		contentPane.add(textResposta);
		textResposta.setColumns(10);
		
		JButton btnNewButton = new JButton("Arriscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (textPalavraEmbaralhada.getText().equals(textResposta.getText())) {
					ImageIcon acerto = new ImageIcon("../Interface-img/download.png");
					JOptionPane.showMessageDialog(null, "ACERTOU!!!", "acerto", JOptionPane.INFORMATION_MESSAGE, acerto);
				}
				else {
					ImageIcon erro = new ImageIcon("../Interface-img/mtboa.jpg");
					JOptionPane.showMessageDialog(null, "ERROUUU!!!", "erro",  JOptionPane.INFORMATION_MESSAGE, erro);
				}
			}
		});
		btnNewButton.setFont(new Font("OCR A Extended", Font.PLAIN, 14));
		btnNewButton.setBounds(157, 127, 105, 33);
		contentPane.add(btnNewButton);
		
		txtPontuao = new JTextField();
		txtPontuao.setFont(new Font("OCR A Extended", Font.PLAIN, 12));
		txtPontuao.setEditable(false);
		txtPontuao.setText("Pontua\u00E7\u00E3o:");
		txtPontuao.setBounds(229, 11, 86, 20);
		contentPane.add(txtPontuao);
		txtPontuao.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setBounds(325, 11, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

}
