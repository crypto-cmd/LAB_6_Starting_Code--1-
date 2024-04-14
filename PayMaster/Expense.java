public class Expense {
    public String name, category, notes;
    public String id;
    public float cost;
    
    public Expense(String name, String cat, float cost, String notes) {
    	this.name = name;
    	category = cat;
    	this.cost = cost;
    	this.notes = notes;
        id= String.format("%d%d%d%d%d", (int)(Math.random()*9),(int)(Math.random()*9), (int)(Math.random()*9),(int)(Math.random()*9), (int)(Math.random()*9));
    	
    }


}