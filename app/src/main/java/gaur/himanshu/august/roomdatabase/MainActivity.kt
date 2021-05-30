package gaur.himanshu.august.roomdatabase

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import gaur.himanshu.august.roomdatabase.databinding.ActivityMainBinding
import gaur.himanshu.august.roomdatabase.mvvm.PersonViewModel
import gaur.himanshu.august.roomdatabase.mvvm.room.Person

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {


    val viewModel: PersonViewModel by viewModels()

    val personAdapter = PersonAdapter()

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel.getAllPersons()

        binding.roomRecycler.apply {
            adapter = personAdapter
        }

        binding.saveDataButton.setOnClickListener {


            val person = Person(
                    name = binding.personName.text.toString().trim(),
                    age = binding.personAge.text.toString().trim().toInt()
            )

            viewModel.insert(person)

        }

        viewModel.list.observe(this) {
            it?.let {
                personAdapter.setContentList(it)
            }
        }


        personAdapter.setOnLongItemClickListener {
            viewModel.delete(it)
        }

    }
}