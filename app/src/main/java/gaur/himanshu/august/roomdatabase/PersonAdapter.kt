package gaur.himanshu.august.roomdatabase


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import gaur.himanshu.august.roomdatabase.databinding.PersonViewholderBinding
import gaur.himanshu.august.roomdatabase.mvvm.room.Person

class PersonAdapter : RecyclerView.Adapter<PersonAdapter.MyViewHolder>() {


    var list = mutableListOf<Person>()

    var setOnItemLongClickListener : ((Person)->Unit)?=null

    fun setContentList(list: List<Person>) {
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }


    fun setOnLongItemClickListener(listner:(Person)->Unit){
        setOnItemLongClickListener=listner
    }

    inner class MyViewHolder(val viewDataBinding: PersonViewholderBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonAdapter.MyViewHolder {
        val binding= PersonViewholderBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PersonAdapter.MyViewHolder, position: Int) {
      holder.viewDataBinding.person= list[position]

        holder.viewDataBinding.root.setOnLongClickListener {
            setOnItemLongClickListener?.let {
                it(list[position])
            }
            return@setOnLongClickListener  true
        }

    }

    override fun getItemCount(): Int {
      return this.list.size
    }
}