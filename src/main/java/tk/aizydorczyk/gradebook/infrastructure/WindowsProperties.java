package tk.aizydorczyk.gradebook.infrastructure;

public enum WindowsProperties {
	LOGIN_LAYOUT_SCALE(600, 380), STUDENT_LAYOUT_SCALE(610, 435), TEACHER_LAYOUT_SCALE(1065, 435);

	private final int width;
	private final int height;

	WindowsProperties(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
