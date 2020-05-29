package ProjectFinal.model;

public abstract class Model extends java.util.Observable{
	public abstract Model updateModel(Model x);
	public abstract <T extends ModelStore> T returnStore();
}
