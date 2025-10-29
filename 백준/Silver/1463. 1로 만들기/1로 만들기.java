import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt();
		
		int[] df = new int[N+1]; 
		df[0] = 0; 
		df[1] = 0; 
	
		//df배열 값 채우기 
		for(int i = 2; i <= N; i++) { // 배열 크기를 고려하여 N까지 반복
		   
		    df[i] = df[i-1] + 1; 
		    
		    if(i % 2 == 0) {
		    	df[i] = Math.min(df[i], df[i/2] + 1);
		    }
		    
		    if(i % 3 == 0) {
		    	df[i] = Math.min(df[i], df[i/3] + 1);		    }
		}
		
		System.out.println(df[N]); 
	}

}
