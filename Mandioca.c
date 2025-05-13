#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <string.h>

typedef struct{
    int peso;
} sacas;

int acharPares(int peso){
    int nPares = 0;
    while(peso > 0){
        if((peso%10)%2 == 0){
            nPares++;
        }
        peso = peso/10;
    }
    return nPares;
}

int main(){
    int nSacas;
    int posTaina;
    int quantTaina;
    scanf("%d %d", &nSacas, &posTaina);
    sacas saca[100000];
    for(int i = 0; i < nSacas; i++){
        scanf("%d", &saca[i].peso);
    }

    
    for(int i = 0; i < posTaina; i++){
        int maiorSaca = 0;
        for(int j = 0; j < nSacas; j++){
            if(saca[j].peso > saca[maiorSaca].peso){
                maiorSaca = j;
            }
        }
        int quilosRetirados = acharPares(saca[maiorSaca].peso);
        saca[maiorSaca].peso = saca[maiorSaca].peso - quilosRetirados;

        if(i == posTaina-1){
            quantTaina = quilosRetirados;
            printf("%d", quantTaina);
        }
    }
    

}