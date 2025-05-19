package CronicasDoEstudante;

import java.util.Objects;

public class Cronica {
	private String titulo;
	private String texto;
	private String data;
	private String autor;
	private int leituras;
	private int indice;
	
	public Cronica(String titulo, String texto, String data) {
		this.titulo = titulo;
		this.texto = texto;
		this.data = data;
		this.autor = "Anônimo";
	}
	
	public void setIndice(int indice) {
		this.indice = indice;
	}

	public Cronica(String titulo, String texto, String data, String autor) {
		this.titulo = titulo;
		this.texto = texto;
		this.data = data;
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cronica other = (Cronica) obj;
		return Objects.equals(titulo, other.titulo);
	}

	@Override
	public String toString() {
		return "Cronica #" + indice + "\n" + titulo + "\nData: " + data + "\nAutor: " + autor + "\n" + texto;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getTexto() {
		this.leituras++;
		return texto;
	}

	public String getData() {
		return data;
	}

	public String getAutor() {
		return autor;
	}

	public int getLeituras() {
		return leituras;
	}
	
	

}
