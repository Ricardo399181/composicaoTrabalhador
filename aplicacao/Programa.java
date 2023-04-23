package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import entidades.Contrato;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelTrabalhador;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyy");

		System.out.println("entre com o nome do departamento: ");
		String departamento = sc.nextLine();

		System.out.println("entre com os dados do trabalhador: ");
		System.out.print("nome: ");
		String nome = sc.nextLine();

		System.out.print("nivel: ");
		String nivel = sc.nextLine();

		System.out.print("base salarial: ");
		double baseSalarial = sc.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nome, NivelTrabalhador.valueOf(nivel), baseSalarial,new Departamento(departamento));

		System.out.print("quantos contratos o trabalhador tera ?: ");
		int n = sc.nextInt();

		for (int i = 1; i <=n; i++) {
			System.out.println("contrato numero #" + i + "dados: ");
			System.out.print("data (DD/MM/YYYY): ");
			Date contratoDate = sdf.parse(sc.next());
			System.out.print("valor por hora: ");
			double valorPorHora = sc.nextDouble();
			System.out.print("duracao (horas): ");
			int hora = sc.nextInt();
			Contrato contrato = new Contrato(contratoDate, valorPorHora, hora);
			trabalhador.addContrato(contrato);

		}

		System.out.println();
		System.out.print("entre com o mes e ano para calcular os rendimentos: ");
		String mesAno = sc.next();
		int mes = Integer.parseInt(mesAno.substring(0, 2));
		int ano = Integer.parseInt(mesAno.substring(3));

		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getName());
		System.out.println("Renda desse período " + mesAno + ": " + String.format("%.2f", trabalhador.ganho(ano, mes) + trabalhador.getBaseSalarial()));

		sc.close();

	}

}
