package cl.desafiolatm.desafio6.ui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.desafiolatm.desafio6.R
import cl.desafiolatm.desafio6.databinding.FragmentDetalleBinding
import cl.desafiolatm.desafio6.viewmodel.TareaViewModel
import java.text.SimpleDateFormat
import java.util.*

class DetalleFragment : Fragment() {

    private lateinit var binding: FragmentDetalleBinding
    val viewModel: TareaViewModel by activityViewModels<TareaViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetalleBinding.inflate(inflater,container,false)

        viewModel.tareaMutable.observe(viewLifecycleOwner, androidx.lifecycle.Observer {
            with(binding){
                val tarea = it
                tvId.text = it.id.toString()
                etTareaDetalle.text = Editable.Factory.getInstance().newEditable(it.tarea)
                val sdf = SimpleDateFormat("dd/MM/yyyy")
                etFechaDetalle.text = sdf.format(it.fecha)

                etFechaDetalle.setOnClickListener {
                    val c = Calendar.getInstance()
                    c.time = tarea.fecha
                    val anio = c.get(Calendar.YEAR)
                    val mes = c.get(Calendar.MONTH)
                    val dia = c.get(Calendar.DAY_OF_MONTH)

                    val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                        etFechaDetalle.text = "$dayOfMonth/${month+1}/$year"
                    }
                    val dpd = DatePickerDialog(requireContext(),dateSetListener,anio,mes,dia)
                    dpd.show()
                }

                btnEditar.setOnClickListener {
                    val tarea1 = etTareaDetalle.text.toString()
                    val fecha = etFechaDetalle.text.toString()
                    viewModel.editar(tarea.id, tarea1, fecha)
                    val alerta = AlertDialog.Builder(requireContext())
                    alerta.setTitle("Editada")
                    alerta.setMessage("Su tarea fue actualizada exitosamente")
                    alerta.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                        dialog.cancel()
                    })
                    alerta.show()
                }
            }
        })

        return binding.root
    }

    private fun showDate()
    {
        val c = Calendar.getInstance()
        val anio = c.get(Calendar.YEAR)
        val mes = c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH)
        binding.etFechaDetalle.text = "$dia/${mes+1}/$anio"
    }
}