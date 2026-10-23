package com.example.lab7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainActivity

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // navigate to race screen
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // verify race screen
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // enter race location
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // add race location
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // verify race appears
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }

    @Test
    fun navigate_to_driver_add_and_driver_clear_and_return_home() {
        // navigate to driver screen
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // verify screen
        composeTestRule
            .onNodeWithText("Race Drivers")
            .assertExists()

        // enter driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Kimi Antonelli")

        // add driver name
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver name appears
        composeTestRule
            .onNodeWithText("Kimi Antonelli")
            .assertExists()

        // enter driver name
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Oliver Bearman")

        // add driver name
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify driver name appears
        composeTestRule
            .onNodeWithText("Oliver Bearman")
            .assertExists()

        //clear drivers
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        //verify
        composeTestRule
            .onNodeWithText("Oliver Bearman")
            .assertDoesNotExist()

        //verify
        composeTestRule
            .onNodeWithText("Kimi Antonelli")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}