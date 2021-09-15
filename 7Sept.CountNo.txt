import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;

class CountWordNumbers{
    public static void main(String[] args) throws IOException{
        StreamTokenizer tokens = getTokens();
        int tokenNumber = 0;
        int wordCount=0,numberCount=0;
        while((tokenNumber = tokens.nextToken()) != StreamTokenizer.TT_EOL)
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
        System.out.println("Words count : "+wordCount);
        System.out.println("Number count : "+numberCount);
        }

        public static StreamTokenizer getTokens()
        {
            System.out.println("Enter any string : ");
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
            StreamTokenizer tokens = new StreamTokenizer(br);
            tokens.eolIsSignificant(true);
            return tokens;
        }
}