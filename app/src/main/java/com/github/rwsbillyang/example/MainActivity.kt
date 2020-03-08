package com.github.rwsbillyang.example

import android.graphics.BlurMaskFilter
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Toast
import com.github.rwsbillyang.dslspan.span
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myTextView.apply {
            text = span {
                font("serif") { +"I am font" }
                ln()
                bold { +"bold text" }
                ln()
                italic { +"italic" }
                ln()
                boldItalic { +"boldItalic" }
                ln()
                absoluteSize(30) { +"30sp font Size" }
                ln()
                relativeSize(1.5F) { +"1.5 times font Size" }
                ln()
                xScale(2.0F) { +"xScale with 2" }
                ln()
                strike { +"strike me" }
                ln()
                underline { +"underline me" }
                ln()
                +"Y";superscript { +"2" }
                ln()
                +"X";subscript { +"2" }
                ln()
                backgroundColor(Color.RED) { +"backgroundColor with red" }
                ln()
                color(Color.BLUE) { +"foregroundColor with BLUE" }
                ln()
                maskFilter(BlurMaskFilter(5f, BlurMaskFilter.Blur.NORMAL)) { +"blur text" }
                ln()
                clickable({ Toast.makeText(this@MainActivity,"you clicked me",Toast.LENGTH_SHORT).show() }) { +"clickme" }
                ln()
                url("tel:18612345678") { +"contact me" }
                ln()
                +"drawale:"
                drawable(getResources().getDrawable(R.drawable.ic_launcher_foreground)) { +"drawale" }
                ln()
                bullet { +"bullet1" }
                ln()
                bullet { +"bullet2" }
                ln()
                relativeSize(2.0F) { color(Color.RED) { +"惊爆价：￥99" } }
                +"原价："
                strike { relativeSize(0.8F) { color(Color.GRAY) { +"￥399" } } }
            }
            //url跳转时需要
            movementMethod = LinkMovementMethod.getInstance()
        }
    }
}
