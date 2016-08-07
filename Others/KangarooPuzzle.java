
public class KangarooPuzzle {
	
	void solution(int x1, int v1, int x2, int v2) {
		int slowCur, slowSpeed, fastCur, fastSpeed;
        if(v1 <= v2) {
        	slowCur = x1;
            slowSpeed = v1;
            fastCur = x2;
            fastSpeed = v2;
        }
        else {
        	slowCur = x2;
            slowSpeed = v2;
            fastCur = x1;
            fastSpeed = v1;
        }
        if(slowCur == fastCur && slowSpeed == fastSpeed) {
            System.out.print("YES");
            return;
        }
        if(slowCur < fastCur) {
            System.out.print("NO");
            return;
        }
        
        while(fastCur <= slowCur) {
        	if(fastCur == slowCur) {
        		System.out.println("YES");
        		return;
        	}
        	fastCur += fastSpeed;
        	slowCur += slowSpeed;
        }
        
        System.out.print("NO");           
    }
 
	public static void main(String[] args) {
		KangarooPuzzle kp = new KangarooPuzzle();
		kp.solution(0, 2, 4, 1);

	}

}
