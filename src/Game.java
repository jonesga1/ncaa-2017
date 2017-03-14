import java.util.Random;

public class Game {
	private Team teamA = null;
	private Team teamB = null;
	
	public void setTeams(Team teamAa, Team teamBa) {
		teamA = teamAa;
		teamB = teamBa;
	}
	
	 public static double erf(double z) {
	        double t = 1.0 / (1.0 + 0.5 * Math.abs(z));

	        // use Horner's method
	        double ans = 1 - t * Math.exp( -z*z   -   1.26551223 +
	                                            t * ( 1.00002368 +
	                                            t * ( 0.37409196 + 
	                                            t * ( 0.09678418 + 
	                                            t * (-0.18628806 + 
	                                            t * ( 0.27886807 + 
	                                            t * (-1.13520398 + 
	                                            t * ( 1.48851587 + 
	                                            t * (-0.82215223 + 
	                                            t * ( 0.17087277))))))))));
	        if (z >= 0) return  ans;
	        else        return -ans;
	    }
	
	public double pointDifferential() {
		double top1 = (this.teamA.getAdjEm() - this.teamB.getAdjEm());
		double top2 = (this.teamA.getAdjT() + this.teamB.getAdjT());
		return (top1 * top2)/200;
	}
	
	public double calculateProbabilityOfWin() {
		double probability = (1 + erf(-this.pointDifferential()))/(22*Math.sqrt(2));
		return probability;
	}
	
	public Team calculateWinner() {
		Random rand = new Random();
		int  n = rand.nextInt(100) + 1;
		double actual = ((double) n)/100;
		if (actual < this.calculateProbabilityOfWin()) {
			//System.out.println(teamB.getName() + " defeats " + teamA.getName());
			this.teamB.addWin();
			this.teamB.addGame();
			this.teamA.addGame();
			return this.teamB;
		} else {
			//System.out.println(teamA.getName() + " defeats " + teamB.getName());
			this.teamA.addWin();
			this.teamB.addGame();
			this.teamA.addGame();
			return this.teamA;
		}
	}

}
