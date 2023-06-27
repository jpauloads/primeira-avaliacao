package com.example.prova1

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ListView
import android.widget.RadioButton
import android.widget.Spinner
import android.widget.Toast
import java.lang.Float

class MainActivity : AppCompatActivity() {


    private lateinit var it_nome : EditText
    private lateinit var it_car : EditText
    private lateinit var it_cnpj : EditText
    private lateinit var it_caixa : EditText
    private lateinit var it_bacon : EditText
    private lateinit var it_prod_leite : EditText
    private lateinit var cb_silo : CheckBox
    private lateinit var bt_inserir : Button
    private lateinit var bt_mostrar : Button
    private lateinit var lv_fazendas : ListView

    private lateinit var radioLavoura : RadioButton
    private lateinit var radioPorco : RadioButton
    private lateinit var radioVaca : RadioButton


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        it_nome = findViewById(R.id.it_nome)
        it_car = findViewById(R.id.it_car)
        it_cnpj = findViewById(R.id.it_cnpj)
        it_caixa = findViewById(R.id.it_caixa)
        it_bacon = findViewById(R.id.it_bacon)
        it_prod_leite = findViewById(R.id.it_prod_leite)
        cb_silo = findViewById(R.id.cb_silo)
        bt_inserir = findViewById(R.id.bt_inserir)
        bt_mostrar = findViewById(R.id.bt_mostrar)
        lv_fazendas = findViewById(R.id.lv_fazenda)

        radioLavoura = findViewById(R.id.radioLavoura)
        radioPorco = findViewById(R.id.radioPorco)
        radioVaca = findViewById(R.id.radioVaca)


        val listaFazendas = ArrayList<Fazenda>()
//        val listaPorcos = ArrayList<Porcos>()
//        val listaVacasLeiteiras = ArrayList<VacasLeiteiras>()

        //CONDICIONAL PARA APARECER OS CAMPOS A SEREM PREENCHIDOS DE ACORDO COM O SELECIONADO NO SPINNER
        radioLavoura.setOnClickListener {
            radioPorco.isChecked = false
            radioVaca.isChecked = false
            cb_silo.visibility = View.VISIBLE
            it_bacon.visibility = View.INVISIBLE
            it_prod_leite.visibility = View.INVISIBLE

            bt_inserir.setOnClickListener {
                if (testaCNPJ(listaFazendas, it_cnpj.text.toString())) {
                    val lavoura = Lavoura(
                        nome = it_nome.text.toString(),
                        car = it_car.text.toString(),
                        caixa = Float.parseFloat(it_caixa.text.toString()),
                        cnpj = it_cnpj.text.toString(),
                        silo = cb_silo.isChecked
                    )
                    listaFazendas.add(lavoura)
                    limparTela()
                } else {
                    Toast.makeText(this@MainActivity, "CNPJ já cadastrado", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }
        radioVaca.setOnClickListener {
            radioLavoura.isChecked = false
            radioPorco.isChecked = false
            it_prod_leite.visibility = View.VISIBLE
            it_bacon.visibility = View.INVISIBLE
            cb_silo.visibility = View.INVISIBLE

            bt_inserir.setOnClickListener {
                Log.i("teste", listaFazendas.toString())
                if (testaCNPJ(listaFazendas, it_cnpj.text.toString())) {
                    val vaca = VacasLeiteiras(
                        nome = it_nome.text.toString(),
                        car = it_car.text.toString(),
                        caixa = Float.parseFloat(it_caixa.text.toString()),
                        cnpj = it_cnpj.text.toString(),
                        prodDiariaLitros = Float.parseFloat(it_prod_leite.text.toString())
                    )
                    listaFazendas.add(vaca)
                    limparTela()
                } else {
                    Toast.makeText(this@MainActivity, "CNPJ já cadastrado", Toast.LENGTH_SHORT)
                        .show()
                }
            }

        }
        radioPorco.setOnClickListener {
            radioLavoura.isChecked = false
            radioVaca.isChecked = false
            it_bacon.visibility = View.VISIBLE
            it_prod_leite.visibility = View.INVISIBLE
            cb_silo.visibility = View.INVISIBLE

            bt_inserir.setOnClickListener {
                if (testaCNPJ(listaFazendas, it_cnpj.text.toString())) {
                    val porco = Porcos(
                        nome = it_nome.text.toString(),
                        car = it_car.text.toString(),
                        caixa = Float.parseFloat(it_caixa.text.toString()),
                        cnpj = it_cnpj.text.toString(),
                        kgBacon = Float.parseFloat(it_bacon.text.toString())
                    )
                    listaFazendas.add(porco)
                    limparTela()
                } else {
                    Toast.makeText(this@MainActivity, "CNPJ já cadastrado", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }


        }



    fun limparTela() {
        it_nome.text.clear()
        it_car.text.clear()
        it_caixa.text.clear()
        it_cnpj.text.clear()
        it_prod_leite.text.clear()
        cb_silo.isChecked = false
        it_bacon.text.clear()
        it_prod_leite.visibility = View.INVISIBLE
        cb_silo.visibility = View.INVISIBLE
        it_bacon.visibility = View.INVISIBLE
    }

    fun testaCNPJ(listaFazendas: ArrayList<Fazenda>, cnpj: String): Boolean {
        val testaNull = listaFazendas.find { it.cnpj == cnpj }
        if(testaNull != null){
            return false
        }else{
            return true
        }

    }
}