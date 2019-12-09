package com.example.restkotlinized.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.restkotlinized.databinding.ListItemBinding
import com.example.restkotlinized.model.Results
import com.jakewharton.rxbinding2.view.RxView
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.BehaviorSubject
import io.reactivex.subjects.PublishSubject
import kotlin.collections.ArrayList

class NewsAdapter(val results: ArrayList<Results>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    companion object {
        private val clickSubject = BehaviorSubject.create<Results>()
        val clickObservable: Observable<Results> =
            clickSubject.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())

        private val switchSubject = PublishSubject.create<Any>()
        val switchObservable: Observable<Any> = switchSubject.observeOn(AndroidSchedulers.mainThread())
    }

    private var disposableSetItem: Disposable? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = results.let { results.size }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(results[position])

    override fun onViewDetachedFromWindow(holder: ViewHolder) {
        super.onViewDetachedFromWindow(holder)
        disposableSetItem?.dispose()
    }


    inner class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(artist: Results) {
            binding.artist = artist
            binding.executePendingBindings()

            disposableSetItem = RxView.clicks(binding.root).subscribe {
                clickSubject.onNext(results[layoutPosition])
                switchSubject.onNext(Any())
            }
        }
    }
}