package mx.edu.potros.examenu2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Principal : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        val btn_detalles: Button = findViewById(R.id.btn_detalles)
        val btn_globos: Button = findViewById(R.id.btn_globos)
        val btn_peluches: Button = findViewById(R.id.btn_peluches)
        val btn_regalos: Button = findViewById(R.id.btn_regalos)
        val btn_tazas: Button = findViewById(R.id.btn_tazas)

        btn_detalles.setOnClickListener {
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "detalles")
            startActivity(intent)
        }

        btn_globos.setOnClickListener {
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "globos")
            startActivity(intent)
        }

        btn_peluches.setOnClickListener {
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "peluches")
            startActivity(intent)
        }

        btn_regalos.setOnClickListener {
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "regalos")
            startActivity(intent)
        }

        btn_tazas.setOnClickListener {
            var intent : Intent = Intent(this, Regalos::class.java)
            intent.putExtra("menuType", "tazas")
            startActivity(intent)
        }
    }
}