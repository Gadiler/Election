package id_311217905_id_312126055;

import java.util.ArrayList;
import java.util.Comparator;

import exceptions.AddContenderException;
import exceptions.VoteException;
import interfaces.BubbleSort;
import interfaces.ComparContendersByNumOfVotes;
import interfaces.ComparVotersByID;

public class Party<T extends Citizen> implements Comparator<T> {
	public enum eFaction {
		Left, Center, Right
	};

	protected eFaction faction;
	protected String nameOfParty;
	protected String seniority;
	protected int numOfContenders;
	protected int numOfVotes;
	protected ArrayList<T> ourVoters;
	protected ArrayList<T> allContenders;

	public Party(eFaction faction, String nameOfParty, String seniority) {
		this.faction = faction;
		this.nameOfParty = nameOfParty;
		this.seniority = seniority;
		allContenders = new ArrayList<T>();
		ourVoters = new ArrayList<T>();
	}

	public Party(Party<T> party) {
		this(party.faction, party.nameOfParty, party.seniority);
	}

	public String getNameOfParty() {
		return nameOfParty;
	}

	public int getNumOfVotes() {
		return numOfVotes;
	}

	public boolean addContender(T newContender) throws Exception {
//		######EXCEPTION!!!!
		for (int i = 0; i < ourVoters.size(); i++) {
			if (ourVoters.get(i) != null) {
				if (newContender.getId() == ourVoters.get(i).getId()) {
					throw new AddContenderException("AddContenderException: " + ourVoters.get(i)
							+ " Already exist\nClass: " + getClass().getSimpleName() + " line: 48");
				}
			}
		}
//		######EXCEPTION!!!!
		allContenders.add(newContender);
		numOfContenders++;
		return true;
	}

	public void makeAVoteForOurParty(T voter, int contenderIndex) throws Exception {
		for (int i = 0; i < ourVoters.size(); i++) {
//		######EXCEPTION!!!!
			if (voter.getId() == ourVoters.get(i).getId()) {
				throw new VoteException("VoteException: " + ourVoters.get(i).name + " All Ready Voted!\nClass: "
						+ getClass() + "line: 62");
			}
		}
//		######EXCEPTION!!!!
		ourVoters.add(voter);
		((Contender) allContenders.get(contenderIndex - 1)).makeAVote();
		numOfVotes++;
		System.out.println("Thank you for voting us!\n");
	}

	public String ourContendersToString() {
		BubbleSort.bubbleSort(allContenders, new ComparVotersByID());
		BubbleSort.bubbleSort(allContenders, new ComparContendersByNumOfVotes());
		StringBuilder sb = new StringBuilder("The Contenders are: \n");
		for (int i = 0; i < allContenders.size(); i++) {
			sb.append((i + 1) + "] " + allContenders.get(i).toString() + ", numOfVotes: "
					+ ((Contender) allContenders.get(i)).getNumOfVotesForContender() + "\n\n");
		}
		return sb.toString() + "The number of contenders is: " + allContenders.size() + "\n";
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(
				"The final count for party: " + nameOfParty + " is: **" + ourVoters.size() + "**" + "\n");
		sb.append(ourContendersToString());
		sb.append("\nThe list of our voters: \n");
		BubbleSort.bubbleSort(ourVoters, new ComparVotersByID());
		for (int i = 0; i < ourVoters.size(); i++) {
			sb.append((i + 1) + ") " + ourVoters.get(i).toString() + "\n");
		}
		return sb.toString() + "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Party<?> other = (Party<?>) obj;
		if (!allContenders.equals(other.allContenders))
			return false;
		if (faction != other.faction)
			return false;
		if (nameOfParty == null) {
			if (other.nameOfParty != null)
				return false;
		} else if (!nameOfParty.equals(other.nameOfParty))
			return false;
		if (numOfContenders != other.numOfContenders)
			return false;
		if (numOfVotes != other.numOfVotes)
			return false;
		if (seniority == null) {
			if (other.seniority != null)
				return false;
		} else if (!seniority.equals(other.seniority))
			return false;
		return true;
	}

	@Override
	public int compare(T o1, T o2) {
		if (o1.id < o2.id) {
			return -1;
		} else if (o1.id > o2.id) {
			return 1;
		} else
			return 0;
	}
}
