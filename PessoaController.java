package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import persistence.PessoaDao;

public class PessoaController implements ActionListener{
	
	private JTextField tfPessoa;
	private JFormattedTextField tfPosicao;
	private JTextArea taLista;
	private PessoaDao pDao;
	

	public PessoaController(JTextField tfPessoa, JFormattedTextField tfPosicao, JTextArea taLista) {
		this.tfPessoa = tfPessoa;
		this.tfPosicao = tfPosicao;
		this.taLista = taLista;
		pDao = new PessoaDao();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		if (cmd.equals("Adicionar")) {
			adicionar(tfPessoa.getText());
		}
		if(cmd.equals("Excluir")) {
			int posicao = Integer.parseInt(tfPosicao.getText());
			excluir(posicao);
		}
		if(cmd.equals("Consultar")) {
			int posicao = Integer.parseInt(tfPosicao.getText());
			consultar(posicao);
		}
		if(cmd.equals("Listar")) {
		      listar();
	}

	}

	private void listar() {
		String[]pessoas = pDao.consultarPessoas();
		StringBuffer buffer = new StringBuffer();
		for(String pessoa : pessoas) {
			buffer.append(pessoas);
			buffer.append("\n");
		}
		
		taLista.setText(buffer.toString());
		
	}



	private void consultar(int posicao) {
		String pessoa = pDao.consultarPessoas(posicao);
		tfPessoa.setText(pessoa);
		tfPessoa.setText("0");
		
	}



	private void excluir(int posicao) {
		pDao.excluirPessoas(posicao);
		tfPosicao.setText("0");
		listar();
		
	}



	private void adicionar(String pessoa) {
		String retorno = pDao.adicionarPessoa(pessoa);
		if(retorno.contains("inserida")) {
			JOptionPane.showMessageDialog(null, retorno, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		}else {
			JOptionPane.showMessageDialog(null, retorno, "ERRO", JOptionPane.ERROR_MESSAGE);
		}
		tfPessoa.setText("");
		listar();
		
	}
	
	

}
