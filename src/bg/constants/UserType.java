package bg.constants;

public enum UserType {
	
	USER("user"),
	EDITOR("editor"),
	CHIEF_EDITOR("chiefeditor");
	
	
	
	private UserType(String name) {
		this.name = name;
	}
	String name;
	
	
	public String getName(){
		return name ();
	}


}
