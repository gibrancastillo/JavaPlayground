package com.ccc.gsf;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class UnitGroup {
	private Map<Integer, Unit> units;
	
	public UnitGroup(List<Unit> unitList) {
		units = new HashMap<Integer, Unit>();
		
		for(Iterator<Unit> i = unitList.iterator(); i.hasNext();) {
			Unit unit = i.next();
			units.put(unit.getId(), unit);
		}
	}
	
	public UnitGroup() {
		this(new LinkedList<Unit>());
	}
	
	public void addUnit(Unit unit) {
		units.put(unit.getId(), unit);
	}
	
	public void removeUnit(int id) {
		units.remove(id);
	}
	
	public void removeUnit(Unit unit) {
		removeUnit(unit.getId());
	}
	
	public Unit getUnit(int id) {
		return units.get(id);
	}
	
	public List<Unit> getUnits() {
		List<Unit> unitList = new LinkedList<Unit>();
		
		for(Iterator<?> i = units.entrySet().iterator(); i.hasNext();) {
			Unit unit = (Unit) i.next();
			unitList.add(unit);
		}
		
		return unitList;
	}
}