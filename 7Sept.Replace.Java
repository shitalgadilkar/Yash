class ReplaceWord{
    public static void main(String[] args) {
        ReplaceWord replace = new ReplaceWord();
        String inputString = "Java is Object Oriented. Java is Programming Language.";
        System.out.println("Input String : "+inputString);
        System.out.println("Output String : "+replace.replaceAllWords("Java", "C++", inputString));
    }

    public StringBuilder replaceAllWords(String fromWord,String toWord,String inputString){
        String[] str = inputString.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String string : str) {
            if(string.equalsIgnoreCase(fromWord)){
                sb.append(toWord).append(" ");
            }
            else{
                sb.append(string).append(" ");
            }
        }
        return sb;
    }
}