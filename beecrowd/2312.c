#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct{
    char nome[100];
    int ouro;
    int prata;
    int bronze;

}Pais;

void InsertionSort(Pais pais[], int numPaises){
        for (int i = 0; i < numPaises - 1; i++) {
          int maior = i;
          for (int j = i + 1; j < numPaises; j++) {
      
            if (pais[maior].ouro < pais[j].ouro){
                maior = j;
            } else if(pais[maior].ouro == pais[j].ouro){
                if(pais[maior].prata < pais[j].prata){
                    maior = j;
                } else if(pais[maior].prata == pais[j].prata){
                    if(pais[maior].bronze < pais[j].bronze){
                        maior = j;
                    } else if(pais[maior].bronze == pais[j].bronze){
                        if(strcmp(pais[j].nome, pais[maior].nome) < 0){
                            maior = j;
                        }
                    }
                }
              
          } 
        }
        Pais tmp = pais[i];
        pais[i] = pais[maior];
        pais[maior] = tmp;
        
    }
}

int main(){
    
    int numPaises;
    scanf("%d", &numPaises);
    Pais pais[numPaises];
    for(int i = 0; i < numPaises; i++){
        scanf("%s %d %d %d", pais[i].nome, &pais[i].ouro, &pais[i].prata, &pais[i].bronze);
    }
    InsertionSort(pais, numPaises);
    for(int i = 0; i < numPaises; i++){
        printf("%s %d %d %d\n", pais[i].nome, pais[i].ouro, pais[i].prata, pais[i].bronze);
    }

    return 0;
}