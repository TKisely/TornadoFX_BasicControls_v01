package com.example.demo.view

import com.example.demo.app.Styles
import javafx.scene.control.Button
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import tornadofx.*

class MainView : View("Builders") {
//    override val root = VBox()

    val buttonApplyView:ButtonApplyView by inject()

    override  val root = buttonApplyView.root
    init {
        with(root) {
            this += Button("Press Me Main")
        }
    }
}

class OtherView:View("Other View"){

    override val root = vbox {
        button("Press Me Root") {
            textFill = Color.BLUE
            action { println("BLUE Button pressed!") }
        }
    }

    init {
        root.apply {
            this += Button("Press Me Other")
        }
    }
}

class ButtonApplyView:View("Button Apply"){

    val otherView:OtherView by inject()
    override  val root = otherView.root

    init {
        with(root) {
            this += Button("Press Me Apply").apply {
                textFill = Color.RED
                action { println("RED Button pressed!") }
            }
        }
    }
}