package model.enumeration;

import java.util.ArrayList;

import model.interfaces.Player;
import model.interfaces.Slot;

/**
 * Provided enum type for Further Programming representing a type of Bet<br>
 * See inline comments for where you need to provide additional code
 * 
 * @author Caspar Ryan
 * 
 */

public enum BetType {
	RED {
		@Override
		// calculate how many points would be added to a player's balance if their
		// selected betType was the winning one. Created accurately according to table 1
		// in the spec sheet.
		public void applyWinLoss(Player player, Slot winSlot) {
			if (winSlot.getColor() == Color.RED) {
				player.setPoints(player.getBet() * 2);
			}
		}
	},
	BLACK {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {
			// TODO Auto-generated method stub
			if (winSlot.getColor() == Color.BLACK) {
				player.setPoints(player.getBet() * 2);
			}
		}
	},
	ZEROS {
		@Override
		public void applyWinLoss(Player player, Slot winSlot) {
			// TODO Auto-generated method stub
			if (winSlot.getColor() == Color.GREEN0 || winSlot.getColor() == Color.GREEN00) {
				player.setPoints(player.getBet() * Slot.WHEEL_SIZE / 2);
			}
		}
	};
	// TODO finish this class with other enum constants
	/**
	 * This method is to be overridden for each bet type<br>
	 * see assignment specification for betting odds and how win/loss is applied
	 * 
	 * @param player  - the player to apply the win/loss points balance adjustment
	 * @param winSlot - the winning slot the ball landed on
	 */
	public abstract void applyWinLoss(Player player, Slot winSlot);
}