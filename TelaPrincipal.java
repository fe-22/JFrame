package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import controller.PessoaController;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class TelaPrincipal extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfPessoa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 480);
		contentPane = new JPanel();
		contentPane.setToolTipText("");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfPessoa = new JTextField();
		tfPessoa.setBounds(74, 45, 400, 20);
		contentPane.add(tfPessoa);
		tfPessoa.setColumns(10);
		
		JLabel lblPessoa = new JLabel("Pessoa");
		lblPessoa.setBounds(18, 48, 54, 14);
		contentPane.add(lblPessoa);
		
		//formatador de campos
		NumberFormat numberFormat = NumberFormat.getInstance();
		NumberFormatter formatter = new NumberFormatter(numberFormat);
		//propriedade
		formatter.setValueClass(Integer.class);
		formatter.setMinimum(0);
		formatter.setMaximum(3);
		formatter.setAllowsInvalid(false);
		
		JFormattedTextField tfPosicao = new JFormattedTextField(formatter);
		tfPosicao.setBounds(74, 87, 54, 20);
		contentPane.add(tfPosicao);
		
		JLabel lblposicao = new JLabel("Posição");
		lblposicao.setBounds(18, 90, 46, 14);
		contentPane.add(lblposicao);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAdicionar.setBounds(39, 174, 89, 23);
		contentPane.add(btnAdicionar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(158, 174, 89, 23);
		contentPane.add(btnExcluir);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.setBounds(284, 174, 89, 23);
		contentPane.add(btnConsultar);
		
		JButton btnListar = new JButton("Listar");
		btnListar.setBounds(411, 174, 89, 23);
		contentPane.add(btnListar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(18, 221, 488, 194);
		contentPane.add(scrollPane);
		
		JTextArea taLista = new JTextArea();
		scrollPane.setViewportView(taLista);
		
		PessoaController pessoaController = new PessoaController(tfPessoa, tfPosicao, taLista);
		btnAdicionar.addActionListener(pessoaController);
		btnConsultar.addActionListener(pessoaController);
		btnExcluir.addActionListener(pessoaController);
		btnListar.addActionListener(pessoaController);
	}
}
