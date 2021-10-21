package com.hibernateSample.DemoHib;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity // (name ="alien_table") in case you wanna create a table with different name from your class name. This happens to be the entity name.
//@Table(name="alien_table") - change only table name and not the entity name 
public class Alien {

	@Id
	private int aid;
	private AlienName aname;
	//@Column(name="alien_color") can be a different column name in the table. 
	//@Transient- This will not create a column in the Table
	private String color;

	public int getAid() {
		return aid;
	}

	public void setAid(int aid) {
		this.aid = aid;
	}

	public AlienName getAname() {
		return aname;
	}

	public void setAname(AlienName aname) {
		this.aname = aname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Alien [aid=" + aid + ", aname=" + aname + ", color=" + color + "]";
	}

}
