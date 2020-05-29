package ProjectFinal.model;

import java.util.ArrayList;
import java.util.Observable;

abstract public class ModelStore extends Observable {
	public abstract ArrayList<? extends Model> getStoreList();
}
