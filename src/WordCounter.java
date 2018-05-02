import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.TreeMap;

public class WordCounter {

	public static void main(String[] args) throws Exception {

		String fileName = "Paragraph.txt";

		Path fileFinder = Paths.get(System.getProperty("user.dir")).resolve(fileName);

		BufferedReader fileReader = new BufferedReader(new FileReader(fileFinder.toFile()));

		Map<String, Integer> occurences = new TreeMap<>();

		String linedUp = fileReader.readLine();
		String nothing = "";

		while (linedUp != null) {
			if (!linedUp.trim().equals(nothing)) {
				String[] words = linedUp.split(" ");

				for (String word : words) {

					String cleanWord = word.toLowerCase().replace(",", nothing).replace(".", nothing)
							.replace("\"", nothing).replace("?", nothing);

					System.out.println(cleanWord);
				}
			}

			linedUp = fileReader.readLine();
		}
	}

}
