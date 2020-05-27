package interfaces;

public interface Messageable {
	void showMessage(String str) ;
	
	String getString(String str) ;
	
	long getLong(String id);

	Enum<?> getEnum(String string);
	
//	String shoeMessage(Object o);
}
