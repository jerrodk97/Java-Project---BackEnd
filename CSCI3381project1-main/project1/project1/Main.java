//Jerrod Koenigseder
package project1;

public class Main{
	
		public static void main(String[] args) {
		//instance testing
		Instance i1 = new Instance();
		System.out.println(i1);
		System.out.println(i1.getCondition());
		System.out.println(i1.getTemp());
		System.out.println(i1.getHumidity());
		System.out.println(i1.getWindy());
		System.out.println(i1.getActivity());
		System.out.println(i1.toString());	
			
			
			
			
		//predictor testing	
		Predictor allData = new Predictor("weather","./project1/weather.numeric.txt");//reads file
		Instance test = new Instance("sunny",85,80,"FALSE","tennis");//creates a new instance
		allData.add(test);//adds to arraylist
		test = new Instance("overcast",81,75,"FALSE","walking");//creates a new instance
		allData.add(test);//adds to arraylist
		System.out.println(allData);//prints all data
		
		test = new Instance("sunny",72,95,"FALSE","swimming");//new instance
		allData.add(test);//add instance
		
		test = new Instance("rainy",71,91,"TRUE","play xbox"); //new instance
		allData.add(test);//adds instance

		String activity = allData.getActivity("sunny",85,80,"FALSE");//gets activity for these conditions
		System.out.println(activity);//prints activity
		
		test = new Instance("sunny",85,80,"FALSE","tennis"); //new instance
		activity = allData.getActivity("sunny", 85, 80, "FALSE"); // get activity from instance
		System.out.println(activity); //print activity
		allData.update("sunny",85,80,"FALSE","running"); //update activity with these conditions to running
		activity = allData.getActivity("sunny", 85, 80, "FALSE"); //sets new activity to String activity
		System.out.println(activity); //prints activity

		allData.update("overcast", 81, 75, "FALSE", "Study for Java Test"); //updates activity for these conditions
		System.out.println(allData.getActivity("overcast", 81, 75, "FALSE")); //prints updated activity
		System.out.println("\n"); //new line
		System.out.println(allData); //print new and updated data
		allData.writeFile(); //write data to file
		}
}

