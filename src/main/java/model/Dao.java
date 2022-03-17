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
		contatos.add(contato);
	}

	public ArrayList<JavaBeans> getContatos() {
		return contatos;
	}

	public void setContatos(ArrayList<JavaBeans> contatos) {
		this.contatos = contatos;
	}
}