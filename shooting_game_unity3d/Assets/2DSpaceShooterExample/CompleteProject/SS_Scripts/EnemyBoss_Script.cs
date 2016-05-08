/// <summary>
/// 
/// This is the EnemyRed Script:
/// - Enemy Ship Movement/Health/Score
/// - Explosion Trigger
/// 
/// </summary>
using UnityEngine;
using System.Collections;


public class EnemyBoss_Script : MonoBehaviour 
{

	//Public Var
	public float speed;						//Enemy Ship Speed
	public int health;						//Enemy Ship Health
	public GameObject LaserBossHit;		//LaserGreenHit Prefab
	public GameObject Explosion;			//Explosion Prefab
	public int ScoreValue;					//How much the Enemy Ship give score after explosion
	public GameObject shot;					//Fire Prefab
	public Transform shotSpawn;				//Where the Fire Spawn
	public float fireRate = 0.5F;			//Fire Rate between Shots
	public Boundary boundary;


	//Private Var
	private float nextFire = 0.0F;			//First fire & Next fire Time
	private int moveDir = 1;


	// Use this for initialization
	void Start () 
	{
//		GetComponent<Rigidbody2D>().velocity = -1 * transform.up * speed;	//Enemy Ship Movement
	}

	// Update is called once per frame
	void Update () 
	{
		//Excute When the Current Time is bigger than the nextFire time
		//Under source code is used for input fire effection
		if (Time.time > nextFire)
		{
			nextFire = Time.time + fireRate; 									//Increment nextFire time with the current system time + fireRate
			Instantiate (shot , shotSpawn.position ,shotSpawn.rotation); 		//Instantiate fire shot 
			GetComponent<AudioSource>().Play ();														//Play Fire sound
		}
	}
	// FixedUpdate() is used for express fixed flow in PC
	void FixedUpdate(){

		if (transform.localPosition.x <= -3) {
			moveDir = 1;
		}

		if (transform.localPosition.x >= 3) {
			moveDir = -1;
		}

		transform.Translate (Vector2.right * speed * Time.deltaTime * moveDir);

		//GetComponent<Rigidbody2D>().velocity = transform.right * speed; 							//Add Velocity to the player ship rigidbody
		
		//Lock the position in the screen by putting a boundaries
		// GetComponent<Rigidbody2D> ().position.x = 
		//	Mathf.Clamp (GetComponent<Rigidbody2D> ().position.x, boundary.xMin, boundary.xMax); //X
		
	}

	//Called when the Trigger entered
	void OnTriggerEnter2D(Collider2D other)
	{
		//Excute if the object tag was equal to one of these
		if(other.tag == "PlayerLaser")
		{
			Vector3 hitPos = new Vector3( transform.position.x , transform.position.y - 2.8f, transform.position.z);
			Instantiate (LaserBossHit, hitPos, transform.rotation);		//Instantiate LaserGreenHit 
			Destroy(other.gameObject);													//Destroy the Other (PlayerLaser)

			//Check the Health if greater than 0
			if(health > 0)
				health--; 																//Decrement Health by 1
			
			//Check the Health if less or equal 0
			if(health <= 0)
			{
				Instantiate (Explosion, transform.position , transform.rotation); 		//Instantiate Explosion
				SharedValues_Script.score += ScoreValue;									//Increment score by ScoreValue
				Destroy(gameObject);													//Destroy The Object (Enemy Ship)
				SharedValues_Script.finish = true;
			}
		}
		
	}
}
