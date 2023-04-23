package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelTrabalhador;

public class Trabalhador {

	private String nome;
	private NivelTrabalhador nivel;
	private Double baseSalarial;
	private Departamento departamento;
	private List<Contrato> contratos = new ArrayList<>();

	public Trabalhador(String nome, NivelTrabalhador nivel, Double baseSalarial, Departamento departamento) {

		this.nome = nome;
		this.nivel = nivel;
		this.baseSalarial = baseSalarial;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelTrabalhador getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalhador nivel) {
		this.nivel = nivel;
	}

	public Double getBaseSalarial() {
		return baseSalarial;
	}

	public void setBaseSalarial(Double baseSalarial) {
		this.baseSalarial = baseSalarial;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void addContrato(Contrato contrato) {
		contratos.add(contrato);
	}

	public void removerContrato(Contrato contrato) {
		contratos.remove(contrato);
	}

	public double ganho(int ano, int mes) {
		double soma = baseSalarial;
	    Calendar cal = Calendar.getInstance();
	    for (Contrato c : contratos) {
	        cal.setTime(c.getData());
	        int c_ano = cal.get(Calendar.YEAR);
	        int c_mes = 1 + cal.get(Calendar.MONTH);
	        if (ano == c_ano && mes == c_mes) {
	            soma += c.valorTotal();
	        }
		}

		return soma;
	}

}
