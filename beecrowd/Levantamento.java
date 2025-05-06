import java.util.*;

class Atleta{
    String nome;
    int peso;
    public Atleta(String nome, int peso){
        this.nome = nome;
        this.peso = peso;
    }
}

public class Levantamento {

    public static void insertionSort(Atleta[] lista, int num){
        for(int i = 1; i < num; i++){
            int atual = lista[i].peso;
            String atual2 = lista[i].nome;
            int j = i - 1;

            while(j >= 0 && lista[j].peso < atual){
                lista[j + 1].nome = lista[j].nome;
                lista[j + 1].peso = lista[j].peso;
                j--;
            }

            lista[j + 1].nome = atual2;
            lista[j + 1].peso = atual;
        }

    }

    public static void ordemAlfabetica(Atleta[] lista, int num){
        for(int k = 1; k < num; k++){
            for(int i = 1; i < num; i++){
                int j = i - 1;
                if(lista[i].peso == lista[j].peso){
                    int result = lista[j].nome.compareTo(lista[i].nome);
                    if(result > 0){
                        Atleta temp = new Atleta(lista[j].nome, lista[j].peso);
                        lista[j].nome = lista[i].nome;
                        lista[j].peso = lista[i].peso;
                        lista[i].nome = temp.nome;
                        lista[i].peso = temp.peso;
                    }
                }
            }
        }
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        int num_atletas = sc.nextInt();
        sc.nextLine();

        Atleta[] vetor = new Atleta[num_atletas];

        for(int i = 0; i < num_atletas; i++){
            String input = sc.nextLine();
            String info[] = input.split(" ");
            vetor[i] = new Atleta(info[0], Integer.parseInt(info[1]));

        }
        insertionSort(vetor, num_atletas);
        ordemAlfabetica(vetor, num_atletas);

        for(int i = 0; i < num_atletas; i++){
            System.out.println(vetor[i].nome + " " + vetor[i].peso);
        }
        

        sc.close();

    }
}
