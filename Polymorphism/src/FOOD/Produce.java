package FOOD;

public class Produce {
	Double qty; //allows for fractional quantity, e.g. 2.2 Lbs
	
	public Produce (Double q) {qty = q;}
	public Produce() {qty = 0.0;} //default constructor
	
	//define parent class Produce
	//children will specify the fields of their unique name, their classification (fruit, vegetable, flowers),
		//how they are priced, their price, and quantity purchased
	public String produceType() {return "Produce";}
	public String produceClassification() {return "Produce";}
	public String priceType() {return "";}
	public double price() {return 0.0;}
	public Double getQty() {return qty;} //encapsulation
	public void setQty(Double q) {qty = q;}
}

//Produce Classification: Fruit
class Fruit extends Produce {
	public Fruit (double q) {super(q);}
	public Fruit () {} //default constructor
	public String produceType() {return "Fruit";}
	public String produceClassification() {return "Fruit";}
}

//Produce Classification: Vegetable
class Vegetable extends Produce {
	public Vegetable (double q) {super(q);}
	public Vegetable () {} //default constructor
	public String produceType() {return "Vegetable";}
	public String produceClassification() {return "Vegetable";}
}

//Produce Classification: Flowers
class Flowers extends Produce {
	public Flowers (double q) {super(q);}
	public Flowers () {} //default constructor
	public String produceType() {return "Flowers";}
	public String produceClassification() {return "Flowers";}
}

//Begin specific types of fruit
//Fruit Type: Banana
class Banana extends Fruit {
	public Banana (double q) {super(q);}
	public Banana() {}
	public String produceType() {return "Banana";}
	public String priceType() {return "Dozen";}
	public double price() {return 0.79;}
}

//Fruit Type: Strawberry
class Strawberry extends Fruit {
	public Strawberry (double q) {super(q);}
	public Strawberry() {}
	public String produceType() {return "Strawberry";}
	public String priceType() {return "Lbs";}
	public double price() {return 2.50;}
}

//Fruit Type: Mango
class Mango extends Fruit {
	public Mango (double q) {super(q);}
	public Mango() {}
	public String produceType() {return "Mango";}
	public String priceType() {return "Unit";}
	public double price() {return 1.49;}
}

//Fruit Type: Orange
class Orange extends Fruit {
	public Orange (double q) {super(q);}
	public Orange() {}
	public String produceType() {return "Orange";}
	public String priceType() {return "Unit";}
	public double price() {return 0.39;}
}

//Fruit Type: Apple
class Apple extends Fruit {
	public Apple (double q) {super(q);}
	public Apple() {}
	public String produceType() {return "Apple";}
	public String priceType() {return "Lbs";}
	public double price() {return 2.33;}
}

//Vegetable Type: Eggplant
class Eggplant extends Vegetable {
	public Eggplant (double q) {super(q);}
	public Eggplant() {}
	public String produceType() {return "Eggplant";}
	public String priceType() {return "Unit";}
	public double price() {return 0.74;}
}

//Vegetable Type: Radish
class Radish extends Vegetable {
	public Radish (double q) {super(q);}
	public Radish() {}
	public String produceType() {return "Radish";}
	public String priceType() {return "Dozen";}
	public double price() {return 1.14;}
}

//Vegetable Type: Cabbage
class Cabbage extends Vegetable {
	public Cabbage (double q) {super(q);}
	public Cabbage() {}
	public String produceType() {return "Cabbage";}
	public String priceType() {return "Unit";}
	public double price() {return 1.48;}
}

//Vegetable Type: Lettuce
class Lettuce extends Vegetable {
	public Lettuce (double q) {super(q);}
	public Lettuce() {}
	public String produceType() {return "Lettuce";}
	public String priceType() {return "Unit";}
	public double price() {return 0.82;}
}

//Vegetable Type: Carrot
class Carrot extends Vegetable {
	public Carrot (double q) {super(q);}
	public Carrot() {}
	public String produceType() {return "Carrot";}
	public String priceType() {return "Dozen";}
	public double price() {return 0.98;}
}

//Flowers Type: Rose
class Rose extends Flowers {
	public Rose (double q) {super(q);}
	public Rose() {}
	public String produceType() {return "Rose";}
	public String priceType() {return "Dozen";}
	public double price() {return 19.99;}
}

//Flowers Type: Carnation
class Carnation extends Flowers {
	public Carnation (double q) {super(q);}
	public Carnation() {}
	public String produceType() {return "Carnation";}
	public String priceType() {return "Dozen";}
	public double price() {return 5.28;}
}

//Flowers Type: Tulip
class Tulip extends Flowers {
	public Tulip (double q) {super(q);}
	public Tulip() {}
	public String produceType() {return "Tullip";}
	public String priceType() {return "Unit";}
	public double price() {return 1.50;}
}

//Flowers Type: Lily
class Lily extends Flowers {
	public Lily (double q) {super(q);}
	public Lily() {}
	public String produceType() {return "Lily";}
	public String priceType() {return "Unit";}
	public double price() {return 3.00;}
}

//Flowers Type: Orchid
class Orchid extends Flowers {
	public Orchid (double q) {super(q);}
	public Orchid() {}
	public String produceType() {return "Orchid";}
	public String priceType() {return "Unit";}
	public double price() {return 13.99;}
}