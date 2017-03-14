import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Region {
	private String region;
	private ArrayList<Team> teams;
	
	public Region(String regiona) {
		region = regiona;
	}
	
	public void loadTeams() {
		try {
			Scanner scan = new Scanner(new File("2017.csv"));
			String line = scan.next();
			
			this.teams = new ArrayList<Team>();
			
			
			while (scan.hasNext()) {
				if (line.equals(region)) {
					line = scan.next();
					for (int i = 0; i < 16; i++) {
						teams.add(new Team(Integer.parseInt(line.split(",")[0]), line.split(",")[1], Double.parseDouble(line.split(",")[2]), Double.parseDouble(line.split(",")[3])));
						line = scan.next();
					}
				}
				line = scan.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Team> getTeams() {
		return this.teams;
	}
	
	public Team hostBracket() {
		// first round
		Game game1 = new Game();
		game1.setTeams(teams.get(0), teams.get(1));
		Game game2 = new Game();
		game2.setTeams(teams.get(2), teams.get(3));
		Game game3 = new Game();
		game3.setTeams(teams.get(4), teams.get(5));
		Game game4 = new Game();
		game4.setTeams(teams.get(6), teams.get(7));
		Game game5 = new Game();
		game5.setTeams(teams.get(8), teams.get(9));
		Game game6 = new Game();
		game6.setTeams(teams.get(10), teams.get(11));
		Game game7 = new Game();
		game7.setTeams(teams.get(12), teams.get(13));
		Game game8 = new Game();
		game8.setTeams(teams.get(14), teams.get(15));
		
		//second round
		Game secondGame1 = new Game();
		secondGame1.setTeams(game1.calculateWinner(), game2.calculateWinner());
		Game secondGame2 = new Game();
		secondGame2.setTeams(game3.calculateWinner(), game4.calculateWinner());
		Game secondGame3 = new Game();
		secondGame3.setTeams(game5.calculateWinner(), game6.calculateWinner());
		Game secondGame4 = new Game();
		secondGame4.setTeams(game7.calculateWinner(), game8.calculateWinner());
		
		// semifinals 
		Game semi1 = new Game();
		semi1.setTeams(secondGame1.calculateWinner(), secondGame2.calculateWinner());
		Game semi2 = new Game();
		semi2.setTeams(secondGame3.calculateWinner(), secondGame4.calculateWinner());
		
		//finals
		Game finals = new Game();
		finals.setTeams(semi1.calculateWinner(), semi2.calculateWinner());
		return finals.calculateWinner();
		
		
	}
	
}
