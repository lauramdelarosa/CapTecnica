package com.delarosa.mybank.ui

import com.delarosa.mybank.ui.login.LoginViewModel
import junit.framework.Assert.*
import org.junit.Before
import org.junit.Test

class LoginViewModelTest {

    private lateinit var viewModel: LoginViewModel

    @Before
    fun setUp() {
        viewModel = LoginViewModel()
    }

    @Test
    fun emptyDataValidateData() {
        // Arrange


        // Act
        val costumerId = ""
        val password = ""

        // Assert
        assertEquals(viewModel.validateData(costumerId, password), false)
    }

    @Test
    fun validDataValidateData() {
        // Arrange

        // Act
        val costumerId = "12345"
        val password = "laura123"

        // Assert
        assertTrue(viewModel.validateData(costumerId, password))
    }


    @Test
    fun notValidText() {
        // Arrange
        // Act
        val text = ""
        // Assert
        assertFalse(viewModel.isValidText(text))
    }

    @Test
    fun validText() {
        // Arrange
        // Act
        val text = "abcd"
        // Assert
        assertTrue(viewModel.isValidText(text))
    }


}