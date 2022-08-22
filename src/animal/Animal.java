package animal;

import java.util.ArrayList;

import field.Location;

public abstract class Animal {
	private int LimitAge;
	private int Age;
	private int BreedAbleAge;
	private boolean isAlive = true;
	public Animal(int limitAge, int breedAbleAge) {
		LimitAge = limitAge;
		BreedAbleAge = breedAbleAge;
	}
	protected int getAge()
	{
		return Age;
	}
	protected double getAgePercent() {
		return (double)Age/(double)LimitAge;
	}
//	public abstract Animal breed();
	public Animal breed() {
		Animal ret = null;
		if(isBreedable()&&Math.random()<getValue()) {
			ret = getAnimal();
		}
		return ret;
	}
	public abstract Animal getAnimal();
	public abstract double getValue();
	public void grow() {
		Age++;
		if(Age>=LimitAge){
			die();
		}
	}
	public void die() {
		isAlive = false;
	}
	public boolean isAlive() {
		return isAlive;
	}
	public boolean isBreedable() {
		return (Age>=BreedAbleAge);
	}
	public Location move(Location[] freeAdj) {
		Location ret = null;
		if(freeAdj.length>0&&Math.random()<0.02) {
			ret = freeAdj[(int)Math.random()*freeAdj.length];
		}
		return ret;
	}
	@Override
	public String toString() {
		return ""+Age+":"+(isAlive?"live":"die");
	}
	public Animal feed(ArrayList<Animal> neighbour) {
		return null;
	}
	public void longerlife(int ic) {
		LimitAge+=ic;
	}
	
}
