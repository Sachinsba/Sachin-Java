import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {
	public static void main(String[] args) {
		String filePath = "sample.txt";
		try {
			FileWriter writer = new FileWriter(filePath);
			writer.write("Hello, this is a sample file.");
			writer.close();
			
			System.out.println("Successfully wrote to the file.");
			StringBuilder content = new StringBuilder();
			FileReader reader = new FileReader(filePath);
			
			BufferedReader bufferedReader = new BufferedReader(reader);String line;
			while ((line = bufferedReader.readLine()) != null) {
				content.append(line);
			}
			
			bufferedReader.close();
			System.out.println("Content of the file: " + content);
			writer = new FileWriter(filePath, true);
			
			writer.write("\nThis is appended content.");
			writer.close();
			
			System.out.println("Successfully appended to the file.");
			System.out.println("Updated content of the file: " + content);} catch (IOException e) {
				System.out.println("An error occurred while handling the file.");e.printStackTrace();
			}
	}
}