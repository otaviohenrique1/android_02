package br.com.alura.orgs.ui.activty

import android.content.Intent
import android.os.Bundle
//import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import br.com.alura.orgs.R
import br.com.alura.orgs.dao.ProdutoDAO
import br.com.alura.orgs.ui.recyclerview.adapter.ListaProdutosAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaProdutosActivity : AppCompatActivity(R.layout.lista_produtos_activity) {
    private val dao = ProdutoDAO()
    private val adapter = ListaProdutosAdapter(
        context = this,
        produtos = dao.buscaTodos()
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configuraReciclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_lista_produtos_fab)
        fab.setOnClickListener {
            vaiParaFormularioProduto()
        }
    }

    private fun vaiParaFormularioProduto() {
        // Navegação entre telas
        val intent = Intent(this, FormularioProdutoActivity::class.java)
        startActivity(intent)
    }

    private fun configuraReciclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_lista_produtos_recyclerView)
//        Log.i("MainActivity", "onCreate: ${dao.buscaTodos()}")
        recyclerView.adapter = adapter
    }
}