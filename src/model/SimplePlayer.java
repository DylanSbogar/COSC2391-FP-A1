package model;

import model.enumeration.BetType;
import model.interfaces.Player;

public class SimplePlayer implements Player {

	private String playerId;
	private String playerName;
	private int points;
	private int bet;
	private BetType betType;

	public SimplePlayer(String playerId, String playerName, int points) {
		this.playerId = playerId;
		this.playerName = playerName;
		this.points = points;
	}

	@Override
	public String getPlayerName() {
		return playerName;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	@Override
	public int getPoints() {
		return points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String getPlayerId() {
		return playerId;
	}

	@Override
	public boolean setBet(int bet) {
		// only set the players bet if their bet is above that of 0. Also return true so
		// we know it was successful.
		if (bet > 0) {
			this.bet = bet;
			return true;
		}
		return false;
	}

	@Override
	public int getBet() {
		return bet;
	}

	@Override
	public void setBetType(BetType betType) {
		this.betType = betType;
	}

	@Override
	public BetType getBetType() {
		return betType;
	}

	@Override
	public void resetBet() {
		// set the bet to 0 for the next round. Will be called at the end of a round to
		// reset all player's bets in case they dont want to play another round.
		bet = 0;
	}

	public String toString() {
		// formatting for when we print out the updated player results with new points
		// when we call the result method.
		return "Player: id=" + getPlayerId() + ", name=" + getPlayerName() + ", bet=" + getBet() + ", betType="
				+ getBetType() + ", points=" + getPoints() + "\n";

	}
}
