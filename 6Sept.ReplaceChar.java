public class ReplaceCharacter{
    public static String replaceCharacter(char fromCharacter , char toCharacter , String inputString)
    {
        StringBuilder builder = new StringBuilder();
        for(int i=0;i<inputString.length();i++)
        {
            char ch = inputString.charAt(i);
            if(ch==fromCharacter)
            {
                builder.append(toCharacter);
            }
            else if(ch==Character.toUpperCase(fromCharacter)){
                builder.append(Character.toUpperCase(toCharacter));
            }
            else if(i==3){
                builder.append(Character.toUpperCase(ch));
            }
            else{
                builder.append(ch);
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        String inputString = "Hello all this is world of jAva";
        System.out.println("Input String : "+inputString);
        System.out.println("\nOutput String : "+replaceCharacter('a', 'e', inputString)+"\n");
    }
}