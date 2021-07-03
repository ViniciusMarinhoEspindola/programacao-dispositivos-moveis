package com.vinicius.app5_cadastro

import android.content.DialogInterface
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.vinicius.app5_cadastro.Usuario
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var foto: ImageView
    private lateinit var btnFoto: Button
    private lateinit var nome: EditText
    private lateinit var idade: EditText
    private lateinit var btnSalvar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        foto = findViewById(R.id.imgFoto)
        btnFoto = findViewById(R.id.btnFoto)
        nome = findViewById(R.id.nome)
        idade = findViewById(R.id.idade)
        btnSalvar = findViewById(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            val intent = Intent(this@MainActivity, SecondActivity::class.java)

            val usuario = Usuario(nome = nome.text.toString(), idade = idade.text.toString().toInt())
            intent.putExtra("USUARIO", usuario)

            startActivity(intent)
        }

        btnFoto.setOnClickListener {
            abrirCamera()
        }
    }

    fun abrirCamera() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if(intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, 12345)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == 12345 && resultCode == RESULT_OK){
            val fotoTirada = data?.extras?.get("data") as Bitmap
            foto.setImageBitmap(fotoTirada)
        }
    }

    override fun onBackPressed() {
        var dialog = AlertDialog.Builder(this@MainActivity)
        dialog.setTitle("Confirmação")
        dialog.setPositiveButton("Sim", DialogInterface.OnClickListener{ dialogInterface, i ->  super.onBackPressed()})
        dialog.create().show()
    }
}