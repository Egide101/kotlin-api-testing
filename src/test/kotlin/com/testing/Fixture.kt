package com.testing

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import org.junit.Assert
import java.net.URL

class Fixture{
    private val baseUrl = "http://localhost:3000"
    var completeEndPoint: StringBuffer = StringBuffer(baseUrl)

    @Given("I use the api endpoint {string}")
    fun i_use_the_api_endpoint(endpoint: String) {
        completeEndPoint.append(endpoint)
    }

    @Given("I use a http Get method")
    fun i_use_a_http_Get_method() {

    }

    @Given("the fixture id is {string}")
    fun the_fixture_id_is(fixtureId: String) {
        completeEndPoint.append(fixtureId)
    }

    @Then("there is a response")
    fun there_is_a_response() {
        val result = URL(completeEndPoint.toString()).readText()
        println(result)

        Assert.assertNotNull(result)
    }
}