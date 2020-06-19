package view;

import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import model.interfaces.Slot;
import view.interfaces.GameEngineCallback;

/**
 * 
 * Skeleton/Partial example implementation of GameEngineCallback showing Java
 * logging behaviour
 * 
 * @author Caspar Ryan
 * @see view.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback {
	private static final Logger logger = Logger.getLogger(GameEngineCallback.class.getName());

	public GameEngineCallbackImpl() {
		// FINE shows wheel spinning output, INFO only shows result
		logger.setLevel(Level.FINE);
	}

	@Override
	public void nextSlot(Slot slot, GameEngine engine) {
		// display the next slot and its relevant information accurate to the outputTrace.
		logger.log(Level.FINE, String.format("Next Slot: %s", slot.toString()));
	}

	@Override
	public void result(Slot result, GameEngine engine) {
		// create a string that we can use to add each player's information to so we can
		// format the result method correctly and accurate to the outputTrace
		String playerString = new String();
		logger.log(Level.INFO, String.format("RESULT=%s\n", result.toString()));
		logger.log(Level.INFO, String.format("FINAL PLAYER POINT BALANCES"));
		for (Player player : engine.getAllPlayers()) {
			playerString += player.toString();
		}
		logger.log(Level.INFO, String.format("\n" + playerString));
	}
}
