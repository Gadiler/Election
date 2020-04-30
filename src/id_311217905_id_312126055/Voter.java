package id_311217905_id_312126055;

import java.util.ArrayList;
import java.util.Random;

public class Voter extends Person implements Cloneable{

	protected static Random r = new Random();
	protected Boolean fInsulation;
	protected Boolean fProtectiveSuit;
	protected Boolean fMilitaryVoter = false;
	protected PollingStation myPollingStation;

	public Voter(String name, long id, String birthYear, PollingStation myPollingStation) throws Exception {
		super(name, id, birthYear);
		setBirthYear(birthYear);
		this.fInsulation = r.nextBoolean();
		this.fProtectiveSuit = r.nextBoolean();
		setPollingStation(myPollingStation);
	}

	public Voter(String name, long id, String birthYear, ArrayList<PollingStation> allPollingStations) throws Exception {
		super(name, id, birthYear);
		setBirthYear(birthYear);
		this.fInsulation = r.nextBoolean();
		this.fProtectiveSuit = r.nextBoolean();
		setPollingStation(allPollingStations);
	}

	private boolean setPollingStation(ArrayList<PollingStation> allPollingStations) {
		if (fInsulation && !fMilitaryVoter) {
			this.fProtectiveSuit = true;
			for (int i = 0; i < allPollingStations.size(); i++) {
				if (allPollingStations.get(i) instanceof CoronaPollingStation) {
					this.myPollingStation = new CoronaPollingStation((CoronaPollingStation) allPollingStations.get(i + r.nextInt(3)));
					return true;
				}
			}
		}
		if (!fInsulation && fMilitaryVoter) {
			for (int i = 0; i < allPollingStations.size(); i++) {
				if (allPollingStations.get(i) instanceof MilitaryPollingStation) {
					this.myPollingStation = new MilitaryPollingStation((MilitaryPollingStation) allPollingStations.get(i + r.nextInt(3)));
					return true;
				}
			}
		}
		if (fInsulation && fMilitaryVoter) {
			for (int i = 0; i < allPollingStations.size(); i++) {
				if (allPollingStations.get(i) instanceof CoronaMilitaryPollingStation) {
					this.myPollingStation = new CoronaMilitaryPollingStation((CoronaMilitaryPollingStation)allPollingStations.get(i));
					return true;
				}
			}
		}
		if (!fInsulation && !fMilitaryVoter) {
			this.myPollingStation = new PollingStation(allPollingStations.get(r.nextInt(10)));
			return true;
		}
		return false;
		
	}

	//	checking person
	private void setBirthYear(String birthYear) throws Exception {
		int year = Integer.parseInt(birthYear);
		if (year >= 1999 && year <= 2002) {
			fMilitaryVoter = true;
		}
	}

	public boolean setPollingStation(PollingStation myPollingStation) throws Exception {
		if (myPollingStation instanceof CoronaPollingStation) {
			this.fProtectiveSuit = true;
			this.fInsulation = true;
		}if (myPollingStation instanceof MilitaryPollingStation) {
			this.fMilitaryVoter = true;
		} 
		this.myPollingStation = myPollingStation.clone();
		return true;
	}

	public PollingStation getMyPollingStation() {
		return myPollingStation;
	}

	@Override
	public Voter clone() throws CloneNotSupportedException {
		Voter temp = (Voter)super.clone();
		temp.myPollingStation = myPollingStation.clone();
		return temp;
	}
	
	@Override
	public String toString() {
		return "Voter name = " + name + ", id = " + id + ", birthYear = " + birthYear + ", Insulation = " + fInsulation
				+ ", ProtectiveSuit: " + fProtectiveSuit + ", myPollingStation = " + myPollingStation + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Voter other = (Voter) obj;
		if (birthYear == null) {
			if (other.birthYear != null)
				return false;
		} else if (!birthYear.equals(other.birthYear))
			return false;
		if (fInsulation == null) {
			if (other.fInsulation != null)
				return false;
		} else if (!fInsulation.equals(other.fInsulation))
			return false;
		if (fMilitaryVoter == null) {
			if (other.fMilitaryVoter != null)
				return false;
		} else if (!fMilitaryVoter.equals(other.fMilitaryVoter))
			return false;
		if (fProtectiveSuit == null) {
			if (other.fProtectiveSuit != null)
				return false;
		} else if (!fProtectiveSuit.equals(other.fProtectiveSuit))
			return false;
		if (id != other.id)
			return false;
		if (myPollingStation == null) {
			if (other.myPollingStation != null)
				return false;
		} else if (!myPollingStation.equals(other.myPollingStation))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
