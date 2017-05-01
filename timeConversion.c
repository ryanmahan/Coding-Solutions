/*
Solution to https://www.hackerrank.com/challenges/time-conversion
"Time Conversion" 
Given a time in 12-hour AM/PM format, convert it to military (24-hour) time.
*/


int main(){ //converts a HH:MM:SSPM/AM time to a 24 hour time
    char* time = (char *)malloc(10240 * sizeof(char));
    scanf("%s",time);
    int length = sizeof(time)/sizeof(time[0]);
    if(112 == time[length] || 80 == time[length]){
        if(time[0] != '1' || time[1] != '2'){
           time[0] = time[0]+1;
            if(time[1] > 55){
                time[0] = time[0]+1;
                time[1] = time[1]-8;
            } else {
                time[1] = time[1]+2;    
            }
        }
        
    } else {
        if(time[0] == '1' && time[1] == '2'){
            time[0] = '0';
            time[1] = '0';
        }
    }
    
    char* output = (char *)malloc(8 * sizeof(char));
    for(int i = 0; i < length; i++){
        output[i] = time[i];
    }
    printf("%s", output);
}
