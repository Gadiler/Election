package id_311217905_id_312126055;

import java.util.Arrays;
import java.util.Comparator;

import comparator.BubbleSort;
import comparator.ComparContendersByNumOfVotes;
import comparator.ComparVotersByID;

public class Party implements Comparator<Contender>{
	public enum eFaction {Left, Center, Right};

	protected eFaction faction;
	protected String nameOfParty;
	protected String seniority;
	protected Contender[] allContenders;
	protected Voter[] OurVoters;
	protected int numOfContenders;
	protected int numOfVotes;

	public Party(eFaction faction, String nameOfParty, String seniority, int numOfContenders, int numOfVoters) {
		this.faction = faction;
		this.nameOfParty = nameOfParty;
		this.seniority = seniority;
		this.allContenders = new Contender[numOfContenders];
		this.OurVoters = new Voter[numOfVoters];
	}

	public Party(Party party) {
		this(party.faction, party.nameOfParty, party.seniority, party.allContenders.length, party.OurVoters.length); 
	}

	public String getNameOfParty() {
		return nameOfParty;
	}

	public int getNumOfVotes() {
		return numOfVotes;
	}

	public boolean addContender(Contender newContender) throws Exception {
//		######EXCEPTION!!!!
		for (int i = 0; i < OurVoters.length; i++) {
			if (OurVoters[i] != null) {
				if (newContender.getId() == OurVoters[i].getId()) {		 			  
					throw new Exception("addContnder Excption: Allready exist"); 
				}
			}
		}
//		######EXCEPTION!!!!
		if (numOfContenders == allContenders.length) {
			Contender[] tempAllContenders = new Contender[allContenders.length+1];
			for (int i = 0; i < allContenders.length; i++) {
				tempAllContenders[i] = allContenders[i];
			}
			allContenders = new Contender[allContenders.length+1];
			for (int i = 0; i < numOfContenders; i++) {
			this.allContenders[i] = tempAllContenders[i];
			}allContenders[numOfContenders++] = new Contender(newContender);
			return true;
		}
		this.allContenders[numOfContenders++] = new Contender(newContender);
		return true;
	}

	public void makeAVoteForOurParty(Voter voter, int contenderIndex) throws Exception {
		for (int i = 0; i < OurVoters.length; i++) {
			if (voter.equals(OurVoters[i])) {
				throw new Exception("makeAVoteForOurParty Exception: "+OurVoters[i].name+" All Ready Voted!");
			}
		}
		OurVoters[numOfVotes++] = voter.clone();
		allContenders[contenderIndex - 1].makeAVote();
		System.out.println("Thank you for voting us!\n");
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("Party details: \n");
		sb.append("###Party name: " + nameOfParty + ", since: " + seniority + "\n");
		sb.append(ourContendersToString());
		return sb.toString();
	}

	public String ourContendersToString() {
		BubbleSort.bubbleSort(allContenders, new ComparVotersByID());
		BubbleSort.bubbleSort(allContenders, new ComparContendersByNumOfVotes());
		StringBuilder sb = new StringBuilder("The Contenders are: \n");
		for (int i = 0; i < numOfContenders; i++) {
			sb.append((i + 1) + "] " + allContenders[i].toString() + "\n");
		}
		return sb.toString() + "The number of contenders is: " + numOfContenders + "\n";
	}

	public String ourVotesToString() {
		StringBuilder sb = new StringBuilder("The final count for party: " + nameOfParty + " is: **" + numOfVotes + "**" + "\n");
		sb.append(ourContendersToString());
		sb.append("\nThe list of our voters: \n");
		for (int j = 0; j < numOfVotes; j++) {
			sb.append((j + 1) + ") " + OurVoters[j].name +", " +OurVoters[j].id+  "\n");
		}
		return sb.toString()+ "\n";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Party other = (Party) obj;
		if (!Arrays.equals(OurVoters, other.OurVoters))
			return false;
		if (!Arrays.equals(allContenders, other.allContenders))
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
	public int compare(Contender o1, Contender o2) {
		if (o1.getNumOfVotesForContender() < o2.getNumOfVotesForContender()) {
			return -1;
		}else if (o1.getNumOfVotesForContender() > o2.getNumOfVotesForContender()) {
			return 1;
		}else
		return 0;
	}


	
	
	

}
