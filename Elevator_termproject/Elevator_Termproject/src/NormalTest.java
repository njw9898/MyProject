public class NormalTest {
	/* this class makes test case about normal time.
	 * test case has 98 people, and each person has a present floor, destination floor and weight.
	 * initilize all people weight 50 so that obtain exact result.
	 * and each person has a random present floor and random destination
	 */
   private int[] weight = new int[97];
   private int[] rand_normalDestination = new int[97];
   private int[] rand_floor = new int[97];
   public NormalTest()
   {
      for(int i=0; i<97; i++) //initialize weight
      {
         weight[i] = 50;
      }
    
      for(int i=0;i<97; i++) //initialize destination using random function
      {
         rand_normalDestination[i] = 1 + (int)(Math.random()*20);
      }
      for(int i=0; i<97; i++) //initialize present floor using random function
      {
         rand_floor[i] = 1 + (int)(Math.random()*20); 
         while(rand_floor[i] == rand_normalDestination[i]){ // prohibit same present and destination floor
            rand_floor[i] = 4+(int)(Math.random()*17);
            if(rand_floor[i] != rand_normalDestination[i])
               break;
         }
      }
     
   }
   public int[] getWeight(){   //getter functions
      return weight;
   }
   public int[] getRandNormalDestination(){
      return rand_normalDestination; 
   }
   public int[] getRandFloor(){
      return rand_floor;
   }
}