
public class Main {
	public static void main(String[] args) throws Exception {
	Game game = new Game();
	game.initField();
	boolean decided=false;
	while(decided==false){
		int col;
		game.printField();
		System.out.println("Spieler "+ game.currentPlayer+" ist am Zug");
		System.out.println("Bitte Spalte eingeben:");
		System.out.println("Gebe eine Zahl zwischen 1 und 8 ein:");
		col=game.insertNumber();
		game.setToken(col-1);
		decided=game.testForWin(col-1);
	}
	game.printField();
	System.out.println("Spieler "+game.previousPlayer+" hat gewonnen.");
	}
}
