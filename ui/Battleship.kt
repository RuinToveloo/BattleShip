package cs349.a3battleship

import cs349.a3battleship.model.Game
import cs349.a3battleship.ui.*
import javafx.application.Application
import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.layout.*
import javafx.scene.paint.Color
import javafx.stage.Stage
import javafx.scene.control.Button

class Battleship : Application() {
    @Throws(Exception::class)
    override fun start(stage: Stage) {
        var model = Model()


        // backend
        var game = Game(10, false)
        var computer = AI(game)
        // var player = ...
        game.startGame()



        val view1 = LeftView(model, game)
        val view2 = OperationView(model,game)
        val view3 = RightView(model,game)

        view1.setPrefSize(350.0, 375.0)
        view2.setPrefSize(175.0, 375.0)
        view3.setPrefSize(350.0, 375.0)


        val border = BorderPane()
        border.setBackground(Background(BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)))
        border.setOnMouseMoved  { e->
            model.pos_x = e.x
            model.pos_y = e.y
            // println(e.x.toString() + " " + e.y.toString())
        }
        border.left = view1
        border.right = view3
        border.center = view2



        val scene = Scene(border, 875.0, 375.0)
        stage.title = "A3 Battleship j334hu"
        stage.isResizable = false
        stage.scene = scene
        stage.show()
    }
}
