package com.muzafakar.workshop.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.bumptech.glide.Glide
import com.muzafakar.workshop.R
import com.muzafakar.workshop.model.Mahasiswa
import kotlinx.android.synthetic.main.item_mahasiswa.view.*

// Inheritance -> pewarisan sifat (BaseAdapter)
class AdapterMahasiswa(private val callback: (Mahasiswa) -> Unit) : BaseAdapter() {
    private val listMahasiswa = mutableListOf<Mahasiswa>()

    fun addData(data: List<Mahasiswa>) {
        listMahasiswa.addAll(data)
        notifyDataSetChanged()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val v =
            LayoutInflater.from(parent!!.context).inflate(R.layout.item_mahasiswa, parent, false)

        v.tvNama.text = listMahasiswa[position].nama
        v.tvNpm.text = listMahasiswa[position].npm
        v.tvPhone.text = listMahasiswa[position].phone

        Glide.with(v).load(listMahasiswa[position].imgUrl).into(v.imgProfile)

        v.setOnClickListener {
            callback(listMahasiswa[position])
        }

        return v
    }

    override fun getItem(position: Int): Any {
        return listMahasiswa[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return listMahasiswa.size
    }
}