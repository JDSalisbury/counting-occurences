import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.stream.Collectors;

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

					if (cleanWord.trim().equals(nothing)) {
						continue;
					}

					if (occurences.containsKey(cleanWord)) {
						occurences.put(cleanWord, occurences.get(cleanWord) + 1);
					} else {
						occurences.put(cleanWord, 1);
					}
				}
			}

			linedUp = fileReader.readLine();
		}
		Map<String, Integer> OrderOfOccurencesFromHighToLow = occurences.entrySet().stream()
				.sorted(Entry.<String, Integer>comparingByValue().reversed())
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		System.out.println(OrderOfOccurencesFromHighToLow);
	}

}
