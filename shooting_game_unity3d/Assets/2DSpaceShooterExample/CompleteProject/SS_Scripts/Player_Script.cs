/// <summary>
/// This is the Player Ship Script:
/// - Player Ship Movement
/// - Fire Control
/// - Screen Boundary Control
/// - Explosion/Game Over Trigger
/// 
/// </summary>

using UnityEngine;
using System.Collections;

[System.Serializable]
public class Boundary 
{
	public float xMin, xMax, yMin, yMax; //Screen Boundary dimentions
}

public class Player_Script : MonoBehaviour 
{
	//Public Var
	public float speed; 			//Player Ship Speed
	public Boundary boundary; 		//make an Object from Class Boundary
	public GameObject shot;			//Fire Prefab
	public Transform shotSpawn;		//Where the Fire Spawn
	public float fireRate;	//Fire Rate between Shots
	public GameObject Explosion;	//Explosion Prefab

	//Private Var
	private float nextFire = 0.0F;	//First fire & Next fire Time


	// Update is called once per frame
	void Update () 
	{
		//Excute When the Current Time is bigger than the nextFire time
		if (Time.time > nextFire) 
		{
			nextFire = Time.time + fireRate; 								//Increment nextFire time with the current system time + fireRate
			Instantiate (shot , shotSpawn.position ,shotSpawn.rotation); 	//Instantiate fire shot 
			GetComponent<AudioSource>().Play (); 													//Play Fire sound
		}
		// Input touch event on Android device
		if (Input.touchCount > 0) {// The 'zero' means one point on hand 
			Touch touch = Input.GetTouch(0); // if touched player read the input 
			// when touch was stopped and moved 
			if(touch.phase == TouchPhase.Stationary || touch.phase == TouchPhase.Moved){
				// move the position of player 
				Vector2 touchPosition = Camera.main.ScreenToWorldPoint(new Vector2(touch.position.x, touch.position.y));
				transform.position = Vector2.Lerp(transform.position, touchPosition, speed * Time.deltaTime);// Lerp means move softly
			}// delta time means time that frame to frame 
		}

	}

	// FixedUpdate is called one per specific time
	void FixedUpdate ()
	{
		float moveHorizontal = Input.GetAxis ("Horizontal"); 				//Get if Any Horizontal Keys pressed
		float moveVertical = Input.GetAxis ("Vertical");					//Get if Any Vertical Keys pressed
		Vector2 movement = new Vector2 (moveHorizontal, moveVertical); 		//Put them in a Vector2 Variable (x,y)
		GetComponent<Rigidbody2D>().velocity = movement * speed; 							//Add Velocity to the player ship rigidbody

		//Lock the position in the screen by putting a boundaries
		GetComponent<Rigidbody2D>().position = new Vector2 
			(
				Mathf.Clamp (GetComponent<Rigidbody2D>().position.x, boundary.xMin, boundary.xMax),  //X
				Mathf.Clamp (GetComponent<Rigidbody2D>().position.y, boundary.yMin, boundary.yMax)	 //Y
			);
	}

	//Called when the Trigger entered
	void OnTriggerEnter2D(Collider2D other)
	{
		//Excute if the object tag was equal to one of these
		if(other.tag == "Enemy" || other.tag == "Asteroid" || other.tag == "EnemyShot") 
		{
			Instantiate (Explosion, transform.position , transform.rotation); 				//Instantiate Explosion
			SharedValues_Script.gameover = true; 											//Trigger That its a GameOver
			Destroy(gameObject); 															//Destroy Player Ship Object
		}
	}
}
