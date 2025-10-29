import java.util.Scanner; 

public class Main {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt(); 
	
		int[][] arr = new int[N][3]; 

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				arr[i][j] = sc.nextInt(); 
			}
		}

		int[][] df = new int[3][N];  
		for(int i=0; i<3; i++) {
			df[i][0] = arr[0][i]; //초기값 설정
		}
		
		for(int c=1; c<N; c++) {
			for(int r=0; r<3; r++) {
				int last = 0; 
				
				switch(r) {
				case 0:
					if(df[1][c-1] > df[2][c-1]) {
						last = df[2][c-1]; 
					}else {last = df[1][c-1];} 
					break; 
					
				case 1:
					if(df[0][c-1] > df[2][c-1]) {
						last = df[2][c-1]; 
					}else {last = df[0][c-1];}
					break; 
			
				case 2:
					if(df[0][c-1] > df[1][c-1]) {
						last = df[1][c-1]; 
					}else {last = df[0][c-1];}
					break; 
				}
				
				df[r][c] = arr[c][r] + last; 
			}	
		}
		
		int min = df[0][N-1]; 
		
		for(int i=1; i<3; i++) {
			if(min > df[i][N-1]) {
				min = df[i][N-1]; 
			}
		}
		
		System.out.println(min); 
	}
}