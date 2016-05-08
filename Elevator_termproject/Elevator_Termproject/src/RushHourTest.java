public class RushHourTest {
	/* this class makes test case about Rush hour time.
	 * test case has 98 people, and each person has a present floor, destination floor and weight.
	 * initilize all people weight 50 so that obtain exact result.
	 * and each person has a random destination but all people are starting at first floor
	 */
   private int[] weight = new int[97];
   private int[] rand_destination = new int[97];
   private int[] present_floor = new int[97];
   public RushHourTest()
   {
      for(int i=0; i<97; i++) // initialize weight and present floor
      {
         weight[i] = 50;
         present_floor[i] = 1;
      }
      for(int i=0;i<97; i++) // initialize destination using random function
      {
         rand_destination[i] = 4+(int)(Math.random()*17);
      }  
   }
   public int[] getWeight(){  // getter functions
      return weight;
   }
   public int[] getFloor(){
      return present_floor;
   }
   public int[] getRand(){
	   return rand_destination;
   }
}