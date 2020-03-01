package fcfs;
  
import java.text.ParseException; 
  
class FCFS { 

    //Function to calculate average time  
    static void findavgTime(int rowCount, int bt[]) { 
        int wt[] = new int[rowCount], tat[] = new int[rowCount]; 
        int total_wt = 0, total_tat = 0; 
  
        //find waiting time
        // waiting time for first process is 0  
        wt[0] = 0;
        for (int i = 1; i < rowCount; i++) {
            wt[i] = bt[i - 1] + wt[i - 1];
        }
        
        //find turn around time by adding bt[i] + wt[i]
        for (int i = 0; i < rowCount; i++) { 
            tat[i] = bt[i] + wt[i]; 
        } 
  
        //Display processes along with all details  
        System.out.printf("Processes Burst time Waiting"
                       +" time Turn around time\n"); 
  
        // Calculate total waiting time and total turn  
        // around time  
        for (int i = 0; i < rowCount; i++) { 
            total_wt = total_wt + wt[i]; 
            total_tat = total_tat + tat[i]; 
            System.out.printf(" %d ", (i + 1)); 
            System.out.printf("     %d ", bt[i]); 
            System.out.printf("     %d", wt[i]); 
            System.out.printf("     %d\n", tat[i]); 
        } 
        float s = (float)total_wt /(float) rowCount; 
        int t = total_tat / rowCount; 
        System.out.printf("Average waiting time = %f", s); 
        System.out.printf("\n"); 
        System.out.printf("Average turn around time = %d ", t); 
    } 
  
    // Driver code  
    public static void main(String[] args) throws ParseException { 
        //process id's  
        int processes[] = {1, 2, 3}; 
        int rowCount = processes.length; 
  
        //Burst time of all processes  
        int burst_time[] = {10, 5, 8}; 
  
        findavgTime(rowCount, burst_time); 
  
    } 
} 