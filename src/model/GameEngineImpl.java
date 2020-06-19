package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

//import jdk.nashorn.internal.codegen.CompilerConstants.Call;
import model.enumeration.BetType;
import model.enumeration.Color;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

public class GameEngineImpl implements GameEngine {

	ArrayList<Slot> slots = new ArrayList<Slot>();
	ArrayList<Player> playerList = new ArrayList<Player>();
	ArrayList<GameEngineCallback> gameEngineCallbackList = new ArrayList<GameEngineCallback>();
	Random rand = new Random();

	@Override
	public void spin(int initialDelay, int finalDelay, int delayIncrement) {
		getWheelSlots();
		int i = rand.nextInt(38);

		while (initialDelay <= finalDelay) {
			// call the next slot, which also logs the result of the slot
			for (GameEngineCallback gec : gameEngineCallbackList) {
				gec.nextSlot(slots.get(i), this);
			}
			i++;
			initialDelay += delayIncrement;

			// if we reach the final position of the wheel (pos.36, number 1), start the
			// counter at 0 so we can continue to spin
			if (i == slots.size()) {
				i = 0;
			}

			// sleep method to delay the time between each iteration of the method to give
			// the illusion of the wheel slowing down as we approach the result
			try {
				Thread.sleep(initialDelay);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// record the last slot that was passed through as the winning slot and log the
		// result.
		Slot winSlot = slots.get(i);
		calculateResult(winSlot);

		for (GameEngineCallback gec : gameEngineCallbackList) {
			gec.result(winSlot, this);
		}

	}

	@Override
	public void calculateResult(Slot winningSlot) {
		// Iterate through players and apply win/loss point balances (via
		// BetType.applyWinLoss(Player player, Slot winSlot))
		for (Player p : playerList) {
			System.out.println(p.getBetType());
		}
		// if the player's betType does not match that of the winning Slot's type; the
		// player loses the amount of points that they bet.

	}

	@Override
	public void addPlayer(Player player) {
		// add a player to the collection of players
		playerList.add(player);
	}

	@Override
	public Player getPlayer(String id) {
		// Go through the list of players, and if the player we are looking for is
		// found, then return that player.
		for (Player p : playerList) {
			if (p.getPlayerId() == id) {
				return p;
			}
		}
		return null;
	}

	@Override
	public boolean removePlayer(Player player) {
		// Go through the list of players, and if the player we are searching for is
		// found, then remove it.
		if (playerList.contains(player)) {
			playerList.remove(player);
			return true;
		}
		return false;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		gameEngineCallbackList.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// go through the list of callbacks and if the callback that we are searching
		// for is created, then remove it and return true so we know it was found
		if (gameEngineCallbackList.contains(gameEngineCallback)) {
			gameEngineCallbackList.remove(gameEngineCallback);
			return true;
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		// retrieve the complete list of players
		return playerList;
	}

	@Override
	public boolean placeBet(Player player, int bet, BetType betType) {
		// if the players inputted bet is over the minimum of 0, set the players bet and
		// return true so we know it was successful.
		if (player.getBet() > 0) {
			bet = player.getBet();
			return true;
		}
		return false;
	}

	@Override
	public Collection<Slot> getWheelSlots() {
		// since with every spin method we will be calling this method, start by
		// clearing the list of slots so we aren't continuously adding another 38 slots
		// to it each time it is called.
		slots.clear();

		// create 38 unique slot objects to the list to represent each slot on the
		// roulette wheel
		slots.add(new SlotImpl(0, Color.GREEN00, 00));
		slots.add(new SlotImpl(1, Color.RED, 27));
		slots.add(new SlotImpl(2, Color.BLACK, 10));
		slots.add(new SlotImpl(3, Color.RED, 25));
		slots.add(new SlotImpl(4, Color.BLACK, 29));
		slots.add(new SlotImpl(5, Color.RED, 12));
		slots.add(new SlotImpl(6, Color.BLACK, 8));
		slots.add(new SlotImpl(7, Color.RED, 19));
		slots.add(new SlotImpl(8, Color.BLACK, 31));
		slots.add(new SlotImpl(9, Color.RED, 18));
		slots.add(new SlotImpl(10, Color.BLACK, 6));
		slots.add(new SlotImpl(11, Color.RED, 21));
		slots.add(new SlotImpl(12, Color.BLACK, 33));
		slots.add(new SlotImpl(13, Color.RED, 16));
		slots.add(new SlotImpl(14, Color.BLACK, 4));
		slots.add(new SlotImpl(15, Color.RED, 23));
		slots.add(new SlotImpl(16, Color.BLACK, 35));
		slots.add(new SlotImpl(17, Color.RED, 14));
		slots.add(new SlotImpl(18, Color.BLACK, 2));
		slots.add(new SlotImpl(19, Color.GREEN0, 0));
		slots.add(new SlotImpl(20, Color.BLACK, 28));
		slots.add(new SlotImpl(21, Color.RED, 9));
		slots.add(new SlotImpl(22, Color.BLACK, 26));
		slots.add(new SlotImpl(23, Color.RED, 30));
		slots.add(new SlotImpl(24, Color.BLACK, 11));
		slots.add(new SlotImpl(25, Color.RED, 7));
		slots.add(new SlotImpl(26, Color.BLACK, 20));
		slots.add(new SlotImpl(27, Color.RED, 32));
		slots.add(new SlotImpl(28, Color.BLACK, 17));
		slots.add(new SlotImpl(29, Color.RED, 5));
		slots.add(new SlotImpl(30, Color.BLACK, 22));
		slots.add(new SlotImpl(31, Color.RED, 34));
		slots.add(new SlotImpl(32, Color.BLACK, 15));
		slots.add(new SlotImpl(33, Color.RED, 3));
		slots.add(new SlotImpl(34, Color.BLACK, 24));
		slots.add(new SlotImpl(35, Color.RED, 36));
		slots.add(new SlotImpl(36, Color.BLACK, 13));
		slots.add(new SlotImpl(37, Color.RED, 1));

		// return the completed list for other methods to call upon.
		return slots;
	}

}
