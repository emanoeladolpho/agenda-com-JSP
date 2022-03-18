package model;

import java.util.ArrayList;

public class Dao {
	
	ArrayList<JavaBeans> contatos = new ArrayList<>();	
	
	public Dao() {
		contatos.add(new JavaBeans(1L,"Fulano","1111-1111","fulano@hotmail.com"));
		contatos.add(new JavaBeans(2L,"Ciclano","2222-2222","ciclano@hotmail.com"));
		contatos.add(new JavaBeans(3L,"Beltrano","3333-3333","beltrano@hotmail.com"));		
	}

	public void inserirContato(JavaBeans contato) {
		Long ultimoId = contatos.get(contatos.size() - 1).getId();
		contato.setId(ultimoId + 1);
		contatos.add(contato);
	}
	
	public JavaBeans getContatoById(JavaBeans contato) {
		contato = contatos.get(contato.getId().intValue() - 1);
		return contato;
	}	
	
	public void editarContato(JavaBeans contato) {
		contatos.set(contato.getId().intValue() - 1, contato);
	}
	
	public void deletarContato(JavaBeans contato) {
		JavaBeans contatoBuscado = contatos
				.stream()
				.filter(item -> item.getId().equals(contato.getId()))
				.findFirst()
				.orElse(null);
		contatos.remove(contatoBuscado);
	}

	public ArrayList<JavaBeans> getContatos() {
		return contatos;
	}

	public void setContatos(ArrayList<JavaBeans> contatos) {
		this.contatos = contatos;
	}
}