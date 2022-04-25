package cl.desafiolatm.desafio6.ui

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import cl.desafiolatm.desafio6.R
import cl.desafiolatm.desafio6.adapter.TareaAdapter
import cl.desafiolatm.desafio6.databinding.FragmentListaBinding
import cl.desafiolatm.desafio6.modelo.Tarea
import cl.desafiolatm.desafio6.viewmodel.TareaViewModel

class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding
    val viewModel: TareaViewModel by activityViewModels<TareaViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaBinding.inflate(inflater,container,false)

        val adapter = TareaAdapter()
        val manager = LinearLayoutManager(context)

        adapter.setOnClickListener(object : TareaAdapter.MiOnClickListener{
            override fun onClickListener(tarea: Tarea) {
                viewModel.tareaMutable.value = tarea
                Navigation.findNavController(requireView()).navigate(R.id.action_listaFragment_to_detalleFragment)
            }

            override fun onDeleteListener(tarea: Tarea) {
                val alerta = AlertDialog.Builder(requireContext())
                alerta.setTitle("Eliminar")
                alerta.setMessage("¿Seguro desea eliminar la tarea?")
                alerta.setPositiveButton("Si", DialogInterface.OnClickListener { dialog, which ->
                    viewModel.eliminar(tarea)
                })
                alerta.setNegativeButton("No", DialogInterface.OnClickListener { dialog, which ->
                    dialog.cancel()
                })
                alerta.show()
            }
        })

        with(binding){
            rvLista.adapter = adapter
            rvLista.layoutManager = manager
            fbtnAdd.setOnClickListener {
                Navigation.findNavController(requireView()).navigate(R.id.action_listaFragment_to_agregarFragment)
            }
        }

        viewModel.lista.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })

        return binding.root
    }
}