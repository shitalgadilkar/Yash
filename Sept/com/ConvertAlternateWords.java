import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConvertAlternateWords {
	public static void main(String[] args) {
		try(Scanner sc = new Scanner(System.in))
		{
			System.out.println("Enter file path :");
			String paths = sc.nextLine();
			File file = new File(paths);
				if(file.exists()) 
				{
					ConvertAlternateWords.alterWordsCase(file);
				}
				else {
					System.out.println("File does not exist");
				}
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public static void alterWordsCase(File file) throws IOException {
		Path path = file.toPath();
		List<String> readAllLines = Files.readAllLines(path);
		System.out.println("Input :");
		readAllLines.forEach(System.out::println);
		readAllLines = readAllLines.stream().map(x -> {
													String[] split = x.split(" ");
													StringBuilder builder = new StringBuilder();
													for(int i=0;i<split.length;i++) {
														if(i%2 != 0) {
															String next = split[i];
															builder.append(next.toUpperCase()).append(" ");
														}
														else {
															builder.append(split[i]).append(" ");
														}
													}
													return builder.toString();
												}).collect(Collectors.toList());
		
		Files.write(path, readAllLines, StandardOpenOption.WRITE);
		System.out.println("\n**** Operation completed Successfully *****");
		System.out.println("Output :");
		readAllLines.forEach(System.out::println);
	}
}
