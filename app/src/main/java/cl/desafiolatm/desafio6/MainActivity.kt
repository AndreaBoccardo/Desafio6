package cl.desafiolatm.desafio6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import cl.desafiolatm.desafio6.databinding.ActivityMainBinding
import cl.desafiolatm.desafio6.viewmodel.TareaViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    val viewModel: TareaViewModel by viewModels<TareaViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}