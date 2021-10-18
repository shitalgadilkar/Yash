import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStudentDatFile {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Path for zip file : ");
		String path=sc.nextLine();
		System.out.println("Enter zip file name : ");
		String name=sc.nextLine();
		File file = new File(path);
		if(file.isDirectory()) {
			try(
				InputStream is = new FileInputStream("src\\student1.dat");
				OutputStream os = new FileOutputStream(file.getPath()+"\\"+name+".zip");
				ZipOutputStream zos=new ZipOutputStream(os);
					){
				ZipEntry zipEntry=new ZipEntry("student1.dat");
				zos.putNextEntry(zipEntry);
				byte[] buffer=new byte[1024];
				int k;
				while((k=is.read(buffer))>0) {
					zos.write(buffer,0,k);
				}
				zos.closeEntry();
				System.out.println("---- Task completed ----");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			System.out.println("-- Invalid path --");
		}
		
		sc.close();
	}
}
