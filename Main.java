import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String hello_massege = new String("Input:");
        String result_massege = new String("Output:");
        String error_massege = new String("Error!");
        String num1str, num2str, operator, ansver;
        while(1 == 1){
            System.out.println(hello_massege);
            Scanner s = new Scanner (System.in);
            num1str = s.next();
            operator = s.next();
            num2str = s.next();
            if(s.nextLine().equals("")){
                System.out.println(result_massege);
                Calculat ob = new Calculat();
                ansver = ob.enterstring(num1str, operator, num2str);
                if(ansver.equals("0")){
                    System.out.println(error_massege);
                    break;
                }else{
                    System.out.println(ansver);
                }
            }else {
                System.out.println(error_massege);
                break;
            }
        }
    }
}
