package Naive;

public class App {
    public static void main(String[] args) {
        System.out.println(search("My home test", "te"));
    }

    public static int search(String text, String pattern){
        int lenOfText = text.length();
        int lenOfPattern = pattern.length();

        for(int i = 0; i < lenOfText-lenOfPattern; i++){
            int j;
            for(j = 0; j < lenOfPattern; j++){
                if(text.charAt(i+j) != pattern.charAt(j)) break;
            }
            if(j == lenOfPattern) return i;
        }
        return lenOfText;
    }
}
