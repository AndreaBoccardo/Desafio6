package cl.desafiolatm.desafio6.ui

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.desafiolatm.desafio6.R
import cl.desafiolatm.desafio6.databinding.FragmentAgregarBinding
import cl.desafiolatm.desafio6.viewmodel.TareaViewModel
import java.util.*

class AgregarFragment : Fragment() {

    private lateinit var binding: FragmentAgregarBinding
    val viewModel: TareaViewModel by activityViewModels<TareaViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAgregarBinding.inflate(inflater,container,false)
        showDate()

        with(binding){
            etFecha.setOnClickListener {
                val c = Calendar.getInstance()
                val anio = c.get(Calendar.YEAR)
                val mes = c.get(Calendar.MONTH)
                val dia = c.get(Calendar.DAY_OF_MONTH)

                val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    etFecha.text = "$dayOfMonth/${month+1}/$year"
                }
                val dpd = DatePickerDialog(requireContext(),dateSetListener,anio,mes,dia)
                dpd.show()
            }

            btnAgregar.setOnClickListener {
                val tarea = etTarea.text.toString()
                val fecha = etFecha.text.toString()
                viewModel.agregar(tarea, fecha)
                val alerta = AlertDialog.Builder(requireContext())
                alerta.setTitle(getString(R.string.agregada))
                alerta.setMessage("Su tarea fue agregada exitosamente")
                alerta.setPositiveButton("ok", DialogInterface.OnClickListener { dialog, which ->
                    dialog.cancel()
                })
                alerta.show()
                showDate()
                etTarea.text.clear()
            }
        }

        return binding.root
    }

    private fun showDate()
    {
        val c = Calendar.getInstance()
        val anio = c.get(Calendar.YEAR)
        val mes = c.get(Calendar.MONTH)
        val dia = c.get(Calendar.DAY_OF_MONTH)
        binding.etFecha.text = "$dia/${mes+1}/$anio"
    }
}