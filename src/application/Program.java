package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;
import entities.Individual;
import entities.Company;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> pessoas = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {

			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or company (i/c)? ");
			char choice = sc.next().toLowerCase().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			Double income = sc.nextDouble();

			if (choice == 'i') {
				System.out.print("Health expenditures: ");
				Double expenditures = sc.nextDouble();
				pessoas.add(new Individual(name, income, expenditures));
			} else {
				System.out.print("Number of employees: ");
				Integer numberEmployees = sc.nextInt();
				pessoas.add(new Company(name, income, numberEmployees));
			}

		}

		Double sum = 0.0;

		System.out.println();
		System.out.println("TAXES PAID:");

		for (TaxPayer pessoa : pessoas) {
			System.out.println(pessoa);
		}
		
		for (TaxPayer pessoa : pessoas) {
			sum += pessoa.calcularImposto();
		}

		System.out.println();
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));

		sc.close();
	}

}
