package Principal;

import java.io.IOException;
import java.util.Scanner;

import Fabricas.FabricaMecanicaDoJogo;

public class Principal {

	private static Scanner scanner;
	private static FabricaMecanicaDoJogo FM;
	private static MecanicaDoJogo MDJ;
	static String in;
	static String out;
	
	public static void main(String[] args) throws IOException {
		
		FM = new FabricaMecanicaDoJogo();
		
		scanner = new Scanner(System.in);
		in = scanner.nextLine();
		out = in;
		
		if (in.equalsIgnoreCase("go")) {
			MDJ = FM.mecanica(out);
			out = MDJ.funcaoMecanica();
			System.out.println(out);
			do {
				scanner = new Scanner(System.in);
				in = scanner.nextLine();
				out = in;
				MDJ = FM.mecanica(out);
				out = MDJ.funcaoMecanica();
				System.out.println(out);
			}
			while (!out.equalsIgnoreCase("exit"));	
			}
		}
	}
