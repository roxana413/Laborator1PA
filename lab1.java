
import java.lang.Math;



public class lab1 {

    public static void main ( String[] args) {
        System.out.println("Hello Word");

        String[] languages = {"C","C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
    int n = (int) (Math.random() * 1_000_000);
    n *= 3;

   String binaryString="10101";
   String hexaString="FF";


   int decimal = Integer.parseInt(binaryString,2);
   int hexa = Integer.parseInt(hexaString, 16);

   n += decimal;
   n += hexa;
   n *= 6;

   System.out.println("Willy-nilly, this semester I will learn " + languages[n%9]);


}
}