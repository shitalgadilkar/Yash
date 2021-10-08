import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;


public class CheckFilesExtentions {
	static long count = 1;

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) {
			System.out.print("Enter extension : ");
			String ext = sc.next();
			File file = new File("D:\\");
			if (file.isDirectory()) {
				try {
					checkFile(file, ext);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println(" -- Invalid Path -- ");
			}
		}
		
		System.out.println("Total files Available : "+(count-1));
	}

	public static void checkFile(File file, String search) throws IOException {
		File[] listFiles = file.listFiles();
		for (File file2 : listFiles) {

			if (file2.isDirectory()) {
				if (!file2.isHidden()) {
					checkFile(file2, search);
				}
			} else if (file2.isFile()) 
			{
				if(file2.isHidden()) {
					continue;
				}
				if (file2.getName().endsWith(search)) {
					System.out.println(count+". "+file2.getCanonicalPath() +"  --- Size :"+Files.size(file2.toPath()));
					count++;
				}
			}

		}

	}

}