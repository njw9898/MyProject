/// <summary>
/// This is the LaserHit Script:
/// - Destroy the LaserHit after specific time
/// 
/// </summary>

using UnityEngine;
using System.Collections;

public class LaserHit_Script : MonoBehaviour 
{

	// Use this for initialization
	void Start () 
	{
		Destroy(gameObject,0.05f); //Destroy the object after specific time
	}
}
