import java.util.*;


public class Tournament {
	public static void main(String args[]) {
		Region east = new Region("East");
		east.loadTeams();
		Region west = new Region("West");
		west.loadTeams();
		Region midwest = new Region("Midwest");
		midwest.loadTeams();
		Region south = new Region("South");
		south.loadTeams();
		ArrayList<Team> percentages = new ArrayList<Team>();
		
		for (int i = 0; i < 1000000; i++) {
			Game semiFinal1 = new Game();
			semiFinal1.setTeams(east.hostBracket(), west.hostBracket());
			Game semiFinal2 = new Game();
			semiFinal2.setTeams(midwest.hostBracket(), south.hostBracket());
			
			Game finals = new Game();
			finals.setTeams(semiFinal1.calculateWinner(), semiFinal2.calculateWinner());
			
			finals.calculateWinner();
		}
		
		for (int i = 0; i < east.getTeams().size(); i++) {
			percentages.add(east.getTeams().get(i));
		}
		for (int i = 0; i < south.getTeams().size(); i++) {
			percentages.add(south.getTeams().get(i));
		}
		for (int i = 0; i < west.getTeams().size(); i++) {
			percentages.add(west.getTeams().get(i));
		}
		for (int i = 0; i < midwest.getTeams().size(); i++) {
			percentages.add(midwest.getTeams().get(i));
		}
		
		Collections.sort(percentages, new Comparator<Team>() {
	        public int compare(Team p1, Team p2) {
	            return Double.compare(p2.winPercentage(), p1.winPercentage());
	        }

	    });
		
		for (int i = 0; i < percentages.size(); i++) {
			System.out.println((i+1) + ": " + percentages.get(i).getName() + " wins about " + percentages.get(i).winPercentage()*100 + "% of their games.");
		}
		
		
		

	}
}
