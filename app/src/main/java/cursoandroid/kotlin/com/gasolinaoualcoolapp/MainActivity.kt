package cursoandroid.kotlin.com.gasolinaoualcoolapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularPreco(view: View) {

        //recuperar valores digitados
        val precoAlcool = preçoAlcool.text.toString()
        val precoGasolina = preçoGasolina.text.toString()

        val validarCampos = validarCampos(precoAlcool, precoGasolina)
        if (validarCampos) {
            calcularMelhorPreco(precoAlcool, precoGasolina)
        } else {
            id_exibirResultado.text = "Preencha os campos corretamente"
        }
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina

        if (resultadoPreco >= 0.7) {
            id_exibirResultado.text = "Melhor utilizar Gasolina!"
        } else {
            id_exibirResultado.text = "Melhor utilizar Álcool!"
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {
        var camposValidados: Boolean = true
        if (precoAlcool == null || precoAlcool.equals("")) {
            camposValidados = false
        } else if (precoGasolina == null || precoGasolina.equals("")) {
            camposValidados = false
        }
        return camposValidados
    }

}