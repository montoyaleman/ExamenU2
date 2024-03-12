package mx.edu.potros.examenu2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

class Regalos : AppCompatActivity() {
    var adapter: RegalosAdapter? = null
    var regalos = ArrayList<Detalles>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regalos)

        var menuOption: String? = intent.getStringExtra("menuType")
        cargarRegalos(menuOption)

        adapter = RegalosAdapter(this, regalos)
        var gridRegalos: GridView = findViewById(R.id.detalles_catalogo)

        gridRegalos.adapter = adapter



    }

    fun cargarRegalos(option: String?){
        when(option){
            "detalles" -> {
                regalos.add(Detalles(R.drawable.cumplebotanas, "$280"))
                regalos.add(Detalles(R.drawable.cumplecheve, "$320"))
                regalos.add(Detalles(R.drawable.cumpleescolar, "$330"))
                regalos.add(Detalles(R.drawable.cumplepaletas, "$190"))
                regalos.add(Detalles(R.drawable.cumplesnack, "$150"))
                regalos.add(Detalles(R.drawable.cumplevinos, "$370"))
            }

            "globos" -> {
                regalos.add(Detalles(R.drawable.globoamor, "$240"))
                regalos.add(Detalles(R.drawable.globocumple, "$820"))
                regalos.add(Detalles(R.drawable.globofestejo, "$260"))
                regalos.add(Detalles(R.drawable.globonum, "$760"))
                regalos.add(Detalles(R.drawable.regalos, "$450"))
                regalos.add(Detalles(R.drawable.globos, "$240"))
            }

            "peluches" -> {
                regalos.add(Detalles(R.drawable.peluchemario, "$320"))
                regalos.add(Detalles(R.drawable.pelucheminecraft, "$320"))
                regalos.add(Detalles(R.drawable.peluchepeppa, "$290"))
                regalos.add(Detalles(R.drawable.globonum, "$300"))
                regalos.add(Detalles(R.drawable.peluches, "$330"))
                regalos.add(Detalles(R.drawable.peluchesony, "$280"))
                regalos.add(Detalles(R.drawable.peluchestich, "$195"))
                regalos.add(Detalles(R.drawable.peluchevarios, "$195"))
            }

            "regalos" -> {
                regalos.add(Detalles(R.drawable.regaloazul, "$80"))
                regalos.add(Detalles(R.drawable.regalobebe, "$290"))
                regalos.add(Detalles(R.drawable.regalocajas, "$140"))
                regalos.add(Detalles(R.drawable.regalocolores, "$85"))
                regalos.add(Detalles(R.drawable.regalos, "$330"))
                regalos.add(Detalles(R.drawable.regalovarios, "$75"))
            }

            "tazas" -> {
                regalos.add(Detalles(R.drawable.tazaabuela, "$120"))
                regalos.add(Detalles(R.drawable.tazalove, "$120"))
                regalos.add(Detalles(R.drawable.tazaquiero, "$260"))
                regalos.add(Detalles(R.drawable.tazas, "$280"))
            }
        }


    }

    class RegalosAdapter: BaseAdapter {
        var regalos = ArrayList<Detalles>()
        var context: Context? = null

        constructor(context: Context, regalos: ArrayList<Detalles>) : super() {
            this.regalos = regalos
            this.context = context
        }

        override fun getCount(): Int {
            return regalos.size
        }

        override fun getItem(position: Int): Any {
            return regalos[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var regalo = regalos[position]
            var inflator =
                context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

            var vista = inflator.inflate(R.layout.activity_detalle_regalos, null)
            var image: ImageView = vista.findViewById(R.id.iv_regalo_imagen)
            var precio: TextView = vista.findViewById(R.id.tv_regalo_precio)

            image.setImageResource(regalo.image)
            precio.setText(regalo.precio)

            image.setOnClickListener() {
                val intento = Intent(context, DetalleRegalos::class.java)

                intento.putExtra("precio", regalo.precio)
                intento.putExtra("image", regalo.image)

                context!!.startActivity(intento)
            }
            return vista
        }
    }
}