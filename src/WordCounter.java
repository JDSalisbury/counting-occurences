import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WordCounter {

	public static void main(String[] args) throws Exception {

		String fileName = "Paragraph.txt";

		Path fileFinder = Paths.get(System.getProperty("user.dir")).resolve(fileName);

		BufferedReader fileReader = new BufferedReader(new FileReader(fileFinder.toFile()));
	}

}
