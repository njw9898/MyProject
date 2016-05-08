/// <summary>
/// This is the EnemyBlue Script:
/// - Enemy Ship Movement/Health/Score
/// - Explosion Trigger
/// 
/// </summary>

using UnityEngine;
using System.Collections;

public class EnemyBlue_Script : MonoBehaviour 
{
	//Public Var
	public float speed; //Enemy Ship Speed
	public int health; //Enemy Ship Health
	public GameObject LaserGreenHit; //LaserGreenHit Prefab
	public GameObject Explosion; //Explosion Prefab
	public int ScoreValue; //How much the Enemy Ship give score after explosion

	bool isBoss;

	// Use this for initialization called one time in script
	void Start () 
	{
		GetComponent<Rigidbody2D>().velocity = -1 * transform.up * speed; //Enemy Ship Movement
	}

	void Update(){// Update() is called infinite as part of frame

		//It is for appear boss 
		isBoss = GameObject.Find("GameController").GetComponent<GameController_Script>().appearBoss;

		// if appear boss, break enemy
		if (isBoss == true) {
			Destroy (gameObject);
		}

	}

	//Called when the Trigger entered
	void OnTriggerEnter2D(Collider2D other)
	{
		//Excute if the object tag was equal to one of these
		if(other.tag == "PlayerLaser")
		{
			// transfrom.position and transfrom.rotation is default value
			Instantiate (LaserGreenHit, transform.position , transform.rotation); 			//Instantiate LaserGreenHit 
			Destroy(other.gameObject); 														//Destroy the Other (PlayerLaser)
			
			//Check the Health if greater than 0
			if(health > 0)
				health--; 																	//Decrement Health by 1

			//Check the Health if less or equal 0, it means object died
			if(health <= 0)
			{
				Instantiate (Explosion, transform.position , transform.rotation); 			//Instantiate Explosion
				SharedValues_Script.score += ScoreValue; 									//Increment score by ScoreValue
				Destroy(gameObject);														//Destroy The Object (Enemy Ship)
			}
		}
	}
}