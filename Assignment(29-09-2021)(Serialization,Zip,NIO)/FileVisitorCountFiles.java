
import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;


public class FileVisitorCountFiles
{
	static long count = 1;

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)) 
		{
			System.out.print("Enter extension : ");
			String ext = sc.nextLine();
			System.out.print("Enter Path : ");
			String path = sc.nextLine();
			File file = new File(path);
			Visitor visitor = new Visitor(ext,1);
			
			if (file.isDirectory()) {
				try {
					Path path2 = Paths.get(path);
					Files.walkFileTree(path2, visitor);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println(" -- Invalid Path -- ");
			}
			System.out.println("Total files Available : "+(visitor.getCount()-1));
		}
		
	}

}

class Visitor extends SimpleFileVisitor<Path>{
	
	private String ext;
	private int count;
	
	public Visitor(String ext, int count) {
		super();
		this.ext = ext;
		this.count = count;
	}
	
	public String getExt() {
		return ext;
	}

	public int getCount() {
		return count;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		String match = getExt();
		if(file.getFileName().toString().endsWith(match)) {
			System.out.println(this.count+". "+file.toFile().getPath());
			this.count+=1;
		}
		return FileVisitResult.CONTINUE;
	}
	
}
