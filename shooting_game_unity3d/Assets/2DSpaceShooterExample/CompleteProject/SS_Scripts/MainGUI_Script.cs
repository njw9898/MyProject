using UnityEngine;
using System.Collections;

public class MainGUI_Script : MonoBehaviour {

	public void BtnStart(){
		Application.LoadLevel ("PlayScene");
	}

	public void BtnEnd() {
		Application.Quit ();
	}
}
