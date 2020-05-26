public class Calculat {
    public static String enterstring(String num1str, String operator, String num2str){
        String ansver = new String();
        try {
            int temp = Integer.parseInt(num1str);
            ansver = arabnuber(num1str, operator, num2str);
            return ansver;
        } catch (NumberFormatException e) {
            ansver = romanuber(num1str, operator, num2str);
            return ansver;
        }
    }

    public static String arabnuber(String num1str, String operator, String num2str){
        String ansver = new String();
        try {
            int num2 = Integer.parseInt(num2str);//является ли вторая строка числом
            int num1 = Integer.parseInt(num1str);
            if((num1<=10 & num1>=1) & (num2<=10 & num2>=1)){
                ansver = operation(num1, num2, operator);
                return ansver;
            }else{
                return "0";
            }
        } catch (NumberFormatException e) {
            return "0";//вторая строка не число, значит ошибка
        }
    }

    public static String romanuber(String num1str, String operator, String num2str){
        String[] romanmass = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        int num1 = 0;
        int num2 = 0;
        String ansver = new String();
        for(int i=0; i<romanmass.length; i++){
            if(romanmass[i].equals(num1str) == true){
                num1 = i+1;
                num1str = "";
            }
            if(romanmass[i].equals(num2str) == true){
                num2 = i+1;
                num2str = "";
            }
        }
        if (num1str.length() == 0 & num2str.length() == 0){
            String tempansver = operation(num1, num2, operator);
            ansver = romanconversion(tempansver);
            return ansver;
        }else{
            return "0";
        }
    }
    private static String operation(int num1, int num2, String operator){
        int resalt;
        float tempresalt;
        if(operator.equals("+")){
            resalt = num1 + num2;
            String resaltstr = Integer.toString(resalt);
            return resaltstr;
        }else if(operator.equals("-")){
            resalt = num1 - num2;
            String resaltstr = Integer.toString(resalt);
            return resaltstr;
        }else if(operator.equals("*")){
            resalt = num1 * num2;
            String resaltstr = Integer.toString(resalt);
            return resaltstr;
        }else if(operator.equals("/")){
            tempresalt = (float)num1 / (float)num2;
            String resaltstr = Float.toString(tempresalt);
            return resaltstr;
        }else {
            return "0";
        }
    }
    public static String romanconversion(String ansver){
        String[] romanunits = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String[] romandoezens = {"X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] romanhundreds = {"C","CC","CCC"};
        String celoe = new String();
        String drobnoe = new String();
        if(ansver.indexOf('.') != -1){//число с плавающей точкой
            int index = ansver.indexOf('.');//получаем индекс точки в строке
            int ww = ansver.length();
            celoe = ansver.substring(0,index);//получаем число перед точкой
            drobnoe = ansver.substring(index+1);//получаем число после точки
            //можно сделать условия вывода остатка от целого числа.
        }else{//число целое
            celoe = ansver;
        }
        if (celoe.equals("0")){
            ansver = "the answer is less than 'I'";//ответ меньше еденицы
            return ansver;
        }
        if(celoe.length() == 1){//число 9 или меньше
            String temp = romanunits[Integer.valueOf(celoe)-1];
            ansver = temp;
            return ansver;
        }else if(celoe.length() == 2){//число от 10 до 99
            String temp1 = celoe.substring(0,1);
            String doezens = romandoezens[Integer.valueOf(temp1)-1];
            String temp2 = celoe.substring(1);
            String units = "";
            if(temp2.equals("0")){
                units = "";
            } else {
                units = romanunits[Integer.valueOf(temp2)-1];
            }
            ansver = doezens + units;
            return ansver;
        }else if(celoe.length() == 3){
            String temp1 = celoe.substring(0,1);
            String hundreds = romanhundreds[Integer.valueOf(temp1)-1];
            //так как максимальное число при выводе 100, то дополнительные условия вывода я не пишу
            ansver = hundreds;
            return ansver;
        }else {
            return "0";
        }
        //return ansver;
    }
}
