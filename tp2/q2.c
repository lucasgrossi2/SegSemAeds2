#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct {
    char* show_id;
    char* type;
    char* title;
    char* director;
    char** cast;
    char* country;
    char* date_added;
    int release_year;
    char* rating;
    char* duration;
    char** listed_in;
} shows;


shows ler(char* base_id) {
    
}

void imprimir(char* base_id) {

}

int main() {
    char input[100];
    scanf("%s", input);
    while (strcmp(input, "FIM") != 0) {
        imprimir(input);
        scanf("%s", input);
    }
    return 0;
}
