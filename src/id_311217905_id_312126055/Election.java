package id_311217905_id_312126055;

import java.util.ArrayList;
import java.util.Random;

import exceptions.AddCitizenException;
import exceptions.PartyException;
import interfaces.BubbleSort;
import interfaces.ComparPartiesByNumOfVotes;
import set.Set;

public class Election<T extends Citizen> implements Cloneable {

	public enum eMonth {
		January, February, March, April, May, June, july, August, September, October, November, Desember
	};

	protected Random r = new Random();
	protected eMonth month;
	protected int Day;// protected - access in package
	protected Set<Voter> allCitizens;
	protected static ArrayList<Party<Citizen>> allParties;
	private ArrayList<BallotBox<Citizen>> allBallotCitizens;
	private ArrayList<BallotBox<SickVoter>> allBallotSickCitizens;
	private ArrayList<BallotBox<Soldier>> allBallotSoldiers;
	private ArrayList<BallotBox<SickSoldier>> allBallotSickSoldiers;

	public Election(eMonth july, int day, Set<T> allCitizens, ArrayList<Party<Citizen>> allParties) throws Exception {
		this.month = july;
		this.Day = day;
		setAllBallotBoxes();
		setVoters(allCitizens);
		setParties(allParties);
	}

	private void setParties(ArrayList<Party<Citizen>> allParties) throws Exception {
		for (int i = allParties.size() - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (allParties.get(j).getNameOfParty().equals(allParties.get(i).getNameOfParty())) {
					throw new PartyException(
							"setPartiesException: The party: " + allParties.get(i).getNameOfParty() + "already exists");
				}
			}
		}
		Election.allParties = new ArrayList<Party<Citizen>>(allParties);
		setContenders(allCitizens, allCitizens.size());

	}

	private void setAllBallotBoxes() {
		this.allBallotCitizens = new ArrayList<BallotBox<Citizen>>();
		this.allBallotSickCitizens = new ArrayList<BallotBox<SickVoter>>();
		this.allBallotSoldiers = new ArrayList<BallotBox<Soldier>>();
		this.allBallotSickSoldiers = new ArrayList<BallotBox<SickSoldier>>();
//		##Setting BallotBoxes
		allBallotCitizens.add(new BallotBox<Citizen>("Yitzhak Rabin 30, Tel-Aviv"));
		allBallotCitizens.add(new BallotBox<Citizen>("Jabotinsky 3, Tel-Aviv"));
		allBallotCitizens.add(new BallotBox<Citizen>("Arlozorov 12, Tel-Aviv"));
		allBallotCitizens.add(new BallotBox<Citizen>("ibn Gabirol, Tel-Aviv"));
		allBallotCitizens.add(new BallotBox<Citizen>("Levi Eshkol 1, Tel-Aviv"));
		allBallotCitizens.add(new BallotBox<Citizen>("Yehuda Halevi 22, Tel-Aviv"));
		allBallotCitizens.add(new BallotBox<Citizen>("Michal Ha-Ktana 8, Tel-Aviv"));
		allBallotCitizens.add(new BallotBox<Citizen>("Yuval Ha-Mebulbal 123, Tel-Aviv"));
		allBallotCitizens.add(new BallotBox<Citizen>("Assi Dayan 10, Tel-Aviv"));
		allBallotCitizens.add(new BallotBox<Citizen>("Golda Meir 44, Tel-Aviv"));
//		##Setting corona military BallotBoxes
		allBallotSickCitizens.add(new BallotBox<SickVoter>("Geula 3, Tel-Aviv"));
		allBallotSickCitizens.add(new BallotBox<SickVoter>("Ha-Yarkon 42, Tel-Aviv"));
		allBallotSickCitizens.add(new BallotBox<SickVoter>("Dizengoff 224, Tel-Aviv"));
//		##Setting military BallotBoxes
		allBallotSoldiers.add(new BallotBox<Soldier>("Yitzhak Sadeh 67, Tel-Aviv"));
		allBallotSoldiers.add(new BallotBox<Soldier>("Ha-Masger 3, Tel-Aviv"));
		allBallotSoldiers.add(new BallotBox<Soldier>("Hertzel 16, Tel-Aviv"));
//		##Setting corona military BallotBoxes
		allBallotSickSoldiers.add(new BallotBox<SickSoldier>("Tel Ha-Shomer"));
	}

	@SuppressWarnings("unchecked")
	private void setVoters(Set<T> arr) throws Exception {
		allCitizens = new Set<Voter>();
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).adult) {
				if (arr.get(i) instanceof Soldier) {
					addSoldier((T) arr.get(i));
				} else if (arr.get(i) instanceof Contender) {
					if (arr.get(i).fInsulation) {
						allCitizens.add(new SickContender(arr.get(i).name, arr.get(i).id, arr.get(i).birthYear,
								((Contender) arr.get(i)).getMyParty()));
					} else {
						allCitizens.add(new Contender(arr.get(i).name, arr.get(i).id, arr.get(i).birthYear,
								((Contender) arr.get(i)).getMyParty()));
					}
					setBallotBoxToCitizen((T) allCitizens.get(allCitizens.size() - 1));
				} else if (arr.get(i) instanceof Citizen) { // Adult Citizen
					addVoter((T) arr.get(i));
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	private boolean setBallotBoxToCitizen(T Citizen) throws Exception {
		BallotBox<T> temp;
		if (Citizen instanceof SickSoldier) {
			temp = (BallotBox<T>) allBallotSickSoldiers.get(r.nextInt(allBallotSickSoldiers.size()));
			Citizen.myBallotBox = temp;
			temp.setVoter(Citizen);
			return true;
		} else if (Citizen instanceof SickVoter || Citizen instanceof SickContender) {
			temp = (BallotBox<T>) allBallotSickCitizens.get(r.nextInt(allBallotSickCitizens.size()));
			Citizen.myBallotBox = temp;
			temp.setVoter(Citizen);
			return true;
		} else if (Citizen instanceof Soldier) {
			temp = (BallotBox<T>) allBallotSoldiers.get(r.nextInt(allBallotSoldiers.size()));
			Citizen.myBallotBox = temp;
			temp.setVoter(Citizen);
			return true;
		} else if (Citizen instanceof Citizen) {
			temp = (BallotBox<T>) allBallotCitizens.get(r.nextInt(allBallotCitizens.size()));
			Citizen.myBallotBox = temp;
			temp.setVoter(Citizen);
			return true;
		}
		return false;

	}

	private void setContenders(Set<Voter> arr, int numOfVoters) throws Exception {
		for (int i = 0; i < numOfVoters; i++) {
			for (int j = 0; j < allParties.size(); j++) {
				if (arr.get(i) instanceof Contender) {
					if (((Contender) arr.get(i)).getMyPartyName().equals(allParties.get(j).getNameOfParty())) {
						allParties.get(j).addContender(((Contender) arr.get(i)));
					}
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public boolean addContender(T contender, String nameOfParty) throws Exception {
		for (int i = 0; i < allParties.size(); i++) {
			if (allParties.get(i).getNameOfParty().equals(nameOfParty)) {
				allCitizens.add(new Contender(contender.name, contender.id, contender.birthYear, allParties.get(i)));
				allParties.get(i).addContender(allCitizens.get(allCitizens.size() - 1));
				setBallotBoxToCitizen((T) allCitizens.get(allCitizens.size() - 1));
				return true;
			}
		}
		throw new Exception(nameOfParty + " is not legitimate party");
	}

	@SuppressWarnings("unchecked")
	public void addVoter(T voter) throws Exception {
		if (voter.adult) {
			if (voter.fMilitaryVoter) {
				if (voter.fInsulation) {
					allCitizens.add(new SickSoldier(voter.name, voter.id, voter.birthYear));
				} else {
					allCitizens.add(new Soldier(voter.name, voter.id, voter.birthYear));
				}
			} else if (voter.fInsulation) {
				allCitizens.add(new SickVoter(voter.name, voter.id, voter.birthYear));
			} else {
				allCitizens.add(new Voter(voter.name, voter.id, voter.birthYear));
			}
			setBallotBoxToCitizen((T) allCitizens.get(allCitizens.size() - 1));
		} else {
			throw new AddCitizenException("addVoterException: " + voter.getName() + " isn't adult!\nClass: "
					+ getClass().getSimpleName() + " line: 164");
		}

	}

	@SuppressWarnings("unchecked")
	public void addSoldier(T soldier) throws Exception {
		if (soldier.fInsulation) {
			allCitizens.add(new SickSoldier(soldier.name, soldier.id, soldier.birthYear));
		} else {
			allCitizens.add(new Soldier(soldier.name, soldier.id, soldier.birthYear));
		}
		setBallotBoxToCitizen((T) allCitizens.get(allCitizens.size() - 1));
	}

	public void addParty(Party<Citizen> p) throws Exception {
		for (int i = 0; i < allParties.size(); i++) {
			if (p.getNameOfParty().equals(allParties.get(i).getNameOfParty())) {
				throw new PartyException(
						"setPartiesException! The party: " + allParties.get(i).getNameOfParty() + "already exists");
			}
		}
		allParties.add(p);
	}

	public void addBallotCitizens(BallotBox<Citizen> bx) {
		allBallotCitizens.add(bx);
	}

	public void addBallotSickCitizens(BallotBox<SickVoter> bx) {
		allBallotSickCitizens.add(bx);
	}

	public void addBallotSickSoldiers(BallotBox<SickSoldier> bx) {
		allBallotSickSoldiers.add(bx);
	}

	public void addBallotSoldiers(BallotBox<Soldier> bx) {
		allBallotSoldiers.add(bx);
	}

	public void makeAVote(T voter, int partyIndex, int contenderIndex) throws Exception { //
		for (int i = 0; i < allCitizens.size(); i++) {
			if (voter.id == allCitizens.get(i).id) {
				allCitizens.get(i).myBallotBox.setAVoteInBallotBox(allCitizens.get(i), partyIndex, contenderIndex);
			}
		}
	}

	private void printBallotBox(ArrayList<?> bx, StringBuilder sb) {
		for (int i = 0; i < bx.size(); i++) {
			sb.append("\n\n" + "BallotBox of citizens: (" + ((BallotBox<?>) bx.get(i)).BallotBoxID + ")");
			sb.append(bx.get(i).toString());
		}
	}

	public String ballotBoxToString() {
		StringBuilder sb = new StringBuilder("##The list of voters by Ballot-Box is:##");
		printBallotBox(allBallotCitizens, sb);
		printBallotBox(allBallotSickCitizens, sb);
		printBallotBox(allBallotSoldiers, sb);
		printBallotBox(allBallotSickSoldiers, sb);
		return sb.toString();
	}

	@Override
	public String toString() {
		BubbleSort.bubbleSort(allParties, new ComparPartiesByNumOfVotes());
		StringBuilder sb = new StringBuilder(
				"********************************************************************************************************************************\n\n"
						+ "**** Elction Day ****\n" + "After calculating the votes, the results are:\n");
		for (int i = 0; i < allParties.size(); i++) {
			sb.append((1 + i) + "} " + allParties.get(i).toString());
			sb.append(i < allParties.size() - 1 ? "\n---------------------------------------------------------\n\n\n\n"
					: "\n");
		}
		return sb.toString()
				+ "********************************************************************************************************************************\n\n"
				+ ballotBoxToString();
	}

	public String partiesPrinter() {
		StringBuilder sb = new StringBuilder("List of parties:\n");
		for (int i = 0; i < allParties.size(); i++) {
			sb.append((1 + i) + "} " + allParties.get(i).getNameOfParty() + "\n");
		}
		return sb.toString();
	}
}
