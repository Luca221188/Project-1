package com.example.shoesapp

import android.content.Context
import android.text.Html
import android.text.Spanned
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.my_custom_view.view.*

class MyCustomView(context: Context): LinearLayout(context) {
    init {
        inflate(context, R.layout.my_custom_view, this)
    }

    fun setShoeName(name: String) {
        shoe_name.text = getSpannedString(name, R.string.shoe_name_format)
    }

    fun setShoeSize(size: Double) {
        shoe_size.text = getSpannedString(size.toString(), R.string.shoe_size_format)
    }

    fun setCompany(company: String) {
        shoe_company.text = getSpannedString(company, R.string.shoe_company_format)
    }

    fun setDescription(description: String) {
        shoe_description.text = getSpannedString(description, R.string.shoe_description_format)
    }

    fun setImage(resource: String) {
        //add an image based on the identifier
//        var id:Int = resources.getIdentifier(resource, "drawable", context.packageName)
//        if(id == 0) {
//           id = resources.getIdentifier("default_color", "color", context.packageName)
//        }
//        shoe_image.setImageResource(id)

        val id: Int
        //add image with Glide
        if (resource == "") {
//            Glide.with(this.context).load(R.color.default_image).into(shoe_image)
            id = resources.getIdentifier("default_image", "color", context.packageName)
            shoe_image.setImageResource(id)
            return
        }
        id = resources.getIdentifier(resource, "drawable", context.packageName)
        Glide.with(this.context)
            .load(id)
            .into(shoe_image)
    }

    private fun getSpannedString(resource: String, stringId: Int): Spanned {
        val string = String.format(resources.getString(stringId), resource)
        return Html.fromHtml(string, Html.FROM_HTML_MODE_COMPACT)
    }
}