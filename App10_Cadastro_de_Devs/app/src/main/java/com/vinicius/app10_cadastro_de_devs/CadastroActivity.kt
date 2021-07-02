package com.vinicius.app10_cadastro_de_devs

import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.*
//import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var stack: Stack
    lateinit var senioridade: Senioridade
    lateinit var spnSenioridade: Spinner
    lateinit var edtNome: EditText
    lateinit var edtEmail: EditText
    lateinit var btnSalvar: Button
    lateinit var imvFoto: ImageView
    var fotoTirada: Bitmap?=null
    lateinit var swtEmpregado: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        edtNome = findViewById(R.id.edtNome)
        edtEmail = findViewById(R.id.edtEmail)
        spnSenioridade = findViewById(R.id.spnSenioridade)
        btnSalvar = findViewById(R.id.btnSalvar)
        imvFoto = findViewById(R.id.imvFoto)
        swtEmpregado = findViewById(R.id.swtEmpregado)

        // Intent para chamar a Câmera
        imvFoto.setOnClickListener(){
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

            if (intent.resolveActivity(packageManager) != null)
                startActivityForResult(intent, RC_CAMERA)
        }

        // Aqui estamos implementando o "Adapter" do Spinner (Combo), consumindo o array no arquivo strings.xml
        ArrayAdapter.createFromResource(this, R.array.opcoes_spinner, android.R.layout.simple_spinner_item).also { arrayAdapter ->
            arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spnSenioridade.adapter = arrayAdapter
        }

        spnSenioridade.onItemSelectedListener = this

        btnSalvar.setOnClickListener(){
            val usuario = Usuario(fotoTirada, edtNome.text.toString(), edtEmail.text.toString(), stack, senioridade, swtEmpregado.isChecked)
            MainActivity.lista.add(usuario)
            finish()
        }
    }

    fun OnStackClick(view: View){
        if (view is RadioButton){
            var checked = view.isChecked

            when (view.id){
                R.id.rdbFrontEnd -> { if (checked) {stack = Stack.FRONTEND}}
                R.id.rdbBackEnd -> { if (checked) {stack = Stack.BACKEND}}
                R.id.rdbFullStack -> { if (checked) {stack = Stack.FULLSTACK}}
            }
        }
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        when (p2){
            0 -> {senioridade = Senioridade.JUNIOR}
            1 -> {senioridade = Senioridade.PLENO}
            2 -> {senioridade = Senioridade.SENIOR}
        }
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if ((resultCode == RESULT_OK) && (requestCode == RC_CAMERA)){
            fotoTirada = data?.extras?.get("data") as Bitmap
            imvFoto.setImageBitmap(fotoTirada)
        }
    }

    companion object{
        const val RC_CAMERA  = 12345
        const val RC_GALERIA = 67890
    }
}
