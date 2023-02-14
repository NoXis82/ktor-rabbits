package com.example.routes

import com.example.data.model.Rabbit
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

//127.0.0.1
//192.168.0.109
//10.0.2.2:8080
private const val BASE_URL: String = "http://192.168.0.109:8080"
private val rabbits = listOf(
    Rabbit("Carl", "A cute brown rabbit", "$BASE_URL/rabbits/rabbit1.jpg"),
    Rabbit("Emma", "Emma likes to eat apples", "$BASE_URL/rabbits/rabbit2.jpg"),
    Rabbit("Florian", "Florian is always hungry", "$BASE_URL/rabbits/rabbit3.jpg"),
    Rabbit("Federico", "Federico likes to climb mountains", "$BASE_URL/rabbits/rabbit4.jpg"),
    Rabbit("Gina", "Gina is a true beauty", "$BASE_URL/rabbits/rabbit5.jpg"),
)

fun Route.randomRabbit() {
    get("/randomrabbit") {
        //call.parameters["rabbitId"]
        call.respond(
            HttpStatusCode.OK,
            rabbits.random()
            )
    }
}