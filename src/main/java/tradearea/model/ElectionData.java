package tradearea.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ElectionData {
	private String regionID;
	private String regionName;
	private String regionAddress;
	private String regionPostalCode;
	private String federalState;
	private String timestamp;
	private List<PartyVotes> countingData;
	private List<PreferenceVotes> preferenceVotes;  // New field for preference votes

	// Constructor
	public ElectionData() {
		this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
	}

	// Getters and Setters for all fields

	public String getRegionID() {
		return regionID;
	}

	public void setRegionID(String regionID) {
		this.regionID = regionID;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getRegionAddress() {
		return regionAddress;
	}

	public void setRegionAddress(String regionAddress) {
		this.regionAddress = regionAddress;
	}

	public String getRegionPostalCode() {
		return regionPostalCode;
	}

	public void setRegionPostalCode(String regionPostalCode) {
		this.regionPostalCode = regionPostalCode;
	}

	public String getFederalState() {
		return federalState;
	}

	public void setFederalState(String federalState) {
		this.federalState = federalState;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public List<PartyVotes> getCountingData() {
		return countingData;
	}

	public void setCountingData(List<PartyVotes> countingData) {
		this.countingData = countingData;
	}

	public List<PreferenceVotes> getPreferenceVotes() {
		return preferenceVotes;
	}

	public void setPreferenceVotes(List<PreferenceVotes> preferenceVotes) {
		this.preferenceVotes = preferenceVotes;
	}

	@Override
	public String toString() {
		return String.format("WarehouseData: Region = %s, timestamp = %s", regionID, timestamp);
	}
}
