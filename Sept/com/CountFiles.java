
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CountFiles {
	
	private static long count=0;
	
	public static void main(String[] args) throws IOException {
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter Path : ");
			String paths = sc.nextLine();
			File file = new File(paths);
			if (file.isDirectory()) {
				System.out.println("----- Path Detected -----");
				
				System.out.println("Total Files : " + countFiles(file));
			} else {
				System.out.println(" -- Invalid Path -- ");
			}
		}
	}

	private static String countFiles(File file) {
		// TODO Auto-generated method stub
		return null;
	}

	public CountFiles(File file)
	{
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {
//			if(file2.isDirectory()) {
//				countFiles(file2);
//			}
//			else 
				if(file2.isFile()) {
				count++;
			}
		}
		
		
	}
	
}