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

        /** initialize our _list for observing data from the Room*/
        viewModel.getAllPersons()

        /** attach adapter to the recycler view*/
        binding.roomRecycler.apply {
            adapter = personAdapter
        }

        /** handle the save button */
        binding.saveDataButton.setOnClickListener {
            val person = Person(
                    name = binding.personName.text.toString().trim(),
                    age = binding.personAge.text.toString().trim().toInt()
            )
            viewModel.insert(person)
        }

        /** observe the viewmodel list */
        viewModel.list.observe(this) {
            it?.let {
                personAdapter.setContentList(it)
            }
        }

        /** delete the adapter list item*/
        personAdapter.setOnLongItemClickListener {
            viewModel.delete(it)
        }

    }
}