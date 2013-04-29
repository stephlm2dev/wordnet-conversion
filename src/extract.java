import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class extract {

	public static String newline = System.getProperty("line.separator");

	public static void main(String[] args) {
		Scanner scanner = null;
		String path = args[0];
		String current_id = "", word = null;
		String[] current_line = null, description = null;
		int compteur = 1;
		try {
			scanner = new Scanner(new FileReader(path));
		} catch (FileNotFoundException e) {
			System.err.println("Fichier non trouvé");
		}
		while (scanner.hasNextLine()) {
			current_line = scanner.nextLine().toString().split(" ");
			word = "";
			if (current_line.length > 2) {
				for (int i = 1; i < current_line.length; ++i) {
					word = word.concat(current_line[i] + " ");
				}
			} else
				word = current_line[1];

			word = word.replace("'", "’");
			word = word.replace("œ", "oe");
			description = current_line[0].split("-");
			if (!(current_id.equals(description[0]))) {
				current_id = description[0];
				compteur = 1;
			} else {
				++compteur;
			}

			writeFile("s(" + current_id + "," + compteur + "," + "'" + word
					+ "'" + "," + description[1] + ",1,1)." + newline,
					"wn_s.pl");
		}
		System.out.println("Fin de l'écriture du fichier");
	}

	public static void writeFile(String text, String path) {
		FileWriter writer = null;
		try {
			writer = new FileWriter(path, true);
			writer.write(text, 0, text.length());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("'" + text + "' a bien été écris dans le fichier");

	}
}
