import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		
		int N = sc.nextInt(); 
		int[] df = new int[N+1]; 
		
		for(int i=0; i<N+1; i++) { //df배열의 모든 요소의 값을 -1로 초기화하기
			df[i] = -1; 
		}
		
		if(N>=3) {
			df[3] = 1; 
		}
		
		if(N>=5) {
			df[5] = 1; 
		}
		
		for(int i=6; i<=N; i++) {
			if(df[i-3] == -1 && df[i-5] == -1) {
				continue;
			}
			else {
				if(df[i-3] == -1) {
					df[i] = df[i-5] + 1; 
				}else if(df[i-5] == -1){
					df[i] = df[i-3] + 1;
				}else {
					df[i] = Math.min(df[i-3], df[i-5]) + 1; 
				}
			}
		}
		
		System.out.println(df[N]);
		sc.close(); 
	} 
}
