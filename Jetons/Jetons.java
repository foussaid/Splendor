package fr.uge.splendor.Jetons;
import java.util.*;

/*Un jeton est caractérisés par une couleur*/

public record Jetons(String color) {
	
	public Jetons{
		Objects.requireNonNull(color, "color ne doit pas être null");
	}
}
