package br.test.gu.adapter;

public class PontoAdapter extends Ponto{
		
	private NovoPonto novoPonto;
	
	public void registraPonto(){
		novoPonto = new NovoPonto();
		novoPonto.registraNovoPonto();
		System.out.println("Novo ponto Registrado com sucesso!!");
	}

	
}
