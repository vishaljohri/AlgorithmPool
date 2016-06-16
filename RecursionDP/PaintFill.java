
import java.util.Arrays;

public class PaintFill {
	
	void fillColor(String screen[][], int x, int y, String newColor, String originalColor)  {
		
		//invalid case
		if(x < 0 || x >= screen.length || y < 0 || y >= screen[0].length)
			return;         
		
		if(screen[x][y] == originalColor)
			screen[x][y]= newColor;
		else
			return;
		
		fillColor(screen, x-1, y, newColor, originalColor);
		fillColor(screen, x+1, y, newColor, originalColor);
		fillColor(screen, x, y-1, newColor, originalColor);
		fillColor(screen, x, y+1, newColor, originalColor);
		
		
	}

	public static void main(String[] args) {
		PaintFill fill = new PaintFill();
		String screen[][] = new String[5][5];
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				screen[i][j] = "R";
			}
		}
		
		for(int i = 0; i <= 4; i++) {
			for(int j = 0; j <= 2; j++) {
				screen[i][j] = "B";
			}
		}
		System.out.println("Original screen");
		for(int i = 0; i < 5; i++) {
		System.out.println(Arrays.toString(screen[i]));
		}
		fill.fillColor(screen, 2, 2, "O", "B");
		System.out.println("Modified screen");
		for(int i = 0; i < 5; i++) {
			System.out.println(Arrays.toString(screen[i]));
		}

	}

}
