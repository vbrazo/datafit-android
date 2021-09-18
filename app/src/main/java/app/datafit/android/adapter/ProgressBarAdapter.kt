package app.datafit.android.adapter

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import app.datafit.android.*

class ProgressBarAdapter : RecyclerView.Adapter<ProgressBarHolder>() {
    override fun getItemCount(): Int = App.getExerciseTrainingCount().toInt()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProgressBarHolder {
        val layoutInflater=LayoutInflater.from(parent?.context)
        val cellRow=layoutInflater.inflate(R.layout.singlerow_layout_progressbar,parent,false)
        return ProgressBarHolder(cellRow)
    }
    override fun onBindViewHolder(holder: ProgressBarHolder, position: Int) {
        holder.bindItems()
    }
}

class ProgressBarHolder(view: View): RecyclerView.ViewHolder(view) {
    fun bindItems() {
        try {
        }catch (e:Exception){
            println(e.message)
        }
    }
}