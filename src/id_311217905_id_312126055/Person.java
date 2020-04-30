package id_311217905_id_312126055;

public class Person implements Cloneable {
	protected final static int LIMITED_YEAR = 2002;
	protected String name;
	protected long id;
	protected String birthYear;
	protected boolean adult = true;

	public Person(String name, long id, String birthYear) throws Exception {
		this.name = name;
		setId(id);
		setBirthYear(birthYear);
	}

	private void setId(long id) throws Exception {
		if (!(id < 1000000000 && id >= 100000000)) { // Lowest & highest id.
			throw new Exception("setIdException: Valid number! (17)");
		}
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public long getId() {
		return id;
	}

	private void setBirthYear(String birthYear) throws Exception {
		int year = Integer.parseInt(birthYear);
		if (year > LIMITED_YEAR) {
			adult = false;
//			throw new Exception("setBirthYearException: Voter is not valid for vote!");
		}		
		this.birthYear = birthYear;
	}

	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
