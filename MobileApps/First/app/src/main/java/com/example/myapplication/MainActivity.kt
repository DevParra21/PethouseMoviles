package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_camera_layout.*
import kotlinx.android.synthetic.main.layout_login.*
import java.io.ByteArrayOutputStream

class MainActivity : AppCompatActivity(), View.OnClickListener, View.OnLongClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        this.tvErrorEmailLogin.isVisible = false;
        this.tvErrorPasswordLogin.isVisible=false;

        this.btnlogin.setOnClickListener(this);
        this.btnlogin.setOnLongClickListener(this);
        /*this.imgbtn_takePhoto.setOnClickListener(this);*/
/*        this.btnOpenNewWindow.setOnClickListener(this);
        this.btnPhoneCall.setOnClickListener(this);
        this.btnOpenMaps.setOnClickListener(this);
        this.btnTakePhoto.setOnClickListener(this);
        this.btnSendMail.setOnClickListener(this);*/


        /*Log.e("Activity",this.toString());
        this.txtEmail.setText("patricio.escuderoprr@uanl.edu.mx");
        this.txtName.setText("Patricio Escudero");
        this.btnAdd.setText("Registrar");

        //Atraves de FindById
        val textEmailVal: EditText = findViewById<EditText>(R.id.txtEmail);
        textEmailVal.setText("patricio.escuderoprr@uanl.edu.mx");
        val textNombreVal: EditText = findViewById<EditText>(R.id.txtName);
        textNombreVal.setText("Eduardo Parra");
        val btnAddObj: Button = findViewById<Button>(R.id.btnAdd);
        btnAdd.setText("Iniciar Sesión");

        this.btnAdd.setOnClickListener(this);
        this.btnAdd.setOnLongClickListener(this);
        this.txtTitle.setOnClickListener(this);

        val persona = Persona("Patricio",28);
        Log.e("Persona",persona.toString());*/
    }

    override fun onResume() {
        super.onResume();

        Log.e("onResume","onResumeFun");

    }

    override fun onClick(v: View?) {

        if (v?.id == R.id.btnlogin) {
            if(this.tbEmailLogin.text.isNotEmpty() && this.tbPasswordLogin.text.isNotEmpty()) {
                //Implementar validaciones en backend

                val signUpActivityIntent: Intent = Intent(this,DashboardActivity::class.java);
                signUpActivityIntent.putExtra("data",this.tbEmailLogin.toString());
                startActivity(signUpActivityIntent);
            }else
            {
                if(this.tbEmailLogin.text.isEmpty())
                    this.tvErrorEmailLogin.isVisible=true;
                else
                    this.tvErrorEmailLogin.isVisible=false;

                if(this.tbPasswordLogin.text.isEmpty())
                    this.tvErrorPasswordLogin.isVisible=true;
                else
                    this.tvErrorPasswordLogin.isVisible=false;
            }

        }

        /* Abrir camara de celular y tomar foto.
        when(v!!.id){
            R.id.imgbtn_takePhoto->{
                val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, 1002);
            }
        }*/
        when(v!!.id){
            R.id.btnOpenNewWindow->openNewWindow();
            R.id.btnPhoneCall->makePhoneCall();
            R.id.btnOpenMaps->openGoogleMaps();
            R.id.btnTakePhoto->takePhoto();
            R.id.btnSendMail->sendMail();
            else->Log.e("Error","Unknown button pressed");
        }



        /*if (v?.id == R.id.btnlogin) {
            /*if(!this.txtEmail.text.isEmpty() || !this.txtName.text.isEmpty()){
                this.txtName.setText("");
                this.txtEmail.setText("");
            }else{
                this.txtName.setText("Patricio Eduardo");
                this.txtEmail.setText("patricio.escudero@uanl.edu.mx");
            }*/
            val activityIntent = Intent(this,CameraActivity::class.java);
            /*activityIntent.putExtra("data",this.txtEmail.text.toString());
            Log.e("SendingInfo", this.txtEmail.text.toString());
            Log.e("ActivityIntent",activityIntent.toString());*/
            startActivity(activityIntent);
        }*/

        /*Utilizando when condition*/
        /*when(v!!.id){
            R.id.btnAdd->Login();
            R.id.txtName->{
                Signup();
            }
            else->{
                Log.e("Error","id no reconocido");
            }
        }*/


    }

    override fun onLongClick(v: View?): Boolean {
        if (v?.id == R.id.btnlogin) {
            val signUpActivityIntent: Intent = Intent(this,SignUpActivity::class.java);
            signUpActivityIntent.putExtra("data",this.tbEmailLogin.toString());
            startActivity(signUpActivityIntent);
        }

        return true;
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == Activity.RESULT_OK){
            if(requestCode == 1002){
                val photo = data?.extras?.get("data")  as Bitmap;
                val stream = ByteArrayOutputStream();

                photo.compress(Bitmap.CompressFormat.JPEG, 100, stream);

                imgPhoto!!.setImageBitmap(photo);
            }
        }
    }

    fun onSignUp(){
        /*if (v?.id == R.id.btnlogin) {
            /*if(!this.txtEmail.text.isEmpty() || !this.txtName.text.isEmpty()){
                this.txtName.setText("");
                this.txtEmail.setText("");
            }else{
                this.txtName.setText("Patricio Eduardo");
                this.txtEmail.setText("patricio.escudero@uanl.edu.mx");
            }*/
            val activityIntent = Intent(this,CameraActivity::class.java);
            /*activityIntent.putExtra("data",this.txtEmail.text.toString());
            Log.e("SendingInfo", this.txtEmail.text.toString());
            Log.e("ActivityIntent",activityIntent.toString());*/
            startActivity(activityIntent);
        }*/

    }

    fun openNewWindow(){
        //Log.e("New Window","New Window button clicked");

        val newWindowIntent = Intent(Intent.ACTION_VIEW, Uri.parse("http://Udemy.com"));
        startActivity(newWindowIntent);

    }

    fun makePhoneCall(){
        //Log.e("New Phone Call","New Phone Call button pressed");
        val newIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9221056183"));
        startActivity(newIntent);
    }

    fun openGoogleMaps(){
        val newIntent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:25.67507,-100.31847"));
        startActivity(newIntent);
    }

    fun takePhoto(){
        //Log.e("Take new photo","Take new photo button clicked");

        val newWindowIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(newWindowIntent);
    }

    fun sendMail(){
        //Log.e("New Window","Send new mail button clicked");

        val newWindowIntent = Intent(Intent.ACTION_SEND);
        newWindowIntent.setType("text/plain");
        newWindowIntent.putExtra(Intent.EXTRA_SUBJECT,"asunto");
        newWindowIntent.putExtra(Intent.EXTRA_TEXT,"Cuerpo del mensaje");
        newWindowIntent.putExtra(Intent.EXTRA_EMAIL,"patricio.escuderoprr@uanl.edu.mx");



        startActivity(newWindowIntent);
    }

    fun Login(){

    }

    private fun Signup(param1:Int=0){
        FuncionesCondicionales();
    }



    fun FuncionesCondicionales(){

        /*if*/
        val valor = if(true) 5  else 10;

        /*when = switch case*/
        when(true){
            true->Log.e("Error","Msj de Error Signup");
            false->Log.e("Error","Msj de Error Login");
            else->Log.e("Error","Msj de Error");
        }

        /*for*/
        val arrayString = arrayListOf<String>("Manzana","Banana");
        for(item:String in arrayString){
            Log.e("item", item);
        }

    }

}
