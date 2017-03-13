# NCAA 2017

Predict the 2017 NCAA Men's Basketball Tournament.

## Data

Sports data analyst [Ken Pomeroy](http://kenpom.com) uses information from thousands of NCAA basketball games to create talent ratings for all of the teams in the country. Given this information it is possible to make informed predictions about individual games, even if the two teams have yet to play each other.

## Predicting the Tournament

Your job is to determine the chances for each team to win the entire tournament. You will use a [Monte Carlo Simulation](http://www.solver.com/monte-carlo-simulation-overview#What_is_Monte_Carlo_Simulation) of the tournament, by simulating each of the 63 games based on the predicted team winning percentages lots and lots of times and collecting the results.

The teams, regions, seeds, and Ken Pomeroy's numbers are located in `2017.csv`. The two numbers for each team are `AdjEm` (Adjusted Efficiency Margin) and `AdjT` (Adjusted Tempo). Using these two numbers and the equations located in `bracket.html` we can find the `Expected Winning Percentage` for any team playing any other.

### Predicting a Game

Once a winning percentage is determined a biased dice roll each time our simulation runs will pick the winner that time. Once enough simulations have been done, the average probability of a team winning the entire tournament can be determined.

The winning percentage `WP` will be a number in the range [0, 1]. To determine the winner of a game in a given turn of the simulation compare this number to a random number `r`. If `r` is <= `WP` then Team A wins the game. Otherwise Team B wins the game. For example, if Team A would beat Team B 75% of the time, the random number 0.3676376 would predict a win by Team A and the random number .818228 would predict a win by Team B. This process will result in Team A winning approximately 75% of the simulated matchups with Team B.

### Setting up the Bracket

Open `bracket.pdf`. Make sure to set up the initial state of the tournament correctly. Teams are separated into one of 4 regions: East, West, South, and MidWest. Each of the teams in a region is given a seed. The lower the seed, the better the team. The teams are pitted based on their seed, a 1 seed always plays a 16 seed first, and then would play the winner of the 8 vs. 9 seed matchup, and so on. You must carefully set up your program to create these specific matchups and not others. The winners of each region meet in the Final Four, with the South playing the West and the East playing the Midwest. The winners of those two games then play for the National Championship.