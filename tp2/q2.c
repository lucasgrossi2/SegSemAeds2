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

char* separador(char* line){
    char* token = malloc(1024 * sizeof(char));
    if(line[0] == ','){
        token = "NaN";
        return token;
    } else {
        int counter = 0;
        while(line[counter] != ','){
            token[counter] = line[counter];
            counter++;
        }
        token[counter] = '\0'; 

        int offset = counter + 1;
        memmove(line, line + offset, strlen(line) - offset + 1);  
        return token;
    }
}

char separadorAspas(char* line){

}

shows ler(char* base_id) {
    FILE *file = fopen("disneyplus.csv", "r");
    char line[1024];
    while (fgets(line, sizeof(line), file)) {
        line[strcspn(line, "\n")] = '\0';
        char *firstField = strtok(line, ",");
        if(strcmp(firstField, base_id) == 0){
            shows show = {0};
            char* token;
            for(int i = 0; i < 11; i++){
                switch(i){
                    case 4:
                    case 10:
                        token = separadorAspas(line);
                    default:
                        token = separador(line);
                }
                switch(i){
                    case 0: //id
                        strcpy(show.show_id, token);
                        break;
                    case 1: //type
                        strcpy(show.type, token);
                        break;
                    case 2: //title
                        strcpy(show.title, token);
                        break;
                    case 3: //director
                        strcpy(show.director, token);
                        break;
                    case 4: //cast !!!!!
                        break;
                    case 5: //country
                        strcpy(show.country, token);
                        break;
                    case 6: //date_added
                        strcpy(show.date_added, token);
                        break;
                    case 7: //release_year !!!!!
                        int year = atoi(token);
                        strcpy(show.release_year, year);
                        break;
                    case 8: //rating
                        strcpy(show.rating, token);
                        break;
                    case 9: //duration
                        strcpy(show.duration, token);
                        break;
                    case 10: //listed_in !!!!!
                        break;
                }
            }
        }
    }
}

void imprimir(char* base_id) {
    ler(base_id);
    //printf ........
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
