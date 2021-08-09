/*
typedef struct variable {
    char* name;
    int* value;
}*VARIABLE;

typedef struct guarda{
    TABLE* arrayTable;
    char* arrayVar;
}*GUARDA;*/

/*
GUARDA* create_guarda(TABLE arrayTable, char* arrayVar) {
    
    GUARDA* gu = (GUARDA*) malloc (sizeof(GUARDA));
    gu->arrayTable = (TABLE*) malloc (strlen(arrayTable) + 1);
    gu->arrayVar = (char*) malloc (strlen(arrayVar) + 1);
     
    strcpy(gu->arrayTable, arrayTable);
    strcpy(gu->arrayVar, arrayVar);
 
    return gu;}

TABLE* getGuardaTable (GUARDA gua){
    return strdup(gua->arrayTable);}

char* getGuardaVar (GUARDA gua){
    return strdup(var->value);}
    */

int interpreter (SGR sgr){

    char line[1024];

    char sn[1024];
    char func[1024];
    char Arg[1024];
    char agr1[64],arg2[64],arg3[64];

    int equalSign;

    enum OPERATOR{LT, EQ, GT};//+ = -

    
    hash = g_hash_table_new_full (g_str_hash, g_str_equal,(GDestroyNotify) free,(GDestroyNotify) freeTable);//?

    TABLE* arrayTable;
    char* Var;//guardar variaveis x,y,...

    printf("Command:\n");
    fgets(line,1024,stdin);
    //sscanf(stdin,%c %c %s,var,igual,line2);

    while (!strcmp(line,"exit")){
        //TABLE* old_arrayTable;
        //char* old_var;

        //while(line[strlen(line)-1]==";"){

        if (strrchr(line,"=")!=NULL) equalSign=1;

        if(equalSign){
            strtok(line,"=");            
            strtok(line," ");
            strtok(line,"(");
            strtok(line,",");
            strtok(line,")");
            Var = strdup(strtok(line,";"));
            char* func = "";
            while(func[0]) func = strtok(NULL,";");

            if(stricmp(func,"businesses_started_by_letter")){
                strtok(NULL,";");
                arg2 = strtok(NULL,";");//  "A" 

                arrayTable = business_started_by_letter(sgr,arg2);
            }

            else if(stricmp(func,"business_info")){
                strtok(NULL,",");
                arg2=strtok(NULL,";");

                arrayTable = business_info(sgr,arg2);
            }

            else if(stricmp(func,"businesses_reviewed")){
                strtok(NULL,",");
                arg2=strtok(NULL,";"); 

                arrayTable = businesses_reviewed(sgr,arg2);
            }

            else if(stricmp(func,"business_with_stars_and_city")){//business_with_stars_and_city(SGR sgr, float stars, char* city);
                strtok(NULL,";");
                arg2=strtok(NULL,";");//stars
                arg3=strtok(NULL,";"); //city

                arrayTable = business_with_stars_and_city(sgr,arg2,arg3);
            }

            else if(strimp(func,"top_businesses_by_city")){
                strtok(NULL,",");
                arg2=strtok(NULL,";"); 

                arrayTable = top_businesses_by_city(sgr,arg2);
            }

            else if(stricmp(func,"international_users")){
                
                arrayTable = international_users(sgr);
            }

            else if(strimp(func,"top_businesses_with_category")){
                strtok(NULL,";");
                arg2=strtok(NULL,";");//stars
                arg3=strtok(NULL,";");

                arrayTable = top_businesses_with_category(sgr,arg2,agr3)
            }

            else if(stricmp(func,"reviews_with_word")){//reviews_with_word(SGR sgr,char* word)
                strtok(NULL,",");
                arg2=strtok(NULL,")");

                arrayTable = reviews_with_word(sgr,arg2);
            }

            else if(stricmp(func,"fromCSV")){
                //arg1=strtok(arg,",");// 
                //arg2=strtok(NULL,")");
                strtok(NULL,",");
                arg1=strtok(NULL,")");
                
                FILE *file = fopen(arg1, "r");
                if(file!=NULL){
                fgets(sn,64,file);
                sn = strtok(sn,";");

                arrayTable = fromCSV()
                
                fclose(file);
                } 
            }
            
            //projeção colunas
            else if(stricmp(func,"proj")){ // y = proj(x,cols) 
                arg1=strtok(arg,","); //x
                arg2=strtok(NULL,")");//cols 
            }

            else{ //indexação
                // y = z[1][2] 
                /*arg1=line[4];//z
                arg2=line[7];//1
                arg3=line[10];//2*/

                strtok(NULL," ");
                strtok(NULL,"=");
                arg1=strtok(NULL,"[");
                strtok(NULL,"]");
                arg2=strtok(NULL,"[");
                strtok(NULL,"]")

                TABLE temp = g_hash_table_lookup(hash,arg1);//table para a key z

                if(g_hash_table_lookup(hash,arg1)!=NULL){

                    TABLE temp1 = memalloc(1,1);

                    insereTable(temp1,0,0,tableValue(arg2,arg3));

                    arrayTable = temp1;

                    /*if(g_hash_table_lookup(hash,Var)!=NULL){

                        g_hash_table_remove(hash,Var);    
                    //g_free (arrayTable);
                    //g_free (var);
                    }
                    g_hash_table_insert (hash, g_strdup (Var), g_strdup ());*/
                }
            }
            insereHash(strdup(var),arrayTable);

            //pos++;
        }
        else{// !equalSign
            //show(x)
            if((stricmp(line[0],"s")==0) && (stricmp(line[1],"h")==0) && (stricmp(line[2],"o")==0) && (stricmp(line[3],"w")==0)){
                for(int j=5;j<strlen(line);j++){   //show(x);\0
                    sn[j-5]=line[j];}
                
                sn = strtok(sn,")"); // x
        
                drawTable (g_hash_table_lookup(hash,sn));
            }
            //toCSV(x,;,filepath)
            else if((stricmp(line[0],"t")==0) && (stricmp(line[1],"o")==0) && (stricmp(line[2],"c")==0) && (stricmp(line[3],"s")==0) && (stricmp(line[4],"v")==0)){
                for(int j=6;j<strlen(line);j++){   //show(x);
                    sn[j-6]=line[j];}
                
                sn =strdup (strtok(sn,",")); //x
                arg1 =strdup ( strtok(NULL,","));//delim
                arg2 =strdup ( strtok(NULL,")")); //filepath

                FILE *file = fopen(arg2, "w");
                if(file!=NULL){
                    if(g_hash_table_lookup(hash,sn)!=NULL){
                        toCSV (g_hash_table_lookup(hash,sn),)
                        fclose(file);
                    }
                }
                free(sn);
                free(arg1);
                free(arg2);
                    
            }
        } 
    }
    g_hash_table_destroy(hash);
    return 0;
}

void insereHash (char va, TABLE t){

    if(g_hash_table_lookup(hash,va)!=NULL){
        g_hash_table_remove(hash,Va);
        }
    g_hash_table_insert (hash,Va,t);
}
