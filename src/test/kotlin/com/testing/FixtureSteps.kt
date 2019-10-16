package com.testing

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import models.Fixture
import org.junit.Assert
import java.net.URL

class FixtureSteps {
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
        val jsonFixture = URL(completeEndPoint.toString()).readText()

        Assert.assertNotNull(jsonFixture)
    }

    lateinit var fixtures: List<Fixture>

    @Then("{int} fixtures are returned in the response")
    fun fixtures_are_returned_in_the_response(numberOfFixtures: Int) {
        val jsonFixture = URL(completeEndPoint.toString()).readText()

        println(jsonFixture)

        val mapper = jacksonObjectMapper()

        fixtures = mapper.readValue(jsonFixture)

        Assert.assertEquals(fixtures.count(), numberOfFixtures)
    }

    @Then("each fixture has a fixture id")
    fun each_fixture_has_a_fixture_id() {
        for (fixture in fixtures) {
            Assert.assertNotNull(fixture.fixtureId)
        }
    }
}