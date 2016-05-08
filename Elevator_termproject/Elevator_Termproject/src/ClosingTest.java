public class ClosingTest {
	/* this class makes test case about Closing time.
	 * test case has 98 people, and each person has a present floor, destination floor and weight.
	 * initilize all people weight 50 so that obtain exact result.
	 * and each person has a random present floor but all people's destinations are first floor
	 */
   private int[] rand_floor = new int[97];
   public ClosingTest()
   {
      for(int i=0; i<97; i++)
      {
         rand_floor[i] = 4 + (int)(Math.random()*17);
      }
   }
   public int[] getRandFloor(){
      return rand_floor;
   }
}