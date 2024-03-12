package mx.edu.potros.examenu2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import org.w3c.dom.Text

class DetalleRegalos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_regalos)
        val iv_regalo_imagen: ImageView = findViewById(R.id.iv_regalo_imagen)
        val tv_regalo_precio: TextView = findViewById(R.id.tv_regalo_precio)

        val bundle = intent.extras
        if (bundle != null){
            iv_regalo_imagen.setImageResource(bundle.getInt("image"))
            tv_regalo_precio.setText(bundle.getString("precio"))
        }
    }
}