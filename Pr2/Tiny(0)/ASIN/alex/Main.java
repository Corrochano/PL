package alex;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

	public static void main(String[] args) {
		Reader input;
		try {
			input = new InputStreamReader(new FileInputStream("input.txt"));
			AnalizadorLexicoTiny al;
			al = new AnalizadorLexicoTiny(input);
			UnidadLexica unidad;
			do {
				unidad = al.sigToken();
				System.out.println(unidad);
			} while (unidad.clase() != ClaseLexica.EOF);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}