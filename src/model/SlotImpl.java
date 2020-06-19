package model;

import model.enumeration.Color;
import model.interfaces.Slot;

public class SlotImpl implements Slot {

	private int position;
	private Color color;
	private int number;
	static final int WHEEL_SIZE = 38;

	public SlotImpl(int position, Color color, int number) {
		this.position = position;
		this.color = color;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public int getPosition() {
		return position;
	}

	public Color getColor() {
		return color;
	}

	public String toString() {
		// formatting for when we print out the spin and result methods.
		return "Position: " + getPosition() + ", Color: " + getColor() + ", Number: " + getNumber();
	}

	public boolean equals(Slot slot) {
		// checks to see if the slot's color and number are correct with that which was
		// passed into the method.
		if (slot.getColor() == color && slot.getNumber() == number) {
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(java.lang.Object Slot) {
		// true if the slot values are equal according to above equals method

		return false;
	}

	public int hashCode() {
		return number;
	}

}
