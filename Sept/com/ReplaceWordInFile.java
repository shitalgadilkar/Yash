
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ReplaceWordInFile {
	private static int index;
	public static void main(String[] args) 
	{
		try(Scanner sc = new Scanner(System.in))
		{
		System.out.println("Enter file path :");
		String paths = sc.nextLine();
		File file = new File(paths);
			if(file.exists()) 
			{
				System.out.print("Enter Word to search : ");
				String search = sc.next();
				
				Path path = file.toPath();
				List<String> readAllLines = Files.readAllLines(path);
				readAllLines.forEach(x-> {
										index = x.indexOf(search);
									});
				
				if(index == -1) {
					System.out.println("***** Word not found ******");
					return;
				}
				
				System.out.print("Enter replacement word : ");
				String substitute = sc.next();
				
				readAllLines=readAllLines.stream().map(f -> f.replaceAll(search,substitute)).collect(Collectors.toList());
				Files.write(path, readAllLines,StandardOpenOption.WRITE);
				System.out.println("**** Operation completed ***** ");
				
			}
			else {
				System.out.println("File does not exist");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}