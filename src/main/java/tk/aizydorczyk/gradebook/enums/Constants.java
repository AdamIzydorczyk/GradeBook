package tk.aizydorczyk.gradebook.enums;

public enum Constants {
	MAIN_VIEW_PATCH("view/mainLayout.fxml");

	private final String constant;

	Constants(String constant) {
		this.constant = constant;
	}

	public String getConstant() {
		return constant;
	}
}
