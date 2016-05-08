/// <summary>
/// This is the DestroyByBoundary Script:
/// - Destroy Any Object go out the boundary (screen)
/// 
/// </summary>

using UnityEngine;
using System.Collections;

public class DestroyByBoundary_Script : MonoBehaviour 
{	
	//Called when the Trigger Exit
	void OnTriggerExit2D(Collider2D other)
	{
		Destroy(other.gameObject); //Destroy the other object
	}

}
