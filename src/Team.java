
public class Team {
	private String name;
	private double AdjEm;
	private double AdjT;
	private int seed;
	private double wins;
	private double games;
	
	public Team(int seed, String name, double adjEm, double adjT) {
		this.name = name;
		this.seed = seed;
		this.AdjEm = adjEm;
		this.AdjT = adjT;
		this.wins = 0;
		this.games = 0;
		
	}
	
	public String getName() {
		return this.name;
	}
	
	public double getAdjEm() {
		return this.AdjEm;
	}
	
	public double getAdjT() {
		return this.AdjT;
	}
	
	public void addWin() {
		this.wins = this.wins + 1.0;
	}
	
	public void addGame() {
		this.games = this.games + 1.0;
	}
	
	public double winPercentage() {
		//System.out.println(this.getName() + " wins about " + this.wins/this.games);
		return (this.wins/this.games);
	}
}
