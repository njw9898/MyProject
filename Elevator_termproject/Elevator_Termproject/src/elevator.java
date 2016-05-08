import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;

//this is elevator class.
public class elevator {
   
   private Toolkit tk;
   private Image img[] = new Image[3]; // this is image one is close, and other is open, and the other is middle.
   
   ArrayList<Businessman> ridingMan = new ArrayList<Businessman>(); 
   ArrayList<Businessman> goalfloor = new ArrayList<Businessman>();

   
   // these two value x and y is the index of map.
   private int x = 0 ;
   private int y;
   
   // these two value d_x and d_y are the index of destination.
   private int d_x;
   private int d_y;
   private boolean flag;

   // elevator open
   private boolean open;
   private boolean flag2=false;
   // elevator up
   private boolean up=true;
   // elevator down
   private boolean down=false;
   private int TTL=300;
   private int TTLy;
   //when the weight is over.
   private int limit=500;
   //if current weight is equal limit, then elevator can't have poeple.
   private int currentweight=0;
   
   public void setTTL(int ttl){
      this.TTL = ttl;
   }
   public int getTTL(){
      return TTL;
   }
   public ArrayList<Businessman> getgoalfloor() { // means get going to destination floor.
      return ridingMan;
   }
   public void setgoalfloor(ArrayList<Businessman> goalfloor) { // means set going to destination floor.
      this.goalfloor = goalfloor;
   }
   public ArrayList<Businessman> getRidingMan() { 
      return ridingMan;
   }
   public void setRidingMan(ArrayList<Businessman> ridingMan) {
      this.ridingMan = ridingMan;
   }
   public void set_open(boolean open) //setting elevator open
   {
      this.open = open;
   }
   public boolean get_open() // getting elevator open
   {
      return open;
   }
   public void set_flag(boolean flag){
      this.flag = flag;
   }
   public boolean get_flag(){
      return flag;
   }
   public int getD_y() { // means the destination y
      return d_y;
   }

   public void setD_y(int d_y) { // make the destination y.
      this.d_y = d_y;
   }


   public elevator(int destination_x, int destination_y){ // make the destination x and y.
      this.d_x = destination_x;
      this.d_y = destination_y;
      
      tk = Toolkit.getDefaultToolkit();//이걸 이용해서  이미지를 가져올 수 있다.
      img[0] = tk.createImage("ele1.jpg"); // close
      img[1] = tk.createImage("ele2.jpg"); // middle
      img[2] = tk.createImage("ele3.jpg"); // open
   }

   public Toolkit getTk() {
      return tk;
   }

   public void setTk(Toolkit tk) {
      this.tk = tk;
   }

   public Image getImg(int i) { // the state of elevator. close, open or middle.
      return img[i];
   }

   public int getX() { // getting index x
      return x;
   }

   public void setX(int x) { // setting index x
      this.x = x;
   }

   public int getY() { // getting index y
      return y;
   }

   public void setY(int y) { // setting index y
      this.y = y;
   }


   public int getD_x() { // getting destination x
      return d_x;
   }

   public void setD_x(int d_x) { //setting destination x
      this.d_x = d_x;
   }
   public boolean getFlag2() {
      return flag2;
   }
   public void setFlag2(boolean flag2) {
      this.flag2 = flag2;
   }
   public boolean getUp() { // get the elevator state up
      return up;
   }
   public void setUp(boolean up) { // set the elevator state up
      this.up = up;
   }
   public boolean getDown() { // get the elevator state down
      return down;
   }
   public void setDown(boolean down) { // set the elevator state down
      this.down = down;
   }
   public int getTTLy() {
      return TTLy;
   }
   public void setTTLy(int tTLy) {
      TTLy = tTLy;
   }
   public int getLimit() { //get limit weight.
      return limit;
   }
   public void setLimit(int limit) { //setting limit weight.
      this.limit = limit;
   }
   public int getCurrentweight() { // get current weight.
      return currentweight;
   }
   public void setCurrentweight(int currentweight) { // set current weight.
      this.currentweight = currentweight;
   }
   
}