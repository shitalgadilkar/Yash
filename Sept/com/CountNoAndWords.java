
import java.io.File;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class CountNoAndWords {
    public static void main(String[] args) throws IOException{
        StreamTokenizer tokens = getTokens();
        if(tokens == null) {
        	System.exit(0);
        }
        int tokenNumber = 0;
        int wordCount=0,numberCount=0;
        while((tokenNumber = tokens.nextToken()) != StreamTokenizer.TT_EOF)
        {
            switch(tokenNumber){
                case StreamTokenizer.TT_NUMBER:
                    numberCount++;
                    break;
                case StreamTokenizer.TT_WORD:
                    wordCount++;
                    break;
                default:
                    break;
            }
        }
        System.out.println("\nWords count : "+wordCount);
        System.out.println("Number count : "+numberCount);
        }
    
    public static StreamTokenizer getTokens()
    {
    	StreamTokenizer tokens=null;
    	try(Scanner sc = new Scanner(System.in))
    	{
    		System.out.println("Enter file path : ");
    		String path = sc.nextLine();
    		File file = new File(path);
    		if(file.exists()) {
        		Path path2 = file.toPath();
        		System.out.println("File content : ");
        		Files.readAllLines(path2).forEach(System.out::println);
        		
        		tokens = new StreamTokenizer(Files.newBufferedReader(path2));
        		tokens.eolIsSignificant(true);
        		return tokens;
    		}
    		else {
    			System.out.println("File does not exist");
    		}
    	} catch (IOException e) {
			e.printStackTrace();
		}
    	
    	return tokens;
    }
}