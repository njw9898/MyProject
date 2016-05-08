import java.awt.Image;
import java.awt.Toolkit;

/*
 * Each businessman has weight, present floor and destination floor
 */
public class Businessman {
   public static int cnt = 0;
   
   private int p_id;
   private Toolkit tk;
   //three people. and each people do walking, walking2, standing
   private Image img[] = new Image[3]; 
   private Image img2[] = new Image[3];
   private Image img3[] = new Image[3];
   
   private int x = 0 ; // of course, these integer are index of current.  
   private int y ;
   
   private int d_x; // these two integer are destination index.
   private int d_y;
   
   private long starttime=0; // when start 
   private long endtime=0; // when finish.
   private int priority; // means people exist first.
   private boolean done; // true, doen
   private boolean offriding = false;
   private boolean riding = false; 
   private boolean isWait = false; // if the person arrive at elevator.
   private int weight=50; //default weight
   
   
   public void setDone(boolean a){
      this.done = a;
   }
   public boolean getDone(){
      return done;
   }
   public void setPri(int pri){
      this.priority=pri;
   }
   public int getPri(){ //geting priority.
      return priority;
   }
   public int getD_y() { // geting destination y.
      return d_y;
   }
   public void setD_y(int d_y) {
      this.d_y = d_y;
   }


   public Businessman(int destination_x, int destination_y, int weight){
      this.d_x = destination_x;
      this.d_y = destination_y;
      this.weight=weight;
      tk = Toolkit.getDefaultToolkit();//get image file
      img[0] = tk.createImage("산타1.png");
      img[1] = tk.createImage("산타2.png");
      img[2] = tk.createImage("산타3.png");
      
      img2[0] = tk.createImage("회사원1.png");
      img2[1] = tk.createImage("회사원2.png");
      img2[2] = tk.createImage("회사원3.png");
      
      img3[0] = tk.createImage("부장님1.png");
      img3[1] = tk.createImage("부장님2.png");
      img3[2] = tk.createImage("부장님3.png");
      this.p_id = cnt++;
   }


   public Toolkit getTk() {
      return tk;
   }


   public void setTk(Toolkit tk) {
      this.tk = tk;
   }

   // three image and each image occure when  special time is. 
   public Image getImg(int i) {
      return img[i];
   }
   
   public Image getImg2(int i) {
      return img2[i];
   }
   
   public Image getImg3(int i){
      return img3[i];
   }
   
   public int getX() { //current x
      return x;
   }

   public void setX(int x) {
      this.x = x;
   }


   public int getY() { // current y
      return y;
   }


   public void setY(int y) {
      this.y = y;
   }


   public int getD_x() {
      return d_x;
   }


   public void setD_x(int d_x) {// setting destination x
      this.d_x = d_x;
   }
   public int getP_id() {
      return p_id;
   }
   public void setP_id(int p_id) {
      this.p_id = p_id;
   }
   public boolean isWait() { // if the person is in elevator.
      return isWait;
   }
   public void setWait(boolean isWait) { // the state waite.
      this.isWait = isWait;
   }
   public boolean getoffriding() {
      return offriding;
   }
   public void setoffriding(boolean offriding) {
      this.offriding = offriding;
   }
   public boolean getRiding() { // getting ridding.
      return riding;
   }
   public void setRiding(boolean riding) { // the state riding.
      this.riding = riding;
   }
   public int getWeight() { // getting weight. 
      return weight;
   }
   public void setWeight(int weight) { // make weight.
      this.weight = weight;
   }
   public long getStarttime() { // get start time.
       return starttime;
   }
   public void setStarttime(long starttime) {  // setting start time.
      this.starttime = starttime;
   }
   public long getEndtime() { // get finish time.
      return endtime;
   }
   public void setEndtime(long endtime) { // setting finish time.
      this.endtime = endtime;
   }
   
}