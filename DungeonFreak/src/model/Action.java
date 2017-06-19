package model;

public interface Action {
	public static final Action NullAction = new Action() {
		@Override
		public void execute() {}
	};

	void execute();
}
