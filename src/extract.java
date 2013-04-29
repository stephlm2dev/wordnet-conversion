import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class extract {
		
	public static void main(String[] args) {
		Scanner scanner = null;
		int current_id = 0, compteur = 1;
		try {
			scanner = new Scanner(new FileReader("../../fra/wn-data-fra.tab"));
		} catch (FileNotFoundException e) {
			System.err.println("Fichier non trouvé");
		}
		String str = null;
		String[] current_line, infos = null;
		while (scanner.hasNextLine()) {
			str = scanner.nextLine();
			current_line = str.toString().split(" ");
			infos = current_line[0].split("-");
			if (current_id != Integer.parseInt(infos[0])) {
				current_id = Integer.parseInt(infos[0]);
				compteur = 1;
			} else ++compteur;
			
			System.out.println("s("+ current_id + "," + compteur + "," + "'" + current_line[1] + "'"
					+ "," + infos[1] + ",1,1).");
		}
	}
}
