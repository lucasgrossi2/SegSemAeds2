import java.util.*;

public class placa {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String placa = sc.nextLine();
        if(placa.length() == 8){
            if(Character.isLetter(placa.charAt(0))){
                if(Character.isLetter(placa.charAt(1))){
                    if(Character.isLetter(placa.charAt(2))){
                        if(placa.charAt(3) == '-'){
                            if(Character.isDigit(placa.charAt(4))){
                                if(Character.isDigit(placa.charAt(5))){
                                    if(Character.isDigit(placa.charAt(6))){
                                        if(Character.isDigit(placa.charAt(7))){
                                            System.out.println("1");
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else if(placa.length() == 7){
            if(Character.isLetter(placa.charAt(0))){
                if(Character.isLetter(placa.charAt(1))){
                    if(Character.isLetter(placa.charAt(2))){
                        if(Character.isDigit(placa.charAt(3))){
                            if(Character.isLetter(placa.charAt(4))){
                                if(Character.isDigit(placa.charAt(5))){
                                    if(Character.isDigit(placa.charAt(6))){
                                        System.out.println("2");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }else{
            System.out.println("0");
        }
        sc.close();
    }
}
