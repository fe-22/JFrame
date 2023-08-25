package persistence;

import java.util.Iterator;

public class PessoaDao {
	
	private String[] pessoas = new String[3];
	
	private int proximaPosicao() {
		int tamanho = pessoas.length;
		for (int i = 0 ; i < tamanho ; i++) {
			if(pessoas[i] == null) {
				return i;
			}
			
			
		}
		
		return tamanho;
	}
	
	public String adicionarPessoa (String pessoa) {
		int proximaPosicao = proximaPosicao();
		if(proximaPosicao < pessoas.length) {
			pessoas[proximaPosicao] = pessoa;
			return "Pessoa inserida!";
		}else {
			return "Base de Dados Cheia!";
		}
	}
	
	public void excluirPessoas(int posicao) {
			int tamanho = pessoas.length;
			for(int i = posicao + 1; i < tamanho; i ++) {
				pessoas[i - 1] = pessoas [i];
			}
			
			pessoas[tamanho - 1] = null;
	}
	
	public String consultarPessoas (int posicao) {
		return pessoas[posicao];
	}
	
	public String[]consultarPessoas(){
		int proximaPosicao = proximaPosicao();
			String pessoaAux[] = new String[proximaPosicao];
			for (int i = 0; i < proximaPosicao; i++) {
				pessoaAux[i] = pessoas[i];
				
			}
			
			return pessoaAux;
			
		}
	}
	


