
public class Game {
	private final int noRows = 9;
	private final int noCols = 8;
	private int row;
	private char[][] field = new char[noRows][noCols];
	char currentPlayer = 'X';
	char previousPlayer = 'O';

	public void initField() {
		for (int i = 0; i < noRows; i++)
			for (int j = 0; j < noCols; j++)
				field[i][j] = '_';
	}

	public void printField() {
		for (int i = 0; i < noRows; i++) {
			if (i == noRows - 1) {
				for (int j = 0; j < noCols; j++)
					System.out.print(j + 1);
			} else {
				for (int j = 0; j < noCols; j++)
					System.out.print(field[i][j]);
				System.out.println();
			}
		}
		System.out.println();
	}

	public void setToken(int col) {
		for (int i = 7; i >= 0; i--) {
			if (field[i][col] == '_') {
				field[i][col] = currentPlayer;
				row = i;
				break;
			}
		}
	}

	public void changeCurrentPlayer() {
		char x = previousPlayer;
		previousPlayer = currentPlayer;
		currentPlayer = x;
	}

	public boolean testForWin(int col) {
		char winPlayer = currentPlayer;
		changeCurrentPlayer();
		int inARow = 0;
		
		
		inARow = 1; // test ou
		int i = row + 1;
		int j = col;
		while (i <= 7) {
			if (field[++i][j] == winPlayer)
				inARow++;
			else
				break;
		}
		i = row ;
		j = col;
		while (i >= 0 ) {
			if (field[i--][j] == winPlayer)
				inARow++;
			else
				break;
		}
		if (inARow >= 4)
			return true;
		
		inARow = 1; // test lr
		i = row;
		j = col + 1;
		while ((j <= 7)) {
			if (field[i][++j] == winPlayer)
				inARow++;
			else
				break;
		}
		i = row;
		j = col - 1;
		while (j >= 0) {
			if (field[i][j--] == winPlayer)
				inARow++;
			else
				break;
		}
		if (inARow >= 4)
			return true;
		
		inARow = 1; // test orul
		i = row + 1;
		j = col + 1;
		while ((i <= 7) && (j <= 7)) {
			if (field[++i][++j] == winPlayer)
				inARow++;
			else
				break;
		}
		i = row - 1;
		j = col - 1;
		while (i >= 0 && j >= 0) {
			if (field[i--][j--] == winPlayer)
				inARow++;
			else
				break;
		}
		if (inARow >= 4)
			return true;
		
		inARow = 1; // test luro
		i = row + 1;
		j = col - 1;
		while (i <= 7 && j >= 0) {
			if (field[i++][j--] == winPlayer)
				inARow++;
			else
				break;
		}
		i = row - 1;
		j = col + 1;
		while (i >= 0 && j <= 7) {
			if (field[i--][j++] == winPlayer)
				inARow++;
			else
				break;
		}
		if (inARow >= 4)
			return true;

		return false;
	}

	public boolean validPlay(int col) {
		
		
		if ((col >= 1) && (col <= 8)){
			if (field[0][col - 1] == '_')
				return true;
		}
		System.out.println("Falsche Zahl eingegeben!!!");
		System.out.println("Gebe eine Zahl zwischen 1 und 8 ein:");
		return false;
		
	}
	
	public int insertNumber() throws Exception{
		int col;
		do{
			
			col=System.in.read();
			col=col-48;
		}while (validPlay(col) == false);
		 
			
		return col;
			
	}
}
