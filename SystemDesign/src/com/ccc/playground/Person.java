package com.ccc.playground;

import java.util.ArrayList;

public class Person {
	private ArrayList<Integer> friends;
	private int personId;
	private int machineId;
	private String info;
	private Server server = new Server();
	
	public Person(int personId, int machineId) {
		this.personId = personId;
		this.machineId = machineId;
	}
	
	public int[] getFriends() {
		int[] temp = new int[friends.size()];
		
		for(int i = 0; i < temp.length; i++) {
			temp[i] = friends.get(i);
		}
		
		return temp;
	}
	
	public void setFriends(int personId) {
		friends.add(personId);
	}
	
	public int getPersonId() {
		return personId;
	}
	
	public int getMachineId() {
		return machineId;
	}
	
	public String getInfo() {
		return info;
	}
	
	public void setInfo(String info) {
		this.info = info;
	}
	
	/**
	 * Look up a machine given the Machine id.
	 * 
	 * @param machineId
	 * @return
	 */
	public Machine lookUpMachine(int machineId) {
		for(Machine m : server.machines) {
			if(m.machineId == machineId) {
				return m;
			}
		}
		
		return null;
	}
	
	/**
	 * Look up a person given their Person id and Machine id.
	 * 
	 * @param machineId
	 * @param personId
	 * @return
	 */
	public Person lookUpFriend(int machineId, int personId) {
		for(Machine m : server.machines) {
			if(m.machineId == machineId) {
				for(Person p : m.persons) {
					if(p.personId == personId) {
						return p;
					}
				}
			}
		}
		
		return null;
	}
}