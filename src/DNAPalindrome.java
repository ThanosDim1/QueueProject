import java.util.Scanner;

public class DNAPalindrome {

    public DNAPalindrome(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the DNA sequence: ");
        String DNA = sc.nextLine();
        while (!DNAvalid(DNA)){
            System.out.println("The DNA sequence you entered was wrong.\nPlease enter a right DNA sequence ");
            DNA = sc.nextLine();
        }
        DNAcheck(DNA);
    }
    static Character convert(Character C){
        return switch (C){
            case 'A' -> 'T';
            case 'T' -> 'A';
            case 'G' -> 'C';
            case 'C' -> 'G';
            default -> ' ';
        };
    }

    // Function to check if the given DNA sequence is a Watson-Crick complemented palindrome
    static boolean DNAvalid(String DNA) {
        for (int i = 0; i <= DNA.length() - 1; i++) {
            char c = DNA.charAt(i);
            if (convert(c)==' ' || DNA.length()%2!=0){
                return false;
            }
        }
        return true;
    }

    static void DNAcheck(String DNA){
        StringDoubleEndedQueueImpl<Character> stack = new StringDoubleEndedQueueImpl<>();
        for (int i = 0; i <= DNA.length() - 1; i++){
            char c = DNA.charAt(i);
            stack.addLast(c);
        }
        for (int i = 0; i <= stack.size(); i++){
            if(!(stack.removeFirst()==convert(stack.removeLast()))){
                System.out.println("The DNA sequence you entered is not a Watson-Crick complemented palindrome");
                return;
            }
        }
        System.out.println("The DNA sequence you entered is a Watson-Crick complemented palindrome");
    }


    public static void main(String[] args) {
        DNAPalindrome process=new DNAPalindrome();
    }
}